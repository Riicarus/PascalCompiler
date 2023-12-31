package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.ProtoTypeNode;

/**
 * FuncArgListDef -> eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:03
 * @since 1.0.0
 */
public class FuncArgListDefEmptyNode extends FuncArgListDefNode {

    public static final DetailedASTCreator<FuncArgListDefEmptyNode> CREATOR =
            children -> new FuncArgListDefEmptyNode();

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
    public ProtoTypeNode toGeneric() {
        return null;
    }
}
