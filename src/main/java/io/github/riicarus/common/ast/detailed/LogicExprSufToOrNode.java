package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.OrNode;

/**
 * LogicExprSuf -> | LogicItem LogicExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:56
 * @since 1.0.0
 */
public class LogicExprSufToOrNode extends LogicExprSufNode {

    public static final DetailedASTCreator<LogicExprSufToOrNode> CREATOR =
            children -> new LogicExprSufToOrNode(
                    (TerminalASTNode) children.get(0),
                    (LogicItemNode) children.get(1),
                    (LogicExprSufNode) children.get(2)
            );

    private final TerminalASTNode or;
    private final LogicItemNode logicItem;
    private final LogicExprSufNode logicExprSuf;

    public LogicExprSufToOrNode(TerminalASTNode or, LogicItemNode logicItem, LogicExprSufNode logicExprSuf) {
        this.or = or;
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
                .append(or.toTreeString(level + 1, prefix))
                .append(logicItem.toTreeString(level + 1, prefix))
                .append(logicExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public BinaryOpNode toGeneric() {
        OrNode orNode = new OrNode();
        orNode.setRightOperand(logicItem.toGeneric());

        BinaryOpNode upperOpNode = logicExprSuf.toGeneric();
        if (upperOpNode != null) {
            upperOpNode.setLeftOperand(orNode);
            orNode.setTopOpNode(upperOpNode.getTopOpNode());
        }

        return orNode;
    }
}
