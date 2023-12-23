package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.DividesNode;

/**
 * ArithItemSuf -> / PrimExpr ArithItemSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:33
 * @since 1.0.0
 */
public class ArithItemSufToDivideNode extends ArithItemSufNode {

    public static final DetailedASTCreator<ArithItemSufToDivideNode> CREATOR =
            children -> new ArithItemSufToDivideNode(
                    (TerminalASTNode) children.get(0),
                    (PrimExprNode) children.get(1),
                    (ArithItemSufNode) children.get(2)
            );

    private final TerminalASTNode divide;
    private final PrimExprNode primExpr;
    private final ArithItemSufNode arithItemSuf;

    public ArithItemSufToDivideNode(TerminalASTNode divide, PrimExprNode primExpr, ArithItemSufNode arithItemSuf) {
        this.divide = divide;
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
                .append(divide.toTreeString(level + 1, prefix))
                .append(primExpr.toTreeString(level + 1, prefix))
                .append(arithItemSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public DividesNode toGeneric() {
        DividesNode dividesNode = new DividesNode();
        dividesNode.setRightOperand(primExpr.toGeneric());

        BinaryOpNode upperOpNode = arithItemSuf.toGeneric();
        if (upperOpNode != null) {
            upperOpNode.setLeftOperand(dividesNode);
            dividesNode.setTopOpNode(upperOpNode.getTopOpNode());
        }

        return dividesNode;
    }
}
