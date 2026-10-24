package me.module.multiserver.library.redis.jedis;

import java.util.List;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ReliableTransaction.class */
public class ReliableTransaction extends TransactionBase {
    public ReliableTransaction(Connection connection) {
        super(connection);
    }

    public ReliableTransaction(Connection connection, boolean z) {
        super(connection, z);
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    protected final void processMultiResponse() {
        String statusCodeReply = this.connection.getStatusCodeReply();
        if (!"OK".equals(statusCodeReply)) {
            throw new JedisException("MULTI command failed. Received response: " + statusCodeReply);
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    protected final void processAppendStatus() {
        String statusCodeReply = this.connection.getStatusCodeReply();
        if (!"QUEUED".equals(statusCodeReply)) {
            throw new JedisException(statusCodeReply);
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    protected final void processPipelinedResponses() {
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    public final List<Object> exec() {
        return super.exec();
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    public final String discard() {
        String strDiscard = super.discard();
        if ("OK".equals(strDiscard)) {
            return strDiscard;
        }
        throw new JedisException("DISCARD command failed. Received response: " + strDiscard);
    }
}
