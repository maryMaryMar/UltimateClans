package me.ulrich.clans.loader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.time.LocalTime;
import java.util.logging.Logger;
import me.ulrich.clans.Clans;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/Persist.class */
public class Persist {
    private File dataFolder;
    private Logger logger;
    private Clans plugin;
    private final Gson gson = buildGson().create();
    private final Gson dataGson = buildDataGson().create();

    public Persist(Clans clans) {
        this.dataFolder = clans.getDataFolder();
        this.logger = clans.getLogger();
        this.plugin = clans;
    }

    public Persist(File file, Logger logger) {
        this.dataFolder = file;
        this.logger = logger;
    }

    public Gson getDataGson() {
        return this.dataGson;
    }

    public Gson getGson() {
        return this.gson;
    }

    public static String getName(Class<?> cls) {
        return cls.getSimpleName().toLowerCase();
    }

    public static String getName(Object obj) {
        return getName(obj.getClass());
    }

    public static String getName(Type type) {
        return getName(type.getClass());
    }

    private GsonBuilder buildGson() {
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().enableComplexMapKeySerialization().excludeFieldsWithModifiers(new int[]{128, 64}).registerTypeAdapter(Location.class, new LocationTypeAdapter()).registerTypeAdapter(Inventory.class, new InventoryTypeAdapter()).registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter()).registerTypeAdapterFactory(EnumTypeAdapter.ENUM_FACTORY);
    }

    private GsonBuilder buildDataGson() {
        return new GsonBuilder().disableHtmlEscaping().enableComplexMapKeySerialization().excludeFieldsWithModifiers(new int[]{128, 64}).registerTypeAdapter(Location.class, new LocationTypeAdapter()).registerTypeAdapter(Inventory.class, new InventoryTypeAdapter()).registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter()).registerTypeAdapterFactory(EnumTypeAdapter.ENUM_FACTORY);
    }

    public File getFile(boolean z, String str) {
        File file = this.dataFolder;
        if (z) {
            file = new File(file, "/json-data");
            file.mkdirs();
        }
        return new File(file, str + ".json");
    }

    public File getFile(Class<?> cls) {
        return getFile(false, getName(cls));
    }

    public File getFile(boolean z, Object obj) {
        return getFile(z, getName(obj));
    }

    public File getFile(Type type) {
        return getFile(false, getName(type));
    }

    public <T> T loadOrSaveDefault(T t, Class<T> cls) {
        return (T) loadOrSaveDefault(t, cls, getFile((Class<?>) cls));
    }

    public <T> T loadOrSaveDefault(boolean z, T t, Class<T> cls, String str) {
        return (T) loadOrSaveDefault(t, cls, getFile(z, str));
    }

    public <T> T loadOrSaveDefault(boolean z, T t, Class<T> cls, File file) {
        return (T) loadOrSaveDefault(t, cls, file);
    }

    public <T> T loadOrSaveDefault(T t, Class<T> cls, File file) {
        if (!file.exists()) {
            this.logger.info("Creating default: " + String.valueOf(file));
            save(false, (Object) t, file);
            return t;
        }
        T t2 = (T) load((Class) cls, file);
        if (t2 != null) {
            return t2;
        }
        this.logger.warning("Using default as I failed to load: " + String.valueOf(file));
        File file2 = new File(file.getPath() + ".bad");
        if (file2.exists()) {
            file2.delete();
        }
        this.logger.warning("Backing up copy of bad file to: " + String.valueOf(file2));
        file.renameTo(file2);
        return t;
    }

    public boolean save(boolean z, Object obj) {
        return save(z, obj, getFile(z, obj));
    }

    public boolean save(boolean z, Object obj, String str) {
        return save(z, obj, getFile(false, str));
    }

    public boolean save(boolean z, Object obj, File file) {
        Gson gson = z ? this.dataGson : this.gson;
        File file2 = new File(file.toPath().toString() + ".backup");
        if (file.exists()) {
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                Files.copy(file.toPath(), file2.toPath(), new CopyOption[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean zWriteCatch = DiscUtil.writeCatch(this.plugin, file, gson.toJson(obj), true);
        file2.delete();
        return zWriteCatch;
    }

    public <T> T load(Class<T> cls) {
        return (T) load((Class) cls, getFile((Class<?>) cls));
    }

    public <T> T load(Class<T> cls, String str) {
        return (T) load((Class) cls, getFile(false, str));
    }

    public <T> T load(Class<T> cls, File file) {
        if (DiscUtil.readCatch(file) == null || !file.exists()) {
            return null;
        }
        try {
            return (T) this.gson.fromJson(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8), cls);
        } catch (Exception e) {
            this.logger.warning(e.getMessage());
            return null;
        }
    }

    public <T> T load(Type type, String str) {
        return (T) load(type, getFile(false, str));
    }

    public <T> T load(Type type, File file) {
        if (DiscUtil.readCatch(file) == null || !file.exists()) {
            return null;
        }
        try {
            return (T) this.gson.fromJson(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8), type);
        } catch (Exception e) {
            this.logger.warning(e.getMessage());
            return null;
        }
    }
}
