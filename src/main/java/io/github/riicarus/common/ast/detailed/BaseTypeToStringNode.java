package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.StringTypeNode;

/**
 * BaseType -> string
 *
 * @author Riicarus
 * @create 2023-12-21 10:20
 * @since 1.0.0
 */
public class BaseTypeToStringNode extends BaseTypeNode {

    public static final DetailedASTCreator<BaseTypeToStringNode> CREATOR =
            children -> new BaseTypeToStringNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode string;

    public BaseTypeToStringNode(TerminalASTNode string) {
        this.string = string;
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
                .append(string == null ? "" : string.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public StringTypeNode toGeneric() {
        return StringTypeNode.getInstance();
    }
}
