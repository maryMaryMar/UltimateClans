package me.ulrich.clans.library.kyori.adventure.chat;

import java.time.Instant;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.identity.Identified;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/SignedMessage.class */
@ApiStatus.NonExtendable
public interface SignedMessage extends Identified, Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/SignedMessage$Signature.class */
    @ApiStatus.NonExtendable
    public interface Signature extends Examinable {
        @Contract(pure = true)
        byte[] bytes();

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        default Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of(ExaminableProperty.of("bytes", bytes()));
        }
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static Signature signature(byte[] bArr) {
        return new SignedMessageImpl.SignatureImpl(bArr);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static SignedMessage system(@NotNull String str, @Nullable ComponentLike componentLike) {
        return new SignedMessageImpl(str, ComponentLike.unbox(componentLike));
    }

    @Contract(pure = true)
    @NotNull
    Instant timestamp();

    @Contract(pure = true)
    long salt();

    @Contract(pure = true)
    @Nullable
    Signature signature();

    @Contract(pure = true)
    @Nullable
    Component unsignedContent();

    @Contract(pure = true)
    @NotNull
    String message();

    @Contract(pure = true)
    default boolean isSystem() {
        return identity() == Identity.nil();
    }

    @Contract(pure = true)
    default boolean canDelete() {
        return signature() != null;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("timestamp", timestamp()), ExaminableProperty.of("salt", salt()), ExaminableProperty.of("signature", signature()), ExaminableProperty.of("unsignedContent", unsignedContent()), ExaminableProperty.of("message", message())});
    }
}
