package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * ES -> WS
 *
 * @author Riicarus
 * @create 2023-12-17 18:00
 * @since 1.0.0
 */
public class ESToWSNode extends ESNode {

    public static final ASTCreator<ESToWSNode> CREATOR =
            children -> new ESToWSNode(
                    (WSNode) children.get(0)
            );

    private final WSNode ws;

    public ESToWSNode(WSNode ws) {
        this.ws = ws;
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
                .append(ws.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
