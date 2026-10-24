package me.ulrich.clans.library.paperlib.environments;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/environments/SpigotEnvironment.class */
public class SpigotEnvironment extends CraftBukkitEnvironment {
    @Override // me.ulrich.clans.library.paperlib.environments.CraftBukkitEnvironment, me.ulrich.clans.library.paperlib.environments.Environment
    public String getName() {
        return "Spigot";
    }

    @Override // me.ulrich.clans.library.paperlib.environments.Environment
    public boolean isSpigot() {
        return true;
    }
}
