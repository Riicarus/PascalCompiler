package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * FuncArgTypeDefSuf -> , Type FuncArgTypeDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:49
 * @since 1.0.0
 */
public class FuncArgTypeDefSufToTypeNode extends FuncArgTypeDefSufNode {

    public static final DetailedASTCreator<FuncArgTypeDefSufToTypeNode> CREATOR =
            children -> new FuncArgTypeDefSufToTypeNode(
                    (TerminalASTNode) children.get(0),
                    (TypeNode) children.get(1),
                    (FuncArgTypeDefSufNode) children.get(2)
            );

    private final TerminalASTNode colon;
    private final TypeNode type;
    private final FuncArgTypeDefSufNode funcArgTypeDefSuf;

    public FuncArgTypeDefSufToTypeNode(TerminalASTNode colon, TypeNode type, FuncArgTypeDefSufNode funcArgTypeDefSuf) {
        this.colon = colon;
        this.type = type;
        this.funcArgTypeDefSuf = funcArgTypeDefSuf;
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
                .append(type.toTreeString(level + 1, prefix))
                .append(funcArgTypeDefSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
