package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.code.CodeBlockNode;

/**
 * Program -> BracedCodeBlock | eps
 *
 * @author Riicarus
 * @create 2023-12-21 9:06
 * @since 1.0.0
 */
public abstract class ProgramNode extends NonterminalASTNode {
    @Override
    public abstract CodeBlockNode toGeneric();
}
