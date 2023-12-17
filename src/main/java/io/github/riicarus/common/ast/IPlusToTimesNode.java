package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * I' -> * F I'
 *
 * @author Riicarus
 * @create 2023-12-17 18:03
 * @since 1.0.0
 */
public class IPlusToTimesNode extends IPlusNode {

    public static final ASTCreator<IPlusToTimesNode> CREATOR =
            children -> new IPlusToTimesNode(
                    (TerminalASTNode) children.get(0),
                    (FNode) children.get(1),
                    (IPlusNode) children.get(2)
            );

    private final TerminalASTNode times;
    private final FNode f;
    private final IPlusNode iPlus;

    public IPlusToTimesNode(TerminalASTNode times, FNode f, IPlusNode iPlus) {
        this.times = times;
        this.f = f;
        this.iPlus = iPlus;
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
                .append(times.toTreeString(level + 1, prefix))
                .append(f.toTreeString(level + 1, prefix))
                .append(iPlus.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
