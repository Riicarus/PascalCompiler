package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * ArithItemSuf -> * PrimExpr ArithItemSuf | / PrimExpr ArithItemSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 11:29
 * @since 1.0.0
 */
public abstract class ArithItemSufNode extends NonterminalASTNode {
    @Override
    public abstract BinaryOpNode toGeneric();

}
