package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * ES -> RS
 *
 * @author Riicarus
 * @create 2023-12-17 18:00
 * @since 1.0.0
 */
public class ESToRSNode extends ESNode {

    public static final ASTCreator<ESToRSNode> CREATOR =
            children -> new ESToRSNode(
                    (RSNode) children.get(0)
            );

    private final RSNode rs;

    public ESToRSNode(RSNode rs) {
        this.rs = rs;
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
                .append(rs.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
