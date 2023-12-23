package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.PlusNode;

/**
 * ArithExprSuf -> + ArithItem ArithExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:26
 * @since 1.0.0
 */
public class ArithExprSufToPlusNode extends ArithExprSufNode {

    public static final DetailedASTCreator<ArithExprSufToPlusNode> CREATOR =
            children -> new ArithExprSufToPlusNode(
                    (TerminalASTNode) children.get(0),
                    (ArithItemNode) children.get(1),
                    (ArithExprSufNode) children.get(2)
            );

    private final TerminalASTNode plus;
    private final ArithItemNode arithItem;
    private final ArithExprSufNode arithExprSuf;

    public ArithExprSufToPlusNode(TerminalASTNode plus, ArithItemNode arithItem, ArithExprSufNode arithExprSuf) {
        this.plus = plus;
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
                .append(plus.toTreeString(level + 1, prefix))
                .append(arithItem.toTreeString(level + 1, prefix))
                .append(arithExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public PlusNode toGeneric() {
        PlusNode plusNode = new PlusNode();
        plusNode.setRightOperand(arithItem.toGeneric());

        BinaryOpNode upperOpNode = arithExprSuf.toGeneric();
        if (upperOpNode != null) {
            upperOpNode.setLeftOperand(plusNode);
            plusNode.setTopOpNode(upperOpNode.getTopOpNode());
        }

        return plusNode;
    }
}
