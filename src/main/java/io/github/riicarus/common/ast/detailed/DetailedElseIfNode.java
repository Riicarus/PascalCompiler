package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ElseIfNode;

/**
 * ElseIf -> elseif (ValueExpr) BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 18:32
 * @since 1.0.0
 */
public class DetailedElseIfNode extends NonterminalASTNode {

    public static final DetailedASTCreator<DetailedElseIfNode> CREATOR =
            children -> new DetailedElseIfNode(
                    (TerminalASTNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (ValueExprNode) children.get(2),
                    (TerminalASTNode) children.get(3),
                    (BracedCodeBlockNode) children.get(4)
            );

    private final TerminalASTNode elseif;
    private final TerminalASTNode lParen;
    private final ValueExprNode valueExpr;
    private final TerminalASTNode rParen;
    private final BracedCodeBlockNode codeBlock;

    public DetailedElseIfNode(TerminalASTNode elseif,
                              TerminalASTNode lParen, ValueExprNode valueExpr, TerminalASTNode rParen,
                              BracedCodeBlockNode codeBlock) {
        this.elseif = elseif;
        this.lParen = lParen;
        this.valueExpr = valueExpr;
        this.rParen = rParen;
        this.codeBlock = codeBlock;
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
                .append(elseif.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(valueExpr.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix))
                .append(codeBlock.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ElseIfNode toGeneric() {
        ElseIfNode elseIfNode = new ElseIfNode();
        elseIfNode.setConditionNode(valueExpr.toGeneric());
        elseIfNode.setCodeBlockNode(codeBlock.toGeneric());

        return elseIfNode;
    }
}
