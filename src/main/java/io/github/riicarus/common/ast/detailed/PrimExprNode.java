package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * PrimExpr -> ( ValueExprOrFuncInlineDefSufNode | Const | Id FuncCallSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:28
 * @since 1.0.0
 */
public abstract class PrimExprNode extends NonterminalASTNode {

    @Override
    public abstract ExprNode toGeneric();
}
