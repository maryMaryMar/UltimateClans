package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/StyleImpl.class */
final class StyleImpl implements Style {
    static final StyleImpl EMPTY = new StyleImpl(null, null, null, DecorationMap.EMPTY, null, null, null);

    @Nullable
    final Key font;

    @Nullable
    final TextColor color;

    @Nullable
    final ShadowColor shadowColor;

    @NotNull
    final DecorationMap decorations;

    @Nullable
    final ClickEvent clickEvent;

    @Nullable
    final HoverEvent<?> hoverEvent;

    @Nullable
    final String insertion;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/StyleImpl$BuilderImpl.class */
    static final class BuilderImpl implements Style.Builder {

        @Nullable
        Key font;

        @Nullable
        TextColor color;

        @Nullable
        ShadowColor shadowColor;
        DecorationMap decorations;

        @Nullable
        ClickEvent clickEvent;

        @Nullable
        HoverEvent<?> hoverEvent;

        @Nullable
        String insertion;

        BuilderImpl() {
            this.decorations = DecorationMap.EMPTY;
        }

        BuilderImpl(@NotNull StyleImpl styleImpl) {
            this.color = styleImpl.color;
            this.shadowColor = styleImpl.shadowColor;
            this.decorations = styleImpl.decorations;
            this.clickEvent = styleImpl.clickEvent;
            this.hoverEvent = styleImpl.hoverEvent;
            this.insertion = styleImpl.insertion;
            this.font = styleImpl.font;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder font(@Nullable Key key) {
            this.font = key;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder color(@Nullable TextColor textColor) {
            this.color = textColor;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder colorIfAbsent(@Nullable TextColor textColor) {
            if (this.color == null) {
                this.color = textColor;
            }
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder shadowColor(@Nullable ARGBLike aRGBLike) {
            this.shadowColor = aRGBLike == null ? null : ShadowColor.shadowColor(aRGBLike);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder shadowColorIfAbsent(@Nullable ARGBLike aRGBLike) {
            if (this.shadowColor == null) {
                this.shadowColor = aRGBLike == null ? null : ShadowColor.shadowColor(aRGBLike);
            }
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
            Objects.requireNonNull(state, "state");
            Objects.requireNonNull(textDecoration, "decoration");
            this.decorations = this.decorations.with(textDecoration, state);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
            Objects.requireNonNull(state, "state");
            TextDecoration.State state2 = this.decorations.get((Object) textDecoration);
            if (state2 == TextDecoration.State.NOT_SET) {
                this.decorations = this.decorations.with(textDecoration, state);
            }
            if (state2 != null) {
                return this;
            }
            throw new IllegalArgumentException(String.format("unknown decoration '%s'", textDecoration));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder clickEvent(@Nullable ClickEvent clickEvent) {
            this.clickEvent = clickEvent;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder hoverEvent(@Nullable HoverEventSource<?> hoverEventSource) {
            this.hoverEvent = HoverEventSource.unbox(hoverEventSource);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public Style.Builder insertion(@Nullable String str) {
            this.insertion = str;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder
        @NotNull
        public Style.Builder merge(@NotNull Style style, Style.Merge.Strategy strategy, @NotNull Set<Style.Merge> set) {
            Key keyFont;
            String strInsertion;
            ShadowColor shadowColor;
            TextColor textColorColor;
            Objects.requireNonNull(style, "style");
            Objects.requireNonNull(strategy, "strategy");
            Objects.requireNonNull(set, "merges");
            if (StyleImpl.nothingToMerge(style, strategy, set)) {
                return this;
            }
            if (set.contains(Style.Merge.COLOR) && (textColorColor = style.color()) != null && (strategy == Style.Merge.Strategy.ALWAYS || (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET && this.color == null))) {
                color(textColorColor);
            }
            if (set.contains(Style.Merge.SHADOW_COLOR) && (shadowColor = style.shadowColor()) != null && (strategy == Style.Merge.Strategy.ALWAYS || (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET && this.shadowColor == null))) {
                shadowColor((ARGBLike) shadowColor);
            }
            if (set.contains(Style.Merge.DECORATIONS)) {
                int length = DecorationMap.DECORATIONS.length;
                for (int i = 0; i < length; i++) {
                    TextDecoration textDecoration = DecorationMap.DECORATIONS[i];
                    TextDecoration.State stateDecoration = style.decoration(textDecoration);
                    if (stateDecoration != TextDecoration.State.NOT_SET) {
                        if (strategy == Style.Merge.Strategy.ALWAYS) {
                            decoration(textDecoration, stateDecoration);
                        } else if (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET) {
                            decorationIfAbsent(textDecoration, stateDecoration);
                        }
                    }
                }
            }
            if (set.contains(Style.Merge.EVENTS)) {
                ClickEvent clickEvent = style.clickEvent();
                if (clickEvent != null && (strategy == Style.Merge.Strategy.ALWAYS || (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET && this.clickEvent == null))) {
                    clickEvent(clickEvent);
                }
                HoverEvent<?> hoverEvent = style.hoverEvent();
                if (hoverEvent != null && (strategy == Style.Merge.Strategy.ALWAYS || (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET && this.hoverEvent == null))) {
                    hoverEvent((HoverEventSource<?>) hoverEvent);
                }
            }
            if (set.contains(Style.Merge.INSERTION) && (strInsertion = style.insertion()) != null && (strategy == Style.Merge.Strategy.ALWAYS || (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET && this.insertion == null))) {
                insertion(strInsertion);
            }
            if (set.contains(Style.Merge.FONT) && (keyFont = style.font()) != null && (strategy == Style.Merge.Strategy.ALWAYS || (strategy == Style.Merge.Strategy.IF_ABSENT_ON_TARGET && this.font == null))) {
                font(keyFont);
            }
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public Style build2() {
            return isEmpty() ? StyleImpl.EMPTY : new StyleImpl(this.font, this.color, this.shadowColor, this.decorations, this.clickEvent, this.hoverEvent, this.insertion);
        }

        private boolean isEmpty() {
            return this.color == null && this.shadowColor == null && this.decorations == DecorationMap.EMPTY && this.clickEvent == null && this.hoverEvent == null && this.insertion == null && this.font == null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style.Builder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
        @NotNull
        public /* bridge */ /* synthetic */ StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
            return hoverEvent((HoverEventSource<?>) hoverEventSource);
        }
    }

    StyleImpl(@Nullable Key key, @Nullable TextColor textColor, @Nullable ShadowColor shadowColor, @NotNull Map<TextDecoration, TextDecoration.State> map, @Nullable ClickEvent clickEvent, @Nullable HoverEvent<?> hoverEvent, @Nullable String str) {
        this.font = key;
        this.color = textColor;
        this.shadowColor = shadowColor;
        this.decorations = DecorationMap.fromMap(map);
        this.clickEvent = clickEvent;
        this.hoverEvent = hoverEvent;
        this.insertion = str;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    public Key font() {
        return this.font;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style font(@Nullable Key key) {
        return Objects.equals(this.font, key) ? this : new StyleImpl(key, this.color, this.shadowColor, this.decorations, this.clickEvent, this.hoverEvent, this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    public TextColor color() {
        return this.color;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style color(@Nullable TextColor textColor) {
        return Objects.equals(this.color, textColor) ? this : new StyleImpl(this.font, textColor, this.shadowColor, this.decorations, this.clickEvent, this.hoverEvent, this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style colorIfAbsent(@Nullable TextColor textColor) {
        return this.color == null ? color(textColor) : this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    public ShadowColor shadowColor() {
        return this.shadowColor;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style shadowColor(@Nullable ARGBLike aRGBLike) {
        if (Objects.equals(this.shadowColor, aRGBLike)) {
            return this;
        }
        return new StyleImpl(this.font, this.color, aRGBLike == null ? null : ShadowColor.shadowColor(aRGBLike), this.decorations, this.clickEvent, this.hoverEvent, this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style shadowColorIfAbsent(@Nullable ARGBLike aRGBLike) {
        return this.shadowColor == null ? shadowColor(aRGBLike) : this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    public TextDecoration.State decoration(@NotNull TextDecoration textDecoration) {
        TextDecoration.State state = this.decorations.get((Object) textDecoration);
        if (state != null) {
            return state;
        }
        throw new IllegalArgumentException(String.format("unknown decoration '%s'", textDecoration));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        Objects.requireNonNull(state, "state");
        return decoration(textDecoration) == state ? this : new StyleImpl(this.font, this.color, this.shadowColor, this.decorations.with(textDecoration, state), this.clickEvent, this.hoverEvent, this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        Objects.requireNonNull(state, "state");
        TextDecoration.State state2 = this.decorations.get((Object) textDecoration);
        if (state2 == TextDecoration.State.NOT_SET) {
            return new StyleImpl(this.font, this.color, this.shadowColor, this.decorations.with(textDecoration, state), this.clickEvent, this.hoverEvent, this.insertion);
        }
        if (state2 != null) {
            return this;
        }
        throw new IllegalArgumentException(String.format("unknown decoration '%s'", textDecoration));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @NotNull
    public Map<TextDecoration, TextDecoration.State> decorations() {
        return this.decorations;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style decorations(@NotNull Map<TextDecoration, TextDecoration.State> map) {
        return new StyleImpl(this.font, this.color, this.shadowColor, DecorationMap.merge(map, this.decorations), this.clickEvent, this.hoverEvent, this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    public ClickEvent clickEvent() {
        return this.clickEvent;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style clickEvent(@Nullable ClickEvent clickEvent) {
        return new StyleImpl(this.font, this.color, this.shadowColor, this.decorations, clickEvent, this.hoverEvent, this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    public HoverEvent<?> hoverEvent() {
        return this.hoverEvent;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style hoverEvent(@Nullable HoverEventSource<?> hoverEventSource) {
        return new StyleImpl(this.font, this.color, this.shadowColor, this.decorations, this.clickEvent, HoverEventSource.unbox(hoverEventSource), this.insertion);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    public String insertion() {
        return this.insertion;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public Style insertion(@Nullable String str) {
        return Objects.equals(this.insertion, str) ? this : new StyleImpl(this.font, this.color, this.shadowColor, this.decorations, this.clickEvent, this.hoverEvent, str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style
    @NotNull
    public Style merge(@NotNull Style style, Style.Merge.Strategy strategy, @NotNull Set<Style.Merge> set) {
        if (nothingToMerge(style, strategy, set)) {
            return this;
        }
        if (isEmpty() && Style.Merge.hasAll(set)) {
            return style;
        }
        Style.Builder builderMo683toBuilder = mo683toBuilder();
        builderMo683toBuilder.merge(style, strategy, set);
        return builderMo683toBuilder.build2();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style
    @NotNull
    public Style unmerge(@NotNull Style style) {
        if (isEmpty()) {
            return this;
        }
        BuilderImpl builderImpl = new BuilderImpl(this);
        if (Objects.equals(font(), style.font())) {
            builderImpl.font((Key) null);
        }
        if (Objects.equals(color(), style.color())) {
            builderImpl.color((TextColor) null);
        }
        if (Objects.equals(shadowColor(), style.shadowColor())) {
            builderImpl.shadowColor((ARGBLike) null);
        }
        int length = DecorationMap.DECORATIONS.length;
        for (int i = 0; i < length; i++) {
            TextDecoration textDecoration = DecorationMap.DECORATIONS[i];
            if (decoration(textDecoration) == style.decoration(textDecoration)) {
                builderImpl.decoration(textDecoration, TextDecoration.State.NOT_SET);
            }
        }
        if (Objects.equals(clickEvent(), style.clickEvent())) {
            builderImpl.clickEvent((ClickEvent) null);
        }
        if (Objects.equals(hoverEvent(), style.hoverEvent())) {
            builderImpl.hoverEvent((HoverEventSource<?>) null);
        }
        if (Objects.equals(insertion(), style.insertion())) {
            builderImpl.insertion((String) null);
        }
        return builderImpl.build2();
    }

    static boolean nothingToMerge(@NotNull Style style, Style.Merge.Strategy strategy, @NotNull Set<Style.Merge> set) {
        return strategy == Style.Merge.Strategy.NEVER || style.isEmpty() || set.isEmpty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public Style.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(this.decorations.examinableProperties(), Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("color", this.color), ExaminableProperty.of("shadowColor", this.shadowColor), ExaminableProperty.of("clickEvent", this.clickEvent), ExaminableProperty.of("hoverEvent", this.hoverEvent), ExaminableProperty.of("insertion", this.insertion), ExaminableProperty.of("font", this.font)}));
    }

    @NotNull
    public String toString() {
        return Internals.toString(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StyleImpl)) {
            return false;
        }
        StyleImpl styleImpl = (StyleImpl) obj;
        return Objects.equals(this.color, styleImpl.color) && this.decorations.equals(styleImpl.decorations) && Objects.equals(this.shadowColor, styleImpl.shadowColor) && Objects.equals(this.clickEvent, styleImpl.clickEvent) && Objects.equals(this.hoverEvent, styleImpl.hoverEvent) && Objects.equals(this.insertion, styleImpl.insertion) && Objects.equals(this.font, styleImpl.font);
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * Objects.hashCode(this.color)) + Objects.hashCode(this.shadowColor))) + this.decorations.hashCode())) + Objects.hashCode(this.clickEvent))) + Objects.hashCode(this.hoverEvent))) + Objects.hashCode(this.insertion))) + Objects.hashCode(this.font);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public /* bridge */ /* synthetic */ StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
        return hoverEvent((HoverEventSource<?>) hoverEventSource);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.Style, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public /* bridge */ /* synthetic */ StyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }
}
