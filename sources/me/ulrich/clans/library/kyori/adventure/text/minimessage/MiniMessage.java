package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessage.class */
public interface MiniMessage extends ComponentSerializer<Component, Component, String> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessage$Builder.class */
    public interface Builder extends AbstractBuilder<MiniMessage> {
        @NotNull
        Builder tags(@NotNull TagResolver tagResolver);

        @NotNull
        Builder editTags(@NotNull Consumer<TagResolver.Builder> consumer);

        @NotNull
        Builder strict(boolean z);

        @NotNull
        Builder emitVirtuals(boolean z);

        @NotNull
        Builder debug(@Nullable Consumer<String> consumer);

        @NotNull
        Builder postProcessor(@NotNull UnaryOperator<Component> unaryOperator);

        @NotNull
        Builder preProcessor(@NotNull UnaryOperator<String> unaryOperator);

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        MiniMessage build2();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessage$Provider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface Provider {
        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        MiniMessage miniMessage();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        Consumer<Builder> builder();
    }

    @NotNull
    static MiniMessage miniMessage() {
        return MiniMessageImpl.Instances.INSTANCE;
    }

    @NotNull
    String escapeTags(@NotNull String str);

    @NotNull
    String escapeTags(@NotNull String str, @NotNull TagResolver tagResolver);

    @NotNull
    default String escapeTags(@NotNull String str, @NotNull TagResolver... tagResolverArr) {
        return escapeTags(str, TagResolver.resolver(tagResolverArr));
    }

    @NotNull
    String stripTags(@NotNull String str);

    @NotNull
    String stripTags(@NotNull String str, @NotNull TagResolver tagResolver);

    @NotNull
    default String stripTags(@NotNull String str, @NotNull TagResolver... tagResolverArr) {
        return stripTags(str, TagResolver.resolver(tagResolverArr));
    }

    @NotNull
    Component deserialize(@NotNull String str, @NotNull Pointered pointered);

    @NotNull
    Component deserialize(@NotNull String str, @NotNull TagResolver tagResolver);

    @NotNull
    Component deserialize(@NotNull String str, @NotNull Pointered pointered, @NotNull TagResolver tagResolver);

    @NotNull
    default Component deserialize(@NotNull String str, @NotNull TagResolver... tagResolverArr) {
        return deserialize(str, TagResolver.resolver(tagResolverArr));
    }

    @NotNull
    default Component deserialize(@NotNull String str, @NotNull Pointered pointered, @NotNull TagResolver... tagResolverArr) {
        return deserialize(str, pointered, TagResolver.resolver(tagResolverArr));
    }

    Node.Root deserializeToTree(@NotNull String str);

    Node.Root deserializeToTree(@NotNull String str, @NotNull Pointered pointered);

    Node.Root deserializeToTree(@NotNull String str, @NotNull TagResolver tagResolver);

    Node.Root deserializeToTree(@NotNull String str, @NotNull Pointered pointered, @NotNull TagResolver tagResolver);

    default Node.Root deserializeToTree(@NotNull String str, @NotNull TagResolver... tagResolverArr) {
        return deserializeToTree(str, TagResolver.resolver(tagResolverArr));
    }

    default Node.Root deserializeToTree(@NotNull String str, @NotNull Pointered pointered, @NotNull TagResolver... tagResolverArr) {
        return deserializeToTree(str, pointered, TagResolver.resolver(tagResolverArr));
    }

    boolean strict();

    @NotNull
    TagResolver tags();

    static Builder builder() {
        return new MiniMessageImpl.BuilderImpl();
    }
}
