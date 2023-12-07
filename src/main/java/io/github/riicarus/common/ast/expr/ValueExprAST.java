package io.github.riicarus.common.ast.expr;

/**
 * 值类型表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-6 13:50
 * @since 1.0.0
 */
public class ValueExprAST extends ExprAST<String> {

    // 值
    protected String value;

    public ValueExprAST(String value) {
        this.value = value;
    }

    @Override
    public String compute() {
        return value;
    }
}
