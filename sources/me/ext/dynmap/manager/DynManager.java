package me.ext.dynmap.manager;

import me.ext.dynmap.Dynmap;
import me.ulrich.clans.data.MapData;
import me.ulrich.clans.manager.utils.Cuboid;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.dynmap.Color;
import org.dynmap.DynmapAPI;
import org.dynmap.markers.AreaMarker;
import org.dynmap.markers.MarkerSet;
import org.java_websocket.framing.CloseFrame;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Dynmap.jar:me/ext/dynmap/manager/DynManager.class */
public class DynManager {
    private String set = Dynmap.getExtensionCore().getName();

    public boolean dynmapSend(String markId, Player sender, MapData data) {
        try {
            try {
                deleteZoneMarker(markId);
            } catch (Exception e) {
            }
            DynmapAPI dynmap = Dynmap.getExtensionCore().getDapi();
            if (dynmap.getMarkerAPI().getMarkerSet(getSet()) != null) {
                dynmap.getMarkerAPI().getMarkerSet(getSet());
            } else {
                dynmap.getMarkerAPI().createMarkerSet(getSet(), getSet(), dynmap.getMarkerAPI().getMarkerIcons(), false);
            }
            Cuboid cub = new Cuboid(data.getLoc1(), data.getLoc2());
            if (cub != null) {
                double[] d1 = {cub.getLowerX(), cub.getUpperX()};
                double[] d2 = {cub.getLowerZ(), cub.getUpperZ()};
                return createZoneMarker(markId, d1, d2, data.getLoc1().getWorld(), data);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean createZoneMarker(String markId, double[] d1, double[] d2, World world, MapData data) {
        try {
            DynmapAPI api = Dynmap.getExtensionCore().getDapi();
            MarkerSet mk = api.getMarkerAPI().getMarkerSet(getSet());
            mk.createAreaMarker(markId, markId, true, world.getName(), new double[CloseFrame.NORMAL], new double[CloseFrame.NORMAL], true);
            AreaMarker area = mk.findAreaMarker(markId);
            area.setCornerLocations(d1, d2);
            area.setLabel(data.getMarkName());
            Color torgb = hex2Rgb(data.getBorderColor());
            area.setLineStyle(data.getBorderSize(), data.getBorderOpacity(), new Color(torgb.getRed(), torgb.getGreen(), torgb.getBlue()).getAlpha());
            Color torgb2 = hex2Rgb(data.getFillColor());
            area.setFillStyle(data.getFillOpacity(), new Color(torgb2.getRed(), torgb2.getGreen(), torgb2.getBlue()).getAlpha());
            area.setRangeY(Math.abs(d1[0] - d1[1]), Math.abs(d2[0] - d2[1]));
            area.setDescription(data.getFinalDescription());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Color hex2Rgb(String colorStr) {
        return new Color(Integer.valueOf(colorStr.substring(1, 3), 16).intValue(), Integer.valueOf(colorStr.substring(3, 5), 16).intValue(), Integer.valueOf(colorStr.substring(5, 7), 16).intValue());
    }

    public boolean deleteZoneMarker(String markID) {
        try {
            DynmapAPI api = Dynmap.getExtensionCore().getDapi();
            int cleared = 0;
            MarkerSet markset = api.getMarkerAPI().getMarkerSet(getSet());
            if (markset != null) {
                AreaMarker am = markset.findAreaMarker(markID);
                if (am != null) {
                    api.getMarkerAPI().getMarkerSet(getSet()).findAreaMarker(markID).deleteMarker();
                    cleared = 0 + 1;
                }
                if (cleared > 0) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String getSet() {
        return this.set;
    }
}
