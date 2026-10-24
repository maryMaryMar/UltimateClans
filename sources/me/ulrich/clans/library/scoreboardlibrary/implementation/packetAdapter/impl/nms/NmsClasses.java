package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsClasses.class */
public final class NmsClasses {
    private static final String OLD_NMS_VERSION_STRING;
    public static final boolean IS_1_8_OR_ABOVE;
    public static final boolean IS_1_9_OR_ABOVE;
    public static final boolean IS_1_13_OR_ABOVE;
    public static final boolean IS_1_20_2_OR_ABOVE;
    public static final boolean IS_1_20_3_OR_ABOVE;
    public static final boolean IS_1_20_5_OR_ABOVE;
    public static final boolean IS_1_21_5_OR_ABOVE;
    public static final boolean IS_1_21_6_OR_ABOVE;
    public static final boolean IS_26_2_OR_ABOVE;
    public static final Class<?> PKT_CLASS;
    public static final Class<?> SET_OBJECTIVE_PKT_CLASS;
    public static final Class<?> SET_DISPLAY_OBJECTIVE_PKT_CLASS;
    public static final Class<?> SET_SCORE_PKT_CLASS;
    public static final Class<?> RESET_SCORE_PKT_CLASS;
    public static final Class<?> SET_PLAYER_TEAM_PKT_CLASS;
    public static final Class<?> TEAM_PARAMETERS_PKT_CLASS;
    public static final Class<?> COMPONENT_CLASS;
    public static final Class<?> CHAT_SERIALIZER_CLASS;
    public static final Class<?> COMPONENT_SERIALIZATION_CLASS;
    public static final Class<?> STYLE_CLASS;
    public static final Class<?> STYLE_SERIALIZER_CLASS;
    public static final Class<?> NUMBER_FORMAT_CLASS;
    public static final Class<?> DISPLAY_SLOT_CLASS;
    public static final Class<?> OBJECTIVE_CLASS;
    public static final Class<?> TEAM_VISIBILITY_CLASS;
    public static final Class<?> TEAM_COLLISION_RULE_CLASS;
    public static final Class<?> TEAM_COLOR_OR_CHAT_FORMATTING_CLASS;
    public static final Class<?> OBJECTIVE_CRITERIA_RENDER_TYPE_CLASS;
    public static final Class<?> DATA_RESULT_CLASS;
    public static final Class<?> DYNAMIC_OPS_CLASS;
    public static final Class<?> JSON_OPS_CLASS;
    public static final Class<?> CODEC_CLASS;
    public static final Class<?> CRAFT_REGISTRY_CLASS;
    public static final Class<?> CRAFT_PLAYER_CLASS;
    public static final Class<?> SERVER_PLAYER_CLASS;
    public static final Class<?> PLAYER_CONNECTION_CLASS;
    public static final Class<?> ADVENTURE_COMPONENT_CLASS;
    public static final Class<?> SCORE_ACTION_CLASS;
    private static final String CB_PACKAGE = Bukkit.getServer().getClass().getPackage().getName();
    public static final boolean IS_1_17_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.world.item.BundleItem");

    private NmsClasses() {
    }

    @Nullable
    private static String oldSpigotClassName(String str) {
        if (OLD_NMS_VERSION_STRING != null) {
            return "net.minecraft.server." + OLD_NMS_VERSION_STRING + "." + str;
        }
        return null;
    }

    @NotNull
    private static String craftBukkitClassName(String str) {
        return CB_PACKAGE + '.' + str;
    }

    static {
        if (IS_1_17_OR_ABOVE) {
            OLD_NMS_VERSION_STRING = null;
        } else {
            OLD_NMS_VERSION_STRING = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        }
        IS_1_8_OR_ABOVE = IS_1_17_OR_ABOVE || ReflectUtil.hasClass(oldSpigotClassName("IScoreboardCriteria$EnumScoreboardHealthDisplay"));
        IS_1_9_OR_ABOVE = IS_1_17_OR_ABOVE || ReflectUtil.hasClass(oldSpigotClassName("ScoreboardTeamBase$EnumTeamPush"));
        IS_1_13_OR_ABOVE = IS_1_17_OR_ABOVE || ReflectUtil.hasClass(oldSpigotClassName("EntityDolphin"));
        IS_1_20_2_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.world.scores.DisplaySlot");
        IS_1_20_3_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.network.chat.numbers.NumberFormat");
        IS_1_20_5_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.network.protocol.common.ClientboundTransferPacket");
        IS_1_21_5_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.world.item.component.BlocksAttacks");
        IS_1_21_6_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.server.dialog.Dialog");
        IS_26_2_OR_ABOVE = ReflectUtil.hasClass("net.minecraft.world.scores.TeamColor");
        PKT_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.protocol.Packet", oldSpigotClassName("Packet"));
        SET_OBJECTIVE_PKT_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.protocol.game.ClientboundSetObjectivePacket", "net.minecraft.network.protocol.game.PacketPlayOutScoreboardObjective", oldSpigotClassName("PacketPlayOutScoreboardObjective"));
        SET_DISPLAY_OBJECTIVE_PKT_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket", "net.minecraft.network.protocol.game.PacketPlayOutScoreboardDisplayObjective", oldSpigotClassName("PacketPlayOutScoreboardDisplayObjective"));
        SET_SCORE_PKT_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.protocol.game.ClientboundSetScorePacket", "net.minecraft.network.protocol.game.PacketPlayOutScoreboardScore", oldSpigotClassName("PacketPlayOutScoreboardScore"));
        RESET_SCORE_PKT_CLASS = ReflectUtil.getOptionalClass("net.minecraft.network.protocol.game.ClientboundResetScorePacket", "net.minecraft.network.protocol.game.ClientboundResetScorePacket");
        SET_PLAYER_TEAM_PKT_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket", "net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam", oldSpigotClassName("PacketPlayOutScoreboardTeam"));
        TEAM_PARAMETERS_PKT_CLASS = ReflectUtil.getOptionalClass("net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket$Parameters", "net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam$b");
        COMPONENT_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.chat.Component", "net.minecraft.network.chat.IChatBaseComponent", oldSpigotClassName("IChatBaseComponent"));
        CHAT_SERIALIZER_CLASS = ReflectUtil.getOptionalClass("net.minecraft.network.chat.Component$Serializer", "net.minecraft.network.chat.IChatBaseComponent$ChatSerializer", oldSpigotClassName("IChatBaseComponent$ChatSerializer"));
        COMPONENT_SERIALIZATION_CLASS = ReflectUtil.getOptionalClass("net.minecraft.network.chat.ComponentSerialization");
        STYLE_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.network.chat.Style", "net.minecraft.network.chat.ChatModifier", oldSpigotClassName("ChatModifier"));
        STYLE_SERIALIZER_CLASS = ReflectUtil.getOptionalClass("net.minecraft.network.chat.Style$Serializer", "net.minecraft.network.chat.ChatModifier$ChatModifierSerializer", oldSpigotClassName("ChatModifier$ChatModifierSerializer"));
        NUMBER_FORMAT_CLASS = ReflectUtil.getOptionalClass("net.minecraft.network.chat.numbers.NumberFormat");
        DISPLAY_SLOT_CLASS = ReflectUtil.getOptionalClass("net.minecraft.world.scores.DisplaySlot");
        OBJECTIVE_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.world.scores.Objective", "net.minecraft.world.scores.ScoreboardObjective", oldSpigotClassName("ScoreboardObjective"));
        TEAM_VISIBILITY_CLASS = ReflectUtil.getOptionalClass("net.minecraft.world.scores.Team$Visibility", "net.minecraft.world.scores.ScoreboardTeamBase$EnumNameTagVisibility", oldSpigotClassName("ScoreboardTeamBase$EnumNameTagVisibility"));
        TEAM_COLLISION_RULE_CLASS = ReflectUtil.getOptionalClass("net.minecraft.world.scores.Team$CollisionRule", "net.minecraft.world.scores.ScoreboardTeamBase$EnumTeamPush", oldSpigotClassName("ScoreboardTeamBase$EnumTeamPush"));
        TEAM_COLOR_OR_CHAT_FORMATTING_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.world.scores.TeamColor", "net.minecraft.ChatFormatting", "net.minecraft.EnumChatFormat", oldSpigotClassName("EnumChatFormat"));
        OBJECTIVE_CRITERIA_RENDER_TYPE_CLASS = ReflectUtil.getOptionalClass("net.minecraft.world.scores.criteria.ObjectiveCriteria$RenderType", "net.minecraft.world.scores.criteria.IScoreboardCriteria$EnumScoreboardHealthDisplay", oldSpigotClassName("IScoreboardCriteria$EnumScoreboardHealthDisplay"));
        DATA_RESULT_CLASS = ReflectUtil.getOptionalClass("com.mojang.serialization.DataResult");
        DYNAMIC_OPS_CLASS = ReflectUtil.getOptionalClass("com.mojang.serialization.DynamicOps");
        JSON_OPS_CLASS = ReflectUtil.getOptionalClass("com.mojang.serialization.JsonOps");
        CODEC_CLASS = ReflectUtil.getOptionalClass("com.mojang.serialization.Codec");
        CRAFT_REGISTRY_CLASS = ReflectUtil.getOptionalClass(craftBukkitClassName("CraftRegistry"));
        CRAFT_PLAYER_CLASS = ReflectUtil.getClassOrThrow(craftBukkitClassName("entity.CraftPlayer"));
        SERVER_PLAYER_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.server.level.ServerPlayer", "net.minecraft.server.level.EntityPlayer", oldSpigotClassName("EntityPlayer"));
        PLAYER_CONNECTION_CLASS = ReflectUtil.getClassOrThrow("net.minecraft.server.network.ServerGamePacketListenerImpl", "net.minecraft.server.network.PlayerConnection", oldSpigotClassName("PlayerConnection"));
        ADVENTURE_COMPONENT_CLASS = ReflectUtil.getOptionalClass("io.papermc.paper.adventure.AdventureComponent");
        SCORE_ACTION_CLASS = ReflectUtil.getOptionalClass("net.minecraft.server.ServerScoreboard$Method", "net.minecraft.server.ScoreboardServer$Action", oldSpigotClassName("ScoreboardServer$Action"), oldSpigotClassName("PacketPlayOutScoreboardScore$EnumScoreboardAction"));
    }
}
