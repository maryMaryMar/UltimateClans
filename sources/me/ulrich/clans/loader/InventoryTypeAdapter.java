package me.ulrich.clans.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/InventoryTypeAdapter.class */
public class InventoryTypeAdapter implements JsonDeserializer<Inventory>, JsonSerializer<Inventory> {
    public JsonElement serialize(Inventory inventory, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("contents", new JsonPrimitive(toBase64(inventory)));
        return jsonObject;
    }

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public Inventory deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return fromBase64(jsonElement.getAsJsonObject().get("contents").getAsString());
    }

    public static String InventoryToString(ItemStack[] itemStackArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
            bukkitObjectOutputStream.writeInt(itemStackArr.length);
            for (ItemStack itemStack : itemStackArr) {
                bukkitObjectOutputStream.writeObject(itemStack);
            }
            bukkitObjectOutputStream.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }
    }

    public static ItemStack[] StringToInventory(String str) throws IOException {
        try {
            BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(str)));
            ItemStack[] itemStackArr = new ItemStack[bukkitObjectInputStream.readInt()];
            for (int i = 0; i < itemStackArr.length; i++) {
                itemStackArr[i] = (ItemStack) bukkitObjectInputStream.readObject();
            }
            bukkitObjectInputStream.close();
            return itemStackArr;
        } catch (ClassNotFoundException e) {
            throw new IOException("Unable to decode class type.", e);
        }
    }

    public static String toBase64(Inventory inventory) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
            bukkitObjectOutputStream.writeInt(inventory.getSize());
            for (int i = 0; i < inventory.getSize(); i++) {
                bukkitObjectOutputStream.writeObject(inventory.getItem(i));
            }
            bukkitObjectOutputStream.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Cannot serialize inventory", e);
        }
    }

    public static String toBase64(ItemStack[] itemStackArr, int i) {
        Inventory inventoryCreateInventory = Bukkit.createInventory((InventoryHolder) null, i);
        inventoryCreateInventory.setContents(itemStackArr);
        return toBase64(inventoryCreateInventory);
    }

    public static Inventory fromBase64(String str) {
        try {
            BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(str)));
            Inventory inventoryCreateInventory = Bukkit.getServer().createInventory((InventoryHolder) null, bukkitObjectInputStream.readInt());
            for (int i = 0; i < inventoryCreateInventory.getSize(); i++) {
                inventoryCreateInventory.setItem(i, (ItemStack) bukkitObjectInputStream.readObject());
            }
            bukkitObjectInputStream.close();
            return inventoryCreateInventory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
