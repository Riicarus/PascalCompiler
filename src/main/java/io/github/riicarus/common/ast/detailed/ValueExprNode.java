package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ValueExpr -> LogicItem LogicExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 9:47
 * @since 1.0.0
 */
public class ValueExprNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ValueExprNode> CREATOR =
            children -> new ValueExprNode(
                    (LogicItemNode) children.get(0),
                    (LogicExprSufNode) children.get(1)
            );

    private final LogicItemNode logicItem;
    private final LogicExprSufNode logicExprSuf;

    public ValueExprNode(LogicItemNode logicItem, LogicExprSufNode logicExprSuf) {
        this.logicItem = logicItem;
        this.logicExprSuf = logicExprSuf;
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
                .append(logicItem.toTreeString(level + 1, prefix))
                .append(logicExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
