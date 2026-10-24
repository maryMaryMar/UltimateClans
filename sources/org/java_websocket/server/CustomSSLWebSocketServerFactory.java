package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/server/CustomSSLWebSocketServerFactory.class */
public class CustomSSLWebSocketServerFactory extends DefaultSSLWebSocketServerFactory {
    private final String[] enabledProtocols;
    private final String[] enabledCiphersuites;

    public CustomSSLWebSocketServerFactory(SSLContext sSLContext, String[] strArr, String[] strArr2) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor(), strArr, strArr2);
    }

    public CustomSSLWebSocketServerFactory(SSLContext sSLContext, ExecutorService executorService, String[] strArr, String[] strArr2) {
        super(sSLContext, executorService);
        this.enabledProtocols = strArr;
        this.enabledCiphersuites = strArr2;
    }

    @Override // org.java_websocket.server.DefaultSSLWebSocketServerFactory, org.java_websocket.WebSocketServerFactory
    public ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngineCreateSSLEngine = this.sslcontext.createSSLEngine();
        if (this.enabledProtocols != null) {
            sSLEngineCreateSSLEngine.setEnabledProtocols(this.enabledProtocols);
        }
        if (this.enabledCiphersuites != null) {
            sSLEngineCreateSSLEngine.setEnabledCipherSuites(this.enabledCiphersuites);
        }
        sSLEngineCreateSSLEngine.setUseClientMode(false);
        return new SSLSocketChannel2(socketChannel, sSLEngineCreateSSLEngine, this.exec, selectionKey);
    }
}
