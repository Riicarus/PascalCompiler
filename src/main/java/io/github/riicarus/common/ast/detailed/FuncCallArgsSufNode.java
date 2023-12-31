package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionCallNode;

/**
 * FuncCallArgsSuf -> , ValueExpr FuncCallArgsSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 12:01
 * @since 1.0.0
 */
public abstract class FuncCallArgsSufNode extends NonterminalASTNode {

    @Override
    public abstract FunctionCallNode toGeneric();
}
