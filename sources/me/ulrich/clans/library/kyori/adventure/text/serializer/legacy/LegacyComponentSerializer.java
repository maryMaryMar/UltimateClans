package me.ulrich.clans.library.kyori.adventure.text.serializer.legacy;

import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializer.class */
public interface LegacyComponentSerializer extends ComponentSerializer<Component, TextComponent, String>, Buildable<LegacyComponentSerializer, Builder> {
    public static final char SECTION_CHAR = 167;
    public static final char AMPERSAND_CHAR = '&';
    public static final char HEX_CHAR = '#';

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializer$Builder.class */
    public interface Builder extends AbstractBuilder<LegacyComponentSerializer>, Buildable.Builder<LegacyComponentSerializer> {
        @NotNull
        Builder character(char c);

        @NotNull
        Builder hexCharacter(char c);

        @NotNull
        Builder extractUrls();

        @NotNull
        Builder extractUrls(@NotNull Pattern pattern);

        @NotNull
        Builder extractUrls(@Nullable Style style);

        @NotNull
        Builder extractUrls(@NotNull Pattern pattern, @Nullable Style style);

        @NotNull
        Builder hexColors();

        @NotNull
        Builder useUnusualXRepeatedCharacterHexFormat();

        @NotNull
        Builder flattener(@NotNull ComponentFlattener componentFlattener);

        @NotNull
        Builder formats(@NotNull List<CharacterAndFormat> list);

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        LegacyComponentSerializer build();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializer$Provider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface Provider {
        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        LegacyComponentSerializer legacyAmpersand();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        LegacyComponentSerializer legacySection();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        Consumer<Builder> legacy();
    }

    @NotNull
    static LegacyComponentSerializer legacySection() {
        return LegacyComponentSerializerImpl.Instances.SECTION;
    }

    @NotNull
    static LegacyComponentSerializer legacyAmpersand() {
        return LegacyComponentSerializerImpl.Instances.AMPERSAND;
    }

    @NotNull
    static LegacyComponentSerializer legacy(char c) {
        if (c == 167) {
            return legacySection();
        }
        return c == '&' ? legacyAmpersand() : builder().character(c).build();
    }

    @Nullable
    static LegacyFormat parseChar(char c) {
        return LegacyComponentSerializerImpl.legacyFormat(c);
    }

    @NotNull
    static Builder builder() {
        return new LegacyComponentSerializerImpl.BuilderImpl();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    TextComponent deserialize(@NotNull String str);

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    String serialize(@NotNull Component component);
}
