package me.ulrich.clans.library.kyori.adventure.platform.viaversion;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import io.netty.buffer.ByteBuf;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.audience.MessageType;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Facet;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet.class */
public class ViaFacet<V> extends FacetBase<V> implements Facet.Message<V, String> {
    private static final String PACKAGE = "com.viaversion.viaversion";
    private static final int SUPPORTED_VIA_MAJOR_VERSION = 4;
    private static final boolean SUPPORTED;
    private final Function<V, UserConnection> connectionFunction;
    private final int minProtocol;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$ActionBar.class */
    public static class ActionBar<V> extends Chat<V> implements Facet.ActionBar<V, String> {
        public ActionBar(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            super(cls, function);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ChatPacket
        public byte createMessageType(@NotNull MessageType messageType) {
            return (byte) 2;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ActionBar
        public void sendMessage(@NotNull V v, @NotNull String str) {
            sendMessage((Object) v, Identity.nil(), str, (Object) MessageType.CHAT);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$ActionBarTitle.class */
    public static class ActionBarTitle<V> extends ProtocolBased<V> implements Facet.ActionBar<V, String> {
        public ActionBarTitle(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            super("1_11", "1_10", Facet.Title.PROTOCOL_ACTION_BAR, "TITLE", cls, function);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.ActionBar
        public void sendMessage(@NotNull V v, @NotNull String str) {
            PacketWrapper packetWrapperCreatePacket = createPacket(v);
            packetWrapperCreatePacket.write(Type.VAR_INT, 2);
            packetWrapperCreatePacket.write(Type.COMPONENT, parse(str));
            sendPacket(packetWrapperCreatePacket);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$BossBar.class */
    public static final class BossBar<V> extends ProtocolBased<V> implements Facet.BossBarPacket<V> {
        private final Set<V> viewers;
        private UUID id;
        private String title;
        private float health;
        private int color;
        private int overlay;
        private byte flags;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$BossBar$Builder.class */
        public static class Builder<V> extends ViaFacet<V> implements Facet.BossBar.Builder<V, Facet.BossBar<V>> {
            public Builder(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
                super(cls, function, Facet.Message.PROTOCOL_HEX_COLOR);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar.Builder
            public Facet.BossBar<V> createBossBar(@NotNull Collection<V> collection) {
                return new BossBar("1_16", "1_15_2", this.viewerClass, this::findConnection, collection);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // me.ulrich.clans.library.kyori.adventure.platform.viaversion.ViaFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
            @NotNull
            public /* bridge */ /* synthetic */ String createMessage(@NotNull Object obj, @NotNull Component component) {
                return super.createMessage(obj, component);
            }
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$BossBar$Builder1_9_To_1_15.class */
        public static class Builder1_9_To_1_15<V> extends ViaFacet<V> implements Facet.BossBar.Builder<V, Facet.BossBar<V>> {
            public Builder1_9_To_1_15(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
                super(cls, function, Facet.BossBar.PROTOCOL_BOSS_BAR);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar.Builder
            public Facet.BossBar<V> createBossBar(@NotNull Collection<V> collection) {
                return new BossBar("1_9", "1_8", this.viewerClass, this::findConnection, collection);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // me.ulrich.clans.library.kyori.adventure.platform.viaversion.ViaFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
            @NotNull
            public /* bridge */ /* synthetic */ String createMessage(@NotNull Object obj, @NotNull Component component) {
                return super.createMessage(obj, component);
            }
        }

        private BossBar(@NotNull String str, @NotNull String str2, @NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function, Collection<V> collection) {
            super(str, str2, Facet.BossBar.PROTOCOL_BOSS_BAR, "BOSSBAR", cls, function);
            this.viewers = new CopyOnWriteArraySet(collection);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void bossBarInitialized(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar) {
            super.bossBarInitialized(bossBar);
            this.id = UUID.randomUUID();
            broadcastPacket(0);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarNameChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, @NotNull Component component, @NotNull Component component2) {
            if (this.viewers.isEmpty()) {
                return;
            }
            this.title = createMessage((Object) this.viewers.iterator().next(), component2);
            broadcastPacket(3);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarProgressChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, float f, float f2) {
            this.health = f2;
            broadcastPacket(2);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarColorChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color color, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color color2) {
            this.color = createColor(color2);
            broadcastPacket(4);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarOverlayChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay overlay, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay overlay2) {
            this.overlay = createOverlay(overlay2);
            broadcastPacket(4);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarFlagsChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, @NotNull Set<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> set, @NotNull Set<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> set2) {
            this.flags = createFlag(this.flags, set, set2);
            broadcastPacket(5);
        }

        public void sendPacket(@NotNull V v, int i) {
            PacketWrapper packetWrapperCreatePacket = createPacket(v);
            packetWrapperCreatePacket.write(Type.UUID, this.id);
            packetWrapperCreatePacket.write(Type.VAR_INT, Integer.valueOf(i));
            if (i == 0 || i == 3) {
                packetWrapperCreatePacket.write(Type.COMPONENT, parse(this.title));
            }
            if (i == 0 || i == 2) {
                packetWrapperCreatePacket.write(Type.FLOAT, Float.valueOf(this.health));
            }
            if (i == 0 || i == 4) {
                packetWrapperCreatePacket.write(Type.VAR_INT, Integer.valueOf(this.color));
                packetWrapperCreatePacket.write(Type.VAR_INT, Integer.valueOf(this.overlay));
            }
            if (i == 0 || i == 5) {
                packetWrapperCreatePacket.write(Type.BYTE, Byte.valueOf(this.flags));
            }
            sendPacket(packetWrapperCreatePacket);
        }

        public void broadcastPacket(int i) {
            if (isEmpty()) {
                return;
            }
            Iterator<V> it = this.viewers.iterator();
            while (it.hasNext()) {
                sendPacket(it.next(), i);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void addViewer(@NotNull V v) {
            if (this.viewers.add(v)) {
                sendPacket(v, 0);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void removeViewer(@NotNull V v) {
            if (this.viewers.remove(v)) {
                sendPacket(v, 1);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public boolean isEmpty() {
            return this.id == null || this.viewers.isEmpty();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            broadcastPacket(1);
            this.viewers.clear();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$Chat.class */
    public static class Chat<V> extends ProtocolBased<V> implements Facet.ChatPacket<V, String> {
        public Chat(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            super("1_16", "1_15_2", Facet.Message.PROTOCOL_HEX_COLOR, "CHAT_MESSAGE", cls, function);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Chat
        public void sendMessage(@NotNull V v, @NotNull Identity identity, @NotNull String str, @NotNull Object obj) {
            PacketWrapper packetWrapperCreatePacket = createPacket(v);
            packetWrapperCreatePacket.write(Type.COMPONENT, parse(str));
            packetWrapperCreatePacket.write(Type.BYTE, Byte.valueOf(createMessageType(obj instanceof MessageType ? (MessageType) obj : MessageType.SYSTEM)));
            packetWrapperCreatePacket.write(Type.UUID, identity.uuid());
            sendPacket(packetWrapperCreatePacket);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$ProtocolBased.class */
    public static class ProtocolBased<V> extends ViaFacet<V> {
        private final Class<? extends Protocol<?, ?, ?, ?>> protocolClass;
        private final Class<? extends ClientboundPacketType> packetClass;
        private final int packetId;

        /* JADX WARN: Multi-variable type inference failed */
        protected ProtocolBased(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            super(cls, function, i);
            String str4 = MessageFormat.format("{0}.protocols.protocol{1}to{2}.Protocol{1}To{2}", ViaFacet.PACKAGE, str, str2);
            String str5 = MessageFormat.format("{0}.protocols.protocol{1}to{2}.ClientboundPackets{1}", ViaFacet.PACKAGE, str, str2);
            Class<?> cls2 = null;
            Class<?> cls3 = null;
            int id = -1;
            try {
                cls2 = Class.forName(str4);
                cls3 = Class.forName(str5);
                for (ClientboundPacketType clientboundPacketType : cls3.getEnumConstants()) {
                    if (clientboundPacketType.getName().equals(str3)) {
                        id = clientboundPacketType.getId();
                        break;
                    }
                }
            } catch (Throwable th) {
            }
            this.protocolClass = cls2;
            this.packetClass = cls3;
            this.packetId = id;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.viaversion.ViaFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && this.protocolClass != null && this.packetClass != null && this.packetId >= 0;
        }

        public PacketWrapper createPacket(@NotNull V v) {
            return PacketWrapper.create(this.packetId, (ByteBuf) null, findConnection(v));
        }

        public void sendPacket(@NotNull PacketWrapper packetWrapper) {
            if (packetWrapper.user() == null) {
                return;
            }
            try {
                packetWrapper.scheduleSend(this.protocolClass);
            } catch (Throwable th) {
                Knob.logError(th, "Failed to send ViaVersion packet: %s %s", packetWrapper.user(), packetWrapper);
            }
        }

        @NotNull
        public JsonElement parse(@NotNull String str) {
            return JsonParser.parseString(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.viaversion.ViaFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @NotNull
        public /* bridge */ /* synthetic */ String createMessage(@NotNull Object obj, @NotNull Component component) {
            return super.createMessage(obj, component);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$TabList.class */
    public static final class TabList<V> extends ProtocolBased<V> implements Facet.TabList<V, String> {
        public TabList(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            super("1_16", "1_15_2", Facet.Message.PROTOCOL_HEX_COLOR, "TAB_LIST", cls, function);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.TabList
        public void send(V v, @Nullable String str, @Nullable String str2) {
            PacketWrapper packetWrapperCreatePacket = createPacket(v);
            packetWrapperCreatePacket.write(Type.COMPONENT, parse(str));
            packetWrapperCreatePacket.write(Type.COMPONENT, parse(str2));
            sendPacket(packetWrapperCreatePacket);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/viaversion/ViaFacet$Title.class */
    public static class Title<V> extends ProtocolBased<V> implements Facet.TitlePacket<V, String, List<Consumer<PacketWrapper>>, Consumer<V>> {
        protected Title(@NotNull String str, @NotNull String str2, int i, @NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            super(str, str2, i, "TITLE", cls, function);
        }

        public Title(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function) {
            this("1_16", "1_15_2", Facet.Message.PROTOCOL_HEX_COLOR, cls, function);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @NotNull
        public List<Consumer<PacketWrapper>> createTitleCollection() {
            return new ArrayList();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTitle(@NotNull List<Consumer<PacketWrapper>> list, @NotNull String str) {
            list.add(packetWrapper -> {
                packetWrapper.write(Type.VAR_INT, 0);
                packetWrapper.write(Type.COMPONENT, parse(str));
            });
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeSubtitle(@NotNull List<Consumer<PacketWrapper>> list, @NotNull String str) {
            list.add(packetWrapper -> {
                packetWrapper.write(Type.VAR_INT, 1);
                packetWrapper.write(Type.COMPONENT, parse(str));
            });
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTimes(@NotNull List<Consumer<PacketWrapper>> list, int i, int i2, int i3) {
            list.add(packetWrapper -> {
                packetWrapper.write(Type.VAR_INT, 3);
                packetWrapper.write(Type.INT, Integer.valueOf(i));
                packetWrapper.write(Type.INT, Integer.valueOf(i2));
                packetWrapper.write(Type.INT, Integer.valueOf(i3));
            });
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @Nullable
        public Consumer<V> completeTitle(@NotNull List<Consumer<PacketWrapper>> list) {
            return obj -> {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    PacketWrapper packetWrapperCreatePacket = createPacket(obj);
                    ((Consumer) list.get(i)).accept(packetWrapperCreatePacket);
                    sendPacket(packetWrapperCreatePacket);
                }
            };
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void showTitle(@NotNull V v, @NotNull Consumer<V> consumer) {
            consumer.accept(v);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void clearTitle(@NotNull V v) {
            PacketWrapper packetWrapperCreatePacket = createPacket(v);
            packetWrapperCreatePacket.write(Type.VAR_INT, 4);
            sendPacket(packetWrapperCreatePacket);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void resetTitle(@NotNull V v) {
            PacketWrapper packetWrapperCreatePacket = createPacket(v);
            packetWrapperCreatePacket.write(Type.VAR_INT, 5);
            sendPacket(packetWrapperCreatePacket);
        }
    }

    public ViaFacet(@NotNull Class<? extends V> cls, @NotNull Function<V, UserConnection> function, int i) {
        super(cls);
        this.connectionFunction = function;
        this.minProtocol = i;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isSupported() {
        return super.isSupported() && SUPPORTED && this.connectionFunction != null && this.minProtocol >= 0;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isApplicable(@NotNull V v) {
        return super.isApplicable(v) && this.minProtocol > Via.getAPI().getServerVersion().lowestSupportedVersion() && findProtocol(v) >= this.minProtocol;
    }

    @Nullable
    public UserConnection findConnection(@NotNull V v) {
        return this.connectionFunction.apply(v);
    }

    public int findProtocol(@NotNull V v) {
        UserConnection userConnectionFindConnection = findConnection(v);
        if (userConnectionFindConnection != null) {
            return userConnectionFindConnection.getProtocolInfo().getProtocolVersion();
        }
        return -1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
    @NotNull
    public String createMessage(@NotNull V v, @NotNull Component component) {
        return findProtocol(v) >= 713 ? GsonComponentSerializer.gson().serialize(component) : GsonComponentSerializer.colorDownsamplingGson().serialize(component);
    }

    static {
        boolean z = false;
        try {
            Class.forName("com.viaversion.viaversion.api.ViaAPI").getDeclaredMethod("majorVersion", new Class[0]);
            z = Via.getAPI().majorVersion() == 4;
        } catch (Throwable th) {
        }
        SUPPORTED = z && Knob.isEnabled("viaversion", true);
    }
}
