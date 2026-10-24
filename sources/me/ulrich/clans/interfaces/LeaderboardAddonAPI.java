package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.LeaderboardData;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/LeaderboardAddonAPI.class */
public interface LeaderboardAddonAPI {
    String parseText(UUID uuid, String str);

    void saveBoardData(LeaderboardData leaderboardData);

    void deleteBoardData(String str);

    void reloadClanData(String str);

    void loadAllBoardData();

    boolean inEditMode(Player player);

    boolean hasLeaderboard(String str);

    boolean hasLeaderboard(Location location);

    Optional<LeaderboardData> getLeaderboard(String str);

    Optional<LeaderboardData> getLeaderboard(Location location);

    boolean createLeaderboard(Location location, AddonEnum.LookType lookType, ClanEnum.PlaceholderTop placeholderTop, int i, BlockFace blockFace);

    boolean deleteLeaderboard(Location location);

    boolean deleteLeaderboard(String str);

    void updateBoards(long j);

    void updateBoard(LeaderboardData leaderboardData);

    void updateBoardFolia(LeaderboardData leaderboardData);

    void updateBoardOther(LeaderboardData leaderboardData);

    BlockFace yawToFace(float f);

    ItemStack getSkinBlock(String str);

    Location expand(BlockFace blockFace, Location location, double d);

    boolean isCartesian(BlockFace blockFace);

    void deupdateBoard(LeaderboardData leaderboardData);

    void clickAction(Player player, AddonEnum.BoardClickType boardClickType, Location location);

    Optional<Entity> rayTraceLegacyEntities(Player player, double d, Predicate<Entity> predicate);

    Optional<Entity> rayTraceEntities(Location location, Vector vector, double d, double d2, Predicate<Entity> predicate);

    HashMap<String, LeaderboardData> getLeaderboardData();

    List<Player> getEditMode();
}
