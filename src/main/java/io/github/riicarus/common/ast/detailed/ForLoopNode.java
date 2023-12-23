package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.code.CodeBlockNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForConditionNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForInitNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForUpdateNode;

/**
 * ForLoop -> for (ForInit; ForCondition; ForUpdate) ForBody
 *
 * @author Riicarus
 * @create 2023-12-21 18:39
 * @since 1.0.0
 */
public class ForLoopNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ForLoopNode> CREATOR =
            children -> new ForLoopNode(
                    (TerminalASTNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (DetailedForInitNode) children.get(2),
                    (TerminalASTNode) children.get(3),
                    (DetailedForConditionNode) children.get(4),
                    (TerminalASTNode) children.get(5),
                    (DetailedForUpdateNode) children.get(6),
                    (TerminalASTNode) children.get(7),
                    (ForBodyNode) children.get(8)
            );

    private final TerminalASTNode _for;
    private final TerminalASTNode lParen;
    private final DetailedForInitNode forInit;
    private final TerminalASTNode semicolon1;
    private final DetailedForConditionNode forCondition;
    private final TerminalASTNode semicolon2;
    private final DetailedForUpdateNode forUpdate;
    private final TerminalASTNode rParen;
    private final ForBodyNode forBody;

    public ForLoopNode(TerminalASTNode _for,
                       TerminalASTNode lParen, DetailedForInitNode forInit, TerminalASTNode semicolon1,
                       DetailedForConditionNode forCondition, TerminalASTNode semicolon2,
                       DetailedForUpdateNode forUpdate, TerminalASTNode rParen,
                       ForBodyNode forBody) {
        this._for = _for;
        this.lParen = lParen;
        this.forInit = forInit;
        this.semicolon1 = semicolon1;
        this.forCondition = forCondition;
        this.semicolon2 = semicolon2;
        this.forUpdate = forUpdate;
        this.rParen = rParen;
        this.forBody = forBody;
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
                .append(_for.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(forInit.toTreeString(level + 1, prefix))
                .append(semicolon1.toTreeString(level + 1, prefix))
                .append(forCondition.toTreeString(level + 1, prefix))
                .append(semicolon2.toTreeString(level + 1, prefix))
                .append(forUpdate.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix))
                .append(forBody.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ForNode toGeneric() {
        ForInitNode forInitNode = forInit.toGeneric();
        ForConditionNode forConditionNode = forCondition.toGeneric();
        ForUpdateNode forUpdateNode = forUpdate.toGeneric();
        CodeBlockNode codeBlockNode = forBody.toGeneric();

        return new ForNode(forInitNode, forConditionNode, forUpdateNode, codeBlockNode);
    }
}
