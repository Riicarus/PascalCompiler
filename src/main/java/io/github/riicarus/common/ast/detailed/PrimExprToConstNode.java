package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * PrimExpr -> Const
 *
 * @author Riicarus
 * @create 2023-12-21 11:39
 * @since 1.0.0
 */
public class PrimExprToConstNode extends PrimExprNode {

    public static final DetailedASTCreator<PrimExprToConstNode> CREATOR =
            children -> new PrimExprToConstNode(
                    (ConstNode) children.get(0)
            );

    private final ConstNode _const;

    public PrimExprToConstNode(ConstNode _const) {
        this._const = _const;
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
                .append(_const.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
