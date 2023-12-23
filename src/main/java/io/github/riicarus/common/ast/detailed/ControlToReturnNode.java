package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ReturnNode;

/**
 * Control -> Return;
 *
 * @author Riicarus
 * @create 2023-12-21 18:13
 * @since 1.0.0
 */
public class ControlToReturnNode extends ControlNode {

    public static final DetailedASTCreator<ControlToReturnNode> CREATOR =
            children -> new ControlToReturnNode(
                    (DetailedReturnNode) children.get(0),
                    (TerminalASTNode) children.get(1)
            );

    private final DetailedReturnNode _return;
    private final TerminalASTNode semicolon;

    public ControlToReturnNode(DetailedReturnNode _return, TerminalASTNode semicolon) {
        this._return = _return;
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
                .append(_return.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ReturnNode toGeneric() {
        return _return.toGeneric();
    }
}
