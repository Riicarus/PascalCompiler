package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * ES -> AS
 *
 * @author Riicarus
 * @create 2023-12-17 18:00
 * @since 1.0.0
 */
public class ESToASNode extends ESNode {

    public static final ASTCreator<ESToASNode> CREATOR =
            children -> new ESToASNode(
                    (ASNode) children.get(0)
            );

    private final ASNode as;

    public ESToASNode(ASNode as) {
        this.as = as;
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
                .append(as.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
