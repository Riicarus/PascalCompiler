package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Continue -> continue
 *
 * @author Riicarus
 * @create 2023-12-21 18:05
 * @since 1.0.0
 */
public class ContinueNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ContinueNode> CREATOR =
            children -> new ContinueNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode _continue;

    public ContinueNode(TerminalASTNode _continue) {
        this._continue = _continue;
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
                .append(_continue.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
