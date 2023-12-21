package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ForInitListSuf -> , ForAssignOrDefine ForInitListSuf
 *
 * @author Riicarus
 * @create 2023-12-21 18:57
 * @since 1.0.0
 */
public class ForInitListSufToForAssignOrDefineNode extends ForInitListSufNode {

    public static final DetailedASTCreator<ForInitListSufToForAssignOrDefineNode> CREATOR =
            children -> new ForInitListSufToForAssignOrDefineNode(
                    (TerminalASTNode) children.get(0),
                    (ForAssignOrDefineNode) children.get(1),
                    (ForInitListSufNode) children.get(2)
            );

    private final TerminalASTNode colon;
    private final ForAssignOrDefineNode forAssignOrDefine;
    private final ForInitListSufNode forInitListSuf;

    public ForInitListSufToForAssignOrDefineNode(TerminalASTNode colon, ForAssignOrDefineNode forAssignOrDefine, ForInitListSufNode forInitListSuf) {
        this.colon = colon;
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
                .append(colon.toTreeString(level + 1, prefix))
                .append(forAssignOrDefine.toTreeString(level + 1, prefix))
                .append(forInitListSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
