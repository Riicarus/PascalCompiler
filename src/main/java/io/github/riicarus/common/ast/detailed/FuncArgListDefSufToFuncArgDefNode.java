package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * FuncArgListDefSuf -> , FuncArgDef FuncArgListDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:09
 * @since 1.0.0
 */
public class FuncArgListDefSufToFuncArgDefNode extends FuncArgListDefSufNode {

    public static final DetailedASTCreator<FuncArgListDefSufToFuncArgDefNode> CREATOR =
            children -> new FuncArgListDefSufToFuncArgDefNode(
                    (TerminalASTNode) children.get(0),
                    (FuncArgDefNode) children.get(1),
                    (FuncArgListDefSufNode) children.get(2)
            );

    private final TerminalASTNode colon;
    private final FuncArgDefNode funcArgDef;
    private final FuncArgListDefSufNode funcArgListDefSuf;

    public FuncArgListDefSufToFuncArgDefNode(TerminalASTNode colon,
                                             FuncArgDefNode funcArgDef,
                                             FuncArgListDefSufNode funcArgListDefSuf) {
        this.colon = colon;
        this.funcArgDef = funcArgDef;
        this.funcArgListDefSuf = funcArgListDefSuf;
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
                .append(funcArgDef.toTreeString(level + 1, prefix))
                .append(funcArgListDefSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
