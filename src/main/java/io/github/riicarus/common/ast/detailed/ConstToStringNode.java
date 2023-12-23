package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.v.ValueNode;
import io.github.riicarus.common.data.ast.generic.type.StringTypeNode;

/**
 * Const -> constString
 *
 * @author Riicarus
 * @create 2023-12-21 11:53
 * @since 1.0.0
 */
public class ConstToStringNode extends ConstNode {

    public static final DetailedASTCreator<ConstToStringNode> CREATOR =
            children -> new ConstToStringNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode constString;

    public ConstToStringNode(TerminalASTNode constString) {
        this.constString = constString;
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
                .append(constString.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ValueNode toGeneric() {
        return new ValueNode(constString.getToken().getLexeme(), StringTypeNode.getInstance());
    }
}
