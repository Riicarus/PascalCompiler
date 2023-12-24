package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.ProtoTypeNode;

/**
 * FuncArgListDef -> FuncArgDef FuncArgListDefSuf | eps
 *
 * @author Riicarus
 * @create 2023-12-21 9:59
 * @since 1.0.0
 */
public abstract class FuncArgListDefNode extends NonterminalASTNode {
    @Override
    public abstract ProtoTypeNode toGeneric();
}
