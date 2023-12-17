package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * VorFCS -> (AE)
 *
 * @author Riicarus
 * @create 2023-12-17 18:06
 * @since 1.0.0
 */
public class FCSuffixNode extends VorFCSNode {

    public static final ASTCreator<FCSuffixNode> CREATOR =
            children -> new FCSuffixNode(
                    (TerminalASTNode) children.get(0),
                    (AENode) children.get(1),
                    (TerminalASTNode) children.get(2)
            );

    private final TerminalASTNode lParen;
    private final AENode ae;
    private final TerminalASTNode rParen;

    public FCSuffixNode(TerminalASTNode lParen, AENode ae, TerminalASTNode rParen) {
        this.lParen = lParen;
        this.ae = ae;
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
                .append(lParen.toTreeString(level + 1, prefix))
                .append(ae.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
