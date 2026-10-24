package me.module.multiserver.manager.EnumFiles;

import me.module.multiserver.library.redis.jedis.Protocol;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    SYNC_high("Sync.high", "", new String[0]),
    SYNC_high_enabled("Sync.high.enabled", false, new String[0]),
    SYNC_high_cache_sync_delay("Sync.high.sync_delay", 40, "# in ticks"),
    SYNC_high_server_name("Sync.high.server_name", "Clans", "# unique name"),
    SYNC_high_redis_channel("Sync.high.redis.channel", "uclans:highsync", "# redis channel"),
    SYNC_HIGH_REDIS_HOST("Sync.high.redis.host", "localhost", "# Redis server address"),
    SYNC_HIGH_REDIS_PORT("Sync.high.redis.port", Integer.valueOf(Protocol.DEFAULT_PORT), "# Redis server port"),
    SYNC_HIGH_REDIS_USER("Sync.high.redis.user", "", "# Authentication user (Redis 6 ACL). Leave empty if not used."),
    SYNC_HIGH_REDIS_PASSWORD("Sync.high.redis.password", "password", "# Authentication password. Leave empty if not used."),
    SYNC_HIGH_REDIS_DATABASE("Sync.high.redis.database", 0, "# Database number (Index)"),
    SYNC_HIGH_REDIS_SSL("Sync.high.redis.ssl", false, "# Enable secure connection via SSL/TLS"),
    SYNC_high_debug("Sync.high.debug", "", " "),
    SYNC_high_debug_console_messages_sent("Sync.high.debug.console_messages_sent", false, new String[0]),
    SYNC_high_debug_file_messages_sent("Sync.high.debug.file_messages_sent", false, new String[0]),
    SYNC_high_debug_console_received_messages("Sync.high.debug.console_received_messages", false, new String[0]),
    SYNC_high_debug_file_received_messages("Sync.high.debug.file_received_messages", false, new String[0]),
    SYNC_high_debug_dispatch_dispatch("Sync.high.debug.dispatch", false, new String[0]),
    SYNC_high_debug_file_dispatch_dispatch("Sync.high.debug.file_dispatch", false, new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Config(String str, Object obj, String... strArr) {
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
