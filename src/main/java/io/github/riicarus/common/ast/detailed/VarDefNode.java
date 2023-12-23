package io.github.riicarus.common.ast.detailed;

import io.github.riicarus.common.data.ast.detailed.NonterminalASTNode;
import io.github.riicarus.common.data.ast.generic.expr.ExprNode;

/**
 * VarDef -> Id VarInit | func Id(FuncArgListDef) BracedCodeBlock
 *
 * @author Riicarus
 * @create 2023-12-21 9:51
 * @since 1.0.0
 */
public abstract class VarDefNode extends NonterminalASTNode {
    @Override
    public abstract ExprNode toGeneric();
}
