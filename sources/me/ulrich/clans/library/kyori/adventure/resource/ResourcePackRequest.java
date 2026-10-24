package me.ulrich.clans.library.kyori.adventure.resource;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackRequest.class */
@ApiStatus.NonExtendable
public interface ResourcePackRequest extends ResourcePackRequestLike, Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackRequest$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder extends AbstractBuilder<ResourcePackRequest>, ResourcePackRequestLike {
        @Contract("_, _ -> this")
        @NotNull
        Builder packs(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr);

        @Contract("_ -> this")
        @NotNull
        Builder packs(@NotNull Iterable<? extends ResourcePackInfoLike> iterable);

        @Contract("_ -> this")
        @NotNull
        Builder callback(@NotNull ResourcePackCallback resourcePackCallback);

        @Contract("_ -> this")
        @NotNull
        Builder replace(boolean z);

        @Contract("_ -> this")
        @NotNull
        Builder required(boolean z);

        @Contract("_ -> this")
        @NotNull
        Builder prompt(@Nullable Component component);

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequestLike
        @NotNull
        default ResourcePackRequest asResourcePackRequest() {
            return build();
        }
    }

    @NotNull
    static ResourcePackRequest addingRequest(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr) {
        return resourcePackRequest().packs(resourcePackInfoLike, resourcePackInfoLikeArr).replace(false).build();
    }

    @NotNull
    static Builder resourcePackRequest() {
        return new ResourcePackRequestImpl.BuilderImpl();
    }

    @NotNull
    static Builder resourcePackRequest(@NotNull ResourcePackRequest resourcePackRequest) {
        return new ResourcePackRequestImpl.BuilderImpl((ResourcePackRequest) Objects.requireNonNull(resourcePackRequest, "existing"));
    }

    @NotNull
    List<ResourcePackInfo> packs();

    @NotNull
    ResourcePackRequest packs(@NotNull Iterable<? extends ResourcePackInfoLike> iterable);

    @NotNull
    ResourcePackCallback callback();

    @NotNull
    ResourcePackRequest callback(@NotNull ResourcePackCallback resourcePackCallback);

    boolean replace();

    @NotNull
    ResourcePackRequest replace(boolean z);

    boolean required();

    @Nullable
    Component prompt();

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequestLike
    @NotNull
    default ResourcePackRequest asResourcePackRequest() {
        return this;
    }
}
