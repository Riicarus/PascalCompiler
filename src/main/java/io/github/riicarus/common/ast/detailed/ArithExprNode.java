package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * ArithExpr -> ArithItem ArithExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:08
 * @since 1.0.0
 */
public class ArithExprNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ArithExprNode> CREATOR =
            children -> new ArithExprNode(
                    (ArithItemNode) children.get(0),
                    (ArithExprSufNode) children.get(1)
            );

    private final ArithItemNode arithItem;
    private final ArithExprSufNode arithExprSuf;

    public ArithExprNode(ArithItemNode arithItem, ArithExprSufNode arithExprSuf) {
        this.arithItem = arithItem;
        this.arithExprSuf = arithExprSuf;
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
                .append(arithItem.toTreeString(level + 1, prefix))
                .append(arithExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    /**
     * 注意: 如果是算术表达式而不是单个值, 此处返回的是对应算术表达式的顶层(根) Op 节点.
     *
     * @return 算术表达式的顶层节点 Or 单个值.
     */
    @Override
    public ExprNode toGeneric() {
        ExprNode itemNode = arithItem.toGeneric();

        BinaryOpNode opNode = arithExprSuf.toGeneric();
        if (opNode == null) {
            return itemNode;
        }

        opNode.setLeftOperand(itemNode);
        // 注意: 这里应该返回顶层 Op 节点
        return opNode.getTopOpNode();
    }
}
