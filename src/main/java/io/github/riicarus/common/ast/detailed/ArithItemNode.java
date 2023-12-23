package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * ArithItem -> PrimExpr ArithItemSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:23
 * @since 1.0.0
 */
public class ArithItemNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ArithItemNode> CREATOR =
            children -> new ArithItemNode(
                    (PrimExprNode) children.get(0),
                    (ArithItemSufNode) children.get(1)
            );

    private final PrimExprNode primExpr;
    private final ArithItemSufNode arithItemSuf;

    public ArithItemNode(PrimExprNode primExpr, ArithItemSufNode arithItemSuf) {
        this.primExpr = primExpr;
        this.arithItemSuf = arithItemSuf;
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
                .append(primExpr.toTreeString(level + 1, prefix))
                .append(arithItemSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    /**
     * 注意: 如果是算术表达式而不是单个值, 此处返回的是对应算术表达式的顶层(根) Op 节点.
     *
     * @return 算术表达式的顶层节点 Or 单个值.
     */
    @Override
    public ExprNode toGeneric() {
        ExprNode primNode = primExpr.toGeneric();

        BinaryOpNode opNode = arithItemSuf.toGeneric();
        if (opNode == null) {
            return primNode;
        }

        opNode.setLeftOperand(primNode);
        return opNode.getTopOpNode();
    }
}
