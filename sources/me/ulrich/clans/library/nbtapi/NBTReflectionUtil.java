package me.ulrich.clans.library.nbtapi;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import me.ulrich.clans.library.nbtapi.utils.DataFixerUtil;
import me.ulrich.clans.library.nbtapi.utils.GsonWrapper;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import me.ulrich.clans.library.nbtapi.utils.ReflectionUtil;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.CodecHelper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ObjectCreator;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTReflectionUtil.class */
public class NBTReflectionUtil {
    private static Field field_unhandledTags;
    private static Field field_handle;
    private static Object type_custom_data;
    private static Object registry_access;
    public static Codec<Object> itemstack_codec;
    public static DynamicOps<Object> nbtOps;
    public static DynamicOps<Object> nbtRegistryOps;
    public static Object problemReporter;
    private static final NBTContainer dummyNBT;

    private NBTReflectionUtil() {
    }

    public static Object getNMSEntity(Entity entity) {
        try {
            return ReflectionMethod.CRAFT_ENTITY_GET_HANDLE.run(ClassWrapper.CRAFT_ENTITY.getClazz().cast(entity), new Object[0]);
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting the NMS Entity from a Bukkit Entity!", e);
        }
    }

    public static Object readNBT(InputStream inputStream) {
        try {
            return MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R3) ? ReflectionMethod.NBTFILE_READV2.run(null, inputStream, ReflectionMethod.NBTACCOUNTER_CREATE_UNLIMITED.run(null, new Object[0])) : ReflectionMethod.NBTFILE_READ.run(null, inputStream);
        } catch (Exception e) {
            try {
                inputStream.close();
            } catch (IOException e2) {
            }
            throw new NbtApiException("Exception while reading a NBT File!", e);
        }
    }

    public static Object writeNBT(Object obj, OutputStream outputStream) {
        try {
            return ReflectionMethod.NBTFILE_WRITE.run(null, obj, outputStream);
        } catch (Exception e) {
            throw new NbtApiException("Exception while writing NBT!", e);
        }
    }

    public static Object getCraftItemHandle(ItemStack itemStack) {
        try {
            return field_handle.get(itemStack);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new NbtApiException("Error getting handle from " + itemStack.getClass(), e);
        }
    }

    public static void writeApiNBT(NBTCompound nBTCompound, OutputStream outputStream) {
        try {
            Object resolvedObject = nBTCompound.getResolvedObject();
            if (resolvedObject == null) {
                resolvedObject = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            }
            ReflectionMethod.NBTFILE_WRITE.run(null, resolvedObject, outputStream);
        } catch (Exception e) {
            throw new NbtApiException("Exception while writing NBT!", e);
        }
    }

    public static Object getItemRootNBTTagCompound(Object obj) {
        try {
            if (!MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4)) {
                return ReflectionMethod.NMSITEM_GETTAG.run(obj, new Object[0]);
            }
            Object objRun = ReflectionMethod.NMSDATACOMPONENTHOLDER_GET.run(obj, type_custom_data);
            if (objRun == null) {
                return null;
            }
            return ReflectionMethod.NMSCUSTOMDATA_GETCOPY.run(objRun, new Object[0]);
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting an Itemstack's NBTCompound!", e);
        }
    }

    public static void setItemStackCompound(Object obj, Object obj2) {
        if (!MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4)) {
            ReflectionMethod.ITEMSTACK_SET_TAG.run(obj, obj2);
        } else if (obj2 == null) {
            ReflectionMethod.NMSITEM_SET.run(obj, type_custom_data, null);
        } else {
            ReflectionMethod.NMSITEM_SET.run(obj, type_custom_data, ObjectCreator.NMS_CUSTOMDATA.getInstance(obj2));
        }
    }

    public static Object convertNBTCompoundtoNMSItem(NBTCompound nBTCompound) {
        try {
            Object toCompount = getToCompount(nBTCompound.getCompound(), nBTCompound);
            if (!MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4)) {
                return MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_11_R1.getVersionId() ? ObjectCreator.NMS_COMPOUNDFROMITEM.getInstance(toCompount) : ReflectionMethod.NMSITEM_CREATESTACK.run(null, toCompount);
            }
            if (nBTCompound.hasTag("DataVersion", NBTType.NBTTagInt)) {
                int iIntValue = nBTCompound.getInteger("DataVersion").intValue();
                int currentVersion = DataFixerUtil.getCurrentVersion();
                if (iIntValue < currentVersion) {
                    toCompount = DataFixerUtil.fixUpRawItemData(toCompount, iIntValue, currentVersion);
                }
            } else if (nBTCompound.hasTag("tag") || nBTCompound.hasTag("Count")) {
                toCompount = DataFixerUtil.fixUpRawItemData(toCompount, 3700, DataFixerUtil.getCurrentVersion());
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                return CodecHelper.convertNbtToItemStack(toCompount);
            }
            return MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R4) ? ((Optional) ReflectionMethod.NMSITEM_LOAD_MODERN.run(null, registry_access, toCompount)).orElse(null) : ReflectionMethod.NMSITEM_LOAD.run(null, registry_access, toCompount);
        } catch (Exception e) {
            throw new NbtApiException("Exception while converting NBTCompound to NMS ItemStack! " + ((Object) null), e);
        }
    }

    public static NBTContainer convertNMSItemtoNBTCompound(Object obj) {
        NBTContainer nBTContainer;
        try {
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                nBTContainer = new NBTContainer(CodecHelper.convertItemStackToNbt(obj));
            } else {
                nBTContainer = MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4) ? new NBTContainer(ReflectionMethod.NMSITEM_SAVE_MODERN.run(obj, registry_access)) : new NBTContainer(ReflectionMethod.NMSITEM_SAVE.run(obj, ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0])));
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_12_R1)) {
                nBTContainer.setInteger("DataVersion", Integer.valueOf(DataFixerUtil.getCurrentVersion()));
            }
            return nBTContainer;
        } catch (Exception e) {
            throw new NbtApiException("Exception while converting NMS ItemStack to NBTCompound!", e);
        }
    }

    @Deprecated
    public static Map<String, Object> getUnhandledNBTTags(ItemMeta itemMeta) {
        try {
            return (Map) field_unhandledTags.get(itemMeta);
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting unhandled tags from ItemMeta!", e);
        }
    }

    public static Object getEntityNBTTagCompound(Object obj) {
        Object objRun;
        try {
            Object objNewInstance = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                Object objRun2 = ReflectionMethod.NMS_GET_TAG_VALUE_OUTPUT.run(null, problemReporter, registry_access);
                ReflectionMethod.NMS_ENTITY_GET_NBT_1216.run(obj, objRun2);
                objRun = ReflectionMethod.NMS_TAG_VALUE_OUTPUT_TO_TAG_COMPOUND.run(objRun2, new Object[0]);
            } else {
                objRun = ReflectionMethod.NMS_ENTITY_GET_NBT.run(obj, objNewInstance);
            }
            if (objRun == null) {
                objRun = objNewInstance;
            }
            return objRun;
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting NBTCompound from NMS Entity!", e);
        }
    }

    public static Object setEntityNBTTag(Object obj, Object obj2) {
        try {
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                ReflectionMethod.NMS_ENTITY_SET_NBT_1216.run(obj2, ReflectionMethod.NMS_GET_TAG_VALUE_INPUT.run(null, problemReporter, registry_access, obj));
            } else {
                ReflectionMethod.NMS_ENTITY_SET_NBT.run(obj2, obj);
            }
            return obj2;
        } catch (Exception e) {
            throw new NbtApiException("Exception while setting the NBTCompound of an Entity", e);
        }
    }

    public static Object getTileEntityNBTTagCompound(BlockState blockState) {
        Object objRun;
        Object objNewInstance;
        try {
            Object objRun2 = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(ClassWrapper.CRAFT_WORLD.getClazz().cast(blockState.getWorld()), new Object[0]);
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                objRun = ReflectionMethod.NMS_WORLD_GET_TILEENTITY_1_7_10.run(objRun2, Integer.valueOf(blockState.getX()), Integer.valueOf(blockState.getY()), Integer.valueOf(blockState.getZ()));
            } else {
                objRun = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(objRun2, ObjectCreator.NMS_BLOCKPOSITION.getInstance(Integer.valueOf(blockState.getX()), Integer.valueOf(blockState.getY()), Integer.valueOf(blockState.getZ())));
            }
            if (objRun == null) {
                throw new NbtApiException("The passed BlockState(" + blockState.getType() + ") doesn't point to a BlockEntity. Only BlockEntities like Chest/Signs/Furnance/etc have NBT.");
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                Object objRun3 = ReflectionMethod.NMS_GET_TAG_VALUE_OUTPUT.run(null, problemReporter, registry_access);
                ReflectionMethod.TILEENTITY_GET_NBT_1216.run(objRun, objRun3);
                objNewInstance = ReflectionMethod.NMS_TAG_VALUE_OUTPUT_TO_TAG_COMPOUND.run(objRun3, new Object[0]);
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4)) {
                objNewInstance = ReflectionMethod.TILEENTITY_GET_NBT_1205.run(objRun, registry_access);
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_18_R1)) {
                objNewInstance = ReflectionMethod.TILEENTITY_GET_NBT_1181.run(objRun, new Object[0]);
            } else {
                objNewInstance = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
                ReflectionMethod.TILEENTITY_GET_NBT.run(objRun, objNewInstance);
            }
            if (objNewInstance == null) {
                throw new NbtApiException("Unable to get NBTCompound from TileEntity! " + blockState + " " + objRun);
            }
            return objNewInstance;
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting NBTCompound from TileEntity!", e);
        }
    }

    public static void setTileEntityNBTTagCompound(BlockState blockState, Object obj) {
        Object objRun;
        try {
            Object objRun2 = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(ClassWrapper.CRAFT_WORLD.getClazz().cast(blockState.getWorld()), new Object[0]);
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                objRun = ReflectionMethod.NMS_WORLD_GET_TILEENTITY_1_7_10.run(objRun2, Integer.valueOf(blockState.getX()), Integer.valueOf(blockState.getY()), Integer.valueOf(blockState.getZ()));
            } else {
                objRun = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(objRun2, ObjectCreator.NMS_BLOCKPOSITION.getInstance(Integer.valueOf(blockState.getX()), Integer.valueOf(blockState.getY()), Integer.valueOf(blockState.getZ())));
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                ReflectionMethod.TILEENTITY_SET_NBT_1216.run(objRun, ReflectionMethod.NMS_GET_TAG_VALUE_INPUT.run(null, problemReporter, registry_access, obj));
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4)) {
                ReflectionMethod.TILEENTITY_SET_NBT_1205.run(objRun, obj, registry_access);
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_17_R1)) {
                ReflectionMethod.TILEENTITY_SET_NBT.run(objRun, obj);
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R1)) {
                ReflectionMethod.TILEENTITY_SET_NBT_LEGACY1161.run(objRun, ReflectionMethod.TILEENTITY_GET_BLOCKDATA.run(objRun, new Object[0]), obj);
            } else {
                ReflectionMethod.TILEENTITY_SET_NBT_LEGACY1151.run(objRun, obj);
            }
        } catch (Exception e) {
            throw new NbtApiException("Exception while setting NBTData for a TileEntity!", e);
        }
    }

    public static Object getSubNBTTagCompound(Object obj, String str) {
        try {
            if (!((Boolean) ReflectionMethod.COMPOUND_HAS_KEY.run(obj, str)).booleanValue()) {
                throw new NbtApiException("Tried getting invalid compound '" + str + "' from '" + obj + "'!");
            }
            Object objRun = ReflectionMethod.COMPOUND_GET_COMPOUND.run(obj, str);
            return objRun instanceof Optional ? ((Optional) objRun).orElse(null) : objRun;
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting NBT subcompounds!", e);
        }
    }

    public static void addNBTTagCompound(NBTCompound nBTCompound, String str) {
        if (str == null) {
            remove(nBTCompound, str);
            return;
        }
        Object compound = nBTCompound.getCompound();
        if (compound == null) {
            compound = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (validCompound(nBTCompound)) {
            try {
                ReflectionMethod.COMPOUND_SET.run(getToCompount(compound, nBTCompound), str, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance());
                nBTCompound.setCompound(compound);
            } catch (Exception e) {
                throw new NbtApiException("Exception while adding a Compound!", e);
            }
        }
    }

    public static boolean validCompound(NBTCompound nBTCompound) {
        Object compound = nBTCompound.getCompound();
        if (compound instanceof Optional) {
            compound = ((Optional) compound).orElse(null);
        }
        if (compound == null) {
            compound = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        Object toCompount = getToCompount(compound, nBTCompound);
        nBTCompound.setResolvedObject(toCompount);
        return toCompount != null;
    }

    public static Object getToCompount(Object obj, NBTCompound nBTCompound) {
        ArrayDeque arrayDeque = new ArrayDeque();
        while (nBTCompound.getParent() != null) {
            arrayDeque.add(nBTCompound.getName());
            nBTCompound = nBTCompound.getParent();
        }
        if (obj instanceof Optional) {
            obj = ((Optional) obj).orElse(null);
        }
        while (!arrayDeque.isEmpty()) {
            String str = (String) arrayDeque.pollLast();
            obj = getSubNBTTagCompound(obj, str);
            if (obj instanceof Optional) {
                obj = ((Optional) obj).orElse(null);
            }
            if (obj == null) {
                throw new NbtApiException("Unable to find tag '" + str + "' in " + obj);
            }
        }
        return obj;
    }

    public static void mergeOtherNBTCompound(NBTCompound nBTCompound, NBTCompound nBTCompound2) {
        Object resolvedObject = nBTCompound2.getResolvedObject();
        if (resolvedObject == null) {
            return;
        }
        Object compound = nBTCompound.getCompound();
        if (compound == null) {
            compound = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!validCompound(nBTCompound)) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        try {
            ReflectionMethod.COMPOUND_MERGE.run(getToCompount(compound, nBTCompound), resolvedObject);
            nBTCompound.setCompound(compound);
        } catch (Exception e) {
            throw new NbtApiException("Exception while merging two NBTCompounds!", e);
        }
    }

    public static void set(NBTCompound nBTCompound, String str, Object obj) {
        if (obj == null) {
            remove(nBTCompound, str);
            return;
        }
        Object compound = nBTCompound.getCompound();
        if (compound == null) {
            compound = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!validCompound(nBTCompound)) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        try {
            ReflectionMethod.COMPOUND_SET.run(getToCompount(compound, nBTCompound), str, obj);
            nBTCompound.setCompound(compound);
        } catch (Exception e) {
            throw new NbtApiException("Exception while setting key '" + str + "' to '" + obj + "'!", e);
        }
    }

    public static <T> NBTList<T> getList(NBTCompound nBTCompound, String str, NBTType nBTType, Class<T> cls) {
        Object objRun;
        Object resolvedObject = nBTCompound.getResolvedObject();
        if (resolvedObject == null) {
            resolvedObject = dummyNBT.getCompound();
        }
        try {
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R4)) {
                objRun = ReflectionMethod.COMPOUND_GET_LIST.run(resolvedObject, str);
                if (objRun instanceof Optional) {
                    objRun = ((Optional) objRun).orElse(null);
                }
                if (objRun == null) {
                    objRun = ClassWrapper.NMS_NBTTAGLIST.getClazz().newInstance();
                }
            } else {
                objRun = ReflectionMethod.COMPOUND_GET_LIST_LEGACY.run(resolvedObject, str, Integer.valueOf(nBTType.getId()));
            }
            if (cls == String.class) {
                return new NBTStringList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == NBTListCompound.class) {
                return new NBTCompoundList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == Integer.class) {
                return new NBTIntegerList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == Float.class) {
                return new NBTFloatList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == Double.class) {
                return new NBTDoubleList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == Long.class) {
                return new NBTLongList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == int[].class) {
                return new NBTIntArrayList(nBTCompound, str, nBTType, objRun);
            }
            if (cls == UUID.class) {
                return new NBTUUIDList(nBTCompound, str, nBTType, objRun);
            }
            return null;
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting a list with the type '" + nBTType + "'!", e);
        }
    }

    public static NBTType getListType(NBTCompound nBTCompound, String str) {
        Field declaredField;
        Object resolvedObject = nBTCompound.getResolvedObject();
        if (resolvedObject == null) {
            resolvedObject = dummyNBT.getCompound();
        }
        try {
            Object objRun = ReflectionMethod.COMPOUND_GET.run(resolvedObject, str);
            if (!MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R4)) {
                try {
                    declaredField = objRun.getClass().getDeclaredField(MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_17_R1) ? "w" : "type");
                } catch (NoSuchFieldException e) {
                    declaredField = objRun.getClass().getDeclaredField("type");
                }
                declaredField.setAccessible(true);
                return NBTType.valueOf(declaredField.getByte(objRun));
            }
            if (objRun instanceof Optional) {
                objRun = ((Optional) objRun).orElse(null);
            }
            if (objRun != null && !new NBTStringList(nBTCompound, str, NBTType.NBTTagString, objRun).isEmpty()) {
                Object objRun2 = ReflectionMethod.LIST_GET.run(objRun, 0);
                if (objRun2 instanceof Optional) {
                    objRun2 = ((Optional) objRun2).orElse(null);
                }
                return objRun2 == null ? NBTType.NBTTagEnd : NBTType.fromName((String) ReflectionMethod.TAGTYPE_GET_NAME.run(ReflectionMethod.TAGTYPE_OWN_TYPE.run(objRun2, new Object[0]), new Object[0]));
            }
            return NBTType.NBTTagEnd;
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting the list type!", e2);
        }
    }

    public static Object getEntry(NBTCompound nBTCompound, String str) {
        try {
            return ReflectionMethod.COMPOUND_GET.run(nBTCompound.getResolvedObject(), str);
        } catch (Exception e) {
            throw new NbtApiException("Exception while getting an Entry!", e);
        }
    }

    public static void setObject(NBTCompound nBTCompound, String str, Object obj) {
        if (MinecraftVersion.hasGsonSupport()) {
            try {
                setData(nBTCompound, ReflectionMethod.COMPOUND_SET_STRING, str, GsonWrapper.getString(obj));
            } catch (Exception e) {
                throw new NbtApiException("Exception while setting the Object '" + obj + "'!", e);
            }
        }
    }

    public static <T> T getObject(NBTCompound nBTCompound, String str, Class<T> cls) {
        String str2;
        if (MinecraftVersion.hasGsonSupport() && (str2 = (String) getData(nBTCompound, ReflectionMethod.COMPOUND_GET_STRING, str)) != null) {
            return (T) GsonWrapper.deserializeJson(str2, cls);
        }
        return null;
    }

    public static void remove(NBTCompound nBTCompound, String str) {
        Object compound = nBTCompound.getCompound();
        if (compound != null && validCompound(nBTCompound)) {
            ReflectionMethod.COMPOUND_REMOVE_KEY.run(getToCompount(compound, nBTCompound), str);
            nBTCompound.setCompound(compound);
        }
    }

    public static Set<String> getKeys(NBTCompound nBTCompound) {
        Object resolvedObject = nBTCompound.getResolvedObject();
        return resolvedObject == null ? Collections.emptySet() : (Set) ReflectionMethod.COMPOUND_GET_KEYS.run(resolvedObject, new Object[0]);
    }

    public static void setData(NBTCompound nBTCompound, ReflectionMethod reflectionMethod, String str, Object obj) {
        if (obj == null) {
            remove(nBTCompound, str);
            return;
        }
        Object compound = nBTCompound.getCompound();
        if (compound == null) {
            compound = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!validCompound(nBTCompound)) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        reflectionMethod.run(getToCompount(compound, nBTCompound), str, obj);
        nBTCompound.setCompound(compound);
    }

    public static Object getData(NBTCompound nBTCompound, ReflectionMethod reflectionMethod, String str) {
        Object resolvedObject = nBTCompound.getResolvedObject();
        if (resolvedObject == null) {
            resolvedObject = dummyNBT.getCompound();
        }
        if (resolvedObject instanceof Optional) {
            resolvedObject = ((Optional) resolvedObject).orElseGet(() -> {
                return dummyNBT.getCompound();
            });
        }
        Object objRun = reflectionMethod.run(resolvedObject, str);
        return objRun instanceof Optional ? ((Optional) objRun).orElseGet(() -> {
            return getDefaultValue(reflectionMethod);
        }) : objRun;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getDefaultValue(ReflectionMethod reflectionMethod) {
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_STRING) {
            return "";
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_BYTE) {
            return (byte) 0;
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_SHORT) {
            return (short) 0;
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_BOOLEAN) {
            return false;
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_INT) {
            return 0;
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_LONG) {
            return 0L;
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_FLOAT) {
            return Float.valueOf(0.0f);
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_DOUBLE) {
            return Double.valueOf(0.0d);
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_BYTEARRAY) {
            return new byte[0];
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_INTARRAY) {
            return new int[0];
        }
        if (reflectionMethod == ReflectionMethod.COMPOUND_GET_LONGARRAY) {
            return new long[0];
        }
        return null;
    }

    static {
        field_unhandledTags = null;
        field_handle = null;
        type_custom_data = null;
        registry_access = null;
        itemstack_codec = null;
        nbtOps = null;
        nbtRegistryOps = null;
        problemReporter = null;
        try {
            field_unhandledTags = ClassWrapper.CRAFT_METAITEM.getClazz().getDeclaredField("unhandledTags");
            field_unhandledTags.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
        try {
            field_handle = ClassWrapper.CRAFT_ITEMSTACK.getClazz().getDeclaredField("handle");
            field_handle.setAccessible(true);
        } catch (NoSuchFieldException e2) {
        }
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4)) {
            try {
                type_custom_data = ReflectionUtil.getMappedField(ClassWrapper.NMS_DATACOMPONENTS.getClazz(), "net.minecraft.core.component.DataComponents#CUSTOM_DATA").get(null);
            } catch (Exception e3) {
                MinecraftVersion.getLogger().log(Level.WARNING, "Unable to find DataComponents#CUSTOM_DATA, NBTApi will not be able to read/write custom data on 1.20+", (Throwable) e3);
            }
            try {
                registry_access = ReflectionMethod.NMSSERVER_GETREGISTRYACCESS.run(ReflectionMethod.NMSSERVER_GETSERVER.run(Bukkit.getServer(), new Object[0]), new Object[0]);
                itemstack_codec = (Codec) ReflectionUtil.getMappedField(ClassWrapper.NMS_ITEMSTACK.getClazz(), "net.minecraft.world.item.ItemStack#CODEC").get(null);
                nbtOps = (DynamicOps) ReflectionUtil.getMappedField(ClassWrapper.NMS_NBTOPS.getClazz(), "net.minecraft.nbt.NbtOps#INSTANCE").get(null);
                if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R5)) {
                    nbtRegistryOps = (DynamicOps) ReflectionMethod.GET_SERIALIZATION_CONTEXT.run(registry_access, nbtOps);
                    problemReporter = ReflectionUtil.getMappedField(ClassWrapper.NMS_PROBLEM_REPORTER.getClazz(), "net.minecraft.util.ProblemReporter#DISCARDING").get(null);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        dummyNBT = new NBTContainer();
    }
}
