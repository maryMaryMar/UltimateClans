package me.ulrich.clans.library.kyori.adventure.builder;

import java.util.function.Consumer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/builder/AbstractBuilder.class */
@FunctionalInterface
public interface AbstractBuilder<R> {
    @Contract(mutates = "param1")
    @NotNull
    static <R, B extends AbstractBuilder<R>> R configureAndBuild(@NotNull B b, @Nullable Consumer<? super B> consumer) {
        if (consumer != null) {
            consumer.accept(b);
        }
        return (R) b.build();
    }

    @Contract(value = "-> new", pure = true)
    @NotNull
    R build();
}
