package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;

/**
 * VarInit -> AssignSuf;
 *
 * @author Riicarus
 * @create 2023-12-21 9:55
 * @since 1.0.0
 */
public class VarInitToAssignSufNode extends VarInitNode {

    public static final DetailedASTCreator<VarInitToAssignSufNode> CREATOR =
            children -> new VarInitToAssignSufNode(
                    (AssignSufNode) children.get(0),
                    (TerminalASTNode) children.get(1)
            );

    private final AssignSufNode assignSuf;
    private final TerminalASTNode semicolon;

    public VarInitToAssignSufNode(AssignSufNode assignSuf, TerminalASTNode semicolon) {
        this.assignSuf = assignSuf;
        this.semicolon = semicolon;
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
                .append(assignSuf.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public AssignNode toGeneric() {
        return assignSuf.toGeneric();
    }
}
