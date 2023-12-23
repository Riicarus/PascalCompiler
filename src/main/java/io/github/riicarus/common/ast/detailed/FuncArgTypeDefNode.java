package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;

/**
 * FuncArgTypeDef -> Type FuncArgTypeDefSufNode | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:28
 * @since 1.0.0
 */
public abstract class FuncArgTypeDefNode extends NonterminalASTNode {
    @Override
    public abstract FuncTypeNode toGeneric();
}
