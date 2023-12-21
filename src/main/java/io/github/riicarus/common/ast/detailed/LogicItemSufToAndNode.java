package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * LogicItemSuf -> & LogicFactor LogicItemSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:02
 * @since 1.0.0
 */
public class LogicItemSufToAndNode extends LogicItemSufNode {

    public static final DetailedASTCreator<LogicItemSufToAndNode> CREATOR =
            children -> new LogicItemSufToAndNode(
                    (TerminalASTNode) children.get(0),
                    (LogicFactorNode) children.get(1),
                    (LogicItemSufNode) children.get(2)
            );

    private final TerminalASTNode and;
    private final LogicFactorNode logicFactor;
    private final LogicItemSufNode logicItemSuf;

    public LogicItemSufToAndNode(TerminalASTNode and, LogicFactorNode logicFactor, LogicItemSufNode logicItemSuf) {
        this.and = and;
        this.logicFactor = logicFactor;
        this.logicItemSuf = logicItemSuf;
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
                .append(and.toTreeString(level + 1, prefix))
                .append(logicFactor.toTreeString(level + 1, prefix))
                .append(logicItemSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
