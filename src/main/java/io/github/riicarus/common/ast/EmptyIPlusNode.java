package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * I' -> eps
 *
 * @author Riicarus
 * @create 2023-12-17 18:03
 * @since 1.0.0
 */
public class EmptyIPlusNode extends IPlusNode {

    public static final ASTCreator<EmptyIPlusNode> CREATOR =
            children -> new EmptyIPlusNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode eps;

    public EmptyIPlusNode(TerminalASTNode eps) {
        this.eps = eps;
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
                .append(eps.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
