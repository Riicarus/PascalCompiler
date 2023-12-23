package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.UnaryOpNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.NegateNode;

/**
 * LogicFactor -> !RelExpr
 *
 * @author Riicarus
 * @create 2023-12-21 11:05
 * @since 1.0.0
 */
public class LogicFactorToNotNode extends LogicFactorNode {

    public static final DetailedASTCreator<LogicFactorToNotNode> CREATOR =
            children -> new LogicFactorToNotNode(
                    (TerminalASTNode) children.get(0),
                    (RelExprNode) children.get(1)
            );

    private final TerminalASTNode not;
    private final RelExprNode relExpr;

    public LogicFactorToNotNode(TerminalASTNode not, RelExprNode relExpr) {
        this.not = not;
        this.relExpr = relExpr;
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
                .append(not.toTreeString(level + 1, prefix))
                .append(relExpr.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public UnaryOpNode toGeneric() {
        ExprNode relNode = relExpr.toGeneric();

        return new NegateNode(relNode);
    }
}
