package me.ulrich.clans.data;

import java.math.BigDecimal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AddonList.class */
public enum AddonList {
    CLANBANK("ClanBank", "4.x", "SUNFLOWER", "", "Bank Addon for UltimateClans", "Bank Addon add a menu for clan to save money and enter top money. Money added to the bank is accessible to all clan members", "https://polymart.org/r/2516", BigDecimal.valueOf(2.0d)),
    CLANQUEST("ClanQuest", "4.x", "PLAYER_HEAD", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQxOWMzNTA0ZjY2ODRiMGE1NWZkMDY5Y2NhZGUyZWI2NTk3MjRjYThiYjEwYzIwZjJkZTUwNWFhNGMyZGVmYiJ9fX0=", "Quest Addon for UltimateClans", "Quest Addon adds quests for clans. There are two types of quests: Daily quests and quests that can only be done once per clan. Rewards options have also been changed and can now add EXP, Money, Commands or Clan Points", "https://polymart.org/r/2521", BigDecimal.valueOf(2.0d)),
    CLANCHEST("ClanChest", "4.x", "CHEST", "", "Chest Addon for UltimateClans", "Addon to add a shared chest with pages for members of the same clan, with option to buy new pages and organize items.", "https://polymart.org/r/2527", BigDecimal.valueOf(2.0d)),
    CLANWAR("ClanWar", "4.x", "DIAMOND_SWORD", "", "War Addon for UltimateClans", "Addon for clan wars with configurable arenas, kits, amounts and configurable rewards. The clan must send the challenge to online clans and the opponent accepts will be teleported to the arena, other dogators of the same clan can participate and the war ends when there is only 1 clan left in the arena.", "https://polymart.org/r/2519", BigDecimal.valueOf(2.0d)),
    CLANLAND("ClanLand", "3.x", "GRASS_BLOCK", "", "Peaceful lands for UltimateClans", "The pacific Land addon creates lands for clan members, a banner needs to be set before starting to create (banner addon).", "https://polymart.org/r/2513", BigDecimal.valueOf(3.0d)),
    CLANGLADIATOR("ClanGladiator", "3.x", "DIAMOND_AXE", "", "Clan Gladiator event for UltimateClans", "Gladiator Event is a pvp event similar to clan wars but only server admins can start the event. The event has no limit of participating clans and players which is ideal for big wars with the option of rewards and custom tags.The entire addon is optimized to perform well with the new UClans api, it has an autocomplete system for commands, Bossbar, Actionbar, Json options in messages, Minimessage for colors and effects, sounds and more.", "https://polymart.org/r/2812", BigDecimal.valueOf(2.0d)),
    CLANLEADERBOARD("ClanLeaderboard", "3.x", "OAK_SIGN", "", "Leaderboards Addon for UltimateClans", "With the Leaderheads Addon you can display the top clans in ways that are attractive to players, with the support of Signs, Armor stands, player heads, turning Holograms on or off and choose the type of armor for each rank.", "https://polymart.org/r/3378", BigDecimal.valueOf(2.0d)),
    CLANFARMCOINS("ClanFarmCoins", "2.x", "DIAMOND_HOE", "", "Farm Coin Addon for UltimateClans", "Allow your players to receive clan points, level and money for the bank by farming in mining, harvesting crops, killing mobs or animals, fishing, harvesting wood or even in pvp with allies, rivals, neutrals.This Addon creates virtual or physical mini coins where players can collect, exchange, keep in the clan and others.You can create as many types of coins as you need, there is no limit and the shooting of coins is based on percentage of chance, and configurable values. As the types allowed for each coin are between mobs, miner, fishing, player, this combination becomes infinite.", "https://polymart.org/r/4441", BigDecimal.valueOf(2.0d)),
    CLANNEXUS("ClanNexus", "4.x", "ENDER_EYE", "", "Competitive Nexus (land) for UltimateClans", "Land addon with protection through the clan Nexus. The clan leader can claim pieces of land for his clan according to the CLAN POWER and number of members. There are two power modes, by kdr and by clan level, but if the power is too low, the land loses its active protection and can be looted. Tnt, lava and water are allowed by default to make the game mode more interesting. Also with maps, trusted and banned players, effects and more.", "https://polymart.org/r/2515", BigDecimal.valueOf(3.0d)),
    CLANLEAGUE("ClanLeague", "1.x", "DIAMOND_SWORD", "", "Clan Leagues Addon for UltimateClans", "Make your server more competitive with this new CLANS LEAGUE addon, creating a ranking of top points received by clans in internal server events. With a SEASONS system that can be created at any time for future seasons. At the end of each season, the clan that received the most points receives the league's rewards, which can be for commands or pre-created items. The rewards system can be divided into 3 parts by Clan, Leader or Permission.", "https://polymart.org/r/6050", BigDecimal.valueOf(3.0d)),
    CLANCORPSE("ClanCorpse", "3.x", "PAPER", "", "Corpses Addon for UltimateClans", "This addon creates corpses where other players can capture and receive rewards, clan levels, player souls. It is configurable for clan members only or free for any player, can be turned off in certain worlds or worldguard regions.", "https://polymart.org/r/2837", BigDecimal.ZERO),
    CLANDISCORDINTEGRATION("ClanDiscordIntegration", "4.x", "PAPER", "", "Discord Addon for UltimateClans", "This addon creates the integration with the discord channel via WebHook by sending pre-configured events.", "https://polymart.org/r/2523", BigDecimal.ZERO),
    CLANHOLOGRAMS("ClanHolograms", "4.x", "PAPER", "", "Hologram Addon for UltimateClans", "This addon is for administrative use and creation of holograms with status of clans, wars, kdr and others.", "https://polymart.org/r/2522", BigDecimal.ZERO);

    private final String name;
    private final String version;
    private final String icon;
    private final String iconTexture;
    private final String description;
    private final String longDescription;
    private final String downloadUrl;
    private final BigDecimal price;

    AddonList(String str, String str2, String str3, String str4, String str5, String str6, String str7, BigDecimal bigDecimal) {
        this.name = str;
        this.version = str2;
        this.icon = str3;
        this.iconTexture = str4;
        this.description = str5;
        this.longDescription = str6;
        this.downloadUrl = str7;
        this.price = bigDecimal;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public String getIconTexture() {
        return this.iconTexture;
    }
}
