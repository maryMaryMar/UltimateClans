package me.ulrich.clans.manager.utils;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.library.nbtapi.NBT;
import me.ulrich.clans.library.nbtapi.NBTItem;
import me.ulrich.clans.library.nbtapi.iface.ReadWriteItemNBT;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Nbts.class */
public class Nbts {
    private static String lWC5Rwpi4aCdaNYiZ7ljm;
    private static String f5MwhXwjzlzyrbM7cznRi;
    private static final byte[] jMMMPZJD32ekz4 = {(byte) 36, (byte) 125, (byte) 254, (byte) 89, (byte) 33, (byte) 138, (byte) 160, (byte) 78, (byte) 217, (byte) 220, (byte) 109, (byte) 32, (byte) 205, (byte) 130, (byte) 74, (byte) 225};
    private static final byte[] QMF31SjipQwDReJz1vmT = {(byte) 203, (byte) 91, (byte) 111, (byte) 191, (byte) 227, (byte) 81, (byte) 22, (byte) 97, (byte) 103, (byte) 213, (byte) 96, (byte) 230, (byte) 29, (byte) 214, (byte) 50, (byte) 187, (byte) 179, (byte) 19, (byte) 214, (byte) 166, (byte) 61, (byte) 194, (byte) 228, (byte) 189, (byte) 201, (byte) 1, (byte) 112, (byte) 100, (byte) 91, (byte) 183, (byte) 95, (byte) 193};
    private static final byte[] yCjOraP5YI9jQBAM = {(byte) 167, (byte) 102, (byte) 125, (byte) 89, (byte) 192, (byte) 121, (byte) 190, (byte) 97, (byte) 97, (byte) 178, (byte) 21, (byte) 114, (byte) 187, (byte) 45, (byte) 75, (byte) 247};

    public ItemStack removeNbtString(ItemStack itemStack, String str) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR)) {
                    return itemStack;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return itemStack;
    }

    public ItemStack setNbt(ItemStack itemStack, String str, String str2) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR) && str != null && !str.isEmpty() && str2 != null) {
                    if ((VersionUtil.is(VersionUtil.VersionEnum.V120) && VersionUtil.BUILD_VERSION.intValue() >= 5) || VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                        NBT.modify(itemStack, (Consumer<ReadWriteItemNBT>) readWriteItemNBT -> {
                            readWriteItemNBT.setString(str, str2);
                        });
                        return itemStack;
                    }
                    NBTItem nBTItem = new NBTItem(itemStack);
                    nBTItem.setString(str, str2);
                    return nBTItem.getItem();
                }
            } catch (Exception e) {
                return null;
            }
        }
        return itemStack;
    }

    public ItemStack setNbt(ItemStack itemStack, String str, Integer num) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR) && str != null && !str.isEmpty()) {
                    if ((VersionUtil.is(VersionUtil.VersionEnum.V120) && VersionUtil.BUILD_VERSION.intValue() >= 5) || VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                        NBT.modify(itemStack, (Consumer<ReadWriteItemNBT>) readWriteItemNBT -> {
                            readWriteItemNBT.setInteger(str, num);
                        });
                        return itemStack;
                    }
                    NBTItem nBTItem = new NBTItem(itemStack);
                    nBTItem.setInteger(str, num);
                    return nBTItem.getItem();
                }
            } catch (Exception e) {
                return null;
            }
        }
        return itemStack;
    }

    public ItemStack setNbt(ItemStack itemStack, String str, byte b) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR) && str != null && !str.isEmpty()) {
                    if ((VersionUtil.is(VersionUtil.VersionEnum.V120) && VersionUtil.BUILD_VERSION.intValue() >= 5) || VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                        NBT.modify(itemStack, (Consumer<ReadWriteItemNBT>) readWriteItemNBT -> {
                            readWriteItemNBT.setByte(str, Byte.valueOf(b));
                        });
                        return itemStack;
                    }
                    NBTItem nBTItem = new NBTItem(itemStack);
                    nBTItem.setByte(str, Byte.valueOf(b));
                    return nBTItem.getItem();
                }
            } catch (Exception e) {
                return null;
            }
        }
        return itemStack;
    }

    public ItemStack setNbt(ItemStack itemStack, String str, boolean z) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR) && str != null && !str.isEmpty()) {
                    if ((VersionUtil.is(VersionUtil.VersionEnum.V120) && VersionUtil.BUILD_VERSION.intValue() >= 5) || VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                        NBT.modify(itemStack, (Consumer<ReadWriteItemNBT>) readWriteItemNBT -> {
                            readWriteItemNBT.setBoolean(str, Boolean.valueOf(z));
                        });
                        return itemStack;
                    }
                    NBTItem nBTItem = new NBTItem(itemStack);
                    nBTItem.setBoolean(str, Boolean.valueOf(z));
                    return nBTItem.getItem();
                }
            } catch (Exception e) {
                return null;
            }
        }
        return itemStack;
    }

    public ItemStack solveNbt(ItemStack itemStack, String str, Object obj) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR) && str != null && !str.isEmpty() && obj != null) {
                    String string = obj.toString();
                    if (isInteger(string)) {
                        return setNbt(itemStack, str, Integer.valueOf(string));
                    }
                    if (isByte(string)) {
                        return setNbt(itemStack, str, Byte.valueOf(string).byteValue());
                    }
                    return isBoolean(string) ? setNbt(itemStack, str, Boolean.valueOf(string).booleanValue()) : setNbt(itemStack, str, string);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return itemStack;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isByte(String str) {
        try {
            Byte.parseByte(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String str) {
        return yPekCspB8HV9Z75gLoY().equalsIgnoreCase(str) || FUBLYepAsh1LPIsquCnT().equalsIgnoreCase(str);
    }

    public boolean hasNbt(ItemStack itemStack, String str, String str2) {
        if (itemStack == null) {
            return false;
        }
        try {
            if (itemStack.getType().equals(Material.AIR)) {
                return false;
            }
            if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 5) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                NBTItem nBTItem = new NBTItem(itemStack);
                return (nBTItem == null || nBTItem.getString(str) == null || !nBTItem.getString(str).equals(str2)) ? false : true;
            }
            String str3 = (String) NBT.get(itemStack, readableItemNBT -> {
                return readableItemNBT.getString(str);
            });
            if (str3 != null) {
                return str3.equals(str2);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String getNbtString(ItemStack itemStack, String str) {
        if (itemStack == null) {
            return null;
        }
        try {
            if (itemStack.getType().equals(Material.AIR) || str.isEmpty() || str == null) {
                return null;
            }
            if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 5) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                NBTItem nBTItem = new NBTItem(itemStack);
                if (nBTItem.getString(str) != null) {
                    return nBTItem.getString(str);
                }
                return null;
            }
            String str2 = (String) NBT.get(itemStack, readableItemNBT -> {
                return readableItemNBT.getString(str);
            });
            if (str2 != null) {
                return str2;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public int getNbtInteger(ItemStack itemStack, String str) {
        if (itemStack == null) {
            return 0;
        }
        try {
            if (itemStack.getType().equals(Material.AIR) || str.isEmpty() || str == null) {
                return 0;
            }
            if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 5) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                NBTItem nBTItem = new NBTItem(itemStack);
                if (nBTItem.getInteger(str).intValue() > 0) {
                    return nBTItem.getInteger(str).intValue();
                }
                return 0;
            }
            Integer num = (Integer) NBT.get(itemStack, readableItemNBT -> {
                return readableItemNBT.getInteger(str);
            });
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String BvgQW7BpZM9rHW(byte[] bArr) {
        return "";
    }

    private static String yPekCspB8HV9Z75gLoY() {
        return "true";
    }

    private static String FUBLYepAsh1LPIsquCnT() {
        return "false";
    }
}
