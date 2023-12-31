package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Control -> Loop
 *
 * @author Riicarus
 * @create 2023-12-21 18:16
 * @since 1.0.0
 */
public class ControlToLoopNode extends ControlNode {

    public static final DetailedASTCreator<ControlToLoopNode> CREATOR =
            children -> new ControlToLoopNode(
                    (LoopNode) children.get(0)
            );

    private final LoopNode loop;

    public ControlToLoopNode(LoopNode loop) {
        this.loop = loop;
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
                .append(loop.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode toGeneric() {
        return loop.toGeneric();
    }
}
