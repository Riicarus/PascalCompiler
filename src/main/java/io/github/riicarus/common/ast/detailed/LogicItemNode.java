package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * LogicItem -> LogicFactor LogicItemSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:53
 * @since 1.0.0
 */
public class LogicItemNode extends NonterminalASTNode {

    public static final DetailedASTCreator<LogicItemNode> CREATOR =
            children -> new LogicItemNode(
                    (LogicFactorNode) children.get(0),
                    (LogicItemSufNode) children.get(1)
            );

    private final LogicFactorNode logicFactor;
    private final LogicItemSufNode logicItemSuf;

    public LogicItemNode(LogicFactorNode logicFactor, LogicItemSufNode logicItemSuf) {
        this.logicFactor = logicFactor;
        this.logicItemSuf = logicItemSuf;
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
                .append(logicFactor.toTreeString(level + 1, prefix))
                .append(logicItemSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    /**
     * 注意: 如果是逻辑表达式而不是单个值, 此处返回的是对应逻辑表达式的顶层(根) Op 节点.
     *
     * @return 逻辑表达式的顶层节点 Or 单个值.
     */
    @Override
    public ExprNode toGeneric() {
        ExprNode factorNode = logicFactor.toGeneric();

        BinaryOpNode opNode = logicItemSuf.toGeneric();
        if (opNode == null) {
            return factorNode;
        }

        opNode.setLeftOperand(factorNode);
        return opNode.getTopOpNode();
    }
}
