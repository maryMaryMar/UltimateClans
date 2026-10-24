package me.ext.decentholograms.interfaces;

import java.util.Collection;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Decentholograms.jar:me/ext/decentholograms/interfaces/Hologram.class */
public interface Hologram {
    Collection<Line> getLines();

    Line getLineAt(int i);

    int getLineIndex(Line line);

    void setLineAt(int i, Line line);

    void updateLine(int i, Line line);

    void appendLine(Line line);

    ItemLine appendItemLine(ItemStack itemStack);

    TextLine appendTextLine(String str);

    VisibilityManager getVisibilityManager();

    Location getLocation();

    void teleport(Location location);

    void delete();

    int size();

    Object getHologramAsObject();

    String getId();

    Object getExtra();
}
