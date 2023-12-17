package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;

/**
 * CE -> AE RO AE
 *
 * @author Riicarus
 * @create 2023-12-17 18:07
 * @since 1.0.0
 */
public class CENode extends NonterminalASTNode {

    public static final ASTCreator<CENode> CREATOR =
            children -> new CENode(
                    (AENode) children.get(0),
                    (RONode) children.get(1),
                    (AENode) children.get(2)
            );

    private final AENode lAe;
    private final RONode ro;
    private final AENode rAe;

    public CENode(AENode lAe, RONode ro, AENode rAe) {
        this.lAe = lAe;
        this.ro = ro;
        this.rAe = rAe;
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
                .append(lAe.toTreeString(level + 1, prefix))
                .append(ro.toTreeString(level + 1, prefix))
                .append(rAe.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
