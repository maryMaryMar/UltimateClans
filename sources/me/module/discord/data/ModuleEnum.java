package me.module.discord.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/data/ModuleEnum.class */
public class ModuleEnum {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/data/ModuleEnum$ModuleLang.class */
    public enum ModuleLang {
        EN
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/data/ModuleEnum$Webhook.class */
    public enum Webhook {
        CONNECTED,
        DISCONNECTED;

        public static Webhook fromString(String str) {
            if (str == null) {
                return DISCONNECTED;
            }
            for (Webhook webhook : values()) {
                if (webhook.name().equalsIgnoreCase(str)) {
                    return webhook;
                }
            }
            return DISCONNECTED;
        }
    }
}
