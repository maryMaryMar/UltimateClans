package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/KeybindComponentImpl.class */
final class KeybindComponentImpl extends AbstractComponent implements KeybindComponent {
    private final String keybind;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/KeybindComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractComponentBuilder<KeybindComponent, KeybindComponent.Builder> implements KeybindComponent.Builder {

        @Nullable
        private String keybind;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull KeybindComponent keybindComponent) {
            super(keybindComponent);
            this.keybind = keybindComponent.keybind();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.KeybindComponent.Builder
        @NotNull
        public KeybindComponent.Builder keybind(@NotNull String str) {
            this.keybind = (String) Objects.requireNonNull(str, "keybind");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public KeybindComponent build2() {
            if (this.keybind == null) {
                throw new IllegalStateException("keybind must be set");
            }
            return KeybindComponentImpl.create(this.children, buildStyle(), this.keybind);
        }
    }

    static KeybindComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str) {
        return new KeybindComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "keybind"));
    }

    KeybindComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull String str) {
        super(list, style);
        this.keybind = str;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.KeybindComponent
    @NotNull
    public String keybind() {
        return this.keybind;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.KeybindComponent
    @NotNull
    public KeybindComponent keybind(@NotNull String str) {
        return Objects.equals(this.keybind, str) ? this : create(this.children, this.style, str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public KeybindComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.keybind);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public KeybindComponent style(@NotNull Style style) {
        return create(this.children, style, this.keybind);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof KeybindComponent) && super.equals(obj)) {
            return Objects.equals(this.keybind, ((KeybindComponent) obj).keybind());
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * super.hashCode()) + this.keybind.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public KeybindComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
