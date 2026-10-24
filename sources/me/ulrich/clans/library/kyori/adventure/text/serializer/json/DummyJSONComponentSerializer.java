package me.ulrich.clans.library.kyori.adventure.text.serializer.json;

import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/DummyJSONComponentSerializer.class */
final class DummyJSONComponentSerializer implements JSONComponentSerializer {
    static final JSONComponentSerializer INSTANCE = new DummyJSONComponentSerializer();
    private static final String UNSUPPORTED_MESSAGE = "No JsonComponentSerializer implementation found\n\nAre you missing an implementation artifact like adventure-text-serializer-gson?\nIs your environment configured in a way that causes ServiceLoader to malfunction?";

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/DummyJSONComponentSerializer$BuilderImpl.class */
    static final class BuilderImpl implements JSONComponentSerializer.Builder {
        BuilderImpl() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public JSONComponentSerializer.Builder options(@NotNull OptionState optionState) {
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public JSONComponentSerializer.Builder editOptions(@NotNull Consumer<OptionState.Builder> consumer) {
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @Deprecated
        @NotNull
        public JSONComponentSerializer.Builder downsampleColors() {
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public JSONComponentSerializer.Builder legacyHoverEventSerializer(@Nullable LegacyHoverEventSerializer legacyHoverEventSerializer) {
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @Deprecated
        @NotNull
        public JSONComponentSerializer.Builder emitLegacyHoverEvent() {
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Builder
        @NotNull
        public JSONComponentSerializer build() {
            return DummyJSONComponentSerializer.INSTANCE;
        }
    }

    DummyJSONComponentSerializer() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public Component deserialize(@NotNull String str) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public String serialize(@NotNull Component component) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }
}
