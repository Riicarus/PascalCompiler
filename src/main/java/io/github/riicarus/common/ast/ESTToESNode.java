package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * EST -> ES; EST
 *
 * @author Riicarus
 * @create 2023-12-17 17:57
 * @since 1.0.0
 */
public class ESTToESNode extends ESTNode {

    public static final ASTCreator<ESTToESNode> CREATOR =
            children -> new ESTToESNode(
                    (ESNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (ESTNode) children.get(2)
            );

    private final ESNode es;
    private final TerminalASTNode semicolon;
    private final ESTNode est;

    public ESTToESNode(ESNode es, TerminalASTNode semicolon, ESTNode est) {
        this.es = es;
        this.semicolon = semicolon;
        this.est = est;
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
                .append(es.toTreeString(level + 1, prefix))
                .append(semicolon.toTreeString(level + 1, prefix))
                .append(est.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}

