package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ForInitNode;

/**
 * ForInit -> ForInitList | eps
 *
 * @author Riicarus
 * @create 2023-12-21 18:40
 * @since 1.0.0
 */
public abstract class DetailedForInitNode extends NonterminalASTNode {
    @Override
    public abstract ForInitNode toGeneric();
}
