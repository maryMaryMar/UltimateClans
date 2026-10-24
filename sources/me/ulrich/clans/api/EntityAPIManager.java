package me.ulrich.clans.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.EntityOptionsData;
import me.ulrich.clans.data.SpawnedEntityData;
import me.ulrich.clans.interfaces.EntityAPI;
import me.ulrich.clans.tasks.TaskWalkEvent;
import me.ulrich.entitywizard.entitylib.wrapper.WrapperEntity;
import me.ulrich.entitywizard.packetevents.protocol.entity.type.EntityType;
import me.ulrich.entitywizard.packetevents.protocol.player.Equipment;
import me.ulrich.entitywizard.packetevents.util.Vector3d;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/EntityAPIManager.class */
public class EntityAPIManager implements EntityAPI {
    private final Clans plugin;

    public EntityAPIManager(Clans clans) {
        this.plugin = clans;
    }

    public Clans getPlugin() {
        return this.plugin;
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void WalkTo(Clans clans, UUID uuid, int i, double d, Object obj, boolean z, boolean z2) {
        new TaskWalkEvent(clans, uuid, i, d, obj, z, z2);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public boolean isAnimal(EntityType entityType) {
        return this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(entityType);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public boolean isMonster(EntityType entityType) {
        return this.plugin.getEntityManager().jBUuLP0sWwaPyPOmogdX7l(entityType);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public boolean isMob(EntityType entityType) {
        return this.plugin.getEntityManager().ZwrsrwOCXRUscW6Q(entityType);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public boolean isAbstractEntity(EntityType entityType) {
        return this.plugin.getEntityManager().iZTqZaRK5UGoe0Z(entityType);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public boolean isItem(EntityType entityType) {
        return this.plugin.getEntityManager().xtOheRiObl4QeAl(entityType);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void createEntityMeta(WrapperEntity wrapperEntity, EntityType entityType, EntityOptionsData entityOptionsData) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(wrapperEntity, entityType, entityOptionsData);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public Optional<SpawnedEntityData> createEntity(Player player, Location location, EntityType entityType, EntityOptionsData entityOptionsData, List<Equipment> list, List<Player> list2) {
        return this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(player, location, entityType, entityOptionsData, list, list2);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public Optional<WrapperEntity> createCustomMetaEntity(EntityType entityType, EntityOptionsData entityOptionsData, me.ulrich.entitywizard.packetevents.protocol.world.Location location) {
        return this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(entityType, entityOptionsData, location);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entitySetViews(int i, List<Player> list) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, list);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entitySetViewsUUID(int i, List<UUID> list) {
        this.plugin.getEntityManager().jBUuLP0sWwaPyPOmogdX7l(i, list);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entitySetViewDistance(int i, int i2) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, i2);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entitySetInvisible(int i, boolean z) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, z);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entitySetGlowing(int i, boolean z) {
        this.plugin.getEntityManager().jBUuLP0sWwaPyPOmogdX7l(i, z);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityRename(int i, Optional<String> optional) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, optional);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityTeleport(int i, me.ulrich.entitywizard.packetevents.protocol.world.Location location, boolean z) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, location, z);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityTeleport(int i, Vector3d vector3d, float f, float f2, boolean z) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, vector3d, f, f2, z);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityRelativeMove(int i, me.ulrich.entitywizard.packetevents.protocol.world.Location location, boolean z) {
        this.plugin.getEntityManager().jBUuLP0sWwaPyPOmogdX7l(i, location, z);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityRotation(int i, float f, float f2) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, f, f2);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void equipEntity(int i, List<Equipment> list) {
        this.plugin.getEntityManager().ZwrsrwOCXRUscW6Q(i, list);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void velocityEntity(int i, Vector3d vector3d) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, vector3d);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void passegerEntity(int i, int[] iArr) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, iArr);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void animateEntity(int i, WrapperPlayServerEntityAnimation.EntityAnimationType entityAnimationType) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, entityAnimationType);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void destroyEntity(int i) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public Vector3d genVec(me.ulrich.entitywizard.packetevents.protocol.world.Location location, me.ulrich.entitywizard.packetevents.protocol.world.Location location2) {
        return this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(location, location2);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public Vector3d calculateVelocity(Vector3d vector3d, Vector3d vector3d2, int i) {
        return this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(vector3d, vector3d2, i);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityAddView(int i, Player player) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, player);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityAddView(int i, UUID uuid) {
        this.plugin.getEntityManager().v8qP8fE86HMhvNuYPFjqY(i, uuid);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityRemoveView(int i, Player player) {
        this.plugin.getEntityManager().jBUuLP0sWwaPyPOmogdX7l(i, player);
    }

    @Override // me.ulrich.clans.interfaces.EntityAPI
    public void entityRemoveView(int i, UUID uuid) {
        this.plugin.getEntityManager().jBUuLP0sWwaPyPOmogdX7l(i, uuid);
    }
}
