package me.ulrich.clans.loader.addon;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.Addon;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/addon/AddonClassloader.class */
public class AddonClassloader extends URLClassLoader {
    private final AddonManager addonManager;
    private final Map<String, Class<?>> classes;
    private final Addon addon;
    private final File file;
    private final String name;
    private final String author;
    private final String version;
    private final String require;
    private boolean disabling;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/addon/AddonClassloader$AddonLoaderException.class */
    private class AddonLoaderException extends RuntimeException {
        private AddonLoaderException(String str) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }

        private AddonLoaderException(String str, Throwable th) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }
    }

    AddonClassloader(AddonManager addonManager, File file, String str, String str2, String str3, String str4) throws java.net.MalformedURLException {
        super(new URL[]{file.toURI().toURL()}, addonManager.getClass().getClassLoader());
        this.classes = new ConcurrentHashMap();
        this.addonManager = addonManager;
        this.file = file;
        this.name = str;
        this.author = str2;
        this.version = str3;
        this.require = str4;
        this.addon = null;
        if (!file.toPath().getFileName().toString().equalsIgnoreCase(str)) {
            throw new AddonLoaderException("File name does not match addon name...");
        }
    }

    AddonClassloader(AddonManager addonManager, File file, String str, String str2, String str3, String str4, String str5) throws java.net.MalformedURLException {
        super(new URL[]{file.toURI().toURL()}, addonManager.getClass().getClassLoader());
        this.classes = new ConcurrentHashMap();
        this.addonManager = addonManager;
        this.file = file;
        try {
            Class<?> cls = Class.forName(str, true, this);
            this.classes.put(cls.getName(), cls);
            try {
                try {
                    this.addon = (Addon) cls.asSubclass(Addon.class).newInstance();
                    this.addon.setClassLoader(this);
                    this.addon.setName(str2);
                    this.addon.setAuthor(str3);
                    this.addon.setVersion(str4);
                    this.addon.setRequire(str5);
                    this.name = str2;
                    this.author = str3;
                    this.version = str4;
                    this.require = str5;
                } catch (Exception e) {
                    throw new AddonLoaderException("Failed to load main class for " + str2, e);
                }
            } catch (Exception e2) {
                throw new AddonLoaderException(str + " does not implement Addon");
            }
        } catch (ClassNotFoundException e3) {
            throw new AddonLoaderException("Could not find main class for addon " + str2);
        } catch (NoClassDefFoundError e4) {
            e4.printStackTrace();
            throw new AddonLoaderException("Maybe there is some dependency missing for " + str2);
        }
    }

    public AddonManager getAddonManager() {
        return this.addonManager;
    }

    public Addon getAddon() {
        return this.addon;
    }

    public File getFile() {
        return this.file;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getVersion() {
        return this.version;
    }

    public String getRequire() {
        return this.require;
    }

    public boolean isDisabling() {
        return this.disabling;
    }

    public void setDisabling(boolean z) {
        this.disabling = z;
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str)  throws ClassNotFoundException {
        return findClass(str, true);
    }

    Class<?> findClass(String str, boolean z) throws ClassNotFoundException {
        if (isDisabling()) {
            throw new ClassNotFoundException("This class loader is disabling...");
        }
        if (this.classes.containsKey(str)) {
            return this.classes.get(str);
        }
        Class<?> clsFindClass = null;
        if (z) {
            clsFindClass = this.addonManager.findClass(str);
        }
        if (clsFindClass == null) {
            clsFindClass = super.findClass(str);
            if (clsFindClass != null) {
                this.addonManager.setClass(str, clsFindClass);
            }
        }
        return clsFindClass;
    }

    void removeClasses() {
        if (!isDisabling()) {
            throw new IllegalStateException("Cannot remove class when the loader isn't disabling...");
        }
        this.addonManager.removeAll(this.classes);
        this.classes.clear();
    }
}
