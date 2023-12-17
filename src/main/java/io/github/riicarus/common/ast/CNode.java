package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * C -> constant
 *
 * @author Riicarus
 * @create 2023-12-17 18:07
 * @since 1.0.0
 */
public class CNode extends NonterminalASTNode {

    public static final ASTCreator<CNode> CREATOR =
            children -> new CNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode constant;

    public CNode(TerminalASTNode constant) {
        this.constant = constant;
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
                .append(constant.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
