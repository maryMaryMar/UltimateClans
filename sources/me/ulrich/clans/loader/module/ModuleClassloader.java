package me.ulrich.clans.loader.module;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.Module;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/module/ModuleClassloader.class */
public class ModuleClassloader extends URLClassLoader {
    private final ModuleManager moduleManager;
    private final Map<String, Class<?>> classes;
    private final Module module;
    private final File file;
    private final String name;
    private final String author;
    private final String version;
    private final String require;
    private boolean disabling;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/module/ModuleClassloader$ModuleLoaderException.class */
    private class ModuleLoaderException extends RuntimeException {
        private ModuleLoaderException(String str) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }

        private ModuleLoaderException(String str, Throwable th) {
            Bukkit.getPluginManager().getPlugin("UltimateClans").getLogger().warning(str);
        }
    }

    ModuleClassloader(ModuleManager moduleManager, File file, String str, String str2, String str3, String str4) throws java.net.MalformedURLException {
        super(new URL[]{file.toURI().toURL()}, moduleManager.getClass().getClassLoader());
        this.classes = new ConcurrentHashMap();
        this.moduleManager = moduleManager;
        this.file = file;
        this.name = str;
        this.author = str2;
        this.version = str3;
        this.require = str4;
        this.module = null;
        if (!file.toPath().getFileName().toString().equalsIgnoreCase(str)) {
            throw new ModuleLoaderException("File name does not match module name...");
        }
    }

    ModuleClassloader(ModuleManager moduleManager, File file, String str, String str2, String str3, String str4, String str5) throws java.net.MalformedURLException {
        super(new URL[]{file.toURI().toURL()}, moduleManager.getClass().getClassLoader());
        this.classes = new ConcurrentHashMap();
        this.moduleManager = moduleManager;
        this.file = file;
        try {
            Class<?> cls = Class.forName(str, true, this);
            this.classes.put(cls.getName(), cls);
            try {
                try {
                    this.module = (Module) cls.asSubclass(Module.class).newInstance();
                    this.module.setClassLoader(this);
                    this.module.setName(str2);
                    this.module.setAuthor(str3);
                    this.module.setVersion(str4);
                    this.module.setRequire(str5);
                    this.name = str2;
                    this.author = str3;
                    this.version = str4;
                    this.require = str5;
                } catch (Exception e) {
                    throw new ModuleLoaderException("Failed to load main class for " + str2, e);
                }
            } catch (Exception e2) {
                throw new ModuleLoaderException(str + " does not implement Module");
            }
        } catch (ClassNotFoundException e3) {
            throw new ModuleLoaderException("Could not find main class for module " + str2);
        } catch (NoClassDefFoundError e4) {
            e4.printStackTrace();
            throw new ModuleLoaderException("Maybe there is some dependency missing for " + str2);
        } catch (UnsupportedClassVersionError e5) {
            throw new ModuleLoaderException("Module " + str2 + " with a different version of Java.");
        } catch (LinkageError e6) {
            throw new ModuleLoaderException("Structure/linking error in the module. " + str2);
        }
    }

    public ModuleManager getModuleManager() {
        return this.moduleManager;
    }

    public Module getModule() {
        return this.module;
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
    protected Class<?> findClass(String str) throws ClassNotFoundException {
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
            clsFindClass = this.moduleManager.findClass(str);
        }
        if (clsFindClass == null) {
            clsFindClass = super.findClass(str);
            if (clsFindClass != null) {
                this.moduleManager.setClass(str, clsFindClass);
            }
        }
        return clsFindClass;
    }

    void removeClasses() {
        if (!isDisabling()) {
            throw new IllegalStateException("Cannot remove class when the loader isn't disabling...");
        }
        this.moduleManager.removeAll(this.classes);
        this.classes.clear();
    }
}
