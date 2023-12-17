package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * RO -> <
 *
 * @author Riicarus
 * @create 2023-12-17 18:08
 * @since 1.0.0
 */
public class LTNode extends RONode {

    public static final ASTCreator<LTNode> CREATOR =
            children -> new LTNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode lt;

    public LTNode(TerminalASTNode lt) {
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

        sb.append(prefix).append(t).append(link).append(symbol == null ? "" : symbol)
                .append(lt.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
