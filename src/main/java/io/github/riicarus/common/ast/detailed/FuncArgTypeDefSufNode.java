package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.type.FuncTypeNode;

/**
 * FuncArgTypeDefSuf -> , Type FuncArgTypeDefSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:45
 * @since 1.0.0
 */
public abstract class FuncArgTypeDefSufNode extends NonterminalASTNode {
    @Override
    public abstract FuncTypeNode toGeneric();
}
