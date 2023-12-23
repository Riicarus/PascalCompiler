package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * ValueExprOrFuncInlineDefSuf -> ValueExpr ) | FuncInlineDefSuf
 *
 * @author Riicarus
 * @create 2023-12-21 11:37
 * @since 1.0.0
 */
public abstract class ValueExprOrFuncInlineDefSufNode extends NonterminalASTNode {
    @Override
    public abstract ExprNode toGeneric();
}
