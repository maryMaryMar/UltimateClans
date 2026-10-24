package me.ulrich.clans.library.kyori.adventure.text.serializer.plain;

import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainTextComponentSerializer.class */
public interface PlainTextComponentSerializer extends ComponentSerializer<Component, TextComponent, String>, Buildable<PlainTextComponentSerializer, Builder> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainTextComponentSerializer$Builder.class */
    public interface Builder extends AbstractBuilder<PlainTextComponentSerializer>, Buildable.Builder<PlainTextComponentSerializer> {
        @NotNull
        Builder flattener(@NotNull ComponentFlattener componentFlattener);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainTextComponentSerializer$Provider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface Provider {
        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        PlainTextComponentSerializer plainTextSimple();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        Consumer<Builder> plainText();
    }

    @NotNull
    static PlainTextComponentSerializer plainText() {
        return PlainTextComponentSerializerImpl.Instances.INSTANCE;
    }

    static Builder builder() {
        return new PlainTextComponentSerializerImpl.BuilderImpl();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    default TextComponent deserialize(@NotNull String str) {
        return Component.text(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    default String serialize(@NotNull Component component) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, component);
        return sb.toString();
    }

    void serialize(@NotNull StringBuilder sb, @NotNull Component component);
}
