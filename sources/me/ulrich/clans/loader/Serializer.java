package me.ulrich.clans.loader;

import java.io.File;
import java.util.logging.Logger;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/Serializer.class */
public class Serializer {
    private boolean data;
    private File dataFolder;
    private Logger logger;

    public Serializer(boolean z, File file, Logger logger) {
        this.data = z;
        this.dataFolder = file;
        this.logger = logger;
    }

    public Serializer(Clans clans, boolean z) {
        this.data = z;
        this.dataFolder = clans.getDataFolder();
        this.logger = clans.getLogger();
    }

    public Serializer(Clans clans) {
        this.data = false;
        this.dataFolder = clans.getDataFolder();
        this.logger = clans.getLogger();
    }

    public void save(Object obj, String str) {
        new Persist(this.dataFolder, this.logger).save(this.data, obj, str);
    }

    public void save(Object obj) {
        new Persist(this.dataFolder, this.logger).save(this.data, obj);
    }

    public void save(Object obj, File file) {
        new Persist(this.dataFolder, this.logger).save(this.data, obj, file);
    }

    public <T> T load(T t, Class<T> cls, String str) {
        return (T) new Persist(this.dataFolder, this.logger).loadOrSaveDefault(this.data, t, cls, str);
    }

    public <T> T load(T t, Class<T> cls, File file) {
        return (T) new Persist(this.dataFolder, this.logger).loadOrSaveDefault(this.data, t, cls, file);
    }
}
