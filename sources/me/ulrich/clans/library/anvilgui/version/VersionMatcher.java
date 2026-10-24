package me.ulrich.clans.library.anvilgui.version;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/VersionMatcher.class */
public class VersionMatcher {
    private static final Map<String, String> VERSION_TO_REVISION = new HashMap<String, String>() { // from class: me.ulrich.clans.library.anvilgui.version.VersionMatcher.1
        {
            put("1.20", "1_20_R1");
            put("1.20.1", "1_20_R1");
            put("1.20.2", "1_20_R2");
            put("1.20.3", "1_20_R3");
            put("1.20.4", "1_20_R3");
            put("1.20.5", "1_20_R4");
            put("1.20.6", "1_20_R4");
            put("1.21", "1_21_R1");
            put("1.21.1", "1_21_R1");
            put("1.21.2", "1_21_R2");
            put("1.21.3", "1_21_R2");
            put("1.21.4", "1_21_R3");
            put("1.21.5", "1_21_R4");
            put("1.21.6", "1_21_R5");
            put("1.21.7", "1_21_R5");
            put("1.21.8", "1_21_R5");
            put("1.21.9", "1_21_R6");
            put("1.21.10", "1_21_R6");
            put("1.21.11", "1_21_R7");
            put("26.1", VersionMatcher.FALLBACK_REVISION);
            put("26.1.1", VersionMatcher.FALLBACK_REVISION);
        }
    };
    private static final String FALLBACK_REVISION = "26_R1";

    public VersionWrapper match() {
        String strSubstring;
        String name = Bukkit.getServer().getClass().getPackage().getName();
        if (name.contains(".v")) {
            strSubstring = name.split("\\.")[3].substring(1);
        } else {
            strSubstring = VERSION_TO_REVISION.getOrDefault(Bukkit.getBukkitVersion().split("-")[0], FALLBACK_REVISION);
        }
        try {
            return (VersionWrapper) Class.forName(getClass().getPackage().getName() + ".Wrapper" + strSubstring).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("AnvilGUI does not support server version \"" + strSubstring + "\"", e);
        } catch (ReflectiveOperationException e2) {
            throw new IllegalStateException("Failed to instantiate version wrapper for version " + strSubstring, e2);
        }
    }
}
