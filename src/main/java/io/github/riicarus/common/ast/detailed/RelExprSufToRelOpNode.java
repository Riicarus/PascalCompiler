package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * RelExprSuf -> RelOp ArithExpr RelExprSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:10
 * @since 1.0.0
 */
public class RelExprSufToRelOpNode extends RelExprSufNode {

    public static final DetailedASTCreator<RelExprSufToRelOpNode> CREATOR =
            children -> new RelExprSufToRelOpNode(
                    (RelOpNode) children.get(0),
                    (ArithExprNode) children.get(1),
                    (RelExprSufNode) children.get(2)
            );

    private final RelOpNode relOp;
    private final ArithExprNode arithExpr;
    private final RelExprSufNode relExprSuf;

    public RelExprSufToRelOpNode(RelOpNode relOp, ArithExprNode arithExpr, RelExprSufNode relExprSuf) {
        this.relOp = relOp;
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
                .append(relOp.toTreeString(level + 1, prefix))
                .append(arithExpr.toTreeString(level + 1, prefix))
                .append(relExprSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
