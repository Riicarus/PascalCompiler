package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.func.FunctionCallNode;

/**
 * FuncCallSuf -> (FuncCallArgs) | eps
 *
 * @author Riicarus
 * @create 2023-12-21 9:45
 * @since 1.0.0
 */
public abstract class FuncCallSufNode extends NonterminalASTNode {

    @Override
    public abstract FunctionCallNode toGeneric();
}
