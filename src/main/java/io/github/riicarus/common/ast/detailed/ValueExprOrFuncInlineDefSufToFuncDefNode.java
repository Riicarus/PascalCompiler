package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionNode;

/**
 * ValueExprOrFuncInlineDefSuf -> FuncInlineDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:46
 * @since 1.0.0
 */
public class ValueExprOrFuncInlineDefSufToFuncDefNode extends ValueExprOrFuncInlineDefSufNode {

    public static final DetailedASTCreator<ValueExprOrFuncInlineDefSufToFuncDefNode> CREATOR =
            children -> new ValueExprOrFuncInlineDefSufToFuncDefNode(
                    (FuncInlineDefSufNode) children.get(0)
            );

    private final FuncInlineDefSufNode funcInlineDefSuf;

    public ValueExprOrFuncInlineDefSufToFuncDefNode(FuncInlineDefSufNode funcInlineDefSuf) {
        this.funcInlineDefSuf = funcInlineDefSuf;
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
                .append(funcInlineDefSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FunctionNode toGeneric() {
        FunctionNode functionNode = new FunctionNode();
        functionNode.setProtoTypeNode(funcInlineDefSuf.toGeneric());
        return functionNode;
    }
}
