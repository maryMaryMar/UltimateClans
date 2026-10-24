package me.ulrich.clans.library.kyori.adventure.chat;

import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/ChatTypeImpl.class */
final class ChatTypeImpl implements ChatType {
    private final Key key;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/ChatTypeImpl$BoundImpl.class */
    static final class BoundImpl implements ChatType.Bound {
        private final ChatType chatType;
        private final Component name;

        @Nullable
        private final Component target;

        BoundImpl(ChatType chatType, Component component, @Nullable Component component2) {
            this.chatType = chatType;
            this.name = component;
            this.target = component2;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.chat.ChatType.Bound
        @NotNull
        public ChatType type() {
            return this.chatType;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.chat.ChatType.Bound
        @NotNull
        public Component name() {
            return this.name;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.chat.ChatType.Bound
        @Nullable
        public Component target() {
            return this.target;
        }

        public String toString() {
            return Internals.toString(this);
        }
    }

    ChatTypeImpl(@NotNull Key key) {
        this.key = key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.chat.ChatType, me.ulrich.clans.library.kyori.adventure.key.Keyed
    @NotNull
    public Key key() {
        return this.key;
    }

    public String toString() {
        return Internals.toString(this);
    }
}
