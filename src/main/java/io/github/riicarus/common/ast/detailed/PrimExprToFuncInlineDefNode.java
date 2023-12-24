package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * PrimExpr -> FuncInlineDefine
 *
 * @author Riicarus
 * @create 2023-12-24 21:07
 * @since 1.0.0
 */
public class PrimExprToFuncInlineDefNode extends PrimExprNode {

    public static final DetailedASTCreator<PrimExprToFuncInlineDefNode> CREATOR =
            children -> new PrimExprToFuncInlineDefNode(
                    (FuncInlineDefineNode) children.get(0)
            );

    private final FuncInlineDefineNode funcInlineDefine;

    public PrimExprToFuncInlineDefNode(FuncInlineDefineNode funcInlineDefine) {
        this.funcInlineDefine = funcInlineDefine;
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
                .append(funcInlineDefine.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ExprNode toGeneric() {
        return funcInlineDefine.toGeneric();
    }
}
