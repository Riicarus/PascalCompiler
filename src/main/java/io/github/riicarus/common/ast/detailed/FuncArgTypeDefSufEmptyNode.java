package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * FuncArgTypeDefSuf -> eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:48
 * @since 1.0.0
 */
public class FuncArgTypeDefSufEmptyNode extends FuncArgTypeDefSufNode {

    public static final DetailedASTCreator<FuncArgTypeDefSufEmptyNode> CREATOR =
            children -> new FuncArgTypeDefSufEmptyNode();

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
    public GenericASTNode simplify() {
        return null;
    }
}