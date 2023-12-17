package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;

/**
 * VorFC -> Id VorFCS
 *
 * @author Riicarus
 * @create 2023-12-17 18:05
 * @since 1.0.0
 */
public class VorFCNode extends NonterminalASTNode {

    public static final ASTCreator<VorFCNode> CREATOR =
            children -> new VorFCNode(
                    (IdNode) children.get(0),
                    (VorFCSNode) children.get(1)
            );

    private final IdNode id;
    private final VorFCSNode VorFCS;

    public VorFCNode(IdNode id, VorFCSNode vorFCS) {
        this.id = id;
        VorFCS = vorFCS;
    }

    @Override
    public String toTreeString(int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(prefix).append(t).append(link).append(symbol == null ? "" : symbol)
                .append(id.toTreeString(level + 1, prefix))
                .append(VorFCS.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
