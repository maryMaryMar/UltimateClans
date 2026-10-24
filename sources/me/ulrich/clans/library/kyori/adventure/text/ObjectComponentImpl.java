package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.object.ObjectContents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ObjectComponentImpl.class */
final class ObjectComponentImpl extends AbstractComponent implements ObjectComponent {
    private final ObjectContents contents;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ObjectComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractComponentBuilder<ObjectComponent, ObjectComponent.Builder> implements ObjectComponent.Builder {
        private ObjectContents objectContents;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull ObjectComponent objectComponent) {
            super(objectComponent);
            this.objectContents = objectComponent.contents();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ObjectComponent.Builder
        @NotNull
        public ObjectComponent.Builder contents(@NotNull ObjectContents objectContents) {
            this.objectContents = (ObjectContents) Objects.requireNonNull(objectContents, "contents");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public ObjectComponent build2() {
            if (this.objectContents == null) {
                throw new IllegalStateException("contents must be set");
            }
            return ObjectComponentImpl.create(this.children, buildStyle(), this.objectContents);
        }
    }

    private ObjectComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull ObjectContents objectContents) {
        super(list, style);
        this.contents = objectContents;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ObjectComponent
    @NotNull
    public ObjectContents contents() {
        return this.contents;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ObjectComponent
    @NotNull
    public ObjectComponent contents(@NotNull ObjectContents objectContents) {
        return create(this.children, this.style, objectContents);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ObjectComponent) && super.equals(obj)) {
            return Objects.equals(this.contents, ((ObjectComponentImpl) obj).contents());
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * super.hashCode()) + this.contents.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public ObjectComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @NotNull
    static ObjectComponentImpl create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull ObjectContents objectContents) {
        return new ObjectComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (ObjectContents) Objects.requireNonNull(objectContents, "contents"));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public ObjectComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.contents);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public ObjectComponent style(@NotNull Style style) {
        return create(this.children, style, this.contents);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
