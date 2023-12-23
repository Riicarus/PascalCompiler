package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.code.CodeBlockNode;

/**
 * EndElse -> else BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 18:37
 * @since 1.0.0
 */
public class EndElseToElseNode extends EndElseNode {

    public static final DetailedASTCreator<EndElseToElseNode> CREATOR =
            children -> new EndElseToElseNode(
                    (TerminalASTNode) children.get(0),
                    (BracedCodeBlockNode) children.get(1)
            );

    private final TerminalASTNode _else;
    private final BracedCodeBlockNode codeBlock;

    public EndElseToElseNode(TerminalASTNode _else, BracedCodeBlockNode codeBlock) {
        this._else = _else;
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
                .append(_else.toTreeString(level + 1, prefix))
                .append(codeBlock.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public CodeBlockNode toGeneric() {
        return codeBlock.toGeneric();
    }
}
