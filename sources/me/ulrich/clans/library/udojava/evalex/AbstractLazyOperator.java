package me.ulrich.clans.library.udojava.evalex;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/AbstractLazyOperator.class */
public abstract class AbstractLazyOperator implements LazyOperator {
    protected String oper;
    protected int precedence;
    protected boolean leftAssoc;
    protected boolean booleanOperator;
    protected boolean unaryOperator;

    protected AbstractLazyOperator(String str, int i, boolean z, boolean z2, boolean z3) {
        this.booleanOperator = false;
        this.oper = str;
        this.precedence = i;
        this.leftAssoc = z;
        this.booleanOperator = z2;
        this.unaryOperator = z3;
    }

    protected AbstractLazyOperator(String str, int i, boolean z, boolean z2) {
        this.booleanOperator = false;
        this.oper = str;
        this.precedence = i;
        this.leftAssoc = z;
        this.booleanOperator = z2;
        this.unaryOperator = false;
    }

    protected AbstractLazyOperator(String str, int i, boolean z) {
        this.booleanOperator = false;
        this.oper = str;
        this.precedence = i;
        this.leftAssoc = z;
        this.unaryOperator = false;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyOperator
    public String getOper() {
        return this.oper;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyOperator
    public int getPrecedence() {
        return this.precedence;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyOperator
    public boolean isLeftAssoc() {
        return this.leftAssoc;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyOperator
    public boolean isBooleanOperator() {
        return this.booleanOperator;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyOperator
    public boolean isUnaryOperator() {
        return this.unaryOperator;
    }
}
