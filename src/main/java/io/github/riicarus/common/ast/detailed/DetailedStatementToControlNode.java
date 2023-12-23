package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.code.StatementNode;

/**
 * Statement -> Control
 *
 * @author Riicarus
 * @create 2023-12-21 9:30
 * @since 1.0.0
 */
public class DetailedStatementToControlNode extends DetailedStatementNode {

    public static final DetailedASTCreator<DetailedStatementToControlNode> CREATOR =
            children -> new DetailedStatementToControlNode(
                    (ControlNode) children.get(0)
            );

    private final ControlNode control;

    public DetailedStatementToControlNode(ControlNode control) {
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
    public StatementNode toGeneric() {
        StatementNode statementNode = new StatementNode();
        statementNode.setCurNode(control.toGeneric());
        return statementNode;
    }
}
