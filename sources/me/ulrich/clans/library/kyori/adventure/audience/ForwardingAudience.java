package me.ulrich.clans.library.kyori.adventure.audience;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.library.kyori.adventure.chat.ChatType;
import me.ulrich.clans.library.kyori.adventure.chat.SignedMessage;
import me.ulrich.clans.library.kyori.adventure.dialog.DialogLike;
import me.ulrich.clans.library.kyori.adventure.identity.Identified;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.inventory.Book;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointer;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointers;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest;
import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import me.ulrich.clans.library.kyori.adventure.sound.SoundStop;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.title.TitlePart;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/audience/ForwardingAudience.class */
@FunctionalInterface
public interface ForwardingAudience extends Audience {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/audience/ForwardingAudience$Single.class */
    public interface Single extends ForwardingAudience {
        @ApiStatus.OverrideOnly
        @NotNull
        Audience audience();

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience
        @Deprecated
        @NotNull
        default Iterable<? extends Audience> audiences() {
            return Collections.singleton(audience());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
        @NotNull
        default <T> Optional<T> get(@NotNull Pointer<T> pointer) {
            return audience().get(pointer);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
        @Contract("_, null -> null; _, !null -> !null")
        @Nullable
        default <T> T getOrDefault(@NotNull Pointer<T> pointer, @Nullable T t) {
            return (T) audience().getOrDefault(pointer, t);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
        default <T> T getOrDefaultFrom(@NotNull Pointer<T> pointer, @NotNull Supplier<? extends T> supplier) {
            return (T) audience().getOrDefaultFrom(pointer, supplier);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        @NotNull
        default Audience filterAudience(@NotNull Predicate<? super Audience> predicate) {
            return predicate.test(audience()) ? this : Audience.empty();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void forEachAudience(@NotNull Consumer<? super Audience> consumer) {
            audience().forEachAudience(consumer);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.pointer.Pointered
        @NotNull
        default Pointers pointers() {
            return audience().pointers();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendMessage(@NotNull Component component) {
            audience().sendMessage(component);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendMessage(@NotNull Component component, ChatType.Bound bound) {
            audience().sendMessage(component, bound);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendMessage(@NotNull SignedMessage signedMessage, ChatType.Bound bound) {
            audience().sendMessage(signedMessage, bound);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void deleteMessage(SignedMessage.Signature signature) {
            audience().deleteMessage(signature);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        @Deprecated
        default void sendMessage(@NotNull Identified identified, @NotNull Component component, @NotNull MessageType messageType) {
            audience().sendMessage(identified, component, messageType);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        @Deprecated
        default void sendMessage(@NotNull Identity identity, @NotNull Component component, @NotNull MessageType messageType) {
            audience().sendMessage(identity, component, messageType);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendActionBar(@NotNull Component component) {
            audience().sendActionBar(component);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendPlayerListHeader(@NotNull Component component) {
            audience().sendPlayerListHeader(component);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendPlayerListFooter(@NotNull Component component) {
            audience().sendPlayerListFooter(component);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendPlayerListHeaderAndFooter(@NotNull Component component, @NotNull Component component2) {
            audience().sendPlayerListHeaderAndFooter(component, component2);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default <T> void sendTitlePart(@NotNull TitlePart<T> titlePart, @NotNull T t) {
            audience().sendTitlePart(titlePart, t);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void clearTitle() {
            audience().clearTitle();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void resetTitle() {
            audience().resetTitle();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void showBossBar(@NotNull BossBar bossBar) {
            audience().showBossBar(bossBar);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void hideBossBar(@NotNull BossBar bossBar) {
            audience().hideBossBar(bossBar);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void playSound(@NotNull Sound sound) {
            audience().playSound(sound);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void playSound(@NotNull Sound sound, double d, double d2, double d3) {
            audience().playSound(sound, d, d2, d3);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void playSound(@NotNull Sound sound, Sound.Emitter emitter) {
            audience().playSound(sound, emitter);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void stopSound(@NotNull SoundStop soundStop) {
            audience().stopSound(soundStop);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void openBook(@NotNull Book book) {
            audience().openBook(book);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void sendResourcePacks(@NotNull ResourcePackRequest resourcePackRequest) {
            audience().sendResourcePacks(resourcePackRequest.callback(Audiences.unwrapCallback(this, audience(), resourcePackRequest.callback())));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void removeResourcePacks(@NotNull Iterable<UUID> iterable) {
            audience().removeResourcePacks(iterable);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void removeResourcePacks(@NotNull UUID uuid, @NotNull UUID... uuidArr) {
            audience().removeResourcePacks(uuid, uuidArr);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void clearResourcePacks() {
            audience().clearResourcePacks();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void showDialog(@NotNull DialogLike dialogLike) {
            audience().showDialog(dialogLike);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.audience.Audience
        default void closeDialog() {
            audience().closeDialog();
        }
    }

    @ApiStatus.OverrideOnly
    @NotNull
    Iterable<? extends Audience> audiences();

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
    @NotNull
    default Pointers pointers() {
        return Pointers.empty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    @NotNull
    default Audience filterAudience(@NotNull Predicate<? super Audience> predicate) {
        Audience audienceFilterAudience;
        ArrayList arrayList = null;
        for (Audience audience : audiences()) {
            if (predicate.test(audience) && (audienceFilterAudience = audience.filterAudience(predicate)) != Audience.empty()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(audienceFilterAudience);
            }
        }
        return arrayList != null ? Audience.audience(arrayList) : Audience.empty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void forEachAudience(@NotNull Consumer<? super Audience> consumer) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().forEachAudience(consumer);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendMessage(@NotNull Component component) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendMessage(component);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendMessage(@NotNull Component component, ChatType.Bound bound) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendMessage(component, bound);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendMessage(@NotNull SignedMessage signedMessage, ChatType.Bound bound) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendMessage(signedMessage, bound);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void deleteMessage(SignedMessage.Signature signature) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().deleteMessage(signature);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    @Deprecated
    default void sendMessage(@NotNull Identified identified, @NotNull Component component, @NotNull MessageType messageType) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendMessage(identified, component, messageType);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    @Deprecated
    default void sendMessage(@NotNull Identity identity, @NotNull Component component, @NotNull MessageType messageType) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendMessage(identity, component, messageType);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendActionBar(@NotNull Component component) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendActionBar(component);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendPlayerListHeader(@NotNull Component component) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendPlayerListHeader(component);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendPlayerListFooter(@NotNull Component component) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendPlayerListFooter(component);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendPlayerListHeaderAndFooter(@NotNull Component component, @NotNull Component component2) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendPlayerListHeaderAndFooter(component, component2);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default <T> void sendTitlePart(@NotNull TitlePart<T> titlePart, @NotNull T t) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendTitlePart(titlePart, t);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void clearTitle() {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().clearTitle();
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void resetTitle() {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().resetTitle();
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void showBossBar(@NotNull BossBar bossBar) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().showBossBar(bossBar);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void hideBossBar(@NotNull BossBar bossBar) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().hideBossBar(bossBar);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void playSound(@NotNull Sound sound) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().playSound(sound);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void playSound(@NotNull Sound sound, double d, double d2, double d3) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().playSound(sound, d, d2, d3);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void playSound(@NotNull Sound sound, Sound.Emitter emitter) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().playSound(sound, emitter);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void stopSound(@NotNull SoundStop soundStop) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().stopSound(soundStop);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void openBook(@NotNull Book book) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().openBook(book);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void sendResourcePacks(@NotNull ResourcePackRequest resourcePackRequest) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().sendResourcePacks(resourcePackRequest);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void removeResourcePacks(@NotNull Iterable<UUID> iterable) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().removeResourcePacks(iterable);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void removeResourcePacks(@NotNull UUID uuid, @NotNull UUID... uuidArr) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().removeResourcePacks(uuid, uuidArr);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void clearResourcePacks() {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().clearResourcePacks();
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void showDialog(@NotNull DialogLike dialogLike) {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().showDialog(dialogLike);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    default void closeDialog() {
        Iterator<? extends Audience> it = audiences().iterator();
        while (it.hasNext()) {
            it.next().closeDialog();
        }
    }
}
