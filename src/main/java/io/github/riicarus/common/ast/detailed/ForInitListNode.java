package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ForInitList -> ForAssignOrDefine ForInitListSuf
 *
 * @author Riicarus
 * @create 2023-12-21 18:54
 * @since 1.0.0
 */
public class ForInitListNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ForInitListNode> CREATOR =
            children -> new ForInitListNode(
                    (ForAssignOrDefineNode) children.get(0),
                    (ForInitListSufNode) children.get(1)
            );

    private final ForAssignOrDefineNode forAssignOrDefine;
    private final ForInitListSufNode forInitListSuf;

    public ForInitListNode(ForAssignOrDefineNode forAssignOrDefine, ForInitListSufNode forInitListSuf) {
        this.forAssignOrDefine = forAssignOrDefine;
        this.forInitListSuf = forInitListSuf;
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
                .append(forAssignOrDefine.toTreeString(level + 1, prefix))
                .append(forInitListSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
