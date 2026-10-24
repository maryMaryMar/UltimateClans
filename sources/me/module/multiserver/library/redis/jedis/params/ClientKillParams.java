package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.args.ClientType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ClientKillParams.class */
public class ClientKillParams extends Params {
    private static final String ID = "ID";
    private static final String TYPE = "TYPE";
    private static final String ADDR = "ADDR";
    private static final String SKIPME = "SKIPME";
    private static final String USER = "USER";
    private static final String LADDR = "LADDR";

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ClientKillParams$SkipMe.class */
    public enum SkipMe {
        YES,
        NO
    }

    public static ClientKillParams clientKillParams() {
        return new ClientKillParams();
    }

    public ClientKillParams id(String str) {
        addParam(ID, str);
        return this;
    }

    public ClientKillParams id(byte[] bArr) {
        addParam(ID, bArr);
        return this;
    }

    public ClientKillParams type(ClientType clientType) {
        addParam(TYPE, clientType);
        return this;
    }

    public ClientKillParams addr(String str) {
        addParam(ADDR, str);
        return this;
    }

    public ClientKillParams addr(byte[] bArr) {
        addParam(ADDR, bArr);
        return this;
    }

    public ClientKillParams addr(String str, int i) {
        addParam(ADDR, str + ':' + i);
        return this;
    }

    public ClientKillParams skipMe(SkipMe skipMe) {
        addParam(SKIPME, skipMe);
        return this;
    }

    public ClientKillParams user(String str) {
        addParam(USER, str);
        return this;
    }

    public ClientKillParams laddr(String str) {
        addParam(LADDR, str);
        return this;
    }

    public ClientKillParams laddr(String str, int i) {
        addParam(LADDR, str + ':' + i);
        return this;
    }
}
