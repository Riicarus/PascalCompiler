package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForUpdateNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;

/**
 * ForUpdateList -> Id AssignSuf ForUpdateListSuf
 *
 * @author Riicarus
 * @create 2023-12-21 19:07
 * @since 1.0.0
 */
public class ForUpdateListNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ForUpdateListNode> CREATOR =
            children -> new ForUpdateListNode(
                    (DetailedIdNode) children.get(0),
                    (AssignSufNode) children.get(1),
                    (ForUpdateListSufNode) children.get(2)
            );

    private final DetailedIdNode id;
    private final AssignSufNode assignSuf;
    private final ForUpdateListSufNode forUpdateListSuf;

    public ForUpdateListNode(DetailedIdNode id, AssignSufNode assignSuf, ForUpdateListSufNode forUpdateListSuf) {
        this.id = id;
        this.assignSuf = assignSuf;
        this.forUpdateListSuf = forUpdateListSuf;
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
                .append(assignSuf.toTreeString(level + 1, prefix))
                .append(forUpdateListSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ForUpdateNode toGeneric() {
        AssignNode assignNode = assignSuf.toGeneric();
        assignNode.setLeftOperand(id.toGeneric());

        ForUpdateNode forUpdateNode = forUpdateListSuf.toGeneric();
        if (forUpdateNode == null) {
            forUpdateNode = new ForUpdateNode();
        }

        forUpdateNode.addUpdate(assignNode);
        return forUpdateNode;
    }
}
