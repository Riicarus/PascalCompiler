package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.relation.NENode;

/**
 * RelOp -> !=
 *
 * @author Riicarus
 * @create 2023-12-21 11:20
 * @since 1.0.0
 */
public class RelOpToNENode extends RelOpNode {

    public static final DetailedASTCreator<RelOpToNENode> CREATOR =
            children -> new RelOpToNENode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode ne;

    public RelOpToNENode(TerminalASTNode ne) {
        this.ne = ne;
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
                .append(ne.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public NENode toGeneric() {
        return new NENode();
    }
}
