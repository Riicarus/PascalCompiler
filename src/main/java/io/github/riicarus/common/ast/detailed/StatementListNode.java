package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.code.StatementNode;

/**
 * StatementList -> Statement StatementList | eps
 *
 * @author Riicarus
 * @create 2023-12-21 9:19
 * @since 1.0.0
 */
public abstract class StatementListNode extends NonterminalASTNode {
    @Override
    public abstract StatementNode toGeneric();
}
