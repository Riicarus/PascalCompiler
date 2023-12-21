package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * FuncCallSuf -> (FuncCallArgs)
 *
 * @author Riicarus
 * @create 2023-12-21 11:57
 * @since 1.0.0
 */
public class FuncCallSufToParenNode extends FuncCallSufNode {

    public static final DetailedASTCreator<FuncCallSufToParenNode> CREATOR =
            children -> new FuncCallSufToParenNode(
                    (TerminalASTNode) children.get(0),
                    (FuncCallArgsNode) children.get(1),
                    (TerminalASTNode) children.get(2)
            );

    private final TerminalASTNode lParen;
    private final FuncCallArgsNode funcCallArgs;
    private final TerminalASTNode rParen;

    public FuncCallSufToParenNode(TerminalASTNode lParen, FuncCallArgsNode funcCallArgs, TerminalASTNode rParen) {
        this.lParen = lParen;
        this.funcCallArgs = funcCallArgs;
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
                .append(lParen.toTreeString(level + 1, prefix))
                .append(funcCallArgs.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
