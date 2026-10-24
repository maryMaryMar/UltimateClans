package me.ulrich.clans.library.kyori.examination.string;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.AbstractExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/string/StringExaminer.class */
public class StringExaminer extends AbstractExaminer<String> {
    private static final Function<String, String> DEFAULT_ESCAPER = str -> {
        return str.replace("\"", "\\\"").replace("\\", "\\\\").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    };
    private static final Collector<CharSequence, ?, String> COMMA_CURLY = Collectors.joining(", ", "{", "}");
    private static final Collector<CharSequence, ?, String> COMMA_SQUARE = Collectors.joining(", ", "[", "]");
    private final Function<String, String> escaper;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/string/StringExaminer$Instances.class */
    private static final class Instances {
        static final StringExaminer SIMPLE_ESCAPING = new StringExaminer(StringExaminer.DEFAULT_ESCAPER);

        private Instances() {
        }
    }

    @NotNull
    public static StringExaminer simpleEscaping() {
        return Instances.SIMPLE_ESCAPING;
    }

    public StringExaminer(@NotNull Function<String, String> function) {
        this.escaper = function;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <E> String array(E[] eArr, @NotNull Stream<String> stream) {
        return (String) stream.collect(COMMA_SQUARE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <E> String collection(@NotNull Collection<E> collection, @NotNull Stream<String> stream) {
        return (String) stream.collect(COMMA_SQUARE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String examinable(@NotNull String str, @NotNull Stream<Map.Entry<String, String>> stream) {
        return str + ((String) stream.map(entry -> {
            return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
        }).collect(COMMA_CURLY));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <K, V> String map(@NotNull Map<K, V> map, @NotNull Stream<Map.Entry<String, String>> stream) {
        return (String) stream.map(entry -> {
            return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
        }).collect(COMMA_CURLY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String nil() {
        return "null";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String scalar(@NotNull Object obj) {
        return String.valueOf(obj);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(boolean z) {
        return String.valueOf(z);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(byte b) {
        return String.valueOf((int) b);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(char c) {
        return Strings.wrapIn(this.escaper.apply(String.valueOf(c)), '\'');
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(double d) {
        return Strings.withSuffix(String.valueOf(d), 'd');
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(float f) {
        return Strings.withSuffix(String.valueOf(f), 'f');
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(int i) {
        return String.valueOf(i);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(long j) {
        return String.valueOf(j);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(short s) {
        return String.valueOf((int) s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <T> String stream(@NotNull Stream<T> stream) {
        return (String) stream.map(this::examine).collect(COMMA_SQUARE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String stream(@NotNull DoubleStream doubleStream) {
        return (String) doubleStream.mapToObj(this::examine).collect(COMMA_SQUARE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String stream(@NotNull IntStream intStream) {
        return (String) intStream.mapToObj(this::examine).collect(COMMA_SQUARE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String stream(@NotNull LongStream longStream) {
        return (String) longStream.mapToObj(this::examine).collect(COMMA_SQUARE);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public String examine(@Nullable String str) {
        return str == null ? nil() : Strings.wrapIn(this.escaper.apply(str), '\"');
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public String array(int i, IntFunction<String> intFunction) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(intFunction.apply(i2));
            if (i2 + 1 < i) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
