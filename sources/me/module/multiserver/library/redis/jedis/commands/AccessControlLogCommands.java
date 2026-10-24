package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.resps.AccessControlLogEntry;
import me.module.multiserver.library.redis.jedis.resps.AccessControlUser;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/AccessControlLogCommands.class */
public interface AccessControlLogCommands {
    String aclWhoAmI();

    String aclGenPass();

    String aclGenPass(int i);

    List<String> aclList();

    List<String> aclUsers();

    AccessControlUser aclGetUser(String str);

    String aclSetUser(String str);

    String aclSetUser(String str, String... strArr);

    long aclDelUser(String str);

    long aclDelUser(String str, String... strArr);

    List<String> aclCat();

    List<String> aclCat(String str);

    List<AccessControlLogEntry> aclLog();

    List<AccessControlLogEntry> aclLog(int i);

    String aclLogReset();

    String aclLoad();

    String aclSave();

    String aclDryRun(String str, String str2, String... strArr);

    String aclDryRun(String str, CommandArguments commandArguments);
}
