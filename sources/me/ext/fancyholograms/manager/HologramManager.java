package me.ext.fancyholograms.manager;

import de.oliver.fancyholograms.api.FancyHologramsPlugin;
import de.oliver.fancyholograms.api.data.TextHologramData;
import de.oliver.fancyholograms.api.hologram.Hologram;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import me.ext.fancyholograms.data.OptimalHologram;
import me.ext.fancyholograms.interfaces.HologramAPI;
import me.ext.fancyholograms.interfaces.ItemLine;
import me.ext.fancyholograms.interfaces.Line;
import me.ext.fancyholograms.interfaces.TextLine;
import me.ext.fancyholograms.interfaces.VisibilityManager;
import me.ulrich.clans.Clans;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Fancyholograms.jar:me/ext/fancyholograms/manager/HologramManager.class */
public final class HologramManager implements HologramAPI {
    private Optional<Hologram> getHologram(me.ext.fancyholograms.interfaces.Hologram hologram) {
        Object hologramObject = hologram.getHologramAsObject();
        if (hologramObject instanceof Hologram) {
            return Optional.of((Hologram) hologramObject);
        }
        return Optional.empty();
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public boolean removeIfPreset(Clans plugin, String id) {
        de.oliver.fancyholograms.api.HologramManager manager = FancyHologramsPlugin.get().getHologramManager();
        Hologram hologram = (Hologram) manager.getHologram(id).orElse(null);
        if (hologram != null) {
            Bukkit.getOnlinePlayers().iterator().forEachRemaining(player -> {
                hologram.forceHideHologram(player);
            });
            hologram.deleteHologram();
            FancyHologramsPlugin.get().getHologramManager().removeHologram(hologram);
            return true;
        }
        return false;
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public me.ext.fancyholograms.interfaces.Hologram createHologram(Clans plugin, Location location, String id, List<String> lines, Object extra) {
        de.oliver.fancyholograms.api.HologramManager manager = FancyHologramsPlugin.get().getHologramManager();
        Optional<Hologram> hologram = manager.getHologram(id);
        if (hologram.isPresent()) {
            TextHologramData data = hologram.get().getData();
            if (data instanceof TextHologramData) {
                TextHologramData textData = data;
                textData.setText(lines);
                hologram.get().forceUpdate();
                hologram.get().refreshHologram(Bukkit.getOnlinePlayers());
            }
        } else {
            TextHologramData hologramData = new TextHologramData(id, location);
            hologramData.setPersistent(false);
            hologramData.setText(lines);
            Hologram hologramC = manager.create(hologramData);
            manager.addHologram(hologramC);
        }
        return new OptimalHologram(this, hologram, location, id, extra);
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void teleport(me.ext.fancyholograms.interfaces.Hologram hologram, Location location) {
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void delete(me.ext.fancyholograms.interfaces.Hologram hologram) {
        removeIfPreset(null, hologram.getId());
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void showTo(VisibilityManager visibilityManager, Player player) {
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void hideTo(VisibilityManager visibilityManager, Player player) {
        Optional<Hologram> hologramOptional = getHologram(visibilityManager.getHologram());
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram fancyHologram = hologramOptional.get();
        fancyHologram.hideHologram(Bukkit.getOnlinePlayers());
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void setLine(me.ext.fancyholograms.interfaces.Hologram hologram, int lineIndex, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram fancyHologram = hologramOptional.get();
        if (!(line instanceof ItemLine) && (line instanceof TextLine)) {
            TextHologramData data = fancyHologram.getData();
            if (data instanceof TextHologramData) {
                TextHologramData textData = data;
                List<String> texts = new ArrayList<>();
                if (textData.getText().size() > 0) {
                    texts.addAll(textData.getText());
                    if (texts.get(lineIndex) != null) {
                        texts.set(lineIndex, ((TextLine) line).getText());
                    }
                } else {
                    texts.add(((TextLine) line).getText());
                }
                textData.setText(texts);
                fancyHologram.forceUpdate();
                fancyHologram.refreshHologram(Bukkit.getOnlinePlayers());
            }
        }
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void updateLine(me.ext.fancyholograms.interfaces.Hologram hologram, int lineIndex, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram fancyHologram = hologramOptional.get();
        if (!(line instanceof ItemLine) && (line instanceof TextLine)) {
            TextHologramData data = fancyHologram.getData();
            if (data instanceof TextHologramData) {
                TextHologramData textData = data;
                List<String> texts = new ArrayList<>();
                if (textData.getText().size() > 0) {
                    texts.addAll(textData.getText());
                    if (texts.get(lineIndex) != null) {
                        texts.set(lineIndex, ((TextLine) line).getText());
                    }
                } else {
                    texts.add(((TextLine) line).getText());
                }
                textData.setText(texts);
                fancyHologram.forceUpdate();
                fancyHologram.refreshHologram(Bukkit.getOnlinePlayers());
            }
        }
    }

    @Override // me.ext.fancyholograms.interfaces.HologramAPI
    public void appendLine(me.ext.fancyholograms.interfaces.Hologram hologram, Line line) {
        Optional<Hologram> hologramOptional = getHologram(hologram);
        if (!hologramOptional.isPresent()) {
            return;
        }
        Hologram fancyHologram = hologramOptional.get();
        if (!(line instanceof ItemLine) && (line instanceof TextLine)) {
            TextHologramData data = fancyHologram.getData();
            if (data instanceof TextHologramData) {
                TextHologramData textData = data;
                List<String> texts = new ArrayList<>();
                texts.add(((TextLine) line).getText());
                textData.setText(texts);
                fancyHologram.forceUpdate();
                fancyHologram.refreshHologram(Bukkit.getOnlinePlayers());
            }
        }
    }
}
