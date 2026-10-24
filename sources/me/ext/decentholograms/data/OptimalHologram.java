package me.ext.decentholograms.data;

import java.util.ArrayList;
import java.util.List;
import me.ext.decentholograms.interfaces.Hologram;
import me.ext.decentholograms.interfaces.HologramAPI;
import me.ext.decentholograms.interfaces.ItemLine;
import me.ext.decentholograms.interfaces.Line;
import me.ext.decentholograms.interfaces.TextLine;
import me.ext.decentholograms.interfaces.VisibilityManager;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Decentholograms.jar:me/ext/decentholograms/data/OptimalHologram.class */
public final class OptimalHologram implements Hologram {
    private final HologramAPI connector;
    private final Object hologramObject;
    private Location location;
    private String id;
    private Object extra;
    private final VisibilityManager visibilityManager = new OptimalVisibilityManager(this);
    private final List<Line> lines = new ArrayList();

    public OptimalHologram(HologramAPI connector, Object hologramObject, Location location, String id, Object extra) {
        this.connector = connector;
        this.hologramObject = hologramObject;
        this.location = location;
        this.id = id;
        this.extra = extra;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public List<Line> getLines() {
        return this.lines;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public Line getLineAt(int index) {
        return this.lines.get(index);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public int getLineIndex(Line line) {
        return this.lines.indexOf(line);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public void setLineAt(int index, Line line) {
        this.lines.set(index, line);
        this.connector.setLine(this, index, line);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public void updateLine(int index, Line line) {
        this.connector.updateLine(this, index, line);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public void appendLine(Line line) {
        this.lines.add(line);
        this.connector.appendLine(this, line);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public ItemLine appendItemLine(ItemStack itemStack) {
        ItemLine itemLine = new OptimalItemLine(this, itemStack);
        appendLine(itemLine);
        return itemLine;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public TextLine appendTextLine(String text) {
        TextLine textLine = new OptimalTextLine(this, text);
        appendLine(textLine);
        return textLine;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public VisibilityManager getVisibilityManager() {
        return this.visibilityManager;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public Location getLocation() {
        return this.location;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public void teleport(Location location) {
        this.location = location;
        this.connector.teleport(this, location);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public void delete() {
        this.connector.delete(this);
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public int size() {
        return this.lines.size();
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public Object getHologramAsObject() {
        return this.hologramObject;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public String getId() {
        return this.id;
    }

    @Override // me.ext.decentholograms.interfaces.Hologram
    public Object getExtra() {
        return this.extra;
    }
}
