package me.ulrich.clans.library.gui.builder.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.components.util.SkullUtil;
import me.ulrich.clans.library.gui.components.util.VersionHelper;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/SkullBuilder.class */
public final class SkullBuilder extends BaseItemBuilder<SkullBuilder> {
    private static final Field PROFILE_FIELD;

    SkullBuilder(@NotNull NameLoreHandler nameLoreHandler) {
        super(SkullUtil.skull(), nameLoreHandler);
    }

    SkullBuilder(@NotNull ItemStack itemStack, @NotNull NameLoreHandler nameLoreHandler) {
        super(itemStack, nameLoreHandler);
        if (!SkullUtil.isPlayerSkull(itemStack)) {
            throw new GuiException("SkullBuilder requires the material to be a PLAYER_HEAD/SKULL_ITEM!");
        }
    }

    @Contract("_, _ -> this")
    @NotNull
    public SkullBuilder texture(@NotNull String str, @NotNull UUID uuid) {
        if (!SkullUtil.isPlayerSkull(getItemStack())) {
            return this;
        }
        if (!VersionHelper.IS_PLAYER_PROFILE_API) {
            if (PROFILE_FIELD == null) {
                return this;
            }
            SkullMeta meta = getMeta();
            GameProfile gameProfile = new GameProfile(uuid, "");
            gameProfile.getProperties().put("textures", new Property("textures", str));
            try {
                PROFILE_FIELD.set(meta, gameProfile);
                setMeta(meta);
                return this;
            } catch (IllegalAccessException | IllegalArgumentException e) {
                throw new GuiException("Failed to set profile field!", e);
            }
        }
        String skinUrl = SkullUtil.getSkinUrl(str);
        if (skinUrl == null) {
            return this;
        }
        SkullMeta meta2 = getMeta();
        PlayerProfile playerProfileCreatePlayerProfile = Bukkit.createPlayerProfile(uuid, "");
        PlayerTextures textures = playerProfileCreatePlayerProfile.getTextures();
        try {
            textures.setSkin(new URL(skinUrl));
            playerProfileCreatePlayerProfile.setTextures(textures);
            meta2.setOwnerProfile(playerProfileCreatePlayerProfile);
            setMeta(meta2);
            return this;
        } catch (MalformedURLException e2) {
            throw new GuiException("Failed to set texture url!", e2);
        }
    }

    @Contract("_ -> this")
    @NotNull
    public SkullBuilder texture(@NotNull String str) {
        return texture(str, UUID.randomUUID());
    }

    @Contract("_ -> this")
    @NotNull
    public SkullBuilder owner(@NotNull OfflinePlayer offlinePlayer) {
        if (!SkullUtil.isPlayerSkull(getItemStack())) {
            return this;
        }
        SkullMeta meta = getMeta();
        if (VersionHelper.IS_SKULL_OWNER_LEGACY) {
            meta.setOwner(offlinePlayer.getName());
        } else {
            meta.setOwningPlayer(offlinePlayer);
        }
        setMeta(meta);
        return this;
    }

    static {
        try {
            Field declaredField = SkullUtil.skull().getItemMeta().getClass().getDeclaredField("profile");
            declaredField.setAccessible(true);
            PROFILE_FIELD = declaredField;
        } catch (NoSuchFieldException e) {
            throw new GuiException("Failed to find profile field in SkullMeta!", e);
        }
    }
}
