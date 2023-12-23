package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.v.ValueNode;
import io.github.riicarus.common.data.ast.generic.type.IntTypeNode;

/**
 * ArraySize -> constInt
 *
 * @author Riicarus
 * @create 2023-12-21 10:35
 * @since 1.0.0
 */
public class ArraySizeToConstIntNode extends ArraySizeNode {

    public static final DetailedASTCreator<ArraySizeToConstIntNode> CREATOR =
            children -> new ArraySizeToConstIntNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode constInt;

    public ArraySizeToConstIntNode(TerminalASTNode constInt) {
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
    public ExprNode toGeneric() {
        return new ValueNode(constInt.getToken().getLexeme(), IntTypeNode.getInstance());
    }
}
