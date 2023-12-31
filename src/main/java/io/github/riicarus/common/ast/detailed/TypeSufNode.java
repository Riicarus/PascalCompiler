package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;

/**
 * TypeSuf -> function(FuncArgTypeDef) TypeSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:22
 * @since 1.0.0
 */
public abstract class TypeSufNode extends NonterminalASTNode {
    @Override
    public abstract FuncTypeNode toGeneric();
}
