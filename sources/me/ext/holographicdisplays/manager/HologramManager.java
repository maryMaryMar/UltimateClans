package me.ext.holographicdisplays.manager;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import java.util.Collection;
import java.util.Optional;
import me.ext.holographicdisplays.data.OptimalHologram;
import me.ext.holographicdisplays.interfaces.HologramAPI;
import me.ext.holographicdisplays.interfaces.ItemLine;
import me.ext.holographicdisplays.interfaces.Line;
import me.ext.holographicdisplays.interfaces.TextLine;
import me.ext.holographicdisplays.interfaces.VisibilityManager;
import me.ulrich.clans.Clans;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holographicdisplays.jar:me/ext/holographicdisplays/manager/HologramManager.class */
public final class HologramManager implements HologramAPI {
    public String encodeLocation(Location loc) {
        try {
            String world = loc.getWorld().getName();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            float pitch = loc.getPitch();
            float yaw = loc.getYaw();
            String located = world + "|" + x + "|" + y + "|" + z + "|" + pitch + "|" + yaw;
            return located.replace(".", "_");
        } catch (Exception e) {
            return null;
        }
    }

    public Location decodeLocation(String located) {
        try {
            String[] splited = located.replace("_", ".").split("\\|");
            World world = Bukkit.getWorld(splited[0].replace(".", "_"));
            double x = Double.valueOf(splited[1]).doubleValue();
            double y = Double.valueOf(splited[2]).doubleValue();
            double z = Double.valueOf(splited[3]).doubleValue();
            float pitch = Float.valueOf(splited[4]).floatValue();
            float yaw = Float.valueOf(splited[5]).floatValue();
            Location loc = new Location(world, x, y, z, yaw, pitch);
            if (loc != null) {
                return loc;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public boolean removeIfPreset(Clans plugin, String id) {
        Location loc;
        if (id != null && (loc = decodeLocation(id)) != null) {
            Collection<Hologram> api = HologramsAPI.getHolograms(plugin);
            for (Hologram holo : api) {
                if (holo.getLocation().equals(loc)) {
                    holo.delete();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public me.ext.holographicdisplays.interfaces.Hologram createHologram(Clans plugin, Location location, String id, Object extra) {
        return new OptimalHologram(this, HologramsAPI.createHologram(plugin, location), location, id, extra);
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void setLine(me.ext.holographicdisplays.interfaces.Hologram hologram, int lineIndex, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram displaysHologram = hologramOptional.get();
        displaysHologram.removeLine(lineIndex);
        if (line instanceof ItemLine) {
            displaysHologram.insertItemLine(lineIndex, ((ItemLine) line).getItemStack());
        } else if (line instanceof TextLine) {
            displaysHologram.insertTextLine(lineIndex, ((TextLine) line).getText());
        }
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void updateLine(me.ext.holographicdisplays.interfaces.Hologram hologram, int lineIndex, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram displaysHologram = hologramOptional.get();
        com.gmail.filoghost.holographicdisplays.api.line.ItemLine line2 = displaysHologram.getLine(lineIndex);
        if ((line instanceof ItemLine) && (line2 instanceof com.gmail.filoghost.holographicdisplays.api.line.ItemLine)) {
            ItemStack itemStack = ((ItemLine) line).getItemStack();
            line2.setItemStack(itemStack);
        } else if ((line instanceof TextLine) && (line2 instanceof com.gmail.filoghost.holographicdisplays.api.line.TextLine)) {
            String text = ((TextLine) line).getText();
            ((com.gmail.filoghost.holographicdisplays.api.line.TextLine) line2).setText(text);
        }
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void appendLine(me.ext.holographicdisplays.interfaces.Hologram hologram, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram displaysHologram = hologramOptional.get();
        if (line instanceof ItemLine) {
            ItemStack itemStack = ((ItemLine) line).getItemStack();
            displaysHologram.appendItemLine(itemStack);
        } else if (line instanceof TextLine) {
            String text = ((TextLine) line).getText();
            displaysHologram.appendTextLine(text);
        }
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void teleport(me.ext.holographicdisplays.interfaces.Hologram hologram, Location location) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram displaysHologram = hologramOptional.get();
        displaysHologram.teleport(location);
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void delete(me.ext.holographicdisplays.interfaces.Hologram hologram) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        hologramOptional.ifPresent((v0) -> {
            v0.delete();
        });
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void showTo(VisibilityManager visibilityManager, Player player) {
        Optional<Hologram> hologramOptional = getHologram(visibilityManager.getHologram());
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram displaysHologram = hologramOptional.get();
        com.gmail.filoghost.holographicdisplays.api.VisibilityManager hologramVisibilityManager = displaysHologram.getVisibilityManager();
        hologramVisibilityManager.showTo(player);
    }

    @Override // me.ext.holographicdisplays.interfaces.HologramAPI
    public void hideTo(VisibilityManager visibilityManager, Player player) {
        Optional<Hologram> hologramOptional = getHologram(visibilityManager.getHologram());
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram displaysHologram = hologramOptional.get();
        com.gmail.filoghost.holographicdisplays.api.VisibilityManager hologramVisibilityManager = displaysHologram.getVisibilityManager();
        hologramVisibilityManager.hideTo(player);
    }

    private Optional<Hologram> getHologram(me.ext.holographicdisplays.interfaces.Hologram hologram) {
        Object hologramObject = hologram.getHologramAsObject();
        if (hologramObject instanceof Hologram) {
            return Optional.of((Hologram) hologramObject);
        }
        return Optional.empty();
    }
}
