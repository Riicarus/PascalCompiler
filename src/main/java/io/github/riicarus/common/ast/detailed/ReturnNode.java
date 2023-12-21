package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Return -> return RetValue
 *
 * @author Riicarus
 * @create 2023-12-21 18:06
 * @since 1.0.0
 */
public class ReturnNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ReturnNode> CREATOR =
            children -> new ReturnNode(
                    (TerminalASTNode) children.get(0),
                    (RetValueNode) children.get(1)
            );

    private final TerminalASTNode _return;
    private final RetValueNode retValue;

    public ReturnNode(TerminalASTNode _return, RetValueNode retValue) {
        this._return = _return;
        this.retValue = retValue;
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
                .append(_return.toTreeString(level + 1, prefix))
                .append(retValue.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
