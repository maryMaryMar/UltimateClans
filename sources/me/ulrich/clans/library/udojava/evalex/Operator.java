package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Operator.class */
public interface Operator extends LazyOperator {
    BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2);
}
