package me.module.multiserver.library.redis.jedis;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Transaction.class */
public class Transaction extends TransactionBase {
    private final Jedis jedis;

    public Transaction(Jedis jedis) {
        super(jedis.getConnection());
        this.jedis = jedis;
    }

    public Transaction(Connection connection) {
        super(connection);
        this.jedis = null;
    }

    public Transaction(Connection connection, boolean z) {
        super(connection, z);
        this.jedis = null;
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    protected final void processMultiResponse() {
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    protected final void processAppendStatus() {
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    protected final void processPipelinedResponses() {
        this.connection.getMany(1 + getPipelinedResponseLength());
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    public final List<Object> exec() {
        try {
            return super.exec();
        } finally {
            if (this.jedis != null) {
                this.jedis.resetState();
            }
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.TransactionBase
    public final String discard() {
        try {
            return super.discard();
        } finally {
            if (this.jedis != null) {
                this.jedis.resetState();
            }
        }
    }
}
