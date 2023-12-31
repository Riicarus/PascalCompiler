package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * RelOp -> < | > | <= | >= | == | !=
 *
 * @author Riicarus
 * @create 2023-12-21 11:11
 * @since 1.0.0
 */
public abstract class RelOpNode extends NonterminalASTNode {

    @Override
    public abstract BinaryOpNode toGeneric();
}
