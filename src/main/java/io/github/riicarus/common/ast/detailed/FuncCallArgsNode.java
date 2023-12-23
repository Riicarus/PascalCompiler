package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionCallNode;

/**
 * FuncCallArgs -> ValueExpr FuncCallArgsSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 11:59
 * @since 1.0.0
 */
public abstract class FuncCallArgsNode extends NonterminalASTNode {

    @Override
    public abstract FunctionCallNode toGeneric();
}
