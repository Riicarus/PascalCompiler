package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.v.FunctionNode;
import io.github.riicarus.common.data.ast.generic.ProtoTypeNode;

/**
 * VarDef -> func Id(FuncArgListDef) BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 9:54
 * @since 1.0.0
 */
public class VarDefToFuncVarNode extends VarDefNode {

    public static final DetailedASTCreator<VarDefToFuncVarNode> CREATOR =
            children -> new VarDefToFuncVarNode(
                    (TerminalASTNode) children.get(0),
                    (DetailedIdNode) children.get(1),
                    (TerminalASTNode) children.get(2),
                    (FuncArgListDefNode) children.get(3),
                    (TerminalASTNode) children.get(4),
                    (BracedCodeBlockNode) children.get(5)
            );

    private final TerminalASTNode func;
    private final DetailedIdNode id;
    private final TerminalASTNode lParen;
    private final FuncArgListDefNode funcArgListDef;
    private final TerminalASTNode rParen;
    private final BracedCodeBlockNode bracedCodeBlock;

    public VarDefToFuncVarNode(TerminalASTNode func, DetailedIdNode id,
                               TerminalASTNode lParen, FuncArgListDefNode funcArgListDef, TerminalASTNode rParen,
                               BracedCodeBlockNode bracedCodeBlock) {
        this.func = func;
        this.id = id;
        this.lParen = lParen;
        this.funcArgListDef = funcArgListDef;
        this.rParen = rParen;
        this.bracedCodeBlock = bracedCodeBlock;
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
                .append(func.toTreeString(level + 1, prefix))
                .append(id.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(funcArgListDef.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix))
                .append(bracedCodeBlock.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FunctionNode toGeneric() {
        ProtoTypeNode protoNode = funcArgListDef.toGeneric();
        protoNode.setCodeBlockNode(bracedCodeBlock.toGeneric());
        FunctionNode functionNode = new FunctionNode(id.toGeneric());
        functionNode.setProtoTypeNode(protoNode);

        return functionNode;
    }
}
