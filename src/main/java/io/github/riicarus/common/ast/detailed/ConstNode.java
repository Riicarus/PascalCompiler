package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.v.ValueNode;

/**
 * Const -> constInt | constFloat | constString | true | false | null
 *
 * @author Riicarus
 * @create 2023-12-21 11:39
 * @since 1.0.0
 */
public abstract class ConstNode extends NonterminalASTNode {
    @Override
    public abstract ValueNode toGeneric();
}
