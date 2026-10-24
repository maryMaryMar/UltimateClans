package me.module.multiserver.library.redis.jedis;

import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.exceptions.JedisClusterOperationException;
import me.module.multiserver.library.redis.jedis.util.JedisClusterCRC16;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ClusterCommandArguments.class */
public class ClusterCommandArguments extends CommandArguments {
    private int commandHashSlot;

    public ClusterCommandArguments(ProtocolCommand protocolCommand) {
        super(protocolCommand);
        this.commandHashSlot = -1;
    }

    public int getCommandHashSlot() {
        return this.commandHashSlot;
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandArguments
    protected CommandArguments processKey(byte[] bArr) {
        int slot = JedisClusterCRC16.getSlot(bArr);
        if (this.commandHashSlot < 0) {
            this.commandHashSlot = slot;
        } else if (this.commandHashSlot != slot) {
            throw new JedisClusterOperationException("Keys must belong to same hashslot.");
        }
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandArguments
    protected CommandArguments processKey(String str) {
        int slot = JedisClusterCRC16.getSlot(str);
        if (this.commandHashSlot < 0) {
            this.commandHashSlot = slot;
        } else if (this.commandHashSlot != slot) {
            throw new JedisClusterOperationException("Keys must belong to same hashslot.");
        }
        return this;
    }
}
