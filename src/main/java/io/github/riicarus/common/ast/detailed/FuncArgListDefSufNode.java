package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.ProtoTypeNode;

/**
 * FuncArgListDefSuf -> , FuncArgDef FuncArgListDefSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 10:05
 * @since 1.0.0
 */
public abstract class FuncArgListDefSufNode extends NonterminalASTNode {
    @Override
    public abstract ProtoTypeNode toGeneric();
}
