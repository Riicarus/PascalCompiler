package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.code.CodeBlockNode;

/**
 * EndElse -> else BracedCodeBlock | eps
 *
 * @author Riicarus
 * @create 2023-12-21 18:36
 * @since 1.0.0
 */
public abstract class EndElseNode extends NonterminalASTNode {
    @Override
    public abstract CodeBlockNode toGeneric();
}
