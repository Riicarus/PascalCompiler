package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;

/**
 * V -> Id
 *
 * @author Riicarus
 * @create 2023-12-17 17:55
 * @since 1.0.0
 */
public class VNode extends NonterminalASTNode {

    public static final ASTCreator<VNode> CREATOR =
            children -> new VNode(
                    (IdNode) children.get(0)
            );

    private final IdNode id;

    public VNode(IdNode id) {
        this.id = id;
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
                .append(id.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
