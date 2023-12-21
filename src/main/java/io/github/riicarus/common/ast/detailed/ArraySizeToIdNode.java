package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ArraySize -> Id
 *
 * @author Riicarus
 * @create 2023-12-21 10:34
 * @since 1.0.0
 */
public class ArraySizeToIdNode extends ArraySizeNode {

    public static final DetailedASTCreator<ArraySizeToIdNode> CREATOR =
            children -> new ArraySizeToIdNode(
                    (IdNode) children.get(0)
            );

    private final IdNode id;

    public ArraySizeToIdNode(IdNode id) {
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

        sb.append(prefix).append(t).append(link).append(symbol)
                .append(id.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
