package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * RelOp -> ==
 *
 * @author Riicarus
 * @create 2023-12-21 11:19
 * @since 1.0.0
 */
public class RelOpToEQNode extends RelOpNode {

    public static final DetailedASTCreator<RelOpToEQNode> CREATOR =
            children -> new RelOpToEQNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode eq;

    public RelOpToEQNode(TerminalASTNode eq) {
        this.eq = eq;
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
                .append(eq.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
