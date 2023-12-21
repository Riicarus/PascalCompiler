package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Define -> Type VarDef
 *
 * @author Riicarus
 * @create 2023-12-21 9:32
 * @since 1.0.0
 */
public class DefineNode extends NonterminalASTNode {

    public static final DetailedASTCreator<DefineNode> CREATOR =
            children -> new DefineNode(
                    (TypeNode) children.get(0),
                    (VarDefNode) children.get(1)
            );

    private final TypeNode type;
    private final VarDefNode varDef;

    public DefineNode(TypeNode type, VarDefNode varDef) {
        this.type = type;
        this.varDef = varDef;
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
                .append(varDef.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
