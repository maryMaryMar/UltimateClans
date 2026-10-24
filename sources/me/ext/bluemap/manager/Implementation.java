package me.ext.bluemap.manager;

import java.util.Optional;
import me.ext.bluemap.BlueMap;
import me.ulrich.clans.data.MapData;
import me.ulrich.clans.interfaces.MapImplement;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Bluemap.jar:me/ext/bluemap/manager/Implementation.class */
public final class Implementation implements MapImplement {
    @Override // me.ulrich.clans.interfaces.MapImplement
    public boolean removeMap(String markId) {
        return BlueMap.getExtensionCore().getBlueManager().deleteZoneMarker(markId);
    }

    @Override // me.ulrich.clans.interfaces.MapImplement
    public boolean createMap(String markId, Player sender, MapData data) {
        return BlueMap.getExtensionCore().getBlueManager().dynmapSend(markId, sender, data);
    }

    @Override // me.ulrich.clans.interfaces.MapImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(BlueMap.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.MapImplement
    public Optional<String> getPluginName() {
        return Optional.of(BlueMap.getExtensionCore().getPluginImp().getDescription().getName());
    }
}
