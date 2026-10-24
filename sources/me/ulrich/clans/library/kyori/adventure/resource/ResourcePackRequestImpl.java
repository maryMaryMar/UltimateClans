package me.ulrich.clans.library.kyori.adventure.resource;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.util.MonkeyBars;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackRequestImpl.class */
final class ResourcePackRequestImpl implements ResourcePackRequest {
    private final List<ResourcePackInfo> packs;
    private final ResourcePackCallback cb;
    private final boolean replace;
    private final boolean required;

    @Nullable
    private final Component prompt;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackRequestImpl$BuilderImpl.class */
    static final class BuilderImpl implements ResourcePackRequest.Builder {
        private List<ResourcePackInfo> packs;
        private ResourcePackCallback cb;
        private boolean replace;
        private boolean required;

        @Nullable
        private Component prompt;

        BuilderImpl() {
            this.packs = Collections.emptyList();
            this.cb = ResourcePackCallback.noOp();
            this.replace = false;
        }

        BuilderImpl(@NotNull ResourcePackRequest resourcePackRequest) {
            this.packs = resourcePackRequest.packs();
            this.cb = resourcePackRequest.callback();
            this.replace = resourcePackRequest.replace();
            this.required = resourcePackRequest.required();
            this.prompt = resourcePackRequest.prompt();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest.Builder
        @NotNull
        public ResourcePackRequest.Builder packs(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr) {
            this.packs = MonkeyBars.nonEmptyArrayToList((v0) -> {
                return v0.asResourcePackInfo();
            }, resourcePackInfoLike, resourcePackInfoLikeArr);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest.Builder
        @NotNull
        public ResourcePackRequest.Builder packs(@NotNull Iterable<? extends ResourcePackInfoLike> iterable) {
            this.packs = MonkeyBars.toUnmodifiableList((v0) -> {
                return v0.asResourcePackInfo();
            }, iterable);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest.Builder
        @NotNull
        public ResourcePackRequest.Builder callback(@NotNull ResourcePackCallback resourcePackCallback) {
            this.cb = (ResourcePackCallback) Objects.requireNonNull(resourcePackCallback, "cb");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest.Builder
        @NotNull
        public ResourcePackRequest.Builder replace(boolean z) {
            this.replace = z;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest.Builder
        @NotNull
        public ResourcePackRequest.Builder required(boolean z) {
            this.required = z;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest.Builder
        @NotNull
        public ResourcePackRequest.Builder prompt(@Nullable Component component) {
            this.prompt = component;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public ResourcePackRequest build2() {
            return new ResourcePackRequestImpl(this.packs, this.cb, this.replace, this.required, this.prompt);
        }
    }

    ResourcePackRequestImpl(List<ResourcePackInfo> list, ResourcePackCallback resourcePackCallback, boolean z, boolean z2, @Nullable Component component) {
        this.packs = list;
        this.cb = resourcePackCallback;
        this.replace = z;
        this.required = z2;
        this.prompt = component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    @NotNull
    public List<ResourcePackInfo> packs() {
        return this.packs;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    @NotNull
    public ResourcePackRequest packs(@NotNull Iterable<? extends ResourcePackInfoLike> iterable) {
        return this.packs.equals(iterable) ? this : new ResourcePackRequestImpl(MonkeyBars.toUnmodifiableList((v0) -> {
            return v0.asResourcePackInfo();
        }, iterable), this.cb, this.replace, this.required, this.prompt);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    @NotNull
    public ResourcePackCallback callback() {
        return this.cb;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    @NotNull
    public ResourcePackRequest callback(@NotNull ResourcePackCallback resourcePackCallback) {
        return resourcePackCallback == this.cb ? this : new ResourcePackRequestImpl(this.packs, (ResourcePackCallback) Objects.requireNonNull(resourcePackCallback, "cb"), this.replace, this.required, this.prompt);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    public boolean replace() {
        return this.replace;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    public boolean required() {
        return this.required;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    @Nullable
    public Component prompt() {
        return this.prompt;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest
    @NotNull
    public ResourcePackRequest replace(boolean z) {
        return z == this.replace ? this : new ResourcePackRequestImpl(this.packs, this.cb, z, this.required, this.prompt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ResourcePackRequestImpl resourcePackRequestImpl = (ResourcePackRequestImpl) obj;
        return this.replace == resourcePackRequestImpl.replace && Objects.equals(this.packs, resourcePackRequestImpl.packs) && Objects.equals(this.cb, resourcePackRequestImpl.cb) && this.required == resourcePackRequestImpl.required && Objects.equals(this.prompt, resourcePackRequestImpl.prompt);
    }

    public int hashCode() {
        return Objects.hash(this.packs, this.cb, Boolean.valueOf(this.replace), Boolean.valueOf(this.required), this.prompt);
    }

    @NotNull
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("packs", this.packs), ExaminableProperty.of("callback", this.cb), ExaminableProperty.of("replace", this.replace), ExaminableProperty.of("required", this.required), ExaminableProperty.of("prompt", this.prompt)});
    }
}
