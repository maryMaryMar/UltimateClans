package org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:org/json/JSONTokener.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:org/json/JSONTokener.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/json/JSONTokener.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONTokener.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/json/JSONTokener.class */
public class JSONTokener {
    private long character;
    private boolean eof;
    private long index;
    private long line;
    private char previous;
    private final Reader reader;
    private boolean usePrevious;
    private long characterPreviousLine;
    private JSONParserConfiguration jsonParserConfiguration;

    public JSONTokener(Reader reader) {
        this(reader, new JSONParserConfiguration());
    }

    public JSONTokener(Reader reader, JSONParserConfiguration jSONParserConfiguration) {
        this.jsonParserConfiguration = jSONParserConfiguration;
        this.reader = reader.markSupported() ? reader : new BufferedReader(reader);
        this.eof = false;
        this.usePrevious = false;
        this.previous = (char) 0;
        this.index = 0L;
        this.character = 1L;
        this.characterPreviousLine = 0L;
        this.line = 1L;
    }

    public JSONTokener(InputStream inputStream) {
        this(inputStream, new JSONParserConfiguration());
    }

    public JSONTokener(InputStream inputStream, JSONParserConfiguration jSONParserConfiguration) {
        this(new InputStreamReader(inputStream, Charset.forName("UTF-8")), jSONParserConfiguration);
    }

    public JSONTokener(String str) {
        this(new StringReader(str));
    }

    public JSONTokener(String str, JSONParserConfiguration jSONParserConfiguration) {
        this(new StringReader(str), jSONParserConfiguration);
    }

    public JSONParserConfiguration getJsonParserConfiguration() {
        return this.jsonParserConfiguration;
    }

    @Deprecated
    public void setJsonParserConfiguration(JSONParserConfiguration jSONParserConfiguration) {
        this.jsonParserConfiguration = jSONParserConfiguration;
    }

    public void back() {
        if (this.usePrevious || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        decrementIndexes();
        this.usePrevious = true;
        this.eof = false;
    }

    private void decrementIndexes() {
        this.index--;
        if (this.previous == '\r' || this.previous == '\n') {
            this.line--;
            this.character = this.characterPreviousLine;
        } else if (this.character > 0) {
            this.character--;
        }
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    public boolean end() {
        return this.eof && !this.usePrevious;
    }

    public boolean more() {
        if (this.usePrevious) {
            return true;
        }
        try {
            this.reader.mark(1);
            try {
                if (this.reader.read() <= 0) {
                    this.eof = true;
                    return false;
                }
                this.reader.reset();
                return true;
            } catch (IOException e) {
                throw new JSONException("Unable to read the next character from the stream", e);
            }
        } catch (IOException e2) {
            throw new JSONException("Unable to preserve stream position", e2);
        }
    }

    public char next() {
        int i;
        if (this.usePrevious) {
            this.usePrevious = false;
            i = this.previous;
        } else {
            try {
                i = this.reader.read();
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        if (i <= 0) {
            this.eof = true;
            return (char) 0;
        }
        incrementIndexes(i);
        this.previous = (char) i;
        return this.previous;
    }

    protected char getPrevious() {
        return this.previous;
    }

    private void incrementIndexes(int i) {
        if (i > 0) {
            this.index++;
            if (i == 13) {
                this.line++;
                this.characterPreviousLine = this.character;
                this.character = 0L;
            } else {
                if (i != 10) {
                    this.character++;
                    return;
                }
                if (this.previous != '\r') {
                    this.line++;
                    this.characterPreviousLine = this.character;
                }
                this.character = 0L;
            }
        }
    }

    public char next(char c) {
        char next = next();
        if (next == c) {
            return next;
        }
        if (next > 0) {
            throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
        }
        throw syntaxError("Expected '" + c + "' and instead saw ''");
    }

    public String next(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = next();
            if (end()) {
                throw syntaxError("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    public char nextClean() {
        char next;
        do {
            next = next();
            if (next == 0) {
                break;
            }
        } while (next <= ' ');
        return next;
    }

    public String nextString(char c) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char next = next();
            switch (next) {
                case 0:
                case '\n':
                case '\r':
                    throw syntaxError("Unterminated string. Character with int code " + ((int) next) + " is not allowed within a quoted string.");
                case TokenParser.ESCAPE /* 92 */:
                    char next2 = next();
                    switch (next2) {
                        case '\"':
                        case '\'':
                        case TokenParser.CLOSE_TAG /* 47 */:
                        case TokenParser.ESCAPE /* 92 */:
                            sb.append(next2);
                            break;
                        case 'b':
                            sb.append('\b');
                            break;
                        case 'f':
                            sb.append('\f');
                            break;
                        case 'n':
                            sb.append('\n');
                            break;
                        case 'r':
                            sb.append('\r');
                            break;
                        case 't':
                            sb.append('\t');
                            break;
                        case 'u':
                            String next3 = next(4);
                            try {
                                sb.append((char) Integer.parseInt(next3, 16));
                            } catch (NumberFormatException e) {
                                throw syntaxError("Illegal escape. \\u must be followed by a 4 digit hexadecimal number. \\" + next3 + " is not valid.", e);
                            }
                            break;
                        default:
                            throw syntaxError("Illegal escape. Escape sequence  \\" + next2 + " is not valid.");
                    }
                    break;
                default:
                    if (next == c) {
                        return sb.toString();
                    }
                    sb.append(next);
                    break;
            }
        }
    }

    public String nextTo(char c) {
        char next;
        StringBuilder sb = new StringBuilder();
        while (true) {
            next = next();
            if (next == c || next == 0 || next == '\n' || next == '\r') {
                break;
            }
            sb.append(next);
        }
        if (next != 0) {
            back();
        }
        return sb.toString().trim();
    }

    public String nextTo(String str) {
        char next;
        StringBuilder sb = new StringBuilder();
        while (true) {
            next = next();
            if (str.indexOf(next) >= 0 || next == 0 || next == '\n' || next == '\r') {
                break;
            }
            sb.append(next);
        }
        if (next != 0) {
            back();
        }
        return sb.toString().trim();
    }

    public Object nextValue() {
        char cNextClean = nextClean();
        switch (cNextClean) {
            case '[':
                back();
                try {
                    return new JSONArray(this, this.jsonParserConfiguration);
                } catch (StackOverflowError e) {
                    throw new JSONException("JSON Array or Object depth too large to process.", e);
                }
            case '{':
                back();
                try {
                    return new JSONObject(this, this.jsonParserConfiguration);
                } catch (StackOverflowError e2) {
                    throw new JSONException("JSON Array or Object depth too large to process.", e2);
                }
            default:
                return nextSimpleValue(cNextClean);
        }
    }

    Object nextSimpleValue(char c) {
        if (this.jsonParserConfiguration != null && this.jsonParserConfiguration.isStrictMode() && c == '\'') {
            throw syntaxError("Strict mode error: Single quoted strings are not allowed");
        }
        switch (c) {
            case '\"':
            case '\'':
                return nextString(c);
            default:
                StringBuilder sb = new StringBuilder();
                while (c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0) {
                    sb.append(c);
                    c = next();
                }
                if (!this.eof) {
                    back();
                }
                String strTrim = sb.toString().trim();
                if ("".equals(strTrim)) {
                    throw syntaxError("Missing value");
                }
                if (this.jsonParserConfiguration != null && this.jsonParserConfiguration.isStrictMode() && strTrim.endsWith(".")) {
                    throw syntaxError(String.format("Strict mode error: Value '%s' ends with dot", strTrim));
                }
                Object objStringToValue = JSONObject.stringToValue(strTrim);
                if (this.jsonParserConfiguration != null && this.jsonParserConfiguration.isStrictMode()) {
                    if ((objStringToValue instanceof Boolean) && !"true".equals(strTrim) && !"false".equals(strTrim)) {
                        throw syntaxError(String.format("Strict mode error: Value '%s' is not lowercase boolean", objStringToValue));
                    }
                    if (objStringToValue == JSONObject.NULL && !"null".equals(strTrim)) {
                        throw syntaxError(String.format("Strict mode error: Value '%s' is not lowercase null", objStringToValue));
                    }
                    if (objStringToValue instanceof String) {
                        throw syntaxError(String.format("Strict mode error: Value '%s' is not surrounded by quotes", objStringToValue));
                    }
                }
                return objStringToValue;
        }
    }

    public char skipTo(char c) {
        char next;
        try {
            long j = this.index;
            long j2 = this.character;
            long j3 = this.line;
            this.reader.mark(1000000);
            do {
                next = next();
                if (next == 0) {
                    this.reader.reset();
                    this.index = j;
                    this.character = j2;
                    this.line = j3;
                    return (char) 0;
                }
            } while (next != c);
            this.reader.mark(1);
            back();
            return next;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public JSONException syntaxError(String str, Throwable th) {
        return new JSONException(str + toString(), th);
    }

    public String toString() {
        return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
    }

    public void close() throws IOException {
        if (this.reader != null) {
            this.reader.close();
        }
    }
}
