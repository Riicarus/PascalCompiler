package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AstType;
import io.github.riicarus.common.data.BasicAstType;

/**
 * 值类型表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-6 13:50
 * @since 1.0.0
 */
public class ValueExprAST<T> extends ExprAST<T> {

    // 值
    protected final T value;

    public ValueExprAST(T value) {
        super(BasicAstType.VALUE);
        this.value = value;
    }

    public ValueExprAST(AstType type, T value) {
        super(type);
        this.value = value;
    }

    @Override
    public String toString() {
        return toTreeString(0);
    }

    @Override
    public String toTreeString(int level) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(t).append(link).append(value);

        return sb.toString();
    }
}
