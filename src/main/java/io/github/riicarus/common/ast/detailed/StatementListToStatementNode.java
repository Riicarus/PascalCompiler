package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.code.StatementNode;

/**
 * StatementList -> Statement StatementList
 *
 * @author Riicarus
 * @create 2023-12-21 9:20
 * @since 1.0.0
 */
public class StatementListToStatementNode extends StatementListNode {

    public static final DetailedASTCreator<StatementListToStatementNode> CREATOR =
            children -> new StatementListToStatementNode(
                    (DetailedStatementNode) children.get(0),
                    (StatementListNode) children.get(1)
            );

    private final DetailedStatementNode statement;
    private final StatementListNode statementList;

    public StatementListToStatementNode(DetailedStatementNode statement, StatementListNode statementList) {
        this.statement = statement;
        this.statementList = statementList;
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
                .append(statement.toTreeString(level + 1, prefix))
                .append(statementList.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public StatementNode toGeneric() {
        StatementNode statementNode = statement.toGeneric();
        StatementNode nextStatementNode = statementList.toGeneric();
        if (nextStatementNode != null) {
            statementNode.setNextStatementNode(nextStatementNode);
        }

        return statementNode;
    }
}
