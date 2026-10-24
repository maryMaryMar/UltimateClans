package me.ulrich.clans.library.gui.components.nbt;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/nbt/LegacyNbt.class */
public final class LegacyNbt implements NbtWrapper {
    public static final String PACKAGE_NAME = Bukkit.getServer().getClass().getPackage().getName();
    public static final String NMS_VERSION = PACKAGE_NAME.substring(PACKAGE_NAME.lastIndexOf(46) + 1);
    private static Method getStringMethod;
    private static Method setStringMethod;
    private static Method setBooleanMethod;
    private static Method hasTagMethod;
    private static Method getTagMethod;
    private static Method setTagMethod;
    private static Method removeTagMethod;
    private static Method asNMSCopyMethod;
    private static Method asBukkitCopyMethod;
    private static Constructor<?> nbtCompoundConstructor;

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    public ItemStack setString(@NotNull ItemStack itemStack, String str, String str2) {
        if (itemStack.getType() == Material.AIR) {
            return itemStack;
        }
        Object objAsNMSCopy = asNMSCopy(itemStack);
        Object tag = hasTag(objAsNMSCopy) ? getTag(objAsNMSCopy) : newNBTTagCompound();
        setString(tag, str, str2);
        setTag(objAsNMSCopy, tag);
        return asBukkitCopy(objAsNMSCopy);
    }

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    public ItemStack removeTag(@NotNull ItemStack itemStack, String str) {
        if (itemStack.getType() == Material.AIR) {
            return itemStack;
        }
        Object objAsNMSCopy = asNMSCopy(itemStack);
        Object tag = hasTag(objAsNMSCopy) ? getTag(objAsNMSCopy) : newNBTTagCompound();
        remove(tag, str);
        setTag(objAsNMSCopy, tag);
        return asBukkitCopy(objAsNMSCopy);
    }

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    public ItemStack setBoolean(@NotNull ItemStack itemStack, String str, boolean z) {
        if (itemStack.getType() == Material.AIR) {
            return itemStack;
        }
        Object objAsNMSCopy = asNMSCopy(itemStack);
        Object tag = hasTag(objAsNMSCopy) ? getTag(objAsNMSCopy) : newNBTTagCompound();
        setBoolean(tag, str, z);
        setTag(objAsNMSCopy, tag);
        return asBukkitCopy(objAsNMSCopy);
    }

    @Override // me.ulrich.clans.library.gui.components.nbt.NbtWrapper
    @Nullable
    public String getString(@NotNull ItemStack itemStack, String str) {
        if (itemStack.getType() == Material.AIR) {
            return null;
        }
        Object objAsNMSCopy = asNMSCopy(itemStack);
        return getString(hasTag(objAsNMSCopy) ? getTag(objAsNMSCopy) : newNBTTagCompound(), str);
    }

    private static void setString(Object obj, String str, String str2) {
        try {
            setStringMethod.invoke(obj, str, str2);
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
    }

    private static void setBoolean(Object obj, String str, boolean z) {
        try {
            setBooleanMethod.invoke(obj, str, Boolean.valueOf(z));
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
    }

    private static void remove(Object obj, String str) {
        try {
            removeTagMethod.invoke(obj, str);
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
    }

    private static String getString(Object obj, String str) {
        try {
            return (String) getStringMethod.invoke(obj, str);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    private static boolean hasTag(Object obj) {
        try {
            return ((Boolean) hasTagMethod.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public static Object getTag(Object obj) {
        try {
            return getTagMethod.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    private static void setTag(Object obj, Object obj2) {
        try {
            setTagMethod.invoke(obj, obj2);
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
    }

    private static Object newNBTTagCompound() {
        try {
            return nbtCompoundConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }

    public static Object asNMSCopy(ItemStack itemStack) {
        try {
            return asNMSCopyMethod.invoke(null, itemStack);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public static ItemStack asBukkitCopy(Object obj) {
        try {
            return (ItemStack) asBukkitCopyMethod.invoke(null, obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    private static Class<?> getNMSClass(String str) {
        try {
            return Class.forName("net.minecraft.server." + NMS_VERSION + "." + str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static Class<?> getCraftItemStackClass() {
        try {
            return Class.forName("org.bukkit.craftbukkit." + NMS_VERSION + ".inventory.CraftItemStack");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    static {
        try {
            getStringMethod = ((Class) Objects.requireNonNull(getNMSClass("NBTTagCompound"))).getMethod("getString", String.class);
            removeTagMethod = ((Class) Objects.requireNonNull(getNMSClass("NBTTagCompound"))).getMethod("remove", String.class);
            setStringMethod = ((Class) Objects.requireNonNull(getNMSClass("NBTTagCompound"))).getMethod("setString", String.class, String.class);
            setBooleanMethod = ((Class) Objects.requireNonNull(getNMSClass("NBTTagCompound"))).getMethod("setBoolean", String.class, Boolean.TYPE);
            hasTagMethod = ((Class) Objects.requireNonNull(getNMSClass("ItemStack"))).getMethod("hasTag", new Class[0]);
            getTagMethod = ((Class) Objects.requireNonNull(getNMSClass("ItemStack"))).getMethod("getTag", new Class[0]);
            setTagMethod = ((Class) Objects.requireNonNull(getNMSClass("ItemStack"))).getMethod("setTag", getNMSClass("NBTTagCompound"));
            nbtCompoundConstructor = ((Class) Objects.requireNonNull(getNMSClass("NBTTagCompound"))).getDeclaredConstructor(new Class[0]);
            asNMSCopyMethod = ((Class) Objects.requireNonNull(getCraftItemStackClass())).getMethod("asNMSCopy", ItemStack.class);
            asBukkitCopyMethod = ((Class) Objects.requireNonNull(getCraftItemStackClass())).getMethod("asBukkitCopy", getNMSClass("ItemStack"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
