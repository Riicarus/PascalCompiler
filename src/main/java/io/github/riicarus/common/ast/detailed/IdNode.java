package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Id -> identifier
 *
 * @author Riicarus
 * @create 2023-12-21 9:38
 * @since 1.0.0
 */
public class IdNode extends NonterminalASTNode {

    public static final DetailedASTCreator<IdNode> CREATOR =
            children -> new IdNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode identifier;

    public IdNode(TerminalASTNode identifier) {
        this.identifier = identifier;
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
                .append(identifier.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
