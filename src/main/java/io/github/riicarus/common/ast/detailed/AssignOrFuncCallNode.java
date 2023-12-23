package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.DetailedASTCreator;
import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.GenericASTNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionCallNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;
import io.github.riicarus.common.data.ast.generic.expr.v.VariableNode;

/**
 * AssignOrFuncCall -> Id AssignOrFuncCallSuf
 *
 * @author Riicarus
 * @create 2023-12-21 9:33
 * @since 1.0.0
 */
public class AssignOrFuncCallNode extends NonterminalASTNode {

    public static final DetailedASTCreator<AssignOrFuncCallNode> CREATOR =
            children -> new AssignOrFuncCallNode(
                    (DetailedIdNode) children.get(0),
                    (AssignOrFuncCallSufNode) children.get(1)
            );

    private final DetailedIdNode id;
    private final AssignOrFuncCallSufNode assignOrFuncCallSuf;

    public AssignOrFuncCallNode(DetailedIdNode id, AssignOrFuncCallSufNode assignOrFuncCallSuf) {
        this.id = id;
        this.assignOrFuncCallSuf = assignOrFuncCallSuf;
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
                .append(id.toTreeString(level + 1, prefix))
                .append(assignOrFuncCallSuf.toTreeString(level + 1, prefix));

        return sb.toString();
    }

    @Override
    public GenericASTNode toGeneric() {
        VariableNode varNode = id.toGeneric();

        if (assignOrFuncCallSuf instanceof AssignOrFuncCallSufToFuncCallSufNode) {
            FunctionCallNode funcCallNode = (FunctionCallNode) assignOrFuncCallSuf.toGeneric();
            funcCallNode.setFuncId(varNode);
            return funcCallNode;
        } else if (assignOrFuncCallSuf instanceof AssignOrFuncCallSufToAssignSufNode) {
            AssignNode assignNode = (AssignNode) assignOrFuncCallSuf.toGeneric();
            assignNode.setLeftOperand(varNode);
            return assignNode;
        } else {
            throw new IllegalStateException("LL1Syntax error, can not cast ast node into correct typeNode, node: " + assignOrFuncCallSuf);
        }
    }
}
