package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.BooleanTypeNode;

/**
 * BaseType -> bool
 *
 * @author Riicarus
 * @create 2023-12-21 10:18
 * @since 1.0.0
 */
public class BaseTypeToBoolNode extends BaseTypeNode {

    public static final DetailedASTCreator<BaseTypeToBoolNode> CREATOR =
            children -> new BaseTypeToBoolNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode bool;

    public BaseTypeToBoolNode(TerminalASTNode bool) {
        this.bool = bool;
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
                .append(bool.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public BooleanTypeNode toGeneric() {
        return BooleanTypeNode.getInstance();
    }
}
