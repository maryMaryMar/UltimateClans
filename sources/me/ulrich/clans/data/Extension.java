package me.ulrich.clans.data;

import me.ulrich.clans.Clans;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import me.ulrich.clans.loader.Serializer;
import me.ulrich.clans.loader.extension.ExtensionClassloader;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/Extension.class */
public abstract class Extension {
    private boolean enabled;
    private Serializer dataSerializer;
    private Serializer configSerializer;
    private JavaPlugin instance;
    private String name;
    private String author;
    private String version;
    private String require;
    private String description;
    private ExtensionClassloader classLoader;
    private File extensionDataFolder;
    private HashMap<String, InputStream> extensionFiles;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public JavaPlugin getInstance() {
        return this.instance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ExtensionClassloader getClassLoader() {
        return this.classLoader;
    }

    public void setClassLoader(ExtensionClassloader extensionClassloader) {
        this.classLoader = extensionClassloader;
    }

    public File getExtensionDataFolder() {
        return this.extensionDataFolder;
    }

    public void enable(JavaPlugin javaPlugin, File file, Serializer serializer, Serializer serializer2) {
        try {
            if (isEnabled()) {
                this.instance.getLogger().warning("Error extension: " + file.getName() + ", The extension is already enabled.");
            }
            this.instance = javaPlugin;
            this.extensionDataFolder = file;
            this.dataSerializer = serializer;
            this.configSerializer = serializer2;
            file.mkdirs();
            onEnable();
            setEnabled(true);
        } catch (Exception e) {
            logThis(e);
        }
    }

    protected boolean logThis(Exception exc) {
        try {
            new jBWyXxi9EyWxcPiz((Clans) Bukkit.getPluginManager().getPlugin("UltimateClans")).v8qP8fE86HMhvNuYPFjqY(ExceptionUtils.getStackTrace(exc), "extension-" + this.extensionDataFolder.getName() + "-stacktrace");
            this.instance.getLogger().warning("Error extension: " + this.extensionDataFolder.getName() + ", StackTrace: saved in /logs/extension-" + this.extensionDataFolder.getName() + "-stacktrace.log");
            return true;
        } catch (ClassCastException e) {
            this.instance.getLogger().warning("Error extension: " + this.extensionDataFolder.getName() + ", StackTrace: Error to save log!");
            return false;
        }
    }

    public void disable() {
        if (!isEnabled()) {
            throw new IllegalStateException("Cannot disable the extension when it isn't enabled");
        }
        onDisable();
        setEnabled(false);
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public Serializer getDataSerializer() {
        return this.dataSerializer;
    }

    public Serializer getConfigSerializer() {
        return this.configSerializer;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public HashMap<String, InputStream> getAddonFiles() {
        return this.extensionFiles;
    }

    public void setAddonFiles(HashMap<String, InputStream> map) {
        this.extensionFiles = map;
    }

    public String getRequire() {
        return this.require;
    }

    public void setRequire(String str) {
        this.require = str;
    }
}
