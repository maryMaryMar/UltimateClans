package me.module.multiserver.library.redis.jedis;

import java.util.Arrays;
import java.util.List;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisPubSub.class */
public abstract class JedisPubSub {
    private static final String JEDIS_SUBSCRIPTION_MESSAGE = "JedisPubSub is not subscribed to a Jedis instance.";
    private int subscribedChannels = 0;
    private volatile Connection client;

    public void onMessage(String str, String str2) {
    }

    public void onPMessage(String str, String str2, String str3) {
    }

    public void onSubscribe(String str, int i) {
    }

    public void onUnsubscribe(String str, int i) {
    }

    public void onPUnsubscribe(String str, int i) {
    }

    public void onPSubscribe(String str, int i) {
    }

    public void onPong(String str) {
    }

    public void unsubscribe() {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.UNSUBSCRIBE);
        this.client.flush();
    }

    public void unsubscribe(String... strArr) {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.UNSUBSCRIBE, strArr);
        this.client.flush();
    }

    public void subscribe(String... strArr) {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.SUBSCRIBE, strArr);
        this.client.flush();
    }

    public void psubscribe(String... strArr) {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.PSUBSCRIBE, strArr);
        this.client.flush();
    }

    public void punsubscribe() {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.PUNSUBSCRIBE);
        this.client.flush();
    }

    public void punsubscribe(String... strArr) {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.PUNSUBSCRIBE, strArr);
        this.client.flush();
    }

    public void ping() {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.PING);
        this.client.flush();
    }

    public void ping(String str) {
        if (this.client == null) {
            throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
        }
        this.client.sendCommand(Protocol.Command.PING, str);
        this.client.flush();
    }

    public boolean isSubscribed() {
        return this.subscribedChannels > 0;
    }

    public void proceedWithPatterns(Connection connection, String... strArr) {
        this.client = connection;
        this.client.setTimeoutInfinite();
        try {
            psubscribe(strArr);
            process();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public void proceed(Connection connection, String... strArr) {
        this.client = connection;
        this.client.setTimeoutInfinite();
        try {
            subscribe(strArr);
            process();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    private void process() {
        do {
            List<Object> unflushedObjectMultiBulkReply = this.client.getUnflushedObjectMultiBulkReply();
            Object obj = unflushedObjectMultiBulkReply.get(0);
            if (!(obj instanceof byte[])) {
                throw new JedisException("Unknown message type: " + obj);
            }
            byte[] bArr = (byte[]) obj;
            if (Arrays.equals(Protocol.ResponseKeyword.SUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                byte[] bArr2 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                onSubscribe(bArr2 == null ? null : SafeEncoder.encode(bArr2), this.subscribedChannels);
            } else if (Arrays.equals(Protocol.ResponseKeyword.UNSUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                byte[] bArr3 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                onUnsubscribe(bArr3 == null ? null : SafeEncoder.encode(bArr3), this.subscribedChannels);
            } else if (Arrays.equals(Protocol.ResponseKeyword.MESSAGE.getRaw(), bArr)) {
                byte[] bArr4 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                byte[] bArr5 = (byte[]) unflushedObjectMultiBulkReply.get(2);
                onMessage(bArr4 == null ? null : SafeEncoder.encode(bArr4), bArr5 == null ? null : SafeEncoder.encode(bArr5));
            } else if (Arrays.equals(Protocol.ResponseKeyword.PMESSAGE.getRaw(), bArr)) {
                byte[] bArr6 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                byte[] bArr7 = (byte[]) unflushedObjectMultiBulkReply.get(2);
                byte[] bArr8 = (byte[]) unflushedObjectMultiBulkReply.get(3);
                onPMessage(bArr6 == null ? null : SafeEncoder.encode(bArr6), bArr7 == null ? null : SafeEncoder.encode(bArr7), bArr8 == null ? null : SafeEncoder.encode(bArr8));
            } else if (Arrays.equals(Protocol.ResponseKeyword.PSUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                byte[] bArr9 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                onPSubscribe(bArr9 == null ? null : SafeEncoder.encode(bArr9), this.subscribedChannels);
            } else if (Arrays.equals(Protocol.ResponseKeyword.PUNSUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                byte[] bArr10 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                onPUnsubscribe(bArr10 == null ? null : SafeEncoder.encode(bArr10), this.subscribedChannels);
            } else {
                if (!Arrays.equals(Protocol.ResponseKeyword.PONG.getRaw(), bArr)) {
                    throw new JedisException("Unknown message type: " + obj);
                }
                byte[] bArr11 = (byte[]) unflushedObjectMultiBulkReply.get(1);
                onPong(bArr11 == null ? null : SafeEncoder.encode(bArr11));
            }
        } while (isSubscribed());
    }

    public int getSubscribedChannels() {
        return this.subscribedChannels;
    }
}
