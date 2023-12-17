package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * VDorFDS -> function Id(A); FB
 *
 * @author Riicarus
 * @create 2023-12-17 17:52
 * @since 1.0.0
 */
public class FDSuffixNode extends VDorFDSNode {

    public static final ASTCreator<FDSuffixNode> CREATOR =
            children -> new FDSuffixNode(
                    (TerminalASTNode) children.get(0),
                    (IdNode) children.get(1),
                    (TerminalASTNode) children.get(2),
                    (ANode) children.get(3),
                    (TerminalASTNode) children.get(4),
                    (TerminalASTNode) children.get(5),
                    (FBNode) children.get(6)
            );

    private final TerminalASTNode function;
    private final IdNode id;
    private final TerminalASTNode lParen;
    private final ANode a;
    private final TerminalASTNode rParen;
    private final TerminalASTNode semicolon;
    private final FBNode fb;

    public FDSuffixNode(TerminalASTNode function,
                        IdNode id,
                        TerminalASTNode lParen, ANode a, TerminalASTNode rParen,
                        TerminalASTNode semicolon,
                        FBNode fb) {
        this.function = function;
        this.id = id;
        this.lParen = lParen;
        this.a = a;
        this.rParen = rParen;
        this.semicolon = semicolon;
        this.fb = fb;
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
                .append(function.toTreeString(level + 1, prefix))
                .append(id.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(a.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix))
                .append(fb.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
