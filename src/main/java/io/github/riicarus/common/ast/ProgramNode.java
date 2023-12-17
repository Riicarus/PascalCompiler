package io.github.riicarus.common.ast;

import io.github.riicarus.common.data.ast.ASTCreator;
import io.github.riicarus.common.data.ast.NonterminalASTNode;

/**
 * <p>程序 AST 节点</p>
 * <p>P -> SP</p>
 *
 * @author Riicarus
 * @create 2023-12-17 5:27
 * @since 1.0.0
 */
public class ProgramNode extends NonterminalASTNode {

    public static final ASTCreator<ProgramNode> CREATOR =
            children -> new ProgramNode(
                    (SubProgramNode) children.get(0)
            );

    private final SubProgramNode subProgram;

    public ProgramNode(SubProgramNode subProgram) {
        this.subProgram = subProgram;
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
                .append(subProgram.toTreeString(level + 1, prefix));

        return sb.toString();
    }
}
