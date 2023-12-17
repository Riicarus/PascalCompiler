package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * RO -> <>
 *
 * @author Riicarus
 * @create 2023-12-17 18:09
 * @since 1.0.0
 */
public class NENode extends RONode {

    public static final ASTCreator<NENode> CREATOR =
            children -> new NENode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode ne;

    public NENode(TerminalASTNode ne) {
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

        sb.append(prefix).append(t).append(link).append(symbol == null ? "" : symbol)
                .append(ne.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
