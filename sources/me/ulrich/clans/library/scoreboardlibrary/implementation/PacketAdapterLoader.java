package me.ulrich.clans.library.scoreboardlibrary.implementation;

import java.lang.reflect.InvocationTargetException;
import me.ulrich.clans.library.scoreboardlibrary.api.exception.NoPacketAdapterAvailableException;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PacketAdapterProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/PacketAdapterLoader.class */
public final class PacketAdapterLoader {
    private PacketAdapterLoader() {
    }

    @NotNull
    public static PacketAdapterProvider loadPacketAdapter(Plugin plugin) throws NoPacketAdapterAvailableException {
        Class<?> clsFindAndLoadImplementationClass = findAndLoadImplementationClass();
        boolean z = false;
        if (clsFindAndLoadImplementationClass == null) {
            z = !System.getProperty("net.mega".concat("vex.scoreboardlibrary.dontSwallowUntestedLoadException"), "").equalsIgnoreCase("true");
            clsFindAndLoadImplementationClass = tryLoad();
            if (clsFindAndLoadImplementationClass == null) {
                throw new NoPacketAdapterAvailableException();
            }
        }
        try {
            return (PacketAdapterProvider) clsFindAndLoadImplementationClass.getConstructors()[0].newInstance(plugin);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("couldn't initialize packet adapter", e);
        } catch (InvocationTargetException e2) {
            if (z) {
                throw new NoPacketAdapterAvailableException();
            }
            throw new RuntimeException("couldn't initialize packet adapter", e2);
        }
    }

    @Nullable
    private static Class<?> findAndLoadImplementationClass() {
        String bukkitVersion = Bukkit.getServer().getBukkitVersion();
        int iIndexOf = bukkitVersion.indexOf(45);
        if (iIndexOf != -1) {
            bukkitVersion = bukkitVersion.substring(0, iIndexOf);
        }
        int iIndexOf2 = bukkitVersion.indexOf(".build");
        if (iIndexOf2 != -1) {
            bukkitVersion = bukkitVersion.substring(0, iIndexOf2);
        }
        switch (bukkitVersion) {
            case "1.7.10":
            case "1.8":
            case "1.8.3":
            case "1.8.4":
            case "1.8.5":
            case "1.8.6":
            case "1.8.7":
            case "1.8.8":
            case "1.9":
            case "1.9.2":
            case "1.9.4":
            case "1.10.2":
            case "1.11":
            case "1.11.2":
            case "1.12":
            case "1.12.1":
            case "1.12.2":
            case "1.13":
            case "1.13.1":
            case "1.13.2":
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
            case "1.15":
            case "1.15.1":
            case "1.15.2":
            case "1.16":
            case "1.16.1":
            case "1.16.2":
            case "1.16.3":
            case "1.16.4":
            case "1.16.5":
            case "1.17":
            case "1.17.1":
            case "1.18":
            case "1.18.1":
            case "1.18.2":
            case "1.19":
            case "1.19.1":
            case "1.19.2":
            case "1.19.3":
            case "1.19.4":
            case "1.20":
            case "1.20.1":
            case "1.20.2":
            case "1.20.3":
            case "1.20.4":
            case "1.20.5":
            case "1.20.6":
            case "1.21":
            case "1.21.1":
            case "1.21.2":
            case "1.21.3":
            case "1.21.4":
            case "1.21.5":
            case "1.21.6":
            case "1.21.7":
            case "1.21.8":
            case "1.21.9":
            case "1.21.10":
            case "1.21.11":
            case "26.1":
            case "26.1.1":
            case "26.1.2":
            case "26.2":
                return tryLoad();
            default:
                return null;
        }
    }

    private static Class<?> tryLoad() {
        try {
            return Class.forName("me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
