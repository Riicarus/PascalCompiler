package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * ArithItemSuf -> eps
 *
 * @author Riicarus
 * @create 2023-12-21 11:35
 * @since 1.0.0
 */
public class ArithItemSufEmptyNode extends ArithItemSufNode {

    public static final DetailedASTCreator<ArithItemSufEmptyNode> CREATOR =
            children -> new ArithItemSufEmptyNode();

    @Override
    public String toTreeString(int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(prefix).append(t).append(link).append(symbol);

        return sb.toString();
    }

    @Override
    public BinaryOpNode toGeneric() {
        return null;
    }
}
