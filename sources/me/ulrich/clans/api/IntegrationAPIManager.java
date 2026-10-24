package me.ulrich.clans.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.interfaces.AnvilModuleAPI;
import me.ulrich.clans.interfaces.BankAddonAPI;
import me.ulrich.clans.interfaces.BannerModuleAPI;
import me.ulrich.clans.interfaces.ChestAddonAPI;
import me.ulrich.clans.interfaces.ClaimImplement;
import me.ulrich.clans.interfaces.DiscordModuleAPI;
import me.ulrich.clans.interfaces.EventImplement;
import me.ulrich.clans.interfaces.FarmCoinsAddonAPI;
import me.ulrich.clans.interfaces.GladiatorAddonAPI;
import me.ulrich.clans.interfaces.HologramImplement;
import me.ulrich.clans.interfaces.HomeModuleAPI;
import me.ulrich.clans.interfaces.IntegrationAPI;
import me.ulrich.clans.interfaces.ItemParseImplement;
import me.ulrich.clans.interfaces.LandAddonAPI;
import me.ulrich.clans.interfaces.LeaderboardAddonAPI;
import me.ulrich.clans.interfaces.LeagueAddonAPI;
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import me.ulrich.clans.interfaces.LoggerModuleAPI;
import me.ulrich.clans.interfaces.MailModuleAPI;
import me.ulrich.clans.interfaces.MapImplement;
import me.ulrich.clans.interfaces.MoneyImplement;
import me.ulrich.clans.interfaces.MultiserverModuleAPI;
import me.ulrich.clans.interfaces.NexusAddonAPI;
import me.ulrich.clans.interfaces.QuestAddonAPI;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;
import me.ulrich.clans.interfaces.ScoreboardImplement;
import me.ulrich.clans.interfaces.WarAddonAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/IntegrationAPIManager.class */
public class IntegrationAPIManager implements IntegrationAPI {
    public IntegrationAPIManager(Clans clans) {
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerAnvilAPI(AnvilModuleAPI anvilModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(anvilModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterAnvilAPI(AnvilModuleAPI anvilModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(anvilModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerMultiserverAPI(MultiserverModuleAPI multiserverModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(multiserverModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterMultiserverAPI(MultiserverModuleAPI multiserverModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(multiserverModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerRewardsAPI(RewardsModuleAPI rewardsModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(rewardsModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterRewardsAPI(RewardsModuleAPI rewardsModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(rewardsModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerDiscordAPI(DiscordModuleAPI discordModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(discordModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterDiscordAPI(DiscordModuleAPI discordModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(discordModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerMailAPI(MailModuleAPI mailModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(mailModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterMailAPI(MailModuleAPI mailModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(mailModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerBannerAPI(BannerModuleAPI bannerModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(bannerModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterBannerAPI(BannerModuleAPI bannerModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(bannerModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerRivalAllyAPI(RivalAllyModuleAPI rivalAllyModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(rivalAllyModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterRivalAllyAPI(RivalAllyModuleAPI rivalAllyModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(rivalAllyModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerLoggerAPI(LoggerModuleAPI loggerModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(loggerModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterLoggerAPI(LoggerModuleAPI loggerModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(loggerModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerLevelupAPI(LevelupModuleAPI levelupModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(levelupModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterLevelupAPI(LevelupModuleAPI levelupModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(levelupModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerHomeAPI(HomeModuleAPI homeModuleAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(homeModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterHomeAPI(HomeModuleAPI homeModuleAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(homeModuleAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public String parseModulePlaceholders(UUID uuid, String str) {
        return Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public String parseAddonPlaceholders(UUID uuid, String str) {
        return Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<RivalAllyModuleAPI> getRivalAlly() {
        return Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<LoggerModuleAPI> getLogger() {
        return Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<LevelupModuleAPI> getLevelup() {
        return Clans.getClanCore().getIntegrationManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<HomeModuleAPI> getHome() {
        return Clans.getClanCore().getIntegrationManager().iZTqZaRK5UGoe0Z();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<MailModuleAPI> getMail() {
        return Clans.getClanCore().getIntegrationManager().xtOheRiObl4QeAl();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<BannerModuleAPI> getBanner() {
        return Clans.getClanCore().getIntegrationManager().zJnaNCVQSgEShq();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<DiscordModuleAPI> getDiscordAPI() {
        return Clans.getClanCore().getIntegrationManager().b4i2FbOkaKeg91LiAe6l();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<RewardsModuleAPI> getRewards() {
        return Clans.getClanCore().getIntegrationManager().CDW4Fj1iwdIXEOqWjiJSR();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<MultiserverModuleAPI> getMultiserverAPI() {
        return Clans.getClanCore().getIntegrationManager().p31abtwfBag2jhMH6K();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<AnvilModuleAPI> getAnvilAPI() {
        return Clans.getClanCore().getIntegrationManager().Un3NRLL6aWivTcbodkcK();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerItemParseAPI(String str, ItemParseImplement itemParseImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, itemParseImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterItemParseAPI(String str) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ItemParseImplement> getItemParseAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ItemParseImplement> getItemParseAPI() {
        return Clans.getClanCore().getIntegrationManager().o1VU1x4DAlrEtGKZ3jAdhE();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public List<ItemParseImplement> getItemParseAllImplemented() {
        return Clans.getClanCore().getIntegrationManager().vVo2VUvxrriklPdRxI();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerScoreboardAPI(String str, ScoreboardImplement scoreboardImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, scoreboardImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterScoreboardAPI(String str) {
        Clans.getClanCore().getIntegrationManager().ZwrsrwOCXRUscW6Q(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ScoreboardImplement> getScoreboardAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().iZTqZaRK5UGoe0Z(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ScoreboardImplement> getScoreboardAPI() {
        return Clans.getClanCore().getIntegrationManager().Nz8xKv4RePC2a0f0iuYU();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerRegionAPI(String str, RegionImplement regionImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, regionImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterRegionAPI(String str) {
        Clans.getClanCore().getIntegrationManager().xtOheRiObl4QeAl(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<RegionImplement> getRegionAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().zJnaNCVQSgEShq(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<RegionImplement> getRegionAPI() {
        return Clans.getClanCore().getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerMoneyAPI(String str, MoneyImplement moneyImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, moneyImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterMoneyAPI(String str) {
        Clans.getClanCore().getIntegrationManager().CDW4Fj1iwdIXEOqWjiJSR(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<MoneyImplement> getMoneyAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().b4i2FbOkaKeg91LiAe6l(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<MoneyImplement> getMoneyAPI() {
        return Clans.getClanCore().getIntegrationManager().IO1OGSMpoP1ZjOsbXi3a();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerMapAPI(String str, MapImplement mapImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, mapImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterMapAPI(String str) {
        Clans.getClanCore().getIntegrationManager().p31abtwfBag2jhMH6K(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<MapImplement> getMapAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().Un3NRLL6aWivTcbodkcK(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<MapImplement> getMapAPI() {
        return Clans.getClanCore().getIntegrationManager().VkPRYe34Awk6AdSxoUC();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerHologramAPI(String str, HologramImplement hologramImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, hologramImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterHologramAPI(String str) {
        Clans.getClanCore().getIntegrationManager().lGGwXL678c4Kv7skJb5NiE(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<HologramImplement> getHologramAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().o1VU1x4DAlrEtGKZ3jAdhE(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<HologramImplement> getHologramAPI() {
        return Clans.getClanCore().getIntegrationManager().QXoNfOxIPaPrSlQMNR();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerEventAPI(String str, EventImplement eventImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, eventImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterEventAPI(String str) {
        Clans.getClanCore().getIntegrationManager().vVo2VUvxrriklPdRxI(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<EventImplement> getEventAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().Fc3p9FhCjSD1k5Ra4(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<EventImplement> getEventAPI() {
        return Clans.getClanCore().getIntegrationManager().V3DAV3orG0so43Del8NdO();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerClaimAPI(String str, ClaimImplement claimImplement) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(str, claimImplement);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterClaimAPI(String str) {
        Clans.getClanCore().getIntegrationManager().Nz8xKv4RePC2a0f0iuYU(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ClaimImplement> getClaimAPI(String str) {
        return Clans.getClanCore().getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui(str);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ClaimImplement> getClaimAPI() {
        return Clans.getClanCore().getIntegrationManager().Y9J1Kd6E1T8FcF();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerBankAPI(BankAddonAPI bankAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(bankAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterBankAPI(BankAddonAPI bankAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(bankAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<BankAddonAPI> getBankAPI() {
        return Clans.getClanCore().getIntegrationManager().MoSLgFbw3mkSoqkObMHJ4();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerChestAPI(ChestAddonAPI chestAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(chestAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterChestAPI(ChestAddonAPI chestAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(chestAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<ChestAddonAPI> getChestAPI() {
        return Clans.getClanCore().getIntegrationManager().GDU5Y0ildSLo4mliJ();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerFarmCoinAPI(FarmCoinsAddonAPI farmCoinsAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(farmCoinsAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterFarmCoinAPI(FarmCoinsAddonAPI farmCoinsAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(farmCoinsAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<FarmCoinsAddonAPI> getFarmCoinAPI() {
        return Clans.getClanCore().getIntegrationManager().hqTnbBoUmxDUXvki();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerLandAPI(LandAddonAPI landAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(landAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterLandAPI(LandAddonAPI landAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(landAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<LandAddonAPI> getLandAPI() {
        return Clans.getClanCore().getIntegrationManager().gvy0NoTzHY6bC7eAY();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerLeaderboardAPI(LeaderboardAddonAPI leaderboardAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(leaderboardAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterLeaderboardAPI(LeaderboardAddonAPI leaderboardAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(leaderboardAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<LeaderboardAddonAPI> getLeaderboardAPI() {
        return Clans.getClanCore().getIntegrationManager().nXcEVQOWhfaKT423a();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerLeagueAPI(LeagueAddonAPI leagueAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(leagueAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterLeagueAPI(LeagueAddonAPI leagueAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(leagueAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<LeagueAddonAPI> getLeagueAPI() {
        return Clans.getClanCore().getIntegrationManager().qCr0jwvuDANuhNNe9InzM1();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerNexusAPI(NexusAddonAPI nexusAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(nexusAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterNexusAPI(NexusAddonAPI nexusAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(nexusAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<NexusAddonAPI> getNexusAPI() {
        return Clans.getClanCore().getIntegrationManager().OfIpR1Ys0fObQiw0avrIMa();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerQuestAPI(QuestAddonAPI questAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(questAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterQuestAPI(QuestAddonAPI questAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(questAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<QuestAddonAPI> getQuestAPI() {
        return Clans.getClanCore().getIntegrationManager().oUXqAhcQIZ2jOE02XWODqg();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerWarAPI(WarAddonAPI warAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(warAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterWarAPI(WarAddonAPI warAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(warAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<WarAddonAPI> getWarAPI() {
        return Clans.getClanCore().getIntegrationManager().eHlgwCjkRE7V5J3Bm3h();
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void registerGladiatorAPI(GladiatorAddonAPI gladiatorAddonAPI) {
        Clans.getClanCore().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(gladiatorAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public void unregisterGladiatorAPI(GladiatorAddonAPI gladiatorAddonAPI) {
        Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(gladiatorAddonAPI);
    }

    @Override // me.ulrich.clans.interfaces.IntegrationAPI
    public Optional<GladiatorAddonAPI> getGladiatorAPI() {
        return Clans.getClanCore().getIntegrationManager().ZPBcFhvCehdDEalmo();
    }
}
