package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * VDorFDS -> V
 *
 * @author Riicarus
 * @create 2023-12-17 17:52
 * @since 1.0.0
 */
public class VDSuffixNode extends VDorFDSNode {

    public static final ASTCreator<VDSuffixNode> CREATOR =
            children -> new VDSuffixNode(
                    (VNode) children.get(0)
            );

    private final VNode v;

    public VDSuffixNode(VNode v) {
        this.v = v;
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
                .append(v.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
