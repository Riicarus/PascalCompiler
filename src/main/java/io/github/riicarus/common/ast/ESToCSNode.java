package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * ES -> CS
 *
 * @author Riicarus
 * @create 2023-12-17 18:01
 * @since 1.0.0
 */
public class ESToCSNode extends ESNode {

    public static final ASTCreator<ESToCSNode> CREATOR =
            children -> new ESToCSNode(
                    (CSNode) children.get(0)
            );

    private final CSNode cs;

    public ESToCSNode(CSNode cs) {
        this.cs = cs;
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
                .append(cs.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
