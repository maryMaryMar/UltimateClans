package me.ulrich.clans.library.kyori.examination;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/Examinable.class */
public interface Examinable {
    @NotNull
    default String examinableName() {
        return getClass().getSimpleName();
    }

    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.empty();
    }

    @NotNull
    default <R> R examine(@NotNull Examiner<R> examiner) {
        return examiner.examine(this);
    }
}
