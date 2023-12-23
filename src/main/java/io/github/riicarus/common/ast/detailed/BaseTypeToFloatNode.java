package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.FloatTypeNode;

/**
 * BaseType -> float
 *
 * @author Riicarus
 * @create 2023-12-21 10:19
 * @since 1.0.0
 */
public class BaseTypeToFloatNode extends BaseTypeNode {

    public static final DetailedASTCreator<BaseTypeToFloatNode> CREATOR =
            children -> new BaseTypeToFloatNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode _float;

    public BaseTypeToFloatNode(TerminalASTNode _float) {
        this._float = _float;
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
                .append(_float.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FloatTypeNode toGeneric() {
        return FloatTypeNode.getInstance();
    }
}
