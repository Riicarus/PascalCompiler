package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.compute.AssignNode;

/**
 * ForAssignOrDefine -> Type Id AssignSuf | Id AssignSuf
 *
 * @author Riicarus
 * @create 2023-12-21 18:51
 * @since 1.0.0
 */
public abstract class ForAssignOrDefineNode extends NonterminalASTNode {
    @Override
    public abstract AssignNode toGeneric();
}
