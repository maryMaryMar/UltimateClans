package me.ulrich.clans.qjkRaOgynIj1;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import me.ulrich.clans.Clans;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/XQWpFH32TPMOVKV5.class */
public class XQWpFH32TPMOVKV5 {
    public static void v8qP8fE86HMhvNuYPFjqY(Clans clans, ItemMeta itemMeta, String str, String str2) {
        v8qP8fE86HMhvNuYPFjqY(clans, itemMeta, str, PersistentDataType.STRING, str2);
    }

    public static String v8qP8fE86HMhvNuYPFjqY(Clans clans, ItemMeta itemMeta, String str) {
        return (String) v8qP8fE86HMhvNuYPFjqY(clans, itemMeta, str, PersistentDataType.STRING);
    }

    public static <T, Z> void v8qP8fE86HMhvNuYPFjqY(Clans clans, ItemMeta itemMeta, String str, PersistentDataType<T, Z> persistentDataType, Z z) {
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(clans, str), persistentDataType, z);
    }

    public static <T, Z> Z v8qP8fE86HMhvNuYPFjqY(Clans clans, ItemMeta itemMeta, String str, PersistentDataType<T, Z> persistentDataType) {
        Object obj;
        try {
            obj = itemMeta.getPersistentDataContainer().get(new NamespacedKey(clans, str), persistentDataType);
        } catch (Exception e) {
            obj = null;
        }
        return (Z) obj;
    }

    public static void jBUuLP0sWwaPyPOmogdX7l(Clans clans, ItemMeta itemMeta, String str) {
        itemMeta.getPersistentDataContainer().remove(new NamespacedKey(clans, str));
    }

    public static void v8qP8fE86HMhvNuYPFjqY(Clans clans, ItemMeta itemMeta) {
        Iterator it = ((Set) itemMeta.getPersistentDataContainer().getKeys().stream().filter(namespacedKey -> {
            return namespacedKey.getNamespace().equals(clans.getName().toLowerCase(Locale.ROOT));
        }).collect(Collectors.toSet())).iterator();
        while (it.hasNext()) {
            itemMeta.getPersistentDataContainer().remove((NamespacedKey) it.next());
        }
    }
}
