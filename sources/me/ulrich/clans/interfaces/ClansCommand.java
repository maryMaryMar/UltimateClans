package me.ulrich.clans.interfaces;

import java.util.EnumMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Flag;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ClansCommand.class */
public interface ClansCommand {
    boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap);
}
