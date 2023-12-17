package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * <p>子程序 AST</p>
 * <p>SP -> begin DST EST end</p>
 *
 * @author Riicarus
 * @create 2023-12-16 2:28
 * @since 1.0.0
 */
public class SubProgramNode extends NonterminalASTNode {

    public static final ASTCreator<SubProgramNode> CREATOR =
            children -> new SubProgramNode(
                    (TerminalASTNode) children.get(0),
                    (DSTNode) children.get(1),
                    (ESTNode) children.get(2),
                    (TerminalASTNode) children.get(3)
            );

    private final TerminalASTNode begin;
    private final DSTNode dst;
    private final ESTNode est;
    private final TerminalASTNode end;

    public SubProgramNode(TerminalASTNode begin, DSTNode dst, ESTNode est, TerminalASTNode end) {
        this.begin = begin;
        this.dst = dst;
        this.est = est;
        this.end = end;
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
                .append(begin.toTreeString(level + 1, prefix))
                .append(dst.toTreeString(level + 1, prefix))
                .append(est.toTreeString(level + 1, prefix))
                .append(end.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
