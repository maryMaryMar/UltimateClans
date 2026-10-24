package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/AbstractWrappedByteChannel.class */
@Deprecated
public class AbstractWrappedByteChannel implements WrappedByteChannel {
    private final ByteChannel channel;

    @Deprecated
    public AbstractWrappedByteChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    @Deprecated
    public AbstractWrappedByteChannel(WrappedByteChannel wrappedByteChannel) {
        this.channel = wrappedByteChannel;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.channel.read(byteBuffer);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.channel.close();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return this.channel.write(byteBuffer);
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return (this.channel instanceof WrappedByteChannel) && ((WrappedByteChannel) this.channel).isNeedWrite();
    }

    @Override // org.java_websocket.WrappedByteChannel
    public void writeMore() {
        if (this.channel instanceof WrappedByteChannel) {
            ((WrappedByteChannel) this.channel).writeMore();
        }
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return (this.channel instanceof WrappedByteChannel) && ((WrappedByteChannel) this.channel).isNeedRead();
    }

    @Override // org.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) this.channel).readMore(byteBuffer);
        }
        return 0;
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        if (this.channel instanceof SocketChannel) {
            return ((SocketChannel) this.channel).isBlocking();
        }
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) this.channel).isBlocking();
        }
        return false;
    }
}
