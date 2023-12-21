package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * AssignOrFuncCall -> Id AssignOrFuncCallSuf
 *
 * @author Riicarus
 * @create 2023-12-21 9:33
 * @since 1.0.0
 */
public class AssignOrFuncCallNode extends NonterminalASTNode {

    public static final DetailedASTCreator<AssignOrFuncCallNode> CREATOR =
            children -> new AssignOrFuncCallNode(
                    (IdNode) children.get(0),
                    (AssignOrFuncCallSufNode) children.get(1)
            );

    private final IdNode id;
    private final AssignOrFuncCallSufNode assignOrFuncCallSuf;

    public AssignOrFuncCallNode(IdNode id, AssignOrFuncCallSufNode assignOrFuncCallSuf) {
        this.id = id;
        this.assignOrFuncCallSuf = assignOrFuncCallSuf;
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
                .append(assignOrFuncCallSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
