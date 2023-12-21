package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * RelOp -> <
 *
 * @author Riicarus
 * @create 2023-12-21 11:13
 * @since 1.0.0
 */
public class RelOpToLTNode extends RelOpNode {

    public static final DetailedASTCreator<RelOpToLTNode> CREATOR =
            children -> new RelOpToLTNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode lt;

    public RelOpToLTNode(TerminalASTNode lt) {
        this.lt = lt;
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
                .append(lt.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
