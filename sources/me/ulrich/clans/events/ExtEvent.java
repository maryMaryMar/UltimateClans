package me.ulrich.clans.events;

import com.google.common.base.Stopwatch;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ExtEvent.class */
public class ExtEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private ClanEnum.RepoReturn RepoReturn;
    private CommandSender commandSender;
    private Stopwatch stopwatch;
    private ClanEnum.ClansExtensions str;

    public ExtEvent(CommandSender commandSender, ClanEnum.RepoReturn repoReturn, Stopwatch stopwatch, ClanEnum.ClansExtensions clansExtensions) {
        setRepoReturn(repoReturn);
        setCommandSender(commandSender);
        setStopwatch(stopwatch);
        setStr(clansExtensions);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean z) {
        this.cancelled = z;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public ClanEnum.RepoReturn getRepoReturn() {
        return this.RepoReturn;
    }

    public void setRepoReturn(ClanEnum.RepoReturn repoReturn) {
        this.RepoReturn = repoReturn;
    }

    public CommandSender getCommandSender() {
        return this.commandSender;
    }

    public void setCommandSender(CommandSender commandSender) {
        this.commandSender = commandSender;
    }

    public Stopwatch getStopwatch() {
        return this.stopwatch;
    }

    public void setStopwatch(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    public ClanEnum.ClansExtensions getStr() {
        return this.str;
    }

    public void setStr(ClanEnum.ClansExtensions clansExtensions) {
        this.str = clansExtensions;
    }
}
