package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;
import io.github.riicarus.common.data.ast.TerminalASTNode;

/**
 * AS -> V := AE
 *
 * @author Riicarus
 * @create 2023-12-17 18:01
 * @since 1.0.0
 */
public class ASNode extends NonterminalASTNode {

    public static final ASTCreator<ASNode> CREATOR =
            children -> new ASNode(
                    (VNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (AENode) children.get(2)
            );

    private final VNode v;
    private final TerminalASTNode assign;
    private final AENode ae;

    public ASNode(VNode v, TerminalASTNode assign, AENode ae) {
        this.v = v;
        this.assign = assign;
        this.ae = ae;
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
                .append(v.toTreeString(level + 1, prefix))
                .append(assign.toTreeString(level + 1, prefix))
                .append(ae.toTreeString(level + 1, prefix));

        return sb.toString();
    }

}
