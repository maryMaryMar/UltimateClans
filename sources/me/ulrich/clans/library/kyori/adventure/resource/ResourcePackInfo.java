package me.ulrich.clans.library.kyori.adventure.resource;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackInfo.class */
@ApiStatus.NonExtendable
public interface ResourcePackInfo extends ResourcePackInfoLike, Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackInfo$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder extends AbstractBuilder<ResourcePackInfo>, ResourcePackInfoLike {
        @Contract("_ -> this")
        @NotNull
        Builder id(@NotNull UUID uuid);

        @Contract("_ -> this")
        @NotNull
        Builder uri(@NotNull URI uri);

        @Contract("_ -> this")
        @NotNull
        Builder hash(@NotNull String str);

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        ResourcePackInfo build();

        @NotNull
        default CompletableFuture<ResourcePackInfo> computeHashAndBuild() {
            return computeHashAndBuild(ForkJoinPool.commonPool());
        }

        @NotNull
        CompletableFuture<ResourcePackInfo> computeHashAndBuild(@NotNull Executor executor);

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfoLike
        @NotNull
        default ResourcePackInfo asResourcePackInfo() {
            return build();
        }
    }

    @NotNull
    static ResourcePackInfo resourcePackInfo(@NotNull UUID uuid, @NotNull URI uri, @NotNull String str) {
        return new ResourcePackInfoImpl(uuid, uri, str);
    }

    @NotNull
    static Builder resourcePackInfo() {
        return new ResourcePackInfoImpl.BuilderImpl();
    }

    @NotNull
    UUID id();

    @NotNull
    URI uri();

    @NotNull
    String hash();

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfoLike
    @NotNull
    default ResourcePackInfo asResourcePackInfo() {
        return this;
    }
}
