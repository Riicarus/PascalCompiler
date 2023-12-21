package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * PrimExpr -> ( ValueExprOrFuncInlineDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:36
 * @since 1.0.0
 */
public class PrimExprToValueOrFuncDefNode extends PrimExprNode {

    public static final DetailedASTCreator<PrimExprToValueOrFuncDefNode> CREATOR =
            children -> new PrimExprToValueOrFuncDefNode(
                    (TerminalASTNode) children.get(0),
                    (ValueExprOrFuncInlineDefSufNode) children.get(1)
            );

    private final TerminalASTNode lParen;
    private final ValueExprOrFuncInlineDefSufNode valueExprOrFuncInlineDefSuf;

    public PrimExprToValueOrFuncDefNode(TerminalASTNode lParen,
                                        ValueExprOrFuncInlineDefSufNode valueExprOrFuncInlineDefSuf) {
        this.lParen = lParen;
        this.valueExprOrFuncInlineDefSuf = valueExprOrFuncInlineDefSuf;
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
                .append(valueExprOrFuncInlineDefSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
