package me.module.home.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/EnumFiles/Chat.class */
public enum Chat implements ConfigurationEnum {
    CHAT_clanhomecreate("Chat.clanhomecreate", "", " "),
    CHAT_clanhomecreate_enabled("Chat.clanhomecreate.enabled", true, new String[0]),
    CHAT_clanhomecreate_time("Chat.clanhomecreate.time", 60, new String[0]),
    CHAT_clanhomecreate_sound_enabled("Chat.clanhomecreate.sound.enabled", false, new String[0]),
    CHAT_clanhomecreate_sound_display("Chat.clanhomecreate.sound.display", "", new String[0]),
    CHAT_clanhomecreate_message_enabled("Chat.clanhomecreate.message.enabled", true, new String[0]),
    CHAT_clanhomecreate_message_center("Chat.clanhomecreate.message.center", false, new String[0]),
    CHAT_clanhomecreate_bossbar_enabled("Chat.clanhomecreate.bossbar.enabled", true, new String[0]),
    CHAT_clanhomecreate_bossbar_color("Chat.clanhomecreate.bossbar.color", "YELLOW", new String[0]),
    CHAT_clanhomecreate_bossbar_style("Chat.clanhomecreate.bossbar.style", "PROGRESS", new String[0]),
    CHAT_clanhomecreate_bossbar_flags("Chat.clanhomecreate.bossbar.flags", Arrays.asList(new Object[0]), new String[0]),
    CHAT_clanhomecreate_bossbar_animated("Chat.clanhomecreate.bossbar.animated", true, new String[0]),
    CHAT_clanhomecreate_title_enabled("Chat.clanhomecreate.title.enabled", true, new String[0]),
    CHAT_clanhomecreate_actionbar_enabled("Chat.clanhomecreate.actionbar.enabled", true, new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Chat(String str, Object obj, String... strArr) {
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
