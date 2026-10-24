package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/AbstractOperator.class */
public abstract class AbstractOperator extends AbstractLazyOperator implements Operator {
    protected AbstractOperator(String str, int i, boolean z, boolean z2, boolean z3) {
        super(str, i, z, z2, z3);
    }

    protected AbstractOperator(String str, int i, boolean z, boolean z2) {
        super(str, i, z, z2);
    }

    protected AbstractOperator(String str, int i, boolean z) {
        super(str, i, z);
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyOperator
    public Expression.LazyNumber eval(final Expression.LazyNumber lazyNumber, final Expression.LazyNumber lazyNumber2) {
        return lazyNumber2 == null ? new Expression.LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.AbstractOperator.1
            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public BigDecimal eval() {
                return AbstractOperator.this.eval(lazyNumber.eval(), (BigDecimal) null);
            }

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public String getString() {
                return String.valueOf(AbstractOperator.this.eval(lazyNumber.eval(), (BigDecimal) null));
            }
        } : new Expression.LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.AbstractOperator.2
            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public BigDecimal eval() {
                return AbstractOperator.this.eval(lazyNumber.eval(), lazyNumber2.eval());
            }

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public String getString() {
                return String.valueOf(AbstractOperator.this.eval(lazyNumber.eval(), lazyNumber2.eval()));
            }
        };
    }
}
