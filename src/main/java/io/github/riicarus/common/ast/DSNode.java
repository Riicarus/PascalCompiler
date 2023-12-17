package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * DS -> integer VDorFDS
 *
 * @author Riicarus
 * @create 2023-12-17 17:51
 * @since 1.0.0
 */
public class DSNode extends NonterminalASTNode {

    public static final ASTCreator<DSNode> CREATOR =
            children -> new DSNode(
                    (TerminalASTNode) children.get(0),
                    (VDorFDSNode) children.get(1)
            );

    private final TerminalASTNode integer;
    private final VDorFDSNode VDorFDS;

    public DSNode(TerminalASTNode integer, VDorFDSNode VDorFDS) {
        this.integer = integer;
        this.VDorFDS = VDorFDS;
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
                .append(integer.toTreeString(level + 1, prefix))
                .append(VDorFDS.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
