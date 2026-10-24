package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonComponentSerializer.class */
public interface GsonComponentSerializer extends JSONComponentSerializer, Buildable<GsonComponentSerializer, Builder> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonComponentSerializer$Builder.class */
    public interface Builder extends AbstractBuilder<GsonComponentSerializer>, JSONComponentSerializer.Builder, Buildable.Builder<GsonComponentSerializer> {
        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        Builder options(@NotNull OptionState optionState);

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        Builder editOptions(@NotNull Consumer<OptionState.Builder> consumer);

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        default Builder downsampleColors() {
            return editOptions(builder -> {
                builder.value(JSONOptions.EMIT_RGB, false);
            });
        }

        @Deprecated
        @NotNull
        default Builder legacyHoverEventSerializer(@Nullable LegacyHoverEventSerializer legacyHoverEventSerializer) {
            return legacyHoverEventSerializer((me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer) legacyHoverEventSerializer);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        Builder legacyHoverEventSerializer(me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverEventSerializer);

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @Deprecated
        @NotNull
        default Builder emitLegacyHoverEvent() {
            return editOptions(builder -> {
                builder.value(JSONOptions.EMIT_HOVER_EVENT_TYPE, JSONOptions.HoverEventValueMode.ALL);
            });
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        GsonComponentSerializer build2();

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        /* bridge */ /* synthetic */ default JSONComponentSerializer.Builder editOptions(@NotNull Consumer consumer) {
            return editOptions((Consumer<OptionState.Builder>) consumer);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonComponentSerializer$Provider.class */
    @ApiStatus.Internal
    @PlatformAPI
    public interface Provider {
        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        GsonComponentSerializer gson();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        GsonComponentSerializer gsonLegacy();

        @ApiStatus.Internal
        @PlatformAPI
        @NotNull
        Consumer<Builder> builder();
    }

    @NotNull
    static GsonComponentSerializer gson() {
        return GsonComponentSerializerImpl.Instances.INSTANCE;
    }

    @NotNull
    static GsonComponentSerializer colorDownsamplingGson() {
        return GsonComponentSerializerImpl.Instances.LEGACY_INSTANCE;
    }

    static Builder builder() {
        return new GsonComponentSerializerImpl.BuilderImpl();
    }

    @NotNull
    Gson serializer();

    @NotNull
    UnaryOperator<GsonBuilder> populator();

    @NotNull
    Component deserializeFromTree(@NotNull JsonElement jsonElement);

    @NotNull
    JsonElement serializeToTree(@NotNull Component component);
}
