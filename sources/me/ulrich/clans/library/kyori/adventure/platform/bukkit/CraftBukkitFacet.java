package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.audience.MessageType;
import me.ulrich.clans.library.kyori.adventure.chat.ChatType;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO;
import me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagTypes;
import me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag;
import me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag;
import me.ulrich.clans.library.kyori.adventure.nbt.StringBinaryTag;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Facet;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet.class */
class CraftBukkitFacet<V extends CommandSender> extends FacetBase<V> {
    private static final Class<?> CLASS_NMS_ENTITY = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("Entity"), MinecraftReflection.findMcClassName("world.entity.Entity"));
    private static final Class<?> CLASS_CRAFT_ENTITY = MinecraftReflection.findCraftClass("entity.CraftEntity");
    private static final MethodHandle CRAFT_ENTITY_GET_HANDLE = MinecraftReflection.findMethod(CLASS_CRAFT_ENTITY, "getHandle", CLASS_NMS_ENTITY, (Class<?>[]) new Class[0]);

    @Nullable
    static final Class<? extends Player> CLASS_CRAFT_PLAYER = MinecraftReflection.findCraftClass("entity.CraftPlayer", Player.class);

    @Nullable
    static final MethodHandle CRAFT_PLAYER_GET_HANDLE;

    @Nullable
    private static final MethodHandle ENTITY_PLAYER_GET_CONNECTION;

    @Nullable
    private static final MethodHandle PLAYER_CONNECTION_SEND_PACKET;
    private static final boolean SUPPORTED;

    @Nullable
    private static final Class<?> CLASS_CHAT_COMPONENT;

    @Nullable
    private static final Class<?> CLASS_MESSAGE_TYPE;

    @Nullable
    private static final Object MESSAGE_TYPE_CHAT;

    @Nullable
    private static final Object MESSAGE_TYPE_SYSTEM;

    @Nullable
    private static final Object MESSAGE_TYPE_ACTIONBAR;

    @Nullable
    private static final MethodHandle LEGACY_CHAT_PACKET_CONSTRUCTOR;

    @Nullable
    private static final MethodHandle CHAT_PACKET_CONSTRUCTOR;

    @Nullable
    private static final Class<?> CLASS_TITLE_PACKET;

    @Nullable
    private static final Class<?> CLASS_TITLE_ACTION;
    private static final MethodHandle CONSTRUCTOR_TITLE_MESSAGE;

    @Nullable
    private static final MethodHandle CONSTRUCTOR_TITLE_TIMES;

    @Nullable
    private static final Object TITLE_ACTION_TITLE;

    @Nullable
    private static final Object TITLE_ACTION_SUBTITLE;

    @Nullable
    private static final Object TITLE_ACTION_ACTIONBAR;

    @Nullable
    private static final Object TITLE_ACTION_CLEAR;

    @Nullable
    private static final Object TITLE_ACTION_RESET;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$AbstractBook.class */
    protected static abstract class AbstractBook extends PacketFacet<Player> implements Facet.Book<Player, Object, ItemStack> {
        protected static final int HAND_MAIN = 0;
        private static final Material BOOK_TYPE = (Material) MinecraftReflection.findEnum(Material.class, "WRITTEN_BOOK");
        private static final ItemStack BOOK_STACK;
        private static final String BOOK_TITLE = "title";
        private static final String BOOK_AUTHOR = "author";
        private static final String BOOK_PAGES = "pages";
        private static final String BOOK_RESOLVED = "resolved";
        private static final Class<?> CLASS_NBT_TAG_COMPOUND;
        private static final Class<?> CLASS_NBT_IO;
        private static final MethodHandle NBT_IO_DESERIALIZE;
        private static final Class<?> CLASS_CRAFT_ITEMSTACK;
        private static final Class<?> CLASS_MC_ITEMSTACK;
        private static final MethodHandle MC_ITEMSTACK_SET_TAG;
        private static final MethodHandle CRAFT_ITEMSTACK_NMS_COPY;
        private static final MethodHandle CRAFT_ITEMSTACK_CRAFT_MIRROR;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$AbstractBook$TrustedByteArrayOutputStream.class */
        private static final class TrustedByteArrayOutputStream extends ByteArrayOutputStream {
            private TrustedByteArrayOutputStream() {
            }

            public InputStream toInputStream() {
                return new ByteArrayInputStream(this.buf, 0, this.count);
            }
        }

        protected AbstractBook() {
        }

        protected abstract void sendOpenPacket(@NotNull Player player);

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || NBT_IO_DESERIALIZE == null || MC_ITEMSTACK_SET_TAG == null || CRAFT_ITEMSTACK_CRAFT_MIRROR == null || CRAFT_ITEMSTACK_NMS_COPY == null || BOOK_STACK == null) ? false : true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PacketFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @NotNull
        public String createMessage(@NotNull Player player, @NotNull Component component) {
            return BukkitComponentSerializer.gson().serialize(component);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Book
        @NotNull
        public ItemStack createBook(@NotNull String str, @NotNull String str2, @NotNull Iterable<Object> iterable) {
            return applyTag(BOOK_STACK, tagFor(str, str2, iterable));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Book
        @Deprecated
        public void openBook(@NotNull Player player, @NotNull ItemStack itemStack) {
            PlayerInventory inventory = player.getInventory();
            ItemStack itemInHand = inventory.getItemInHand();
            try {
                inventory.setItemInHand(itemStack);
                sendOpenPacket(player);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send openBook packet: %s", itemStack);
            } finally {
                inventory.setItemInHand(itemInHand);
            }
        }

        private static CompoundBinaryTag tagFor(@NotNull String str, @NotNull String str2, @NotNull Iterable<Object> iterable) {
            ListBinaryTag.Builder builder = ListBinaryTag.builder(BinaryTagTypes.STRING);
            Iterator<Object> it = iterable.iterator();
            while (it.hasNext()) {
                builder.add(StringBinaryTag.of((String) it.next()));
            }
            return CompoundBinaryTag.builder().putString(BOOK_TITLE, str).putString(BOOK_AUTHOR, str2).put(BOOK_PAGES, builder.build()).putByte(BOOK_RESOLVED, (byte) 1).build();
        }

        @NotNull
        private Object createTag(@NotNull CompoundBinaryTag compoundBinaryTag) throws IOException {
            TrustedByteArrayOutputStream trustedByteArrayOutputStream = new TrustedByteArrayOutputStream();
            BinaryTagIO.writer().write(compoundBinaryTag, trustedByteArrayOutputStream);
            try {
                DataInputStream dataInputStream = new DataInputStream(trustedByteArrayOutputStream.toInputStream());
                try {
                    Object objInvoke = (Object) NBT_IO_DESERIALIZE.invoke(dataInputStream);
                    dataInputStream.close();
                    return objInvoke;
                } catch (Throwable th) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                throw new IOException(th3);
            }
        }

        private ItemStack applyTag(@NotNull ItemStack itemStack, CompoundBinaryTag compoundBinaryTag) {
            if (CRAFT_ITEMSTACK_NMS_COPY == null || MC_ITEMSTACK_SET_TAG == null || CRAFT_ITEMSTACK_CRAFT_MIRROR == null) {
                return itemStack;
            }
            try {
                Object objInvoke = (Object) CRAFT_ITEMSTACK_NMS_COPY.invoke(itemStack);
                MC_ITEMSTACK_SET_TAG.invoke(objInvoke, createTag(compoundBinaryTag));
                return (ItemStack) CRAFT_ITEMSTACK_CRAFT_MIRROR.invoke(objInvoke);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to apply NBT tag to ItemStack: %s %s", itemStack, compoundBinaryTag);
                return itemStack;
            }
        }

        static {
            BOOK_STACK = BOOK_TYPE == null ? null : new ItemStack(BOOK_TYPE);
            CLASS_NBT_TAG_COMPOUND = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("NBTTagCompound"), MinecraftReflection.findMcClassName("nbt.CompoundTag"), MinecraftReflection.findMcClassName("nbt.NBTTagCompound"));
            CLASS_NBT_IO = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("NBTCompressedStreamTools"), MinecraftReflection.findMcClassName("nbt.NbtIo"), MinecraftReflection.findMcClassName("nbt.NBTCompressedStreamTools"));
            MethodHandle methodHandleUnreflect = null;
            if (CLASS_NBT_IO != null) {
                for (Method method : CLASS_NBT_IO.getDeclaredMethods()) {
                    if (Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(CLASS_NBT_TAG_COMPOUND) && method.getParameterCount() == 1) {
                        Class<?> cls = method.getParameterTypes()[0];
                        if (cls.equals(DataInputStream.class) || cls.equals(DataInput.class)) {
                            try {
                                methodHandleUnreflect = MinecraftReflection.lookup().unreflect(method);
                                break;
                            } catch (IllegalAccessException e) {
                            }
                        }
                    }
                }
            }
            NBT_IO_DESERIALIZE = methodHandleUnreflect;
            CLASS_CRAFT_ITEMSTACK = MinecraftReflection.findCraftClass("inventory.CraftItemStack");
            CLASS_MC_ITEMSTACK = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("ItemStack"), MinecraftReflection.findMcClassName("world.item.ItemStack"));
            MC_ITEMSTACK_SET_TAG = MinecraftReflection.searchMethod(CLASS_MC_ITEMSTACK, (Integer) 1, "setTag", (Class<?>) Void.TYPE, (Class<?>[]) new Class[]{CLASS_NBT_TAG_COMPOUND});
            CRAFT_ITEMSTACK_NMS_COPY = MinecraftReflection.findStaticMethod(CLASS_CRAFT_ITEMSTACK, "asNMSCopy", CLASS_MC_ITEMSTACK, (Class<?>[]) new Class[]{ItemStack.class});
            CRAFT_ITEMSTACK_CRAFT_MIRROR = MinecraftReflection.findStaticMethod(CLASS_CRAFT_ITEMSTACK, "asCraftMirror", CLASS_CRAFT_ITEMSTACK, (Class<?>[]) new Class[]{CLASS_MC_ITEMSTACK});
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$ActionBar.class */
    static class ActionBar extends PacketFacet<Player> implements Facet.ActionBar<Player, Object> {
        ActionBar() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && CraftBukkitFacet.TITLE_ACTION_ACTIONBAR != null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PacketFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @Nullable
        public Object createMessage(@NotNull Player player, @NotNull Component component) {
            try {
                return (Object) CraftBukkitFacet.CONSTRUCTOR_TITLE_MESSAGE.invoke(CraftBukkitFacet.TITLE_ACTION_ACTIONBAR, super.createMessage(player, component));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke PacketPlayOutTitle constructor: %s", component);
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ActionBar
        public /* bridge */ /* synthetic */ void sendMessage(@NotNull Player player, @Nullable Object obj) {
            super.sendMessage((CommandSender) player, obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$ActionBarLegacy.class */
    static class ActionBarLegacy extends PacketFacet<Player> implements Facet.ActionBar<Player, Object> {
        ActionBarLegacy() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && CraftBukkitFacet.LEGACY_CHAT_PACKET_CONSTRUCTOR != null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PacketFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @Nullable
        public Object createMessage(@NotNull Player player, @NotNull Component component) {
            TextComponent textComponentText = Component.text(BukkitComponentSerializer.legacy().serialize(component));
            try {
                return (Object) CraftBukkitFacet.LEGACY_CHAT_PACKET_CONSTRUCTOR.invoke(super.createMessage(player, (Component) textComponentText), (byte) 2);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke PacketPlayOutChat constructor: %s", textComponentText);
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ActionBar
        public /* bridge */ /* synthetic */ void sendMessage(@NotNull Player player, @Nullable Object obj) {
            super.sendMessage((CommandSender) player, obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$ActionBar_1_17.class */
    static class ActionBar_1_17 extends PacketFacet<Player> implements Facet.ActionBar<Player, Object> {

        @Nullable
        private static final Class<?> CLASS_SET_ACTION_BAR_TEXT_PACKET = MinecraftReflection.findMcClass("network.protocol.game.ClientboundSetActionBarTextPacket");

        @Nullable
        private static final MethodHandle CONSTRUCTOR_ACTION_BAR = MinecraftReflection.findConstructor(CLASS_SET_ACTION_BAR_TEXT_PACKET, CraftBukkitFacet.CLASS_CHAT_COMPONENT);

        ActionBar_1_17() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && CONSTRUCTOR_ACTION_BAR != null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PacketFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @Nullable
        public Object createMessage(@NotNull Player player, @NotNull Component component) {
            try {
                return (Object) CONSTRUCTOR_ACTION_BAR.invoke(super.createMessage(player, component));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke PacketPlayOutTitle constructor: %s", component);
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ActionBar
        public /* bridge */ /* synthetic */ void sendMessage(@NotNull Player player, @Nullable Object obj) {
            super.sendMessage((CommandSender) player, obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Book1_13.class */
    static final class Book1_13 extends AbstractBook {
        private static final Object PACKET_TYPE_BOOK_OPEN;
        private static final Class<?> CLASS_BYTE_BUF = MinecraftReflection.findClass("io.netty.buffer.ByteBuf");
        private static final Class<?> CLASS_PACKET_CUSTOM_PAYLOAD = MinecraftReflection.findNmsClass("PacketPlayOutCustomPayload");
        private static final Class<?> CLASS_FRIENDLY_BYTE_BUF = MinecraftReflection.findNmsClass("PacketDataSerializer");
        private static final Class<?> CLASS_RESOURCE_LOCATION = MinecraftReflection.findNmsClass("MinecraftKey");
        private static final MethodHandle NEW_PACKET_CUSTOM_PAYLOAD = MinecraftReflection.findConstructor(CLASS_PACKET_CUSTOM_PAYLOAD, CLASS_RESOURCE_LOCATION, CLASS_FRIENDLY_BYTE_BUF);
        private static final MethodHandle NEW_FRIENDLY_BYTE_BUF = MinecraftReflection.findConstructor(CLASS_FRIENDLY_BYTE_BUF, CLASS_BYTE_BUF);

        Book1_13() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.AbstractBook, me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || CLASS_BYTE_BUF == null || NEW_PACKET_CUSTOM_PAYLOAD == null || PACKET_TYPE_BOOK_OPEN == null) ? false : true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.AbstractBook
        protected void sendOpenPacket(@NotNull Player player) {
            ByteBuf byteBufBuffer = Unpooled.buffer();
            byteBufBuffer.writeByte(0);
            sendMessage(player, (Object) NEW_PACKET_CUSTOM_PAYLOAD.invoke(PACKET_TYPE_BOOK_OPEN, (Object) NEW_FRIENDLY_BYTE_BUF.invoke(byteBufBuffer)));
        }

        static {
            Object objNewInstance = null;
            if (CLASS_RESOURCE_LOCATION != null) {
                try {
                    objNewInstance = CLASS_RESOURCE_LOCATION.getConstructor(String.class).newInstance("minecraft:book_open");
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                }
            }
            PACKET_TYPE_BOOK_OPEN = objNewInstance;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$BookPost1_13.class */
    static final class BookPost1_13 extends AbstractBook {
        private static final Class<?> CLASS_ENUM_HAND = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("EnumHand"), MinecraftReflection.findMcClassName("world.EnumHand"), MinecraftReflection.findMcClassName("world.InteractionHand"));
        private static final Object HAND_MAIN = MinecraftReflection.findEnum(CLASS_ENUM_HAND, "MAIN_HAND", 0);
        private static final Class<?> PACKET_OPEN_BOOK = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutOpenBook"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutOpenBook"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundOpenBookPacket"));
        private static final MethodHandle NEW_PACKET_OPEN_BOOK = MinecraftReflection.findConstructor(PACKET_OPEN_BOOK, CLASS_ENUM_HAND);

        BookPost1_13() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.AbstractBook, me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || HAND_MAIN == null || NEW_PACKET_OPEN_BOOK == null) ? false : true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.AbstractBook
        protected void sendOpenPacket(@NotNull Player player) {
            sendMessage(player, (Object) NEW_PACKET_OPEN_BOOK.invoke(HAND_MAIN));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$BookPre1_13.class */
    static final class BookPre1_13 extends AbstractBook {
        private static final String PACKET_TYPE_BOOK_OPEN = "MC|BOpen";
        private static final Class<?> CLASS_BYTE_BUF = MinecraftReflection.findClass("io.netty.buffer.ByteBuf");
        private static final Class<?> CLASS_PACKET_CUSTOM_PAYLOAD = MinecraftReflection.findNmsClass("PacketPlayOutCustomPayload");
        private static final Class<?> CLASS_PACKET_DATA_SERIALIZER = MinecraftReflection.findNmsClass("PacketDataSerializer");
        private static final MethodHandle NEW_PACKET_CUSTOM_PAYLOAD = MinecraftReflection.findConstructor(CLASS_PACKET_CUSTOM_PAYLOAD, String.class, CLASS_PACKET_DATA_SERIALIZER);
        private static final MethodHandle NEW_PACKET_BYTE_BUF = MinecraftReflection.findConstructor(CLASS_PACKET_DATA_SERIALIZER, CLASS_BYTE_BUF);

        BookPre1_13() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.AbstractBook, me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || CLASS_BYTE_BUF == null || CLASS_PACKET_CUSTOM_PAYLOAD == null || NEW_PACKET_CUSTOM_PAYLOAD == null) ? false : true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.AbstractBook
        protected void sendOpenPacket(@NotNull Player player) {
            ByteBuf byteBufBuffer = Unpooled.buffer();
            byteBufBuffer.writeByte(0);
            sendMessage(player, (Object) NEW_PACKET_CUSTOM_PAYLOAD.invoke(PACKET_TYPE_BOOK_OPEN, (Object) NEW_PACKET_BYTE_BUF.invoke(byteBufBuffer)));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Book_1_20_5.class */
    static final class Book_1_20_5 extends PacketFacet<Player> implements Facet.Book<Player, Object, ItemStack> {
        Book_1_20_5() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && CraftBukkitAccess.Book_1_20_5.isSupported();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Book
        @Nullable
        public ItemStack createBook(@NotNull String str, @NotNull String str2, @NotNull Iterable<Object> iterable) {
            try {
                ItemStack itemStack = new ItemStack(Material.WRITTEN_BOOK);
                ArrayList arrayList = new ArrayList();
                Iterator<Object> it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add((Object) CraftBukkitAccess.Book_1_20_5.CREATE_FILTERABLE.invoke(it.next()));
                }
                Object objInvoke = (Object) CraftBukkitAccess.Book_1_20_5.NEW_BOOK_CONTENT.invoke((Object) CraftBukkitAccess.Book_1_20_5.CREATE_FILTERABLE.invoke(str), str2, 0, arrayList, true);
                Object objInvoke2 = (Object) CraftBukkitAccess.Book_1_20_5.CRAFT_ITEMSTACK_NMS_COPY.invoke(itemStack);
                CraftBukkitAccess.Book_1_20_5.MC_ITEMSTACK_SET.invoke(objInvoke2, CraftBukkitAccess.Book_1_20_5.WRITTEN_BOOK_COMPONENT_TYPE, objInvoke);
                return (ItemStack) CraftBukkitAccess.Book_1_20_5.CRAFT_ITEMSTACK_CRAFT_MIRROR.invoke(objInvoke2);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to apply written_book_content component to ItemStack", new Object[0]);
                return null;
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Book
        public void openBook(@NotNull Player player, @NotNull ItemStack itemStack) {
            PlayerInventory inventory = player.getInventory();
            ItemStack itemInHand = inventory.getItemInHand();
            try {
                inventory.setItemInHand(itemStack);
                sendMessage(player, (Object) CraftBukkitAccess.Book_1_20_5.NEW_PACKET_OPEN_BOOK.invoke(CraftBukkitAccess.Book_1_20_5.HAND_MAIN));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send openBook packet: %s", itemStack);
            } finally {
                inventory.setItemInHand(itemInHand);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$BossBar.class */
    static final class BossBar extends BukkitFacet.BossBar {
        private static final Class<?> CLASS_CRAFT_BOSS_BAR = MinecraftReflection.findCraftClass("boss.CraftBossBar");
        private static final Class<?> CLASS_BOSS_BAR_ACTION;
        private static final Object BOSS_BAR_ACTION_TITLE;
        private static final MethodHandle CRAFT_BOSS_BAR_HANDLE;
        private static final MethodHandle NMS_BOSS_BATTLE_SET_NAME;
        private static final MethodHandle NMS_BOSS_BATTLE_SEND_UPDATE;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$BossBar$Builder.class */
        public static class Builder extends CraftBukkitFacet<Player> implements Facet.BossBar.Builder<Player, BossBar> {
            protected Builder() {
                super(Player.class);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
            public boolean isSupported() {
                return (!super.isSupported() || BossBar.CLASS_CRAFT_BOSS_BAR == null || BossBar.CRAFT_BOSS_BAR_HANDLE == null || BossBar.NMS_BOSS_BATTLE_SET_NAME == null || BossBar.NMS_BOSS_BATTLE_SEND_UPDATE == null) ? false : true;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar.Builder
            public BossBar createBossBar(@NotNull Collection<Player> collection) {
                return new BossBar(collection);
            }
        }

        private BossBar(@NotNull Collection<Player> collection) {
            super(collection);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitFacet.BossBar, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarNameChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, @NotNull Component component, @NotNull Component component2) {
            try {
                Object objInvoke = (Object) CRAFT_BOSS_BAR_HANDLE.invoke(this.bar);
                NMS_BOSS_BATTLE_SET_NAME.invoke(objInvoke, MinecraftComponentSerializer.get().serialize(component2));
                NMS_BOSS_BATTLE_SEND_UPDATE.invoke(objInvoke, BOSS_BAR_ACTION_TITLE);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to set CraftBossBar name: %s %s", this.bar, component2);
                super.bossBarNameChanged(bossBar, component, component2);
            }
        }

        static {
            String str;
            Object objInvoke = null;
            Class<?> clsFindClass = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutBoss$Action"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutBoss$Action"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundBossEventPacket$Operation"));
            if (clsFindClass == null || !clsFindClass.isEnum()) {
                clsFindClass = null;
                Class<?> clsFindClass2 = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutBoss"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutBoss"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundBossEventPacket"));
                Class<?> clsFindClass3 = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("BossBattle"), MinecraftReflection.findMcClassName("world.BossBattle"), MinecraftReflection.findMcClassName("world.BossEvent"));
                if (clsFindClass2 != null && clsFindClass3 != null) {
                    try {
                        MethodType methodType = MethodType.methodType(clsFindClass2, clsFindClass3);
                        try {
                            clsFindClass2.getDeclaredMethod("createUpdateNamePacket", clsFindClass3);
                            str = "createUpdateNamePacket";
                        } catch (NoSuchMethodException e) {
                            str = "c";
                        }
                        objInvoke = (Object) LambdaMetafactory.metafactory(MinecraftReflection.lookup(), "apply", MethodType.methodType(Function.class), methodType.generic(), MinecraftReflection.lookup().findStatic(clsFindClass2, str, methodType), methodType).getTarget().invoke();
                        clsFindClass = Function.class;
                    } catch (Throwable th) {
                        Knob.logError(th, "Failed to initialize CraftBossBar constructor", new Object[0]);
                    }
                }
            } else {
                objInvoke = MinecraftReflection.findEnum(clsFindClass, "UPDATE_NAME", 3);
            }
            CLASS_BOSS_BAR_ACTION = clsFindClass;
            BOSS_BAR_ACTION_TITLE = objInvoke;
            MethodHandle methodHandleUnreflectGetter = null;
            MethodHandle methodHandleUnreflectSetter = null;
            MethodHandle methodHandleFindMethod = null;
            if (CLASS_CRAFT_BOSS_BAR != null && CraftBukkitFacet.CLASS_CHAT_COMPONENT != null && BOSS_BAR_ACTION_TITLE != null) {
                try {
                    Field fieldNeedField = MinecraftReflection.needField(CLASS_CRAFT_BOSS_BAR, "handle");
                    methodHandleUnreflectGetter = MinecraftReflection.lookup().unreflectGetter(fieldNeedField);
                    Class<?> type = fieldNeedField.getType();
                    for (Field field : type.getFields()) {
                        if (field.getType().equals(CraftBukkitFacet.CLASS_CHAT_COMPONENT)) {
                            methodHandleUnreflectSetter = MinecraftReflection.lookup().unreflectSetter(field);
                            break;
                        }
                    }
                    methodHandleFindMethod = MinecraftReflection.findMethod(type, new String[]{"sendUpdate", "a", "broadcast"}, (Class<?>) Void.TYPE, (Class<?>[]) new Class[]{CLASS_BOSS_BAR_ACTION});
                } catch (Throwable th2) {
                    Knob.logError(th2, "Failed to initialize CraftBossBar constructor", new Object[0]);
                }
            }
            CRAFT_BOSS_BAR_HANDLE = methodHandleUnreflectGetter;
            NMS_BOSS_BATTLE_SET_NAME = methodHandleUnreflectSetter;
            NMS_BOSS_BATTLE_SEND_UPDATE = methodHandleFindMethod;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$BossBarWither.class */
    static final class BossBarWither extends FakeEntity<Wither> implements Facet.BossBarEntity<Player, Location> {
        private volatile boolean initialized;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$BossBarWither$Builder.class */
        public static class Builder extends CraftBukkitFacet<Player> implements Facet.BossBar.Builder<Player, BossBarWither> {
            protected Builder() {
                super(Player.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar.Builder
            @NotNull
            public BossBarWither createBossBar(@NotNull Collection<Player> collection) {
                return new BossBarWither(collection);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
            public /* bridge */ /* synthetic */ boolean isSupported() {
                return super.isSupported();
            }
        }

        private BossBarWither(@NotNull Collection<Player> collection) {
            super(Wither.class, collection.iterator().next().getWorld().getSpawnLocation());
            this.initialized = false;
            invisible(true);
            metadata(20, Integer.valueOf(Facet.BossBarEntity.INVULNERABLE_TICKS));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void bossBarInitialized(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar) {
            super.bossBarInitialized(bossBar);
            this.initialized = true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.FakeEntity, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Position
        @NotNull
        public Location createPosition(@NotNull Player player) {
            Location locationCreatePosition = super.createPosition(player);
            locationCreatePosition.setPitch(locationCreatePosition.getPitch() - 30.0f);
            locationCreatePosition.setYaw(locationCreatePosition.getYaw() + 0.0f);
            locationCreatePosition.add(locationCreatePosition.getDirection().multiply(40));
            return locationCreatePosition;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public boolean isEmpty() {
            return !this.initialized || this.viewers.isEmpty();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Chat.class */
    static class Chat extends PacketFacet<CommandSender> implements Facet.Chat<CommandSender, Object> {
        Chat() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && CraftBukkitFacet.CHAT_PACKET_CONSTRUCTOR != null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Chat
        public void sendMessage(@NotNull CommandSender commandSender, @NotNull Identity identity, @NotNull Object obj, @NotNull Object obj2) {
            Object obj3 = obj2 == MessageType.CHAT ? CraftBukkitFacet.MESSAGE_TYPE_CHAT : CraftBukkitFacet.MESSAGE_TYPE_SYSTEM;
            try {
                sendMessage(commandSender, (Object) CraftBukkitFacet.CHAT_PACKET_CONSTRUCTOR.invoke(obj, obj3, identity.uuid()));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke PacketPlayOutChat constructor: %s %s", obj, obj3);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Chat1_19_3.class */
    static class Chat1_19_3 extends Chat {
        Chat1_19_3() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.Chat, me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && CraftBukkitAccess.Chat1_19_3.isSupported();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.Chat, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Chat
        public void sendMessage(@NotNull CommandSender commandSender, @NotNull Identity identity, @NotNull Object obj, @NotNull Object obj2) {
            Object objInvoke;
            if (!(obj2 instanceof ChatType.Bound)) {
                super.sendMessage(commandSender, identity, obj, obj2);
                return;
            }
            ChatType.Bound bound = (ChatType.Bound) obj2;
            try {
                Object objCreateMessage = createMessage(commandSender, bound.name());
                Object objCreateMessage2 = bound.target() != null ? createMessage(commandSender, bound.target()) : null;
                Object objOrElseThrow = (Optional) CraftBukkitAccess.Chat1_19_3.REGISTRY_ACCESS_GET_REGISTRY_OPTIONAL.invoke((Object) CraftBukkitAccess.Chat1_19_3.ACTUAL_GET_REGISTRY_ACCESS.invoke((Object) CraftBukkitAccess.Chat1_19_3.SERVER_PLAYER_GET_LEVEL.invoke((Object) CRAFT_PLAYER_GET_HANDLE.invoke(commandSender))), CraftBukkitAccess.Chat1_19_3.CHAT_TYPE_RESOURCE_KEY).orElseThrow(NoSuchElementException::new);
                Object objInvoke2 = (Object) CraftBukkitAccess.NEW_RESOURCE_LOCATION.invoke(bound.type().key().namespace(), bound.type().key().value());
                if (CraftBukkitAccess.Chat1_19_3.CHAT_TYPE_BOUND_NETWORK_CONSTRUCTOR != null) {
                    int iInvoke = (int) CraftBukkitAccess.Chat1_19_3.REGISTRY_GET_ID.invoke(objOrElseThrow, (Optional) CraftBukkitAccess.Chat1_19_3.REGISTRY_GET_OPTIONAL.invoke(objOrElseThrow, objInvoke2).orElseThrow(NoSuchElementException::new));
                    if (iInvoke < 0) {
                        throw new IllegalArgumentException("Could not get a valid network id from " + obj2);
                    }
                    objInvoke = (Object) CraftBukkitAccess.Chat1_19_3.CHAT_TYPE_BOUND_NETWORK_CONSTRUCTOR.invoke(iInvoke, objCreateMessage, objCreateMessage2);
                } else {
                    objInvoke = (Object) CraftBukkitAccess.Chat1_19_3.CHAT_TYPE_BOUND_CONSTRUCTOR.invoke((Optional) CraftBukkitAccess.Chat1_19_3.REGISTRY_GET_HOLDER.invoke(objOrElseThrow, objInvoke2).orElseThrow(NoSuchElementException::new), objCreateMessage, Optional.ofNullable(objCreateMessage2));
                }
                sendMessage(commandSender, (Object) CraftBukkitAccess.Chat1_19_3.DISGUISED_CHAT_PACKET_CONSTRUCTOR.invoke(obj, objInvoke));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send a 1.19.3+ message: %s %s", obj, obj2);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$EntitySound.class */
    static class EntitySound extends PacketFacet<Player> implements PartialEntitySound {
        private static final MethodHandle NEW_CLIENTBOUND_ENTITY_SOUND;
        private static final MethodHandle NEW_CLIENTBOUND_CUSTOM_SOUND;
        private static final Object REGISTRY_SOUND_EVENT;
        private static final Class<?> CLASS_CLIENTBOUND_CUSTOM_SOUND = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutCustomSoundEffect"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundCustomSoundPacket"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutCustomSoundEffect"));
        private static final Class<?> CLASS_VEC3 = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("Vec3D"), MinecraftReflection.findMcClassName("world.phys.Vec3D"), MinecraftReflection.findMcClassName("world.phys.Vec3"));
        private static final MethodHandle NEW_VEC3 = MinecraftReflection.findConstructor(CLASS_VEC3, Double.TYPE, Double.TYPE, Double.TYPE);
        private static final MethodHandle NEW_RESOURCE_LOCATION = MinecraftReflection.findConstructor(CraftBukkitAccess.CLASS_RESOURCE_LOCATION, String.class, String.class);
        private static final MethodHandle REGISTRY_GET_OPTIONAL = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "getOptional", (Class<?>) Optional.class, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});

        EntitySound() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || NEW_CLIENTBOUND_ENTITY_SOUND == null || NEW_RESOURCE_LOCATION == null || REGISTRY_SOUND_EVENT == null || REGISTRY_GET_OPTIONAL == null || CraftBukkitFacet.CRAFT_ENTITY_GET_HANDLE == null || !CraftBukkitAccess.EntitySound.isSupported()) ? false : true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PartialEntitySound
        public Object createForEntity(Sound sound, Entity entity) {
            Object vanilla;
            try {
                Object nativeEntity = toNativeEntity(entity);
                if (nativeEntity == null || (vanilla = toVanilla(sound.source())) == null) {
                    return null;
                }
                Object objInvoke = (Object) NEW_RESOURCE_LOCATION.invoke(sound.name().namespace(), sound.name().value());
                Optional optionalInvoke = (Optional) REGISTRY_GET_OPTIONAL.invoke(REGISTRY_SOUND_EVENT, objInvoke);
                long jOrElseGet = sound.seed().orElseGet(() -> {
                    return ThreadLocalRandom.current().nextLong();
                });
                if (optionalInvoke.isPresent()) {
                    return (Object) NEW_CLIENTBOUND_ENTITY_SOUND.invoke(optionalInvoke.get(), vanilla, nativeEntity, sound.volume(), sound.pitch(), jOrElseGet);
                }
                if (NEW_CLIENTBOUND_CUSTOM_SOUND == null || NEW_VEC3 == null) {
                    return null;
                }
                Location location = entity.getLocation();
                return (Object) NEW_CLIENTBOUND_CUSTOM_SOUND.invoke(objInvoke, vanilla, (Object) NEW_VEC3.invoke(location.getX(), location.getY(), location.getZ()), sound.volume(), sound.pitch(), jOrElseGet);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send sound tracking an entity", new Object[0]);
                return null;
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.EntitySound
        public void playSound(@NotNull Player player, Object obj) {
            sendPacket(player, obj);
        }

        static {
            MethodHandle methodHandleFindConstructor = MinecraftReflection.findConstructor(CraftBukkitAccess.EntitySound.CLASS_CLIENTBOUND_ENTITY_SOUND, CraftBukkitAccess.EntitySound.CLASS_SOUND_EVENT, CraftBukkitAccess.EntitySound.CLASS_SOUND_SOURCE, CraftBukkitFacet.CLASS_NMS_ENTITY, Float.TYPE, Float.TYPE, Long.TYPE);
            if (methodHandleFindConstructor == null) {
                methodHandleFindConstructor = MinecraftReflection.findConstructor(CraftBukkitAccess.EntitySound.CLASS_CLIENTBOUND_ENTITY_SOUND, CraftBukkitAccess.EntitySound.CLASS_SOUND_EVENT, CraftBukkitAccess.EntitySound.CLASS_SOUND_SOURCE, CraftBukkitFacet.CLASS_NMS_ENTITY, Float.TYPE, Float.TYPE);
                if (methodHandleFindConstructor != null) {
                    methodHandleFindConstructor = MethodHandles.dropArguments(methodHandleFindConstructor, 5, (Class<?>[]) new Class[]{Long.TYPE});
                }
            }
            NEW_CLIENTBOUND_ENTITY_SOUND = methodHandleFindConstructor;
            MethodHandle methodHandleFindConstructor2 = MinecraftReflection.findConstructor(CLASS_CLIENTBOUND_CUSTOM_SOUND, CraftBukkitAccess.CLASS_RESOURCE_LOCATION, CraftBukkitAccess.EntitySound.CLASS_SOUND_SOURCE, CLASS_VEC3, Float.TYPE, Float.TYPE, Long.TYPE);
            if (methodHandleFindConstructor2 == null) {
                methodHandleFindConstructor2 = MinecraftReflection.findConstructor(CLASS_CLIENTBOUND_CUSTOM_SOUND, CraftBukkitAccess.CLASS_RESOURCE_LOCATION, CraftBukkitAccess.EntitySound.CLASS_SOUND_SOURCE, CLASS_VEC3, Float.TYPE, Float.TYPE);
                if (methodHandleFindConstructor2 != null) {
                    methodHandleFindConstructor2 = MethodHandles.dropArguments(methodHandleFindConstructor2, 5, (Class<?>[]) new Class[]{Long.TYPE});
                }
            }
            NEW_CLIENTBOUND_CUSTOM_SOUND = methodHandleFindConstructor2;
            Object objOrElse = null;
            if (CraftBukkitAccess.CLASS_REGISTRY != null) {
                try {
                    Field fieldFindField = MinecraftReflection.findField(CraftBukkitAccess.CLASS_REGISTRY, "SOUND_EVENT");
                    if (fieldFindField != null) {
                        objOrElse = fieldFindField.get(null);
                    } else {
                        Object obj = null;
                        for (Field field : CraftBukkitAccess.CLASS_REGISTRY.getDeclaredFields()) {
                            if ((field.getModifiers() & 28) == 28 && field.getType().equals(CraftBukkitAccess.CLASS_WRITABLE_REGISTRY)) {
                                field.setAccessible(true);
                                obj = field.get(null);
                                break;
                            }
                        }
                        if (obj != null) {
                            objOrElse = (Optional) REGISTRY_GET_OPTIONAL.invoke(obj, (Object) NEW_RESOURCE_LOCATION.invoke(Key.MINECRAFT_NAMESPACE, "sound_event")).orElse(null);
                        }
                    }
                } catch (Throwable th) {
                    Knob.logError(th, "Failed to initialize EntitySound CraftBukkit facet", new Object[0]);
                }
            }
            REGISTRY_SOUND_EVENT = objOrElse;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$EntitySound_1_19_3.class */
    static class EntitySound_1_19_3 extends PacketFacet<Player> implements PartialEntitySound {
        EntitySound_1_19_3() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return CraftBukkitAccess.EntitySound_1_19_3.isSupported() && super.isSupported();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PartialEntitySound
        public Object createForEntity(Sound sound, Entity entity) {
            try {
                Object objInvoke = (Object) CraftBukkitAccess.NEW_RESOURCE_LOCATION.invoke(sound.name().namespace(), sound.name().value());
                Optional optionalInvoke = (Optional) CraftBukkitAccess.EntitySound_1_19_3.REGISTRY_GET_OPTIONAL.invoke(CraftBukkitAccess.EntitySound_1_19_3.SOUND_EVENT_REGISTRY, objInvoke);
                return (Object) CraftBukkitAccess.EntitySound_1_19_3.NEW_CLIENTBOUND_ENTITY_SOUND.invoke((Object) CraftBukkitAccess.EntitySound_1_19_3.REGISTRY_WRAP_AS_HOLDER.invoke(CraftBukkitAccess.EntitySound_1_19_3.SOUND_EVENT_REGISTRY, optionalInvoke.isPresent() ? optionalInvoke.get() : (Object) CraftBukkitAccess.EntitySound_1_19_3.SOUND_EVENT_CREATE_VARIABLE_RANGE.invoke(objInvoke)), toVanilla(sound.source()), toNativeEntity(entity), sound.volume(), sound.pitch(), sound.seed().orElseGet(() -> {
                    return ThreadLocalRandom.current().nextLong();
                }));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send sound tracking an entity", new Object[0]);
                return null;
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.EntitySound
        public void playSound(@NotNull Player player, Object obj) {
            sendPacket(player, obj);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$FakeEntity.class */
    static class FakeEntity<E extends Entity> extends PacketFacet<Player> implements Facet.FakeEntity<Player, Location>, Listener {
        private static final Class<? extends World> CLASS_CRAFT_WORLD = MinecraftReflection.findCraftClass("CraftWorld", World.class);
        private static final Class<?> CLASS_NMS_LIVING_ENTITY = MinecraftReflection.findNmsClass("EntityLiving");
        private static final Class<?> CLASS_DATA_WATCHER = MinecraftReflection.findNmsClass("DataWatcher");
        private static final MethodHandle CRAFT_WORLD_CREATE_ENTITY = MinecraftReflection.findMethod(CLASS_CRAFT_WORLD, "createEntity", (Class<?>) CraftBukkitFacet.CLASS_NMS_ENTITY, (Class<?>[]) new Class[]{Location.class, Class.class});
        private static final MethodHandle NMS_ENTITY_GET_BUKKIT_ENTITY = MinecraftReflection.findMethod((Class<?>) CraftBukkitFacet.CLASS_NMS_ENTITY, "getBukkitEntity", (Class<?>) CraftBukkitFacet.CLASS_CRAFT_ENTITY, (Class<?>[]) new Class[0]);
        private static final MethodHandle NMS_ENTITY_GET_DATA_WATCHER = MinecraftReflection.findMethod((Class<?>) CraftBukkitFacet.CLASS_NMS_ENTITY, "getDataWatcher", CLASS_DATA_WATCHER, (Class<?>[]) new Class[0]);
        private static final MethodHandle NMS_ENTITY_SET_LOCATION = MinecraftReflection.findMethod((Class<?>) CraftBukkitFacet.CLASS_NMS_ENTITY, "setLocation", (Class<?>) Void.TYPE, (Class<?>[]) new Class[]{Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE});
        private static final MethodHandle NMS_ENTITY_SET_INVISIBLE = MinecraftReflection.findMethod((Class<?>) CraftBukkitFacet.CLASS_NMS_ENTITY, "setInvisible", (Class<?>) Void.TYPE, (Class<?>[]) new Class[]{Boolean.TYPE});
        private static final MethodHandle DATA_WATCHER_WATCH = MinecraftReflection.findMethod(CLASS_DATA_WATCHER, "watch", (Class<?>) Void.TYPE, (Class<?>[]) new Class[]{Integer.TYPE, Object.class});
        private static final Class<?> CLASS_SPAWN_LIVING_PACKET = MinecraftReflection.findNmsClass("PacketPlayOutSpawnEntityLiving");
        private static final MethodHandle NEW_SPAWN_LIVING_PACKET = MinecraftReflection.findConstructor(CLASS_SPAWN_LIVING_PACKET, CLASS_NMS_LIVING_ENTITY);
        private static final Class<?> CLASS_ENTITY_DESTROY_PACKET = MinecraftReflection.findNmsClass("PacketPlayOutEntityDestroy");
        private static final MethodHandle NEW_ENTITY_DESTROY_PACKET = MinecraftReflection.findConstructor(CLASS_ENTITY_DESTROY_PACKET, int[].class);
        private static final Class<?> CLASS_ENTITY_METADATA_PACKET = MinecraftReflection.findNmsClass("PacketPlayOutEntityMetadata");
        private static final MethodHandle NEW_ENTITY_METADATA_PACKET = MinecraftReflection.findConstructor(CLASS_ENTITY_METADATA_PACKET, Integer.TYPE, CLASS_DATA_WATCHER, Boolean.TYPE);
        private static final Class<?> CLASS_ENTITY_TELEPORT_PACKET = MinecraftReflection.findNmsClass("PacketPlayOutEntityTeleport");
        private static final MethodHandle NEW_ENTITY_TELEPORT_PACKET = MinecraftReflection.findConstructor(CLASS_ENTITY_TELEPORT_PACKET, CraftBukkitFacet.CLASS_NMS_ENTITY);
        private static final Class<?> CLASS_ENTITY_WITHER = MinecraftReflection.findNmsClass("EntityWither");
        private static final Class<?> CLASS_WORLD = MinecraftReflection.findNmsClass("World");
        private static final Class<?> CLASS_WORLD_SERVER = MinecraftReflection.findNmsClass("WorldServer");
        private static final MethodHandle CRAFT_WORLD_GET_HANDLE = MinecraftReflection.findMethod(CLASS_CRAFT_WORLD, "getHandle", CLASS_WORLD_SERVER, (Class<?>[]) new Class[0]);
        private static final MethodHandle NEW_ENTITY_WITHER = MinecraftReflection.findConstructor(CLASS_ENTITY_WITHER, CLASS_WORLD);
        private static final boolean SUPPORTED;
        private final E entity;
        private final Object entityHandle;
        protected final Set<Player> viewers;

        protected FakeEntity(@NotNull Class<E> cls, @NotNull Location location) {
            this(BukkitAudience.PLUGIN.get(), cls, location);
        }

        protected FakeEntity(@NotNull Plugin plugin, @NotNull Class<E> cls, @NotNull Location location) {
            Entity entityInvoke = null;
            Object objInvoke = null;
            if (SUPPORTED) {
                try {
                    if (CRAFT_WORLD_CREATE_ENTITY != null) {
                        entityInvoke = (Entity) NMS_ENTITY_GET_BUKKIT_ENTITY.invoke((Object) CRAFT_WORLD_CREATE_ENTITY.invoke(location.getWorld(), location, cls));
                    } else if (Wither.class.isAssignableFrom(cls) && NEW_ENTITY_WITHER != null) {
                        entityInvoke = (Entity) NMS_ENTITY_GET_BUKKIT_ENTITY.invoke((Object) NEW_ENTITY_WITHER.invoke((Object) CRAFT_WORLD_GET_HANDLE.invoke(location.getWorld())));
                    }
                    if (CraftBukkitFacet.CLASS_CRAFT_ENTITY.isInstance(entityInvoke)) {
                        objInvoke = (Object) CraftBukkitFacet.CRAFT_ENTITY_GET_HANDLE.invoke(entityInvoke);
                    }
                } catch (Throwable th) {
                    Knob.logError(th, "Failed to create fake entity: %s", cls.getSimpleName());
                }
            }
            this.entity = (E) entityInvoke;
            this.entityHandle = objInvoke;
            this.viewers = new HashSet();
            if (isSupported()) {
                plugin.getServer().getPluginManager().registerEvents(this, plugin);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || this.entity == null || this.entityHandle == null) ? false : true;
        }

        @EventHandler(ignoreCancelled = false, priority = EventPriority.MONITOR)
        public void onPlayerMove(PlayerMoveEvent playerMoveEvent) {
            Player player = playerMoveEvent.getPlayer();
            if (this.viewers.contains(player)) {
                teleport(player, createPosition(player));
            }
        }

        @Nullable
        public Object createSpawnPacket() {
            if (!(this.entity instanceof LivingEntity)) {
                return null;
            }
            try {
                return (Object) NEW_SPAWN_LIVING_PACKET.invoke(this.entityHandle);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to create spawn packet: %s", this.entity);
                return null;
            }
        }

        @Nullable
        public Object createDespawnPacket() {
            try {
                return (Object) NEW_ENTITY_DESTROY_PACKET.invoke(this.entity.getEntityId());
            } catch (Throwable th) {
                Knob.logError(th, "Failed to create despawn packet: %s", this.entity);
                return null;
            }
        }

        @Nullable
        public Object createMetadataPacket() {
            try {
                return (Object) NEW_ENTITY_METADATA_PACKET.invoke(this.entity.getEntityId(), (Object) NMS_ENTITY_GET_DATA_WATCHER.invoke(this.entityHandle), false);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to create update metadata packet: %s", this.entity);
                return null;
            }
        }

        @Nullable
        public Object createLocationPacket() {
            try {
                return (Object) NEW_ENTITY_TELEPORT_PACKET.invoke(this.entityHandle);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to create teleport packet: %s", this.entity);
                return null;
            }
        }

        public void broadcastPacket(@Nullable Object obj) {
            Iterator<Player> it = this.viewers.iterator();
            while (it.hasNext()) {
                sendPacket(it.next(), obj);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Position
        @NotNull
        public Location createPosition(@NotNull Player player) {
            return player.getLocation();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Position
        @NotNull
        public Location createPosition(double d, double d2, double d3) {
            return new Location((World) null, d, d2, d3);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.FakeEntity
        public void teleport(@NotNull Player player, @Nullable Location location) {
            if (location == null) {
                this.viewers.remove(player);
                sendPacket(player, createDespawnPacket());
                return;
            }
            if (!this.viewers.contains(player)) {
                sendPacket(player, createSpawnPacket());
                this.viewers.add(player);
            }
            try {
                NMS_ENTITY_SET_LOCATION.invoke(this.entityHandle, location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
            } catch (Throwable th) {
                Knob.logError(th, "Failed to set entity location: %s %s", this.entity, location);
            }
            sendPacket(player, createLocationPacket());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.FakeEntity
        public void metadata(int i, @NotNull Object obj) {
            if (DATA_WATCHER_WATCH != null) {
                try {
                    DATA_WATCHER_WATCH.invoke((Object) NMS_ENTITY_GET_DATA_WATCHER.invoke(this.entityHandle), i, obj);
                } catch (Throwable th) {
                    Knob.logError(th, "Failed to set entity metadata: %s %s=%s", this.entity, Integer.valueOf(i), obj);
                }
                broadcastPacket(createMetadataPacket());
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.FakeEntity
        public void invisible(boolean z) {
            if (NMS_ENTITY_SET_INVISIBLE != null) {
                try {
                    NMS_ENTITY_SET_INVISIBLE.invoke(this.entityHandle, z);
                } catch (Throwable th) {
                    Knob.logError(th, "Failed to change entity visibility: %s", this.entity);
                }
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.FakeEntity
        @Deprecated
        public void health(float f) {
            if (this.entity instanceof Damageable) {
                Damageable damageable = this.entity;
                damageable.setHealth((((double) f) * (damageable.getMaxHealth() - 0.10000000149011612d)) + 0.10000000149011612d);
                broadcastPacket(createMetadataPacket());
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.FakeEntity
        public void name(@NotNull Component component) {
            this.entity.setCustomName(BukkitComponentSerializer.legacy().serialize(component));
            broadcastPacket(createMetadataPacket());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.FakeEntity, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            HandlerList.unregisterAll(this);
            Iterator it = new LinkedList(this.viewers).iterator();
            while (it.hasNext()) {
                teleport((Player) it.next(), (Location) null);
            }
        }

        static {
            SUPPORTED = ((CRAFT_WORLD_CREATE_ENTITY == null && (NEW_ENTITY_WITHER == null || CRAFT_WORLD_GET_HANDLE == null)) || CraftBukkitFacet.CRAFT_ENTITY_GET_HANDLE == null || NMS_ENTITY_GET_BUKKIT_ENTITY == null || NMS_ENTITY_GET_DATA_WATCHER == null) ? false : true;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$PacketFacet.class */
    static class PacketFacet<V extends CommandSender> extends CraftBukkitFacet<V> implements Facet.Message<V, Object> {
        protected PacketFacet() {
            super(CLASS_CRAFT_PLAYER);
        }

        public void sendPacket(@NotNull Player player, @Nullable Object obj) {
            if (obj == null) {
                return;
            }
            try {
                CraftBukkitFacet.PLAYER_CONNECTION_SEND_PACKET.invoke((Object) CraftBukkitFacet.ENTITY_PLAYER_GET_CONNECTION.invoke((Object) CRAFT_PLAYER_GET_HANDLE.invoke(player)), obj);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke CraftBukkit sendPacket: %s", obj);
            }
        }

        public void sendMessage(@NotNull V v, @Nullable Object obj) {
            sendPacket((Player) v, obj);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @Nullable
        public Object createMessage(@NotNull V v, @NotNull Component component) {
            try {
                return MinecraftComponentSerializer.get().serialize(component);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to serialize net.minecraft.server IChatBaseComponent: %s", component);
                return null;
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$PartialEntitySound.class */
    private interface PartialEntitySound extends Facet.EntitySound<Player, Object> {
        public static final Map<String, Object> MC_SOUND_SOURCE_BY_NAME = new ConcurrentHashMap();

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.EntitySound
        default Object createForSelf(Player player, Sound sound) {
            return createForEntity(sound, player);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.EntitySound
        default Object createForEmitter(Sound sound, Sound.Emitter emitter) {
            Entity entity;
            if (emitter instanceof BukkitEmitter) {
                entity = ((BukkitEmitter) emitter).entity;
            } else {
                if (!(emitter instanceof Entity)) {
                    return null;
                }
                entity = (Entity) emitter;
            }
            return createForEntity(sound, entity);
        }

        default Object toNativeEntity(Entity entity) {
            if (CraftBukkitFacet.CLASS_CRAFT_ENTITY.isInstance(entity)) {
                return (Object) CraftBukkitFacet.CRAFT_ENTITY_GET_HANDLE.invoke(entity);
            }
            return null;
        }

        default Object toVanilla(Sound.Source source) {
            if (MC_SOUND_SOURCE_BY_NAME.isEmpty()) {
                for (Object obj : CraftBukkitAccess.EntitySound.CLASS_SOUND_SOURCE.getEnumConstants()) {
                    MC_SOUND_SOURCE_BY_NAME.put((String) CraftBukkitAccess.EntitySound.SOUND_SOURCE_GET_NAME.invoke(obj), obj);
                }
            }
            return MC_SOUND_SOURCE_BY_NAME.get(Sound.Source.NAMES.key(source));
        }

        Object createForEntity(Sound sound, Entity entity);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$TabList.class */
    static class TabList extends PacketFacet<Player> implements Facet.TabList<Player, Object> {
        private static final Class<?> CLIENTBOUND_TAB_LIST_PACKET = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutPlayerListHeaderFooter"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutPlayerListHeaderFooter"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundTabListPacket"));

        @Nullable
        private static final MethodHandle CLIENTBOUND_TAB_LIST_PACKET_CTOR_PRE_1_17 = MinecraftReflection.findConstructor(CLIENTBOUND_TAB_LIST_PACKET, new Class[0]);

        @Nullable
        protected static final MethodHandle CLIENTBOUND_TAB_LIST_PACKET_CTOR = MinecraftReflection.findConstructor(CLIENTBOUND_TAB_LIST_PACKET, CraftBukkitFacet.CLASS_CHAT_COMPONENT, CraftBukkitFacet.CLASS_CHAT_COMPONENT);

        @Nullable
        private static final Field CRAFT_PLAYER_TAB_LIST_HEADER = MinecraftReflection.findField(CLASS_CRAFT_PLAYER, "playerListHeader");

        @Nullable
        private static final Field CRAFT_PLAYER_TAB_LIST_FOOTER = MinecraftReflection.findField(CLASS_CRAFT_PLAYER, "playerListFooter");

        @Nullable
        protected static final MethodHandle CLIENTBOUND_TAB_LIST_PACKET_SET_HEADER = first(MinecraftReflection.findSetterOf(MinecraftReflection.findField(CLIENTBOUND_TAB_LIST_PACKET, PaperFacet.NATIVE_COMPONENT_CLASS, "adventure$header")), MinecraftReflection.findSetterOf(MinecraftReflection.findField(CLIENTBOUND_TAB_LIST_PACKET, CraftBukkitFacet.CLASS_CHAT_COMPONENT, "header", "a")));

        @Nullable
        protected static final MethodHandle CLIENTBOUND_TAB_LIST_PACKET_SET_FOOTER = first(MinecraftReflection.findSetterOf(MinecraftReflection.findField(CLIENTBOUND_TAB_LIST_PACKET, PaperFacet.NATIVE_COMPONENT_CLASS, "adventure$footer")), MinecraftReflection.findSetterOf(MinecraftReflection.findField(CLIENTBOUND_TAB_LIST_PACKET, CraftBukkitFacet.CLASS_CHAT_COMPONENT, "footer", "b")));

        TabList() {
        }

        private static MethodHandle first(MethodHandle... methodHandleArr) {
            for (MethodHandle methodHandle : methodHandleArr) {
                if (methodHandle != null) {
                    return methodHandle;
                }
            }
            return null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return !(CLIENTBOUND_TAB_LIST_PACKET_CTOR == null && (CLIENTBOUND_TAB_LIST_PACKET_CTOR_PRE_1_17 == null || CLIENTBOUND_TAB_LIST_PACKET_SET_HEADER == null || CLIENTBOUND_TAB_LIST_PACKET_SET_FOOTER == null)) && super.isSupported();
        }

        protected Object create117Packet(Player player, @Nullable Object obj, @Nullable Object obj2) {
            return (Object) CLIENTBOUND_TAB_LIST_PACKET_CTOR.invoke(obj == null ? createMessage(player, (Component) Component.empty()) : obj, obj2 == null ? createMessage(player, (Component) Component.empty()) : obj2);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.TabList
        public void send(Player player, @Nullable Object obj, @Nullable Object obj2) {
            Object objInvoke;
            try {
                if (CRAFT_PLAYER_TAB_LIST_HEADER != null && CRAFT_PLAYER_TAB_LIST_FOOTER != null) {
                    if (obj == null) {
                        obj = CRAFT_PLAYER_TAB_LIST_HEADER.get(player);
                    } else {
                        CRAFT_PLAYER_TAB_LIST_HEADER.set(player, obj);
                    }
                    if (obj2 == null) {
                        obj2 = CRAFT_PLAYER_TAB_LIST_FOOTER.get(player);
                    } else {
                        CRAFT_PLAYER_TAB_LIST_FOOTER.set(player, obj2);
                    }
                }
                if (CLIENTBOUND_TAB_LIST_PACKET_CTOR != null) {
                    objInvoke = create117Packet(player, obj, obj2);
                } else {
                    objInvoke = (Object) CLIENTBOUND_TAB_LIST_PACKET_CTOR_PRE_1_17.invoke();
                    CLIENTBOUND_TAB_LIST_PACKET_SET_HEADER.invoke(objInvoke, obj == null ? createMessage(player, (Component) Component.empty()) : obj);
                    CLIENTBOUND_TAB_LIST_PACKET_SET_FOOTER.invoke(objInvoke, obj2 == null ? createMessage(player, (Component) Component.empty()) : obj2);
                }
                sendPacket(player, objInvoke);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send tab list header and footer to %s", player);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Title.class */
    static class Title extends PacketFacet<Player> implements Facet.Title<Player, Object, List<Object>, List<?>> {
        Title() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || CraftBukkitFacet.CONSTRUCTOR_TITLE_MESSAGE == null || CraftBukkitFacet.CONSTRUCTOR_TITLE_TIMES == null) ? false : true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @NotNull
        public List<Object> createTitleCollection() {
            return new ArrayList();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTitle(@NotNull List<Object> list, @NotNull Object obj) {
            try {
                list.add((Object) CraftBukkitFacet.CONSTRUCTOR_TITLE_MESSAGE.invoke(CraftBukkitFacet.TITLE_ACTION_TITLE, obj));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke title packet constructor", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeSubtitle(@NotNull List<Object> list, @NotNull Object obj) {
            try {
                list.add((Object) CraftBukkitFacet.CONSTRUCTOR_TITLE_MESSAGE.invoke(CraftBukkitFacet.TITLE_ACTION_SUBTITLE, obj));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke subtitle packet constructor", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTimes(@NotNull List<Object> list, int i, int i2, int i3) {
            try {
                list.add((Object) CraftBukkitFacet.CONSTRUCTOR_TITLE_TIMES.invoke(i, i2, i3));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke title animations packet constructor", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @Nullable
        public List<?> completeTitle(@NotNull List<Object> list) {
            return list;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void showTitle(@NotNull Player player, @NotNull List<?> list) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                sendMessage(player, it.next());
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void clearTitle(@NotNull Player player) {
            try {
                if (CraftBukkitFacet.TITLE_ACTION_CLEAR != null) {
                    sendPacket(player, (Object) CraftBukkitFacet.CONSTRUCTOR_TITLE_MESSAGE.invoke(CraftBukkitFacet.TITLE_ACTION_CLEAR, null));
                } else {
                    player.sendTitle("", "", -1, -1, -1);
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to clear title", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void resetTitle(@NotNull Player player) {
            try {
                if (CraftBukkitFacet.TITLE_ACTION_RESET != null) {
                    sendPacket(player, (Object) CraftBukkitFacet.CONSTRUCTOR_TITLE_MESSAGE.invoke(CraftBukkitFacet.TITLE_ACTION_RESET, null));
                } else {
                    player.resetTitle();
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to clear title", new Object[0]);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Title_1_17.class */
    static class Title_1_17 extends PacketFacet<Player> implements Facet.Title<Player, Object, List<Object>, List<?>> {
        private static final Class<?> PACKET_SET_TITLE = MinecraftReflection.findMcClass("network.protocol.game.ClientboundSetTitleTextPacket");
        private static final Class<?> PACKET_SET_SUBTITLE = MinecraftReflection.findMcClass("network.protocol.game.ClientboundSetSubtitleTextPacket");
        private static final Class<?> PACKET_SET_TITLE_ANIMATION = MinecraftReflection.findMcClass("network.protocol.game.ClientboundSetTitlesAnimationPacket");
        private static final Class<?> PACKET_CLEAR_TITLES = MinecraftReflection.findMcClass("network.protocol.game.ClientboundClearTitlesPacket");
        private static final MethodHandle CONSTRUCTOR_SET_TITLE = MinecraftReflection.findConstructor(PACKET_SET_TITLE, CraftBukkitFacet.CLASS_CHAT_COMPONENT);
        private static final MethodHandle CONSTRUCTOR_SET_SUBTITLE = MinecraftReflection.findConstructor(PACKET_SET_SUBTITLE, CraftBukkitFacet.CLASS_CHAT_COMPONENT);
        private static final MethodHandle CONSTRUCTOR_SET_TITLE_ANIMATION = MinecraftReflection.findConstructor(PACKET_SET_TITLE_ANIMATION, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        private static final MethodHandle CONSTRUCTOR_CLEAR_TITLES = MinecraftReflection.findConstructor(PACKET_CLEAR_TITLES, Boolean.TYPE);

        Title_1_17() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || CONSTRUCTOR_SET_TITLE == null || CONSTRUCTOR_SET_SUBTITLE == null || CONSTRUCTOR_SET_TITLE_ANIMATION == null || CONSTRUCTOR_CLEAR_TITLES == null) ? false : true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @NotNull
        public List<Object> createTitleCollection() {
            return new ArrayList();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTitle(@NotNull List<Object> list, @NotNull Object obj) {
            try {
                list.add((Object) CONSTRUCTOR_SET_TITLE.invoke(obj));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke title packet constructor", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeSubtitle(@NotNull List<Object> list, @NotNull Object obj) {
            try {
                list.add((Object) CONSTRUCTOR_SET_SUBTITLE.invoke(obj));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke subtitle packet constructor", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTimes(@NotNull List<Object> list, int i, int i2, int i3) {
            try {
                list.add((Object) CONSTRUCTOR_SET_TITLE_ANIMATION.invoke(i, i2, i3));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to invoke title animations packet constructor", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @Nullable
        public List<?> completeTitle(@NotNull List<Object> list) {
            return list;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void showTitle(@NotNull Player player, @NotNull List<?> list) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                sendMessage(player, it.next());
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void clearTitle(@NotNull Player player) {
            try {
                if (CONSTRUCTOR_CLEAR_TITLES != null) {
                    sendPacket(player, (Object) CONSTRUCTOR_CLEAR_TITLES.invoke(false));
                } else {
                    player.sendTitle("", "", -1, -1, -1);
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to clear title", new Object[0]);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void resetTitle(@NotNull Player player) {
            try {
                if (CONSTRUCTOR_CLEAR_TITLES != null) {
                    sendPacket(player, (Object) CONSTRUCTOR_CLEAR_TITLES.invoke(true));
                } else {
                    player.resetTitle();
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to clear title", new Object[0]);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitFacet$Translator.class */
    static final class Translator extends FacetBase<Server> implements FacetComponentFlattener.Translator<Server> {
        private static final Class<?> CLASS_LANGUAGE = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("LocaleLanguage"), MinecraftReflection.findMcClassName("locale.LocaleLanguage"), MinecraftReflection.findMcClassName("locale.Language"));
        private static final MethodHandle LANGUAGE_GET_INSTANCE;
        private static final MethodHandle LANGUAGE_GET_OR_DEFAULT;

        private static MethodHandle unreflectUnchecked(Method method) {
            try {
                method.setAccessible(true);
                return MinecraftReflection.lookup().unreflect(method);
            } catch (IllegalAccessException e) {
                return null;
            }
        }

        Translator() {
            super(Server.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return (!super.isSupported() || LANGUAGE_GET_INSTANCE == null || LANGUAGE_GET_OR_DEFAULT == null) ? false : true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetComponentFlattener.Translator
        @NotNull
        public String valueOrDefault(@NotNull Server server, @NotNull String str) {
            try {
                return (String) LANGUAGE_GET_OR_DEFAULT.invoke((Object) LANGUAGE_GET_INSTANCE.invoke(), str);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to transate key '%s'", str);
                return str;
            }
        }

        static {
            if (CLASS_LANGUAGE == null) {
                LANGUAGE_GET_INSTANCE = null;
                LANGUAGE_GET_OR_DEFAULT = null;
            } else {
                LANGUAGE_GET_INSTANCE = (MethodHandle) Arrays.stream(CLASS_LANGUAGE.getDeclaredMethods()).filter(method -> {
                    return Modifier.isStatic(method.getModifiers()) && !Modifier.isPrivate(method.getModifiers()) && method.getReturnType().equals(CLASS_LANGUAGE) && method.getParameterCount() == 0;
                }).findFirst().map(Translator::unreflectUnchecked).orElse(null);
                LANGUAGE_GET_OR_DEFAULT = (MethodHandle) Arrays.stream(CLASS_LANGUAGE.getDeclaredMethods()).filter(method2 -> {
                    return !Modifier.isStatic(method2.getModifiers()) && Modifier.isPublic(method2.getModifiers()) && method2.getParameterCount() == 1 && method2.getParameterTypes()[0] == String.class && method2.getReturnType().equals(String.class);
                }).findFirst().map(Translator::unreflectUnchecked).orElse(null);
            }
        }
    }

    protected CraftBukkitFacet(@Nullable Class<? extends V> cls) {
        super(cls);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isSupported() {
        return super.isSupported() && SUPPORTED;
    }

    static {
        Class<?> clsFindCraftClass = MinecraftReflection.findCraftClass("entity.CraftPlayer");
        Class<?> clsFindClass = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("Packet"), MinecraftReflection.findMcClassName("network.protocol.Packet"));
        MethodHandle methodHandleUnreflect = null;
        MethodHandle methodHandleUnreflectGetter = null;
        MethodHandle methodHandleSearchMethod = null;
        if (clsFindCraftClass != null && clsFindClass != null) {
            try {
                Method method = clsFindCraftClass.getMethod("getHandle", new Class[0]);
                Class<?> returnType = method.getReturnType();
                methodHandleUnreflect = MinecraftReflection.lookup().unreflect(method);
                Field fieldFindField = MinecraftReflection.findField(returnType, "playerConnection", "connection");
                Class<?> type = null;
                if (fieldFindField != null) {
                    methodHandleUnreflectGetter = MinecraftReflection.lookup().unreflectGetter(fieldFindField);
                    type = fieldFindField.getType();
                } else {
                    Class<?> clsFindClass2 = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PlayerConnection"), MinecraftReflection.findMcClassName("server.network.PlayerConnection"), MinecraftReflection.findMcClassName("server.network.ServerGamePacketListenerImpl"));
                    for (Field field : returnType.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (Modifier.isPublic(modifiers) && !Modifier.isFinal(modifiers) && (clsFindClass2 == null || field.getType().equals(clsFindClass2))) {
                            methodHandleUnreflectGetter = MinecraftReflection.lookup().unreflectGetter(field);
                            type = field.getType();
                        }
                    }
                }
                Class<?> clsFindClass3 = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("server.network.ServerCommonPacketListenerImpl"));
                if (clsFindClass3 != null) {
                    type = clsFindClass3;
                }
                methodHandleSearchMethod = MinecraftReflection.searchMethod(type, (Integer) 1, new String[]{"sendPacket", "send"}, (Class<?>) Void.TYPE, (Class<?>[]) new Class[]{clsFindClass});
            } catch (Throwable th) {
                Knob.logError(th, "Failed to initialize CraftBukkit sendPacket", new Object[0]);
            }
        }
        CRAFT_PLAYER_GET_HANDLE = methodHandleUnreflect;
        ENTITY_PLAYER_GET_CONNECTION = methodHandleUnreflectGetter;
        PLAYER_CONNECTION_SEND_PACKET = methodHandleSearchMethod;
        SUPPORTED = (!Knob.isEnabled("craftbukkit", true) || !MinecraftComponentSerializer.isSupported() || CRAFT_PLAYER_GET_HANDLE == null || ENTITY_PLAYER_GET_CONNECTION == null || PLAYER_CONNECTION_SEND_PACKET == null) ? false : true;
        CLASS_CHAT_COMPONENT = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("IChatBaseComponent"), MinecraftReflection.findMcClassName("network.chat.IChatBaseComponent"), MinecraftReflection.findMcClassName("network.chat.Component"));
        CLASS_MESSAGE_TYPE = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("ChatMessageType"), MinecraftReflection.findMcClassName("network.chat.ChatMessageType"), MinecraftReflection.findMcClassName("network.chat.ChatType"));
        if (CLASS_MESSAGE_TYPE == null || CLASS_MESSAGE_TYPE.isEnum()) {
            MESSAGE_TYPE_CHAT = MinecraftReflection.findEnum(CLASS_MESSAGE_TYPE, "CHAT", 0);
            MESSAGE_TYPE_SYSTEM = MinecraftReflection.findEnum(CLASS_MESSAGE_TYPE, "SYSTEM", 1);
            MESSAGE_TYPE_ACTIONBAR = MinecraftReflection.findEnum(CLASS_MESSAGE_TYPE, "GAME_INFO", 2);
        } else {
            MESSAGE_TYPE_CHAT = 0;
            MESSAGE_TYPE_SYSTEM = 1;
            MESSAGE_TYPE_ACTIONBAR = 2;
        }
        MethodHandle methodHandleFindConstructor = null;
        MethodHandle methodHandleFindConstructor2 = null;
        try {
            if (CLASS_CHAT_COMPONENT != null) {
                Class<?> clsNeedClass = MinecraftReflection.needClass(MinecraftReflection.findNmsClassName("PacketPlayOutChat"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutChat"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundChatPacket"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundSystemChatPacket"));
                methodHandleFindConstructor2 = MESSAGE_TYPE_CHAT == 0 ? MinecraftReflection.findConstructor(clsNeedClass, CLASS_CHAT_COMPONENT, Boolean.TYPE) : null;
                if (methodHandleFindConstructor2 == null) {
                    methodHandleFindConstructor2 = MinecraftReflection.findConstructor(clsNeedClass, CLASS_CHAT_COMPONENT, Integer.TYPE);
                }
                if (methodHandleFindConstructor2 == null) {
                    methodHandleFindConstructor2 = MinecraftReflection.findConstructor(clsNeedClass, CLASS_CHAT_COMPONENT);
                }
                if (methodHandleFindConstructor2 == null) {
                    if (CLASS_MESSAGE_TYPE != null) {
                        methodHandleFindConstructor2 = MinecraftReflection.findConstructor(clsNeedClass, CLASS_CHAT_COMPONENT, CLASS_MESSAGE_TYPE, UUID.class);
                    }
                } else if (MESSAGE_TYPE_CHAT == 0) {
                    methodHandleFindConstructor2 = methodHandleFindConstructor2.type().parameterType(1).equals(Boolean.TYPE) ? MethodHandles.dropArguments(MethodHandles.insertArguments(methodHandleFindConstructor2, 1, Boolean.FALSE), 1, (Class<?>[]) new Class[]{Integer.class, UUID.class}) : MethodHandles.dropArguments(methodHandleFindConstructor2, 2, (Class<?>[]) new Class[]{UUID.class});
                } else {
                    MethodHandle methodHandle = methodHandleFindConstructor2;
                    Class[] clsArr = new Class[2];
                    clsArr[0] = CLASS_MESSAGE_TYPE == null ? Object.class : CLASS_MESSAGE_TYPE;
                    clsArr[1] = UUID.class;
                    methodHandleFindConstructor2 = MethodHandles.dropArguments(methodHandle, 1, (Class<?>[]) clsArr);
                }
                methodHandleFindConstructor = MinecraftReflection.findConstructor(clsNeedClass, CLASS_CHAT_COMPONENT, Byte.TYPE);
                if (methodHandleFindConstructor == null) {
                    methodHandleFindConstructor = MinecraftReflection.findConstructor(clsNeedClass, CLASS_CHAT_COMPONENT, Integer.TYPE);
                }
            }
        } catch (Throwable th2) {
            Knob.logError(th2, "Failed to initialize ClientboundChatPacket constructor", new Object[0]);
        }
        CHAT_PACKET_CONSTRUCTOR = methodHandleFindConstructor2;
        LEGACY_CHAT_PACKET_CONSTRUCTOR = methodHandleFindConstructor;
        CLASS_TITLE_PACKET = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutTitle"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutTitle"));
        CLASS_TITLE_ACTION = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutTitle$EnumTitleAction"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutTitle$EnumTitleAction"));
        CONSTRUCTOR_TITLE_MESSAGE = MinecraftReflection.findConstructor(CLASS_TITLE_PACKET, CLASS_TITLE_ACTION, CLASS_CHAT_COMPONENT);
        CONSTRUCTOR_TITLE_TIMES = MinecraftReflection.findConstructor(CLASS_TITLE_PACKET, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        TITLE_ACTION_TITLE = MinecraftReflection.findEnum(CLASS_TITLE_ACTION, "TITLE", 0);
        TITLE_ACTION_SUBTITLE = MinecraftReflection.findEnum(CLASS_TITLE_ACTION, "SUBTITLE", 1);
        TITLE_ACTION_ACTIONBAR = MinecraftReflection.findEnum(CLASS_TITLE_ACTION, "ACTIONBAR");
        TITLE_ACTION_CLEAR = MinecraftReflection.findEnum(CLASS_TITLE_ACTION, "CLEAR");
        TITLE_ACTION_RESET = MinecraftReflection.findEnum(CLASS_TITLE_ACTION, "RESET");
    }
}
