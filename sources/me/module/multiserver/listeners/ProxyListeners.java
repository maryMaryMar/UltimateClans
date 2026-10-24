package me.module.multiserver.listeners;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Consumer;
import me.module.multiserver.Multiserver;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/listeners/ProxyListeners.class */
public class ProxyListeners implements PluginMessageListener {
    public ProxyListeners(Consumer<String> consumer) {
    }

    public void onPluginMessageReceived(String str, Player player, byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            if (dataInputStream.readUTF().equals("BungeePlayers")) {
                Multiserver.a().getPlayerAPI().solveProxiedPlayers(dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
