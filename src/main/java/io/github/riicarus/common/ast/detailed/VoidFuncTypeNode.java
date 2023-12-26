package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;
import io.github.riicarus.common.data.ast.generic.type.VoidTypeNode;

/**
 * VoidFuncType -> void function(FuncArgTypeDef)
 *
 * @author Riicarus
 * @create 2023-12-21 10:24
 * @since 1.0.0
 */
public class VoidFuncTypeNode extends NonterminalASTNode {

    public static final DetailedASTCreator<VoidFuncTypeNode> CREATOR =
            children -> new VoidFuncTypeNode(
                    (TerminalASTNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (TerminalASTNode) children.get(2),
                    (FuncArgTypeDefNode) children.get(3),
                    (TerminalASTNode) children.get(4)
            );

    private final TerminalASTNode _void;
    private final TerminalASTNode function;
    private final TerminalASTNode lParen;
    private final FuncArgTypeDefNode funcArgTypeDef;
    private final TerminalASTNode rParen;

    public VoidFuncTypeNode(TerminalASTNode _void, TerminalASTNode function,
                            TerminalASTNode lParen, FuncArgTypeDefNode funcArgTypeDef, TerminalASTNode rParen) {
        this._void = _void;
        this.function = function;
        this.lParen = lParen;
        this.funcArgTypeDef = funcArgTypeDef;
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
                .append(_void.toTreeString(level + 1, prefix))
                .append(function.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(funcArgTypeDef.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FuncTypeNode toGeneric() {
        FuncTypeNode funcTypeNode = funcArgTypeDef.toGeneric();
        funcTypeNode.deepSetReturnType(new VoidTypeNode());

        return funcTypeNode;
    }
}
