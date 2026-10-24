package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/EntityNBTComponentImpl.class */
final class EntityNBTComponentImpl extends NBTComponentImpl<EntityNBTComponent, EntityNBTComponent.Builder> implements EntityNBTComponent {
    private final String selector;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/EntityNBTComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractNBTComponentBuilder<EntityNBTComponent, EntityNBTComponent.Builder> implements EntityNBTComponent.Builder {

        @Nullable
        private String selector;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull EntityNBTComponent entityNBTComponent) {
            super(entityNBTComponent);
            this.selector = entityNBTComponent.selector();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent.Builder
        public EntityNBTComponent.Builder selector(@NotNull String str) {
            this.selector = (String) Objects.requireNonNull(str, "selector");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public EntityNBTComponent build2() {
            if (this.nbtPath == null) {
                throw new IllegalStateException("nbt path must be set");
            }
            if (this.selector == null) {
                throw new IllegalStateException("selector must be set");
            }
            return EntityNBTComponentImpl.create(this.children, buildStyle(), this.nbtPath, this.interpret, this.separator, this.selector);
        }
    }

    static EntityNBTComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, String str, boolean z, @Nullable ComponentLike componentLike, String str2) {
        return new EntityNBTComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "nbtPath"), z, ComponentLike.unbox(componentLike), (String) Objects.requireNonNull(str2, "selector"));
    }

    EntityNBTComponentImpl(@NotNull List<Component> list, @NotNull Style style, String str, boolean z, @Nullable Component component, String str2) {
        super(list, style, str, z, component);
        this.selector = str2;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public EntityNBTComponent nbtPath(@NotNull String str) {
        return Objects.equals(this.nbtPath, str) ? this : create(this.children, this.style, str, this.interpret, this.separator, this.selector);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public EntityNBTComponent interpret(boolean z) {
        return this.interpret == z ? this : create(this.children, this.style, this.nbtPath, z, this.separator, this.selector);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @Nullable
    public Component separator() {
        return this.separator;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public EntityNBTComponent separator(@Nullable ComponentLike componentLike) {
        return create(this.children, this.style, this.nbtPath, this.interpret, componentLike, this.selector);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent
    @NotNull
    public String selector() {
        return this.selector;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent
    @NotNull
    public EntityNBTComponent selector(@NotNull String str) {
        return Objects.equals(this.selector, str) ? this : create(this.children, this.style, this.nbtPath, this.interpret, this.separator, str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public EntityNBTComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.nbtPath, this.interpret, this.separator, this.selector);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public EntityNBTComponent style(@NotNull Style style) {
        return create(this.children, style, this.nbtPath, this.interpret, this.separator, this.selector);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof EntityNBTComponent) && super.equals(obj)) {
            return Objects.equals(this.selector, ((EntityNBTComponentImpl) obj).selector());
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * super.hashCode()) + this.selector.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public EntityNBTComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
