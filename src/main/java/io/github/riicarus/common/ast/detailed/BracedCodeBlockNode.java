package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * BracedCodeBlock -> { StatementList }
 *
 * @author Riicarus
 * @create 2023-12-21 9:15
 * @since 1.0.0
 */
public class BracedCodeBlockNode extends NonterminalASTNode {

    public static final DetailedASTCreator<BracedCodeBlockNode> CREATOR =
            children -> new BracedCodeBlockNode(
                    (TerminalASTNode) children.get(0),
                    (StatementListNode) children.get(1),
                    (TerminalASTNode) children.get(2)
            );

    private final TerminalASTNode lBrace;
    private final StatementListNode statementList;
    private final TerminalASTNode rBrace;

    public BracedCodeBlockNode(TerminalASTNode lBrace, StatementListNode statementList, TerminalASTNode rBrace) {
        this.lBrace = lBrace;
        this.statementList = statementList;
        this.rBrace = rBrace;
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
                .append(lBrace.toTreeString(level + 1, prefix))
                .append(statementList.toTreeString(level + 1, prefix))
                .append(rBrace.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
