package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * PrimExpr -> Id FuncCallSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:41
 * @since 1.0.0
 */
public class PrimExprToIdOrFuncCallNode extends PrimExprNode {

    public static final DetailedASTCreator<PrimExprToIdOrFuncCallNode> CREATOR =
            children -> new PrimExprToIdOrFuncCallNode(
                    (IdNode) children.get(0),
                    (FuncCallSufNode) children.get(1)
            );

    private final IdNode id;
    private final FuncCallSufNode funcCallSuf;

    public PrimExprToIdOrFuncCallNode(IdNode id, FuncCallSufNode funcCallSuf) {
        this.id = id;
        this.funcCallSuf = funcCallSuf;
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
                .append(id.toTreeString(level + 1, prefix))
                .append(funcCallSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
