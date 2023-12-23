package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForUpdateNode;

/**
 * ForUpdateListSuf -> , Id AssignSuf ForUpdateListSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 19:10
 * @since 1.0.0
 */
public abstract class ForUpdateListSufNode extends NonterminalASTNode {
    @Override
    public abstract ForUpdateNode toGeneric();
}
