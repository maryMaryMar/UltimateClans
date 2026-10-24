package me.module.discord.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/data/ChatMessageDTO.class */
public class ChatMessageDTO {
    private String uuid;
    private String nickname;
    private String role;
    private String message;
    private String server;

    public ChatMessageDTO(String str, String str2, String str3, String str4, String str5) {
        this.uuid = str;
        this.nickname = str2;
        this.role = str3;
        this.message = str4;
        this.server = str5;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRole() {
        return this.role;
    }

    public String getMessage() {
        return this.message;
    }

    public String getServer() {
        return this.server;
    }
}
