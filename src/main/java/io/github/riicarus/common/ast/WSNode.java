package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * WS -> write(V)
 *
 * @author Riicarus
 * @create 2023-12-17 18:01
 * @since 1.0.0
 */
public class WSNode extends NonterminalASTNode {

    public static final ASTCreator<WSNode> CREATOR =
            children -> new WSNode(
                    (TerminalASTNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (VNode) children.get(2),
                    (TerminalASTNode) children.get(3)
            );

    private final TerminalASTNode write;
    private final TerminalASTNode lParen;
    private final VNode v;
    private final TerminalASTNode rParen;

    public WSNode(TerminalASTNode write, TerminalASTNode lParen, VNode v, TerminalASTNode rParen) {
        this.write = write;
        this.lParen = lParen;
        this.v = v;
        this.rParen = rParen;
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
                .append(write.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(v.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
