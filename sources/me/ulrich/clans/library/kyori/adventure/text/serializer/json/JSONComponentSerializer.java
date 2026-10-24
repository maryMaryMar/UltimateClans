package me.ulrich.clans.library.kyori.adventure.text.serializer.json;

import java.util.function.Consumer;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONComponentSerializer.class */
public interface JSONComponentSerializer extends ComponentSerializer<Component, Component, String> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONComponentSerializer$Builder.class */
    public interface Builder {
        @NotNull
        Builder options(@NotNull OptionState optionState);

        @NotNull
        Builder editOptions(@NotNull Consumer<OptionState.Builder> consumer);

        @Deprecated
        @NotNull
        Builder downsampleColors();

        @NotNull
        Builder legacyHoverEventSerializer(@Nullable LegacyHoverEventSerializer legacyHoverEventSerializer);

        @Deprecated
        @NotNull
        Builder emitLegacyHoverEvent();

        @NotNull
        JSONComponentSerializer build();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONComponentSerializer$Provider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface Provider {
        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        JSONComponentSerializer instance();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        Supplier<Builder> builder();
    }

    @NotNull
    static JSONComponentSerializer json() {
        return JSONComponentSerializerAccessor.Instances.INSTANCE;
    }

    static Builder builder() {
        return JSONComponentSerializerAccessor.Instances.BUILDER_SUPPLIER.get();
    }
}
