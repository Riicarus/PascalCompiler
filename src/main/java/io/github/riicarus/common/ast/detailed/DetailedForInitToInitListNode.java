package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForInitNode;

/**
 * ForInit -> ForInitList
 *
 * @author Riicarus
 * @create 2023-12-21 18:46
 * @since 1.0.0
 */
public class DetailedForInitToInitListNode extends DetailedForInitNode {

    public static final DetailedASTCreator<DetailedForInitToInitListNode> CREATOR =
            children -> new DetailedForInitToInitListNode(
                    (ForInitListNode) children.get(0)
            );

    private final ForInitListNode forInitList;

    public DetailedForInitToInitListNode(ForInitListNode forInitList) {
        this.forInitList = forInitList;
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
                .append(forInitList.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ForInitNode toGeneric() {
        return forInitList.toGeneric();
    }
}
