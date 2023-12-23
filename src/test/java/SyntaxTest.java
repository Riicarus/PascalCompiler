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
                {
                  int k;
                  int k;
                  void function(string) function(bool) Max := (bool b) => {
                      if (b) {
                          return 1;
                      } else {
                          return 0;
                      }
                  };
                  int function(int) func F(int n) {
                      int n;
                      if (n <= 0) {
                          F := 1;
                          continue;
                      } elseif (n == 1) {
                          F := 10;
                          return F;
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
        System.out.println(tokenList);
        final SyntaxParseResult result = PascalSyntax.SYNTAXER.parse(tokenList, lexer.getAssistantLexSymbolSet());

        System.out.println();
        System.out.println("Syntax Parse Result:");
        System.out.println(result.print("\t"));
    }

}
