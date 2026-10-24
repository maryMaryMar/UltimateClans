package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import java.util.Iterator;
import me.ulrich.clans.library.kyori.adventure.audience.MessageType;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Facet;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.bungeecord.BungeeComponentSerializer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.TranslationRegistry;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet.class */
class SpigotFacet<V extends CommandSender> extends FacetBase<V> {
    private static final boolean SUPPORTED;
    private static final Class<?> BUNGEE_CHAT_MESSAGE_TYPE;
    static final Class<?> BUNGEE_COMPONENT_TYPE;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet$ActionBar.class */
    static final class ActionBar extends ChatWithType implements Facet.ActionBar<Player, BaseComponent[]> {
        ActionBar() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ActionBar
        public void sendMessage(@NotNull Player player, BaseComponent[] baseComponentArr) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, baseComponentArr);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet$Book.class */
    static final class Book extends Message<Player> implements Facet.Book<Player, BaseComponent[], ItemStack> {
        private static final boolean SUPPORTED = MinecraftReflection.hasMethod((Class<?>) Player.class, "openBook", (Class<?>[]) new Class[]{ItemStack.class});

        protected Book() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.SpigotFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Book
        @NotNull
        public ItemStack createBook(@NotNull String str, @NotNull String str2, @NotNull Iterable<BaseComponent[]> iterable) {
            ItemStack itemStack = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta instanceof BookMeta) {
                BookMeta bookMeta = itemMeta;
                Iterator<BaseComponent[]> it = iterable.iterator();
                while (it.hasNext()) {
                    bookMeta.spigot().addPage(new BaseComponent[][]{it.next()});
                }
                bookMeta.setTitle(str);
                bookMeta.setAuthor(str2);
                itemStack.setItemMeta(bookMeta);
            }
            return itemStack;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Book
        public void openBook(@NotNull Player player, @NotNull ItemStack itemStack) {
            player.openBook(itemStack);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet$Chat.class */
    static final class Chat extends Message<CommandSender> implements Facet.Chat<CommandSender, BaseComponent[]> {
        private static final boolean SUPPORTED = MinecraftReflection.hasClass("org.bukkit.command.CommandSender$Spigot");

        protected Chat() {
            super(CommandSender.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.SpigotFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Chat
        public void sendMessage(@NotNull CommandSender commandSender, @NotNull Identity identity, BaseComponent[] baseComponentArr, @NotNull Object obj) {
            commandSender.spigot().sendMessage(baseComponentArr);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet$ChatWithType.class */
    static class ChatWithType extends Message<Player> implements Facet.Chat<Player, BaseComponent[]> {
        private static final Class<?> PLAYER_CLASS = MinecraftReflection.findClass("org.bukkit.entity.Player$Spigot");
        private static final boolean SUPPORTED = MinecraftReflection.hasMethod(PLAYER_CLASS, "sendMessage", (Class<?>[]) new Class[]{SpigotFacet.BUNGEE_CHAT_MESSAGE_TYPE, BUNGEE_COMPONENT_TYPE});

        protected ChatWithType() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.SpigotFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        @Nullable
        private ChatMessageType createType(@NotNull MessageType messageType) {
            if (messageType == MessageType.CHAT) {
                return ChatMessageType.CHAT;
            }
            if (messageType == MessageType.SYSTEM) {
                return ChatMessageType.SYSTEM;
            }
            Knob.logUnsupported(this, messageType);
            return null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Chat
        public void sendMessage(@NotNull Player player, @NotNull Identity identity, BaseComponent[] baseComponentArr, @NotNull Object obj) {
            ChatMessageType chatMessageTypeCreateType = obj instanceof MessageType ? createType((MessageType) obj) : ChatMessageType.SYSTEM;
            if (chatMessageTypeCreateType != null) {
                player.spigot().sendMessage(chatMessageTypeCreateType, baseComponentArr);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet$Message.class */
    static class Message<V extends CommandSender> extends SpigotFacet<V> implements Facet.Message<V, BaseComponent[]> {
        private static final BungeeComponentSerializer SERIALIZER = BungeeComponentSerializer.of(BukkitComponentSerializer.gson(), BukkitComponentSerializer.legacy());

        protected Message(@Nullable Class<? extends V> cls) {
            super(cls);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @NotNull
        public BaseComponent[] createMessage(@NotNull V v, @NotNull Component component) {
            return SERIALIZER.serialize(component);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/SpigotFacet$Translator.class */
    static class Translator extends FacetBase<Server> implements FacetComponentFlattener.Translator<Server> {
        private static final boolean SUPPORTED = MinecraftReflection.hasClass("net.md_5.bungee.chat.TranslationRegistry");

        Translator() {
            super(Server.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetComponentFlattener.Translator
        @NotNull
        public String valueOrDefault(@NotNull Server server, @NotNull String str) {
            return TranslationRegistry.INSTANCE.translate(str);
        }
    }

    protected SpigotFacet(@Nullable Class<? extends V> cls) {
        super(cls);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isSupported() {
        return super.isSupported() && SUPPORTED;
    }

    static {
        SUPPORTED = Knob.isEnabled("spigot", true) && BungeeComponentSerializer.isNative();
        BUNGEE_CHAT_MESSAGE_TYPE = MinecraftReflection.findClass("net.md_5.bungee.api.ChatMessageType");
        BUNGEE_COMPONENT_TYPE = MinecraftReflection.findClass("net.md_5.bungee.api.chat.BaseComponent");
    }
}
