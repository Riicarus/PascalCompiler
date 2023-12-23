package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;
import io.github.riicarus.common.data.ast.generic.expr.v.VariableNode;

/**
 * VarDef -> Id VarInit
 *
 * @author Riicarus
 * @create 2023-12-21 9:53
 * @since 1.0.0
 */
public class VarDefToCommonVarNode extends VarDefNode {

    public static final DetailedASTCreator<VarDefToCommonVarNode> CREATOR =
            children -> new VarDefToCommonVarNode(
                    (DetailedIdNode) children.get(0),
                    (VarInitNode) children.get(1)
            );

    private final DetailedIdNode id;
    private final VarInitNode varInit;

    public VarDefToCommonVarNode(DetailedIdNode id, VarInitNode varInit) {
        this.id = id;
        this.varInit = varInit;
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
                .append(id.toTreeString(level + 1, prefix))
                .append(varInit.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ExprNode toGeneric() {
        VariableNode varNode = id.toGeneric();

        AssignNode assignNode = varInit.toGeneric();
        if (assignNode == null) {
            return varNode;
        }

        assignNode.setLeftOperand(id.toGeneric());
        return assignNode;
    }
}
