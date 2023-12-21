package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * FuncArgDef -> Type Id
 *
 * @author Riicarus
 * @create 2023-12-21 10:05
 * @since 1.0.0
 */
public class FuncArgDefNode extends NonterminalASTNode {

    public static final DetailedASTCreator<FuncArgDefNode> CREATOR =
            children -> new FuncArgDefNode(
                    (TypeNode) children.get(0),
                    (IdNode) children.get(1)
            );

    private final TypeNode type;
    private final IdNode id;

    public FuncArgDefNode(TypeNode type, IdNode id) {
        this.type = type;
        this.id = id;
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
                .append(type.toTreeString(level + 1, prefix))
                .append(id.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
