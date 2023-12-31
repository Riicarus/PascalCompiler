package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * RetValue -> ValueExpr | eps
 *
 * @author Riicarus
 * @create 2023-12-21 18:17
 * @since 1.0.0
 */
public abstract class RetValueNode extends NonterminalASTNode {
    @Override
    public abstract ExprNode toGeneric();
}
