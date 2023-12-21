package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * TypeSuf -> [ArraySize] TypeSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:33
 * @since 1.0.0
 */
public class TypeSufToArrayNode extends TypeSufNode {

    public static final DetailedASTCreator<TypeSufToArrayNode> CREATOR =
            children -> new TypeSufToArrayNode(
                    (TerminalASTNode) children.get(0),
                    (ArraySizeNode) children.get(1),
                    (TerminalASTNode) children.get(2),
                    (TypeSufNode) children.get(3)
            );

    private final TerminalASTNode lBracket;
    private final ArraySizeNode arraySize;
    private final TerminalASTNode rBracket;
    private final TypeSufNode typeSuf;

    public TypeSufToArrayNode(TerminalASTNode lBracket, ArraySizeNode arraySize, TerminalASTNode rBracket,
                              TypeSufNode typeSuf) {
        this.lBracket = lBracket;
        this.arraySize = arraySize;
        this.rBracket = rBracket;
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
                .append(lBracket.toTreeString(level + 1, prefix))
                .append(arraySize.toTreeString(level + 1, prefix))
                .append(rBracket.toTreeString(level + 1, prefix))
                .append(typeSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
