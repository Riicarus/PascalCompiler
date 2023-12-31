package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForInitNode;

/**
 * ForInitListSuf -> , ForAssignOrDefine ForInitListSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 18:52
 * @since 1.0.0
 */
public abstract class ForInitListSufNode extends NonterminalASTNode {
    @Override
    public abstract ForInitNode toGeneric();
}
