package me.ulrich.clans.library.kyori.adventure.audience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.library.kyori.adventure.chat.ChatType;
import me.ulrich.clans.library.kyori.adventure.chat.SignedMessage;
import me.ulrich.clans.library.kyori.adventure.dialog.DialogLike;
import me.ulrich.clans.library.kyori.adventure.identity.Identified;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.inventory.Book;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfoLike;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequest;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackRequestLike;
import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import me.ulrich.clans.library.kyori.adventure.sound.SoundStop;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.title.Title;
import me.ulrich.clans.library.kyori.adventure.title.TitlePart;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/audience/Audience.class */
public interface Audience extends Pointered {
    @NotNull
    static Audience empty() {
        return EmptyAudience.INSTANCE;
    }

    @NotNull
    static Audience audience(@NotNull Audience... audienceArr) {
        int length = audienceArr.length;
        if (length == 0) {
            return empty();
        }
        return length == 1 ? audienceArr[0] : audience(Arrays.asList(audienceArr));
    }

    @NotNull
    static ForwardingAudience audience(@NotNull Iterable<? extends Audience> iterable) {
        return () -> {
            return iterable;
        };
    }

    @NotNull
    static Collector<? super Audience, ?, ForwardingAudience> toAudience() {
        return Audiences.COLLECTOR;
    }

    @NotNull
    default Audience filterAudience(@NotNull Predicate<? super Audience> predicate) {
        return predicate.test(this) ? this : empty();
    }

    default void forEachAudience(@NotNull Consumer<? super Audience> consumer) {
        consumer.accept(this);
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull ComponentLike componentLike) {
        sendMessage(componentLike.asComponent());
    }

    default void sendMessage(@NotNull Component component) {
        sendMessage(component, MessageType.SYSTEM);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull ComponentLike componentLike, @NotNull MessageType messageType) {
        sendMessage(componentLike.asComponent(), messageType);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Component component, @NotNull MessageType messageType) {
        sendMessage(Identity.nil(), component, messageType);
    }

    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Identified identified, @NotNull ComponentLike componentLike) {
        sendMessage(identified, componentLike.asComponent());
    }

    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Identity identity, @NotNull ComponentLike componentLike) {
        sendMessage(identity, componentLike.asComponent());
    }

    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Identified identified, @NotNull Component component) {
        sendMessage(identified, component, MessageType.CHAT);
    }

    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Identity identity, @NotNull Component component) {
        sendMessage(identity, component, MessageType.CHAT);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Identified identified, @NotNull ComponentLike componentLike, @NotNull MessageType messageType) {
        sendMessage(identified, componentLike.asComponent(), messageType);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull Identity identity, @NotNull ComponentLike componentLike, @NotNull MessageType messageType) {
        sendMessage(identity, componentLike.asComponent(), messageType);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    default void sendMessage(@NotNull Identified identified, @NotNull Component component, @NotNull MessageType messageType) {
        sendMessage(identified.identity(), component, messageType);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    default void sendMessage(@NotNull Identity identity, @NotNull Component component, @NotNull MessageType messageType) {
    }

    default void sendMessage(@NotNull Component component, ChatType.Bound bound) {
        sendMessage(component, MessageType.CHAT);
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull ComponentLike componentLike, ChatType.Bound bound) {
        sendMessage(componentLike.asComponent(), bound);
    }

    default void sendMessage(@NotNull SignedMessage signedMessage, ChatType.Bound bound) {
        Component componentUnsignedContent = signedMessage.unsignedContent() != null ? signedMessage.unsignedContent() : Component.text(signedMessage.message());
        if (signedMessage.isSystem()) {
            sendMessage(componentUnsignedContent);
        } else {
            sendMessage(signedMessage.identity(), componentUnsignedContent, MessageType.CHAT);
        }
    }

    @ForwardingAudienceOverrideNotRequired
    default void deleteMessage(@NotNull SignedMessage signedMessage) {
        if (signedMessage.canDelete()) {
            deleteMessage((SignedMessage.Signature) Objects.requireNonNull(signedMessage.signature()));
        }
    }

    default void deleteMessage(SignedMessage.Signature signature) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendActionBar(@NotNull ComponentLike componentLike) {
        sendActionBar(componentLike.asComponent());
    }

    default void sendActionBar(@NotNull Component component) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendPlayerListHeader(@NotNull ComponentLike componentLike) {
        sendPlayerListHeader(componentLike.asComponent());
    }

    default void sendPlayerListHeader(@NotNull Component component) {
        sendPlayerListHeaderAndFooter(component, (Component) Component.empty());
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendPlayerListFooter(@NotNull ComponentLike componentLike) {
        sendPlayerListFooter(componentLike.asComponent());
    }

    default void sendPlayerListFooter(@NotNull Component component) {
        sendPlayerListHeaderAndFooter((Component) Component.empty(), component);
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendPlayerListHeaderAndFooter(@NotNull ComponentLike componentLike, @NotNull ComponentLike componentLike2) {
        sendPlayerListHeaderAndFooter(componentLike.asComponent(), componentLike2.asComponent());
    }

    default void sendPlayerListHeaderAndFooter(@NotNull Component component, @NotNull Component component2) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void showTitle(@NotNull Title title) {
        Title.Times times = title.times();
        if (times != null) {
            sendTitlePart(TitlePart.TIMES, times);
        }
        sendTitlePart(TitlePart.SUBTITLE, title.subtitle());
        sendTitlePart(TitlePart.TITLE, title.title());
    }

    default <T> void sendTitlePart(@NotNull TitlePart<T> titlePart, @NotNull T t) {
    }

    default void clearTitle() {
    }

    default void resetTitle() {
    }

    default void showBossBar(@NotNull BossBar bossBar) {
    }

    default void hideBossBar(@NotNull BossBar bossBar) {
    }

    default void playSound(@NotNull Sound sound) {
    }

    default void playSound(@NotNull Sound sound, double d, double d2, double d3) {
    }

    default void playSound(@NotNull Sound sound, Sound.Emitter emitter) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void stopSound(@NotNull Sound sound) {
        stopSound(((Sound) Objects.requireNonNull(sound, "sound")).asStop());
    }

    default void stopSound(@NotNull SoundStop soundStop) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void openBook(Book.Builder builder) {
        openBook(builder.build2());
    }

    default void openBook(@NotNull Book book) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendResourcePacks(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr) {
        sendResourcePacks(ResourcePackRequest.addingRequest(resourcePackInfoLike, resourcePackInfoLikeArr));
    }

    @ForwardingAudienceOverrideNotRequired
    default void sendResourcePacks(@NotNull ResourcePackRequestLike resourcePackRequestLike) {
        sendResourcePacks(resourcePackRequestLike.asResourcePackRequest());
    }

    default void sendResourcePacks(@NotNull ResourcePackRequest resourcePackRequest) {
    }

    @ForwardingAudienceOverrideNotRequired
    default void removeResourcePacks(@NotNull ResourcePackRequestLike resourcePackRequestLike) {
        removeResourcePacks(resourcePackRequestLike.asResourcePackRequest());
    }

    @ForwardingAudienceOverrideNotRequired
    default void removeResourcePacks(@NotNull ResourcePackRequest resourcePackRequest) {
        List<ResourcePackInfo> listPacks = resourcePackRequest.packs();
        if (listPacks.size() == 1) {
            removeResourcePacks(listPacks.get(0).id(), new UUID[0]);
        } else if (listPacks.isEmpty()) {
            return;
        }
        UUID[] uuidArr = new UUID[listPacks.size() - 1];
        for (int i = 0; i < uuidArr.length; i++) {
            uuidArr[i] = listPacks.get(i + 1).id();
        }
        removeResourcePacks(listPacks.get(0).id(), uuidArr);
    }

    @ForwardingAudienceOverrideNotRequired
    default void removeResourcePacks(@NotNull ResourcePackInfoLike resourcePackInfoLike, @NotNull ResourcePackInfoLike... resourcePackInfoLikeArr) {
        UUID[] uuidArr = new UUID[resourcePackInfoLikeArr.length];
        for (int i = 0; i < resourcePackInfoLikeArr.length; i++) {
            uuidArr[i] = resourcePackInfoLikeArr[i].asResourcePackInfo().id();
        }
        removeResourcePacks(resourcePackInfoLike.asResourcePackInfo().id(), uuidArr);
    }

    default void removeResourcePacks(@NotNull Iterable<UUID> iterable) {
        UUID[] uuidArr;
        Iterator<UUID> it = iterable.iterator();
        if (it.hasNext()) {
            UUID next = it.next();
            if (!it.hasNext()) {
                uuidArr = new UUID[0];
            } else if (iterable instanceof Collection) {
                uuidArr = new UUID[((Collection) iterable).size() - 1];
                for (int i = 0; i < uuidArr.length; i++) {
                    uuidArr[i] = it.next();
                }
            } else {
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                uuidArr = (UUID[]) arrayList.toArray(new UUID[0]);
            }
            removeResourcePacks(next, uuidArr);
        }
    }

    default void removeResourcePacks(@NotNull UUID uuid, @NotNull UUID... uuidArr) {
    }

    default void clearResourcePacks() {
    }

    default void showDialog(@NotNull DialogLike dialogLike) {
    }

    default void closeDialog() {
    }
}
