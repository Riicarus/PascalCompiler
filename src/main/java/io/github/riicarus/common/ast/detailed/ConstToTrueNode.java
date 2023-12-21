package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Const -> true
 *
 * @author Riicarus
 * @create 2023-12-21 11:54
 * @since 1.0.0
 */
public class ConstToTrueNode extends ConstNode {

    public static final DetailedASTCreator<ConstToTrueNode> CREATOR =
            children -> new ConstToTrueNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode _true;

    public ConstToTrueNode(TerminalASTNode _true) {
        this._true = _true;
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
                .append(_true.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
