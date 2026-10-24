package me.ulrich.clans.loader.addon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Addon;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.loader.JarFilter;
import me.ulrich.clans.loader.Serializer;
import me.ulrich.clans.manager.utils.VersionComparer;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/addon/AddonManager.class */
public class AddonManager {
    private final JavaPlugin instance;
    private final File addonFolder;
    private final Serializer dataSerializer;
    private final Serializer configSerializer;
    private Map<String, Class> globalClassMap = new ConcurrentHashMap();
    private Map<String, AddonClassloader> classLoaders = new ConcurrentHashMap();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/addon/AddonManager$AddonManagerException.class */
    private static final class AddonManagerException extends RuntimeException {
        private AddonManagerException(String str) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }

        private AddonManagerException(String str, Throwable th) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }
    }

    public AddonManager(JavaPlugin javaPlugin, Serializer serializer, Serializer serializer2) {
        this.instance = javaPlugin;
        this.addonFolder = new File(javaPlugin.getDataFolder(), "addons");
        this.addonFolder.mkdirs();
        this.dataSerializer = serializer;
        this.configSerializer = serializer2;
    }

    public File getAddonFolder() {
        return this.addonFolder;
    }

    public void load() {
        if (!this.addonFolder.exists() && !this.addonFolder.mkdir()) {
            throw new AddonManagerException("Couldn't create Addon folder");
        }
        File[] fileArrListFiles = this.addonFolder.listFiles(new JarFilter());
        if (fileArrListFiles == null) {
            return;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        listAsList.stream().filter(this::isLibrary).forEach(this::loadAddon);
        listAsList.stream().filter(file -> {
            return !isLibrary(file);
        }).forEach(this::loadAddon);
    }

    private void getAddonData(File file, String str) {
        try {
            JarFile jarFile = new JarFile(file);
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    String name = jarEntryNextElement.getName();
                    if (!jarEntryNextElement.isDirectory() && !name.startsWith("META-INF/") && name.endsWith(".yml")) {
                        try {
                            InputStream inputStream = jarFile.getInputStream(jarFile.getJarEntry(name));
                            try {
                                mkdir(String.valueOf(this.instance.getDataFolder()) + "/addons/" + str + "/");
                                File file2 = new File(String.valueOf(this.instance.getDataFolder()) + "/addons/" + str + "/" + name);
                                if (!file2.exists()) {
                                    try {
                                        file2.getParentFile().mkdirs();
                                        file2.createNewFile();
                                        if (inputStream != null) {
                                            try {
                                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i = inputStream.read(bArr);
                                                    if (i <= 0) {
                                                        break;
                                                    } else {
                                                        fileOutputStream.write(bArr, 0, i);
                                                    }
                                                }
                                                fileOutputStream.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Throwable th) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            throw new AddonManagerException("Failed to load data in " + file.getName(), e3);
                        }
                    }
                }
            } catch (Exception e4) {
                throw new AddonManagerException(e4.getMessage(), e4);
            }
        } catch (IOException e5) {
            throw new AddonManagerException("Failed to create jar object from " + file.getName(), e5);
        }
    }

    public boolean mkdir(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    private Properties getAddonProperties(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            JarEntry jarEntry = jarFile.getJarEntry("plugin.properties");
            if (jarEntry == null) {
                return null;
            }
            Properties properties = new Properties();
            try {
                InputStream inputStream = jarFile.getInputStream(jarEntry);
                try {
                    properties.load(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return properties;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                throw new AddonManagerException("Failed to load \"plugin.properties\" in " + file.getName());
            }
        } catch (IOException e2) {
            throw new AddonManagerException("Failed to create jar object from " + file.getName(), e2);
        }
    }

    void setClass(String str, Class<?> cls) {
        this.globalClassMap.put(str, cls);
    }

    Class<?> findClass(String str) {
        if (this.globalClassMap.containsKey(str)) {
            return this.globalClassMap.get(str);
        }
        Iterator<AddonClassloader> it = this.classLoaders.values().iterator();
        while (it.hasNext()) {
            try {
                Class<?> clsFindClass = it.next().findClass(str, false);
                if (clsFindClass != null) {
                    this.globalClassMap.put(str, clsFindClass);
                    return clsFindClass;
                }
                continue;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public Collection<String> getLibraries() {
        return Collections.unmodifiableList((List) this.classLoaders.values().stream().filter(addonClassloader -> {
            return addonClassloader.getAddon() == null;
        }).map((v0) -> {
            return v0.getName();
        }).collect(Collectors.toList()));
    }

    public Collection<Addon> getAddons() {
        return Collections.unmodifiableList((List) this.classLoaders.values().stream().filter(addonClassloader -> {
            return addonClassloader.getAddon() != null;
        }).map((v0) -> {
            return v0.getAddon();
        }).collect(Collectors.toList()));
    }

    public <T extends Addon> Optional<T> getAddonInstance(Class<T> cls) {
        Stream<Addon> streamFilter = this.classLoaders.values().stream().filter(addonClassloader -> {
            return addonClassloader.getAddon() != null;
        }).map((v0) -> {
            return v0.getAddon();
        }).filter(addon -> {
            return addon.getClass().equals(cls);
        });
        Objects.requireNonNull(cls);
        return streamFilter.map((v1) -> {
            return cls.cast(v1);
        }).findAny();
    }

    public Optional<Addon> getAddonInstance(String str) {
        return this.classLoaders.containsKey(str) ? Optional.of(this.classLoaders.get(str).getAddon()) : Optional.empty();
    }

    public <T extends Addon> void unloadAddon(Class<T> cls) {
        getAddonInstance(cls).ifPresent(this::unloadAddon);
    }

    public <T extends Addon> void unloadAddon(T t) {
        if (t.isEnabled()) {
            t.disable();
        }
        AddonClassloader classLoader = t.getClassLoader();
        classLoader.setDisabling(true);
        classLoader.removeClasses();
        String name = t.getName();
        if (!this.classLoaders.containsKey(name)) {
            throw new AddonManagerException("Cannot find class loader by name \"" + name + "\". Panicking!");
        }
        classLoader.setDisabling(false);
        this.classLoaders.remove(name);
    }

    public <T extends Addon> Addon reloadAddon(T t) {
        if (t.isEnabled()) {
            t.disable();
        }
        File file = t.getClassLoader().getFile();
        unloadAddon(t);
        AddonClassloader addonClassloaderLoadAddon = loadAddon(file);
        if (addonClassloaderLoadAddon == null || addonClassloaderLoadAddon.getAddon() == null) {
            throw new AddonManagerException("Failed to enable addon...");
        }
        addonClassloaderLoadAddon.getAddon().enable(this.instance, new File(getAddonFolder(), t.getName()), getDataSerializer(), getConfigSerializer());
        return addonClassloaderLoadAddon.getAddon();
    }

    public void reloadAddonConfig(Addon addon) {
        addon.onDisable();
        addon.onEnable();
    }

    private boolean isLibrary(File file) {
        Properties addonProperties = null;
        try {
            addonProperties = getAddonProperties(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addonProperties == null;
    }

    public AddonClassloader loadAddon(File file) {
        try {
            Properties addonProperties = getAddonProperties(file);
            if (addonProperties == null) {
                return loadLibrary(file);
            }
            if (!addonProperties.containsKey("main")) {
                new AddonManagerException("\"plugin.properties\" for " + file.getName() + " has no \"main\" key");
                return null;
            }
            if (!addonProperties.containsKey("name")) {
                new AddonManagerException("\"plugin.properties\" for " + file.getName() + " has no \"name\" key");
                return null;
            }
            String string = addonProperties.get("name").toString();
            if (this.classLoaders.containsKey(string)) {
                Clans.getClanCore().getLogger().warning("Addon of name \"" + string + "\" has already been loaded...");
                return null;
            }
            String string2 = addonProperties.get("main").toString();
            if (this.globalClassMap.containsKey(string2)) {
                throw new AddonManagerException("Addon main class has already been loaded: " + string2);
            }
            String string3 = null;
            try {
                string3 = addonProperties.get(Key.MINECRAFT_NAMESPACE).toString();
            } catch (Exception e) {
            }
            if (string3 != null && !VersionUtil.isMinecraftFamily(VersionUtil.VersionEnum.valueOf(string3))) {
                Clans.getClanCore().getLogger().warning(" - Addon : " + string + " --DISABLED");
                return null;
            }
            String string4 = null;
            try {
                string4 = addonProperties.get("minecraft_min").toString();
            } catch (Exception e2) {
            }
            if (string4 != null && !VersionUtil.isAbove(VersionUtil.VersionEnum.valueOf(string4))) {
                Clans.getClanCore().getLogger().warning(" - Addon : " + string + " --DISABLED");
                return null;
            }
            String string5 = null;
            try {
                string5 = addonProperties.get("depend").toString();
            } catch (Exception e3) {
            }
            String string6 = null;
            try {
                string6 = addonProperties.get("author").toString();
            } catch (Exception e4) {
            }
            String string7 = null;
            try {
                string7 = addonProperties.get("version").toString();
            } catch (Exception e5) {
            }
            String string8 = null;
            try {
                string8 = addonProperties.get("requires").toString();
            } catch (Exception e6) {
            }
            try {
                addonProperties.get("description").toString();
            } catch (Exception e7) {
            }
            try {
                addonProperties.get("category").toString();
            } catch (Exception e8) {
            }
            String string9 = null;
            try {
                string9 = addonProperties.get("min_version").toString();
            } catch (Exception e9) {
            }
            if (string9 != null && string5 != null && new VersionComparer(Clans.getClanCore().getDescription().getVersion()).compareTo(new VersionComparer(string9)) < 0) {
                Clans.getClanCore().getLogger().warning(" ! " + string + ", Reason: Need " + string5 + " " + string9 + "+");
                return null;
            }
            if (string8 != null && string8.startsWith("[") && string8.endsWith("]")) {
                JSONArray jSONArray = new JSONArray(string8);
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        if (!Bukkit.getServer().getPluginManager().isPluginEnabled(jSONArray.get(i).toString())) {
                            Clans.getClanCore().getLogger().warning(" Module " + string + " requires " + jSONArray.get(i).toString());
                            return null;
                        }
                        continue;
                    } catch (Exception e10) {
                    }
                }
            }
            if (string5 == null || !string5.equals("UltimateClans")) {
                new AddonManagerException("Failed to load " + file.getName());
                return null;
            }
            try {
                getAddonData(file, string);
                try {
                    AddonClassloader addonClassloader = new AddonClassloader(this, file, string2, string, string6, string7, string8);
                    this.classLoaders.put(string, addonClassloader);
                    return addonClassloader;
                } catch (Exception e11) {
                    new AddonManagerException("Failed to load " + file.getName(), e11);
                    return null;
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        } catch (Exception e13) {
            e13.printStackTrace();
            return null;
        }
    }

    private AddonClassloader loadLibrary(File file) {
        try {
            AddonClassloader addonClassloader = new AddonClassloader(this, file, file.toPath().getFileName().toString(), null, null, null, null);
            this.classLoaders.put(addonClassloader.getName(), addonClassloader);
            return addonClassloader;
        } catch (Exception e) {
            new AddonManagerException("Failed to load " + file.getName(), e);
            return null;
        }
    }

    public void enableAddons() {
        this.classLoaders.values().stream().filter(addonClassloader -> {
            return addonClassloader.getAddon() != null;
        }).map((v0) -> {
            return v0.getAddon();
        }).filter(addon -> {
            return !addon.isEnabled();
        }).forEach(addon2 -> {
            addon2.enable(this.instance, new File(getAddonFolder(), addon2.getName()), getDataSerializer(), getConfigSerializer());
        });
    }

    public void disableAddons() {
        this.classLoaders.values().stream().filter(addonClassloader -> {
            return addonClassloader.getAddon() != null;
        }).map((v0) -> {
            return v0.getAddon();
        }).filter((v0) -> {
            return v0.isEnabled();
        }).forEach((v0) -> {
            v0.disable();
        });
    }

    void removeAll(Map<String, Class<?>> map) {
        map.keySet().forEach(str -> {
            this.globalClassMap.remove(str);
        });
        Iterator<Class<?>> it = map.values().iterator();
        while (it.hasNext()) {
            if (this.globalClassMap.containsValue(it.next())) {
                throw new AddonManagerException("Clazz did not get removed...");
            }
        }
    }

    public Serializer getDataSerializer() {
        return this.dataSerializer;
    }

    public Serializer getConfigSerializer() {
        return this.configSerializer;
    }
}
