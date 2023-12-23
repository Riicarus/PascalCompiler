package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.v.ValueNode;
import io.github.riicarus.common.data.ast.generic.type.IntTypeNode;

/**
 * Const -> constInt
 *
 * @author Riicarus
 * @create 2023-12-21 11:51
 * @since 1.0.0
 */
public class ConstToIntNode extends ConstNode {

    public static final DetailedASTCreator<ConstToIntNode> CREATOR =
            children -> new ConstToIntNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode constInt;

    public ConstToIntNode(TerminalASTNode constInt) {
        this.constInt = constInt;
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
                .append(constInt.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ValueNode toGeneric() {
        return new ValueNode(constInt.getToken().getLexeme(), IntTypeNode.getInstance());
    }
}
