package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Function.class */
public interface Function extends LazyFunction {
    BigDecimal eval(List<BigDecimal> list);
}
