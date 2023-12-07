package io.github.riicarus.common.ast.expr;

import io.github.riicarus.common.data.AstType;
import io.github.riicarus.common.data.BasicAstType;

/**
 * 减法表达式 AST
 *
 * @author Riicarus
 * @create 2023-12-7 18:52
 * @since 1.0.0
 */
public class DoubleMinusOpExprAST extends ExprAST<Double> {

    protected final ExprAST<Double> left;
    protected final ExprAST<Double> right;

    public DoubleMinusOpExprAST(AstType type, ExprAST<Double> left, ExprAST<Double> right) {
        super(type);
        this.left = left;
        this.right = right;
    }

    public DoubleMinusOpExprAST(ExprAST<Double> left, ExprAST<Double> right) {
        super(BasicAstType.OP);
        this.left = left;
        this.right = right;
    }

    @Override
    public Double execute() {
        return left.execute() - right.execute();
    }

    @Override
    public String toTreeString(int level) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(t).append(link).append("-(d)")
                .append(left.toTreeString(level + 1))
                .append(right.toTreeString(level + 1));

        return sb.toString();
    }

    @Override
    public String toString() {
        return toTreeString(0);
    }
}