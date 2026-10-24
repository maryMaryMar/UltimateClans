package me.ulrich.clans.library.nbtapi.iface;

import java.io.File;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/iface/NBTFileHandle.class */
public interface NBTFileHandle extends ReadWriteNBT {
    void save();

    File getFile();
}
