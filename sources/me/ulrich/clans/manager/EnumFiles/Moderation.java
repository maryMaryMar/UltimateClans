package me.ulrich.clans.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/EnumFiles/Moderation.class */
public enum Moderation implements ConfigurationEnum {
    Moderation("Moderation", "", "# This file contains changes to member roles and promotions", "# This setting requires advanced knowledge as it affects addons too!", "# usage: KEY:DEFAULT VALUE ex (KICK:true/false, KICK:0/1) always use boolean value. Values \u200b\u200bnot added are always considered FALSE", "# Applicable permissions list:", "# DEFAULT - MANDATORY FOR EMPTY PERMISSION", "# KICK - Kick members", "# INVITE - Send invites", "# BAN - Ban players", "# UNBAN - Unban players", "# MODTAG - Change the clan tag", "# DISBAND - Disband the clan !CAUTION", "# HOMEMANAGER - Criar and delete homes", "# REGROUP - Use clan regroup", "# FF - Toggle clan ff", "# DESC - Change clan description", "# SETTINGS - Open, read and edit in settings", "# PERMISSIONS - Open, read and edit member permissions", "# EDIT_WEBHOOK - Edit and delete clan discord webhook", "# PROMOTE - Promote Members", "# DEMOTE - Demote Members", " ", "# Addon permissions are in the config.yml of each addon."),
    Moderation_just_edit_permissions_below("Moderation.just_edit_permissions_below", true, " ", " ", "# This setting only allows you to edit roles below him, for example a load with priority 2 cannot edit loads with priority 3"),
    Moderation_disable_actions_higher_roles("Moderation.disable_actions_higher_roles", true, " ", " ", "# With this option, lower positions cannot reach higher roles such as Ban, Kick, Promote and Demote."),
    Moderation_update("Moderation.update", "", " ", " ", "# If the DEFAULT permissions are changed, the clans can update the Roles."),
    Moderation_update_enabled("Moderation.update.enabled", true, "# enable update button"),
    Moderation_update_cooldown("Moderation.update.cooldown", 3600, "# in seconds"),
    Moderation_list("Moderation.list", "", " ", " ", "# Use this formatting as an example or uncomment the lines:", "# EXAMPLE", "#    list:", "#      member:", "#        name: '<gray>Member'", "#        priority: 0", "#        upgradable: true", "#        icon:", "#            material: STONE", "#            name: '<gray>Member Permissions'", "#            lore:", "#            - ' <yellow>Click to edit'", "#            glow: true", "#            amount: 1", "#            model: 0", "#            texture: ''", "#            slot: 7", "#        editable: true", "#        default_permissions:", "#        - 'DEFAULT:true'", "#      moderator:", "#        name: '<green>Mod'", "#        priority: 1", "#        upgradable: true", "#        icon:", "#            material: STONE", "#            name: '<green>Mod Permissions'", "#            lore:", "#            - ' <yellow>Click to edit'", "#            glow: true", "#            amount: 1", "#            model: 0", "#            texture: ''", "#            slot: 8", "#        editable: true", "#        default_permissions:", "#        - 'KICK:true'", "#        - 'INVITE:true'", "#      admin:", "#        name: '<yellow>Admin'", "#        priority: 2", "#        upgradable: true", "#        icon:", "#            material: STONE", "#            name: '<yellow>Admin Permissions'", "#            lore:", "#            - ' <yellow>Click to edit'", "#            glow: true", "#            amount: 1", "#            model: 0", "#            texture: ''", "#            slot: 9", "#        editable: true", "#        default_permissions:", "#        - 'KICK:true'", "#        - 'INVITE:true'", "#        - 'BAN:true'", "#        - 'UNBAN:true'", "#        - 'MODTAG:true'", "#        - 'HOMEMANAGER:true'", "#        - 'PERMISSIONS:true'", "#        - 'EDIT_WEBHOOK:true'", "#      leader:", "#        name: '<red>Leader'", "#        priority: 100", "#        upgradable: false", "#        icon:", "#            material: STONE", "#            name: '<red>Leader'", "#            lore:", "#            - ' <red>These permissions are not editable'", "#            glow: true", "#            amount: 1", "#            model: 0", "#            texture: ''", "#            slot: 10", "#        default_permissions:", "#        - 'DEFAULT:true'"),
    Moderation_list_member("Moderation.list.member", "", "# Default first role."),
    Moderation_list_member_name("Moderation.list.member.name", "<gray>Member", "# The name that will appear in menus, placeholders, and commands."),
    Moderation_list_member_priority("Moderation.list.member.priority", 0, "# Priority is in ascending order, for example 0 for members, 1 for moderator, the higher the position, the higher the priority."),
    Moderation_list_member_default_permissions("Moderation.list.member.default_permissions", Arrays.asList("DEFAULT:true"), "# usage: KEY:DEFAULT VALUE ex (KEY:true or false, KEY:0 or 1) always use boolean value."),
    Moderation_list_member_editable("Moderation.list.member.editable", true, "# Can the leader change these permissions?"),
    Moderation_list_member_upgradable("Moderation.list.member.upgradable", true, "# Can it be achieved with promotion?"),
    Moderation_list_member_icon("Moderation.list.member.icon", "", "# Icon for GUI menus"),
    Moderation_list_member_icon_material("Moderation.list.member.icon.material", "PLAYER_HEAD", new String[0]),
    Moderation_list_member_icon_name("Moderation.list.member.icon.name", "<gray>Member Permissions", new String[0]),
    Moderation_list_member_icon_lore("Moderation.list.member.icon.lore", Arrays.asList("", " <yellow>Click to edit member permissions"), new String[0]),
    Moderation_list_member_icon_glow("Moderation.list.member.icon.glow", "true", new String[0]),
    Moderation_list_member_icon_amount("Moderation.list.member.icon.amount", 1, new String[0]),
    Moderation_list_member_icon_model("Moderation.list.member.icon.model", 0, new String[0]),
    Moderation_list_member_icon_texture("Moderation.list.member.icon.texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQxZmFjNmIyYTgyODg1ODk1YzVhN2I2OTc2OWE4NWFmOTBhZmRkOGMzZDNhYjUxOTRjYzU3ODU5MTBiZDM0NSJ9fX0=", new String[0]),
    Moderation_list_member_icon_slot("Moderation.list.member.icon.slot", 11, new String[0]),
    Moderation_list_leader("Moderation.list.leader", "", "# This is the leader configuration"),
    Moderation_list_leader_name("Moderation.list.leader.name", "<red>Leader", "# The name that will appear in menus, placeholders, and commands."),
    Moderation_list_leader_priority("Moderation.list.leader.priority", 100, "# Priority is in ascending order, for example 0 for leaders, 1 for moderator, the higher the position, the higher the priority."),
    Moderation_list_leader_default_permissions("Moderation.list.leader.default_permissions", Arrays.asList("DEFAULT:true"), "# usage: KEY:DEFAULT VALUE ex (KEY:true or false, KEY:0 or 1) always use boolean value."),
    Moderation_list_leader_icon("Moderation.list.leader.icon", "", "# Icon for GUI menus"),
    Moderation_list_leader_icon_material("Moderation.list.leader.icon.material", "PLAYER_HEAD", new String[0]),
    Moderation_list_leader_icon_name("Moderation.list.leader.icon.name", "<red>Leader", new String[0]),
    Moderation_list_leader_icon_lore("Moderation.list.leader.icon.lore", Arrays.asList("", " <red>These permissions are not editable"), new String[0]),
    Moderation_list_leader_icon_glow("Moderation.list.leader.icon.glow", "false", new String[0]),
    Moderation_list_leader_icon_amount("Moderation.list.leader.icon.amount", 1, new String[0]),
    Moderation_list_leader_icon_model("Moderation.list.leader.icon.model", 0, new String[0]),
    Moderation_list_leader_icon_texture("Moderation.list.leader.icon.texture", "%uclans_leader_head%", new String[0]),
    Moderation_list_leader_icon_slot("Moderation.list.leader.icon.slot", 10, new String[0]),
    Moderation_permissions("Moderation.permissions", "", "# DEFAULT - MANDATORY FOR EMPTY PERMISSION", "# KICK - Kick members", "# INVITE - Send invites", "# BAN - Ban players", "# UNBAN - Unban players", "# MODTAG - Change the clan tag", "# DISBAND - Disband the clan !CAUTION", "# HOMEMANAGER - Criar and delete homes", "# REGROUP - Use clan regroup", "# FF - Toggle clan ff", "# DESC - Change clan description", "# SETTINGS - Open, read and edit in settings !CAUTION", "# PERMISSIONS - Open, read and edit member permissions !CAUTION", "# EDIT_WEBHOOK - Open, read and edit discord webhook", "# PROMOTE - Permission to promote a member", "# DEMOTE - Permission to demote a member"),
    Moderation_permissions_DEFAULT("Moderation.permissions.DEFAULT.name", "Default", new String[0]),
    Moderation_permissions_KICK("Moderation.permissions.KICK.name", "Kick-Members", new String[0]),
    Moderation_permissions_INVITE("Moderation.permissions.INVITE.name", "Invite-Members", new String[0]),
    Moderation_permissions_BAN("Moderation.permissions.BAN.name", "Ban-Member", new String[0]),
    Moderation_permissions_UNBAN("Moderation.permissions.UNBAN.name", "Unban-Member", new String[0]),
    Moderation_permissions_MODTAG("Moderation.permissions.MODTAG.name", "Modtag", new String[0]),
    Moderation_permissions_DISBAND("Moderation.permissions.DISBAND.name", "Disband", new String[0]),
    Moderation_permissions_REGROUP("Moderation.permissions.REGROUP.name", "Regroup-Invite", new String[0]),
    Moderation_permissions_FF("Moderation.permissions.FF.name", "FF", new String[0]),
    Moderation_permissions_DESC("Moderation.permissions.DESC.name", "Change-Desc", new String[0]),
    Moderation_permissions_SETTINGS("Moderation.permissions.SETTINGS.name", "Manage-Settings", new String[0]),
    Moderation_permissions_PERMISSIONS("Moderation.permissions.PERMISSIONS.name", "Change-Permissions", new String[0]),
    Moderation_permissions_EDIT_WEBHOOK("Moderation.permissions.EDIT_WEBHOOK.name", "Edit-Webhook", new String[0]),
    Moderation_permissions_PROMOTE("Moderation.permissions.PROMOTE.name", "Promote-Members", new String[0]),
    Moderation_permissions_DEMOTE("Moderation.permissions.DEMOTE.name", "Demote-Members", new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Moderation(String str, Object obj, String... strArr) {
        this.path = str;
        this.defaultValue = obj;
        this.comments = strArr;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public String getPath() {
        return this.path;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public String[] getComments() {
        return this.comments;
    }
}
