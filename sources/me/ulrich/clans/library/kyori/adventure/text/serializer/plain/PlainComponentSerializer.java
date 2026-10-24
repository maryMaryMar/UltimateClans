package me.ulrich.clans.library.kyori.adventure.text.serializer.plain;

import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainComponentSerializer.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated
public class PlainComponentSerializer implements ComponentSerializer<Component, TextComponent, String>, Buildable<PlainComponentSerializer, Builder> {

    @Deprecated
    final PlainTextComponentSerializer serializer;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainComponentSerializer$Builder.class */
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public interface Builder extends AbstractBuilder<PlainComponentSerializer>, Buildable.Builder<PlainComponentSerializer> {
        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        Builder flattener(@NotNull ComponentFlattener componentFlattener);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    public static PlainComponentSerializer plain() {
        return PlainComponentSerializerImpl.INSTANCE;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static Builder builder() {
        return new PlainComponentSerializerImpl.BuilderImpl();
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public PlainComponentSerializer() {
        this(PlainTextComponentSerializer.plainText());
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public PlainComponentSerializer(@Nullable Function<KeybindComponent, String> function, @Nullable Function<TranslatableComponent, String> function2) {
        this(PlainComponentSerializerImpl.createRealSerializerFromLegacyFunctions(function, function2));
    }

    @Deprecated
    PlainComponentSerializer(@NotNull PlainTextComponentSerializer plainTextComponentSerializer) {
        this.serializer = plainTextComponentSerializer;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public TextComponent deserialize(@NotNull String str) {
        return this.serializer.deserialize(str);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public String serialize(@NotNull Component component) {
        return this.serializer.serialize(component);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public void serialize(@NotNull StringBuilder sb, @NotNull Component component) {
        this.serializer.serialize(sb, component);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public Builder mo683toBuilder() {
        return new PlainComponentSerializerImpl.BuilderImpl(this);
    }
}
