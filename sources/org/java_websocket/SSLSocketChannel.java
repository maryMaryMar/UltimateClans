package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.java_websocket.interfaces.ISSLChannel;
import org.java_websocket.util.ByteBufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/SSLSocketChannel.class */
public class SSLSocketChannel implements ByteChannel, WrappedByteChannel, ISSLChannel {
    private final Logger log = LoggerFactory.getLogger((Class<?>) SSLSocketChannel.class);
    private final SocketChannel socketChannel;
    private final SSLEngine engine;
    private ByteBuffer myAppData;
    private ByteBuffer myNetData;
    private ByteBuffer peerAppData;
    private ByteBuffer peerNetData;
    private ExecutorService executor;

    /* JADX INFO: renamed from: org.java_websocket.SSLSocketChannel$1, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/SSLSocketChannel$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = new int[SSLEngineResult.HandshakeStatus.values().length];

        static {
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = new int[SSLEngineResult.Status.values().length];
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public SSLSocketChannel(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws SSLException {
        if (socketChannel == null || sSLEngine == null || this.executor == executorService) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel;
        this.engine = sSLEngine;
        this.executor = executorService;
        this.myNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
        this.peerNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
        this.engine.beginHandshake();
        if (doHandshake()) {
            if (selectionKey != null) {
                selectionKey.interestOps(selectionKey.interestOps() | 4);
            }
        } else {
            try {
                this.socketChannel.close();
            } catch (IOException e) {
                this.log.error("Exception during the closing of the channel", (Throwable) e);
            }
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.peerAppData.hasRemaining()) {
            this.peerAppData.flip();
            return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
        }
        this.peerNetData.compact();
        int i = this.socketChannel.read(this.peerNetData);
        if (i > 0 || this.peerNetData.hasRemaining()) {
            this.peerNetData.flip();
            if (this.peerNetData.hasRemaining()) {
                this.peerAppData.compact();
                try {
                    SSLEngineResult sSLEngineResultUnwrap = this.engine.unwrap(this.peerNetData, this.peerAppData);
                    switch (AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[sSLEngineResultUnwrap.getStatus().ordinal()]) {
                        case 1:
                            this.peerAppData.flip();
                            return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                        case 2:
                            this.peerAppData.flip();
                            return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                        case 3:
                            this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                            return read(byteBuffer);
                        case 4:
                            closeConnection();
                            byteBuffer.clear();
                            return -1;
                        default:
                            throw new IllegalStateException("Invalid SSL status: " + sSLEngineResultUnwrap.getStatus());
                    }
                } catch (SSLException e) {
                    this.log.error("SSLException during unwrap", (Throwable) e);
                    throw e;
                }
            }
        } else if (i < 0) {
            handleEndOfStream();
        }
        ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
        return i;
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer byteBuffer) throws SSLException {
        int iWrite = 0;
        while (byteBuffer.hasRemaining()) {
            this.myNetData.clear();
            SSLEngineResult sSLEngineResultWrap = this.engine.wrap(byteBuffer, this.myNetData);
            switch (AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[sSLEngineResultWrap.getStatus().ordinal()]) {
                case 1:
                    this.myNetData.flip();
                    while (this.myNetData.hasRemaining()) {
                        iWrite += this.socketChannel.write(this.myNetData);
                    }
                    break;
                case 2:
                    throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
                case 3:
                    this.myNetData = enlargePacketBuffer(this.myNetData);
                    break;
                case 4:
                    closeConnection();
                    return 0;
                default:
                    throw new IllegalStateException("Invalid SSL status: " + sSLEngineResultWrap.getStatus());
            }
        }
        return iWrite;
    }

    private boolean doHandshake() throws IOException {
        int applicationBufferSize = this.engine.getSession().getApplicationBufferSize();
        this.myAppData = ByteBuffer.allocate(applicationBufferSize);
        this.peerAppData = ByteBuffer.allocate(applicationBufferSize);
        this.myNetData.clear();
        this.peerNetData.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus = this.engine.getHandshakeStatus();
        boolean z = false;
        while (!z) {
            switch (AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()]) {
                case 1:
                    z = !this.peerNetData.hasRemaining();
                    if (z) {
                        return true;
                    }
                    this.socketChannel.write(this.peerNetData);
                    break;
                case 2:
                    if (this.socketChannel.read(this.peerNetData) < 0) {
                        if (this.engine.isInboundDone() && this.engine.isOutboundDone()) {
                            return false;
                        }
                        try {
                            this.engine.closeInbound();
                            break;
                        } catch (SSLException e) {
                        }
                        this.engine.closeOutbound();
                        handshakeStatus = this.engine.getHandshakeStatus();
                        break;
                    } else {
                        this.peerNetData.flip();
                        try {
                            SSLEngineResult sSLEngineResultUnwrap = this.engine.unwrap(this.peerNetData, this.peerAppData);
                            this.peerNetData.compact();
                            handshakeStatus = sSLEngineResultUnwrap.getHandshakeStatus();
                            switch (AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[sSLEngineResultUnwrap.getStatus().ordinal()]) {
                                case 1:
                                    break;
                                case 2:
                                    this.peerNetData = handleBufferUnderflow(this.peerNetData);
                                    break;
                                case 3:
                                    this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                                    break;
                                case 4:
                                    if (this.engine.isOutboundDone()) {
                                        return false;
                                    }
                                    this.engine.closeOutbound();
                                    handshakeStatus = this.engine.getHandshakeStatus();
                                    break;
                                default:
                                    throw new IllegalStateException("Invalid SSL status: " + sSLEngineResultUnwrap.getStatus());
                            }
                        } catch (SSLException e2) {
                            this.engine.closeOutbound();
                            handshakeStatus = this.engine.getHandshakeStatus();
                            break;
                        }
                    }
                    break;
                case 3:
                    this.myNetData.clear();
                    try {
                        SSLEngineResult sSLEngineResultWrap = this.engine.wrap(this.myAppData, this.myNetData);
                        handshakeStatus = sSLEngineResultWrap.getHandshakeStatus();
                        switch (AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[sSLEngineResultWrap.getStatus().ordinal()]) {
                            case 1:
                                this.myNetData.flip();
                                while (this.myNetData.hasRemaining()) {
                                    this.socketChannel.write(this.myNetData);
                                }
                                break;
                            case 2:
                                throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
                            case 3:
                                this.myNetData = enlargePacketBuffer(this.myNetData);
                                break;
                            case 4:
                                try {
                                    this.myNetData.flip();
                                    while (this.myNetData.hasRemaining()) {
                                        this.socketChannel.write(this.myNetData);
                                    }
                                    this.peerNetData.clear();
                                } catch (Exception e3) {
                                    handshakeStatus = this.engine.getHandshakeStatus();
                                }
                                break;
                            default:
                                throw new IllegalStateException("Invalid SSL status: " + sSLEngineResultWrap.getStatus());
                        }
                    } catch (SSLException e4) {
                        this.engine.closeOutbound();
                        handshakeStatus = this.engine.getHandshakeStatus();
                        break;
                    }
                    break;
                case 4:
                    while (true) {
                        Runnable delegatedTask = this.engine.getDelegatedTask();
                        if (delegatedTask == null) {
                            handshakeStatus = this.engine.getHandshakeStatus();
                        } else {
                            this.executor.execute(delegatedTask);
                        }
                        break;
                    }
                    break;
                case 5:
                    break;
                default:
                    throw new IllegalStateException("Invalid SSL status: " + handshakeStatus);
            }
        }
        return true;
    }

    private ByteBuffer enlargePacketBuffer(ByteBuffer byteBuffer) {
        return enlargeBuffer(byteBuffer, this.engine.getSession().getPacketBufferSize());
    }

    private ByteBuffer enlargeApplicationBuffer(ByteBuffer byteBuffer) {
        return enlargeBuffer(byteBuffer, this.engine.getSession().getApplicationBufferSize());
    }

    private ByteBuffer enlargeBuffer(ByteBuffer byteBuffer, int i) {
        return i > byteBuffer.capacity() ? ByteBuffer.allocate(i) : ByteBuffer.allocate(byteBuffer.capacity() * 2);
    }

    private ByteBuffer handleBufferUnderflow(ByteBuffer byteBuffer) {
        if (this.engine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer byteBufferEnlargePacketBuffer = enlargePacketBuffer(byteBuffer);
        byteBuffer.flip();
        byteBufferEnlargePacketBuffer.put(byteBuffer);
        return byteBufferEnlargePacketBuffer;
    }

    private void closeConnection() {
        this.engine.closeOutbound();
        try {
            doHandshake();
        } catch (IOException e) {
        }
        this.socketChannel.close();
    }

    private void handleEndOfStream() {
        try {
            this.engine.closeInbound();
        } catch (Exception e) {
            this.log.error("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
        }
        closeConnection();
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return false;
    }

    @Override // org.java_websocket.WrappedByteChannel
    public void writeMore() {
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return this.peerNetData.hasRemaining() || this.peerAppData.hasRemaining();
    }

    @Override // org.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        return read(byteBuffer);
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeConnection();
    }

    @Override // org.java_websocket.interfaces.ISSLChannel
    public SSLEngine getSSLEngine() {
        return this.engine;
    }
}
