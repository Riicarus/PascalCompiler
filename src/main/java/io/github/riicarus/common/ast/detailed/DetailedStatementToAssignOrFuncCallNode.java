package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.code.StatementNode;

/**
 * Statement -> AssignOrFuncCall
 *
 * @author Riicarus
 * @create 2023-12-21 9:29
 * @since 1.0.0
 */
public class DetailedStatementToAssignOrFuncCallNode extends DetailedStatementNode {

    public static final DetailedASTCreator<DetailedStatementToAssignOrFuncCallNode> CREATOR =
            children -> new DetailedStatementToAssignOrFuncCallNode(
                    (AssignOrFuncCallNode) children.get(0)
            );

    private final AssignOrFuncCallNode assignOrFuncCall;

    public DetailedStatementToAssignOrFuncCallNode(AssignOrFuncCallNode assignOrFuncCall) {
        this.assignOrFuncCall = assignOrFuncCall;
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
                .append(assignOrFuncCall.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public StatementNode toGeneric() {
        StatementNode statementNode = new StatementNode();
        statementNode.setCurNode(assignOrFuncCall.toGeneric());
        return statementNode;
    }
}
