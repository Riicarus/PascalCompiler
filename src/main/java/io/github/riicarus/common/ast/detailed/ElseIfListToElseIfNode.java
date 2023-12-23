package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ElseNode;

/**
 * ElseIfList -> ElseIF ElseIfList
 *
 * @author Riicarus
 * @create 2023-12-21 18:31
 * @since 1.0.0
 */
public class ElseIfListToElseIfNode extends ElseIfListNode {

    public static final DetailedASTCreator<ElseIfListToElseIfNode> CREATOR =
            children -> new ElseIfListToElseIfNode(
                    (DetailedElseIfNode) children.get(0),
                    (ElseIfListNode) children.get(1)
            );

    private final DetailedElseIfNode elseif;
    private final ElseIfListNode elseIfList;

    public ElseIfListToElseIfNode(DetailedElseIfNode elseif, ElseIfListNode elseIfList) {
        this.elseif = elseif;
        this.elseIfList = elseIfList;
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
                .append(elseif.toTreeString(level + 1, prefix))
                .append(elseIfList.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ElseNode toGeneric() {
        ElseNode elseNode = elseIfList.toGeneric();
        if (elseNode == null) {
            elseNode = new ElseNode();
        }

        elseNode.addElseIfNode(elseif.toGeneric());
        return elseNode;
    }
}
