package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * VarDef -> Id VarInit
 *
 * @author Riicarus
 * @create 2023-12-21 9:53
 * @since 1.0.0
 */
public class VarDefToCommonVarNode extends VarDefNode {

    public static final DetailedASTCreator<VarDefToCommonVarNode> CREATOR =
            children -> new VarDefToCommonVarNode(
                    (IdNode) children.get(0),
                    (VarInitNode) children.get(1)
            );

    private final IdNode id;
    private final VarInitNode varInit;

    public VarDefToCommonVarNode(IdNode id, VarInitNode varInit) {
        this.id = id;
        this.varInit = varInit;
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
                .append(id.toTreeString(level + 1, prefix))
                .append(varInit.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
