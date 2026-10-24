package me.module.multiserver.library.redis.jedis;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.util.IOUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/DefaultJedisSocketFactory.class */
public class DefaultJedisSocketFactory implements JedisSocketFactory {
    protected static final HostAndPort DEFAULT_HOST_AND_PORT = new HostAndPort(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
    private volatile HostAndPort hostAndPort;
    private int connectionTimeout;
    private int socketTimeout;
    private boolean ssl;
    private SSLSocketFactory sslSocketFactory;
    private SSLParameters sslParameters;
    private HostnameVerifier hostnameVerifier;
    private HostAndPortMapper hostAndPortMapper;

    public DefaultJedisSocketFactory() {
        this.hostAndPort = DEFAULT_HOST_AND_PORT;
        this.connectionTimeout = 2000;
        this.socketTimeout = 2000;
        this.ssl = false;
        this.sslSocketFactory = null;
        this.sslParameters = null;
        this.hostnameVerifier = null;
        this.hostAndPortMapper = null;
    }

    public DefaultJedisSocketFactory(HostAndPort hostAndPort) {
        this(hostAndPort, null);
    }

    public DefaultJedisSocketFactory(JedisClientConfig jedisClientConfig) {
        this(null, jedisClientConfig);
    }

    public DefaultJedisSocketFactory(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this.hostAndPort = DEFAULT_HOST_AND_PORT;
        this.connectionTimeout = 2000;
        this.socketTimeout = 2000;
        this.ssl = false;
        this.sslSocketFactory = null;
        this.sslParameters = null;
        this.hostnameVerifier = null;
        this.hostAndPortMapper = null;
        if (hostAndPort != null) {
            this.hostAndPort = hostAndPort;
        }
        if (jedisClientConfig != null) {
            this.connectionTimeout = jedisClientConfig.getConnectionTimeoutMillis();
            this.socketTimeout = jedisClientConfig.getSocketTimeoutMillis();
            this.ssl = jedisClientConfig.isSsl();
            this.sslSocketFactory = jedisClientConfig.getSslSocketFactory();
            this.sslParameters = jedisClientConfig.getSslParameters();
            this.hostnameVerifier = jedisClientConfig.getHostnameVerifier();
            this.hostAndPortMapper = jedisClientConfig.getHostAndPortMapper();
        }
    }

    private Socket connectToFirstSuccessfulHost(HostAndPort hostAndPort) {
        List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName(hostAndPort.getHost()));
        if (listAsList.size() > 1) {
            Collections.shuffle(listAsList);
        }
        JedisConnectionException jedisConnectionException = new JedisConnectionException("Failed to connect to any host resolved for DNS name.");
        for (InetAddress inetAddress : listAsList) {
            try {
                Socket socket = new Socket();
                socket.setReuseAddress(true);
                socket.setKeepAlive(true);
                socket.setTcpNoDelay(true);
                socket.setSoLinger(true, 0);
                socket.connect(new InetSocketAddress(inetAddress.getHostAddress(), hostAndPort.getPort()), this.connectionTimeout);
                return socket;
            } catch (Exception e) {
                jedisConnectionException.addSuppressed(e);
            }
        }
        throw jedisConnectionException;
    }

    @Override // me.module.multiserver.library.redis.jedis.JedisSocketFactory
    public Socket createSocket() {
        Socket socketConnectToFirstSuccessfulHost = null;
        try {
            HostAndPort socketHostAndPort = getSocketHostAndPort();
            socketConnectToFirstSuccessfulHost = connectToFirstSuccessfulHost(socketHostAndPort);
            socketConnectToFirstSuccessfulHost.setSoTimeout(this.socketTimeout);
            if (this.ssl) {
                SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
                if (null == sSLSocketFactory) {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                socketConnectToFirstSuccessfulHost = sSLSocketFactory.createSocket(socketConnectToFirstSuccessfulHost, socketHostAndPort.getHost(), socketHostAndPort.getPort(), true);
                if (null != this.sslParameters) {
                    ((SSLSocket) socketConnectToFirstSuccessfulHost).setSSLParameters(this.sslParameters);
                }
                if (null != this.hostnameVerifier && !this.hostnameVerifier.verify(socketHostAndPort.getHost(), ((SSLSocket) socketConnectToFirstSuccessfulHost).getSession())) {
                    throw new JedisConnectionException(String.format("The connection to '%s' failed ssl/tls hostname verification.", socketHostAndPort.getHost()));
                }
            }
            return socketConnectToFirstSuccessfulHost;
        } catch (Exception e) {
            IOUtils.closeQuietly(socketConnectToFirstSuccessfulHost);
            if (e instanceof JedisConnectionException) {
                throw ((JedisConnectionException) e);
            }
            throw new JedisConnectionException("Failed to create socket.", e);
        }
    }

    public void updateHostAndPort(HostAndPort hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

    public HostAndPort getHostAndPort() {
        return this.hostAndPort;
    }

    protected HostAndPort getSocketHostAndPort() {
        HostAndPort hostAndPort;
        HostAndPortMapper hostAndPortMapper = this.hostAndPortMapper;
        HostAndPort hostAndPort2 = this.hostAndPort;
        return (hostAndPortMapper == null || (hostAndPort = hostAndPortMapper.getHostAndPort(hostAndPort2)) == null) ? hostAndPort2 : hostAndPort;
    }

    public String toString() {
        return "DefaultJedisSocketFactory{" + this.hostAndPort.toString() + "}";
    }
}
