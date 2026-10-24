package me.ulrich.clans.library.nbtapi;

import com.mojang.authlib.GameProfile;
import me.ulrich.clans.library.nbtapi.utils.GameprofileUtil;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ObjectCreator;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTGameProfile.class */
public class NBTGameProfile {
    @Deprecated
    public static NBTCompound toNBT(GameProfile gameProfile) {
        return MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4) ? (NBTCompound) GameprofileUtil.writeGameProfile(NBT.createNBTObject(), gameProfile) : new NBTContainer(ReflectionMethod.GAMEPROFILE_SERIALIZE.run(null, ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]), gameProfile));
    }

    @Deprecated
    public static GameProfile fromNBT(NBTCompound nBTCompound) {
        return MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_20_R4) ? GameprofileUtil.readGameProfile(nBTCompound) : (GameProfile) ReflectionMethod.GAMEPROFILE_DESERIALIZE.run(null, NBTReflectionUtil.getToCompount(nBTCompound.getCompound(), nBTCompound));
    }
}
