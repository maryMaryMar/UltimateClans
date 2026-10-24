package me.ulrich.clans.library.udojava.evalex;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/LazyFunction.class */
public interface LazyFunction {
    String getName();

    int getNumParams();

    boolean numParamsVaries();

    boolean isBooleanFunction();

    Expression.LazyNumber lazyEval(List<Expression.LazyNumber> list);
}
