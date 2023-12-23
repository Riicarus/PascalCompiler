package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.TypeNode;

/**
 * Type -> BaseType TypeSuf | VoidFuncType TypeSuf
 *
 * @author Riicarus
 * @create 2023-12-21 9:51
 * @since 1.0.0
 */
public abstract class DetailedTypeNode extends NonterminalASTNode {
    @Override
    public abstract TypeNode toGeneric();
}