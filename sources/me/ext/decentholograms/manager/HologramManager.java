package me.ext.decentholograms.manager;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import java.util.Optional;
import me.ext.decentholograms.data.OptimalHologram;
import me.ext.decentholograms.interfaces.HologramAPI;
import me.ext.decentholograms.interfaces.Line;
import me.ext.decentholograms.interfaces.TextLine;
import me.ext.decentholograms.interfaces.VisibilityManager;
import me.ulrich.clans.Clans;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Decentholograms.jar:me/ext/decentholograms/manager/HologramManager.class */
public final class HologramManager implements HologramAPI {
    private Optional<Hologram> getHologram(me.ext.decentholograms.interfaces.Hologram hologram) {
        Object hologramObject = hologram.getHologramAsObject();
        if (hologramObject instanceof Hologram) {
            return Optional.of((Hologram) hologramObject);
        }
        return Optional.empty();
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public boolean removeIfPreset(Clans plugin, String id) {
        Hologram hologram;
        if (id != null && (hologram = DHAPI.getHologram(id.replace("|", "").replace("-", "").replace("_", "").replace(".", ""))) != null) {
            DHAPI.removeHologram(hologram.getName());
            return false;
        }
        return false;
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public me.ext.decentholograms.interfaces.Hologram createHologram(Clans plugin, Location location, String id, Object extra) {
        String id2 = id.replace("|", "").replace("-", "").replace("_", "").replace(".", "");
        removeIfPreset(plugin, id2);
        Hologram holo = DHAPI.createHologram(id2, location, false);
        return new OptimalHologram(this, holo, location, id2, extra);
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void setLine(me.ext.decentholograms.interfaces.Hologram hologram, int lineIndex, Line line) {
        if (!(line instanceof TextLine)) {
            return;
        }
        Optional<Hologram> hologramOptimal = getHologram(hologram);
        if (!hologramOptimal.isPresent()) {
            return;
        }
        Hologram decentHologram = hologramOptimal.get();
        DHAPI.setHologramLine(decentHologram, lineIndex, ((TextLine) line).getText());
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void updateLine(me.ext.decentholograms.interfaces.Hologram hologram, int lineIndex, Line line) {
        if (!(line instanceof TextLine)) {
            return;
        }
        Optional<Hologram> hologramOptimal = getHologram(hologram);
        if (!hologramOptimal.isPresent()) {
            return;
        }
        Hologram decentHologram = hologramOptimal.get();
        DHAPI.setHologramLine(decentHologram, lineIndex, ((TextLine) line).getText());
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void appendLine(me.ext.decentholograms.interfaces.Hologram hologram, Line line) {
        if (!(line instanceof TextLine)) {
            return;
        }
        Optional<Hologram> hologramOptimal = getHologram(hologram);
        if (!hologramOptimal.isPresent()) {
            return;
        }
        Hologram decentHologram = hologramOptimal.get();
        DHAPI.addHologramLine(decentHologram, ((TextLine) line).getText());
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void teleport(me.ext.decentholograms.interfaces.Hologram hologram, Location location) {
        Optional<Hologram> hologramOptimal = getHologram(hologram);
        if (!hologramOptimal.isPresent()) {
            return;
        }
        Hologram decentHologram = hologramOptimal.get();
        DHAPI.moveHologram(decentHologram, location);
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void delete(me.ext.decentholograms.interfaces.Hologram hologram) {
        removeIfPreset(null, hologram.getId());
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void showTo(VisibilityManager visibilityManager, Player player) {
        Optional<Hologram> hologramOptimal = getHologram(visibilityManager.getHologram());
        if (!hologramOptimal.isPresent()) {
            return;
        }
        Hologram decentHologram = hologramOptimal.get();
        decentHologram.show(player, 0);
    }

    @Override // me.ext.decentholograms.interfaces.HologramAPI
    public void hideTo(VisibilityManager visibilityManager, Player player) {
        Optional<Hologram> hologramOptimal = getHologram(visibilityManager.getHologram());
        if (!hologramOptimal.isPresent()) {
            return;
        }
        Hologram decentHologram = hologramOptimal.get();
        decentHologram.hide(player);
    }
}
