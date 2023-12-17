package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * F -> C
 *
 * @author Riicarus
 * @create 2023-12-17 18:04
 * @since 1.0.0
 */
public class FToCNode extends FNode {

    public static final ASTCreator<FToCNode> CREATOR =
            children -> new FToCNode(
                    (CNode) children.get(0)
            );

    private final CNode c;

    public FToCNode(CNode c) {
        this.c = c;
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
                .append(c.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
