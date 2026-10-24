package me.ulrich.clans.manager.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Files.class */
public class Files {
    private final Plugin plugin;
    private FileConfiguration configuration;
    private File file;
    private String name;

    public Files(Plugin plugin, File file, String str, String str2, String str3, String str4) {
        this.plugin = plugin;
        this.name = str2;
        this.file = new File((str == null || str.isEmpty()) ? file : new File(file, str), str2 + "." + str4);
        if (!this.file.exists()) {
            try {
                this.file.getParentFile().mkdirs();
                if (str3 != null) {
                    InputStream resource = plugin.getResource(str3 + "." + str4);
                    if (resource != null) {
                        copy(resource, this.file);
                    } else {
                        this.file.createNewFile();
                    }
                } else {
                    this.file.createNewFile();
                }
            } catch (IOException e) {
                plugin.getLogger().warning("Could not create " + this.file.getName() + "!");
                e.printStackTrace();
            }
        }
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public FileConfiguration get() {
        return this.configuration;
    }

    public File getFile() {
        return this.file;
    }

    public String getName() {
        return this.name;
    }

    public void save() {
        try {
            this.configuration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            this.configuration = YamlConfiguration.loadConfiguration(this.file);
        } catch (Exception e) {
            this.plugin.getLogger().warning("Could not reload " + this.name + "!");
            e.printStackTrace();
        }
    }

    public Files getFileManager() {
        return this;
    }

    private static void copy(InputStream inputStream, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        inputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
