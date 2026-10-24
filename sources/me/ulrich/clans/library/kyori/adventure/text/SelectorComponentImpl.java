package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/SelectorComponentImpl.class */
final class SelectorComponentImpl extends AbstractComponent implements SelectorComponent {
    private final String pattern;

    @Nullable
    private final Component separator;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/SelectorComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractComponentBuilder<SelectorComponent, SelectorComponent.Builder> implements SelectorComponent.Builder {

        @Nullable
        private String pattern;

        @Nullable
        private Component separator;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull SelectorComponent selectorComponent) {
            super(selectorComponent);
            this.pattern = selectorComponent.pattern();
            this.separator = selectorComponent.separator();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.SelectorComponent.Builder
        @NotNull
        public SelectorComponent.Builder pattern(@NotNull String str) {
            this.pattern = (String) Objects.requireNonNull(str, "pattern");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.SelectorComponent.Builder
        @NotNull
        public SelectorComponent.Builder separator(@Nullable ComponentLike componentLike) {
            this.separator = ComponentLike.unbox(componentLike);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public SelectorComponent build2() {
            if (this.pattern == null) {
                throw new IllegalStateException("pattern must be set");
            }
            return SelectorComponentImpl.create(this.children, buildStyle(), this.pattern, this.separator);
        }
    }

    static SelectorComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str, @Nullable ComponentLike componentLike) {
        return new SelectorComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "pattern"), ComponentLike.unbox(componentLike));
    }

    SelectorComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull String str, @Nullable Component component) {
        super(list, style);
        this.pattern = str;
        this.separator = component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.SelectorComponent
    @NotNull
    public String pattern() {
        return this.pattern;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.SelectorComponent
    @NotNull
    public SelectorComponent pattern(@NotNull String str) {
        return Objects.equals(this.pattern, str) ? this : create(this.children, this.style, str, this.separator);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.SelectorComponent
    @Nullable
    public Component separator() {
        return this.separator;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.SelectorComponent
    @NotNull
    public SelectorComponent separator(@Nullable ComponentLike componentLike) {
        return create(this.children, this.style, this.pattern, componentLike);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public SelectorComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.pattern, this.separator);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public SelectorComponent style(@NotNull Style style) {
        return create(this.children, style, this.pattern, this.separator);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectorComponent) || !super.equals(obj)) {
            return false;
        }
        SelectorComponent selectorComponent = (SelectorComponent) obj;
        return Objects.equals(this.pattern, selectorComponent.pattern()) && Objects.equals(this.separator, selectorComponent.separator());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * ((31 * super.hashCode()) + this.pattern.hashCode())) + Objects.hashCode(this.separator);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public SelectorComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
