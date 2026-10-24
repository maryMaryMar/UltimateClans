package me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/scheduler/FoliaTaskScheduler.class */
final class FoliaTaskScheduler implements TaskScheduler {
    private static final Class<?> asyncSchedulerClass;
    private static final Class<?> scheduledTaskClass;
    private static final Class<?> cancelledStateClass;
    private static final MethodHandle getAsyncSchedulerMethod;
    private static final MethodHandle cancelScheduledTaskMethod;
    private static final MethodHandle runAtFixedRateMethod;
    private static final MethodHandle runDelayedMethod;
    private final Plugin plugin;
    private final Object asyncScheduler;

    public FoliaTaskScheduler(@NotNull Plugin plugin) {
        this.plugin = plugin;
        try {
            this.asyncScheduler = (Object) getAsyncSchedulerMethod.invoke(plugin.getServer());
        } catch (Throwable th) {
            throw new RuntimeException("couldn't get async scheduler", th);
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.TaskScheduler
    @NotNull
    public RunningTask runEveryTick(@NotNull Runnable runnable) {
        try {
            Object objInvoke = (Object) runAtFixedRateMethod.invoke(this.asyncScheduler, this.plugin, obj -> {
                runnable.run();
            }, 50L, 50L, TimeUnit.MILLISECONDS);
            return () -> {
                try {
                    cancelScheduledTaskMethod.invoke(objInvoke);
                } catch (Throwable th) {
                    throw new RuntimeException("couldn't cancel scheduled task", th);
                }
            };
        } catch (Throwable th) {
            throw new RuntimeException("couldn't schedule repeating task", th);
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.TaskScheduler
    public void runNextTick(@NotNull Runnable runnable) {
        try {
            runDelayedMethod.invoke(this.asyncScheduler, this.plugin, obj -> {
                runnable.run();
            }, 50L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw new RuntimeException("couldn't schedule delayed task", th);
        }
    }

    static {
        try {
            asyncSchedulerClass = Class.forName("io.papermc.paper.threadedregions.scheduler.AsyncScheduler");
            scheduledTaskClass = Class.forName("io.papermc.paper.threadedregions.scheduler.ScheduledTask");
            cancelledStateClass = Class.forName("io.papermc.paper.threadedregions.scheduler.ScheduledTask$CancelledState");
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            getAsyncSchedulerMethod = lookup.findVirtual(Server.class, "getAsyncScheduler", MethodType.methodType(asyncSchedulerClass));
            cancelScheduledTaskMethod = lookup.findVirtual(scheduledTaskClass, "cancel", MethodType.methodType(cancelledStateClass));
            runAtFixedRateMethod = lookup.findVirtual(asyncSchedulerClass, "runAtFixedRate", MethodType.methodType(scheduledTaskClass, Plugin.class, Consumer.class, Long.TYPE, Long.TYPE, TimeUnit.class));
            runDelayedMethod = lookup.findVirtual(asyncSchedulerClass, "runDelayed", MethodType.methodType(scheduledTaskClass, Plugin.class, Consumer.class, Long.TYPE, TimeUnit.class));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
