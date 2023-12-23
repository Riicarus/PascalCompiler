package io.github.riicarus.front.syntax;

import io.github.riicarus.common.ast.detailed.*;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxInlineDefiner;
import io.github.riicarus.front.syntax.ll1.LL1SyntaxSymbol;
import io.github.riicarus.front.syntax.ll1.LL1Syntaxer;

import java.util.List;

/**
 * 类 Pascal 文法定义
 *
 * @author Riicarus
 * @create 2023-12-9 15:10
 * @since 1.0.0
 */
public class PascalSyntax {

    private static final SyntaxSymbol eps = new LL1SyntaxSymbol("eps", true);
    private static final SyntaxSymbol _int = new LL1SyntaxSymbol("int", true);
    private static final SyntaxSymbol bool = new LL1SyntaxSymbol("bool", true);
    private static final SyntaxSymbol _float = new LL1SyntaxSymbol("float", true);
    private static final SyntaxSymbol string = new LL1SyntaxSymbol("string", true);
    private static final SyntaxSymbol _void = new LL1SyntaxSymbol("void", true);
    private static final SyntaxSymbol _null = new LL1SyntaxSymbol("null", true);
    private static final SyntaxSymbol function = new LL1SyntaxSymbol("function", true);
    private static final SyntaxSymbol func = new LL1SyntaxSymbol("func", true);
    private static final SyntaxSymbol _continue = new LL1SyntaxSymbol("continue", true);
    private static final SyntaxSymbol _break = new LL1SyntaxSymbol("break", true);
    private static final SyntaxSymbol _return = new LL1SyntaxSymbol("return", true);
    private static final SyntaxSymbol _if = new LL1SyntaxSymbol("if", true);
    private static final SyntaxSymbol _else = new LL1SyntaxSymbol("else", true);
    private static final SyntaxSymbol elseif = new LL1SyntaxSymbol("elseif", true);
    private static final SyntaxSymbol _for = new LL1SyntaxSymbol("for", true);
    private static final SyntaxSymbol _true = new LL1SyntaxSymbol("true", true);
    private static final SyntaxSymbol _false = new LL1SyntaxSymbol("false", true);

    private static final SyntaxSymbol identifier = new LL1SyntaxSymbol("identifier", true);
    private static final SyntaxSymbol constInt = new LL1SyntaxSymbol("constInt", true);
    private static final SyntaxSymbol constString = new LL1SyntaxSymbol("constString", true);
    private static final SyntaxSymbol constFloat = new LL1SyntaxSymbol("constFloat", true);

    private static final SyntaxSymbol eq = new LL1SyntaxSymbol("==", true);
    private static final SyntaxSymbol ne = new LL1SyntaxSymbol("!=", true);
    private static final SyntaxSymbol le = new LL1SyntaxSymbol("<=", true);
    private static final SyntaxSymbol lt = new LL1SyntaxSymbol("<", true);
    private static final SyntaxSymbol ge = new LL1SyntaxSymbol(">=", true);
    private static final SyntaxSymbol gt = new LL1SyntaxSymbol(">", true);
    private static final SyntaxSymbol minus = new LL1SyntaxSymbol("-", true);
    private static final SyntaxSymbol plus = new LL1SyntaxSymbol("+", true);
    private static final SyntaxSymbol times = new LL1SyntaxSymbol("*", true);
    private static final SyntaxSymbol divides = new LL1SyntaxSymbol("/", true);
    private static final SyntaxSymbol or = new LL1SyntaxSymbol("|", true);
    private static final SyntaxSymbol and = new LL1SyntaxSymbol("&", true);
    private static final SyntaxSymbol not = new LL1SyntaxSymbol("!", true);
    private static final SyntaxSymbol assign = new LL1SyntaxSymbol(":=", true);
    private static final SyntaxSymbol funcArgTrans = new LL1SyntaxSymbol("=>", true);
    private static final SyntaxSymbol rParen = new LL1SyntaxSymbol(")", true);
    private static final SyntaxSymbol lParen = new LL1SyntaxSymbol("(", true);
    private static final SyntaxSymbol lBracket = new LL1SyntaxSymbol("[", true);
    private static final SyntaxSymbol rBracket = new LL1SyntaxSymbol("]", true);
    private static final SyntaxSymbol lBrace = new LL1SyntaxSymbol("{", true);
    private static final SyntaxSymbol rBrace = new LL1SyntaxSymbol("}", true);
    private static final SyntaxSymbol semicolon = new LL1SyntaxSymbol(";", true);
    private static final SyntaxSymbol colon = new LL1SyntaxSymbol(",", true);

    private static final SyntaxSymbol Program = new LL1SyntaxSymbol("Program");
    private static final SyntaxSymbol NonNullCodeBlock = new LL1SyntaxSymbol("NonNullCodeBlock");
    private static final SyntaxSymbol BracedCodeBlock = new LL1SyntaxSymbol("BracedCodeBlock");
    private static final SyntaxSymbol Statement = new LL1SyntaxSymbol("Statement");
    private static final SyntaxSymbol AssignOrFuncCall = new LL1SyntaxSymbol("AssignOrFuncCall");
    private static final SyntaxSymbol AssignOrFuncCallSuf = new LL1SyntaxSymbol("AssignOrFuncCallSuf");
    private static final SyntaxSymbol AssignSuf = new LL1SyntaxSymbol("AssignSuf");
    private static final SyntaxSymbol StatementList = new LL1SyntaxSymbol("StatementList");

    private static final SyntaxSymbol Define = new LL1SyntaxSymbol("Define");
    private static final SyntaxSymbol VarDef = new LL1SyntaxSymbol("VarDef");
    private static final SyntaxSymbol Id = new LL1SyntaxSymbol("Id");
    private static final SyntaxSymbol VarInit = new LL1SyntaxSymbol("VarInit");
    private static final SyntaxSymbol FuncArgListDef = new LL1SyntaxSymbol("FuncArgListDef");
    private static final SyntaxSymbol FuncArgListDefSuf = new LL1SyntaxSymbol("FuncArgListDefSuf");
    private static final SyntaxSymbol FuncArgDef = new LL1SyntaxSymbol("FuncArgDef");
    private static final SyntaxSymbol Type = new LL1SyntaxSymbol("Type");
    private static final SyntaxSymbol TypeSuf = new LL1SyntaxSymbol("TypeSuf");
    private static final SyntaxSymbol BaseType = new LL1SyntaxSymbol("BaseType");
    private static final SyntaxSymbol VoidFuncType = new LL1SyntaxSymbol("VoidFuncType");
    private static final SyntaxSymbol FuncArgTypeDef = new LL1SyntaxSymbol("FuncArgTypeDef");
    private static final SyntaxSymbol FuncArgTypeDefSuf = new LL1SyntaxSymbol("FuncArgTypeDefSuf");

    private static final SyntaxSymbol ValueExpr = new LL1SyntaxSymbol("ValueExpr");
    private static final SyntaxSymbol LogicExprSuf = new LL1SyntaxSymbol("LogicExprSuf");
    private static final SyntaxSymbol LogicItem = new LL1SyntaxSymbol("LogicItem");
    private static final SyntaxSymbol LogicItemSuf = new LL1SyntaxSymbol("LogicItemSuf");
    private static final SyntaxSymbol LogicFactor = new LL1SyntaxSymbol("LogicFactor");
    private static final SyntaxSymbol RelExpr = new LL1SyntaxSymbol("RelExpr");
    private static final SyntaxSymbol RelExprSuf = new LL1SyntaxSymbol("RelExprSuf");
    private static final SyntaxSymbol RelOp = new LL1SyntaxSymbol("RelOp");
    private static final SyntaxSymbol ArithExpr = new LL1SyntaxSymbol("ArithExpr");
    private static final SyntaxSymbol ArithExprSuf = new LL1SyntaxSymbol("ArithExprSuf");
    private static final SyntaxSymbol ArithItem = new LL1SyntaxSymbol("ArithItem");
    private static final SyntaxSymbol ArithItemSuf = new LL1SyntaxSymbol("ArithItemSuf");
    private static final SyntaxSymbol PrimExpr = new LL1SyntaxSymbol("PrimExpr");
    private static final SyntaxSymbol ValueExprOrFuncInlineDefSuf = new LL1SyntaxSymbol("ValueExprOrFuncInlineDefSuf");
    private static final SyntaxSymbol Const = new LL1SyntaxSymbol("Const");
    private static final SyntaxSymbol FuncCallSuf = new LL1SyntaxSymbol("FuncCallSuf");
    private static final SyntaxSymbol FuncCallArgs = new LL1SyntaxSymbol("FuncCallArgs");
    private static final SyntaxSymbol FuncCallArgsSuf = new LL1SyntaxSymbol("FuncCallArgsSuf");
    private static final SyntaxSymbol FuncInlineDefSuf = new LL1SyntaxSymbol("FuncInlineDefSuf");

    private static final SyntaxSymbol Control = new LL1SyntaxSymbol("Control");
    private static final SyntaxSymbol Break = new LL1SyntaxSymbol("Break");
    private static final SyntaxSymbol Continue = new LL1SyntaxSymbol("Continue");
    private static final SyntaxSymbol Return = new LL1SyntaxSymbol("Return");
    private static final SyntaxSymbol RetValue = new LL1SyntaxSymbol("RetValue");

    private static final SyntaxSymbol If = new LL1SyntaxSymbol("If");
    private static final SyntaxSymbol Else = new LL1SyntaxSymbol("Else");
    private static final SyntaxSymbol ElseIfList = new LL1SyntaxSymbol("ElseIfList");
    private static final SyntaxSymbol ElseIf = new LL1SyntaxSymbol("ElseIf");
    private static final SyntaxSymbol EndElse = new LL1SyntaxSymbol("EndElse");

    private static final SyntaxSymbol Loop = new LL1SyntaxSymbol("Loop");

    private static final SyntaxSymbol ForLoop = new LL1SyntaxSymbol("ForLoop");
    private static final SyntaxSymbol ForInit = new LL1SyntaxSymbol("ForInit");
    private static final SyntaxSymbol ForInitList = new LL1SyntaxSymbol("ForInitList");
    private static final SyntaxSymbol ForInitListSuf = new LL1SyntaxSymbol("ForInitListSuf");
    private static final SyntaxSymbol ForAssignOrDefine = new LL1SyntaxSymbol("ForAssignOrDefine");
    private static final SyntaxSymbol ForCondition = new LL1SyntaxSymbol("ForCondition");
    private static final SyntaxSymbol ForUpdate = new LL1SyntaxSymbol("ForUpdate");
    private static final SyntaxSymbol ForUpdateList = new LL1SyntaxSymbol("ForUpdateList");
    private static final SyntaxSymbol ForUpdateListSuf = new LL1SyntaxSymbol("ForUpdateListSuf");
    private static final SyntaxSymbol ForBody = new LL1SyntaxSymbol("ForBody");

    private static final LL1SyntaxInlineDefiner definer = new LL1SyntaxInlineDefiner(eps, Program);

    public static final Syntaxer SYNTAXER;

    static {
        // 程序
        definer.addProduction(Program, List.of(BracedCodeBlock), ProgramToCodeNode.CREATOR);
        definer.addProduction(Program, List.of(eps), ProgramEmptyNode.CREATOR);

        // 代码块
        definer.addProduction(BracedCodeBlock, List.of(lBrace, StatementList, rBrace), BracedCodeBlockNode.CREATOR);

        definer.addProduction(NonNullCodeBlock, List.of(Statement), NonNullCodeBlockNode.CREATOR);

        definer.addProduction(Statement, List.of(Define), DetailedStatementToDefineNode.CREATOR);
        definer.addProduction(Statement, List.of(AssignOrFuncCall), DetailedStatementToAssignOrFuncCallNode.CREATOR);
        definer.addProduction(Statement, List.of(Control), DetailedStatementToControlNode.CREATOR);
        definer.addProduction(Statement, List.of(BracedCodeBlock), DetailedStatementToBracedCodeBlockNode.CREATOR);

        definer.addProduction(AssignOrFuncCall, List.of(Id, AssignOrFuncCallSuf, semicolon), AssignOrFuncCallNode.CREATOR);
        definer.addProduction(AssignOrFuncCallSuf, List.of(AssignSuf), AssignOrFuncCallSufToAssignSufNode.CREATOR);
        definer.addProduction(AssignOrFuncCallSuf, List.of(FuncCallSuf), AssignOrFuncCallSufToFuncCallSufNode.CREATOR);
        definer.addProduction(AssignSuf, List.of(assign, ValueExpr), AssignSufNode.CREATOR);

        definer.addProduction(StatementList, List.of(Statement, StatementList), StatementListToStatementNode.CREATOR);
        definer.addProduction(StatementList, List.of(eps), StatementListEmptyNode.CREATOR);

        // 定义语句
        definer.addProduction(Define, List.of(Type, VarDef), DefineNode.CREATOR);

        definer.addProduction(VarDef, List.of(Id, VarInit), VarDefToCommonVarNode.CREATOR);
        definer.addProduction(VarDef, List.of(func, Id, lParen, FuncArgListDef, rParen, BracedCodeBlock), VarDefToFuncVarNode.CREATOR);

        definer.addProduction(Id, List.of(identifier), DetailedIdNode.CREATOR);

        definer.addProduction(VarInit, List.of(AssignSuf, semicolon), VarInitToAssignSufNode.CREATOR);
        definer.addProduction(VarInit, List.of(semicolon), VarInitToSemicolonNode.CREATOR);

        definer.addProduction(FuncArgListDef, List.of(FuncArgDef, FuncArgListDefSuf), FuncArgListDefToFuncArgDefNode.CREATOR);
        definer.addProduction(FuncArgListDef, List.of(eps), FuncArgListDefEmptyNode.CREATOR);
        definer.addProduction(FuncArgListDefSuf, List.of(colon, FuncArgDef, FuncArgListDefSuf), FuncArgListDefSufToFuncArgDefNode.CREATOR);
        definer.addProduction(FuncArgListDefSuf, List.of(eps), FuncArgListDefSufEmptyNode.CREATOR);
        definer.addProduction(FuncArgDef, List.of(Type, Id), FuncArgDefNode.CREATOR);

        definer.addProduction(Type, List.of(BaseType, TypeSuf), DetailedTypeToBaseTypeNode.CREATOR);
        definer.addProduction(Type, List.of(VoidFuncType, TypeSuf), DetailedTypeToVoidFuncTypeNode.CREATOR);
        definer.addProduction(TypeSuf, List.of(function, lParen, FuncArgTypeDef, rParen, TypeSuf), TypeSufToFuncNode.CREATOR);
        definer.addProduction(TypeSuf, List.of(eps), TypeSufEmptyNode.CREATOR);

        definer.addProduction(BaseType, List.of(_int), BaseTypeToIntNode.CREATOR);
        definer.addProduction(BaseType, List.of(bool), BaseTypeToBoolNode.CREATOR);
        definer.addProduction(BaseType, List.of(_float), BaseTypeToFloatNode.CREATOR);
        definer.addProduction(BaseType, List.of(string), BaseTypeToStringNode.CREATOR);

        definer.addProduction(VoidFuncType, List.of(_void, function, lParen, FuncArgTypeDef, rParen), VoidFuncTypeNode.CREATOR);

        definer.addProduction(FuncArgTypeDef, List.of(Type, FuncArgTypeDefSuf), FuncArgTypeDefToTypeNode.CREATOR);
        definer.addProduction(FuncArgTypeDef, List.of(eps), FuncArgTypeDefEmptyNode.CREATOR);
        definer.addProduction(FuncArgTypeDefSuf, List.of(colon, Type, FuncArgTypeDefSuf), FuncArgTypeDefSufToTypeNode.CREATOR);
        definer.addProduction(FuncArgTypeDefSuf, List.of(eps), FuncArgTypeDefSufEmptyNode.CREATOR);

        // 值语句
        definer.addProduction(ValueExpr, List.of(LogicItem, LogicExprSuf), ValueExprNode.CREATOR);
        definer.addProduction(LogicExprSuf, List.of(or, LogicItem, LogicExprSuf), LogicExprSufToOrNode.CREATOR);
        definer.addProduction(LogicExprSuf, List.of(eps), LogicExprSufEmptyNode.CREATOR);
        definer.addProduction(LogicItem, List.of(LogicFactor, LogicItemSuf), LogicItemNode.CREATOR);
        definer.addProduction(LogicItemSuf, List.of(and, LogicFactor, LogicItemSuf), LogicItemSufToAndNode.CREATOR);
        definer.addProduction(LogicItemSuf, List.of(eps), LogicItemSufEmptyNode.CREATOR);
        definer.addProduction(LogicFactor, List.of(not, RelExpr), LogicFactorToNotNode.CREATOR);
        definer.addProduction(LogicFactor, List.of(RelExpr), LogicFactorToRelExprNode.CREATOR);

        definer.addProduction(RelExpr, List.of(ArithExpr, RelExprSuf), RelExprNode.CREATOR);
        definer.addProduction(RelExprSuf, List.of(RelOp, ArithExpr, RelExprSuf), RelExprSufToRelOpNode.CREATOR);
        definer.addProduction(RelExprSuf, List.of(eps), RelExprSufEmptyNode.CREATOR);

        definer.addProduction(RelOp, List.of(lt), RelOpToLTNode.CREATOR);
        definer.addProduction(RelOp, List.of(gt), RelOpToGTNode.CREATOR);
        definer.addProduction(RelOp, List.of(le), RelOpToLENode.CREATOR);
        definer.addProduction(RelOp, List.of(ge), RelOpToGENode.CREATOR);
        definer.addProduction(RelOp, List.of(eq), RelOpToEQNode.CREATOR);
        definer.addProduction(RelOp, List.of(ne), RelOpToNENode.CREATOR);

        definer.addProduction(ArithExpr, List.of(ArithItem, ArithExprSuf), ArithExprNode.CREATOR);
        definer.addProduction(ArithExprSuf, List.of(minus, ArithItem, ArithExprSuf), ArithExprSufToMinusNode.CREATOR);
        definer.addProduction(ArithExprSuf, List.of(plus, ArithItem, ArithExprSuf), ArithExprSufToPlusNode.CREATOR);
        definer.addProduction(ArithExprSuf, List.of(eps), ArithExprSufEmptyNode.CREATOR);
        definer.addProduction(ArithItem, List.of(PrimExpr, ArithItemSuf), ArithItemNode.CREATOR);
        definer.addProduction(ArithItemSuf, List.of(times, PrimExpr, ArithItemSuf), ArithItemSufToTimesNode.CREATOR);
        definer.addProduction(ArithItemSuf, List.of(divides, PrimExpr, ArithItemSuf), ArithItemSufToDivideNode.CREATOR);
        definer.addProduction(ArithItemSuf, List.of(eps), ArithItemSufEmptyNode.CREATOR);

        definer.addProduction(PrimExpr, List.of(lParen, ValueExprOrFuncInlineDefSuf), PrimExprToValueOrFuncDefNode.CREATOR);
        definer.addProduction(PrimExpr, List.of(Const), PrimExprToConstNode.CREATOR);
        definer.addProduction(PrimExpr, List.of(Id, FuncCallSuf), PrimExprToIdOrFuncCallNode.CREATOR);

        definer.addProduction(ValueExprOrFuncInlineDefSuf, List.of(ValueExpr, rParen), ValueExprOrFuncInlineDefSufToValueNode.CREATOR);
        definer.addProduction(ValueExprOrFuncInlineDefSuf, List.of(FuncInlineDefSuf), ValueExprOrFuncInlineDefSufToFuncDefNode.CREATOR);

        definer.addProduction(Const, List.of(constInt), ConstToIntNode.CREATOR);
        definer.addProduction(Const, List.of(constFloat), ConstToFloatNode.CREATOR);
        definer.addProduction(Const, List.of(constString), ConstToStringNode.CREATOR);
        definer.addProduction(Const, List.of(_true), ConstToTrueNode.CREATOR);
        definer.addProduction(Const, List.of(_false), ConstToFloatNode.CREATOR);
        definer.addProduction(Const, List.of(_null), ConstToNullNode.CREATOR);

        definer.addProduction(FuncCallSuf, List.of(lParen, FuncCallArgs, rParen), FuncCallSufToParenNode.CREATOR);
        definer.addProduction(FuncCallSuf, List.of(eps), FuncCallSufEmptyNode.CREATOR);
        definer.addProduction(FuncCallArgs, List.of(ValueExpr, FuncCallArgsSuf), FuncCallArgsToValueExprNode.CREATOR);
        definer.addProduction(FuncCallArgs, List.of(eps), FuncCallArgsEmptyNode.CREATOR);
        definer.addProduction(FuncCallArgsSuf, List.of(colon, ValueExpr, FuncCallArgsSuf), FuncCallArgsSufToValueExprNode.CREATOR);
        definer.addProduction(FuncCallArgsSuf, List.of(eps), FuncCallArgsSufEmptyNode.CREATOR);

        definer.addProduction(FuncInlineDefSuf, List.of(FuncArgListDef, rParen, funcArgTrans, BracedCodeBlock), FuncInlineDefSufNode.CREATOR);

        // 控制语句
        definer.addProduction(Control, List.of(Break, semicolon), ControlToBreakNode.CREATOR);
        definer.addProduction(Control, List.of(Continue, semicolon), ControlToContinueNode.CREATOR);
        definer.addProduction(Control, List.of(Return, semicolon), ControlToReturnNode.CREATOR);
        definer.addProduction(Control, List.of(If), ControlToIfNode.CREATOR);
        definer.addProduction(Control, List.of(Loop), ControlToLoopNode.CREATOR);

        definer.addProduction(Break, List.of(_break), DetailedBreakNode.CREATOR);

        definer.addProduction(Continue, List.of(_continue), DetailedContinueNode.CREATOR);

        definer.addProduction(Return, List.of(_return, RetValue), DetailedReturnNode.CREATOR);

        definer.addProduction(RetValue, List.of(ValueExpr), RetValueToValueExprNode.CREATOR);
        definer.addProduction(RetValue, List.of(eps), RetValueEmptyNode.CREATOR);

        // if 语句
        definer.addProduction(If, List.of(_if, lParen, ValueExpr, rParen, BracedCodeBlock, Else), DetailedIfNode.CREATOR);

        definer.addProduction(Else, List.of(ElseIfList, EndElse), DetailedElseNode.CREATOR);

        definer.addProduction(ElseIfList, List.of(ElseIf, ElseIfList), ElseIfListToElseIfNode.CREATOR);
        definer.addProduction(ElseIfList, List.of(eps), ElseIfListEmptyNode.CREATOR);

        definer.addProduction(ElseIf, List.of(elseif, lParen, ValueExpr, rParen, BracedCodeBlock), DetailedElseIfNode.CREATOR);

        definer.addProduction(EndElse, List.of(_else, BracedCodeBlock), EndElseToElseNode.CREATOR);
        definer.addProduction(EndElse, List.of(eps), EndElseEmptyNode.CREATOR);


        // 循环语句
        definer.addProduction(Loop, List.of(ForLoop), LoopToForLoopNode.CREATOR);

        // For 循环
        definer.addProduction(ForLoop, List.of(_for, lParen, ForInit, semicolon, ForCondition, semicolon, ForUpdate, rParen, ForBody), ForLoopNode.CREATOR);

        definer.addProduction(ForInit, List.of(ForInitList), DetailedForInitToInitListNode.CREATOR);
        definer.addProduction(ForInit, List.of(eps), DetailedForInitEmptyNode.CREATOR);

        definer.addProduction(ForInitList, List.of(ForAssignOrDefine, ForInitListSuf), ForInitListNode.CREATOR);
        definer.addProduction(ForInitListSuf, List.of(colon, ForAssignOrDefine, ForInitListSuf), ForInitListSufToForAssignOrDefineNode.CREATOR);
        definer.addProduction(ForInitListSuf, List.of(eps), ForInitListSufEmptyNode.CREATOR);
        definer.addProduction(ForAssignOrDefine, List.of(Type, Id, AssignSuf), ForAssignOrDefineToDefineNode.CREATOR);
        definer.addProduction(ForAssignOrDefine, List.of(Id, AssignSuf), ForAssignOrDefineToAssignNode.CREATOR);

        definer.addProduction(ForCondition, List.of(ValueExpr), DetailedForConditionToValueExprNode.CREATOR);
        definer.addProduction(ForCondition, List.of(eps), DetailedForConditionEmptyNode.CREATOR);

        definer.addProduction(ForUpdate, List.of(ForUpdateList), DetailedForUpdateToUpdateListNode.CREATOR);
        definer.addProduction(ForUpdate, List.of(eps), DetailedForUpdateEmptyNode.CREATOR);
        definer.addProduction(ForUpdateList, List.of(Id, AssignSuf, ForUpdateListSuf), ForUpdateListNode.CREATOR);
        definer.addProduction(ForUpdateListSuf, List.of(colon, Id, AssignSuf, ForUpdateListSuf), ForUpdateListSufToAssignNode.CREATOR);
        definer.addProduction(ForUpdateListSuf, List.of(eps), ForUpdateListSufEmptyNode.CREATOR);

        definer.addProduction(ForBody, List.of(BracedCodeBlock), ForBodyNode.CREATOR);

        SYNTAXER = new LL1Syntaxer(definer);
    }

    public static void avoidLazyLoad() {}

}
