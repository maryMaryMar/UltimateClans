package me.ulrich.clans.tasks;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ulrich.clans.Clans;
import me.ulrich.clans.events.ClanEntityEndEvent;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.manager.lusTj7BhhrQvAt6I;
import me.ulrich.entitywizard.entitylib.EntityLib;
import me.ulrich.entitywizard.entitylib.wrapper.WrapperEntity;
import me.ulrich.entitywizard.packetevents.protocol.world.Location;
import me.ulrich.entitywizard.packetevents.util.SpigotConversionUtil;
import me.ulrich.entitywizard.packetevents.util.Vector3d;
import me.ulrich.entitywizard.packetevents.wrapper.PacketWrapper;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityTeleport;
import me.ulrich.entitywizard.packetevents.wrapper.play.server.WrapperPlayServerEntityVelocity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/TaskWalkEvent.class */
public class TaskWalkEvent {
    private int entityID;
    private MyScheduledTask task;
    private Object targetLocation;
    private int counter;
    private double velocity;
    private Clans plugin;
    private boolean returns;
    private UUID playerSender;
    private volatile Location entityTargetSnapshot;
    private final AtomicBoolean entityTargetUpdatePending = new AtomicBoolean(false);
    private long tempoInicial = System.currentTimeMillis();
    private int maxTime = 5000;
    private boolean respectDistance = true;

    public TaskWalkEvent(Clans clans, UUID uuid, int i, double d, Object obj, boolean z, boolean z2) {
        this.entityID = i;
        this.targetLocation = obj;
        this.returns = z2;
        setPlayerSender(uuid);
        this.plugin = clans;
        this.velocity = d;
        if (z) {
            run();
        }
    }

    public void run() {
        this.counter = 0;
        this.task = this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskTimer(() -> {
            long jCurrentTimeMillis = System.currentTimeMillis();
            double d = this.velocity;
            WrapperEntity entity = EntityLib.getApi().getDefaultContainer().getEntity(this.entityID);
            if (entity == null) {
                System.out.println(">> WALK 2 (stop)");
                stop();
                return;
            }
            Location location = null;
            if (this.targetLocation instanceof Location) {
                location = (Location) this.targetLocation;
            } else if (this.targetLocation instanceof org.bukkit.Location) {
                location = SpigotConversionUtil.fromBukkitLocation((org.bukkit.Location) this.targetLocation);
            } else if (this.targetLocation instanceof Entity) {
                Entity entity2 = (Entity) this.targetLocation;
                if (this.entityTargetUpdatePending.compareAndSet(false, true)) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask(entity2, () -> {
                        try {
                            if (entity2.isDead()) {
                                this.entityTargetSnapshot = null;
                            } else {
                                this.entityTargetSnapshot = SpigotConversionUtil.fromBukkitLocation(entity2.getLocation()).clone();
                            }
                        } finally {
                            this.entityTargetUpdatePending.set(false);
                        }
                    });
                }
                Location location2 = this.entityTargetSnapshot;
                if (location2 == null) {
                    if (jCurrentTimeMillis - this.tempoInicial > this.maxTime) {
                        if (this.returns) {
                            Bukkit.getPluginManager().callEvent(new ClanEntityEndEvent(this.playerSender, this.entityID));
                        }
                        stop();
                        return;
                    }
                    return;
                }
                location = location2.clone();
            } else if (this.targetLocation instanceof List) {
                List list = (List) this.targetLocation;
                if (list.size() > 0) {
                    if (this.counter >= list.size()) {
                        location = null;
                    } else {
                        if (list.stream().findFirst().isPresent()) {
                            if (list.stream().findFirst().get() instanceof lusTj7BhhrQvAt6I.Ijap9SQKkijXSxP5) {
                                lusTj7BhhrQvAt6I.Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5 = (lusTj7BhhrQvAt6I.Ijap9SQKkijXSxP5) list.get(this.counter);
                                location = new Location(new Vector3d(ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(), entity.getLocation().clone().getY(), ijap9SQKkijXSxP5.jBUuLP0sWwaPyPOmogdX7l()), ijap9SQKkijXSxP5.ZwrsrwOCXRUscW6Q().getYaw(), ijap9SQKkijXSxP5.ZwrsrwOCXRUscW6Q().getPitch());
                            } else if (list.stream().findFirst().get() instanceof Location) {
                                location = (Location) list.get(this.counter);
                            }
                        }
                        this.respectDistance = false;
                        this.tempoInicial = System.currentTimeMillis();
                    }
                }
            }
            if (location == null) {
                stop();
                if (this.returns) {
                    Bukkit.getPluginManager().callEvent(new ClanEntityEndEvent(this.playerSender, this.entityID));
                    return;
                }
                return;
            }
            Location location3 = entity.getLocation();
            Vector3d position = location3.getPosition();
            Vector3d position2 = location.getPosition();
            Vector3d vector3dNormalize = position2.subtract(position).normalize();
            double dDistance = position.distance(position2);
            double d2 = d * d;
            if (dDistance <= 2.5d) {
                d /= 2.0d;
            }
            Vector3d vector3d = new Vector3d(position.getX() + (vector3dNormalize.getX() * d), position.getY() + (vector3dNormalize.getY() * d), position.getZ() + (vector3dNormalize.getZ() * d));
            entity.setLocation(new Location(vector3d, location3.getYaw(), location3.getPitch()));
            PacketWrapper wrapperPlayServerEntityTeleport = new WrapperPlayServerEntityTeleport(entity.getEntityId(), vector3d, location.getYaw(), location.getPitch(), false);
            PacketWrapper wrapperPlayServerEntityRotation = new WrapperPlayServerEntityRotation(entity.getEntityId(), location.getYaw(), location.getPitch(), false);
            PacketWrapper wrapperPlayServerEntityVelocity = new WrapperPlayServerEntityVelocity(entity.getEntityId(), new Vector3d(vector3dNormalize.getX() * d, vector3dNormalize.getY() * d, vector3dNormalize.getZ() * d));
            entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{wrapperPlayServerEntityRotation});
            entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{wrapperPlayServerEntityTeleport});
            entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{wrapperPlayServerEntityVelocity});
            if ((dDistance <= d2 || dDistance <= 1.0d) && this.respectDistance) {
                entity.setLocation(location);
                entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityTeleport(entity.getEntityId(), location.getPosition(), location.getYaw(), location.getPitch(), false)});
                entity.sendPacketsToViewersIfSpawned(new PacketWrapper[]{new WrapperPlayServerEntityVelocity(this.entityID, Vector3d.zero())});
                stop();
                if (this.returns) {
                    Bukkit.getPluginManager().callEvent(new ClanEntityEndEvent(this.playerSender, this.entityID));
                    return;
                }
                return;
            }
            this.counter++;
            if (jCurrentTimeMillis - this.tempoInicial > this.maxTime) {
                System.out.println(">> TEMPO MAXIMO DECORRIDO");
                if (this.returns) {
                    Bukkit.getPluginManager().callEvent(new ClanEntityEndEvent(this.playerSender, this.entityID));
                }
                stop();
            }
        }, 1L, 1L);
    }

    public MyScheduledTask getTask() {
        return this.task;
    }

    public void stop() {
        this.task.cancel();
    }

    public boolean isReturns() {
        return this.returns;
    }

    public UUID getPlayerSender() {
        return this.playerSender;
    }

    public void setPlayerSender(UUID uuid) {
        this.playerSender = uuid;
    }
}
