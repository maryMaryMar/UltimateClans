package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.EntityOptionsData;
import me.ulrich.clans.data.SpawnedEntityData;
import me.ulrich.entitywizard.entitylib.wrapper.WrapperEntity;
import me.ulrich.entitywizard.packetevents.protocol.entity.type.EntityType;
import me.ulrich.entitywizard.packetevents.protocol.player.Equipment;
import me.ulrich.entitywizard.packetevents.util.Vector3d;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/EntityAPI.class */
public interface EntityAPI {
    void WalkTo(Clans clans, UUID uuid, int i, double d, Object obj, boolean z, boolean z2);

    boolean isAnimal(EntityType entityType);

    boolean isMonster(EntityType entityType);

    boolean isMob(EntityType entityType);

    boolean isAbstractEntity(EntityType entityType);

    boolean isItem(EntityType entityType);

    void createEntityMeta(WrapperEntity wrapperEntity, EntityType entityType, EntityOptionsData entityOptionsData);

    Optional<SpawnedEntityData> createEntity(Player player, Location location, EntityType entityType, EntityOptionsData entityOptionsData, List<Equipment> list, List<Player> list2);

    Optional<WrapperEntity> createCustomMetaEntity(EntityType entityType, EntityOptionsData entityOptionsData, me.ulrich.entitywizard.packetevents.protocol.world.Location location);

    void entitySetViews(int i, List<Player> list);

    void entitySetViewsUUID(int i, List<UUID> list);

    void entityAddView(int i, Player player);

    void entityAddView(int i, UUID uuid);

    void entityRemoveView(int i, Player player);

    void entityRemoveView(int i, UUID uuid);

    void entitySetViewDistance(int i, int i2);

    void entitySetInvisible(int i, boolean z);

    void entitySetGlowing(int i, boolean z);

    void entityRename(int i, Optional<String> optional);

    void entityTeleport(int i, me.ulrich.entitywizard.packetevents.protocol.world.Location location, boolean z);

    void entityTeleport(int i, Vector3d vector3d, float f, float f2, boolean z);

    void entityRelativeMove(int i, me.ulrich.entitywizard.packetevents.protocol.world.Location location, boolean z);

    void entityRotation(int i, float f, float f2);

    void equipEntity(int i, List<Equipment> list);

    void velocityEntity(int i, Vector3d vector3d);

    void passegerEntity(int i, int[] iArr);

    void animateEntity(int i, WrapperPlayServerEntityAnimation.EntityAnimationType entityAnimationType);

    void destroyEntity(int i);

    Vector3d genVec(me.ulrich.entitywizard.packetevents.protocol.world.Location location, me.ulrich.entitywizard.packetevents.protocol.world.Location location2);

    Vector3d calculateVelocity(Vector3d vector3d, Vector3d vector3d2, int i);
}
