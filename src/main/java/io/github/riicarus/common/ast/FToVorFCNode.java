package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;

/**
 * F -> VorFC
 *
 * @author Riicarus
 * @create 2023-12-17 18:03
 * @since 1.0.0
 */
public class FToVorFCNode extends FNode {

    public static final ASTCreator<FToVorFCNode> CREATOR =
            children -> new FToVorFCNode(
                    (VorFCNode) children.get(0)
            );

    private final VorFCNode VorFC;

    public FToVorFCNode(VorFCNode vorFC) {
        VorFC = vorFC;
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
                .append(VorFC.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
