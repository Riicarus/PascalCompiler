package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;

/**
 * ForAssignOrDefine -> Type Id AssignSuf
 *
 * @author Riicarus
 * @create 2023-12-21 19:02
 * @since 1.0.0
 */
public class ForAssignOrDefineToDefineNode extends ForAssignOrDefineNode {

    public static final DetailedASTCreator<ForAssignOrDefineToDefineNode> CREATOR =
            children -> new ForAssignOrDefineToDefineNode(
                    (DetailedTypeNode) children.get(0),
                    (DetailedIdNode) children.get(1),
                    (AssignSufNode) children.get(2)
            );

    private final DetailedTypeNode type;
    private final DetailedIdNode id;
    private final AssignSufNode assignSuf;

    public ForAssignOrDefineToDefineNode(DetailedTypeNode type, DetailedIdNode id, AssignSufNode assignSuf) {
        this.type = type;
        this.id = id;
        this.assignSuf = assignSuf;
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
                .append(type.toTreeString(level + 1, prefix))
                .append(id.toTreeString(level + 1, prefix))
                .append(assignSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public AssignNode toGeneric() {
        AssignNode assignNode = assignSuf.toGeneric();
        assignNode.setLeftOperand(id.toGeneric());
        assignNode.getLeftOperand().setTypeNode(type.toGeneric());

        return assignNode;
    }
}
