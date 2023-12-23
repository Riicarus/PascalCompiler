package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;
import io.github.riicarus.common.data.ast.generic.type.TypeNode;

/**
 * Type -> VoidFuncType TypeSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:24
 * @since 1.0.0
 */
public class DetailedTypeToVoidFuncTypeNode extends DetailedTypeNode {

    public static final DetailedASTCreator<DetailedTypeToVoidFuncTypeNode> CREATOR =
            children -> new DetailedTypeToVoidFuncTypeNode(
                    (VoidFuncTypeNode) children.get(0),
                    (TypeSufNode) children.get(1)
            );

    private final VoidFuncTypeNode voidFuncType;
    private final TypeSufNode typeSuf;

    public DetailedTypeToVoidFuncTypeNode(VoidFuncTypeNode voidFuncType, TypeSufNode typeSuf) {
        this.voidFuncType = voidFuncType;
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
                .append(voidFuncType.toTreeString(level + 1, prefix))
                .append(typeSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public TypeNode toGeneric() {
        FuncTypeNode funcTypeNode = voidFuncType.toGeneric();

        FuncTypeNode topFuncType = typeSuf.toGeneric();
        if (topFuncType == null) {
            return funcTypeNode;
        }

        topFuncType.deepSetReturnType(funcTypeNode);
        return topFuncType;
    }
}
