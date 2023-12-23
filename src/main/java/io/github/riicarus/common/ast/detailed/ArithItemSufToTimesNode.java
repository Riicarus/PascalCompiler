package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.TimesNode;

/**
 * ArithItemSuf -> * PrimExpr ArithItemSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:31
 * @since 1.0.0
 */
public class ArithItemSufToTimesNode extends ArithItemSufNode {

    public static final DetailedASTCreator<ArithItemSufToTimesNode> CREATOR =
            children -> new ArithItemSufToTimesNode(
                    (TerminalASTNode) children.get(0),
                    (PrimExprNode) children.get(1),
                    (ArithItemSufNode) children.get(2)
            );

    private final TerminalASTNode times;
    private final PrimExprNode primExpr;
    private final ArithItemSufNode arithItemSuf;

    public ArithItemSufToTimesNode(TerminalASTNode times, PrimExprNode primExpr, ArithItemSufNode arithItemSuf) {
        this.times = times;
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
                .append(times.toTreeString(level + 1, prefix))
                .append(primExpr.toTreeString(level + 1, prefix))
                .append(arithItemSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public TimesNode toGeneric() {
        TimesNode timesNode = new TimesNode();
        timesNode.setRightOperand(primExpr.toGeneric());

        BinaryOpNode upperOpNode = arithItemSuf.toGeneric();
        if (upperOpNode != null) {
            upperOpNode.setLeftOperand(timesNode);
            timesNode.setTopOpNode(upperOpNode.getTopOpNode());
        }

        return timesNode;
    }
}
