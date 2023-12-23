package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForInitNode;

/**
 * ForInitListSuf -> eps
 *
 * @author Riicarus
 * @create 2023-12-21 19:00
 * @since 1.0.0
 */
public class ForInitListSufEmptyNode extends ForInitListSufNode {

    public static final DetailedASTCreator<ForInitListSufEmptyNode> CREATOR =
            children -> new ForInitListSufEmptyNode();

    @Override
    public String toTreeString(int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(prefix).append(t).append(link).append(symbol);

        return sb.toString();
    }

    @Override
    public ForInitNode toGeneric() {
        return null;
    }
}
