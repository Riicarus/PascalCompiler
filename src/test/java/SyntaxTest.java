import io.github.riicarus.common.data.SyntaxParseResult;
import io.github.riicarus.common.data.Token;
import io.github.riicarus.front.lex.PascalLexer;
import io.github.riicarus.front.syntax.PascalSyntax;
import org.junit.Test;

import java.util.List;

/**
 * @author Riicarus
 * @create 2023-12-16 0:57
 * @since 1.0.0
 */
public class SyntaxTest {

    static PascalLexer lexer = new PascalLexer();

    @Test
    public void testLL1SyntaxInlineDefinerParse() {
        String s = """
                begin
                  integer k;
                  integer k;
                  integer function F(n);
                    begin
                      integer n;
                      if n<=0 then F:=1
                      else F:=n*F(n-1);
                    end;
                  read(m);
                  k:=F(m);
                  write(k);
                end
                """;

        final List<Token> tokenList = lexer.parse(s.toCharArray());
        System.out.println(tokenList);
        final SyntaxParseResult result = PascalSyntax.SYNTAXER.parse(tokenList, lexer.getAssistantLexSymbolSet());

        System.out.println();
        System.out.println("Syntax Parse Result:");
        System.out.println(result.print("\t"));
    }

}
