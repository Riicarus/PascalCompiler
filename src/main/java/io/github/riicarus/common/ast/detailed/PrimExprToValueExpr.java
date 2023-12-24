package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * PrimExpr -> (ValueExpr)
 *
 * @author Riicarus
 * @create 2023-12-21 11:36
 * @since 1.0.0
 */
public class PrimExprToValueExpr extends PrimExprNode {

    public static final DetailedASTCreator<PrimExprToValueExpr> CREATOR =
            children -> new PrimExprToValueExpr(
                    (TerminalASTNode) children.get(0),
                    (ValueExprNode) children.get(1),
                    (TerminalASTNode) children.get(2)
            );

    private final TerminalASTNode lParen;
    private final ValueExprNode valueExpr;
    private final TerminalASTNode rParen;

    public PrimExprToValueExpr(TerminalASTNode lParen,
                               ValueExprNode valueExpr, TerminalASTNode rParen) {
        this.lParen = lParen;
        this.valueExpr = valueExpr;
        this.rParen = rParen;
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
                .append(lParen.toTreeString(level + 1, prefix))
                .append(valueExpr.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ExprNode toGeneric() {
        return valueExpr.toGeneric();
    }
}
