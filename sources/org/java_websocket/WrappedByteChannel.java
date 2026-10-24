package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/WrappedByteChannel.class */
public interface WrappedByteChannel extends ByteChannel {
    boolean isNeedWrite();

    void writeMore();

    boolean isNeedRead();

    int readMore(ByteBuffer byteBuffer);

    boolean isBlocking();
}
