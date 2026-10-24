package me.ext.bluemap.manager;

import com.flowpowered.math.vector.Vector3d;
import de.bluecolored.bluemap.api.BlueMapAPI;
import de.bluecolored.bluemap.api.BlueMapMap;
import de.bluecolored.bluemap.api.markers.MarkerSet;
import de.bluecolored.bluemap.api.markers.ShapeMarker;
import de.bluecolored.bluemap.api.math.Color;
import de.bluecolored.bluemap.api.math.Shape;
import java.util.Optional;
import me.ulrich.clans.data.MapData;
import me.ulrich.clans.manager.utils.Cuboid;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Bluemap.jar:me/ext/bluemap/manager/BlueManager.class */
public class BlueManager {
    public boolean dynmapSend(String markId, Player sender, MapData data) {
        Optional<BlueMapAPI> optionalApi = BlueMapAPI.getInstance();
        MarkerSet markerSet = MarkerSet.builder().label(markId).build();
        try {
            Cuboid cub = new Cuboid(data.getLoc1(), data.getLoc2());
            if (cub != null) {
                Shape shape = Shape.createRect(cub.getUpperSW().getX(), cub.getUpperSW().getZ(), cub.getLowerNE().getX(), cub.getLowerNE().getZ());
                ShapeMarker shaped = ShapeMarker.builder().fillColor(new Color(data.getFillColor())).lineWidth(data.getBorderSize()).lineColor(new Color(data.getBorderColor())).shape(shape, cub.getCenter().getWorld().getHighestBlockAt(cub.getCenter()).getY() + 2).position(new Vector3d(cub.getCenter().getX(), cub.getCenter().getY(), cub.getCenter().getZ())).label(data.getMarkName()).detail(data.getFinalDescription()).build();
                markerSet.getMarkers().put(data.getMarkName(), shaped);
                optionalApi.get().getWorld(cub.getCenter().getWorld()).ifPresent(world -> {
                    for (BlueMapMap map : world.getMaps()) {
                        map.getMarkerSets().put(data.getMarkName(), markerSet);
                    }
                });
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteZoneMarker(String markID) {
        Optional<BlueMapAPI> optionalApi = BlueMapAPI.getInstance();
        optionalApi.get().getWorlds().iterator().forEachRemaining(wo -> {
            for (BlueMapMap map : wo.getMaps()) {
                map.getMarkerSets().keySet().removeIf(sets -> {
                    return sets.equals(markID);
                });
            }
        });
        return false;
    }
}
