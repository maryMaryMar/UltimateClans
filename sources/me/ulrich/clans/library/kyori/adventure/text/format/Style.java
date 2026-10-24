package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.adventure.util.MonkeyBars;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/Style.class */
@ApiStatus.NonExtendable
public interface Style extends StyleGetter, StyleSetter<Style>, Buildable<Style, Builder>, Examinable {
    public static final Key DEFAULT_FONT = Key.key("default");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/Style$Builder.class */
    public interface Builder extends AbstractBuilder<Style>, MutableStyleSetter<Builder>, Buildable.Builder<Style> {
        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        Builder font(@Nullable Key key);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        Builder color(@Nullable TextColor textColor);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        Builder colorIfAbsent(@Nullable TextColor textColor);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        default Builder decorate(@NotNull TextDecoration textDecoration) {
            return (Builder) super.decorate(textDecoration);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        default Builder decorate(@NotNull TextDecoration... textDecorationArr) {
            return (Builder) super.decorate(textDecorationArr);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_, _ -> this")
        @NotNull
        default Builder decoration(@NotNull TextDecoration textDecoration, boolean z) {
            return (Builder) super.decoration(textDecoration, z);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        default Builder decorations(@NotNull Map<TextDecoration, TextDecoration.State> map) {
            return (Builder) super.decorations(map);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_, _ -> this")
        @NotNull
        Builder decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_, _ -> this")
        @NotNull
        Builder decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        Builder clickEvent(@Nullable ClickEvent clickEvent);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        Builder hoverEvent(@Nullable HoverEventSource<?> hoverEventSource);

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        Builder insertion(@Nullable String str);

        @Contract("_ -> this")
        @NotNull
        default Builder merge(@NotNull Style style) {
            return merge(style, Merge.all());
        }

        @Contract("_, _ -> this")
        @NotNull
        default Builder merge(@NotNull Style style, Merge.Strategy strategy) {
            return merge(style, strategy, Merge.all());
        }

        @Contract("_, _ -> this")
        @NotNull
        default Builder merge(@NotNull Style style, @NotNull Merge... mergeArr) {
            return mergeArr.length == 0 ? this : merge(style, Merge.merges(mergeArr));
        }

        @Contract("_, _, _ -> this")
        @NotNull
        default Builder merge(@NotNull Style style, Merge.Strategy strategy, @NotNull Merge... mergeArr) {
            return mergeArr.length == 0 ? this : merge(style, strategy, Merge.merges(mergeArr));
        }

        @Contract("_, _ -> this")
        @NotNull
        default Builder merge(@NotNull Style style, @NotNull Set<Merge> set) {
            return merge(style, Merge.Strategy.ALWAYS, set);
        }

        @Contract("_, _, _ -> this")
        @NotNull
        Builder merge(@NotNull Style style, Merge.Strategy strategy, @NotNull Set<Merge> set);

        @Contract("_ -> this")
        @NotNull
        default Builder apply(@NotNull StyleBuilderApplicable styleBuilderApplicable) {
            styleBuilderApplicable.styleApply(this);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        Style build2();

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        /* bridge */ /* synthetic */ default MutableStyleSetter decorations(@NotNull Map map) {
            return decorations((Map<TextDecoration, TextDecoration.State>) map);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        /* bridge */ /* synthetic */ default StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
            return hoverEvent((HoverEventSource<?>) hoverEventSource);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.MutableStyleSetter, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @Contract("_ -> this")
        @NotNull
        /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Map map) {
            return decorations((Map<TextDecoration, TextDecoration.State>) map);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/Style$Merge.class */
    public enum Merge {
        COLOR,
        SHADOW_COLOR,
        DECORATIONS,
        EVENTS,
        INSERTION,
        FONT;

        static final Set<Merge> ALL = merges(values());
        static final Set<Merge> COLOR_AND_DECORATIONS = merges(COLOR, DECORATIONS);

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/Style$Merge$Strategy.class */
        public enum Strategy {
            ALWAYS,
            NEVER,
            IF_ABSENT_ON_TARGET
        }

        @NotNull
        public static Set<Merge> all() {
            return ALL;
        }

        @NotNull
        public static Set<Merge> colorAndDecorations() {
            return COLOR_AND_DECORATIONS;
        }

        @NotNull
        public static Set<Merge> merges(Merge... mergeArr) {
            return MonkeyBars.enumSet(Merge.class, mergeArr);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static Set<Merge> of(Merge... mergeArr) {
            return MonkeyBars.enumSet(Merge.class, mergeArr);
        }

        static boolean hasAll(@NotNull Set<Merge> set) {
            return set.size() == ALL.size();
        }
    }

    @NotNull
    static Style empty() {
        return StyleImpl.EMPTY;
    }

    @NotNull
    static Builder style() {
        return new StyleImpl.BuilderImpl();
    }

    @NotNull
    static Style style(@NotNull Consumer<Builder> consumer) {
        return (Style) AbstractBuilder.configureAndBuild(style(), consumer);
    }

    @NotNull
    static Style style(@Nullable TextColor textColor) {
        return empty().color(textColor);
    }

    @NotNull
    static Style style(@NotNull TextDecoration textDecoration) {
        return style().decoration(textDecoration, true).build2();
    }

    @NotNull
    static Style style(@Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        Builder builderStyle = style();
        builderStyle.color(textColor);
        builderStyle.decorate(textDecorationArr);
        return builderStyle.build2();
    }

    @NotNull
    static Style style(@Nullable TextColor textColor, Set<TextDecoration> set) {
        Builder builderStyle = style();
        builderStyle.color(textColor);
        if (!set.isEmpty()) {
            Iterator<TextDecoration> it = set.iterator();
            while (it.hasNext()) {
                builderStyle.decoration(it.next(), true);
            }
        }
        return builderStyle.build2();
    }

    @NotNull
    static Style style(StyleBuilderApplicable... styleBuilderApplicableArr) {
        if (styleBuilderApplicableArr.length == 0) {
            return empty();
        }
        Builder builderStyle = style();
        for (StyleBuilderApplicable styleBuilderApplicable : styleBuilderApplicableArr) {
            if (styleBuilderApplicable != null) {
                styleBuilderApplicable.styleApply(builderStyle);
            }
        }
        return builderStyle.build2();
    }

    @NotNull
    static Style style(@NotNull Iterable<? extends StyleBuilderApplicable> iterable) {
        Builder builderStyle = style();
        Iterator<? extends StyleBuilderApplicable> it = iterable.iterator();
        while (it.hasNext()) {
            it.next().styleApply(builderStyle);
        }
        return builderStyle.build2();
    }

    @NotNull
    default Style edit(@NotNull Consumer<Builder> consumer) {
        return edit(consumer, Merge.Strategy.ALWAYS);
    }

    @NotNull
    default Style edit(@NotNull Consumer<Builder> consumer, Merge.Strategy strategy) {
        return style((Consumer<Builder>) builder -> {
            if (strategy == Merge.Strategy.ALWAYS) {
                builder.merge(this, strategy);
            }
            consumer.accept(builder);
            if (strategy == Merge.Strategy.IF_ABSENT_ON_TARGET) {
                builder.merge(this, strategy);
            }
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    Key font();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style font(@Nullable Key key);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    TextColor color();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style color(@Nullable TextColor textColor);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style colorIfAbsent(@Nullable TextColor textColor);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    default boolean hasDecoration(@NotNull TextDecoration textDecoration) {
        return super.hasDecoration(textDecoration);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    TextDecoration.State decoration(@NotNull TextDecoration textDecoration);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default Style decorate(@NotNull TextDecoration textDecoration) {
        return (Style) super.decorate(textDecoration);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default Style decoration(@NotNull TextDecoration textDecoration, boolean z) {
        return (Style) super.decoration(textDecoration, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @NotNull
    default Map<TextDecoration, TextDecoration.State> decorations() {
        return super.decorations();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style decorations(@NotNull Map<TextDecoration, TextDecoration.State> map);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    ClickEvent clickEvent();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style clickEvent(@Nullable ClickEvent clickEvent);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    HoverEvent<?> hoverEvent();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style hoverEvent(@Nullable HoverEventSource<?> hoverEventSource);

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    String insertion();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    Style insertion(@Nullable String str);

    @NotNull
    default Style merge(@NotNull Style style) {
        return merge(style, Merge.all());
    }

    @NotNull
    default Style merge(@NotNull Style style, Merge.Strategy strategy) {
        return merge(style, strategy, Merge.all());
    }

    @NotNull
    default Style merge(@NotNull Style style, @NotNull Merge merge) {
        return merge(style, Collections.singleton(merge));
    }

    @NotNull
    default Style merge(@NotNull Style style, Merge.Strategy strategy, @NotNull Merge merge) {
        return merge(style, strategy, Collections.singleton(merge));
    }

    @NotNull
    default Style merge(@NotNull Style style, @NotNull Merge... mergeArr) {
        return merge(style, Merge.merges(mergeArr));
    }

    @NotNull
    default Style merge(@NotNull Style style, Merge.Strategy strategy, @NotNull Merge... mergeArr) {
        return merge(style, strategy, Merge.merges(mergeArr));
    }

    @NotNull
    default Style merge(@NotNull Style style, @NotNull Set<Merge> set) {
        return merge(style, Merge.Strategy.ALWAYS, set);
    }

    @NotNull
    Style merge(@NotNull Style style, Merge.Strategy strategy, @NotNull Set<Merge> set);

    @NotNull
    Style unmerge(@NotNull Style style);

    boolean isEmpty();

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    Builder mo683toBuilder();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
        return hoverEvent((HoverEventSource<?>) hoverEventSource);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }
}
