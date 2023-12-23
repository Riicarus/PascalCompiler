package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.code.StatementNode;

/**
 * Statement -> Define | AssignOrFuncCall | Control | BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 9:25
 * @since 1.0.0
 */
public abstract class DetailedStatementNode extends NonterminalASTNode {
    @Override
    public abstract StatementNode toGeneric();
}
