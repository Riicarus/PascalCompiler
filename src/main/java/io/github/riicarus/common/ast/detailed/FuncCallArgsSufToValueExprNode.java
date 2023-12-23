package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionCallNode;

/**
 * FuncCallArgsSuf -> , ValueExpr FuncCallArgsSuf
 *
 * @author Riicarus
 * @create 2023-12-21 12:03
 * @since 1.0.0
 */
public class FuncCallArgsSufToValueExprNode extends FuncCallArgsSufNode {

    public static final DetailedASTCreator<FuncCallArgsSufToValueExprNode> CREATOR =
            children -> new FuncCallArgsSufToValueExprNode(
                    (TerminalASTNode) children.get(0),
                    (ValueExprNode) children.get(1),
                    (FuncCallArgsSufNode) children.get(2)
            );

    private final TerminalASTNode colon;
    private final ValueExprNode valueExpr;
    private final FuncCallArgsSufNode funcCallArgsSuf;

    public FuncCallArgsSufToValueExprNode(TerminalASTNode colon, ValueExprNode valueExpr, FuncCallArgsSufNode funcCallArgsSuf) {
        this.colon = colon;
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
                .append(colon.toTreeString(level + 1, prefix))
                .append(valueExpr.toTreeString(level + 1, prefix))
                .append(funcCallArgsSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FunctionCallNode toGeneric() {
        FunctionCallNode functionCallNode = funcCallArgsSuf.toGeneric();
        if (functionCallNode == null) {
            functionCallNode = new FunctionCallNode();
        }

        functionCallNode.addArg(valueExpr.toGeneric());
        return functionCallNode;
    }
}
