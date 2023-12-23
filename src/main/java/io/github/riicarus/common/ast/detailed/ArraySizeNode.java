package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * ArraySize -> Id | constInt | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:33
 * @since 1.0.0
 */
public abstract class ArraySizeNode extends NonterminalASTNode {
    @Override
    public abstract ExprNode toGeneric();
}
