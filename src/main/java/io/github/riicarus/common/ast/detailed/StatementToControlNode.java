package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Statement -> Control
 *
 * @author Riicarus
 * @create 2023-12-21 9:30
 * @since 1.0.0
 */
public class StatementToControlNode extends StatementNode {

    public static final DetailedASTCreator<StatementToControlNode> CREATOR =
            children -> new StatementToControlNode(
                    (ControlNode) children.get(0)
            );

    private final ControlNode control;

    public StatementToControlNode(ControlNode control) {
        this.control = control;
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
                .append(control.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
