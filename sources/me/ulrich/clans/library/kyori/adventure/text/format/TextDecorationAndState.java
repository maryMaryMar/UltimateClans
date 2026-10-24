package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/TextDecorationAndState.class */
@ApiStatus.NonExtendable
public interface TextDecorationAndState extends StyleBuilderApplicable, Examinable {
    @NotNull
    TextDecoration decoration();

    TextDecoration.State state();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable
    default void styleApply(Style.Builder builder) {
        builder.decoration(decoration(), state());
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("decoration", decoration()), ExaminableProperty.of("state", state())});
    }
}
