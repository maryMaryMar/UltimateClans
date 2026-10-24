package me.ulrich.clans.data.addons;

import java.io.File;
import java.util.Optional;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusStructureData.class */
public class NexusStructureData {
    private boolean playerCanUse;
    private boolean replaceAir;
    private boolean enabled;
    private String name;
    private Optional<String> usePermission;
    private Material icon;
    private String filename;
    private boolean replaceBusy;
    private int sizeX;
    private int sizeY;
    private int sizeZ;
    private File file;

    public NexusStructureData(File file, String str, String str2, Optional<String> optional, Material material, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, int i3) {
        setFile(file);
        setFilename(str);
        setName(str2);
        setEnabled(z2);
        setPlayerCanUse(z);
        setReplaceAir(z3);
        setReplaceBusy(z4);
        setUsePermission(optional);
        setIcon(material);
        setSizeX(i);
        setSizeY(i2);
        setSizeZ(i3);
    }

    public boolean isReplaceAir() {
        return this.replaceAir;
    }

    public void setReplaceAir(boolean z) {
        this.replaceAir = z;
    }

    public boolean isPlayerCanUse() {
        return this.playerCanUse;
    }

    public void setPlayerCanUse(boolean z) {
        this.playerCanUse = z;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Optional<String> getUsePermission() {
        return this.usePermission;
    }

    public void setUsePermission(Optional<String> optional) {
        this.usePermission = optional;
    }

    public Material getIcon() {
        return this.icon;
    }

    public void setIcon(Material material) {
        this.icon = material;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public boolean isReplaceBusy() {
        return this.replaceBusy;
    }

    public void setReplaceBusy(boolean z) {
        this.replaceBusy = z;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(int i) {
        this.sizeX = i;
    }

    public int getSizeZ() {
        return this.sizeZ;
    }

    public void setSizeZ(int i) {
        this.sizeZ = i;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(int i) {
        this.sizeY = i;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
