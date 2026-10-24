package me.ext.holograms.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import me.ext.holograms.Holograms;
import me.ext.holograms.interfaces.Hologram;
import me.ulrich.clans.data.HoloData;
import me.ulrich.clans.interfaces.HologramImplement;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holograms.jar:me/ext/holograms/manager/Implementation.class */
public class Implementation implements HologramImplement {
    private HashMap<String, HoloData> holograms = new HashMap<>();

    public void deleteAll() {
        getHolograms().entrySet().iterator().forEachRemaining(holo -> {
            deleteHolo(((HoloData) holo.getValue()).getId());
        });
    }

    public void retreaveConsumer(Consumer<HoloData> callback, Long time, String id, Location loc, List<String> lines, Object... objects) {
        Holograms.getExtensionCore().getScheduler().runTaskLater(() -> {
            Hologram holo = new HologramManager().createHologram(Holograms.getClanCore(), loc, id, objects);
            lines.iterator().forEachRemaining(line -> {
                holo.appendTextLine(line);
            });
            holo.getVisibilityManager().setVisibleByDefault(true);
            HoloData data = new HoloData(id, loc, holo, lines, objects);
            callback.accept(data);
        }, time.longValue());
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public void createHologramTimed(Long time, String id, Location loc, List<String> lines, Object... objects) {
        deleteHolo(id);
        retreaveConsumer(call -> {
            getHolograms().put(id, call);
            Holograms.getExtensionCore().getScheduler().runTaskLater(() -> {
                deleteHolo((Hologram) call.getHologram());
                deleteHolo(call.getId());
            }, time.longValue());
        }, 1L, id, loc, lines, objects);
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public boolean hasHologram(String id) {
        try {
            if (getHolograms().containsKey(id)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public Optional<HoloData> createHologram(String id, Location loc, List<String> lines, Object... objects) {
        if (hasHologram(id) && !deleteHolo(id)) {
            return Optional.empty();
        }
        try {
            Hologram holo = new HologramManager().createHologram(Holograms.getClanCore(), loc, id, objects);
            lines.iterator().forEachRemaining(line -> {
                holo.appendTextLine(line);
            });
            holo.getVisibilityManager().setVisibleByDefault(true);
            HoloData data = new HoloData(id, loc, holo, lines, objects);
            getHolograms().put(id, data);
            return Optional.of(data);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public boolean deleteHolo(Hologram hologram) {
        if (hologram != null) {
            hologram.delete();
            return false;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public boolean deleteHolo(String id) {
        try {
            if (hasHologram(id)) {
                boolean deleted = new HologramManager().removeIfPreset(Holograms.getClanCore(), id);
                if (deleted) {
                    getHolograms().remove(id);
                    return true;
                }
                try {
                    if (getHolograms().containsKey(id)) {
                        HoloData holo = getHolograms().get(id);
                        Hologram holog = (Hologram) holo.getHologram();
                        holog.delete();
                        return true;
                    }
                } catch (Exception e) {
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public Optional<HoloData> getHologram(String id) {
        if (hasHologram(id)) {
            return Optional.of(getHolograms().get(id));
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public Optional<HoloData> updateHologram(String id, List<String> lines, Object... objects) {
        if (hasHologram(id)) {
            HoloData holo = getHolograms().get(id);
            Optional<HoloData> newholo = createHologram(id, holo.getLoc(), lines, objects);
            return newholo;
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(Holograms.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.HologramImplement
    public Optional<String> getPluginName() {
        return Optional.of(Holograms.getExtensionCore().getPluginImp().getDescription().getName());
    }

    public HashMap<String, HoloData> getHolograms() {
        return this.holograms;
    }
}
