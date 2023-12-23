package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ContinueNode;

/**
 * Control -> Continue;
 *
 * @author Riicarus
 * @create 2023-12-21 18:10
 * @since 1.0.0
 */
public class ControlToContinueNode extends ControlNode {

    public static final DetailedASTCreator<ControlToContinueNode> CREATOR =
            children -> new ControlToContinueNode(
                    (DetailedContinueNode) children.get(0),
                    (TerminalASTNode) children.get(1)
            );

    private final DetailedContinueNode _continue;
    private final TerminalASTNode semicolon;

    public ControlToContinueNode(DetailedContinueNode _continue, TerminalASTNode semicolon) {
        this._continue = _continue;
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
                .append(_continue.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ContinueNode toGeneric() {
        return _continue.toGeneric();
    }
}
