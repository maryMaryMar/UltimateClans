package me.ulrich.clans.library.kyori.adventure.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/MonkeyBars.class */
public final class MonkeyBars {
    private MonkeyBars() {
    }

    @SafeVarargs
    @NotNull
    public static <E extends Enum<E>> Set<E> enumSet(Class<E> cls, E... eArr) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(cls);
        Collections.addAll(enumSetNoneOf, eArr);
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    @NotNull
    public static <T> List<T> addOne(@NotNull List<T> list, T t) {
        if (list.isEmpty()) {
            return Collections.singletonList(t);
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(t);
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    @NotNull
    public static <I, O> List<O> nonEmptyArrayToList(@NotNull Function<I, O> function, @NotNull I i, @NotNull I... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(function.apply(i));
        for (I i2 : iArr) {
            arrayList.add(Objects.requireNonNull(function.apply(Objects.requireNonNull(i2, "source[?]")), "mapper(source[?])"));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <I, O> List<O> toUnmodifiableList(@NotNull Function<I, O> function, @NotNull Iterable<? extends I> iterable) {
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList();
        Iterator<? extends I> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Objects.requireNonNull(function.apply(Objects.requireNonNull(it.next(), "source[?]")), "mapper(source[?])"));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
