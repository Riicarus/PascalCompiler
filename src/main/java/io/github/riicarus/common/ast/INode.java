package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;

/**
 * I -> F I'
 *
 * @author Riicarus
 * @create 2023-12-17 18:03
 * @since 1.0.0
 */
public class INode extends NonterminalASTNode {

    public static final ASTCreator<INode> CREATOR =
            children -> new INode(
                    (FNode) children.get(0),
                    (IPlusNode) children.get(1)
            );

    private final FNode f;
    private final IPlusNode iPlus;

    public INode(FNode f, IPlusNode iPlus) {
        this.f = f;
        this.iPlus = iPlus;
    }

    @Override
    public String toTreeString(int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        String t = "\t".repeat(Math.max(0, level - 1));
        String link = level == 0 ? "" : "|--- ";

        if (level != 0) {
            sb.append("\r\n");
        }

        sb.append(prefix).append(t).append(link).append(symbol == null ? "" : symbol)
                .append(f.toTreeString(level + 1, prefix))
                .append(iPlus.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
