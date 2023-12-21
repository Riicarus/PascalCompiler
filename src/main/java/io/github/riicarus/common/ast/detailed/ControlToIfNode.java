package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Control -> If
 *
 * @author Riicarus
 * @create 2023-12-21 18:14
 * @since 1.0.0
 */
public class ControlToIfNode extends ControlNode {

    public static final DetailedASTCreator<ControlToIfNode> CREATOR =
            children -> new ControlToIfNode(
                    (IfNode) children.get(0)
            );

    private final IfNode _if;

    public ControlToIfNode(IfNode _if) {
        this._if = _if;
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
                .append(_if.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
