package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * LogicExprSuf -> | LogicItem LogicExprSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:53
 * @since 1.0.0
 */
public abstract class LogicExprSufNode extends NonterminalASTNode {
    @Override
    public abstract BinaryOpNode toGeneric();
}
