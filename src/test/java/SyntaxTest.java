import io.github.riicarus.common.ast.expr.DoubleMinusOpExprAST;
import io.github.riicarus.common.ast.expr.DoubleTimesOpExprAST;
import io.github.riicarus.common.ast.expr.ExprAST;
import io.github.riicarus.common.ast.expr.ValueExprAST;
import io.github.riicarus.common.data.AstConstructStrategy;
import io.github.riicarus.common.data.AstConstructor;
import io.github.riicarus.common.data.SyntaxParseResult;
import io.github.riicarus.front.lex.Lexer;
import io.github.riicarus.front.lex.PascalLexer;
import io.github.riicarus.front.syntax.SyntaxSymbol;
import io.github.riicarus.front.syntax.SyntaxSymbolType;
import io.github.riicarus.front.syntax.Syntaxer;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxInlineDefiner;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxSymbol;
import io.github.riicarus.front.syntax.ll1.LL1Syntaxer;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Riicarus
 * @create 2023-12-7 13:06
 * @since 1.0.0
 */
public class SyntaxTest {

    SyntaxSymbol<String> eps = new LL1SyntaxSymbol<>("eps", true, SyntaxSymbolType.ASST);
    AstConstructor<String> epsConstructor = (lexeme, astStack, opSymbolStack) -> null;
    SyntaxSymbol<Double> times = new LL1SyntaxSymbol<>("*", true, SyntaxSymbolType.OP);
    @SuppressWarnings("unchecked")  // caught exception
    AstConstructor<Double> timesConstructor = (lexeme, astStack, opSymbolStack) -> {
        if (astStack.size() < 2)
            throw new IllegalStateException("LL1Syntax wrong: construct times ast failed: ast stack size is less than 2.");

        ExprAST<Double> right, left;
        try {
            right = (ExprAST<Double>) astStack.pop();
            left = (ExprAST<Double>) astStack.pop();
        } catch (ClassCastException e) {
            throw new IllegalStateException("LL1Syntax wrong: construct times ast failed: ast type is not double.");
        }

        return new DoubleTimesOpExprAST(left, right);
    };

    SyntaxSymbol<Double> minus = new LL1SyntaxSymbol<>("-", true, SyntaxSymbolType.OP);
    @SuppressWarnings("unchecked")  // caught exception
    AstConstructor<Double> minusConstructor = (lexeme, astStack, opSymbolStack) -> {
        if (astStack.size() < 2)
            throw new IllegalStateException("LL1Syntax wrong: construct minus ast failed: ast stack size is less than 2.");

        ExprAST<Double> right, left;
        try {
            right = (ExprAST<Double>) astStack.pop();
            left = (ExprAST<Double>) astStack.pop();
        } catch (ClassCastException e) {
            throw new IllegalStateException("LL1Syntax wrong: construct minus ast failed: ast type is not double.");
        }

        return new DoubleMinusOpExprAST(left, right);
    };
    SyntaxSymbol<Double> constant = new LL1SyntaxSymbol<>("constant", true, SyntaxSymbolType.VAL);
    AstConstructor<Double> constantConstructor = (lexeme, astStack, opSymbolStack) -> new ValueExprAST<>(Double.parseDouble(lexeme));

    SyntaxSymbol<?> E = new LL1SyntaxSymbol<>("E", false, SyntaxSymbolType.EXPR);
    SyntaxSymbol<?> EP = new LL1SyntaxSymbol<>("E'", false, SyntaxSymbolType.EXPR);
    SyntaxSymbol<?> T = new LL1SyntaxSymbol<>("T", false, SyntaxSymbolType.EXPR);
    SyntaxSymbol<?> TP = new LL1SyntaxSymbol<>("T'", false, SyntaxSymbolType.EXPR);
    SyntaxSymbol<?> F = new LL1SyntaxSymbol<>("F", false, SyntaxSymbolType.EXPR);

    Map<SyntaxSymbol<?>, Integer> opPrecedenceMap = Map.of(
            times, 10,
            minus, 1
    );
    AstConstructStrategy strategy = new AstConstructStrategy();

    LL1SyntaxInlineDefiner definer = new LL1SyntaxInlineDefiner(eps, E, strategy);
    // LL1SyntaxInlineDefiner definer = new LL1SyntaxInlineDefiner(eps, E, opPrecedenceMap, strategy);

    Lexer lexer = new PascalLexer();
    Syntaxer pascalSyntaxer;


    private void init() {
        definer.addSymbols(Set.of(eps, times, minus, constant));
        definer.addSymbols(Set.of(E, EP, T, TP, F));

        definer.addProduction("E", List.of("T", "E'"));
        definer.addProduction("E'", List.of("-", "T", "E'"));
        definer.addProduction("E'", List.of("eps"));
        definer.addProduction("T", List.of("F", "T'"));
        definer.addProduction("T'", List.of("*", "F", "T'"));
        definer.addProduction("T'", List.of("eps"));
        definer.addProduction("F", List.of("constant"));


        strategy.add(eps, epsConstructor);
        strategy.add(times, timesConstructor);
        strategy.add(minus, minusConstructor);
        strategy.add(constant, constantConstructor);

        pascalSyntaxer = new LL1Syntaxer(definer);
    }

    @Test
    public void testLL1SyntaxInlineDefinerParse() {
        init();
        final SyntaxParseResult result = pascalSyntaxer.parse(lexer.parse("3 - 4 * 5 - 7 * 8 - 0 ".toCharArray()), lexer.getAssistantLexSymbolSet(), strategy);
        System.out.println(result.getAst().execute());
    }

}
