package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;

/**
 * AssignSuf -> := ValueExpr
 *
 * @author Riicarus
 * @create 2023-12-21 9:43
 * @since 1.0.0
 */
public class AssignSufNode extends NonterminalASTNode {

    public static final DetailedASTCreator<AssignSufNode> CREATOR =
            children -> new AssignSufNode(
                    (TerminalASTNode) children.get(0),
                    (ValueExprNode) children.get(1)
            );

    private final TerminalASTNode assign;
    private final ValueExprNode valueExpr;

    public AssignSufNode(TerminalASTNode assign, ValueExprNode valueExpr) {
        this.assign = assign;
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
                .append(assign.toTreeString(level + 1, prefix))
                .append(valueExpr.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public AssignNode toGeneric() {
        AssignNode assignNode = new AssignNode();
        assignNode.setRightOperand(valueExpr.toGeneric());
        return assignNode;
    }
}
