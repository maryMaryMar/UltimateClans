package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/AbstractFunction.class */
public abstract class AbstractFunction extends AbstractLazyFunction implements Function {
    protected AbstractFunction(String str, int i) {
        super(str, i);
    }

    protected AbstractFunction(String str, int i, boolean z) {
        super(str, i, z);
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyFunction
    public Expression.LazyNumber lazyEval(final List<Expression.LazyNumber> list) {
        return new Expression.LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.AbstractFunction.1
            private List<BigDecimal> params;

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public BigDecimal eval() {
                return AbstractFunction.this.eval(getParams());
            }

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public String getString() {
                return String.valueOf(AbstractFunction.this.eval(getParams()));
            }

            private List<BigDecimal> getParams() {
                if (this.params == null) {
                    this.params = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        this.params.add(((Expression.LazyNumber) it.next()).eval());
                    }
                }
                return this.params;
            }
        };
    }
}
