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

    static {
        long time = System.currentTimeMillis();
        System.out.println();
        System.out.println("Syntax loading...");
        PascalSyntax.avoidLazyLoad();
        System.out.println("Syntax loaded, time used: " + (System.currentTimeMillis() - time) + " ms.");
    }

    @Test
    public void testLL1SyntaxInlineDefinerParse() {
        String s = """
                {
                    {
                        int count;
                        string name;
                    }
                    
                    int k;
                    int k;
                    void function(string) function(bool) Max := void function(string) (bool b) => {
                        if (b) {
                            return 1;
                        } else {
                            return 0;
                        }
                    };
                    int function(float) function(int, bool, string) func F(int function(bool) n) {
                        int n;
                        if (n <= 0) {
                            string name;
                            F := 1;
                            continue;
                        } elseif (n == 1) {
                            string name;
                            F := 10;
                            return F;
                        } elseif (n == 3) {
                            float f := 10;
                        } else {
                            F := n * F(n - 1);
                            return 1;
                        }
                    }
                    for (int i := 0, k := 9; i < 10; i := i + 1) {
                        k := i;
                        break;
                        continue;
                        return k;
                        return;
                        return 1;
                    }
                    read(m);
                    k:=F(m);
                    write(k);
                    
                    int j := i * k - n * j / p;
                }
                """;

        final List<Token> tokenList = lexer.parse(s.toCharArray());

        long time = System.currentTimeMillis();
        final SyntaxParseResult result = PascalSyntax.SYNTAXER.parse(tokenList, lexer.getAssistantLexSymbolSet());

        System.out.println();
        System.out.println("Syntax Parse Result:");
        System.out.println(result.print("\t"));
    }

}
