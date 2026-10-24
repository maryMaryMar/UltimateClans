package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextComponent.class */
public interface TextComponent extends BuildableComponent<TextComponent, Builder>, ScopedComponent<TextComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextComponent$Builder.class */
    public interface Builder extends ComponentBuilder<TextComponent, Builder> {
        @NotNull
        String content();

        @Contract("_ -> this")
        @NotNull
        Builder content(@NotNull String str);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static TextComponent ofChildren(@NotNull ComponentLike... componentLikeArr) {
        return Component.textOfChildren(componentLikeArr);
    }

    @NotNull
    String content();

    @Contract(pure = true)
    @NotNull
    TextComponent content(@NotNull String str);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("content", content())), super.examinableProperties());
    }
}
