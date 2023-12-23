package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * RelExpr -> ArithExpr RelExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:06
 * @since 1.0.0
 */
public class RelExprNode extends NonterminalASTNode {

    public static final DetailedASTCreator<RelExprNode> CREATOR =
            children -> new RelExprNode(
                    (ArithExprNode) children.get(0),
                    (RelExprSufNode) children.get(1)
            );

    private final ArithExprNode arithExpr;
    private final RelExprSufNode relExprSuf;

    public RelExprNode(ArithExprNode arithExpr, RelExprSufNode relExprSuf) {
        this.arithExpr = arithExpr;
        this.relExprSuf = relExprSuf;
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
                .append(arithExpr.toTreeString(level + 1, prefix))
                .append(relExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    /**
     * 注意: 如果是关系表达式而不是单个值, 此处返回的是对应关系表达式的顶层(根) Op 节点.
     *
     * @return 关系表达式的顶层节点 Or 单个值.
     */
    @Override
    public ExprNode toGeneric() {
        ExprNode arithNode = arithExpr.toGeneric();

        BinaryOpNode opNode = relExprSuf.toGeneric();
        if (opNode == null) {
            return arithNode;
        }

        opNode.setLeftOperand(arithNode);

        return opNode.getTopOpNode();
    }
}
