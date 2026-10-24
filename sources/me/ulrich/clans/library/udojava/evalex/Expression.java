package me.ulrich.clans.library.udojava.evalex;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression.class */
public class Expression {
    public static final int OPERATOR_PRECEDENCE_UNARY = 60;
    public static final int OPERATOR_PRECEDENCE_EQUALITY = 7;
    public static final int OPERATOR_PRECEDENCE_COMPARISON = 10;
    public static final int OPERATOR_PRECEDENCE_OR = 2;
    public static final int OPERATOR_PRECEDENCE_AND = 4;
    public static final int OPERATOR_PRECEDENCE_POWER = 40;
    public static final int OPERATOR_PRECEDENCE_POWER_HIGHER = 80;
    public static final int OPERATOR_PRECEDENCE_MULTIPLICATIVE = 30;
    public static final int OPERATOR_PRECEDENCE_ADDITIVE = 20;
    public static final String MISSING_PARAMETERS_FOR_OPERATOR = "Missing parameter(s) for operator ";
    private MathContext mc;
    private int powerOperatorPrecedence;
    private String firstVarChars;
    private String varChars;
    private final String originalExpression;
    private String expressionString;
    private List<Token> rpn;
    protected Map<String, LazyOperator> operators;
    protected Map<String, me.ulrich.clans.library.udojava.evalex.LazyFunction> functions;
    protected Map<String, LazyNumber> variables;
    private static final char DECIMAL_SEPARATOR = '.';
    private static final char MINUS_SIGN = '-';
    private static final LazyNumber PARAMS_START;
    public static final BigDecimal PI = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679");
    public static final BigDecimal e = new BigDecimal("2.71828182845904523536028747135266249775724709369995957496696762772407663");
    private static final Map<String, BigDecimal> DEFAULT_CONSTANTS = new HashMap();

    /* JADX INFO: renamed from: me.ulrich.clans.library.udojava.evalex.Expression$75, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$75.class */
    static /* synthetic */ class AnonymousClass75 {
        static final /* synthetic */ int[] $SwitchMap$com$udojava$evalex$Expression$TokenType = new int[TokenType.values().length];

        static {
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.STRINGPARAM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.LITERAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.HEX_LITERAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.VARIABLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.FUNCTION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.COMMA.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.OPERATOR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.UNARY_OPERATOR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.OPEN_PAREN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$udojava$evalex$Expression$TokenType[TokenType.CLOSE_PAREN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$ExpressionException.class */
    public static class ExpressionException extends RuntimeException {
        private static final long serialVersionUID = 1118142866870779047L;

        public ExpressionException(String str) {
            super(str);
        }

        public ExpressionException(String str, int i) {
            super(str + " at character position " + i);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$Function.class */
    public abstract class Function extends AbstractFunction {
        public Function(String str, int i) {
            super(str, i);
        }

        public Function(String str, int i, boolean z) {
            super(str, i, z);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$LazyFunction.class */
    public abstract class LazyFunction extends AbstractLazyFunction {
        public LazyFunction(String str, int i, boolean z) {
            super(str, i, z);
        }

        public LazyFunction(String str, int i) {
            super(str, i);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$LazyNumber.class */
    public interface LazyNumber {
        BigDecimal eval();

        String getString();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$Operator.class */
    public abstract class Operator extends AbstractOperator {
        public Operator(String str, int i, boolean z, boolean z2, boolean z3) {
            super(str, i, z, z2, z3);
        }

        public Operator(String str, int i, boolean z, boolean z2) {
            super(str, i, z, z2);
        }

        public Operator(String str, int i, boolean z) {
            super(str, i, z);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$Token.class */
    public class Token {
        public String surface = "";
        public TokenType type;
        public int pos;

        public Token() {
        }

        public void append(char c) {
            this.surface += c;
        }

        public void append(String str) {
            this.surface += str;
        }

        public char charAt(int i) {
            return this.surface.charAt(i);
        }

        public int length() {
            return this.surface.length();
        }

        public String toString() {
            return this.surface;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$TokenType.class */
    enum TokenType {
        VARIABLE,
        FUNCTION,
        LITERAL,
        OPERATOR,
        UNARY_OPERATOR,
        OPEN_PAREN,
        COMMA,
        CLOSE_PAREN,
        HEX_LITERAL,
        STRINGPARAM
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$Tokenizer.class */
    private class Tokenizer implements Iterator<Token> {
        private int pos = 0;
        private String input;
        private Token previousToken;
        private Token nextToken;

        public Tokenizer(String str) {
            this.nextToken = Expression.this.new Token();
            this.input = str.trim();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < this.input.length();
        }

        private char peekNextChar() {
            if (this.pos >= this.input.length() - 1) {
                return (char) 0;
            }
            return this.input.charAt(this.pos + 1);
        }

        private char consumeChar(Token token) {
            String str = this.input;
            int i = this.pos;
            this.pos = i + 1;
            token.append(str.charAt(i));
            if (this.pos >= this.input.length()) {
                return (char) 0;
            }
            return this.input.charAt(this.pos);
        }

        private char skipChar() {
            this.pos++;
            if (this.pos >= this.input.length()) {
                return (char) 0;
            }
            return this.input.charAt(this.pos);
        }

        private boolean isHexDigit(char c) {
            return c == 'x' || c == 'X' || (c >= '0' && c <= '9') || ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Token next() {
            char cConsumeChar;
            Token token = Expression.this.new Token();
            if (this.pos >= this.input.length()) {
                this.previousToken = null;
                return null;
            }
            char cCharAt = this.input.charAt(this.pos);
            while (true) {
                cConsumeChar = cCharAt;
                if (!Character.isWhitespace(cConsumeChar) || this.pos >= this.input.length()) {
                    break;
                }
                cCharAt = skipChar();
            }
            token.pos = this.pos;
            if (this.pos < this.input.length() - 1) {
                this.nextToken.pos = this.pos + 1;
            } else {
                this.nextToken = null;
            }
            boolean z = false;
            if (Character.isDigit(cConsumeChar) || (cConsumeChar == Expression.DECIMAL_SEPARATOR && Character.isDigit(peekNextChar()))) {
                if (cConsumeChar == '0' && (peekNextChar() == 'x' || peekNextChar() == 'X')) {
                    z = true;
                }
                while (true) {
                    if (!(z && isHexDigit(cConsumeChar)) && (!(Character.isDigit(cConsumeChar) || cConsumeChar == Expression.DECIMAL_SEPARATOR || cConsumeChar == 'e' || cConsumeChar == 'E' || ((cConsumeChar == '-' && token.length() > 0 && ('e' == token.charAt(token.length() - 1) || 'E' == token.charAt(token.length() - 1))) || (cConsumeChar == '+' && token.length() > 0 && ('e' == token.charAt(token.length() - 1) || 'E' == token.charAt(token.length() - 1))))) || this.pos >= this.input.length())) {
                        break;
                    }
                    cConsumeChar = consumeChar(token);
                }
                token.type = z ? TokenType.HEX_LITERAL : TokenType.LITERAL;
            } else if (cConsumeChar == '\"') {
                tokenizeString(token);
            } else if (Character.isLetter(cConsumeChar) || Expression.this.firstVarChars.indexOf(cConsumeChar) >= 0) {
                while (true) {
                    if ((!Character.isLetter(cConsumeChar) && !Character.isDigit(cConsumeChar) && Expression.this.varChars.indexOf(cConsumeChar) < 0 && (token.length() != 0 || Expression.this.firstVarChars.indexOf(cConsumeChar) < 0)) || this.pos >= this.input.length()) {
                        break;
                    }
                    cConsumeChar = consumeChar(token);
                }
                if (Character.isWhitespace(cConsumeChar)) {
                    while (Character.isWhitespace(cConsumeChar) && this.pos < this.input.length()) {
                        cConsumeChar = skipChar();
                    }
                    this.pos--;
                }
                if (Expression.this.operators.containsKey(token.surface)) {
                    token.type = TokenType.OPERATOR;
                } else if (cConsumeChar == '(') {
                    token.type = TokenType.FUNCTION;
                } else {
                    token.type = TokenType.VARIABLE;
                }
            } else if (cConsumeChar == '(' || cConsumeChar == ')' || cConsumeChar == ',') {
                if (cConsumeChar == '(') {
                    token.type = TokenType.OPEN_PAREN;
                } else if (cConsumeChar == ')') {
                    token.type = TokenType.CLOSE_PAREN;
                } else {
                    token.type = TokenType.COMMA;
                }
                consumeChar(token);
            } else {
                String str = "";
                int i = this.pos;
                char cCharAt2 = this.input.charAt(this.pos);
                int i2 = -1;
                while (!Character.isLetter(cCharAt2) && !Character.isDigit(cCharAt2) && Expression.this.firstVarChars.indexOf(cCharAt2) < 0 && !Character.isWhitespace(cCharAt2) && cCharAt2 != '(' && cCharAt2 != ')' && cCharAt2 != ',' && this.pos < this.input.length()) {
                    str = str + cCharAt2;
                    cCharAt2 = skipChar();
                    if (Expression.this.operators.containsKey(str)) {
                        i2 = this.pos;
                    }
                }
                if (i2 != -1) {
                    token.append(this.input.substring(i, i2));
                    this.pos = i2;
                } else {
                    token.append(str);
                }
                if (this.previousToken == null || ((this.previousToken.type == TokenType.OPERATOR && !Expression.this.operators.get(this.previousToken.surface).isUnaryOperator()) || this.previousToken.type == TokenType.OPEN_PAREN || this.previousToken.type == TokenType.COMMA || this.previousToken.type == TokenType.UNARY_OPERATOR)) {
                    token.surface += "u";
                    token.type = TokenType.UNARY_OPERATOR;
                } else {
                    token.type = TokenType.OPERATOR;
                }
            }
            this.previousToken = token;
            return token;
        }

        private void tokenizeString(Token token) {
            char c;
            char cSkipChar = skipChar();
            while (true) {
                c = cSkipChar;
                if (c == '\"' || c == 0) {
                    break;
                } else {
                    cSkipChar = consumeChar(token);
                }
            }
            if (c == 0) {
                throw new TokenizerException("unterminated string literal", token.pos);
            }
            skipChar();
            token.type = TokenType.STRINGPARAM;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new ExpressionException("remove() not supported");
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/udojava/evalex/Expression$UnaryOperator.class */
    public abstract class UnaryOperator extends AbstractUnaryOperator {
        public UnaryOperator(String str, int i, boolean z) {
            super(str, i, z);
        }
    }

    protected LazyNumber createLazyNumber(final BigDecimal bigDecimal) {
        return new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.2
            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public String getString() {
                return bigDecimal.toPlainString();
            }

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public BigDecimal eval() {
                return bigDecimal;
            }
        };
    }

    public Expression(String str) {
        this(str, MathContext.DECIMAL32);
    }

    public Expression(String str, MathContext mathContext) {
        this(str, ExpressionSettings.builder().mathContext(mathContext).build());
    }

    public Expression(String str, ExpressionSettings expressionSettings) {
        this.powerOperatorPrecedence = 40;
        this.firstVarChars = "_";
        this.varChars = "_";
        this.expressionString = null;
        this.rpn = null;
        this.operators = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.functions = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.variables = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.mc = expressionSettings.getMathContext();
        this.powerOperatorPrecedence = expressionSettings.getPowerOperatorPrecedence();
        this.expressionString = str;
        this.originalExpression = str;
        addOperator(new Operator(Marker.ANY_NON_NULL_MARKER, 20, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.3
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.add(bigDecimal2, Expression.this.mc);
            }
        });
        addOperator(new Operator("-", 20, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.4
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.subtract(bigDecimal2, Expression.this.mc);
            }
        });
        addOperator(new Operator(Marker.ANY_MARKER, 30, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.5
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.multiply(bigDecimal2, Expression.this.mc);
            }
        });
        addOperator(new Operator("/", 30, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.6
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.divide(bigDecimal2, Expression.this.mc);
            }
        });
        addOperator(new Operator("%", 30, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.7
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.remainder(bigDecimal2, Expression.this.mc);
            }
        });
        addOperator(new Operator("^", this.powerOperatorPrecedence, false) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.8
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                int iSignum = bigDecimal2.signum();
                double dDoubleValue = bigDecimal.doubleValue();
                BigDecimal bigDecimalMultiply = bigDecimal2.multiply(new BigDecimal(iSignum));
                BigDecimal bigDecimalRemainder = bigDecimalMultiply.remainder(BigDecimal.ONE);
                BigDecimal bigDecimalMultiply2 = bigDecimal.pow(bigDecimalMultiply.subtract(bigDecimalRemainder).intValueExact(), Expression.this.mc).multiply(BigDecimal.valueOf(Math.pow(dDoubleValue, bigDecimalRemainder.doubleValue())), Expression.this.mc);
                if (iSignum == -1) {
                    bigDecimalMultiply2 = BigDecimal.ONE.divide(bigDecimalMultiply2, Expression.this.mc.getPrecision(), RoundingMode.HALF_UP);
                }
                return bigDecimalMultiply2;
            }
        });
        addOperator(new Operator("&&", 4, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.9
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                    return bigDecimal2.compareTo(BigDecimal.ZERO) != 0 ? BigDecimal.ONE : BigDecimal.ZERO;
                }
                return BigDecimal.ZERO;
            }
        });
        addOperator(new Operator("||", 2, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.10
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                    return BigDecimal.ONE;
                }
                return bigDecimal2.compareTo(BigDecimal.ZERO) != 0 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator(">", 10, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.11
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.compareTo(bigDecimal2) == 1 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator(">=", 10, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.12
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.compareTo(bigDecimal2) >= 0 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator("<", 10, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.13
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.compareTo(bigDecimal2) == -1 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator("<=", 10, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.14
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return bigDecimal.compareTo(bigDecimal2) <= 0 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator("=", 7, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.15
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                if (bigDecimal == bigDecimal2) {
                    return BigDecimal.ONE;
                }
                if (bigDecimal == null || bigDecimal2 == null) {
                    return BigDecimal.ZERO;
                }
                return bigDecimal.compareTo(bigDecimal2) == 0 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator("==", 7, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.16
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                return ((Operator) Expression.this.operators.get("=")).eval(bigDecimal, bigDecimal2);
            }
        });
        addOperator(new Operator("!=", 7, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.17
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                if (bigDecimal == bigDecimal2) {
                    return BigDecimal.ZERO;
                }
                if (bigDecimal == null || bigDecimal2 == null) {
                    return BigDecimal.ONE;
                }
                return bigDecimal.compareTo(bigDecimal2) != 0 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addOperator(new Operator("<>", 7, false, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.18
            @Override // me.ulrich.clans.library.udojava.evalex.Operator
            public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
                Expression.assertNotNull(bigDecimal, bigDecimal2);
                return ((Operator) Expression.this.operators.get("!=")).eval(bigDecimal, bigDecimal2);
            }
        });
        addOperator(new UnaryOperator("-", 60, false) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.19
            @Override // me.ulrich.clans.library.udojava.evalex.AbstractUnaryOperator
            public BigDecimal evalUnary(BigDecimal bigDecimal) {
                return bigDecimal.multiply(new BigDecimal(-1));
            }
        });
        addOperator(new UnaryOperator(Marker.ANY_NON_NULL_MARKER, 60, false) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.20
            @Override // me.ulrich.clans.library.udojava.evalex.AbstractUnaryOperator
            public BigDecimal evalUnary(BigDecimal bigDecimal) {
                return bigDecimal.multiply(BigDecimal.ONE);
            }
        });
        addFunction(new Function("FACT", 1, false) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.21
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                int iIntValue = list.get(0).intValue();
                BigDecimal bigDecimalMultiply = BigDecimal.ONE;
                for (int i = 1; i <= iIntValue; i++) {
                    bigDecimalMultiply = bigDecimalMultiply.multiply(new BigDecimal(i));
                }
                return bigDecimalMultiply;
            }
        });
        addFunction(new Function("NOT", 1, true) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.22
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return list.get(0).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ONE : BigDecimal.ZERO;
            }
        });
        addLazyFunction(new LazyFunction("IF", 3) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.23
            @Override // me.ulrich.clans.library.udojava.evalex.LazyFunction
            public LazyNumber lazyEval(List<LazyNumber> list) {
                return new LazyIfNumber(list);
            }
        });
        addFunction(new Function("RANDOM", 0) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.24
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                return new BigDecimal(Math.random(), Expression.this.mc);
            }
        });
        addFunction(new Function("SINR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.25
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.sin(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("COSR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.26
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.cos(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("TANR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.27
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.tan(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("COTR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.28
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.tan(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("SECR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.29
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.cos(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("CSCR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.30
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.sin(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("SIN", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.31
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.sin(Math.toRadians(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("COS", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.32
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.cos(Math.toRadians(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("TAN", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.33
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.tan(Math.toRadians(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("COT", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.34
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.tan(Math.toRadians(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("SEC", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.35
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.cos(Math.toRadians(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("CSC", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.36
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.sin(Math.toRadians(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("ASINR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.37
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.asin(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ACOSR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.38
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.acos(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ATANR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.39
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.atan(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ACOTR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.40
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                if (list.get(0).doubleValue() == 0.0d) {
                    throw new ExpressionException("Number must not be 0");
                }
                return new BigDecimal(Math.atan(1.0d / list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ATAN2R", 2) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.41
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0), list.get(1));
                return new BigDecimal(Math.atan2(list.get(0).doubleValue(), list.get(1).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ASIN", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.42
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.toDegrees(Math.asin(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("ACOS", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.43
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.toDegrees(Math.acos(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("ATAN", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.44
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.toDegrees(Math.atan(list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("ACOT", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.45
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                if (list.get(0).doubleValue() == 0.0d) {
                    throw new ExpressionException("Number must not be 0");
                }
                return new BigDecimal(Math.toDegrees(Math.atan(1.0d / list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("ATAN2", 2) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.46
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0), list.get(1));
                return new BigDecimal(Math.toDegrees(Math.atan2(list.get(0).doubleValue(), list.get(1).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("SINH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.47
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.sinh(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("COSH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.48
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.cosh(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("TANH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.49
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.tanh(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("SECH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.50
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.cosh(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("CSCH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.51
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.sinh(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("COTH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.52
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(1.0d / Math.tanh(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ASINH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.53
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.log(list.get(0).doubleValue() + Math.sqrt(Math.pow(list.get(0).doubleValue(), 2.0d) + 1.0d)), Expression.this.mc);
            }
        });
        addFunction(new Function("ACOSH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.54
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                if (Double.compare(list.get(0).doubleValue(), 1.0d) < 0) {
                    throw new ExpressionException("Number must be x >= 1");
                }
                return new BigDecimal(Math.log(list.get(0).doubleValue() + Math.sqrt(Math.pow(list.get(0).doubleValue(), 2.0d) - 1.0d)), Expression.this.mc);
            }
        });
        addFunction(new Function("ATANH", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.55
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                if (Math.abs(list.get(0).doubleValue()) > 1.0d || Math.abs(list.get(0).doubleValue()) == 1.0d) {
                    throw new ExpressionException("Number must be |x| < 1");
                }
                return new BigDecimal(0.5d * Math.log((1.0d + list.get(0).doubleValue()) / (1.0d - list.get(0).doubleValue())), Expression.this.mc);
            }
        });
        addFunction(new Function("RAD", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.56
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.toRadians(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("DEG", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.57
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.toDegrees(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("MAX", -1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.58
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                if (list.isEmpty()) {
                    throw new ExpressionException("MAX requires at least one parameter");
                }
                BigDecimal bigDecimal = null;
                for (BigDecimal bigDecimal2 : list) {
                    Expression.assertNotNull(bigDecimal2);
                    if (bigDecimal == null || bigDecimal2.compareTo(bigDecimal) > 0) {
                        bigDecimal = bigDecimal2;
                    }
                }
                return bigDecimal;
            }
        });
        addFunction(new Function("MIN", -1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.59
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                if (list.isEmpty()) {
                    throw new ExpressionException("MIN requires at least one parameter");
                }
                BigDecimal bigDecimal = null;
                for (BigDecimal bigDecimal2 : list) {
                    Expression.assertNotNull(bigDecimal2);
                    if (bigDecimal == null || bigDecimal2.compareTo(bigDecimal) < 0) {
                        bigDecimal = bigDecimal2;
                    }
                }
                return bigDecimal;
            }
        });
        addFunction(new Function("ABS", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.60
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return list.get(0).abs(Expression.this.mc);
            }
        });
        addFunction(new Function("LOG", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.61
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.log(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("LOG10", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.62
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return new BigDecimal(Math.log10(list.get(0).doubleValue()), Expression.this.mc);
            }
        });
        addFunction(new Function("ROUND", 2) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.63
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0), list.get(1));
                return list.get(0).setScale(list.get(1).intValue(), Expression.this.mc.getRoundingMode());
            }
        });
        addFunction(new Function("FLOOR", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.64
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return list.get(0).setScale(0, RoundingMode.FLOOR);
            }
        });
        addFunction(new Function("CEILING", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.65
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                Expression.assertNotNull(list.get(0));
                return list.get(0).setScale(0, RoundingMode.CEILING);
            }
        });
        addFunction(new Function("SQRT", 1) { // from class: me.ulrich.clans.library.udojava.evalex.Expression.66
            @Override // me.ulrich.clans.library.udojava.evalex.Function
            public BigDecimal eval(List<BigDecimal> list) {
                BigInteger bigIntegerAbs;
                Expression.assertNotNull(list.get(0));
                BigDecimal bigDecimal = list.get(0);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    return new BigDecimal(0);
                }
                if (bigDecimal.signum() < 0) {
                    throw new ExpressionException("Argument to SQRT() function must not be negative");
                }
                BigInteger bigInteger = bigDecimal.movePointRight(Expression.this.mc.getPrecision() << 1).toBigInteger();
                BigInteger bigIntegerShiftRight = bigInteger.shiftRight((bigInteger.bitLength() + 1) >> 1);
                do {
                    BigInteger bigInteger2 = bigIntegerShiftRight;
                    bigIntegerShiftRight = bigIntegerShiftRight.add(bigInteger.divide(bigIntegerShiftRight)).shiftRight(1);
                    Thread.yield();
                    bigIntegerAbs = bigIntegerShiftRight.subtract(bigInteger2).abs();
                    if (bigIntegerAbs.compareTo(BigInteger.ZERO) == 0) {
                        break;
                    }
                } while (bigIntegerAbs.compareTo(BigInteger.ONE) != 0);
                return new BigDecimal(bigIntegerShiftRight, Expression.this.mc.getPrecision());
            }
        });
        for (Map.Entry<String, BigDecimal> entry : DEFAULT_CONSTANTS.entrySet()) {
            BigDecimal value = entry.getValue();
            this.variables.put(entry.getKey(), value == null ? null : createLazyNumber(value));
        }
    }

    public static void assertNotNull(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            throw new ArithmeticException("Operand may not be null");
        }
    }

    public static void assertNotNull(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal == null) {
            throw new ArithmeticException("First operand may not be null");
        }
        if (bigDecimal2 == null) {
            throw new ArithmeticException("Second operand may not be null");
        }
    }

    protected boolean isNumber(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (str.charAt(0) == '-' && str.length() == 1) {
            return false;
        }
        if (str.charAt(0) == '+' && str.length() == 1) {
            return false;
        }
        if ((str.charAt(0) == DECIMAL_SEPARATOR && (str.length() == 1 || !Character.isDigit(str.charAt(1)))) || str.charAt(0) == 'e' || str.charAt(0) == 'E') {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '-' && c != DECIMAL_SEPARATOR && c != 'e' && c != 'E' && c != '+') {
                return false;
            }
        }
        return true;
    }

    private List<Token> shuntingYard(String str) {
        List<Token> arrayList = new ArrayList<>();
        Stack<Token> stack = new Stack<>();
        Tokenizer tokenizer = new Tokenizer(str);
        Token token = null;
        Token token2 = null;
        while (true) {
            Token token3 = token2;
            if (!tokenizer.hasNext()) {
                while (!stack.isEmpty()) {
                    Token tokenPop = stack.pop();
                    if (tokenPop.type == TokenType.OPEN_PAREN || tokenPop.type == TokenType.CLOSE_PAREN) {
                        throw new ExpressionException("Mismatched parentheses");
                    }
                    arrayList.add(tokenPop);
                }
                return arrayList;
            }
            Token next = tokenizer.next();
            switch (AnonymousClass75.$SwitchMap$com$udojava$evalex$Expression$TokenType[next.type.ordinal()]) {
                case 1:
                    stack.push(next);
                    break;
                case 2:
                case 3:
                    if (token3 != null && (token3.type == TokenType.LITERAL || token3.type == TokenType.HEX_LITERAL)) {
                        throw new ExpressionException("Missing operator", next.pos);
                    }
                    arrayList.add(next);
                    break;
                    break;
                case 4:
                    arrayList.add(next);
                    break;
                case 5:
                    stack.push(next);
                    token = next;
                    break;
                case 6:
                    if (token3 != null && token3.type == TokenType.OPERATOR) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token3, token3.pos);
                    }
                    while (!stack.isEmpty() && stack.peek().type != TokenType.OPEN_PAREN) {
                        arrayList.add(stack.pop());
                    }
                    if (stack.isEmpty()) {
                        if (token == null) {
                            throw new ExpressionException("Unexpected comma", next.pos);
                        }
                        throw new ExpressionException("Parse error for function " + token, next.pos);
                    }
                    break;
                    break;
                case OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                    if (token3 != null && this.operators.containsKey(next.surface) && ((token3.type == TokenType.COMMA || token3.type == TokenType.OPEN_PAREN) && !this.operators.get(next.surface).isUnaryOperator())) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + next, next.pos);
                    }
                    LazyOperator lazyOperator = this.operators.get(next.surface);
                    if (lazyOperator == null) {
                        throw new ExpressionException("Unknown operator " + next, next.pos + 1);
                    }
                    shuntOperators(arrayList, stack, lazyOperator);
                    stack.push(next);
                    break;
                    break;
                case 8:
                    if (token3 != null && token3.type != TokenType.OPERATOR && token3.type != TokenType.COMMA && token3.type != TokenType.OPEN_PAREN && token3.type != TokenType.UNARY_OPERATOR) {
                        throw new ExpressionException("Invalid position for unary operator " + next, next.pos);
                    }
                    LazyOperator lazyOperator2 = this.operators.get(next.surface);
                    if (lazyOperator2 == null) {
                        throw new ExpressionException("Unknown unary operator " + next.surface.substring(0, next.surface.length() - 1), next.pos + 1);
                    }
                    shuntOperators(arrayList, stack, lazyOperator2);
                    stack.push(next);
                    break;
                    break;
                case 9:
                    if (token3 != null) {
                        if (token3.type == TokenType.LITERAL || token3.type == TokenType.CLOSE_PAREN || token3.type == TokenType.VARIABLE || token3.type == TokenType.HEX_LITERAL) {
                            Token token4 = new Token();
                            token4.append(Marker.ANY_MARKER);
                            token4.type = TokenType.OPERATOR;
                            stack.push(token4);
                        }
                        if (token3.type == TokenType.FUNCTION) {
                            arrayList.add(next);
                        }
                    }
                    stack.push(next);
                    break;
                case 10:
                    if (token3 != null && token3.type == TokenType.OPERATOR && !this.operators.get(token3.surface).isUnaryOperator()) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token3, token3.pos);
                    }
                    while (!stack.isEmpty() && stack.peek().type != TokenType.OPEN_PAREN) {
                        arrayList.add(stack.pop());
                    }
                    if (stack.isEmpty()) {
                        throw new ExpressionException("Mismatched parentheses");
                    }
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek().type == TokenType.FUNCTION) {
                        arrayList.add(stack.pop());
                    }
                    break;
                    break;
            }
            token2 = next;
        }
    }

    private void shuntOperators(List<Token> list, Stack<Token> stack, LazyOperator lazyOperator) {
        Token tokenPeek = stack.isEmpty() ? null : stack.peek();
        while (true) {
            Token token = tokenPeek;
            if (token == null) {
                return;
            }
            if (token.type != TokenType.OPERATOR && token.type != TokenType.UNARY_OPERATOR) {
                return;
            }
            if ((!lazyOperator.isLeftAssoc() || lazyOperator.getPrecedence() > this.operators.get(token.surface).getPrecedence()) && lazyOperator.getPrecedence() >= this.operators.get(token.surface).getPrecedence()) {
                return;
            }
            list.add(stack.pop());
            tokenPeek = stack.isEmpty() ? null : stack.peek();
        }
    }

    public BigDecimal eval() {
        return eval(true);
    }

    public BigDecimal eval(boolean z) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (final Token token : getRPN()) {
            switch (AnonymousClass75.$SwitchMap$com$udojava$evalex$Expression$TokenType[token.type.ordinal()]) {
                case 1:
                    arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.72
                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public BigDecimal eval() {
                            return null;
                        }

                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public String getString() {
                            return token.surface;
                        }
                    });
                    break;
                case 2:
                    arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.71
                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public BigDecimal eval() {
                            if (token.surface.equalsIgnoreCase("NULL")) {
                                return null;
                            }
                            return new BigDecimal(token.surface, Expression.this.mc);
                        }

                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public String getString() {
                            return String.valueOf(new BigDecimal(token.surface, Expression.this.mc));
                        }
                    });
                    break;
                case 3:
                    arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.73
                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public BigDecimal eval() {
                            return new BigDecimal(new BigInteger(token.surface.substring(2), 16), Expression.this.mc);
                        }

                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public String getString() {
                            return new BigInteger(token.surface.substring(2), 16).toString();
                        }
                    });
                    break;
                case 4:
                    if (!this.variables.containsKey(token.surface)) {
                        throw new ExpressionException("Unknown operator or function: " + token);
                    }
                    arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.70
                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public BigDecimal eval() {
                            LazyNumber lazyNumber = Expression.this.variables.get(token.surface);
                            BigDecimal bigDecimalEval = lazyNumber == null ? null : lazyNumber.eval();
                            if (bigDecimalEval == null) {
                                return null;
                            }
                            return bigDecimalEval.round(Expression.this.mc);
                        }

                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public String getString() {
                            return Expression.this.variables.get(token.surface).getString();
                        }
                    });
                    break;
                    break;
                case 5:
                    me.ulrich.clans.library.udojava.evalex.LazyFunction lazyFunction = this.functions.get(token.surface.toUpperCase(Locale.ROOT));
                    ArrayList arrayList = new ArrayList(!lazyFunction.numParamsVaries() ? lazyFunction.getNumParams() : 0);
                    while (!arrayDeque.isEmpty() && arrayDeque.peek() != PARAMS_START) {
                        arrayList.add(0, arrayDeque.pop());
                    }
                    if (arrayDeque.peek() == PARAMS_START) {
                        arrayDeque.pop();
                    }
                    arrayDeque.push(lazyFunction.lazyEval(arrayList));
                    break;
                case 6:
                default:
                    throw new ExpressionException("Unexpected token " + token.surface, token.pos);
                case OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                    if (this.operators.get(token.surface).isUnaryOperator()) {
                        final LazyNumber lazyNumber = (LazyNumber) arrayDeque.pop();
                        arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.68
                            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                            public BigDecimal eval() {
                                return Expression.this.operators.get(token.surface).eval(lazyNumber, null).eval();
                            }

                            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                            public String getString() {
                                return String.valueOf(Expression.this.operators.get(token.surface).eval(lazyNumber, null).eval());
                            }
                        });
                    } else {
                        final LazyNumber lazyNumber2 = (LazyNumber) arrayDeque.pop();
                        final LazyNumber lazyNumber3 = (LazyNumber) arrayDeque.pop();
                        arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.69
                            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                            public BigDecimal eval() {
                                return Expression.this.operators.get(token.surface).eval(lazyNumber3, lazyNumber2).eval();
                            }

                            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                            public String getString() {
                                return String.valueOf(Expression.this.operators.get(token.surface).eval(lazyNumber3, lazyNumber2).eval());
                            }
                        });
                    }
                    break;
                case 8:
                    final LazyNumber lazyNumber4 = (LazyNumber) arrayDeque.pop();
                    arrayDeque.push(new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.67
                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public BigDecimal eval() {
                            return Expression.this.operators.get(token.surface).eval(lazyNumber4, null).eval();
                        }

                        @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                        public String getString() {
                            return String.valueOf(Expression.this.operators.get(token.surface).eval(lazyNumber4, null).eval());
                        }
                    });
                    break;
                case 9:
                    arrayDeque.push(PARAMS_START);
                    break;
            }
        }
        BigDecimal bigDecimalEval = ((LazyNumber) arrayDeque.pop()).eval();
        if (bigDecimalEval == null) {
            return null;
        }
        if (z) {
            bigDecimalEval = bigDecimalEval.stripTrailingZeros();
        }
        return bigDecimalEval;
    }

    public Expression setPrecision(int i) {
        this.mc = new MathContext(i);
        return this;
    }

    public Expression setRoundingMode(RoundingMode roundingMode) {
        this.mc = new MathContext(this.mc.getPrecision(), roundingMode);
        return this;
    }

    public Expression setFirstVariableCharacters(String str) {
        this.firstVarChars = str;
        return this;
    }

    public Expression setVariableCharacters(String str) {
        this.varChars = str;
        return this;
    }

    public <OPERATOR extends LazyOperator> OPERATOR addOperator(OPERATOR operator) {
        String oper = operator.getOper();
        if (operator instanceof AbstractUnaryOperator) {
            oper = oper + "u";
        }
        return (OPERATOR) this.operators.put(oper, operator);
    }

    public me.ulrich.clans.library.udojava.evalex.Function addFunction(me.ulrich.clans.library.udojava.evalex.Function function) {
        return (me.ulrich.clans.library.udojava.evalex.Function) this.functions.put(function.getName(), function);
    }

    public me.ulrich.clans.library.udojava.evalex.LazyFunction addLazyFunction(me.ulrich.clans.library.udojava.evalex.LazyFunction lazyFunction) {
        return this.functions.put(lazyFunction.getName(), lazyFunction);
    }

    public Expression setVariable(String str, BigDecimal bigDecimal) {
        return setVariable(str, createLazyNumber(bigDecimal));
    }

    public Expression setVariable(String str, LazyNumber lazyNumber) {
        this.variables.put(str, lazyNumber);
        return this;
    }

    public Expression setVariable(String str, final String str2) {
        if (isNumber(str2)) {
            this.variables.put(str, createLazyNumber(new BigDecimal(str2, this.mc)));
        } else if (str2.equalsIgnoreCase("null")) {
            this.variables.put(str, null);
        } else {
            this.variables.put(str, new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.74
                private final Map<String, LazyNumber> outerVariables;
                private final Map<String, me.ulrich.clans.library.udojava.evalex.LazyFunction> outerFunctions;
                private final Map<String, LazyOperator> outerOperators;
                private final String innerExpressionString;
                private final MathContext inneMc;

                {
                    this.outerVariables = Expression.this.variables;
                    this.outerFunctions = Expression.this.functions;
                    this.outerOperators = Expression.this.operators;
                    this.innerExpressionString = str2;
                    this.inneMc = Expression.this.mc;
                }

                @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                public String getString() {
                    return this.innerExpressionString;
                }

                @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
                public BigDecimal eval() {
                    Expression expression = new Expression(this.innerExpressionString, this.inneMc);
                    expression.variables = this.outerVariables;
                    expression.functions = this.outerFunctions;
                    expression.operators = this.outerOperators;
                    return expression.eval();
                }
            });
            this.rpn = null;
        }
        return this;
    }

    private Expression createEmbeddedExpression(String str) {
        Map<String, LazyNumber> map = this.variables;
        Map<String, me.ulrich.clans.library.udojava.evalex.LazyFunction> map2 = this.functions;
        Map<String, LazyOperator> map3 = this.operators;
        Expression expression = new Expression(str, this.mc);
        expression.variables = map;
        expression.functions = map2;
        expression.operators = map3;
        return expression;
    }

    public Expression with(String str, BigDecimal bigDecimal) {
        return setVariable(str, bigDecimal);
    }

    public Expression with(String str, LazyNumber lazyNumber) {
        return setVariable(str, lazyNumber);
    }

    public Expression and(String str, String str2) {
        return setVariable(str, str2);
    }

    public Expression and(String str, BigDecimal bigDecimal) {
        return setVariable(str, bigDecimal);
    }

    public Expression and(String str, LazyNumber lazyNumber) {
        return setVariable(str, lazyNumber);
    }

    public Expression with(String str, String str2) {
        return setVariable(str, str2);
    }

    public Iterator<Token> getExpressionTokenizer() {
        return new Tokenizer(this.expressionString);
    }

    private List<Token> getRPN() {
        if (this.rpn == null) {
            this.rpn = shuntingYard(this.expressionString);
            validate(this.rpn);
        }
        return this.rpn;
    }

    private void validate(List<Token> list) {
        Stack stack = new Stack();
        stack.push(0);
        for (Token token : list) {
            switch (AnonymousClass75.$SwitchMap$com$udojava$evalex$Expression$TokenType[token.type.ordinal()]) {
                case 5:
                    me.ulrich.clans.library.udojava.evalex.LazyFunction lazyFunction = this.functions.get(token.surface.toUpperCase(Locale.ROOT));
                    if (lazyFunction == null) {
                        throw new ExpressionException("Unknown function " + token, token.pos + 1);
                    }
                    int iIntValue = ((Integer) stack.pop()).intValue();
                    if (!lazyFunction.numParamsVaries() && iIntValue != lazyFunction.getNumParams()) {
                        throw new ExpressionException("Function " + token + " expected " + lazyFunction.getNumParams() + " parameters, got " + iIntValue);
                    }
                    if (stack.isEmpty()) {
                        throw new ExpressionException("Too many function calls, maximum scope exceeded");
                    }
                    stack.set(stack.size() - 1, Integer.valueOf(((Integer) stack.peek()).intValue() + 1));
                    break;
                    break;
                case 6:
                default:
                    stack.set(stack.size() - 1, Integer.valueOf(((Integer) stack.peek()).intValue() + 1));
                    break;
                case OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                    int i = this.operators.get(token.surface).isUnaryOperator() ? 1 : 2;
                    if (((Integer) stack.peek()).intValue() < i) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token);
                    }
                    if (i > 1) {
                        stack.set(stack.size() - 1, Integer.valueOf((((Integer) stack.peek()).intValue() - i) + 1));
                    }
                    break;
                    break;
                case 8:
                    if (((Integer) stack.peek()).intValue() < 1) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token);
                    }
                    break;
                    break;
                case 9:
                    stack.push(0);
                    break;
            }
        }
        if (stack.size() > 1) {
            throw new ExpressionException("Too many unhandled function parameter lists");
        }
        if (((Integer) stack.peek()).intValue() > 1) {
            throw new ExpressionException("Too many numbers or variables");
        }
        if (((Integer) stack.peek()).intValue() < 1) {
            throw new ExpressionException("Empty expression");
        }
    }

    public String toRPN() {
        StringBuilder sb = new StringBuilder();
        for (Token token : getRPN()) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            if (token.type == TokenType.VARIABLE && this.variables.containsKey(token.surface)) {
                String string = this.variables.get(token.surface).getString();
                if (isNumber(string)) {
                    sb.append(token.toString());
                } else {
                    sb.append(createEmbeddedExpression(string).toRPN());
                }
            } else {
                sb.append(token.toString());
            }
        }
        return sb.toString();
    }

    public Set<String> getDeclaredVariables() {
        return Collections.unmodifiableSet(this.variables.keySet());
    }

    public Set<String> getDeclaredOperators() {
        return Collections.unmodifiableSet(this.operators.keySet());
    }

    public Set<String> getDeclaredFunctions() {
        return Collections.unmodifiableSet(this.functions.keySet());
    }

    public String getExpression() {
        return this.expressionString;
    }

    public List<String> getUsedVariables() {
        ArrayList arrayList = new ArrayList();
        Tokenizer tokenizer = new Tokenizer(this.expressionString);
        while (tokenizer.hasNext()) {
            Token next = tokenizer.next();
            String string = next.toString();
            if (next.type == TokenType.VARIABLE && !DEFAULT_CONSTANTS.containsKey(string)) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    public String getOriginalExpression() {
        return this.originalExpression;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Expression expression = (Expression) obj;
        if (this.expressionString == null) {
            return expression.expressionString == null;
        }
        return this.expressionString.equals(expression.expressionString);
    }

    public int hashCode() {
        if (this.expressionString == null) {
            return 0;
        }
        return this.expressionString.hashCode();
    }

    public String toString() {
        return this.expressionString;
    }

    public boolean isBoolean() {
        List<Token> rpn = getRPN();
        if (rpn.isEmpty()) {
            return false;
        }
        for (int size = rpn.size() - 1; size >= 0; size--) {
            Token token = rpn.get(size);
            if (!token.surface.equals("IF")) {
                if (token.type == TokenType.FUNCTION) {
                    return this.functions.get(token.surface).isBooleanFunction();
                }
                if (token.type == TokenType.OPERATOR) {
                    return this.operators.get(token.surface).isBooleanOperator();
                }
            }
        }
        return false;
    }

    public List<String> infixNotation() {
        ArrayList arrayList = new ArrayList();
        Tokenizer tokenizer = new Tokenizer(this.expressionString);
        while (tokenizer.hasNext()) {
            Token next = tokenizer.next();
            arrayList.add("{" + next.type + ":" + next.surface + "}");
        }
        return arrayList;
    }

    static {
        DEFAULT_CONSTANTS.put("e", e);
        DEFAULT_CONSTANTS.put("PI", PI);
        DEFAULT_CONSTANTS.put("NULL", null);
        DEFAULT_CONSTANTS.put("TRUE", BigDecimal.ONE);
        DEFAULT_CONSTANTS.put("FALSE", BigDecimal.ZERO);
        PARAMS_START = new LazyNumber() { // from class: me.ulrich.clans.library.udojava.evalex.Expression.1
            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public BigDecimal eval() {
                return null;
            }

            @Override // me.ulrich.clans.library.udojava.evalex.Expression.LazyNumber
            public String getString() {
                return null;
            }
        };
    }
}
