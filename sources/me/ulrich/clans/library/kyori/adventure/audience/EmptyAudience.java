package me.ulrich.clans.library.kyori.adventure.audience;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.chat.ChatType;
import me.ulrich.clans.library.kyori.adventure.chat.SignedMessage;
import me.ulrich.clans.library.kyori.adventure.identity.Identified;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.inventory.Book;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointer;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfoLike;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/audience/EmptyAudience.class */
final class EmptyAudience implements Audience {
    static final EmptyAudience INSTANCE = new EmptyAudience();

    EmptyAudience() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
    @NotNull
    public <T> Optional<T> get(@NotNull Pointer<T> pointer) {
        return Optional.empty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
    @Contract("_, null -> null; _, !null -> !null")
    @Nullable
    public <T> T getOrDefault(@NotNull Pointer<T> pointer, @Nullable T t) {
        return t;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
    public <T> T getOrDefaultFrom(@NotNull Pointer<T> pointer, @NotNull Supplier<? extends T> supplier) {
        return supplier.get();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    @NotNull
    public Audience filterAudience(@NotNull Predicate<? super Audience> predicate) {
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void forEachAudience(@NotNull Consumer<? super Audience> consumer) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull ComponentLike componentLike) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull Component component) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    @Deprecated
    public void sendMessage(@NotNull Identified identified, @NotNull Component component, @NotNull MessageType messageType) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    @Deprecated
    public void sendMessage(@NotNull Identity identity, @NotNull Component component, @NotNull MessageType messageType) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull Component component, ChatType.Bound bound) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull SignedMessage signedMessage, ChatType.Bound bound) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void deleteMessage(SignedMessage.Signature signature) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendActionBar(@NotNull ComponentLike componentLike) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendPlayerListHeader(@NotNull ComponentLike componentLike) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendPlayerListFooter(@NotNull ComponentLike componentLike) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendPlayerListHeaderAndFooter(@NotNull ComponentLike componentLike, @NotNull ComponentLike componentLike2) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void openBook(Book.Builder builder) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendResourcePacks(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void removeResourcePacks(@NotNull ResourcePackRequest resourcePackRequest) {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void removeResourcePacks(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr) {
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyAudience";
    }
}
