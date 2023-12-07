import io.github.riicarus.common.data.Token;
import io.github.riicarus.front.lex.*;
import org.junit.Test;

/**
 * @author Riicarus
 * @create 2023-12-7 13:04
 * @since 1.0.0
 */
public class LexTest {

    @Test
    public void testValidateString() {
        String regex = "(0|1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*";
        NFA nfa = RegexParser.reToNFA(regex);
        DFA numberDfa = DFA.nfaToDfa(nfa, null).minimize();
        System.out.println(numberDfa.validateString("123c4"));

        Token target = null;
        for (PascalLexicalSymbol symbol : PascalLexicalSymbol.values()) {
            final Token token = symbol.validate("\r\n");

            if (token == null) continue;

            if (target == null) target = token;
            else if (target.getLen() < token.getLen()) target = token;
        }

        System.out.println(target);
    }

    @Test
    public void testAnalyze() {
        PascalLexer pascalLexer = new PascalLexer();
        long time = System.currentTimeMillis();
        System.out.println(pascalLexer.parse("begin := F - * read(123) \r\n abc \n 123 \n end".toCharArray()));
        System.out.println(System.currentTimeMillis() - time);
    }

}
