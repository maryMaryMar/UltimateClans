package me.ulrich.clans.library.udojava.evalex;

import java.math.MathContext;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/ExpressionSettings.class */
public class ExpressionSettings {
    private MathContext mathContext;
    private int powerOperatorPrecedence;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/ExpressionSettings$Builder.class */
    public static class Builder {
        private MathContext mathContext = MathContext.DECIMAL32;
        private int powerOperatorPrecedence = 40;

        public Builder mathContext(MathContext mathContext) {
            this.mathContext = mathContext;
            return this;
        }

        public Builder powerOperatorPrecedenceHigher() {
            this.powerOperatorPrecedence = 80;
            return this;
        }

        public Builder powerOperatorPrecedence(int i) {
            this.powerOperatorPrecedence = i;
            return this;
        }

        public ExpressionSettings build() {
            return new ExpressionSettings(this.mathContext, this.powerOperatorPrecedence);
        }
    }

    private ExpressionSettings() {
    }

    public ExpressionSettings(MathContext mathContext, int i) {
        this.mathContext = mathContext;
        this.powerOperatorPrecedence = i;
    }

    public MathContext getMathContext() {
        return this.mathContext;
    }

    public int getPowerOperatorPrecedence() {
        return this.powerOperatorPrecedence;
    }

    public static Builder builder() {
        return new Builder();
    }
}
