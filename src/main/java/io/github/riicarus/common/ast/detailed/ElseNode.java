package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Else -> ElseIfList EndElse
 *
 * @author Riicarus
 * @create 2023-12-21 18:21
 * @since 1.0.0
 */
public class ElseNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ElseNode> CREATOR =
            children -> new ElseNode(
                    (ElseIfListNode) children.get(0),
                    (EndElseNode) children.get(1)
            );

    private final ElseIfListNode elseIfList;
    private final EndElseNode endElse;

    public ElseNode(ElseIfListNode elseIfList, EndElseNode endElse) {
        this.elseIfList = elseIfList;
        this.endElse = endElse;
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
                .append(elseIfList.toTreeString(level + 1, prefix))
                .append(endElse.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
