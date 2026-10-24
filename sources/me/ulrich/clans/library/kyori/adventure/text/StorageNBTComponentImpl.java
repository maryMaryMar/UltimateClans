package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/StorageNBTComponentImpl.class */
final class StorageNBTComponentImpl extends NBTComponentImpl<StorageNBTComponent, StorageNBTComponent.Builder> implements StorageNBTComponent {
    private final Key storage;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/StorageNBTComponentImpl$BuilderImpl.class */
    static class BuilderImpl extends AbstractNBTComponentBuilder<StorageNBTComponent, StorageNBTComponent.Builder> implements StorageNBTComponent.Builder {

        @Nullable
        private Key storage;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull StorageNBTComponent storageNBTComponent) {
            super(storageNBTComponent);
            this.storage = storageNBTComponent.storage();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent.Builder
        public StorageNBTComponent.Builder storage(@NotNull Key key) {
            this.storage = (Key) Objects.requireNonNull(key, "storage");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public StorageNBTComponent build2() {
            if (this.nbtPath == null) {
                throw new IllegalStateException("nbt path must be set");
            }
            if (this.storage == null) {
                throw new IllegalStateException("storage must be set");
            }
            return StorageNBTComponentImpl.create(this.children, buildStyle(), this.nbtPath, this.interpret, this.separator, this.storage);
        }
    }

    @NotNull
    static StorageNBTComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, String str, boolean z, @Nullable ComponentLike componentLike, @NotNull Key key) {
        return new StorageNBTComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "nbtPath"), z, ComponentLike.unbox(componentLike), (Key) Objects.requireNonNull(key, "storage"));
    }

    StorageNBTComponentImpl(@NotNull List<Component> list, @NotNull Style style, String str, boolean z, @Nullable Component component, Key key) {
        super(list, style, str, z, component);
        this.storage = key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public StorageNBTComponent nbtPath(@NotNull String str) {
        return Objects.equals(this.nbtPath, str) ? this : create(this.children, this.style, str, this.interpret, this.separator, this.storage);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public StorageNBTComponent interpret(boolean z) {
        return this.interpret == z ? this : create(this.children, this.style, this.nbtPath, z, this.separator, this.storage);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @Nullable
    public Component separator() {
        return this.separator;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public StorageNBTComponent separator(@Nullable ComponentLike componentLike) {
        return create(this.children, this.style, this.nbtPath, this.interpret, componentLike, this.storage);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent
    @NotNull
    public Key storage() {
        return this.storage;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent
    @NotNull
    public StorageNBTComponent storage(@NotNull Key key) {
        return Objects.equals(this.storage, key) ? this : create(this.children, this.style, this.nbtPath, this.interpret, this.separator, key);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public StorageNBTComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.nbtPath, this.interpret, this.separator, this.storage);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public StorageNBTComponent style(@NotNull Style style) {
        return create(this.children, style, this.nbtPath, this.interpret, this.separator, this.storage);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof StorageNBTComponent) && super.equals(obj)) {
            return Objects.equals(this.storage, ((StorageNBTComponentImpl) obj).storage());
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * super.hashCode()) + this.storage.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public StorageNBTComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
