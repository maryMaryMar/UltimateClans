package me.ulrich.clans.library.kyori.adventure.text.serializer.plain;

import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainComponentSerializerImpl.class */
@Deprecated
final class PlainComponentSerializerImpl {

    @Deprecated
    static final PlainComponentSerializer INSTANCE = new PlainComponentSerializer();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainComponentSerializerImpl$BuilderImpl.class */
    @Deprecated
    static final class BuilderImpl implements PlainComponentSerializer.Builder {
        private final PlainTextComponentSerializer.Builder builder = PlainTextComponentSerializer.builder();

        @Deprecated
        BuilderImpl() {
        }

        @Deprecated
        BuilderImpl(PlainComponentSerializer plainComponentSerializer) {
            this.builder.flattener(((PlainTextComponentSerializerImpl) plainComponentSerializer.serializer).flattener);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.plain.PlainComponentSerializer.Builder
        public PlainComponentSerializer.Builder flattener(@NotNull ComponentFlattener componentFlattener) {
            this.builder.flattener(componentFlattener);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public PlainComponentSerializer build2() {
            return new PlainComponentSerializer(this.builder.build2());
        }
    }

    private PlainComponentSerializerImpl() {
    }

    @Deprecated
    static PlainTextComponentSerializer createRealSerializerFromLegacyFunctions(@Nullable Function<KeybindComponent, String> function, @Nullable Function<TranslatableComponent, String> function2) {
        if (function == null && function2 == null) {
            return PlainTextComponentSerializer.plainText();
        }
        ComponentFlattener.Builder builder = ComponentFlattener.basic().mo683toBuilder();
        if (function != null) {
            builder.mapper(KeybindComponent.class, function);
        }
        if (function2 != null) {
            builder.mapper(TranslatableComponent.class, function2);
        }
        return PlainTextComponentSerializer.builder().flattener(builder.build2()).build2();
    }
}
