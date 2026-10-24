package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/AbstractUnaryOperator.class */
public abstract class AbstractUnaryOperator extends AbstractOperator {
    protected AbstractUnaryOperator(String str, int i, boolean z) {
        super(str, i, z);
    }

    @Override // me.ulrich.clans.library.udojava.evalex.AbstractOperator, me.ulrich.clans.library.udojava.evalex.LazyOperator
    public Expression.LazyNumber eval(final Expression.LazyNumber lazyNumber, Expression.LazyNumber lazyNumber2) {
        if (lazyNumber2 != null) {
            throw new Expression.ExpressionException("Did not expect a second parameter for unary operator");
        }
        return new Expression.LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.AbstractUnaryOperator.1
            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public String getString() {
                return String.valueOf(AbstractUnaryOperator.this.evalUnary(lazyNumber.eval()));
            }

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public BigDecimal eval() {
                return AbstractUnaryOperator.this.evalUnary(lazyNumber.eval());
            }
        };
    }

    @Override // me.ulrich.clans.library.udojava.evalex.Operator
    public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal2 != null) {
            throw new Expression.ExpressionException("Did not expect a second parameter for unary operator");
        }
        return evalUnary(bigDecimal);
    }

    public abstract BigDecimal evalUnary(BigDecimal bigDecimal);
}
