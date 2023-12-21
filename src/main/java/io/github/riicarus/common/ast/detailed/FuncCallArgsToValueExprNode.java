package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * FuncCallArgs -> ValueExpr FuncCallArgsSuf
 *
 * @author Riicarus
 * @create 2023-12-21 12:00
 * @since 1.0.0
 */
public class FuncCallArgsToValueExprNode extends FuncCallArgsNode {

    public static final DetailedASTCreator<FuncCallArgsToValueExprNode> CREATOR =
            children -> new FuncCallArgsToValueExprNode(
                    (ValueExprNode) children.get(0),
                    (FuncCallArgsSufNode) children.get(1)
            );

    private final ValueExprNode valueExpr;
    private final FuncCallArgsSufNode funcCallArgsSuf;

    public FuncCallArgsToValueExprNode(ValueExprNode valueExpr, FuncCallArgsSufNode funcCallArgsSuf) {
        this.valueExpr = valueExpr;
        this.funcCallArgsSuf = funcCallArgsSuf;
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
                .append(valueExpr.toTreeString(level + 1, prefix))
                .append(funcCallArgsSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
