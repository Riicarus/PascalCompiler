package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * ForBody -> BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 18:41
 * @since 1.0.0
 */
public class ForBodyNode extends NonterminalASTNode {

    public static final DetailedASTCreator<ForBodyNode> CREATOR =
            children -> new ForBodyNode(
                    (BracedCodeBlockNode) children.get(0)
            );

    private final BracedCodeBlockNode codeBlock;

    public ForBodyNode(BracedCodeBlockNode codeBlock) {
        this.codeBlock = codeBlock;
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
                .append(codeBlock.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode simplify() {
        return null;
    }
}
