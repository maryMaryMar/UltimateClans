package me.ulrich.clans.data;

import me.ulrich.clans.manager.utils.VersionUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum.class */
public class ClanEnum {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$AllyInviteReturn.class */
    public enum AllyInviteReturn {
        SENDED,
        MODERATION_OFFLINE,
        ERROR,
        ALREADY_INVITED
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$BannerFilter.class */
    public enum BannerFilter {
        COMMON,
        BANNER,
        HEAD
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$BuyChestResponse.class */
    public enum BuyChestResponse {
        NEEDMONEY,
        ERROR,
        SUCCESS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ChatDataType.class */
    public enum ChatDataType {
        CHANGENICKNAME,
        COMMANDUNKNOWNPLAYER,
        COMMANDUNKNOWNADMIN,
        CLANLEVELRECEIVED,
        CLANPATENTRECEIVED,
        CLANCREATE,
        CLANMODTAG,
        MEMBERSEARCH,
        CLANDESC,
        INVITERECEIVE,
        CLANREGROUPRECEIVE,
        CLANINVITE
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClanActions.class */
    public enum ClanActions {
        CREATE,
        NEWMEMBER,
        REMOVEMEMBER,
        WARWIN,
        WARLOSE,
        NEWALLIANCE,
        REMOVEALLIANCE,
        NEWRIVAL,
        REMOVERIVAL,
        PROMOTEMEMBER,
        DEMOTEMEMBER,
        DEATHMEMBER,
        KILLMEMBER,
        CLANVERIFY
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClanCommandActions.class */
    public enum ClanCommandActions {
        CREATE,
        DELETE,
        JOIN,
        LEAVE,
        MODTAG
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClanLangs.class */
    public enum ClanLangs {
        EN,
        ES,
        BR,
        RU
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClanStorage.class */
    public enum ClanStorage {
        MYSQL,
        SQLITE,
        YAML
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClansAddons.class */
    public enum ClansAddons {
        ClanBank,
        ClanChest,
        ClanQuest,
        ClanWar,
        ClanGladiator,
        ClanLand,
        ClanLeaderboard,
        ClanNexus,
        ClanLeague,
        ClanGuardian,
        ClanRaid,
        ClanFarmCoins
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClansExtensions.class */
    public enum ClansExtensions {
        AnimatedScoreboard("AnimatedScoreboard"),
        BlueMap("BlueMap"),
        CMIHolograms("CMIHolograms"),
        DecentHolograms("DecentHolograms"),
        Dynmap("dynmap"),
        Eco("eco"),
        ElementalGems("ElementalGems"),
        FancyHolograms("FancyHolograms"),
        GriefDefender("GriefDefender"),
        GriefPrevention("GriefPrevention"),
        Holograms("Holograms"),
        HolographicDisplays("HolographicDisplays"),
        HuskClaims("HuskClaims"),
        ItemsAdder("ItemsAdder"),
        Nexo("Nexo"),
        PlayerPoints("PlayerPoints"),
        ProtectionStones("ProtectionStones"),
        TAB("TAB"),
        TokenEnchantMoney("TokenEnchant"),
        Vault("Vault"),
        CraftEngine("CraftEngine"),
        WorldGuardRegion("WorldGuard");

        private final String pluginName;

        ClansExtensions(String str) {
            this.pluginName = str;
        }

        public String getPluginName() {
            return this.pluginName;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ClansModules.class */
    public enum ClansModules {
        Anvil_26("Anvil_26", VersionUtil.VersionEnum.V261),
        Anvil_1_21("Anvil_1_21", VersionUtil.VersionEnum.V121),
        Anvil_1_20("Anvil_1_20", VersionUtil.VersionEnum.V120),
        Anvil_1_19("Anvil_1_19", VersionUtil.VersionEnum.V119),
        Anvil_1_18("Anvil_1_18", VersionUtil.VersionEnum.V118),
        Banner("Banner", null),
        Chat("Chat", null),
        Discord("Discord", null),
        Home("Home", null),
        Levelup("Levelup", null),
        Logger("Logger", null),
        Mail("Mail", null),
        Multiserver("Multiserver", null),
        Rewards("Rewards", null),
        Rivalally("Rivalally", null);

        private final String pluginName;
        private final VersionUtil.VersionEnum targetVersion;

        ClansModules(String str, VersionUtil.VersionEnum versionEnum) {
            this.pluginName = str;
            this.targetVersion = versionEnum;
        }

        public String getPluginName() {
            return this.pluginName;
        }

        public VersionUtil.VersionEnum getTargetVersion() {
            return this.targetVersion;
        }

        public boolean isCompatibleWithServer() {
            if (this.targetVersion == null) {
                return true;
            }
            return VersionUtil.is(this.targetVersion);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$DebugType.class */
    public enum DebugType {
        SENT,
        RECEIVED,
        DISPATCH
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$EnumExpand.class */
    public enum EnumExpand {
        VERT,
        UP,
        DOWN
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$EventState.class */
    public enum EventState {
        STOPED,
        INLOBBY,
        STARTED,
        ENDING,
        CANCELED,
        INWAIT
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$HoloPreference.class */
    public enum HoloPreference {
        ANY,
        CMI,
        HOLOGRAPHICDISPLAYS,
        HOLOGRAMS,
        DECENTHOLOGRAMS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ImportStorage.class */
    public enum ImportStorage {
        MYSQL,
        SQLITE
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$KdrChangeType.class */
    public enum KdrChangeType {
        RESET,
        KILL,
        DEATH
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$LoggerTime.class */
    public enum LoggerTime {
        ALL,
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$MailTime.class */
    public enum MailTime {
        ALL,
        READ,
        UNREAD
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$MoneyType.class */
    public enum MoneyType {
        VAULT,
        PLAYERPOINTS,
        CLANSOULS,
        TOKENENCHANT,
        DISABLED,
        ULTRAECONOMY,
        ELEMENTALGEMS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$MsgUsage.class */
    public enum MsgUsage {
        help,
        usage,
        error,
        success
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$PlaceholderPlayerTop.class */
    public enum PlaceholderPlayerTop {
        ALL,
        KDR,
        SOULS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$PlaceholderTop.class */
    public enum PlaceholderTop {
        KILL,
        DEATH,
        KDR,
        MEMBER,
        BANK,
        LEVEL,
        WAR,
        ALL,
        POINT,
        PATENT,
        SOULS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$PlayerLeaveReaction.class */
    public enum PlayerLeaveReaction {
        KICK,
        LEAVE
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$PlayerSettingsType.class */
    public enum PlayerSettingsType {
        INVITATIONS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$QueueSync.class */
    public enum QueueSync {
        Moderation,
        ClanAndPlayers,
        GetInvite,
        ClanData,
        UpdateClanPlayers,
        PlayerData
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$RedisType.class */
    public enum RedisType {
        EMPTY,
        CLANUPDATEUUID,
        PLAYERUPDATEUUID,
        INVITEUPDATEUUID,
        MODERATIONUPDATEUUID,
        PLAYERTELEPORT,
        CLANCHAT,
        CUSTOM,
        CLEARPRORYEDPLAYERS,
        PROXYEDPLAYERS,
        EVENTMESSAGES,
        CLANREWARDS,
        CLANMAILS,
        CLANLOGGER
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$ReloadType.class */
    public enum ReloadType {
        ALL,
        ADDONS,
        CONFIGURATIONS
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$RepoReturn.class */
    public enum RepoReturn {
        ERROR_REPO,
        ALREADY_UPDATED,
        ERROR_DOWNLOAD,
        SUCCESS_DOWNLOAD,
        SUCCESS_DOWNLOAD_RELOAD,
        ALREADY_EXISTS,
        NEED_RELOAD_ADDONS,
        GENERAL_ERROR
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$RivalAllyCount.class */
    public enum RivalAllyCount {
        RIVAL,
        ALLY
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$RivalRemoveReturn.class */
    public enum RivalRemoveReturn {
        SENDED,
        MODERATION_OFFLINE,
        ERROR,
        ALREADY_SENDED
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$SettingsFlagsAccept.class */
    public enum SettingsFlagsAccept {
        TRUE,
        FALSE,
        TOGGLE
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$SettingsType.class */
    public enum SettingsType {
        WARINVITE,
        ALLYSHAREDCHAT,
        JOINLEAVE,
        ALLYSHAREDHOME,
        CLANFF,
        OPENED,
        PUBLICHOMES,
        RECEIVEMAILALLIES,
        RECEIVEMAILALL,
        ALLYPVP
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$SoulsChangeType.class */
    public enum SoulsChangeType {
        RESET,
        KILL,
        DEATH
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$SyncName.class */
    public enum SyncName {
        NULL,
        UPDATE,
        CHEST,
        BROADCAST,
        CLANCHAT,
        INVITE,
        ALLYINVITE,
        RIVALREMOVE
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$TranslatableKey.class */
    public enum TranslatableKey {
        block,
        entity,
        item,
        biome,
        color,
        enchantment,
        gameMode
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanEnum$WarReturn.class */
    public enum WarReturn {
        SENDED,
        MODERATION_OFFLINE,
        ERROR,
        ALREADY_INVITED
    }
}
