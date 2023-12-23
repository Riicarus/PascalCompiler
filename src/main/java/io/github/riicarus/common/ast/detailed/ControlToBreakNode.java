package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.BreakNode;

/**
 * Control -> Break;
 *
 * @author Riicarus
 * @create 2023-12-21 18:03
 * @since 1.0.0
 */
public class ControlToBreakNode extends ControlNode {

    public static final DetailedASTCreator<ControlToBreakNode> CREATOR =
            children -> new ControlToBreakNode(
                    (DetailedBreakNode) children.get(0),
                    (TerminalASTNode) children.get(1)
            );

    private final DetailedBreakNode _break;
    private final TerminalASTNode semicolon;

    public ControlToBreakNode(DetailedBreakNode _break, TerminalASTNode semicolon) {
        this._break = _break;
        this.semicolon = semicolon;
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
                .append(_break.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public BreakNode toGeneric() {
        return _break.toGeneric();
    }
}
