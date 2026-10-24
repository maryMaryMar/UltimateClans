package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.connection.UserConnection;
import io.netty.channel.Channel;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.Iterator;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.ViaConnectionGuard;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsPacketSender.class */
public final class NmsPacketSender {
    private static final MethodHandle GET_HANDLE;
    private static final MethodHandle PLAYER_CONNECTION;
    private static final MethodHandle SEND_PACKET;
    private final ViaAPI<Player> via;
    static final /* synthetic */ boolean $assertionsDisabled;

    public NmsPacketSender(ViaAPI<Player> viaAPI) {
        this.via = viaAPI;
    }

    public void sendPacket(Player player, Object obj) {
        UserConnection connection;
        if (this.via != null && (connection = this.via.getConnection(player.getUniqueId())) != null) {
            Channel channel = connection.getChannel();
            if (ViaConnectionGuard.isCurrentPlayConnection(this.via, player, connection)) {
                if (!$assertionsDisabled && channel == null) {
                    throw new AssertionError();
                }
                channel.eventLoop().execute(() -> {
                    if (ViaConnectionGuard.isCurrentPlayConnection(this.via, player, connection)) {
                        channel.writeAndFlush(obj);
                    }
                });
                return;
            }
        }
        try {
            SEND_PACKET.invoke((Object) PLAYER_CONNECTION.invoke((Object) GET_HANDLE.invoke(player)), obj);
        } catch (Throwable th) {
            throw new IllegalStateException("couldn't send packet to player", th);
        }
    }

    public void sendPacket(Iterable<Player> iterable, Object obj) {
        Iterator<Player> it = iterable.iterator();
        while (it.hasNext()) {
            sendPacket(it.next(), obj);
        }
    }

    static {
        $assertionsDisabled = !NmsPacketSender.class.desiredAssertionStatus();
        MethodHandles.Lookup lookupPublicLookup = MethodHandles.publicLookup();
        try {
            GET_HANDLE = lookupPublicLookup.findVirtual(NmsClasses.CRAFT_PLAYER_CLASS, "getHandle", MethodType.methodType(NmsClasses.SERVER_PLAYER_CLASS));
            MethodHandle methodHandleUnreflectGetter = null;
            for (Field field : NmsClasses.SERVER_PLAYER_CLASS.getFields()) {
                if (field.getType() == NmsClasses.PLAYER_CONNECTION_CLASS) {
                    try {
                        methodHandleUnreflectGetter = lookupPublicLookup.unreflectGetter(field);
                    } catch (IllegalAccessException e) {
                        throw new ExceptionInInitializerError(e);
                    }
                }
            }
            if (methodHandleUnreflectGetter == null) {
                throw new ExceptionInInitializerError("failed to find player connection field");
            }
            PLAYER_CONNECTION = methodHandleUnreflectGetter;
            MethodType methodType = MethodType.methodType((Class<?>) Void.TYPE, NmsClasses.PKT_CLASS);
            MethodHandle methodHandleFindVirtual = null;
            for (String str : new String[]{"a", "sendPacket", "b", "send"}) {
                try {
                    methodHandleFindVirtual = lookupPublicLookup.findVirtual(NmsClasses.PLAYER_CONNECTION_CLASS, str, methodType);
                } catch (IllegalAccessException e2) {
                    throw new ExceptionInInitializerError(e2);
                } catch (NoSuchMethodException e3) {
                }
            }
            if (methodHandleFindVirtual == null) {
                throw new ExceptionInInitializerError(new RuntimeException("Couldn't find send packet method"));
            }
            SEND_PACKET = methodHandleFindVirtual;
        } catch (IllegalAccessException | NoSuchMethodException e4) {
            throw new ExceptionInInitializerError(e4);
        }
    }
}
