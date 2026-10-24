package me.ulrich.clans.library.udojava.evalex;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/LazyOperator.class */
public interface LazyOperator {
    String getOper();

    int getPrecedence();

    boolean isLeftAssoc();

    boolean isBooleanOperator();

    boolean isUnaryOperator();

    Expression.LazyNumber eval(Expression.LazyNumber lazyNumber, Expression.LazyNumber lazyNumber2);
}
