package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.TypeNode;

/**
 * BaseType -> int | bool | float | string
 *
 * @author Riicarus
 * @create 2023-12-21 10:13
 * @since 1.0.0
 */
public abstract class BaseTypeNode extends NonterminalASTNode {
    @Override
    public abstract TypeNode toGeneric();
}
