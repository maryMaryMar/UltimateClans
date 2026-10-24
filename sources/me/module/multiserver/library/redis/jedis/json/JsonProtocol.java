package me.module.multiserver.library.redis.jedis.json;

import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/JsonProtocol.class */
public class JsonProtocol {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/JsonProtocol$JsonCommand.class */
    public enum JsonCommand implements ProtocolCommand {
        DEL("JSON.DEL"),
        GET("JSON.GET"),
        MGET("JSON.MGET"),
        SET("JSON.SET"),
        TYPE("JSON.TYPE"),
        STRAPPEND("JSON.STRAPPEND"),
        STRLEN("JSON.STRLEN"),
        NUMINCRBY("JSON.NUMINCRBY"),
        ARRAPPEND("JSON.ARRAPPEND"),
        ARRINDEX("JSON.ARRINDEX"),
        ARRINSERT("JSON.ARRINSERT"),
        ARRLEN("JSON.ARRLEN"),
        ARRPOP("JSON.ARRPOP"),
        ARRTRIM("JSON.ARRTRIM"),
        CLEAR("JSON.CLEAR"),
        TOGGLE("JSON.TOGGLE"),
        OBJKEYS("JSON.OBJKEYS"),
        OBJLEN("JSON.OBJLEN"),
        DEBUG("JSON.DEBUG"),
        RESP("JSON.RESP");

        private final byte[] raw;

        JsonCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }
}
