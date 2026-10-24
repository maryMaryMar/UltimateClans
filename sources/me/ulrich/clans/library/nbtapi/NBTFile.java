package me.ulrich.clans.library.nbtapi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import me.ulrich.clans.library.nbtapi.iface.NBTFileHandle;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ObjectCreator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTFile.class */
public class NBTFile extends NBTCompound implements NBTFileHandle {
    private final File file;
    private Object nbt;

    @Deprecated
    public NBTFile(File file) {
        super(null, null);
        if (file == null) {
            throw new NullPointerException("File can't be null!");
        }
        this.file = file;
        if (file.exists()) {
            this.nbt = NBTReflectionUtil.readNBT(Files.newInputStream(file.toPath(), new OpenOption[0]));
        } else {
            this.nbt = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
            save();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.NBTFileHandle
    public void save() {
        try {
            getWriteLock().lock();
            saveTo(this.file, this);
        } finally {
            getWriteLock().unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.NBTFileHandle
    public File getFile() {
        return this.file;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    public Object getCompound() {
        return this.nbt;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setCompound(Object obj) {
        this.nbt = obj;
    }

    @Deprecated
    public static NBTCompound readFrom(File file) {
        return !file.exists() ? new NBTContainer() : new NBTContainer(NBTReflectionUtil.readNBT(Files.newInputStream(file.toPath(), new OpenOption[0])));
    }

    @Deprecated
    public static void saveTo(File file, NBTCompound nBTCompound) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (!file.createNewFile()) {
                throw new IOException("Unable to create file at " + file.getAbsolutePath());
            }
        }
        nBTCompound.writeCompound(Files.newOutputStream(file.toPath(), new OpenOption[0]));
    }
}
