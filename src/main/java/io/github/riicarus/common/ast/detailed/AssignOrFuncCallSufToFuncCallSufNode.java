package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * AssignOrFuncCallSuf -> FuncCallSuf
 *
 * @author Riicarus
 * @create 2023-12-21 9:44
 * @since 1.0.0
 */
public class AssignOrFuncCallSufToFuncCallSufNode extends AssignOrFuncCallSufNode {

    public static final DetailedASTCreator<AssignOrFuncCallSufToFuncCallSufNode> CREATOR =
            children -> new AssignOrFuncCallSufToFuncCallSufNode(
                    (FuncCallSufNode) children.get(0)
            );

    private final FuncCallSufNode funcCallSuf;

    public AssignOrFuncCallSufToFuncCallSufNode(FuncCallSufNode funcCallSuf) {
        this.funcCallSuf = funcCallSuf;
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
                .append(funcCallSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
