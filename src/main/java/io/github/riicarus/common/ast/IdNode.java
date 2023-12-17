package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * Id -> identifier
 *
 * @author Riicarus
 * @create 2023-12-17 17:56
 * @since 1.0.0
 */
public class IdNode extends NonterminalASTNode {

    public static final ASTCreator<IdNode> CREATOR =
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

        sb.append(prefix).append(t).append(link).append(symbol == null ? "" : symbol)
                .append(identifier.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
