package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.IntTypeNode;

/**
 * BaseType -> int
 *
 * @author Riicarus
 * @create 2023-12-21 10:17
 * @since 1.0.0
 */
public class BaseTypeToIntNode extends BaseTypeNode {

    public static final DetailedASTCreator<BaseTypeToIntNode> CREATOR =
            children -> new BaseTypeToIntNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode _int;

    public BaseTypeToIntNode(TerminalASTNode _int) {
        this._int = _int;
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
                .append(_int.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public IntTypeNode toGeneric() {
        return new IntTypeNode();
    }
}
