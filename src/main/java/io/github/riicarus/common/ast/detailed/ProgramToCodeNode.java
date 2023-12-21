package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;

/**
 * Program -> BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 9:08
 * @since 1.0.0
 */
public class ProgramToCodeNode extends ProgramNode {

    public static final DetailedASTCreator<ProgramToCodeNode> CREATOR =
            children -> new ProgramToCodeNode(
                    (BracedCodeBlockNode) children.get(0)
            );

    private final BracedCodeBlockNode codeBlock;

    public ProgramToCodeNode(BracedCodeBlockNode codeBlock) {
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
