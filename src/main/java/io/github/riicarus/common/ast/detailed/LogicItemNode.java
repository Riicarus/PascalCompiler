package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * LogicItem -> LogicFactor LogicItemSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:53
 * @since 1.0.0
 */
public class LogicItemNode extends NonterminalASTNode {

    public static final DetailedASTCreator<LogicItemNode> CREATOR =
            children -> new LogicItemNode(
                    (LogicFactorNode) children.get(0),
                    (LogicItemSufNode) children.get(1)
            );

    private final LogicFactorNode logicFactor;
    private final LogicItemSufNode logicItemSuf;

    public LogicItemNode(LogicFactorNode logicFactor, LogicItemSufNode logicItemSuf) {
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
                .append(logicFactor.toTreeString(level + 1, prefix))
                .append(logicItemSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
