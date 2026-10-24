package me.ulrich.clans.manager;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.library.universalScheduler.UniversalScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.tasks.AsyncTaskExecutor;
import org.bukkit.entity.Entity;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/z8MICAC4yDYZiO.class */
public class z8MICAC4yDYZiO {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private boolean jBUuLP0sWwaPyPOmogdX7l;
    private TaskScheduler ZwrsrwOCXRUscW6Q = null;
    private ConcurrentHashMap<UUID, MyScheduledTask> iZTqZaRK5UGoe0Z = new ConcurrentHashMap<>();
    private ConcurrentHashMap<UUID, MyScheduledTask> xtOheRiObl4QeAl = new ConcurrentHashMap<>();
    private final AsyncTaskExecutor zJnaNCVQSgEShq = new AsyncTaskExecutor();
    private static final byte[] T0qhk0texDxrDFqW = {(byte) 78, (byte) 196, (byte) 254, (byte) 204, (byte) 214, (byte) 9, (byte) 144, (byte) 66, (byte) 109, (byte) 23, (byte) 179, (byte) 204, (byte) 45, (byte) 219, (byte) 50, (byte) 207, (byte) 90, (byte) 7, (byte) 182, (byte) 126, (byte) 117, (byte) 109, (byte) 137, (byte) 224, (byte) 10, (byte) 206, (byte) 48, (byte) 233, (byte) 253, (byte) 188, (byte) 104, (byte) 29};
    private static final byte[] VHvMIDYMpskXg4O7jL = {(byte) 233, (byte) 225, (byte) 101, (byte) 60, (byte) 181, (byte) 158, (byte) 171, (byte) 24, (byte) 124, (byte) 40, (byte) 0, (byte) 50, (byte) 177, (byte) 71, (byte) 191, (byte) 49};
    private static volatile String qint3uhTEsxRCbIcnWB;

    public z8MICAC4yDYZiO(Clans clans) {
        this.jBUuLP0sWwaPyPOmogdX7l = false;
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.jBUuLP0sWwaPyPOmogdX7l = UniversalScheduler.isFolia || UniversalScheduler.isCanvas;
        p31abtwfBag2jhMH6K();
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l() {
        try {
            Class.forName(sWnxgR3x23cXRVW6NHVR());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private void p31abtwfBag2jhMH6K() {
        this.ZwrsrwOCXRUscW6Q = UniversalScheduler.getScheduler(this.v8qP8fE86HMhvNuYPFjqY);
    }

    public boolean ZwrsrwOCXRUscW6Q() {
        return this.ZwrsrwOCXRUscW6Q != null;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        return zJnaNCVQSgEShq().containsKey(uuid);
    }

    public Optional<MyScheduledTask> jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        try {
            if (v8qP8fE86HMhvNuYPFjqY(uuid)) {
                return Optional.of(zJnaNCVQSgEShq().get(uuid));
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid) {
        Optional<MyScheduledTask> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(uuid);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            return false;
        }
        optionalJBUuLP0sWwaPyPOmogdX7l.get().cancel();
        return true;
    }

    public Optional<MyScheduledTask> v8qP8fE86HMhvNuYPFjqY(UUID uuid, MyScheduledTask myScheduledTask) {
        try {
            if (ZwrsrwOCXRUscW6Q()) {
                if (v8qP8fE86HMhvNuYPFjqY(uuid)) {
                    ZwrsrwOCXRUscW6Q(uuid);
                }
                zJnaNCVQSgEShq().put(uuid, myScheduledTask);
                return Optional.of(myScheduledTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean iZTqZaRK5UGoe0Z(UUID uuid) {
        return CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid);
    }

    public Optional<MyScheduledTask> xtOheRiObl4QeAl(UUID uuid) {
        try {
            if (iZTqZaRK5UGoe0Z(uuid)) {
                return Optional.of(CDW4Fj1iwdIXEOqWjiJSR().get(uuid));
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    public boolean zJnaNCVQSgEShq(UUID uuid) {
        Optional<MyScheduledTask> optionalXtOheRiObl4QeAl = xtOheRiObl4QeAl(uuid);
        if (!optionalXtOheRiObl4QeAl.isPresent()) {
            return false;
        }
        optionalXtOheRiObl4QeAl.get().cancel();
        return true;
    }

    public Optional<MyScheduledTask> jBUuLP0sWwaPyPOmogdX7l(UUID uuid, MyScheduledTask myScheduledTask) {
        try {
            if (ZwrsrwOCXRUscW6Q()) {
                if (iZTqZaRK5UGoe0Z(uuid)) {
                    zJnaNCVQSgEShq(uuid);
                }
                CDW4Fj1iwdIXEOqWjiJSR().put(uuid, myScheduledTask);
                return Optional.of(myScheduledTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean iZTqZaRK5UGoe0Z() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public TaskScheduler xtOheRiObl4QeAl() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public void v8qP8fE86HMhvNuYPFjqY(Entity entity, Runnable runnable) {
        if (entity == null || runnable == null || !ZwrsrwOCXRUscW6Q()) {
            return;
        }
        if (xtOheRiObl4QeAl().isEntityThread(entity)) {
            runnable.run();
        } else {
            xtOheRiObl4QeAl().runTask(entity, runnable);
        }
    }

    public ConcurrentHashMap<UUID, MyScheduledTask> zJnaNCVQSgEShq() {
        return this.xtOheRiObl4QeAl;
    }

    public ConcurrentHashMap<UUID, MyScheduledTask> CDW4Fj1iwdIXEOqWjiJSR() {
        return this.iZTqZaRK5UGoe0Z;
    }

    public AsyncTaskExecutor b4i2FbOkaKeg91LiAe6l() {
        return this.zJnaNCVQSgEShq;
    }

    private static String sWnxgR3x23cXRVW6NHVR() {
        return "com.destroystokyo.paper.PaperConfig";
    }
}
