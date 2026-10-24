package me.module.multiserver.library.redis.jedis;

import java.util.Arrays;
import java.util.List;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/BinaryJedisPubSub.class */
public abstract class BinaryJedisPubSub {
    private int subscribedChannels = 0;
    private Connection client;

    public void onMessage(byte[] bArr, byte[] bArr2) {
    }

    public void onPMessage(byte[] bArr, byte[] bArr2, byte[] bArr3) {
    }

    public void onSubscribe(byte[] bArr, int i) {
    }

    public void onUnsubscribe(byte[] bArr, int i) {
    }

    public void onPUnsubscribe(byte[] bArr, int i) {
    }

    public void onPSubscribe(byte[] bArr, int i) {
    }

    public void onPong(byte[] bArr) {
    }

    public void unsubscribe() {
        this.client.sendCommand(Protocol.Command.UNSUBSCRIBE);
        this.client.flush();
    }

    public void unsubscribe(byte[]... bArr) {
        this.client.sendCommand(Protocol.Command.UNSUBSCRIBE, bArr);
        this.client.flush();
    }

    public void subscribe(byte[]... bArr) {
        this.client.sendCommand(Protocol.Command.SUBSCRIBE, bArr);
        this.client.flush();
    }

    public void psubscribe(byte[]... bArr) {
        this.client.sendCommand(Protocol.Command.PSUBSCRIBE, bArr);
        this.client.flush();
    }

    public void punsubscribe() {
        this.client.sendCommand(Protocol.Command.PUNSUBSCRIBE);
        this.client.flush();
    }

    public void punsubscribe(byte[]... bArr) {
        this.client.sendCommand(Protocol.Command.PUNSUBSCRIBE, bArr);
        this.client.flush();
    }

    public void ping() {
        this.client.sendCommand(Protocol.Command.PING);
        this.client.flush();
    }

    public void ping(byte[] bArr) {
        this.client.sendCommand(Protocol.Command.PING, bArr);
        this.client.flush();
    }

    public boolean isSubscribed() {
        return this.subscribedChannels > 0;
    }

    public void proceedWithPatterns(Connection connection, byte[]... bArr) {
        this.client = connection;
        this.client.setTimeoutInfinite();
        try {
            psubscribe(bArr);
            process();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public void proceed(Connection connection, byte[]... bArr) {
        this.client = connection;
        this.client.setTimeoutInfinite();
        try {
            subscribe(bArr);
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
                onSubscribe((byte[]) unflushedObjectMultiBulkReply.get(1), this.subscribedChannels);
            } else if (Arrays.equals(Protocol.ResponseKeyword.UNSUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                onUnsubscribe((byte[]) unflushedObjectMultiBulkReply.get(1), this.subscribedChannels);
            } else if (Arrays.equals(Protocol.ResponseKeyword.MESSAGE.getRaw(), bArr)) {
                onMessage((byte[]) unflushedObjectMultiBulkReply.get(1), (byte[]) unflushedObjectMultiBulkReply.get(2));
            } else if (Arrays.equals(Protocol.ResponseKeyword.PMESSAGE.getRaw(), bArr)) {
                onPMessage((byte[]) unflushedObjectMultiBulkReply.get(1), (byte[]) unflushedObjectMultiBulkReply.get(2), (byte[]) unflushedObjectMultiBulkReply.get(3));
            } else if (Arrays.equals(Protocol.ResponseKeyword.PSUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                onPSubscribe((byte[]) unflushedObjectMultiBulkReply.get(1), this.subscribedChannels);
            } else if (Arrays.equals(Protocol.ResponseKeyword.PUNSUBSCRIBE.getRaw(), bArr)) {
                this.subscribedChannels = ((Long) unflushedObjectMultiBulkReply.get(2)).intValue();
                onPUnsubscribe((byte[]) unflushedObjectMultiBulkReply.get(1), this.subscribedChannels);
            } else {
                if (!Arrays.equals(Protocol.ResponseKeyword.PONG.getRaw(), bArr)) {
                    throw new JedisException("Unknown message type: " + obj);
                }
                onPong((byte[]) unflushedObjectMultiBulkReply.get(1));
            }
        } while (isSubscribed());
    }

    public int getSubscribedChannels() {
        return this.subscribedChannels;
    }
}
