package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/IntegrationAPI.class */
public interface IntegrationAPI {
    void registerAnvilAPI(AnvilModuleAPI anvilModuleAPI);

    void unregisterAnvilAPI(AnvilModuleAPI anvilModuleAPI);

    void registerMultiserverAPI(MultiserverModuleAPI multiserverModuleAPI);

    void unregisterMultiserverAPI(MultiserverModuleAPI multiserverModuleAPI);

    void registerRewardsAPI(RewardsModuleAPI rewardsModuleAPI);

    void unregisterRewardsAPI(RewardsModuleAPI rewardsModuleAPI);

    void registerDiscordAPI(DiscordModuleAPI discordModuleAPI);

    void unregisterDiscordAPI(DiscordModuleAPI discordModuleAPI);

    void registerMailAPI(MailModuleAPI mailModuleAPI);

    void unregisterMailAPI(MailModuleAPI mailModuleAPI);

    void registerBannerAPI(BannerModuleAPI bannerModuleAPI);

    void unregisterBannerAPI(BannerModuleAPI bannerModuleAPI);

    void registerRivalAllyAPI(RivalAllyModuleAPI rivalAllyModuleAPI);

    void unregisterRivalAllyAPI(RivalAllyModuleAPI rivalAllyModuleAPI);

    void registerLoggerAPI(LoggerModuleAPI loggerModuleAPI);

    void unregisterLoggerAPI(LoggerModuleAPI loggerModuleAPI);

    void registerLevelupAPI(LevelupModuleAPI levelupModuleAPI);

    void unregisterLevelupAPI(LevelupModuleAPI levelupModuleAPI);

    void registerHomeAPI(HomeModuleAPI homeModuleAPI);

    void unregisterHomeAPI(HomeModuleAPI homeModuleAPI);

    String parseModulePlaceholders(UUID uuid, String str);

    String parseAddonPlaceholders(UUID uuid, String str);

    Optional<RivalAllyModuleAPI> getRivalAlly();

    Optional<LoggerModuleAPI> getLogger();

    Optional<LevelupModuleAPI> getLevelup();

    Optional<HomeModuleAPI> getHome();

    Optional<MailModuleAPI> getMail();

    Optional<BannerModuleAPI> getBanner();

    Optional<DiscordModuleAPI> getDiscordAPI();

    Optional<RewardsModuleAPI> getRewards();

    Optional<MultiserverModuleAPI> getMultiserverAPI();

    Optional<AnvilModuleAPI> getAnvilAPI();

    void registerItemParseAPI(String str, ItemParseImplement itemParseImplement);

    void unregisterItemParseAPI(String str);

    Optional<ItemParseImplement> getItemParseAPI(String str);

    Optional<ItemParseImplement> getItemParseAPI();

    List<ItemParseImplement> getItemParseAllImplemented();

    void registerScoreboardAPI(String str, ScoreboardImplement scoreboardImplement);

    void unregisterScoreboardAPI(String str);

    Optional<ScoreboardImplement> getScoreboardAPI(String str);

    Optional<ScoreboardImplement> getScoreboardAPI();

    void registerRegionAPI(String str, RegionImplement regionImplement);

    void unregisterRegionAPI(String str);

    Optional<RegionImplement> getRegionAPI(String str);

    Optional<RegionImplement> getRegionAPI();

    void registerMoneyAPI(String str, MoneyImplement moneyImplement);

    void unregisterMoneyAPI(String str);

    Optional<MoneyImplement> getMoneyAPI(String str);

    Optional<MoneyImplement> getMoneyAPI();

    void registerMapAPI(String str, MapImplement mapImplement);

    void unregisterMapAPI(String str);

    Optional<MapImplement> getMapAPI(String str);

    Optional<MapImplement> getMapAPI();

    void registerHologramAPI(String str, HologramImplement hologramImplement);

    void unregisterHologramAPI(String str);

    Optional<HologramImplement> getHologramAPI(String str);

    Optional<HologramImplement> getHologramAPI();

    void registerEventAPI(String str, EventImplement eventImplement);

    void unregisterEventAPI(String str);

    Optional<EventImplement> getEventAPI(String str);

    Optional<EventImplement> getEventAPI();

    void registerClaimAPI(String str, ClaimImplement claimImplement);

    void unregisterClaimAPI(String str);

    Optional<ClaimImplement> getClaimAPI(String str);

    Optional<ClaimImplement> getClaimAPI();

    void registerBankAPI(BankAddonAPI bankAddonAPI);

    void unregisterBankAPI(BankAddonAPI bankAddonAPI);

    Optional<BankAddonAPI> getBankAPI();

    void registerChestAPI(ChestAddonAPI chestAddonAPI);

    void unregisterChestAPI(ChestAddonAPI chestAddonAPI);

    Optional<ChestAddonAPI> getChestAPI();

    void registerFarmCoinAPI(FarmCoinsAddonAPI farmCoinsAddonAPI);

    void unregisterFarmCoinAPI(FarmCoinsAddonAPI farmCoinsAddonAPI);

    Optional<FarmCoinsAddonAPI> getFarmCoinAPI();

    void registerLandAPI(LandAddonAPI landAddonAPI);

    void unregisterLandAPI(LandAddonAPI landAddonAPI);

    Optional<LandAddonAPI> getLandAPI();

    void registerLeaderboardAPI(LeaderboardAddonAPI leaderboardAddonAPI);

    void unregisterLeaderboardAPI(LeaderboardAddonAPI leaderboardAddonAPI);

    Optional<LeaderboardAddonAPI> getLeaderboardAPI();

    void registerLeagueAPI(LeagueAddonAPI leagueAddonAPI);

    void unregisterLeagueAPI(LeagueAddonAPI leagueAddonAPI);

    Optional<LeagueAddonAPI> getLeagueAPI();

    void registerNexusAPI(NexusAddonAPI nexusAddonAPI);

    void unregisterNexusAPI(NexusAddonAPI nexusAddonAPI);

    Optional<NexusAddonAPI> getNexusAPI();

    void registerQuestAPI(QuestAddonAPI questAddonAPI);

    void unregisterQuestAPI(QuestAddonAPI questAddonAPI);

    Optional<QuestAddonAPI> getQuestAPI();

    void registerWarAPI(WarAddonAPI warAddonAPI);

    void unregisterWarAPI(WarAddonAPI warAddonAPI);

    Optional<WarAddonAPI> getWarAPI();

    void registerGladiatorAPI(GladiatorAddonAPI gladiatorAddonAPI);

    void unregisterGladiatorAPI(GladiatorAddonAPI gladiatorAddonAPI);

    Optional<GladiatorAddonAPI> getGladiatorAPI();
}
