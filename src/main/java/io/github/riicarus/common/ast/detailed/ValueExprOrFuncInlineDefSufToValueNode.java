package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ValueExprOrFuncInlineDefSuf -> ValueExpr )
 *
 * @author Riicarus
 * @create 2023-12-21 11:43
 * @since 1.0.0
 */
public class ValueExprOrFuncInlineDefSufToValueNode extends ValueExprOrFuncInlineDefSufNode {

    public static final DetailedASTCreator<ValueExprOrFuncInlineDefSufToValueNode> CREATOR =
            children -> new ValueExprOrFuncInlineDefSufToValueNode(
                    (ValueExprNode) children.get(0),
                    (TerminalASTNode) children.get(1)
            );

    private final ValueExprNode valueExpr;
    private final TerminalASTNode rParen;

    public ValueExprOrFuncInlineDefSufToValueNode(ValueExprNode valueExpr, TerminalASTNode rParen) {
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
                .append(valueExpr.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
