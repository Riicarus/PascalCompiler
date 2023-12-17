package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;

/**
 * AE -> I AE'
 *
 * @author Riicarus
 * @create 2023-12-17 18:02
 * @since 1.0.0
 */
public class AENode extends NonterminalASTNode {

    public static final ASTCreator<AENode> CREATOR =
            children -> new AENode(
                    (INode) children.get(0),
                    (AEPlusNode) children.get(1)
            );

    private final INode i;
    private final AEPlusNode aePlus;

    public AENode(INode i, AEPlusNode aePlus) {
        this.i = i;
        this.aePlus = aePlus;
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
                .append(i.toTreeString(level + 1, prefix))
                .append(aePlus.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
