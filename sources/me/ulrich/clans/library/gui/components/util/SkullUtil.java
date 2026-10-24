package me.ulrich.clans.library.gui.components.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Base64;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/util/SkullUtil.class */
public final class SkullUtil {
    private static final Material SKULL = getSkullMaterial();
    private static final Gson GSON = new Gson();

    private static Material getSkullMaterial() {
        return VersionHelper.IS_ITEM_LEGACY ? Material.valueOf("SKULL_ITEM") : Material.PLAYER_HEAD;
    }

    public static ItemStack skull() {
        return VersionHelper.IS_ITEM_LEGACY ? new ItemStack(SKULL, 1, (short) 3) : new ItemStack(SKULL);
    }

    public static boolean isPlayerSkull(@NotNull ItemStack itemStack) {
        if (VersionHelper.IS_ITEM_LEGACY) {
            return itemStack.getType() == SKULL && itemStack.getDurability() == 3;
        }
        return itemStack.getType() == SKULL;
    }

    public static String getSkinUrl(String str) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3 = ((JsonObject) GSON.fromJson(new String(Base64.getDecoder().decode(str)), JsonObject.class)).get("textures");
        if (jsonElement3 == null || (jsonElement = jsonElement3.getAsJsonObject().get("SKIN")) == null || (jsonElement2 = jsonElement.getAsJsonObject().get(ComponentTreeConstants.CLICK_EVENT_URL)) == null) {
            return null;
        }
        return jsonElement2.getAsString();
    }
}
