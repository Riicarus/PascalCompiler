package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.type.ProtoTypeNode;

/**
 * FuncArgListDef -> FuncArgDef FuncArgListDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:02
 * @since 1.0.0
 */
public class FuncArgListDefToFuncArgDefNode extends FuncArgListDefNode {

    public static final DetailedASTCreator<FuncArgListDefToFuncArgDefNode> CREATOR =
            children -> new FuncArgListDefToFuncArgDefNode(
                    (FuncArgDefNode) children.get(0),
                    (FuncArgListDefSufNode) children.get(1)
            );

    private final FuncArgDefNode funcArgDef;
    private final FuncArgListDefSufNode funcArgListDefSuf;

    public FuncArgListDefToFuncArgDefNode(FuncArgDefNode funcArgDef, FuncArgListDefSufNode funcArgListDefSuf) {
        this.funcArgDef = funcArgDef;
        this.funcArgListDefSuf = funcArgListDefSuf;
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
                .append(funcArgDef.toTreeString(level + 1, prefix))
                .append(funcArgListDefSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ProtoTypeNode toGeneric() {
        ProtoTypeNode protoNode = funcArgListDefSuf.toGeneric();
        if (protoNode == null) {
            protoNode = new ProtoTypeNode();
        }

        protoNode.addArgNode(funcArgDef.toGeneric());
        return protoNode;
    }
}
