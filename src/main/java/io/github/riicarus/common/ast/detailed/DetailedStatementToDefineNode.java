package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.code.StatementNode;

/**
 * Statement -> Define
 *
 * @author Riicarus
 * @create 2023-12-21 9:29
 * @since 1.0.0
 */
public class DetailedStatementToDefineNode extends DetailedStatementNode {

    public static final DetailedASTCreator<DetailedStatementToDefineNode> CREATOR =
            children -> new DetailedStatementToDefineNode(
                    (DefineNode) children.get(0)
            );

    private final DefineNode define;

    public DetailedStatementToDefineNode(DefineNode define) {
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
                .append(define == null ? "" : define.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public StatementNode toGeneric() {
        StatementNode statementNode = new StatementNode();
        statementNode.setCurNode(define.toGeneric());
        return statementNode;
    }
}
