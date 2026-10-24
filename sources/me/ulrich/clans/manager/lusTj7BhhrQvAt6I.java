package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.EntityOptionsData;
import me.ulrich.clans.data.SpawnedEntityData;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.entitywizard.entitylib.EntityLib;
import me.ulrich.entitywizard.entitylib.meta.EntityMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.horse.CamelMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.horse.HorseMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.horse.LlamaMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.horse.MuleMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.horse.SkeletonHorseMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.horse.ZombieHorseMeta;
import me.ulrich.entitywizard.entitylib.meta.mobs.monster.zombie.ZombieMeta;
import me.ulrich.entitywizard.entitylib.meta.other.ArmorStandMeta;
import me.ulrich.entitywizard.entitylib.meta.other.EndCrystalMeta;
import me.ulrich.entitywizard.entitylib.wrapper.WrapperEntity;
import me.ulrich.entitywizard.packetevents.PacketEvents;
import me.ulrich.entitywizard.packetevents.event.SimplePacketListenerAbstract;
import me.ulrich.entitywizard.packetevents.libs.net.kyori.adventure.text.Component;
import me.ulrich.entitywizard.packetevents.libs.net.kyori.adventure.text.TextComponent;
import me.ulrich.entitywizard.packetevents.libs.net.kyori.adventure.text.format.Style;
import me.ulrich.entitywizard.packetevents.libs.net.kyori.adventure.text.format.TextDecoration;
import me.ulrich.entitywizard.packetevents.libs.net.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.entitywizard.packetevents.manager.server.ServerVersion;
import me.ulrich.entitywizard.packetevents.manager.server.VersionComparison;
import me.ulrich.entitywizard.packetevents.protocol.entity.data.EntityDataTypes;
import me.ulrich.entitywizard.packetevents.protocol.entity.type.EntityType;
import me.ulrich.entitywizard.packetevents.protocol.entity.type.EntityTypes;
import me.ulrich.entitywizard.packetevents.protocol.particle.Particle;
import me.ulrich.entitywizard.packetevents.protocol.particle.type.ParticleTypes;
import me.ulrich.entitywizard.packetevents.protocol.player.Equipment;
import me.ulrich.entitywizard.packetevents.protocol.world.Location;
import me.ulrich.entitywizard.packetevents.util.SpigotConversionUtil;
import me.ulrich.entitywizard.packetevents.util.Vector3d;
import me.ulrich.entitywizard.packetevents.util.Vector3f;
import me.ulrich.entitywizard.packetevents.wrapper.PacketWrapper;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityAnimation;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityEquipment;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityRelativeMove;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityTeleport;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityVelocity;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerParticle;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerSetPassengers;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerUpdateViewDistance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/lusTj7BhhrQvAt6I.class */
public class lusTj7BhhrQvAt6I {
    private List<SimplePacketListenerAbstract> v8qP8fE86HMhvNuYPFjqY = new ArrayList();
    private me.ulrich.clans.qjkRaOgynIj1.ZRp1tak21UvNaOVCtFx jBUuLP0sWwaPyPOmogdX7l;
    private Clans ZwrsrwOCXRUscW6Q;
    private static String ckj42cLJQpkLREQiPG;
    private static String LEC6f44omB4OOon1YNtf;
    private static volatile String UX1cIibcPVw1OVMEou6m;
    private static final byte[] dqfZwIlUrxL0mCPExW = {(byte) 3, (byte) 191, (byte) 50, (byte) 154, (byte) 205, (byte) 50, (byte) 23, (byte) 217, (byte) 133, (byte) 37, (byte) 205, (byte) 98, (byte) 222, (byte) 110, (byte) 96, (byte) 67};
    private static final byte[] bnBbQxdAsAj1A0rpHkk = {(byte) 120, (byte) 240, (byte) 121, (byte) 233, (byte) 234, (byte) 132, (byte) 159, (byte) 52, (byte) 41, (byte) 211, (byte) 67, (byte) 57, (byte) 95, (byte) 69, (byte) 67, (byte) 128, (byte) 170, (byte) 134, (byte) 253, (byte) 198, (byte) 70, (byte) 204, (byte) 255, (byte) 131, (byte) 248, (byte) 238, (byte) 155, (byte) 149, (byte) 77, (byte) 248, (byte) 51, (byte) 186};
    private static final byte[] XhszkCGeaex5MW = {(byte) 132, (byte) 158, (byte) 7, (byte) 39, (byte) 217, (byte) 142, (byte) 10, (byte) 125, (byte) 43, (byte) 154, (byte) 83, (byte) 156, (byte) 51, (byte) 141, (byte) 48, (byte) 43, (byte) 70, (byte) 97, (byte) 65, (byte) 0, (byte) 135, (byte) 138, (byte) 246, (byte) 144, (byte) 54, (byte) 38, (byte) 0, (byte) 177, (byte) 133, (byte) 85, (byte) 214, (byte) 70};
    private static final byte[] p4REpuC51yxsO2YJccaw = {(byte) 105, (byte) 212, (byte) 107, (byte) 190, (byte) 159, (byte) 15, (byte) 137, (byte) 165, (byte) 180, (byte) 3, (byte) 1, (byte) 202, (byte) 174, (byte) 240, (byte) 220, (byte) 201};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/lusTj7BhhrQvAt6I$Ijap9SQKkijXSxP5.class */
    public class Ijap9SQKkijXSxP5 {
        private Location jBUuLP0sWwaPyPOmogdX7l;
        private double ZwrsrwOCXRUscW6Q;
        private double iZTqZaRK5UGoe0Z;

        public Ijap9SQKkijXSxP5(Location location, double d, double d2) {
            this.ZwrsrwOCXRUscW6Q = d;
            this.iZTqZaRK5UGoe0Z = d2;
            this.jBUuLP0sWwaPyPOmogdX7l = location;
        }

        public double v8qP8fE86HMhvNuYPFjqY() {
            return this.ZwrsrwOCXRUscW6Q;
        }

        public double jBUuLP0sWwaPyPOmogdX7l() {
            return this.iZTqZaRK5UGoe0Z;
        }

        public Location ZwrsrwOCXRUscW6Q() {
            return this.jBUuLP0sWwaPyPOmogdX7l;
        }
    }

    public lusTj7BhhrQvAt6I(Clans clans) {
        this.jBUuLP0sWwaPyPOmogdX7l = null;
        this.ZwrsrwOCXRUscW6Q = clans;
        me.ulrich.clans.tjCyMSV004ze7Mc.UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfH = new me.ulrich.clans.tjCyMSV004ze7Mc.UsEbiuprSHpNw3qjITfH(clans);
        PacketEvents.getAPI().getEventManager().registerListener(usEbiuprSHpNw3qjITfH);
        this.v8qP8fE86HMhvNuYPFjqY.add(usEbiuprSHpNw3qjITfH);
        this.jBUuLP0sWwaPyPOmogdX7l = new me.ulrich.clans.qjkRaOgynIj1.ZRp1tak21UvNaOVCtFx();
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        EntityLib.getApi().getDefaultContainer().clearEntities(true);
        if (iZTqZaRK5UGoe0Z() != null) {
            iZTqZaRK5UGoe0Z().iterator().forEachRemaining(simplePacketListenerAbstract -> {
                PacketEvents.getAPI().getEventManager().unregisterListener(simplePacketListenerAbstract);
            });
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l() {
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(EntityType entityType) {
        return this.jBUuLP0sWwaPyPOmogdX7l.jBUuLP0sWwaPyPOmogdX7l().contains(entityType);
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(EntityType entityType) {
        return this.jBUuLP0sWwaPyPOmogdX7l.ZwrsrwOCXRUscW6Q().contains(entityType);
    }

    public boolean ZwrsrwOCXRUscW6Q(EntityType entityType) {
        return this.jBUuLP0sWwaPyPOmogdX7l.ZwrsrwOCXRUscW6Q().contains(entityType) || this.jBUuLP0sWwaPyPOmogdX7l.jBUuLP0sWwaPyPOmogdX7l().contains(entityType) || this.jBUuLP0sWwaPyPOmogdX7l.xtOheRiObl4QeAl().contains(entityType);
    }

    public boolean iZTqZaRK5UGoe0Z(EntityType entityType) {
        return this.jBUuLP0sWwaPyPOmogdX7l.iZTqZaRK5UGoe0Z().contains(entityType);
    }

    public boolean xtOheRiObl4QeAl(EntityType entityType) {
        return this.jBUuLP0sWwaPyPOmogdX7l.zJnaNCVQSgEShq().contains(entityType);
    }

    public void v8qP8fE86HMhvNuYPFjqY(WrapperEntity wrapperEntity, EntityType entityType, EntityOptionsData entityOptionsData) {
        EntityMeta entityMeta;
        if (wrapperEntity == null || (entityMeta = wrapperEntity.getEntityMeta()) == null) {
            return;
        }
        try {
            entityMeta.setHasNoGravity(true);
            if (entityType == EntityTypes.HORSE || entityType == EntityTypes.DONKEY || entityType == EntityTypes.MULE || entityType == EntityTypes.LLAMA || entityType == EntityTypes.PIG || entityType == EntityTypes.STRIDER || entityType == EntityTypes.CAMEL || entityType == EntityTypes.SKELETON_HORSE || entityType == EntityTypes.ZOMBIE_HORSE) {
                if (entityType.equals(EntityTypes.HORSE)) {
                    ((HorseMeta) entityMeta).setTamed(true);
                } else if (entityType.equals(EntityTypes.DONKEY)) {
                } else if (entityType.equals(EntityTypes.MULE)) {
                    ((MuleMeta) entityMeta).setTamed(true);
                } else if (entityType.equals(EntityTypes.LLAMA)) {
                    ((LlamaMeta) entityMeta).setTamed(true);
                } else if (!entityType.equals(EntityTypes.PIG)) {
                    if (entityType.equals(EntityTypes.STRIDER)) {
                    } else if (entityType.equals(EntityTypes.CAMEL)) {
                        ((CamelMeta) entityMeta).setTamed(entityOptionsData.isTamed());
                    } else if (entityType.equals(EntityTypes.SKELETON_HORSE)) {
                        ((SkeletonHorseMeta) entityMeta).setTamed(entityOptionsData.isTamed());
                    } else if (entityType.equals(EntityTypes.ZOMBIE_HORSE)) {
                        ((ZombieHorseMeta) entityMeta).setTamed(entityOptionsData.isTamed());
                    }
                }
            }
            if (entityType.equals(EntityTypes.ZOMBIE)) {
                ((ZombieMeta) entityMeta).setBaby(entityOptionsData.isBaby());
                return;
            }
            if (entityType.equals(EntityTypes.ARMOR_STAND)) {
                ArmorStandMeta armorStandMeta = (ArmorStandMeta) entityMeta;
                armorStandMeta.setHasNoBasePlate(!entityOptionsData.isBase());
                armorStandMeta.setSmall(entityOptionsData.isBaby());
                armorStandMeta.setHasArms(entityOptionsData.isArms());
                return;
            }
            if (entityType.equals(EntityTypes.END_CRYSTAL)) {
                ((EndCrystalMeta) entityMeta).setShowingBottom(entityOptionsData.isBase());
            } else if (entityType.equals(EntityTypes.SKELETON)) {
            } else if (entityType.equals(EntityTypes.HORSE)) {
                ((HorseMeta) entityMeta).setSaddled(true);
            }
        } catch (RuntimeException e) {
            if (e.getMessage() == null || !e.getMessage().contains(SXVWqKCQ8PIqDBE())) {
                throw e;
            }
        }
    }

    public Optional<SpawnedEntityData> v8qP8fE86HMhvNuYPFjqY(Player player, org.bukkit.Location location, EntityType entityType, EntityOptionsData entityOptionsData, List<Equipment> list, List<Player> list2) {
        if (location == null) {
            return Optional.empty();
        }
        Location locationFromBukkitLocation = SpigotConversionUtil.fromBukkitLocation(location);
        Optional<WrapperEntity> optionalV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(player, entityType, entityOptionsData, locationFromBukkitLocation);
        if (!optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            return Optional.empty();
        }
        if (!optionalV8qP8fE86HMhvNuYPFjqY.get().isSpawned()) {
            optionalV8qP8fE86HMhvNuYPFjqY.get().spawn(locationFromBukkitLocation);
        }
        Optional<SpawnedEntityData> optionalOf = Optional.of(new SpawnedEntityData(optionalV8qP8fE86HMhvNuYPFjqY.get().getEntityId(), System.currentTimeMillis() / 1000, false, -1));
        ZwrsrwOCXRUscW6Q().getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            v8qP8fE86HMhvNuYPFjqY(((WrapperEntity) optionalV8qP8fE86HMhvNuYPFjqY.get()).getEntityId(), entityOptionsData.isInvisible());
            v8qP8fE86HMhvNuYPFjqY(((WrapperEntity) optionalV8qP8fE86HMhvNuYPFjqY.get()).getEntityId(), (List<Player>) list2);
            ZwrsrwOCXRUscW6Q(((WrapperEntity) optionalV8qP8fE86HMhvNuYPFjqY.get()).getEntityId(), list);
        }, 2L);
        return optionalOf;
    }

    private Optional<WrapperEntity> v8qP8fE86HMhvNuYPFjqY(Player player, EntityType entityType, EntityOptionsData entityOptionsData, Location location) {
        try {
            if (entityType == null) {
                return Optional.empty();
            }
            WrapperEntity wrapperEntity = new WrapperEntity(entityType);
            v8qP8fE86HMhvNuYPFjqY(wrapperEntity, entityType, entityOptionsData);
            wrapperEntity.spawn(location);
            try {
                Optional optionalCreateVeloPacket = wrapperEntity.createVeloPacket();
                if (optionalCreateVeloPacket.isPresent()) {
                    ((Vector3d) optionalCreateVeloPacket.get()).add(0.0d, 0.0d, 0.0d);
                }
                wrapperEntity.setVelocity(Vector3d.zero());
            } catch (Exception e) {
            }
            wrapperEntity.setLocation(location);
            return Optional.of(wrapperEntity);
        } catch (Exception e2) {
            e2.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<WrapperEntity> v8qP8fE86HMhvNuYPFjqY(EntityType entityType, EntityOptionsData entityOptionsData, Location location) {
        try {
            WrapperEntity wrapperEntity = new WrapperEntity(entityType);
            wrapperEntity.getEntityId();
            v8qP8fE86HMhvNuYPFjqY(wrapperEntity, entityType, entityOptionsData);
            if (location != null) {
                wrapperEntity.spawn(location);
            }
            Optional optionalCreateVeloPacket = wrapperEntity.createVeloPacket();
            if (optionalCreateVeloPacket.isPresent()) {
                ((Vector3d) optionalCreateVeloPacket.get()).add(0.0d, 0.0d, 0.0d);
            }
            wrapperEntity.setVelocity(Vector3d.zero());
            if (location != null) {
                wrapperEntity.setLocation(location);
            }
            return Optional.of(wrapperEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, List<Player> list) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        if (entity != null) {
            list.iterator().forEachRemaining(player -> {
                entity.addViewer(player.getUniqueId());
            });
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l(int i, List<UUID> list) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        list.iterator().forEachRemaining(uuid -> {
            entity.addViewer(uuid);
        });
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, Player player) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        if (entity != null) {
            entity.addViewer(player.getUniqueId());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, UUID uuid) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        if (entity != null) {
            entity.addViewer(uuid);
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l(int i, Player player) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        if (entity != null) {
            entity.removeViewer(player.getUniqueId());
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l(int i, UUID uuid) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        if (entity != null) {
            entity.removeViewer(uuid);
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, int i2) {
        EntityLib.getApi().getDefaultContainer().getEntity(i).sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerUpdateViewDistance(i2)});
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, boolean z) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        EntityMeta entityMeta = entity.getEntityMeta();
        entityMeta.setInvisible(z);
        entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{entityMeta.createPacket()});
    }

    public void jBUuLP0sWwaPyPOmogdX7l(int i, boolean z) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        EntityMeta entityMeta = entity.getEntityMeta();
        entityMeta.setGlowing(z);
        entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{entityMeta.createPacket()});
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, Optional<String> optional) {
        try {
            WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
            if (entity != null) {
                EntityMeta entityMeta = entity.getEntityMeta();
                if (PacketEvents.getAPI().getServerManager().getVersion().is(VersionComparison.NEWER_THAN, ServerVersion.V_1_14)) {
                    entityMeta.setIndex((byte) 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT, Optional.of(v8qP8fE86HMhvNuYPFjqY(optional.get())));
                } else {
                    entityMeta.setIndex((byte) 2, EntityDataTypes.STRING, optional.get());
                }
                if (PacketEvents.getAPI().getServerManager().getVersion().is(VersionComparison.NEWER_THAN, ServerVersion.V_1_14)) {
                    entityMeta.setIndex((byte) 3, EntityDataTypes.BOOLEAN, true);
                } else {
                    entityMeta.setMaskBit(3, (byte) 1, true);
                }
                entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{entityMeta.createPacket()});
            }
        } catch (RuntimeException e) {
            if (e.getMessage() == null || !e.getMessage().contains(D6mtAIBsSkTs8TypJnHrPK())) {
                throw e;
            }
        }
    }

    public Component v8qP8fE86HMhvNuYPFjqY(String str) {
        String strReplace = str.replace(ww663TcLAcJvOQTPPu5(), this.ZwrsrwOCXRUscW6Q.getTagpl());
        MiniMessage miniMessage = MiniMessage.miniMessage();
        if (miniMessage != null) {
            return miniMessage.deserialize(strReplace).applyFallbackStyle(Style.style().decoration(TextDecoration.ITALIC, false).build());
        }
        TextComponent textComponentText = Component.text(strReplace);
        textComponentText.decoration(TextDecoration.ITALIC, false);
        return textComponentText;
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, Location location, boolean z) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityTeleport(i, location, z)});
        entity.setLocation(location);
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, Vector3d vector3d, float f, float f2, boolean z) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityTeleport(i, vector3d, f, f2, z)});
        entity.setLocation(new Location(vector3d, f, f2));
    }

    public void jBUuLP0sWwaPyPOmogdX7l(int i, Location location, boolean z) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityRelativeMove(i, location.getX(), location.getY(), location.getZ(), z)});
        entity.setLocation(location);
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, float f, float f2) {
        EntityLib.getApi().getDefaultContainer().getEntity(i).sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityRotation(i, f, f2, false)});
    }

    public void ZwrsrwOCXRUscW6Q(int i, List<Equipment> list) {
        if (list.size() > 0) {
            EntityLib.getApi().getDefaultContainer().getEntity(i).sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityEquipment(i, list)});
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, Vector3d vector3d) {
        EntityLib.getApi().getDefaultContainer().getEntity(i).sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityVelocity(i, vector3d)});
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, int[] iArr) {
        EntityLib.getApi().getDefaultContainer().getEntity(i).sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerSetPassengers(i, iArr)});
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i, WrapperPlayServerEntityAnimation.EntityAnimationType entityAnimationType) {
        EntityLib.getApi().getDefaultContainer().getEntity(i).sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityAnimation(i, entityAnimationType)});
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i) {
        WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(i);
        if (entity != null) {
            entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerDestroyEntities(i)});
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(Player player, Location location) {
        new WrapperPlayServerParticle(new Particle(ParticleTypes.CLOUD), true, new Vector3d(location.getX(), location.getY(), location.getZ()), new Vector3f(0.0f, 0.0f, 0.0f), 1.0f, 1);
    }

    public Vector3d v8qP8fE86HMhvNuYPFjqY(Location location, Location location2) {
        double x = location.getX() - location2.getX();
        double y = location.getY() - location2.getY();
        double z = location.getZ() - location2.getZ();
        double dAtan2 = Math.atan2(z, x);
        double dAtan3 = Math.atan2(Math.sqrt((z * z) + (x * x)), y) + 3.141592653589793d;
        return new Vector3d(Math.sin(dAtan3) * Math.cos(dAtan2), Math.cos(dAtan3), Math.sin(dAtan3) * Math.sin(dAtan2));
    }

    public Vector3d v8qP8fE86HMhvNuYPFjqY(Vector3d vector3d, Vector3d vector3d2, int i) {
        double y = vector3d2.getY() - vector3d.getY();
        double dSqrt = Math.sqrt(v8qP8fE86HMhvNuYPFjqY(vector3d, vector3d2));
        double dMax = Math.max(i, y + ((double) i));
        double d = ((-dSqrt) * dSqrt) / (4.0d * dMax);
        double dSqrt2 = ((-dSqrt) / (2.0d * d)) - (Math.sqrt((dSqrt * dSqrt) - ((4.0d * d) * (-y))) / (2.0d * d));
        double dSqrt3 = Math.sqrt(dMax * 0.667d);
        double d2 = dSqrt3 / dSqrt2;
        double x = vector3d2.getX() - vector3d.getX();
        double z = vector3d2.getZ() - vector3d.getZ();
        double dSqrt4 = Math.sqrt((x * x) + (z * z));
        return new Vector3d(d2 * (x / dSqrt4), dSqrt3, d2 * (z / dSqrt4));
    }

    private double v8qP8fE86HMhvNuYPFjqY(Vector3d vector3d, Vector3d vector3d2) {
        double x = vector3d2.getX() - vector3d.getX();
        double z = vector3d2.getZ() - vector3d.getZ();
        return (x * x) + (z * z);
    }

    public Clans ZwrsrwOCXRUscW6Q() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public List<SimplePacketListenerAbstract> iZTqZaRK5UGoe0Z() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public me.ulrich.clans.qjkRaOgynIj1.ZRp1tak21UvNaOVCtFx xtOheRiObl4QeAl() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    private static String SXVWqKCQ8PIqDBE() {
        return "Unknown protocol version";
    }

    private static String D6mtAIBsSkTs8TypJnHrPK() {
        return "Unknown protocol version";
    }

    private static String ww663TcLAcJvOQTPPu5() {
        return "%tag%";
    }
}
