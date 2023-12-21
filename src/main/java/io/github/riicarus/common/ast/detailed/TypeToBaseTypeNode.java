package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Type -> BaseType TypeSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:12
 * @since 1.0.0
 */
public class TypeToBaseTypeNode extends TypeNode {

    public static final DetailedASTCreator<TypeToBaseTypeNode> CREATOR =
            children -> new TypeToBaseTypeNode(
                    (BaseTypeNode) children.get(0),
                    (TypeSufNode) children.get(1)
            );

    private final BaseTypeNode baseType;
    private final TypeSufNode typeSuf;

    public TypeToBaseTypeNode(BaseTypeNode baseType, TypeSufNode typeSuf) {
        this.baseType = baseType;
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
                .append(baseType.toTreeString(level + 1, prefix))
                .append(typeSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
