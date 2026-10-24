package org.java_websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLSession;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.interfaces.ISSLChannel;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/WebSocketImpl.class */
public class WebSocketImpl implements WebSocket {
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_WSS_PORT = 443;
    public static final int RCVBUF = 16384;
    private final Logger log;
    public final BlockingQueue<ByteBuffer> outQueue;
    public final BlockingQueue<ByteBuffer> inQueue;
    private final WebSocketListener wsl;
    private SelectionKey key;
    private ByteChannel channel;
    private WebSocketServer.WebSocketWorker workerThread;
    private boolean flushandclosestate;
    private volatile ReadyState readyState;
    private List<Draft> knownDrafts;
    private Draft draft;
    private Role role;
    private ByteBuffer tmpHandshakeBytes;
    private ClientHandshake handshakerequest;
    private String closemessage;
    private Integer closecode;
    private Boolean closedremotely;
    private String resourceDescriptor;
    private long lastPong;
    private final Object synchronizeWriteObject;
    private Object attachment;
    static final /* synthetic */ boolean $assertionsDisabled;

    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list) {
        this(webSocketListener, (Draft) null);
        this.role = Role.SERVER;
        if (list != null && !list.isEmpty()) {
            this.knownDrafts = list;
        } else {
            this.knownDrafts = new ArrayList();
            this.knownDrafts.add(new Draft_6455());
        }
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.log = LoggerFactory.getLogger((Class<?>) WebSocketImpl.class);
        this.flushandclosestate = false;
        this.readyState = ReadyState.NOT_YET_CONNECTED;
        this.draft = null;
        this.tmpHandshakeBytes = ByteBuffer.allocate(0);
        this.handshakerequest = null;
        this.closemessage = null;
        this.closecode = null;
        this.closedremotely = null;
        this.resourceDescriptor = null;
        this.lastPong = System.nanoTime();
        this.synchronizeWriteObject = new Object();
        if (webSocketListener == null || (draft == null && this.role == Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.outQueue = new LinkedBlockingQueue();
        this.inQueue = new LinkedBlockingQueue();
        this.wsl = webSocketListener;
        this.role = Role.CLIENT;
        if (draft != null) {
            this.draft = draft.copyInstance();
        }
    }

    public void decode(ByteBuffer byteBuffer) {
        if (!$assertionsDisabled && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        this.log.trace("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.readyState != ReadyState.NOT_YET_CONNECTED) {
            if (this.readyState == ReadyState.OPEN) {
                decodeFrames(byteBuffer);
            }
        } else {
            if (!decodeHandshake(byteBuffer) || isClosing() || isClosed()) {
                return;
            }
            if (!$assertionsDisabled && this.tmpHandshakeBytes.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                decodeFrames(byteBuffer);
            } else if (this.tmpHandshakeBytes.hasRemaining()) {
                decodeFrames(this.tmpHandshakeBytes);
            }
        }
    }

    private boolean decodeHandshake(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.tmpHandshakeBytes.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.tmpHandshakeBytes.remaining() < byteBuffer.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + byteBuffer.remaining());
                this.tmpHandshakeBytes.flip();
                byteBufferAllocate.put(this.tmpHandshakeBytes);
                this.tmpHandshakeBytes = byteBufferAllocate;
            }
            this.tmpHandshakeBytes.put(byteBuffer);
            this.tmpHandshakeBytes.flip();
            byteBuffer2 = this.tmpHandshakeBytes;
        }
        byteBuffer2.mark();
        try {
            try {
                if (this.role != Role.SERVER) {
                    if (this.role == Role.CLIENT) {
                        this.draft.setParseMode(this.role);
                        Handshakedata handshakedataTranslateHandshake = this.draft.translateHandshake(byteBuffer2);
                        if (!(handshakedataTranslateHandshake instanceof ServerHandshake)) {
                            this.log.trace("Closing due to protocol error: wrong http function");
                            flushAndClose(CloseFrame.PROTOCOL_ERROR, "wrong http function", false);
                            return false;
                        }
                        ServerHandshake serverHandshake = (ServerHandshake) handshakedataTranslateHandshake;
                        if (this.draft.acceptHandshakeAsClient(this.handshakerequest, serverHandshake) == HandshakeState.MATCHED) {
                            try {
                                this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, serverHandshake);
                                open(serverHandshake);
                                return true;
                            } catch (RuntimeException e) {
                                this.log.error("Closing since client was never connected", (Throwable) e);
                                this.wsl.onWebsocketError(this, e);
                                flushAndClose(-1, e.getMessage(), false);
                                return false;
                            } catch (InvalidDataException e2) {
                                this.log.trace("Closing due to invalid data exception. Possible handshake rejection", (Throwable) e2);
                                flushAndClose(e2.getCloseCode(), e2.getMessage(), false);
                                return false;
                            }
                        }
                        this.log.trace("Closing due to protocol error: draft {} refuses handshake", this.draft);
                        close(CloseFrame.PROTOCOL_ERROR, "draft " + this.draft + " refuses handshake");
                    }
                    return false;
                }
                if (this.draft != null) {
                    Handshakedata handshakedataTranslateHandshake2 = this.draft.translateHandshake(byteBuffer2);
                    if (!(handshakedataTranslateHandshake2 instanceof ClientHandshake)) {
                        this.log.trace("Closing due to protocol error: wrong http function");
                        flushAndClose(CloseFrame.PROTOCOL_ERROR, "wrong http function", false);
                        return false;
                    }
                    ClientHandshake clientHandshake = (ClientHandshake) handshakedataTranslateHandshake2;
                    if (this.draft.acceptHandshakeAsServer(clientHandshake) == HandshakeState.MATCHED) {
                        open(clientHandshake);
                        return true;
                    }
                    this.log.trace("Closing due to protocol error: the handshake did finally not match");
                    close(CloseFrame.PROTOCOL_ERROR, "the handshake did finally not match");
                    return false;
                }
                Iterator<Draft> it = this.knownDrafts.iterator();
                while (it.hasNext()) {
                    Draft draftCopyInstance = it.next().copyInstance();
                    try {
                        draftCopyInstance.setParseMode(this.role);
                        byteBuffer2.reset();
                        Handshakedata handshakedataTranslateHandshake3 = draftCopyInstance.translateHandshake(byteBuffer2);
                        if (!(handshakedataTranslateHandshake3 instanceof ClientHandshake)) {
                            this.log.trace("Closing due to wrong handshake");
                            closeConnectionDueToWrongHandshake(new InvalidDataException(CloseFrame.PROTOCOL_ERROR, "wrong http function"));
                            return false;
                        }
                        ClientHandshake clientHandshake2 = (ClientHandshake) handshakedataTranslateHandshake3;
                        if (draftCopyInstance.acceptHandshakeAsServer(clientHandshake2) == HandshakeState.MATCHED) {
                            this.resourceDescriptor = clientHandshake2.getResourceDescriptor();
                            try {
                                write(draftCopyInstance.createHandshake(draftCopyInstance.postProcessHandshakeResponseAsServer(clientHandshake2, this.wsl.onWebsocketHandshakeReceivedAsServer(this, draftCopyInstance, clientHandshake2))));
                                this.draft = draftCopyInstance;
                                open(clientHandshake2);
                                return true;
                            } catch (RuntimeException e3) {
                                this.log.error("Closing due to internal server error", (Throwable) e3);
                                this.wsl.onWebsocketError(this, e3);
                                closeConnectionDueToInternalServerError(e3);
                                return false;
                            } catch (InvalidDataException e4) {
                                this.log.trace("Closing due to wrong handshake. Possible handshake rejection", (Throwable) e4);
                                closeConnectionDueToWrongHandshake(e4);
                                return false;
                            }
                        }
                    } catch (InvalidHandshakeException e5) {
                    }
                }
                if (this.draft != null) {
                    return false;
                }
                this.log.trace("Closing due to protocol error: no draft matches");
                closeConnectionDueToWrongHandshake(new InvalidDataException(CloseFrame.PROTOCOL_ERROR, "no draft matches"));
                return false;
            } catch (InvalidHandshakeException e6) {
                this.log.trace("Closing due to invalid handshake", (Throwable) e6);
                close(e6);
            }
        } catch (IncompleteHandshakeException e7) {
            if (this.tmpHandshakeBytes.capacity() != 0) {
                this.tmpHandshakeBytes.position(this.tmpHandshakeBytes.limit());
                this.tmpHandshakeBytes.limit(this.tmpHandshakeBytes.capacity());
                return false;
            }
            byteBuffer2.reset();
            int preferredSize = e7.getPreferredSize();
            if (preferredSize == 0) {
                preferredSize = byteBuffer2.capacity() + 16;
            } else if (!$assertionsDisabled && e7.getPreferredSize() < byteBuffer2.remaining()) {
                throw new AssertionError();
            }
            this.tmpHandshakeBytes = ByteBuffer.allocate(preferredSize);
            this.tmpHandshakeBytes.put(byteBuffer);
            return false;
        }
    }

    private void decodeFrames(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.translateFrame(byteBuffer)) {
                this.log.trace("matched frame: {}", framedata);
                this.draft.processFrame(this, framedata);
            }
        } catch (LinkageError | ThreadDeath | VirtualMachineError e) {
            this.log.error("Got fatal error during frame processing");
            throw e;
        } catch (Error e2) {
            this.log.error("Closing web socket due to an error during frame processing");
            this.wsl.onWebsocketError(this, new Exception(e2));
            close(CloseFrame.UNEXPECTED_CONDITION, "Got error " + e2.getClass().getName());
        } catch (LimitExceededException e3) {
            if (e3.getLimit() == Integer.MAX_VALUE) {
                this.log.error("Closing due to invalid size of frame", (Throwable) e3);
                this.wsl.onWebsocketError(this, e3);
            }
            close(e3);
        } catch (InvalidDataException e4) {
            this.log.error("Closing due to invalid data in frame", (Throwable) e4);
            this.wsl.onWebsocketError(this, e4);
            close(e4);
        }
    }

    private void closeConnectionDueToWrongHandshake(InvalidDataException invalidDataException) {
        write(generateHttpResponseDueToError(404));
        flushAndClose(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void closeConnectionDueToInternalServerError(RuntimeException runtimeException) {
        write(generateHttpResponseDueToError(500));
        flushAndClose(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer generateHttpResponseDueToError(int i) {
        String str;
        switch (i) {
            case 404:
                str = "404 WebSocket Upgrade Failure";
                break;
            case 500:
            default:
                str = "500 Internal Server Error";
                break;
        }
        return ByteBuffer.wrap(Charsetfunctions.asciiBytes("HTTP/1.1 " + str + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (48 + str.length()) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public synchronized void close(int i, String str, boolean z) {
        if (this.readyState == ReadyState.CLOSING || this.readyState == ReadyState.CLOSED) {
            return;
        }
        if (this.readyState == ReadyState.OPEN) {
            if (i == 1006) {
                if (!$assertionsDisabled && z) {
                    throw new AssertionError();
                }
                this.readyState = ReadyState.CLOSING;
                flushAndClose(i, str, false);
                return;
            }
            if (this.draft.getCloseHandshakeType() != CloseHandshakeType.NONE) {
                if (!z) {
                    try {
                        try {
                            this.wsl.onWebsocketCloseInitiated(this, i, str);
                        } catch (RuntimeException e) {
                            this.wsl.onWebsocketError(this, e);
                        }
                    } catch (InvalidDataException e2) {
                        this.log.error("generated frame is invalid", (Throwable) e2);
                        this.wsl.onWebsocketError(this, e2);
                        flushAndClose(CloseFrame.ABNORMAL_CLOSE, "generated frame is invalid", false);
                    }
                }
                if (isOpen()) {
                    CloseFrame closeFrame = new CloseFrame();
                    closeFrame.setReason(str);
                    closeFrame.setCode(i);
                    closeFrame.isValid();
                    sendFrame(closeFrame);
                }
            }
            flushAndClose(i, str, z);
        } else if (i == -3) {
            if (!$assertionsDisabled && !z) {
                throw new AssertionError();
            }
            flushAndClose(-3, str, true);
        } else if (i == 1002) {
            flushAndClose(i, str, z);
        } else {
            flushAndClose(-1, str, false);
        }
        this.readyState = ReadyState.CLOSING;
        this.tmpHandshakeBytes = null;
    }

    @Override // org.java_websocket.WebSocket
    public void close(int i, String str) {
        close(i, str, false);
    }

    public synchronized void closeConnection(int i, String str, boolean z) {
        if (this.readyState == ReadyState.CLOSED) {
            return;
        }
        if (this.readyState == ReadyState.OPEN && i == 1006) {
            this.readyState = ReadyState.CLOSING;
        }
        if (this.key != null) {
            this.key.cancel();
        }
        if (this.channel != null) {
            try {
                this.channel.close();
            } catch (IOException e) {
                if (e.getMessage() == null || !e.getMessage().equals("Broken pipe")) {
                    this.log.error("Exception during channel.close()", (Throwable) e);
                    this.wsl.onWebsocketError(this, e);
                } else {
                    this.log.trace("Caught IOException: Broken pipe during closeConnection()", (Throwable) e);
                }
            }
        }
        try {
            this.wsl.onWebsocketClose(this, i, str, z);
        } catch (RuntimeException e2) {
            this.wsl.onWebsocketError(this, e2);
        }
        if (this.draft != null) {
            this.draft.reset();
        }
        this.handshakerequest = null;
        this.readyState = ReadyState.CLOSED;
    }

    protected void closeConnection(int i, boolean z) {
        closeConnection(i, "", z);
    }

    public void closeConnection() {
        if (this.closedremotely == null) {
            throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
        }
        closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
    }

    @Override // org.java_websocket.WebSocket
    public void closeConnection(int i, String str) {
        closeConnection(i, str, false);
    }

    public synchronized void flushAndClose(int i, String str, boolean z) {
        if (this.flushandclosestate) {
            return;
        }
        this.closecode = Integer.valueOf(i);
        this.closemessage = str;
        this.closedremotely = Boolean.valueOf(z);
        this.flushandclosestate = true;
        this.wsl.onWriteDemand(this);
        try {
            this.wsl.onWebsocketClosing(this, i, str, z);
        } catch (RuntimeException e) {
            this.log.error("Exception in onWebsocketClosing", (Throwable) e);
            this.wsl.onWebsocketError(this, e);
        }
        if (this.draft != null) {
            this.draft.reset();
        }
        this.handshakerequest = null;
    }

    public void eot() {
        if (this.readyState == ReadyState.NOT_YET_CONNECTED) {
            closeConnection(-1, true);
            return;
        }
        if (this.flushandclosestate) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
            return;
        }
        if (this.draft.getCloseHandshakeType() == CloseHandshakeType.NONE) {
            closeConnection(CloseFrame.NORMAL, true);
            return;
        }
        if (this.draft.getCloseHandshakeType() != CloseHandshakeType.ONEWAY) {
            closeConnection(CloseFrame.ABNORMAL_CLOSE, true);
        } else if (this.role == Role.SERVER) {
            closeConnection(CloseFrame.ABNORMAL_CLOSE, true);
        } else {
            closeConnection(CloseFrame.NORMAL, true);
        }
    }

    @Override // org.java_websocket.WebSocket
    public void close(int i) {
        close(i, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        close(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override // org.java_websocket.WebSocket
    public void send(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(str, this.role == Role.CLIENT));
    }

    @Override // org.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(byteBuffer, this.role == Role.CLIENT));
    }

    @Override // org.java_websocket.WebSocket
    public void send(byte[] bArr) {
        send(ByteBuffer.wrap(bArr));
    }

    private void send(Collection<Framedata> collection) {
        if (!isOpen()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (Framedata framedata : collection) {
            this.log.trace("send frame: {}", framedata);
            arrayList.add(this.draft.createBinaryFrame(framedata));
        }
        write(arrayList);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        send(this.draft.continuousFrame(opcode, byteBuffer, z));
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Collection<Framedata> collection) {
        send(collection);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        send(Collections.singletonList(framedata));
    }

    @Override // org.java_websocket.WebSocket
    public void sendPing() {
        PingFrame pingFrameOnPreparePing = this.wsl.onPreparePing(this);
        if (pingFrameOnPreparePing == null) {
            throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        }
        sendFrame(pingFrameOnPreparePing);
    }

    @Override // org.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return !this.outQueue.isEmpty();
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        this.resourceDescriptor = clientHandshakeBuilder.getResourceDescriptor();
        if (!$assertionsDisabled && this.resourceDescriptor == null) {
            throw new AssertionError();
        }
        try {
            this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
            write(this.draft.createHandshake(this.handshakerequest));
        } catch (RuntimeException e) {
            this.log.error("Exception in startHandshake", (Throwable) e);
            this.wsl.onWebsocketError(this, e);
            throw new InvalidHandshakeException("rejected because of " + e);
        } catch (InvalidDataException e2) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    private void write(ByteBuffer byteBuffer) {
        this.log.trace("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.outQueue.add(byteBuffer);
        this.wsl.onWriteDemand(this);
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.synchronizeWriteObject) {
            Iterator<ByteBuffer> it = list.iterator();
            while (it.hasNext()) {
                write(it.next());
            }
        }
    }

    private void open(Handshakedata handshakedata) {
        this.log.trace("open using draft: {}", this.draft);
        this.readyState = ReadyState.OPEN;
        updateLastPong();
        try {
            this.wsl.onWebsocketOpen(this, handshakedata);
        } catch (RuntimeException e) {
            this.wsl.onWebsocketError(this, e);
        }
    }

    @Override // org.java_websocket.WebSocket
    public boolean isOpen() {
        return this.readyState == ReadyState.OPEN;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isClosing() {
        return this.readyState == ReadyState.CLOSING;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.flushandclosestate;
    }

    @Override // org.java_websocket.WebSocket
    public boolean isClosed() {
        return this.readyState == ReadyState.CLOSED;
    }

    @Override // org.java_websocket.WebSocket
    public ReadyState getReadyState() {
        return this.readyState;
    }

    public void setSelectionKey(SelectionKey selectionKey) {
        this.key = selectionKey;
    }

    public SelectionKey getSelectionKey() {
        return this.key;
    }

    public String toString() {
        return super.toString();
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.wsl.getRemoteSocketAddress(this);
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.wsl.getLocalSocketAddress(this);
    }

    @Override // org.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // org.java_websocket.WebSocket
    public void close() {
        close(CloseFrame.NORMAL);
    }

    @Override // org.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    long getLastPong() {
        return this.lastPong;
    }

    public void updateLastPong() {
        this.lastPong = System.nanoTime();
    }

    public WebSocketListener getWebSocketListener() {
        return this.wsl;
    }

    @Override // org.java_websocket.WebSocket
    public <T> T getAttachment() {
        return (T) this.attachment;
    }

    @Override // org.java_websocket.WebSocket
    public boolean hasSSLSupport() {
        return this.channel instanceof ISSLChannel;
    }

    @Override // org.java_websocket.WebSocket
    public SSLSession getSSLSession() {
        if (hasSSLSupport()) {
            return ((ISSLChannel) this.channel).getSSLEngine().getSession();
        }
        throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
    }

    @Override // org.java_websocket.WebSocket
    public IProtocol getProtocol() {
        if (this.draft == null) {
            return null;
        }
        if (this.draft instanceof Draft_6455) {
            return ((Draft_6455) this.draft).getProtocol();
        }
        throw new IllegalArgumentException("This draft does not support Sec-WebSocket-Protocol");
    }

    @Override // org.java_websocket.WebSocket
    public <T> void setAttachment(T t) {
        this.attachment = t;
    }

    public ByteChannel getChannel() {
        return this.channel;
    }

    public void setChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    public WebSocketServer.WebSocketWorker getWorkerThread() {
        return this.workerThread;
    }

    public void setWorkerThread(WebSocketServer.WebSocketWorker webSocketWorker) {
        this.workerThread = webSocketWorker;
    }

    static {
        $assertionsDisabled = !WebSocketImpl.class.desiredAssertionStatus();
    }
}
