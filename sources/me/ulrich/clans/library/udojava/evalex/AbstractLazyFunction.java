package me.ulrich.clans.library.udojava.evalex;

import java.util.Locale;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/AbstractLazyFunction.class */
public abstract class AbstractLazyFunction implements LazyFunction {
    protected String name;
    protected int numParams;
    protected boolean booleanFunction;

    protected AbstractLazyFunction(String str, int i, boolean z) {
        this.name = str.toUpperCase(Locale.ROOT);
        this.numParams = i;
        this.booleanFunction = z;
    }

    protected AbstractLazyFunction(String str, int i) {
        this(str, i, false);
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyFunction
    public String getName() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyFunction
    public int getNumParams() {
        return this.numParams;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyFunction
    public boolean numParamsVaries() {
        return this.numParams < 0;
    }

    @Override // me.ulrich.clans.library.udojava.evalex.LazyFunction
    public boolean isBooleanFunction() {
        return this.booleanFunction;
    }
}
