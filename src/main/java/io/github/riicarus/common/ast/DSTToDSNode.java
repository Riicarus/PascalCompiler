package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * DST -> DS; DST
 *
 * @author Riicarus
 * @create 2023-12-17 17:47
 * @since 1.0.0
 */
public class DSTToDSNode extends DSTNode {

    public static final ASTCreator<DSTToDSNode> CREATOR =
            children -> new DSTToDSNode(
                    (DSNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (DSTNode) children.get(2)
            );

    private final DSNode ds;
    private final TerminalASTNode semicolon;
    private final DSTNode dst;

    public DSTToDSNode(DSNode ds, TerminalASTNode semicolon, DSTNode dst) {
        this.ds = ds;
        this.semicolon = semicolon;
        this.dst = dst;
    }

    @Override
    public String toTreeString(int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(prefix).append(t).append(link).append(symbol == null ? "" : symbol)
                .append(ds.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix))
                .append(dst.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
