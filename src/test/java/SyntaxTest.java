import io.github.riicarus.front.lex.Lexer;
import io.github.riicarus.front.lex.PascalLexer;
import io.github.riicarus.front.syntax.SyntaxSymbol;
import io.github.riicarus.front.syntax.SyntaxSymbolType;
import io.github.riicarus.front.syntax.Syntaxer;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxFileDefiner;
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

    @Test
    public void testLL1SyntaxParse() {
        Syntaxer syntaxer = new LL1Syntaxer(new LL1SyntaxFileDefiner("D:/tmp/compiler/program.syn"));
        Lexer lexer = new PascalLexer();
        syntaxer.parse(lexer.parse("3 - 4 * 5 - 7 * 8 - 0 ".toCharArray()), lexer.getAssistantLexSymbolSet());
    }

    @Test
    public void testLL1SyntaxInlineDefinerParse() {
        SyntaxSymbol startSymbol = new LL1SyntaxSymbol("E", false, SyntaxSymbolType.EXPR);
        LL1SyntaxSymbol epsSymbol = new LL1SyntaxSymbol("eps", true, SyntaxSymbolType.ASST);
        final LL1SyntaxInlineDefiner definer = new LL1SyntaxInlineDefiner(epsSymbol, startSymbol);

        definer.addTerminalSymbols(Map.of(
                "eps", epsSymbol.getType(),
                "*", SyntaxSymbolType.OP,
                "-", SyntaxSymbolType.OP,
                "constant", SyntaxSymbolType.VALUE));
        definer.addNonterminalSymbols(Set.of("E", "E'", "T", "T'", "F"));

        definer.addProduction("E", List.of("T", "E'"));
        definer.addProduction("E'", List.of("-", "T", "E'"));
        definer.addProduction("E'", List.of("eps"));
        definer.addProduction("T", List.of("F", "T'"));
        definer.addProduction("T'", List.of("*", "F", "T'"));
        definer.addProduction("T'", List.of("eps"));
        definer.addProduction("F", List.of("constant"));

        Syntaxer pascalSyntaxer = new LL1Syntaxer(definer);

        Lexer lexer = new PascalLexer();
        pascalSyntaxer.parse(lexer.parse("3 - 4 * 5 - 7 * 8 - 0 ".toCharArray()), lexer.getAssistantLexSymbolSet());
    }

}
