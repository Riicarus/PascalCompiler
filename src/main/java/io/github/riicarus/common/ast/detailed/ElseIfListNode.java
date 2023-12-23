package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ctrl.ElseNode;

/**
 * ElseIfList -> ElseIf ElseIfList | eps
 *
 * @author Riicarus
 * @create 2023-12-21 18:30
 * @since 1.0.0
 */
public abstract class ElseIfListNode extends NonterminalASTNode {
    @Override
    public abstract ElseNode toGeneric();
}
