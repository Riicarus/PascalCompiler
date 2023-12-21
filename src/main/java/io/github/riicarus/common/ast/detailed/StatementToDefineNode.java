package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Statement -> Define
 *
 * @author Riicarus
 * @create 2023-12-21 9:29
 * @since 1.0.0
 */
public class StatementToDefineNode extends StatementNode {

    public static final DetailedASTCreator<StatementToDefineNode> CREATOR =
            children -> new StatementToDefineNode(
                    (DefineNode) children.get(0)
            );

    private final DefineNode define;

    public StatementToDefineNode(DefineNode define) {
        this.define = define;
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
                .append(define.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
