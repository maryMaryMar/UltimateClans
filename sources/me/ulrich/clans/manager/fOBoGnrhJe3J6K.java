package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.interfaces.ScoreboardImplement;
import me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary;
import me.ulrich.clans.library.scoreboardlibrary.api.exception.NoPacketAdapterAvailableException;
import me.ulrich.clans.library.scoreboardlibrary.api.noop.NoopScoreboardLibrary;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.utils.CooldownAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/fOBoGnrhJe3J6K.class */
public class fOBoGnrhJe3J6K {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private ConcurrentHashMap<UUID, Sidebar> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private ScoreboardLibrary ZwrsrwOCXRUscW6Q;
    private static String WggpiT54dC7YbV;
    private static volatile String xfQ0VNEDuvSs3x;
    private static String OkRbkG1PdczAk3TSJk;
    private static volatile String eeGYh6CwPbU1aLzEAc6MNT;
    private static volatile String SfLGgMHOD8eswSC2yH0Zdc;
    private static String KGDtq9ANop63gjc;
    private static final byte[] kNoFdWrROn6LHedNe3B = {(byte) 0, (byte) 167, (byte) 135, (byte) 10, (byte) 78, (byte) 211, (byte) 82, (byte) 72, (byte) 179, (byte) 75, (byte) 197, (byte) 95, (byte) 141, (byte) 229, (byte) 128, (byte) 98, (byte) 243, (byte) 76, (byte) 19, (byte) 151, (byte) 106, (byte) 236, (byte) 197, (byte) 69, (byte) 43, (byte) 129, (byte) 128, (byte) 209, (byte) 103, (byte) 241, (byte) 176, (byte) 34};
    private static final byte[] FaTtE2Vnvz4CzJ4nLplnb3 = {(byte) 0, (byte) 167, (byte) 135, (byte) 10, (byte) 78, (byte) 211, (byte) 82, (byte) 72, (byte) 179, (byte) 75, (byte) 197, (byte) 95, (byte) 141, (byte) 229, (byte) 128, (byte) 98, (byte) 243, (byte) 76, (byte) 19, (byte) 151, (byte) 106, (byte) 236, (byte) 197, (byte) 69, (byte) 43, (byte) 129, (byte) 128, (byte) 209, (byte) 103, (byte) 241, (byte) 176, (byte) 34};
    private static final byte[] oKjEKy7JfeGx0gV9 = {(byte) 247, (byte) 185, (byte) 124, (byte) 81, (byte) 152, (byte) 59, (byte) 96, (byte) 147, (byte) 54, (byte) 91, (byte) 102, (byte) 20, (byte) 164, (byte) 159, (byte) 158, (byte) 123};
    private static final byte[] wUudAN0EnYgvxwJ1PH3K8 = {(byte) 194, (byte) 21, (byte) 166, (byte) 35, (byte) 249, (byte) 185, (byte) 53, (byte) 172, (byte) 214, (byte) 111, (byte) 89, (byte) 186, (byte) 108, (byte) 196, (byte) 204, (byte) 177, (byte) 55, (byte) 141, (byte) 23, (byte) 105, (byte) 107, (byte) 33, (byte) 171, (byte) 67, (byte) 160, (byte) 166, (byte) 186, (byte) 223, (byte) 206, (byte) 51, (byte) 134, (byte) 211};
    private static final byte[] WvKlLFl3FI0FRFoaI4 = {(byte) 167, (byte) 159, (byte) 64, (byte) 254, (byte) 86, (byte) 143, (byte) 200, (byte) 174, (byte) 234, (byte) 240, (byte) 91, (byte) 152, (byte) 98, (byte) 127, (byte) 65, (byte) 81};

    public fOBoGnrhJe3J6K(Clans clans) {
        this.ZwrsrwOCXRUscW6Q = null;
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        try {
            this.ZwrsrwOCXRUscW6Q = ScoreboardLibrary.loadScoreboardLibrary(clans);
        } catch (Exception e) {
            this.ZwrsrwOCXRUscW6Q = new NoopScoreboardLibrary();
        }
        if (this.ZwrsrwOCXRUscW6Q == null) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("The scoreboard system is disabled. (Configuration: " + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(EzT85461orE5O6()) + ")");
        }
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l() {
        return this.v8qP8fE86HMhvNuYPFjqY.isEnabled() && this.ZwrsrwOCXRUscW6Q != null && this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().Nz8xKv4RePC2a0f0iuYU().isPresent();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, String str, List<String> list) {
        if (CooldownAPI.isInCooldown(this.v8qP8fE86HMhvNuYPFjqY.getPluginUUID(), GMKcww2qS8F0YYKx7F()) || player == null) {
            return false;
        }
        if ((player != null && !player.isOnline()) || str == null || list.size() == 0) {
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(joURFGZEQdy0Bmv())) {
            Optional<ScoreboardImplement> optionalNz8xKv4RePC2a0f0iuYU = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().Nz8xKv4RePC2a0f0iuYU();
            if (optionalNz8xKv4RePC2a0f0iuYU.isPresent() && optionalNz8xKv4RePC2a0f0iuYU.isPresent()) {
                optionalNz8xKv4RePC2a0f0iuYU.get().hidePluginScoreboard(player);
            }
            jBUuLP0sWwaPyPOmogdX7l(player, str, list);
            return false;
        }
        if (this.ZwrsrwOCXRUscW6Q == null) {
            return false;
        }
        Optional<ScoreboardImplement> optionalNz8xKv4RePC2a0f0iuYU2 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().Nz8xKv4RePC2a0f0iuYU();
        if (optionalNz8xKv4RePC2a0f0iuYU2.isPresent() && optionalNz8xKv4RePC2a0f0iuYU2.isPresent()) {
            optionalNz8xKv4RePC2a0f0iuYU2.get().hidePluginScoreboard(player);
        }
        if (iZTqZaRK5UGoe0Z().containsKey(player.getUniqueId())) {
            iZTqZaRK5UGoe0Z().get(player.getUniqueId()).removePlayer(player);
        }
        Sidebar sidebarCreateSidebar = this.ZwrsrwOCXRUscW6Q.createSidebar(15, Locale.US);
        if (sidebarCreateSidebar == null || player == null) {
            return false;
        }
        sidebarCreateSidebar.title(this.v8qP8fE86HMhvNuYPFjqY.getColorManager().ZwrsrwOCXRUscW6Q(str));
        Iterator<String> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            sidebarCreateSidebar.line(i, this.v8qP8fE86HMhvNuYPFjqY.getColorManager().ZwrsrwOCXRUscW6Q(it.next()));
            i++;
        }
        sidebarCreateSidebar.addPlayer(player);
        iZTqZaRK5UGoe0Z().put(player.getUniqueId(), sidebarCreateSidebar);
        return true;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(Player player, String str, List<String> list) {
        try {
            me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1JBUuLP0sWwaPyPOmogdX7l = me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.jBUuLP0sWwaPyPOmogdX7l(player);
            if (me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.v8qP8fE86HMhvNuYPFjqY(player)) {
                ztcc5xsafoa1tc1JBUuLP0sWwaPyPOmogdX7l = me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId());
                ztcc5xsafoa1tc1JBUuLP0sWwaPyPOmogdX7l.v8qP8fE86HMhvNuYPFjqY(Arrays.asList(new String[0]));
            }
            ztcc5xsafoa1tc1JBUuLP0sWwaPyPOmogdX7l.v8qP8fE86HMhvNuYPFjqY(ChatColor.translateAlternateColorCodes('&', this.v8qP8fE86HMhvNuYPFjqY.getColorManager().iZTqZaRK5UGoe0Z(str)));
            Iterator<String> it = list.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                arrayList.add(ChatColor.translateAlternateColorCodes('&', this.v8qP8fE86HMhvNuYPFjqY.getColorManager().iZTqZaRK5UGoe0Z(it.next())));
            }
            if (arrayList.size() > 0) {
                ztcc5xsafoa1tc1JBUuLP0sWwaPyPOmogdX7l.v8qP8fE86HMhvNuYPFjqY(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(Player player) {
        try {
            if (me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.v8qP8fE86HMhvNuYPFjqY(player.getUniqueId())) {
                me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.ZwrsrwOCXRUscW6Q(player.getUniqueId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l(Player player) {
        if (CooldownAPI.isInCooldown(this.v8qP8fE86HMhvNuYPFjqY.getPluginUUID(), CVMRrzwtroaqi1segQxnD())) {
            return;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(zYWijCUuZtu47VTPITg())) {
            v8qP8fE86HMhvNuYPFjqY(player);
        } else {
            if (this.ZwrsrwOCXRUscW6Q == null) {
                return;
            }
            if (iZTqZaRK5UGoe0Z().containsKey(player.getUniqueId())) {
                Sidebar sidebar = iZTqZaRK5UGoe0Z().get(player.getUniqueId());
                if (sidebar != null && player != null) {
                    sidebar.removePlayer(player);
                    sidebar.close();
                }
                iZTqZaRK5UGoe0Z().remove(player.getUniqueId());
            }
        }
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            Optional<ScoreboardImplement> optionalNz8xKv4RePC2a0f0iuYU = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().Nz8xKv4RePC2a0f0iuYU();
            if (optionalNz8xKv4RePC2a0f0iuYU.isPresent()) {
                this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                    ((ScoreboardImplement) optionalNz8xKv4RePC2a0f0iuYU.get()).showPluginScoreboard(player);
                }, 1L);
            }
        }, 10L);
    }

    public void ZwrsrwOCXRUscW6Q() {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(NpDhhBdwjqeYPJge())) {
            me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.v8qP8fE86HMhvNuYPFjqY.entrySet().iterator().forEachRemaining(entry -> {
                me.ulrich.clans.qjkRaOgynIj1.zTcC5XsAfoa1Tc1.ZwrsrwOCXRUscW6Q((UUID) entry.getKey());
            });
        } else {
            iZTqZaRK5UGoe0Z().entrySet().iterator().forEachRemaining(entry2 -> {
                ((Sidebar) entry2.getValue()).close();
            });
            iZTqZaRK5UGoe0Z().clear();
        }
        if (jBUuLP0sWwaPyPOmogdX7l()) {
            Bukkit.getOnlinePlayers().iterator().forEachRemaining(player -> {
                Optional<ScoreboardImplement> optionalNz8xKv4RePC2a0f0iuYU = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().Nz8xKv4RePC2a0f0iuYU();
                if (optionalNz8xKv4RePC2a0f0iuYU.isPresent()) {
                    this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        ((ScoreboardImplement) optionalNz8xKv4RePC2a0f0iuYU.get()).showPluginScoreboard(player);
                    }, 1L);
                }
            });
        }
    }

    public ConcurrentHashMap<UUID, Sidebar> iZTqZaRK5UGoe0Z() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public ScoreboardLibrary xtOheRiObl4QeAl() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    private static String EzT85461orE5O6() {
        return "Config.scoreboard.enabled";
    }

    private static String GMKcww2qS8F0YYKx7F() {
        return "reload";
    }

    private static String joURFGZEQdy0Bmv() {
        return "Config.scoreboard.simple_mode";
    }

    private static String CVMRrzwtroaqi1segQxnD() {
        return "reload";
    }

    private static String zYWijCUuZtu47VTPITg() {
        return "Config.scoreboard.simple_mode";
    }

    private static String NpDhhBdwjqeYPJge() {
        return "Config.scoreboard.simple_mode";
    }
}
