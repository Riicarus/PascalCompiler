package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.op.abstruct.BinaryOpNode;

/**
 * LogicItemSuf -> & LogicFactor LogicItemSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:58
 * @since 1.0.0
 */
public abstract class LogicItemSufNode extends NonterminalASTNode {
    @Override
    public abstract BinaryOpNode toGeneric();
}
