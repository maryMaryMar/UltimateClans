package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ScoreComponentImpl.class */
final class ScoreComponentImpl extends AbstractComponent implements ScoreComponent {
    private final String name;
    private final String objective;

    @Deprecated
    @Nullable
    private final String value;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ScoreComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractComponentBuilder<ScoreComponent, ScoreComponent.Builder> implements ScoreComponent.Builder {

        @Nullable
        private String name;

        @Nullable
        private String objective;

        @Nullable
        private String value;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull ScoreComponent scoreComponent) {
            super(scoreComponent);
            this.name = scoreComponent.name();
            this.objective = scoreComponent.objective();
            this.value = scoreComponent.value();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent.Builder
        @NotNull
        public ScoreComponent.Builder name(@NotNull String str) {
            this.name = (String) Objects.requireNonNull(str, "name");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent.Builder
        @NotNull
        public ScoreComponent.Builder objective(@NotNull String str) {
            this.objective = (String) Objects.requireNonNull(str, "objective");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent.Builder
        @Deprecated
        @NotNull
        public ScoreComponent.Builder value(@Nullable String str) {
            this.value = str;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public ScoreComponent build2() {
            if (this.name == null) {
                throw new IllegalStateException("name must be set");
            }
            if (this.objective == null) {
                throw new IllegalStateException("objective must be set");
            }
            return ScoreComponentImpl.create(this.children, buildStyle(), this.name, this.objective, this.value);
        }
    }

    static ScoreComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        return new ScoreComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "name"), (String) Objects.requireNonNull(str2, "objective"), str3);
    }

    ScoreComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        super(list, style);
        this.name = str;
        this.objective = str2;
        this.value = str3;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent
    @NotNull
    public String name() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent
    @NotNull
    public ScoreComponent name(@NotNull String str) {
        return Objects.equals(this.name, str) ? this : create(this.children, this.style, str, this.objective, this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent
    @NotNull
    public String objective() {
        return this.objective;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent
    @NotNull
    public ScoreComponent objective(@NotNull String str) {
        return Objects.equals(this.objective, str) ? this : create(this.children, this.style, this.name, str, this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent
    @Deprecated
    @Nullable
    public String value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ScoreComponent
    @Deprecated
    @NotNull
    public ScoreComponent value(@Nullable String str) {
        return Objects.equals(this.value, str) ? this : create(this.children, this.style, this.name, this.objective, str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public ScoreComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.name, this.objective, this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public ScoreComponent style(@NotNull Style style) {
        return create(this.children, style, this.name, this.objective, this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScoreComponent) || !super.equals(obj)) {
            return false;
        }
        ScoreComponent scoreComponent = (ScoreComponent) obj;
        return Objects.equals(this.name, scoreComponent.name()) && Objects.equals(this.objective, scoreComponent.objective()) && Objects.equals(this.value, scoreComponent.value());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * ((31 * ((31 * super.hashCode()) + this.name.hashCode())) + this.objective.hashCode())) + Objects.hashCode(this.value);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public ScoreComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
