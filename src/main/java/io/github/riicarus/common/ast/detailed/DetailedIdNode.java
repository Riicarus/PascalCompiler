package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.v.VariableNode;

/**
 * Id -> identifier
 *
 * @author Riicarus
 * @create 2023-12-21 9:38
 * @since 1.0.0
 */
public class DetailedIdNode extends NonterminalASTNode {

    public static final DetailedASTCreator<DetailedIdNode> CREATOR =
            children -> new DetailedIdNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode identifier;

    public DetailedIdNode(TerminalASTNode identifier) {
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
    public VariableNode toGeneric() {
        return new VariableNode(identifier.getToken().getLexeme());
    }
}
