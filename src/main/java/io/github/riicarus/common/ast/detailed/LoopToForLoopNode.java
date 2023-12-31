package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForNode;

/**
 * Loop -> ForLoop
 *
 * @author Riicarus
 * @create 2023-12-21 18:08
 * @since 1.0.0
 */
public class LoopToForLoopNode extends LoopNode {

    public static final DetailedASTCreator<LoopToForLoopNode> CREATOR =
            children -> new LoopToForLoopNode(
                    (ForLoopNode) children.get(0)
            );

    private final ForLoopNode forLoop;

    public LoopToForLoopNode(ForLoopNode forLoop) {
        this.forLoop = forLoop;
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
                .append(forLoop.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ForNode toGeneric() {
        return forLoop.toGeneric();
    }
}
