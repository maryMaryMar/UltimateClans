package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonComponentSerializerImpl.class */
final class GsonComponentSerializerImpl implements GsonComponentSerializer {
    private static final Optional<GsonComponentSerializer.Provider> SERVICE = Services.service(GsonComponentSerializer.Provider.class);
    static final Consumer<GsonComponentSerializer.Builder> BUILDER = (Consumer) SERVICE.map((v0) -> {
        return v0.builder();
    }).orElseGet(() -> {
        return builder -> {
        };
    });
    private final Gson serializer;
    private final UnaryOperator<GsonBuilder> populator;
    private final me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverSerializer;
    private final OptionState flags;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonComponentSerializerImpl$BuilderImpl.class */
    static final class BuilderImpl implements GsonComponentSerializer.Builder {
        private OptionState flags;
        private me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverSerializer;

        BuilderImpl() {
            this.flags = JSONOptions.byDataVersion();
            GsonComponentSerializerImpl.BUILDER.accept(this);
        }

        BuilderImpl(GsonComponentSerializerImpl gsonComponentSerializerImpl) {
            this();
            this.flags = gsonComponentSerializerImpl.flags;
            this.legacyHoverSerializer = gsonComponentSerializerImpl.legacyHoverSerializer;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer.Builder, me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public GsonComponentSerializer.Builder options(@NotNull OptionState optionState) {
            this.flags = (OptionState) Objects.requireNonNull(optionState, "flags");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer.Builder, me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public GsonComponentSerializer.Builder editOptions(@NotNull Consumer<OptionState.Builder> consumer) {
            OptionState.Builder builderValues = JSONOptions.schema().stateBuilder().values(this.flags);
            ((Consumer) Objects.requireNonNull(consumer, "flagEditor")).accept(builderValues);
            this.flags = builderValues.build();
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer.Builder, me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public GsonComponentSerializer.Builder legacyHoverEventSerializer(me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverEventSerializer) {
            this.legacyHoverSerializer = legacyHoverEventSerializer;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer.Builder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public GsonComponentSerializer build2() {
            return new GsonComponentSerializerImpl(this.flags, this.legacyHoverSerializer);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer.Builder, me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public /* bridge */ /* synthetic */ JSONComponentSerializer.Builder editOptions(@NotNull Consumer consumer) {
            return editOptions((Consumer<OptionState.Builder>) consumer);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonComponentSerializerImpl$Instances.class */
    static final class Instances {
        static final GsonComponentSerializer INSTANCE = (GsonComponentSerializer) GsonComponentSerializerImpl.SERVICE.map((v0) -> {
            return v0.gson();
        }).orElseGet(() -> {
            return new GsonComponentSerializerImpl(JSONOptions.byDataVersion(), null);
        });
        static final GsonComponentSerializer LEGACY_INSTANCE = (GsonComponentSerializer) GsonComponentSerializerImpl.SERVICE.map((v0) -> {
            return v0.gsonLegacy();
        }).orElseGet(() -> {
            return new GsonComponentSerializerImpl(JSONOptions.byDataVersion().at(2525), null);
        });

        Instances() {
        }
    }

    GsonComponentSerializerImpl(OptionState optionState, me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverEventSerializer) {
        this.flags = optionState;
        this.legacyHoverSerializer = legacyHoverEventSerializer;
        this.populator = gsonBuilder -> {
            gsonBuilder.registerTypeAdapterFactory(new SerializerFactory(optionState, legacyHoverEventSerializer));
            return gsonBuilder;
        };
        this.serializer = ((GsonBuilder) this.populator.apply(new GsonBuilder().disableHtmlEscaping())).create();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer
    @NotNull
    public Gson serializer() {
        return this.serializer;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer
    @NotNull
    public UnaryOperator<GsonBuilder> populator() {
        return this.populator;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public Component deserialize(@NotNull String str) throws JsonParseException {
        Component component = (Component) serializer().fromJson(str, Component.class);
        if (component == null) {
            throw ComponentSerializerImpl.notSureHowToDeserialize(str);
        }
        return component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @Nullable
    public Component deserializeOr(@Nullable String str, @Nullable Component component) {
        Component component2;
        if (str != null && (component2 = (Component) serializer().fromJson(str, Component.class)) != null) {
            return component2;
        }
        return component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public String serialize(@NotNull Component component) {
        return serializer().toJson(component);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer
    @NotNull
    public Component deserializeFromTree(@NotNull JsonElement jsonElement) throws JsonParseException {
        Component component = (Component) serializer().fromJson(jsonElement, Component.class);
        if (component == null) {
            throw ComponentSerializerImpl.notSureHowToDeserialize(jsonElement);
        }
        return component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer
    @NotNull
    public JsonElement serializeToTree(@NotNull Component component) {
        return serializer().toJsonTree(component);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public GsonComponentSerializer.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }
}
