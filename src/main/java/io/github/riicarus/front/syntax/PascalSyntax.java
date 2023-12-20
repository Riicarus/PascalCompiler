package io.github.riicarus.front.syntax;

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
    private static final SyntaxSymbol integer = new LL1SyntaxSymbol("integer", true);
    private static final SyntaxSymbol _boolean = new LL1SyntaxSymbol("boolean", true);
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
    private static final SyntaxSymbol _elseif = new LL1SyntaxSymbol("elseif", true);
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
    private static final SyntaxSymbol ArraySize = new LL1SyntaxSymbol("ArraySize");

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
    private static final SyntaxSymbol ForBody = new LL1SyntaxSymbol("ForBody");

    private static final LL1SyntaxInlineDefiner definer = new LL1SyntaxInlineDefiner(eps, Program);

    public static final Syntaxer SYNTAXER;

    static {
        // 程序
        definer.addProduction(Program, List.of(BracedCodeBlock), null);
        definer.addProduction(Program, List.of(eps), null);

        // 代码块
        definer.addProduction(BracedCodeBlock, List.of(lBrace, StatementList, rBrace), null);

        definer.addProduction(NonNullCodeBlock, List.of(Statement), null);

        definer.addProduction(Statement, List.of(Define), null);
        definer.addProduction(Statement, List.of(AssignOrFuncCall), null);
        definer.addProduction(Statement, List.of(Control), null);
        definer.addProduction(Statement, List.of(BracedCodeBlock), null);

        definer.addProduction(AssignOrFuncCall, List.of(Id, AssignOrFuncCallSuf, semicolon), null);
        definer.addProduction(AssignOrFuncCallSuf, List.of(AssignSuf), null);
        definer.addProduction(AssignOrFuncCallSuf, List.of(FuncCallSuf), null);
        definer.addProduction(AssignSuf, List.of(assign, ValueExpr), null);

        definer.addProduction(StatementList, List.of(Statement, StatementList), null);
        definer.addProduction(StatementList, List.of(eps), null);

        // 定义语句
        definer.addProduction(Define, List.of(Type, VarDef), null);

        definer.addProduction(VarDef, List.of(Id, VarInit), null);
        definer.addProduction(VarDef, List.of(func, Id, lParen, FuncArgListDef, rParen, BracedCodeBlock), null);

        definer.addProduction(Id, List.of(identifier), null);

        definer.addProduction(VarInit, List.of(AssignSuf, semicolon), null);
        definer.addProduction(VarInit, List.of(semicolon), null);

        definer.addProduction(FuncArgListDef, List.of(FuncArgDef, FuncArgListDefSuf), null);
        definer.addProduction(FuncArgListDef, List.of(eps), null);
        definer.addProduction(FuncArgListDefSuf, List.of(colon, FuncArgDef, FuncArgListDefSuf), null);
        definer.addProduction(FuncArgListDefSuf, List.of(eps), null);
        definer.addProduction(FuncArgDef, List.of(Type, Id), null);

        definer.addProduction(Type, List.of(BaseType, TypeSuf), null);
        definer.addProduction(Type, List.of(VoidFuncType, TypeSuf), null);
        definer.addProduction(TypeSuf, List.of(function, lParen, FuncArgTypeDef, rParen, TypeSuf), null);
        definer.addProduction(TypeSuf, List.of(lBracket, ArraySize, rBracket, TypeSuf), null);
        definer.addProduction(TypeSuf, List.of(eps), null);

        definer.addProduction(BaseType, List.of(integer), null);
        definer.addProduction(BaseType, List.of(_boolean), null);
        definer.addProduction(BaseType, List.of(_float), null);
        definer.addProduction(BaseType, List.of(string), null);

        definer.addProduction(VoidFuncType, List.of(_void, function, lParen, FuncArgTypeDef, rParen), null);

        definer.addProduction(FuncArgTypeDef, List.of(Type, FuncArgTypeDefSuf), null);
        definer.addProduction(FuncArgTypeDef, List.of(eps), null);
        definer.addProduction(FuncArgTypeDefSuf, List.of(colon, Type, FuncArgTypeDefSuf), null);
        definer.addProduction(FuncArgTypeDefSuf, List.of(eps), null);

        definer.addProduction(ArraySize, List.of(Id), null);
        definer.addProduction(ArraySize, List.of(constInt), null);
        definer.addProduction(ArraySize, List.of(eps), null);


        // 值语句
        definer.addProduction(ValueExpr, List.of(LogicItem, LogicExprSuf), null);
        definer.addProduction(LogicExprSuf, List.of(or, LogicItem, LogicExprSuf), null);
        definer.addProduction(LogicExprSuf, List.of(eps), null);
        definer.addProduction(LogicItem, List.of(LogicFactor, LogicItemSuf), null);
        definer.addProduction(LogicItemSuf, List.of(and, LogicFactor, LogicItemSuf), null);
        definer.addProduction(LogicItemSuf, List.of(eps), null);
        definer.addProduction(LogicFactor, List.of(not, RelExpr), null);
        definer.addProduction(LogicFactor, List.of(RelExpr), null);

        definer.addProduction(RelExpr, List.of(ArithExpr, RelExprSuf), null);
        definer.addProduction(RelExprSuf, List.of(RelOp, ArithExpr, RelExprSuf), null);
        definer.addProduction(RelExprSuf, List.of(eps), null);

        definer.addProduction(RelOp, List.of(lt), null);
        definer.addProduction(RelOp, List.of(gt), null);
        definer.addProduction(RelOp, List.of(le), null);
        definer.addProduction(RelOp, List.of(ge), null);
        definer.addProduction(RelOp, List.of(eq), null);
        definer.addProduction(RelOp, List.of(ne), null);

        definer.addProduction(ArithExpr, List.of(ArithItem, ArithExprSuf), null);
        definer.addProduction(ArithExprSuf, List.of(minus, ArithItem, ArithExprSuf), null);
        definer.addProduction(ArithExprSuf, List.of(plus, ArithItem, ArithExprSuf), null);
        definer.addProduction(ArithExprSuf, List.of(eps), null);
        definer.addProduction(ArithItem, List.of(PrimExpr, ArithItemSuf), null);
        definer.addProduction(ArithItemSuf, List.of(times, PrimExpr, ArithItemSuf), null);
        definer.addProduction(ArithItemSuf, List.of(divides, PrimExpr, ArithItemSuf), null);
        definer.addProduction(ArithItemSuf, List.of(eps), null);

        definer.addProduction(PrimExpr, List.of(lParen, ValueExprOrFuncInlineDefSuf), null);
        definer.addProduction(PrimExpr, List.of(Const), null);
        definer.addProduction(PrimExpr, List.of(Id, FuncCallSuf), null);

        definer.addProduction(ValueExprOrFuncInlineDefSuf, List.of(ValueExpr, rParen), null);
        definer.addProduction(ValueExprOrFuncInlineDefSuf, List.of(FuncInlineDefSuf), null);

        definer.addProduction(Const, List.of(constInt), null);
        definer.addProduction(Const, List.of(constFloat), null);
        definer.addProduction(Const, List.of(constString), null);
        definer.addProduction(Const, List.of(_true), null);
        definer.addProduction(Const, List.of(_false), null);
        definer.addProduction(Const, List.of(_null), null);

        definer.addProduction(FuncCallSuf, List.of(lParen, FuncCallArgs, rParen), null);
        definer.addProduction(FuncCallSuf, List.of(eps), null);
        definer.addProduction(FuncCallArgs, List.of(ValueExpr, FuncCallArgsSuf), null);
        definer.addProduction(FuncCallArgs, List.of(eps), null);
        definer.addProduction(FuncCallArgsSuf, List.of(colon, ValueExpr, FuncCallArgsSuf), null);
        definer.addProduction(FuncCallArgsSuf, List.of(eps), null);

        definer.addProduction(FuncInlineDefSuf, List.of(FuncArgListDef, rParen, funcArgTrans, BracedCodeBlock), null);

        // 控制语句
        definer.addProduction(Control, List.of(Break, semicolon), null);
        definer.addProduction(Control, List.of(Continue, semicolon), null);
        definer.addProduction(Control, List.of(Return, semicolon), null);
        definer.addProduction(Control, List.of(If), null);
        definer.addProduction(Control, List.of(Loop), null);

        definer.addProduction(Break, List.of(_break), null);

        definer.addProduction(Continue, List.of(_continue), null);

        definer.addProduction(Return, List.of(_return, RetValue), null);

        definer.addProduction(RetValue, List.of(ValueExpr), null);
        definer.addProduction(RetValue, List.of(eps), null);

        // if 语句
        definer.addProduction(If, List.of(_if, lParen, ValueExpr, rParen, BracedCodeBlock, Else), null);

        definer.addProduction(Else, List.of(ElseIfList, EndElse), null);

        definer.addProduction(ElseIfList, List.of(ElseIf, ElseIfList), null);
        definer.addProduction(ElseIfList, List.of(eps), null);

        definer.addProduction(ElseIf, List.of(_elseif, lParen, ValueExpr, rParen, BracedCodeBlock), null);

        definer.addProduction(EndElse, List.of(_else, BracedCodeBlock), null);
        definer.addProduction(EndElse, List.of(eps), null);


        // 循环语句
        definer.addProduction(Loop, List.of(ForLoop), null);

        // For 循环
        definer.addProduction(ForLoop, List.of(_for, lParen, ForInit, semicolon, ForCondition, semicolon, ForUpdate, rParen, ForBody), null);

        definer.addProduction(ForInit, List.of(ForInitList), null);
        definer.addProduction(ForInit, List.of(eps), null);

        definer.addProduction(ForInitList, List.of(ForAssignOrDefine, ForInitListSuf), null);
        definer.addProduction(ForInitListSuf, List.of(colon, ForAssignOrDefine, ForInitListSuf), null);
        definer.addProduction(ForInitListSuf, List.of(eps), null);
        definer.addProduction(ForAssignOrDefine, List.of(Type, Id, AssignSuf), null);
        definer.addProduction(ForAssignOrDefine, List.of(Id, AssignSuf), null);

        definer.addProduction(ForCondition, List.of(ValueExpr), null);
        definer.addProduction(ForCondition, List.of(eps), null);

        definer.addProduction(ForUpdate, List.of(ForInitList), null);
        definer.addProduction(ForUpdate, List.of(eps), null);

        definer.addProduction(ForBody, List.of(BracedCodeBlock), null);

        SYNTAXER = new LL1Syntaxer(definer);
    }

}
