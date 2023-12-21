package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * VarInit -> ;
 *
 * @author Riicarus
 * @create 2023-12-21 9:57
 * @since 1.0.0
 */
public class VarInitToSemicolonNode extends VarInitNode {

    public static final DetailedASTCreator<VarInitToSemicolonNode> CREATOR =
            children -> new VarInitToSemicolonNode(
                    (TerminalASTNode) children.get(0)
            );

    private final TerminalASTNode semicolon;

    public VarInitToSemicolonNode(TerminalASTNode semicolon) {
        this.semicolon = semicolon;
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
                .append(semicolon.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
