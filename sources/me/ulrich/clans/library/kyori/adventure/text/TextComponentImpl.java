package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.internal.properties.AdventureProperties;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.util.Nag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextComponentImpl.class */
class TextComponentImpl extends AbstractComponent implements TextComponent {

    @VisibleForTesting
    static final char SECTION_CHAR = 167;
    private final String content;
    private static final boolean WARN_WHEN_LEGACY_FORMATTING_DETECTED = Boolean.TRUE.equals(AdventureProperties.TEXT_WARN_WHEN_LEGACY_FORMATTING_DETECTED.value());
    static final TextComponent EMPTY = createDirect("");
    static final TextComponent NEWLINE = createDirect("\n");
    static final TextComponent SPACE = createDirect(" ");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextComponentImpl$BuilderImpl.class */
    static class BuilderImpl extends AbstractComponentBuilder<TextComponent, TextComponent.Builder> implements TextComponent.Builder {
        private String content;

        BuilderImpl() {
            this.content = "";
        }

        BuilderImpl(@NotNull TextComponent textComponent) {
            super(textComponent);
            this.content = "";
            this.content = textComponent.content();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponent.Builder
        @NotNull
        public TextComponent.Builder content(@NotNull String str) {
            this.content = (String) Objects.requireNonNull(str, "content");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponent.Builder
        @NotNull
        public String content() {
            return this.content;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public TextComponent build2() {
            return isEmpty() ? Component.empty() : TextComponentImpl.create(this.children, buildStyle(), this.content);
        }

        private boolean isEmpty() {
            return this.content.isEmpty() && this.children.isEmpty() && !hasStyle();
        }
    }

    static TextComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str) {
        List<Component> listAsComponents = ComponentLike.asComponents(list, IS_NOT_EMPTY);
        return (listAsComponents.isEmpty() && style.isEmpty() && str.isEmpty()) ? Component.empty() : new TextComponentImpl(listAsComponents, (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "content"));
    }

    TextComponent create0(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str) {
        return create(list, style, str);
    }

    @NotNull
    private static TextComponent createDirect(@NotNull String str) {
        return new TextComponentImpl(Collections.emptyList(), Style.empty(), str);
    }

    TextComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull String str) {
        LegacyFormattingDetected legacyFormattingDetectedWarnWhenLegacyFormattingDetected;
        super(list, style);
        this.content = str;
        if (!WARN_WHEN_LEGACY_FORMATTING_DETECTED || (legacyFormattingDetectedWarnWhenLegacyFormattingDetected = warnWhenLegacyFormattingDetected()) == null) {
            return;
        }
        Nag.print(legacyFormattingDetectedWarnWhenLegacyFormattingDetected);
    }

    @VisibleForTesting
    @Nullable
    final LegacyFormattingDetected warnWhenLegacyFormattingDetected() {
        if (this.content.indexOf(167) != -1) {
            return new LegacyFormattingDetected(this);
        }
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponent
    @NotNull
    public String content() {
        return this.content;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponent
    @NotNull
    public TextComponent content(@NotNull String str) {
        return Objects.equals(this.content, str) ? this : create0(this.children, this.style, str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public TextComponent children(@NotNull List<? extends ComponentLike> list) {
        return create0(list, this.style, this.content);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public TextComponent style(@NotNull Style style) {
        return create0(this.children, style, this.content);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TextComponentImpl) && super.equals(obj)) {
            return Objects.equals(this.content, ((TextComponentImpl) obj).content);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * super.hashCode()) + this.content.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public TextComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
