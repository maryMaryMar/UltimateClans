package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.BuildableComponent;
import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ComponentBuilder.class */
@ApiStatus.NonExtendable
public interface ComponentBuilder<C extends BuildableComponent<C, B>, B extends ComponentBuilder<C, B>> extends AbstractBuilder<C>, ComponentBuilderApplicable, ComponentLike, MutableStyleSetter<B>, Buildable.Builder<C> {
    @Contract("_ -> this")
    @NotNull
    B append(@NotNull Component component);

    @Contract("_ -> this")
    @NotNull
    default B append(@NotNull ComponentLike componentLike) {
        return (B) append(componentLike.asComponent());
    }

    @Contract("_ -> this")
    @NotNull
    default B append(@NotNull ComponentBuilder<?, ?> componentBuilder) {
        return (B) append((Component) componentBuilder.build2());
    }

    @Contract("_ -> this")
    @NotNull
    B append(@NotNull Component... componentArr);

    @Contract("_ -> this")
    @NotNull
    B append(@NotNull ComponentLike... componentLikeArr);

    @Contract("_ -> this")
    @NotNull
    B append(@NotNull Iterable<? extends ComponentLike> iterable);

    @NotNull
    default B appendNewline() {
        return (B) append((Component) Component.newline());
    }

    @NotNull
    default B appendSpace() {
        return (B) append((Component) Component.space());
    }

    @Contract("_ -> this")
    @NotNull
    default B apply(@NotNull Consumer<? super ComponentBuilder<?, ?>> consumer) {
        consumer.accept(this);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    B applyDeep(@NotNull Consumer<? super ComponentBuilder<?, ?>> consumer);

    @Contract("_ -> this")
    @NotNull
    B mapChildren(@NotNull Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> function);

    @Contract("_ -> this")
    @NotNull
    B mapChildrenDeep(@NotNull Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> function);

    @NotNull
    List<Component> children();

    @Contract("_ -> this")
    @NotNull
    B style(@NotNull Style style);

    @Contract("_ -> this")
    @NotNull
    B style(@NotNull Consumer<Style.Builder> consumer);

    @Contract("_ -> this")
    @NotNull
    B font(@Nullable Key key);

    @Contract("_ -> this")
    @NotNull
    B color(@Nullable TextColor textColor);

    @Contract("_ -> this")
    @NotNull
    B colorIfAbsent(@Nullable TextColor textColor);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_, _ -> this")
    @NotNull
    default B decorations(@NotNull Set<TextDecoration> set, boolean z) {
        return (B) super.decorations(set, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    default B decorate(@NotNull TextDecoration textDecoration) {
        return (B) decoration(textDecoration, TextDecoration.State.TRUE);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    default B decorate(@NotNull TextDecoration... textDecorationArr) {
        return (B) super.decorate(textDecorationArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_, _ -> this")
    @NotNull
    default B decoration(@NotNull TextDecoration textDecoration, boolean z) {
        return (B) decoration(textDecoration, TextDecoration.State.byBoolean(z));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    default B decorations(@NotNull Map<TextDecoration, TextDecoration.State> map) {
        return (B) super.decorations(map);
    }

    @Contract("_, _ -> this")
    @NotNull
    B decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state);

    @Contract("_, _ -> this")
    @NotNull
    B decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state);

    @Contract("_ -> this")
    @NotNull
    B clickEvent(@Nullable ClickEvent clickEvent);

    @Contract("_ -> this")
    @NotNull
    B hoverEvent(@Nullable HoverEventSource<?> hoverEventSource);

    @Contract("_ -> this")
    @NotNull
    B insertion(@Nullable String str);

    @Contract("_ -> this")
    @NotNull
    default B mergeStyle(@NotNull Component component) {
        return (B) mergeStyle(component, Style.Merge.all());
    }

    @Contract("_, _ -> this")
    @NotNull
    default B mergeStyle(@NotNull Component component, Style.Merge... mergeArr) {
        return (B) mergeStyle(component, Style.Merge.merges(mergeArr));
    }

    @Contract("_, _ -> this")
    @NotNull
    B mergeStyle(@NotNull Component component, @NotNull Set<Style.Merge> set);

    @NotNull
    B resetStyle();

    @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
    @NotNull
    /* JADX INFO: renamed from: build */
    C build2();

    @Contract("_ -> this")
    @NotNull
    default B applicableApply(@NotNull ComponentBuilderApplicable componentBuilderApplicable) {
        componentBuilderApplicable.componentBuilderApply(this);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilderApplicable
    default void componentBuilderApply(@NotNull ComponentBuilder<?, ?> componentBuilder) {
        componentBuilder.append((ComponentBuilder<?, ?>) this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentLike
    @NotNull
    default Component asComponent() {
        return build2();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_, _ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default MutableStyleSetter decorations(@NotNull Set set, boolean z) {
        return decorations((Set<TextDecoration>) set, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default MutableStyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }

    @Contract("_ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
        return hoverEvent((HoverEventSource<?>) hoverEventSource);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_, _ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Set set, boolean z) {
        return decorations((Set<TextDecoration>) set, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract("_ -> this")
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }
}
