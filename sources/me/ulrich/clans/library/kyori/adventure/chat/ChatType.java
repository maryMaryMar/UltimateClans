package me.ulrich.clans.library.kyori.adventure.chat;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.key.Keyed;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/ChatType.class */
public interface ChatType extends Keyed, Examinable {
    public static final ChatType CHAT = new ChatTypeImpl(Key.key("chat"));
    public static final ChatType SAY_COMMAND = new ChatTypeImpl(Key.key("say_command"));
    public static final ChatType MSG_COMMAND_INCOMING = new ChatTypeImpl(Key.key("msg_command_incoming"));
    public static final ChatType MSG_COMMAND_OUTGOING = new ChatTypeImpl(Key.key("msg_command_outgoing"));
    public static final ChatType TEAM_MSG_COMMAND_INCOMING = new ChatTypeImpl(Key.key("team_msg_command_incoming"));
    public static final ChatType TEAM_MSG_COMMAND_OUTGOING = new ChatTypeImpl(Key.key("team_msg_command_outgoing"));
    public static final ChatType EMOTE_COMMAND = new ChatTypeImpl(Key.key("emote_command"));

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/ChatType$Bound.class */
    public interface Bound extends Examinable {
        @Contract(pure = true)
        @NotNull
        ChatType type();

        @Contract(pure = true)
        @NotNull
        Component name();

        @Contract(pure = true)
        @Nullable
        Component target();

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        default Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("type", type()), ExaminableProperty.of("name", name()), ExaminableProperty.of("target", target())});
        }
    }

    @NotNull
    static ChatType chatType(@NotNull Keyed keyed) {
        return keyed instanceof ChatType ? (ChatType) keyed : new ChatTypeImpl(((Keyed) Objects.requireNonNull(keyed, KeybindTag.KEYBIND)).key());
    }

    @Contract(value = "_ -> new", pure = true)
    default Bound bind(@NotNull ComponentLike componentLike) {
        return bind(componentLike, null);
    }

    @Contract(value = "_, _ -> new", pure = true)
    default Bound bind(@NotNull ComponentLike componentLike, @Nullable ComponentLike componentLike2) {
        return new ChatTypeImpl.BoundImpl(this, (Component) Objects.requireNonNull(componentLike.asComponent(), "name"), ComponentLike.unbox(componentLike2));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of(KeybindTag.KEYBIND, key()));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Keyed
    @NotNull
    Key key();
}
