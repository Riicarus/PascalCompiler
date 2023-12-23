package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.v.VariableNode;

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
                    (DetailedTypeNode) children.get(0),
                    (DetailedIdNode) children.get(1)
            );

    private final DetailedTypeNode type;
    private final DetailedIdNode id;

    public FuncArgDefNode(DetailedTypeNode type, DetailedIdNode id) {
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
    public VariableNode toGeneric() {
        VariableNode varNode = id.toGeneric();
        varNode.setTypeNode(type.toGeneric());

        return varNode;
    }
}
