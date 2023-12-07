package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AstType;
import io.github.riicarus.common.data.BasicAstType;

/**
 * 乘法表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-7 18:45
 * @since 1.0.0
 */
public class DoubleTimesOpExprAST extends ExprAST<Double> {
    protected final ExprAST<Double> left;
    protected final ExprAST<Double> right;

    public DoubleTimesOpExprAST(AstType type, ExprAST<Double> left, ExprAST<Double> right) {
        super(type);
        this.left = left;
        this.right = right;
    }

    public DoubleTimesOpExprAST(ExprAST<Double> left, ExprAST<Double> right) {
        super(BasicAstType.OP);
        this.left = left;
        this.right = right;
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

        sb.append(t).append(link).append("*(d)")
                .append(left.toTreeString(level + 1))
                .append(right.toTreeString(level + 1));

        return sb.toString();
    }
}
