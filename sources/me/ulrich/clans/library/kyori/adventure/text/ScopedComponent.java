package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ScopedComponent.class */
public interface ScopedComponent<C extends Component> extends Component {
    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ComponentLike
    @NotNull
    default C asComponent() {
        return (C) super.asComponent();
    }

    @NotNull
    C children(@NotNull List<? extends ComponentLike> list);

    @NotNull
    C style(@NotNull Style style);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C style(@NotNull Consumer<Style.Builder> consumer) {
        return (C) super.style(consumer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C style(Style.Builder builder) {
        return (C) super.style(builder);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C style(@NotNull Consumer<Style.Builder> consumer, Style.Merge.Strategy strategy) {
        return (C) super.style(consumer, strategy);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C mergeStyle(@NotNull Component component) {
        return (C) super.mergeStyle(component);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C mergeStyle(@NotNull Component component, Style.Merge... mergeArr) {
        return (C) super.mergeStyle(component, mergeArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C append(@NotNull Component component) {
        return (C) super.append(component);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C append(@NotNull ComponentLike componentLike) {
        return (C) super.append(componentLike);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C append(@NotNull ComponentBuilder<?, ?> componentBuilder) {
        return (C) super.append(componentBuilder);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C append(@NotNull List<? extends ComponentLike> list) {
        return (C) super.append(list);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C append(@NotNull ComponentLike... componentLikeArr) {
        return (C) super.append(componentLikeArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C appendNewline() {
        return (C) super.appendNewline();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C appendSpace() {
        return (C) super.appendSpace();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C applyFallbackStyle(@NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        return (C) super.applyFallbackStyle(styleBuilderApplicableArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C applyFallbackStyle(@NotNull Style style) {
        return (C) super.applyFallbackStyle(style);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    default C mergeStyle(@NotNull Component component, @NotNull Set<Style.Merge> set) {
        return (C) super.mergeStyle(component, set);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C color(@Nullable TextColor textColor) {
        return (C) super.color(textColor);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C colorIfAbsent(@Nullable TextColor textColor) {
        return (C) super.colorIfAbsent(textColor);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C shadowColor(@Nullable ARGBLike aRGBLike) {
        return (C) super.shadowColor(aRGBLike);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C shadowColorIfAbsent(@Nullable ARGBLike aRGBLike) {
        return (C) super.shadowColorIfAbsent(aRGBLike);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C decorate(@NotNull TextDecoration textDecoration) {
        return (C) super.decorate(textDecoration);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C decoration(@NotNull TextDecoration textDecoration, boolean z) {
        return (C) super.decoration(textDecoration, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        return (C) super.decoration(textDecoration, state);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        return (C) super.decorationIfAbsent(textDecoration, state);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C decorations(@NotNull Map<TextDecoration, TextDecoration.State> map) {
        return (C) super.decorations(map);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C clickEvent(@Nullable ClickEvent clickEvent) {
        return (C) super.clickEvent(clickEvent);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C hoverEvent(@Nullable HoverEventSource<?> hoverEventSource) {
        return (C) super.hoverEvent(hoverEventSource);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C insertion(@Nullable String str) {
        return (C) super.insertion(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default C font(@Nullable Key key) {
        return (C) super.font(key);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
        return hoverEvent((HoverEventSource<?>) hoverEventSource);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }
}
