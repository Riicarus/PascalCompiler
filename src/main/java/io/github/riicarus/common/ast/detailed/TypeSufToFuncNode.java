package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;

/**
 * TypeSuf -> function(FuncArgTypeDef) TypeSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:31
 * @since 1.0.0
 */
public class TypeSufToFuncNode extends TypeSufNode {

    public static final DetailedASTCreator<TypeSufToFuncNode> CREATOR =
            children -> new TypeSufToFuncNode(
                    (TerminalASTNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (FuncArgTypeDefNode) children.get(2),
                    (TerminalASTNode) children.get(3),
                    (TypeSufNode) children.get(4)
            );

    private final TerminalASTNode function;
    private final TerminalASTNode lParen;
    private final FuncArgTypeDefNode funcArgTypeDef;
    private final TerminalASTNode rParen;
    private final TypeSufNode typeSuf;

    public TypeSufToFuncNode(TerminalASTNode function,
                             TerminalASTNode lParen, FuncArgTypeDefNode funcArgTypeDef, TerminalASTNode rParen,
                             TypeSufNode typeSuf) {
        this.function = function;
        this.lParen = lParen;
        this.funcArgTypeDef = funcArgTypeDef;
        this.rParen = rParen;
        this.typeSuf = typeSuf;
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
                .append(function.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(funcArgTypeDef.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix))
                .append(typeSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FuncTypeNode toGeneric() {
        FuncTypeNode funcTypeNode = funcArgTypeDef.toGeneric();

        FuncTypeNode topFuncType = typeSuf.toGeneric();
        if (topFuncType == null) {
            return funcTypeNode;
        }

        topFuncType.deepSetReturnType(funcTypeNode);
        return topFuncType;
    }
}
