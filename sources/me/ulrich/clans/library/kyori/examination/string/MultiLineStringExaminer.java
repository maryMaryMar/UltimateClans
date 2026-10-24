package me.ulrich.clans.library.kyori.examination.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.AbstractExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/string/MultiLineStringExaminer.class */
public class MultiLineStringExaminer extends AbstractExaminer<Stream<String>> {
    private static final String INDENT_2 = "  ";
    private final StringExaminer examiner;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/string/MultiLineStringExaminer$Instances.class */
    private static final class Instances {
        static final MultiLineStringExaminer SIMPLE_ESCAPING = new MultiLineStringExaminer(StringExaminer.simpleEscaping());

        private Instances() {
        }
    }

    @NotNull
    public static MultiLineStringExaminer simpleEscaping() {
        return Instances.SIMPLE_ESCAPING;
    }

    public MultiLineStringExaminer(@NotNull StringExaminer stringExaminer) {
        this.examiner = stringExaminer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <E> Stream<String> array(E[] eArr, @NotNull Stream<Stream<String>> stream) {
        return arrayLike(stream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <E> Stream<String> collection(@NotNull Collection<E> collection, @NotNull Stream<Stream<String>> stream) {
        return arrayLike(stream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> examinable(@NotNull String str, @NotNull Stream<Map.Entry<String, Stream<String>>> stream) {
        return enclose(indent(flatten(",", stream.map(entry -> {
            return association(examine((String) entry.getKey()), " = ", (Stream<String>) entry.getValue());
        }))), str + "{", "}");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <K, V> Stream<String> map(@NotNull Map<K, V> map, @NotNull Stream<Map.Entry<Stream<String>, Stream<String>>> stream) {
        return enclose(indent(flatten(",", stream.map(entry -> {
            return association((Stream<String>) entry.getKey(), " = ", (Stream<String>) entry.getValue());
        }))), "{", "}");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> nil() {
        return Stream.of(this.examiner.nil());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> scalar(@NotNull Object obj) {
        return Stream.of(this.examiner.scalar(obj));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(boolean z) {
        return Stream.of(this.examiner.examine(z));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(byte b) {
        return Stream.of(this.examiner.examine(b));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(char c) {
        return Stream.of(this.examiner.examine(c));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(double d) {
        return Stream.of(this.examiner.examine(d));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(float f) {
        return Stream.of(this.examiner.examine(f));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(int i) {
        return Stream.of(this.examiner.examine(i));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(long j) {
        return Stream.of(this.examiner.examine(j));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(short s) {
        return Stream.of(this.examiner.examine(s));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> array(int i, IntFunction<Stream<String>> intFunction) {
        return arrayLike(i == 0 ? Stream.empty() : IntStream.range(0, i).mapToObj(intFunction));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public <T> Stream<String> stream(@NotNull Stream<T> stream) {
        return arrayLike(stream.map(this::examine));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> stream(@NotNull DoubleStream doubleStream) {
        return arrayLike(doubleStream.mapToObj(this::examine));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> stream(@NotNull IntStream intStream) {
        return arrayLike(intStream.mapToObj(this::examine));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.examination.AbstractExaminer
    @NotNull
    public Stream<String> stream(@NotNull LongStream longStream) {
        return arrayLike(longStream.mapToObj(this::examine));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examiner
    @NotNull
    public Stream<String> examine(@Nullable String str) {
        return Stream.of(this.examiner.examine(str));
    }

    private Stream<String> arrayLike(Stream<Stream<String>> stream) {
        return enclose(indent(flatten(",", stream)), "[", "]");
    }

    private static Stream<String> enclose(Stream<String> stream, String str, String str2) {
        return enclose((List<String>) stream.collect(Collectors.toList()), str, str2);
    }

    private static Stream<String> enclose(List<String> list, String str, String str2) {
        return list.isEmpty() ? Stream.of(str + str2) : (Stream) Stream.of((Object[]) new Stream[]{Stream.of(str), indent(list.stream()), Stream.of(str2)}).reduce(Stream.empty(), Stream::concat);
    }

    private static Stream<String> flatten(String str, Stream<Stream<String>> stream) {
        ArrayList arrayList = new ArrayList();
        stream.forEachOrdered(stream2 -> {
            if (!arrayList.isEmpty()) {
                int size = arrayList.size() - 1;
                arrayList.set(size, ((String) arrayList.get(size)) + str);
            }
            Objects.requireNonNull(arrayList);
            stream2.forEachOrdered((v1) -> {
                r1.add(v1);
            });
        });
        return arrayList.stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Stream<String> association(Stream<String> stream, String str, Stream<String> stream2) {
        return association((List<String>) stream.collect(Collectors.toList()), str, (List<String>) stream2.collect(Collectors.toList()));
    }

    private static Stream<String> association(List<String> list, String str, List<String> list2) {
        int size = list.size();
        int size2 = list2.size();
        int iMax = Math.max(size, size2);
        int iMaxLength = Strings.maxLength(list.stream());
        String strRepeat = size < 2 ? "" : Strings.repeat(" ", iMaxLength);
        String strRepeat2 = size < 2 ? "" : Strings.repeat(" ", str.length());
        ArrayList arrayList = new ArrayList(iMax);
        int i = 0;
        while (i < iMax) {
            arrayList.add((i < size ? Strings.padEnd(list.get(i), iMaxLength, ' ') : strRepeat) + (i == 0 ? str : strRepeat2) + (i < size2 ? list2.get(i) : ""));
            i++;
        }
        return arrayList.stream();
    }

    private static Stream<String> indent(Stream<String> stream) {
        return stream.map(str -> {
            return INDENT_2 + str;
        });
    }
}
