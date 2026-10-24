package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/LazyIfNumber.class */
public class LazyIfNumber implements Expression.LazyNumber {
    private List<Expression.LazyNumber> lazyParams;

    public LazyIfNumber(List<Expression.LazyNumber> list) {
        this.lazyParams = list;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
    public BigDecimal eval() {
        BigDecimal bigDecimalEval = this.lazyParams.get(0).eval();
        assertNotNull(bigDecimalEval);
        return bigDecimalEval.compareTo(BigDecimal.ZERO) != 0 ? this.lazyParams.get(1).eval() : this.lazyParams.get(2).eval();
    }

    @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
    public String getString() {
        return this.lazyParams.get(0).getString();
    }

    private void assertNotNull(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            throw new ArithmeticException("Operand may not be null");
        }
    }
}
