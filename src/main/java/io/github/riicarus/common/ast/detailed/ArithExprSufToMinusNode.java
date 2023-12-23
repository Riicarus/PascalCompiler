package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.MinusNode;

/**
 * ArithExprSuf -> - ArithItem ArithExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:25
 * @since 1.0.0
 */
public class ArithExprSufToMinusNode extends ArithExprSufNode {

    public static final DetailedASTCreator<ArithExprSufToMinusNode> CREATOR =
            children -> new ArithExprSufToMinusNode(
                    (TerminalASTNode) children.get(0),
                    (ArithItemNode) children.get(1),
                    (ArithExprSufNode) children.get(2)
            );

    private final TerminalASTNode minus;
    private final ArithItemNode arithItem;
    private final ArithExprSufNode arithExprSuf;

    public ArithExprSufToMinusNode(TerminalASTNode minus, ArithItemNode arithItem, ArithExprSufNode arithExprSuf) {
        this.minus = minus;
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
                .append(minus.toTreeString(level + 1, prefix))
                .append(arithItem.toTreeString(level + 1, prefix))
                .append(arithExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public MinusNode toGeneric() {
        MinusNode minusNode = new MinusNode();
        minusNode.setRightOperand(arithItem.toGeneric());

        BinaryOpNode upperOpNode = arithExprSuf.toGeneric();
        if (upperOpNode != null) {
            upperOpNode.setLeftOperand(minusNode);
            minusNode.setTopOpNode(upperOpNode.getTopOpNode());
        }

        return minusNode;
    }
}
