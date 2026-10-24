package me.ulrich.clans.loader.extension;

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
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.loader.JarFilter;
import me.ulrich.clans.loader.Serializer;
import me.ulrich.clans.manager.utils.VersionComparer;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/extension/ExtensionManager.class */
public class ExtensionManager {
    private final JavaPlugin instance;
    private final File extensionFolder;
    private final Serializer dataSerializer;
    private final Serializer configSerializer;
    private Map<String, Class> globalClassMap = new ConcurrentHashMap();
    private Map<String, ExtensionClassloader> classLoaders = new ConcurrentHashMap();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/extension/ExtensionManager$ExtensionManagerException.class */
    private static final class ExtensionManagerException extends RuntimeException {
        private ExtensionManagerException(String str) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }

        private ExtensionManagerException(String str, Throwable th) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }
    }

    public ExtensionManager(JavaPlugin javaPlugin, Serializer serializer, Serializer serializer2) {
        this.instance = javaPlugin;
        this.extensionFolder = new File(javaPlugin.getDataFolder(), "extensions");
        this.extensionFolder.mkdirs();
        this.dataSerializer = serializer;
        this.configSerializer = serializer2;
    }

    public File getExtensionFolder() {
        return this.extensionFolder;
    }

    public void loadExtensions() {
        if (!this.extensionFolder.exists() && !this.extensionFolder.mkdir()) {
            throw new ExtensionManagerException("Couldn't create extension folder");
        }
        File[] fileArrListFiles = this.extensionFolder.listFiles(new JarFilter());
        if (fileArrListFiles == null) {
            return;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        listAsList.stream().filter(this::isLibrary).forEach(this::loadExtension);
        listAsList.stream().filter(file -> {
            return !isLibrary(file);
        }).forEach(this::loadExtension);
    }

    private void getExtensionData(File file, String str) {
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
                                mkdir(String.valueOf(this.instance.getDataFolder()) + "/extensions/" + str + "/");
                                File file2 = new File(String.valueOf(this.instance.getDataFolder()) + "/extensions/" + str + "/" + name);
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
                            throw new ExtensionManagerException("Failed to load data in " + file.getName(), e3);
                        }
                    }
                }
            } catch (Exception e4) {
                throw new ExtensionManagerException(e4.getMessage(), e4);
            }
        } catch (IOException e5) {
            throw new ExtensionManagerException("Failed to create jar object from " + file.getName(), e5);
        }
    }

    public boolean mkdir(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    private Properties getExtensionProperties(File file) {
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
                throw new ExtensionManagerException("Failed to load \"plugin.properties\" in " + file.getName());
            }
        } catch (IOException e2) {
            throw new ExtensionManagerException("Failed to create jar object from " + file.getName(), e2);
        }
    }

    void setClass(String str, Class<?> cls) {
        this.globalClassMap.put(str, cls);
    }

    Class<?> findClass(String str) {
        if (this.globalClassMap.containsKey(str)) {
            return this.globalClassMap.get(str);
        }
        Iterator<ExtensionClassloader> it = this.classLoaders.values().iterator();
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
        return Collections.unmodifiableList((List) this.classLoaders.values().stream().filter(extensionClassloader -> {
            return extensionClassloader.getExtension() == null;
        }).map((v0) -> {
            return v0.getName();
        }).collect(Collectors.toList()));
    }

    public Collection<Extension> getExtensions() {
        return Collections.unmodifiableList((List) this.classLoaders.values().stream().filter(extensionClassloader -> {
            return extensionClassloader.getExtension() != null;
        }).map((v0) -> {
            return v0.getExtension();
        }).collect(Collectors.toList()));
    }

    public <T extends Extension> Optional<T> getExtensionInstance(Class<T> cls) {
        Stream<Extension> streamFilter = this.classLoaders.values().stream().filter(extensionClassloader -> {
            return extensionClassloader.getExtension() != null;
        }).map((v0) -> {
            return v0.getExtension();
        }).filter(extension -> {
            return extension.getClass().equals(cls);
        });
        Objects.requireNonNull(cls);
        return streamFilter.map((v1) -> {
            return cls.cast(v1);
        }).findAny();
    }

    public Optional<Extension> getExtensionInstance(String str) {
        return this.classLoaders.containsKey(str) ? Optional.of(this.classLoaders.get(str).getExtension()) : Optional.empty();
    }

    public <T extends Extension> void unloadExtension(Class<T> cls) {
        getExtensionInstance(cls).ifPresent(this::unloadExtension);
    }

    public <T extends Extension> void unloadExtension(T t) {
        if (t.isEnabled()) {
            t.disable();
        }
        ExtensionClassloader classLoader = t.getClassLoader();
        classLoader.setDisabling(true);
        classLoader.removeClasses();
        String name = t.getName();
        if (!this.classLoaders.containsKey(name)) {
            throw new ExtensionManagerException("Cannot find class loader by name \"" + name + "\". Panicking!");
        }
        classLoader.setDisabling(false);
        this.classLoaders.remove(name);
    }

    public <T extends Extension> Extension reloadExtension(T t) {
        if (t.isEnabled()) {
            t.disable();
        }
        File file = t.getClassLoader().getFile();
        unloadExtension(t);
        ExtensionClassloader extensionClassloaderLoadExtension = loadExtension(file);
        if (extensionClassloaderLoadExtension == null || extensionClassloaderLoadExtension.getExtension() == null) {
            throw new ExtensionManagerException("Failed to enable extension...");
        }
        extensionClassloaderLoadExtension.getExtension().enable(this.instance, new File(getExtensionFolder(), t.getName()), getDataSerializer(), getConfigSerializer());
        return extensionClassloaderLoadExtension.getExtension();
    }

    public void reloadExtensionConfig(Extension extension) {
        extension.onDisable();
        extension.onEnable();
    }

    private boolean isLibrary(File file) {
        Properties extensionProperties = null;
        try {
            extensionProperties = getExtensionProperties(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return extensionProperties == null;
    }

    public ExtensionClassloader loadExtension(File file) {
        try {
            Properties extensionProperties = getExtensionProperties(file);
            if (extensionProperties == null) {
                return loadLibrary(file);
            }
            if (!extensionProperties.containsKey("main")) {
                new ExtensionManagerException("\"plugin.properties\" for " + file.getName() + " has no \"main\" key");
                return null;
            }
            if (!extensionProperties.containsKey("name")) {
                new ExtensionManagerException("\"plugin.properties\" for " + file.getName() + " has no \"name\" key");
                return null;
            }
            String string = extensionProperties.get("name").toString();
            if (this.classLoaders.containsKey(string)) {
                Clans.getClanCore().getLogger().warning("Extension of name \"" + string + "\" has already been loaded...");
                return null;
            }
            String string2 = extensionProperties.get("main").toString();
            if (this.globalClassMap.containsKey(string2)) {
                throw new ExtensionManagerException("extension main class has already been loaded: " + string2);
            }
            String string3 = null;
            try {
                string3 = extensionProperties.get(Key.MINECRAFT_NAMESPACE).toString();
            } catch (Exception e) {
            }
            if (string3 != null && !VersionUtil.isMinecraftFamily(VersionUtil.VersionEnum.valueOf(string3))) {
                Clans.getClanCore().getLogger().warning(" - Extension : " + string + " --DISABLED");
                return null;
            }
            String string4 = null;
            try {
                string4 = extensionProperties.get("minecraft_min").toString();
            } catch (Exception e2) {
            }
            if (string4 != null && !VersionUtil.isAbove(VersionUtil.VersionEnum.valueOf(string4))) {
                Clans.getClanCore().getLogger().warning(" - Extension : " + string + " --DISABLED");
                return null;
            }
            String string5 = null;
            try {
                string5 = extensionProperties.get("depend").toString();
            } catch (Exception e3) {
            }
            String string6 = null;
            try {
                string6 = extensionProperties.get("author").toString();
            } catch (Exception e4) {
            }
            String string7 = null;
            try {
                string7 = extensionProperties.get("version").toString();
            } catch (Exception e5) {
            }
            String string8 = null;
            try {
                string8 = extensionProperties.get("requires").toString();
            } catch (Exception e6) {
            }
            String string9 = null;
            try {
                string9 = extensionProperties.get("description").toString();
            } catch (Exception e7) {
            }
            try {
                extensionProperties.get("category").toString();
            } catch (Exception e8) {
            }
            String string10 = null;
            try {
                string10 = extensionProperties.get("min_version").toString();
            } catch (Exception e9) {
            }
            if (string10 != null && string5 != null && new VersionComparer(Clans.getClanCore().getDescription().getVersion()).compareTo(new VersionComparer(string10)) < 0) {
                Clans.getClanCore().getLogger().warning(" ! " + string + ", Reason: Need " + string5 + " " + string10 + "+");
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
                new ExtensionManagerException("Failed to load " + file.getName());
                return null;
            }
            try {
                getExtensionData(file, string);
                try {
                    ExtensionClassloader extensionClassloader = new ExtensionClassloader(this, file, string2, string, string6, string7, string8, string9);
                    this.classLoaders.put(string, extensionClassloader);
                    return extensionClassloader;
                } catch (Exception e11) {
                    new ExtensionManagerException("Failed to load " + file.getName(), e11);
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

    private ExtensionClassloader loadLibrary(File file) {
        try {
            ExtensionClassloader extensionClassloader = new ExtensionClassloader(this, file, file.toPath().getFileName().toString(), null, null, null, null, null);
            this.classLoaders.put(extensionClassloader.getName(), extensionClassloader);
            return extensionClassloader;
        } catch (Exception e) {
            new ExtensionManagerException("Failed to load " + file.getName(), e);
            return null;
        }
    }

    public void enableExtensions() {
        this.classLoaders.values().stream().filter(extensionClassloader -> {
            return extensionClassloader.getExtension() != null;
        }).map((v0) -> {
            return v0.getExtension();
        }).filter(extension -> {
            return !extension.isEnabled();
        }).forEach(extension2 -> {
            extension2.enable(this.instance, new File(getExtensionFolder(), extension2.getName()), getDataSerializer(), getConfigSerializer());
        });
    }

    public void disableExtensions() {
        this.classLoaders.values().stream().filter(extensionClassloader -> {
            return extensionClassloader.getExtension() != null;
        }).map((v0) -> {
            return v0.getExtension();
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
                throw new ExtensionManagerException("Clazz did not get removed...");
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
