package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForConditionNode;

/**
 * ForCondition -> ValueExpr
 *
 * @author Riicarus
 * @create 2023-12-21 19:05
 * @since 1.0.0
 */
public class DetailedForConditionToValueExprNode extends DetailedForConditionNode {

    public static final DetailedASTCreator<DetailedForConditionToValueExprNode> CREATOR =
            children -> new DetailedForConditionToValueExprNode(
                    (ValueExprNode) children.get(0)
            );

    private final ValueExprNode valueExpr;

    public DetailedForConditionToValueExprNode(ValueExprNode valueExpr) {
        this.valueExpr = valueExpr;
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
                .append(valueExpr.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ForConditionNode toGeneric() {
        return new ForConditionNode(valueExpr.toGeneric());
    }
}
