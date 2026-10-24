package me.ext.cmiholograms.manager;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Modules.Holograms.CMIHologram;
import java.util.Optional;
import me.ext.cmiholograms.data.OptimalHologram;
import me.ext.cmiholograms.interfaces.Hologram;
import me.ext.cmiholograms.interfaces.HologramAPI;
import me.ext.cmiholograms.interfaces.ItemLine;
import me.ext.cmiholograms.interfaces.Line;
import me.ext.cmiholograms.interfaces.TextLine;
import me.ext.cmiholograms.interfaces.VisibilityManager;
import me.ulrich.clans.Clans;
import net.Zrips.CMILib.Container.CMILocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Cmiholograms.jar:me/ext/cmiholograms/manager/HologramManager.class */
public final class HologramManager implements HologramAPI {
    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public boolean removeIfPreset(Clans plugin, String id) {
        CMIHologram hologram;
        if (id != null && (hologram = CMI.getInstance().getHologramManager().getByName(id)) != null) {
            hologram.remove();
            return false;
        }
        return false;
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public Hologram createHologram(Clans plugin, Location location, String id, Object extra) {
        return new OptimalHologram(this, new CMIHologram(id, new CMILocation(location)), location, id, extra);
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void setLine(Hologram hologram, int lineIndex, Line line) {
        Optional<CMIHologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        CMIHologram cmiHologram = hologramOptional.get();
        if (!(line instanceof ItemLine) && (line instanceof TextLine)) {
            cmiHologram.setLine(lineIndex, ((TextLine) line).getText());
            cmiHologram.update();
        }
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void updateLine(Hologram hologram, int lineIndex, Line line) {
        Optional<CMIHologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        CMIHologram cmiHologram = hologramOptional.get();
        if (!(line instanceof ItemLine) && (line instanceof TextLine)) {
            String text = ((TextLine) line).getText();
            cmiHologram.setLine(lineIndex, text);
            CMI.getInstance().getHologramManager().addHologram(cmiHologram);
            cmiHologram.update();
        }
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void appendLine(Hologram hologram, Line line) {
        Optional<CMIHologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        CMIHologram cmiHologram = hologramOptional.get();
        if (!(line instanceof ItemLine) && (line instanceof TextLine)) {
            String text = ((TextLine) line).getText();
            cmiHologram.addLine(text);
            CMI.getInstance().getHologramManager().addHologram(cmiHologram);
            cmiHologram.update();
        }
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void teleport(Hologram hologram, Location location) {
        Optional<CMIHologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        CMIHologram cmiHologram = hologramOptional.get();
        cmiHologram.setLoc(location);
        CMI.getInstance().getHologramManager().addHologram(cmiHologram);
        cmiHologram.update();
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void delete(Hologram hologram) {
        Optional<CMIHologram> hologramOptional = getHologram(hologram);
        hologramOptional.ifPresent((v0) -> {
            v0.remove();
        });
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void showTo(VisibilityManager visibilityManager, Player player) {
        throw new UnsupportedOperationException("CMI does not support per-player holograms!");
    }

    @Override // me.ext.cmiholograms.interfaces.HologramAPI
    public void hideTo(VisibilityManager visibilityManager, Player player) {
        Optional<CMIHologram> hologramOptional = getHologram(visibilityManager.getHologram());
        if (!hologramOptional.isPresent()) {
            return;
        }
        CMIHologram cmiHologram = hologramOptional.get();
        cmiHologram.hide(player.getUniqueId());
    }

    private Optional<CMIHologram> getHologram(Hologram hologram) {
        Object hologramObject = hologram.getHologramAsObject();
        if (hologramObject instanceof CMIHologram) {
            return Optional.of((CMIHologram) hologramObject);
        }
        return Optional.empty();
    }
}
