package me.ulrich.clans.library.nbtapi.handler;

import me.ulrich.clans.library.nbtapi.NBT;
import me.ulrich.clans.library.nbtapi.iface.NBTHandler;
import me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT;
import me.ulrich.clans.library.nbtapi.iface.ReadableNBT;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/handler/NBTHandlers.class */
public class NBTHandlers {
    public static final NBTHandler<ItemStack> ITEM_STACK = new NBTHandler<ItemStack>() { // from class: me.ulrich.clans.library.nbtapi.handler.NBTHandlers.1
        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public boolean fuzzyMatch(Object obj) {
            return obj instanceof ItemStack;
        }

        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public void set(ReadWriteNBT readWriteNBT, String str, ItemStack itemStack) {
            readWriteNBT.removeKey(str);
            readWriteNBT.getOrCreateCompound(str).mergeCompound(NBT.itemStackToNBT(itemStack));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public ItemStack get(ReadableNBT readableNBT, String str) {
            ReadableNBT compound = readableNBT.getCompound(str);
            if (compound != null) {
                return NBT.itemStackFromNBT(compound);
            }
            return null;
        }
    };
    public static final NBTHandler<ReadableNBT> STORE_READABLE_TAG = new NBTHandler<ReadableNBT>() { // from class: me.ulrich.clans.library.nbtapi.handler.NBTHandlers.2
        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public boolean fuzzyMatch(Object obj) {
            return obj instanceof ReadableNBT;
        }

        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public void set(ReadWriteNBT readWriteNBT, String str, ReadableNBT readableNBT) {
            readWriteNBT.removeKey(str);
            readWriteNBT.getOrCreateCompound(str).mergeCompound(readableNBT);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public ReadableNBT get(ReadableNBT readableNBT, String str) {
            ReadableNBT compound = readableNBT.getCompound(str);
            if (compound == null) {
                return null;
            }
            ReadWriteNBT readWriteNBTCreateNBTObject = NBT.createNBTObject();
            readWriteNBTCreateNBTObject.mergeCompound(compound);
            return readWriteNBTCreateNBTObject;
        }
    };
    public static final NBTHandler<ReadWriteNBT> STORE_READWRITE_TAG = new NBTHandler<ReadWriteNBT>() { // from class: me.ulrich.clans.library.nbtapi.handler.NBTHandlers.3
        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public boolean fuzzyMatch(Object obj) {
            return obj instanceof ReadWriteNBT;
        }

        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public void set(ReadWriteNBT readWriteNBT, String str, ReadWriteNBT readWriteNBT2) {
            readWriteNBT.removeKey(str);
            readWriteNBT.getOrCreateCompound(str).mergeCompound(readWriteNBT2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.nbtapi.iface.NBTHandler
        public ReadWriteNBT get(ReadableNBT readableNBT, String str) {
            ReadableNBT compound = readableNBT.getCompound(str);
            if (compound == null) {
                return null;
            }
            ReadWriteNBT readWriteNBTCreateNBTObject = NBT.createNBTObject();
            readWriteNBTCreateNBTObject.mergeCompound(compound);
            return readWriteNBTCreateNBTObject;
        }
    };
}
