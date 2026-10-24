package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/VirtualComponentImpl.class */
final class VirtualComponentImpl<C> extends TextComponentImpl implements VirtualComponent {
    private final Class<C> contextType;
    private final VirtualComponentRenderer<C> renderer;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/VirtualComponentImpl$BuilderImpl.class */
    static final class BuilderImpl<C> extends TextComponentImpl.BuilderImpl {
        private final Class<C> contextType;
        private final VirtualComponentRenderer<C> renderer;

        BuilderImpl(VirtualComponentImpl<C> virtualComponentImpl) {
            super(virtualComponentImpl);
            this.contextType = virtualComponentImpl.contextType();
            this.renderer = virtualComponentImpl.renderer();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl.BuilderImpl, me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public TextComponent build2() {
            return VirtualComponentImpl.createVirtual(this.contextType, this.renderer, this.children, buildStyle());
        }
    }

    static <C> VirtualComponent createVirtual(@NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer) {
        return createVirtual(cls, virtualComponentRenderer, Collections.emptyList(), Style.empty());
    }

    static <C> VirtualComponent createVirtual(@NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer, List<? extends ComponentLike> list, Style style) {
        return new VirtualComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), style, "", cls, virtualComponentRenderer);
    }

    private VirtualComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull String str, @NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer) {
        super(list, style, str);
        this.contextType = cls;
        this.renderer = virtualComponentRenderer;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl
    VirtualComponent create0(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str) {
        return new VirtualComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), style, str, this.contextType, this.renderer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.VirtualComponent
    @NotNull
    public Class<C> contextType() {
        return this.contextType;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.VirtualComponent
    @NotNull
    public VirtualComponentRenderer<C> renderer() {
        return this.renderer;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl, me.ulrich.clans.library.kyori.adventure.text.TextComponent
    @NotNull
    public String content() {
        return this.renderer.fallbackString();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl, me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public TextComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VirtualComponentImpl) || !super.equals(obj)) {
            return false;
        }
        VirtualComponentImpl virtualComponentImpl = (VirtualComponentImpl) obj;
        return Objects.equals(this.contextType, virtualComponentImpl.contextType) && Objects.equals(this.renderer, virtualComponentImpl.renderer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * ((31 * super.hashCode()) + this.contextType.hashCode())) + this.renderer.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TextComponentImpl
    /* bridge */ /* synthetic */ TextComponent create0(@NotNull List list, @NotNull Style style, @NotNull String str) {
        return create0((List<? extends ComponentLike>) list, style, str);
    }
}
