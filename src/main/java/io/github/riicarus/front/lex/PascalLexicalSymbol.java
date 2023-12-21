package io.github.riicarus.front.lex;

import io.github.riicarus.common.data.Token;
import io.github.riicarus.common.util.CharUtil;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类 Pascal 语言单词符号.
 *
 * <p>定义时需要将关键字放在标识符之前.</p>
 *
 * @author Riicarus
 * @create 2023-11-6 17:43
 * @since 1.0.0
 */
public enum PascalLexicalSymbol implements LexicalSymbol {

    // 关键字
    INTEGER("int", "int"),
    BOOLEAN("bool", "bool"),
    FLOAT("float", "float"),
    STRING("string", "string"),
    VOID("void", "void"),
    NULL("null", "null"),
    FUNC_TYPE("function", "function"),
    FUNC_DEF("func", "func"),
    CONTINUE("continue", "continue"),
    BREAK("break", "break"),
    RETURN("return", "return"),
    IF("if", "if"),
    ELSE("else", "else"),
    ELSE_IF("elseif", "elseif"),
    FOR("for", "for"),
    TRUE("true", "true"),
    FALSE("false", "false"),

    // 变量,
    IDENTIFIER("identifier", true, CharUtil.IDENTIFIER_REGEX),
    CONST_INT("constInt", true, CharUtil.NUMBER_REGEX),
    CONST_STRING("constString", true, CharUtil.STRING_REGEX),
    CONST_FLOAT("constFloat", true, CharUtil.FLOAT_REGEX),

    // 符号
    EQ("==", "=="),
    NE("!=", "!="),
    LE("<=", "<="),
    LT("<", "<"),
    GE(">=", ">="),
    GT(">", ">"),
    MINUS("-", "-"),
    PLUS("+", "+"),
    TIMES("*", "\\*"),
    DIVIDES("/", "/"),
    OR("|", "\\|"),
    AND("&", "&"),
    NOT("!", "!"),
    ASSIGN(":=", ":="),
    FUNC_ARG_TRANS("=>", "=>"),
    L_PAREN("(", "\\("),
    R_PAREN(")", "\\)"),
    L_BRACKET("[", "["),
    R_BRACKET("]", "]"),
    L_BRACE("{", "{"),
    R_BRACE("}", "}"),
    SEMICOLON(";", ";"),
    COLON(",", ","),
    EMPTY_SPACE(" ", "( )( )*"),
    EOL("EOL", "(\r)*\n"), EOF("EOF", String.valueOf((char) 26)),
    LEX_END(String.valueOf(CharUtil.LEX_SYNTAX_END), String.valueOf(CharUtil.LEX_SYNTAX_END));

    private final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private final String name;

    private final int code;

    private final boolean needPrintVal;

    private final DFA dfa;

    PascalLexicalSymbol(String name, boolean needPrintVal, String regex) {
        this.name = name;
        this.code = ID_GENERATOR.getAndIncrement();
        this.needPrintVal = needPrintVal;
        this.dfa = DFA.nfaToDfa(RegexParser.reToNFA(regex, CharUtil.PASCAL_CHAR_SET), CharUtil.PASCAL_CHAR_SET);
    }

    PascalLexicalSymbol(String name, String regex) {
        this.name = name;
        this.code = ID_GENERATOR.getAndIncrement();
        this.needPrintVal = false;
        this.dfa = DFA.nfaToDfa(RegexParser.reToNFA(regex, CharUtil.PASCAL_CHAR_SET), CharUtil.PASCAL_CHAR_SET);
    }

    @Override
    public Token validate(String s) {
        String value = dfa.validateString(s);

        if (value == null || value.length() == 0) return null;

        return new Token(this, value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public boolean needPrintVal() {
        return needPrintVal;
    }

    @Override
    public DFA getDfa() {
        return dfa;
    }

    public static void avoidLazyLoad() {
    }

    public static Set<LexicalSymbol> assistantLexSymbols() {
        return Set.of(EMPTY_SPACE, EOL, EOF);
    }
}
