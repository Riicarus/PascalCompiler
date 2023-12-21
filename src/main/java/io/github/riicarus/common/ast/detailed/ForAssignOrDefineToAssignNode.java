package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ForAssignOrDefine -> Id AssignSuf
 *
 * @author Riicarus
 * @create 2023-12-21 19:01
 * @since 1.0.0
 */
public class ForAssignOrDefineToAssignNode extends ForAssignOrDefineNode {

    public static final DetailedASTCreator<ForAssignOrDefineToAssignNode> CREATOR =
            children -> new ForAssignOrDefineToAssignNode(
                    (IdNode) children.get(0),
                    (AssignSufNode) children.get(1)
            );

    private final IdNode id;
    private final AssignSufNode assignSuf;

    public ForAssignOrDefineToAssignNode(IdNode id, AssignSufNode assignSuf) {
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
                .append(id.toTreeString(level + 1, prefix))
                .append(assignSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
