package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * CS -> if CE then ES else ES
 *
 * @author Riicarus
 * @create 2023-12-17 18:07
 * @since 1.0.0
 */
public class CSNode extends NonterminalASTNode {

    public static final ASTCreator<CSNode> CREATOR =
            children -> new CSNode(
                    (TerminalASTNode) children.get(0),
                    (CENode) children.get(1),
                    (TerminalASTNode) children.get(2),
                    (ESNode) children.get(3),
                    (TerminalASTNode) children.get(4),
                    (ESNode) children.get(5)
            );

    private final TerminalASTNode _if;
    private final CENode ce;
    private final TerminalASTNode _then;
    private final ESNode thenEs;
    private final TerminalASTNode _else;
    private final ESNode elseEs;

    public CSNode(TerminalASTNode anIf, CENode ce, TerminalASTNode then, ESNode thenEs, TerminalASTNode anElse, ESNode elseEs) {
        _if = anIf;
        this.ce = ce;
        _then = then;
        this.thenEs = thenEs;
        _else = anElse;
        this.elseEs = elseEs;
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
                .append(_if.toTreeString(level + 1, prefix))
                .append(ce.toTreeString(level + 1, prefix))
                .append(_then.toTreeString(level + 1, prefix))
                .append(thenEs.toTreeString(level + 1, prefix))
                .append(_else.toTreeString(level + 1, prefix))
                .append(elseEs.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
