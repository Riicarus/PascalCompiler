package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;
import io.github.riicarus.common.data.ast.generic.expr.v.VariableNode;
import io.github.riicarus.common.data.ast.generic.type.TypeNode;

/**
 * Define -> Type VarDef
 *
 * @author Riicarus
 * @create 2023-12-21 9:32
 * @since 1.0.0
 */
public class DefineNode extends NonterminalASTNode {

    public static final DetailedASTCreator<DefineNode> CREATOR =
            children -> new DefineNode(
                    (DetailedTypeNode) children.get(0),
                    (VarDefNode) children.get(1)
            );

    private final DetailedTypeNode type;
    private final VarDefNode varDef;

    public DefineNode(DetailedTypeNode type, VarDefNode varDef) {
        this.type = type;
        this.varDef = varDef;
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
                .append(varDef.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public ExprNode toGeneric() {
        TypeNode typeNode = type.toGeneric();
        if (varDef instanceof VarDefToCommonVarNode) {
            ExprNode exprNode = varDef.toGeneric();

            if (exprNode instanceof AssignNode) {   // 如果是赋值语句
                ((AssignNode) exprNode).getLeftOperand().setTypeNode(typeNode);
                return exprNode;
            }

            // 如果只有定义, 没有赋值, 直接返回 varNode
            if (exprNode instanceof VariableNode) {
                ((VariableNode) exprNode).setTypeNode(typeNode);
                return exprNode;
            }

            throw new IllegalStateException("LL1Syntax error: can not cast node into correct type, node: " + exprNode);
        }

        if (varDef instanceof VarDefToFuncVarNode) {
            FunctionNode funcNode = (FunctionNode) varDef.toGeneric();
            funcNode.setReturnType(typeNode);
            return funcNode;
        }

        throw new IllegalStateException("LL1Syntax error: can not cast node into correct type.");
    }
}
