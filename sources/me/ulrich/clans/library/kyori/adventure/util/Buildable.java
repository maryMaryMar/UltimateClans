package me.ulrich.clans.library.kyori.adventure.util;

import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Buildable.class */
public interface Buildable<R, B extends Builder<R>> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Buildable$Builder.class */
    @Deprecated
    public interface Builder<R> extends AbstractBuilder<R> {
        @Override // 
        @Contract(value = "-> new", pure = true)
        @NotNull
        R build();
    }

    /* JADX WARN: Incorrect return type in method signature: <R::Lme/ulrich/clans/library/kyori/adventure/util/Buildable<TR;TB;>;B::Lme/ulrich/clans/library/kyori/adventure/util/Buildable$Builder<TR;>;>(TB;Ljava/util/function/Consumer<-TB;>;)TR; */
    @Contract(mutates = "param1")
    @Deprecated
    @NotNull
    static Buildable configureAndBuild(@NotNull Builder builder, @Nullable Consumer consumer) {
        return (Buildable) AbstractBuilder.configureAndBuild(builder, consumer);
    }

    @Contract(value = "-> new", pure = true)
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    B mo683toBuilder();
}
