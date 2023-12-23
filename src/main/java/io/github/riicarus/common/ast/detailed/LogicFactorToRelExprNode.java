package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * LogicFactor -> RelExpr
 *
 * @author Riicarus
 * @create 2023-12-21 11:07
 * @since 1.0.0
 */
public class LogicFactorToRelExprNode extends LogicFactorNode {

    public static final DetailedASTCreator<LogicFactorToRelExprNode> CREATOR =
            children -> new LogicFactorToRelExprNode(
                    (RelExprNode) children.get(0)
            );

    private final RelExprNode relExpr;

    public LogicFactorToRelExprNode(RelExprNode relExpr) {
        this.relExpr = relExpr;
    }

    @Override
    public String toTreeString(int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(prefix).append(t).append(link).append(symbol)
                .append(relExpr.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ExprNode toGeneric() {
        return relExpr.toGeneric();
    }
}
