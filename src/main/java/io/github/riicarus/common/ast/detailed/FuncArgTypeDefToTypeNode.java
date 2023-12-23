package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;

/**
 * FuncArgTypeDef -> Type FuncArgTypeDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 10:43
 * @since 1.0.0
 */
public class FuncArgTypeDefToTypeNode extends FuncArgTypeDefNode {

    public static final DetailedASTCreator<FuncArgTypeDefToTypeNode> CREATOR =
            children -> new FuncArgTypeDefToTypeNode(
                    (DetailedTypeNode) children.get(0),
                    (FuncArgTypeDefSufNode) children.get(1)
            );

    private final DetailedTypeNode type;
    private final FuncArgTypeDefSufNode funcArgTypeDefSuf;

    public FuncArgTypeDefToTypeNode(DetailedTypeNode type, FuncArgTypeDefSufNode funcArgTypeDefSuf) {
        this.type = type;
        this.funcArgTypeDefSuf = funcArgTypeDefSuf;
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
                .append(funcArgTypeDefSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public FuncTypeNode toGeneric() {
        FuncTypeNode funcTypeNode = funcArgTypeDefSuf.toGeneric();
        if (funcTypeNode == null) {
            funcTypeNode = new FuncTypeNode();
        }

        funcTypeNode.addArgType(type.toGeneric());
        return funcTypeNode;
    }
}
