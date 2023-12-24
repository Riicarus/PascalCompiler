package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.detailed.TerminalASTNode;
import io.github.riicarus.common.data.ast.generic.ProtoTypeNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionNode;

/**
 * FuncInlineDefine -> Type (FuncArgListDef) => BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 11:46
 * @since 1.0.0
 */
public class FuncInlineDefineNode extends NonterminalASTNode {

    public static final DetailedASTCreator<FuncInlineDefineNode> CREATOR =
            children -> new FuncInlineDefineNode(
                    (DetailedTypeNode) children.get(0),
                    (TerminalASTNode) children.get(1),
                    (FuncArgListDefNode) children.get(2),
                    (TerminalASTNode) children.get(3),
                    (TerminalASTNode) children.get(4),
                    (BracedCodeBlockNode) children.get(5)
            );

    private final DetailedTypeNode type;
    private final TerminalASTNode lParen;
    private final FuncArgListDefNode funcArgListDef;
    private final TerminalASTNode rParen;
    private final TerminalASTNode funcAssign;
    private final BracedCodeBlockNode bracedCodeBlock;

    public FuncInlineDefineNode(DetailedTypeNode type, TerminalASTNode lParen, FuncArgListDefNode funcArgListDef, TerminalASTNode rParen,
                                TerminalASTNode funcAssign, BracedCodeBlockNode bracedCodeBlock) {
        this.type = type;
        this.lParen = lParen;
        this.funcArgListDef = funcArgListDef;
        this.rParen = rParen;
        this.funcAssign = funcAssign;
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
                .append(type.toTreeString(level + 1, prefix))
                .append(lParen.toTreeString(level + 1, prefix))
                .append(funcArgListDef.toTreeString(level + 1, prefix))
                .append(rParen.toTreeString(level + 1, prefix))
                .append(funcAssign.toTreeString(level + 1, prefix))
                .append(bracedCodeBlock.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FunctionNode toGeneric() {
        ProtoTypeNode protoNode = funcArgListDef.toGeneric();
        protoNode.setBody(bracedCodeBlock.toGeneric());

        FunctionNode functionNode = new FunctionNode();
        functionNode.setProtoTypeNode(protoNode);
        functionNode.setReturnType(type.toGeneric());

        return functionNode;
    }
}
