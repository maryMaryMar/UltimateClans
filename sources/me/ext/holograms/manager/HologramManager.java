package me.ext.holograms.manager;

import com.sainttx.holograms.HologramPlugin;
import com.sainttx.holograms.api.Hologram;
import java.util.Optional;
import me.ext.holograms.data.OptimalHologram;
import me.ext.holograms.interfaces.HologramAPI;
import me.ext.holograms.interfaces.ItemLine;
import me.ext.holograms.interfaces.Line;
import me.ext.holograms.interfaces.TextLine;
import me.ext.holograms.interfaces.VisibilityManager;
import me.ulrich.clans.Clans;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holograms.jar:me/ext/holograms/manager/HologramManager.class */
public final class HologramManager implements HologramAPI {
    @Override // me.ext.holograms.interfaces.HologramAPI
    public boolean removeIfPreset(Clans plugin, String id) {
        com.sainttx.holograms.api.HologramManager hologramManager;
        Hologram hologram;
        if (id != null && (hologram = (hologramManager = JavaPlugin.getPlugin(HologramPlugin.class).getHologramManager()).getHologram(id)) != null) {
            hologramManager.deleteHologram(hologram);
            return false;
        }
        return false;
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public me.ext.holograms.interfaces.Hologram createHologram(Clans plugin, Location location, String id, Object extra) {
        return new OptimalHologram(this, new Hologram(id, location, false), location, id, extra);
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void setLine(me.ext.holograms.interfaces.Hologram hologram, int lineIndex, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram saintHologram = hologramOptional.get();
        saintHologram.removeLine(saintHologram.getLine(lineIndex));
        if (line instanceof ItemLine) {
            saintHologram.addLine(new com.sainttx.holograms.api.line.ItemLine(saintHologram, ((ItemLine) line).getItemStack()), lineIndex);
        } else if (line instanceof TextLine) {
            saintHologram.addLine(new com.sainttx.holograms.api.line.TextLine(saintHologram, ((TextLine) line).getText()), lineIndex);
        }
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void updateLine(me.ext.holograms.interfaces.Hologram hologram, int lineIndex, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram saintHologram = hologramOptional.get();
        com.sainttx.holograms.api.line.ItemLine line2 = saintHologram.getLine(lineIndex);
        if ((line instanceof ItemLine) && (line2 instanceof ItemLine)) {
            ItemStack itemStack = ((ItemLine) line).getItemStack();
            line2.setItem(itemStack);
        } else if ((line instanceof TextLine) && (line2 instanceof com.sainttx.holograms.api.line.TextLine)) {
            String text = ((TextLine) line).getText();
            ((com.sainttx.holograms.api.line.TextLine) line2).setText(text);
        }
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void appendLine(me.ext.holograms.interfaces.Hologram hologram, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram saintHologram = hologramOptional.get();
        if (line instanceof ItemLine) {
            saintHologram.addLine(new com.sainttx.holograms.api.line.ItemLine(saintHologram, ((ItemLine) line).getItemStack()));
        } else if (line instanceof TextLine) {
            saintHologram.addLine(new com.sainttx.holograms.api.line.TextLine(saintHologram, ((TextLine) line).getText()));
        }
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void teleport(me.ext.holograms.interfaces.Hologram hologram, Location location) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram saintHologram = hologramOptional.get();
        saintHologram.teleport(location);
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void delete(me.ext.holograms.interfaces.Hologram hologram) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        hologramOptional.ifPresent((v0) -> {
            v0.despawn();
        });
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void showTo(VisibilityManager visibilityManager, Player player) {
        throw new UnsupportedOperationException("Holograms does not support per-player holograms!");
    }

    @Override // me.ext.holograms.interfaces.HologramAPI
    public void hideTo(VisibilityManager visibilityManager, Player player) {
        throw new UnsupportedOperationException("Holograms does not support per-player holograms!");
    }

    private Optional<Hologram> getHologram(me.ext.holograms.interfaces.Hologram hologram) {
        Object hologramObject = hologram.getHologramAsObject();
        if (hologramObject instanceof Hologram) {
            return Optional.of((Hologram) hologramObject);
        }
        return Optional.empty();
    }
}
