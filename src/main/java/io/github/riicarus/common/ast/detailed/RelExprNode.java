package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

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

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
