package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * AE' -> - I AE'
 *
 * @author Riicarus
 * @create 2023-12-17 18:02
 * @since 1.0.0
 */
public class AEPlusToMinusNode extends AEPlusNode {

    public static final ASTCreator<AEPlusToMinusNode> CREATOR =
            children -> new AEPlusToMinusNode(
                    (TerminalASTNode) children.get(0),
                    (INode) children.get(1),
                    (AEPlusNode) children.get(2)
            );

    private final TerminalASTNode minus;
    private final INode i;
    private final AEPlusNode aePlus;

    public AEPlusToMinusNode(TerminalASTNode minus, INode i, AEPlusNode aePlus) {
        this.minus = minus;
        this.i = i;
        this.aePlus = aePlus;
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
                .append(minus.toTreeString(level + 1, prefix))
                .append(i.toTreeString(level + 1, prefix))
                .append(aePlus.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
