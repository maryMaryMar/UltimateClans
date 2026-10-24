package me.module.multiserver.library.redis.jedis;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.IOUtils;
import me.module.multiserver.library.redis.jedis.util.RedisInputStream;
import me.module.multiserver.library.redis.jedis.util.RedisOutputStream;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Connection.class */
public class Connection implements Closeable {
    private ConnectionPool memberOf;
    private final JedisSocketFactory socketFactory;
    private Socket socket;
    private RedisOutputStream outputStream;
    private RedisInputStream inputStream;
    private int soTimeout;
    private int infiniteSoTimeout;
    private boolean broken;

    public Connection() {
        this(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
    }

    public Connection(String str, int i) {
        this(new HostAndPort(str, i));
    }

    public Connection(HostAndPort hostAndPort) {
        this(new DefaultJedisSocketFactory(hostAndPort));
    }

    public Connection(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(new DefaultJedisSocketFactory(hostAndPort, jedisClientConfig));
        this.infiniteSoTimeout = jedisClientConfig.getBlockingSocketTimeoutMillis();
        initializeFromClientConfig(jedisClientConfig);
    }

    public Connection(JedisSocketFactory jedisSocketFactory, JedisClientConfig jedisClientConfig) {
        this.soTimeout = 0;
        this.infiniteSoTimeout = 0;
        this.broken = false;
        this.socketFactory = jedisSocketFactory;
        this.soTimeout = jedisClientConfig.getSocketTimeoutMillis();
        this.infiniteSoTimeout = jedisClientConfig.getBlockingSocketTimeoutMillis();
        initializeFromClientConfig(jedisClientConfig);
    }

    public Connection(JedisSocketFactory jedisSocketFactory) {
        this.soTimeout = 0;
        this.infiniteSoTimeout = 0;
        this.broken = false;
        this.socketFactory = jedisSocketFactory;
    }

    public String toString() {
        return "Connection{" + this.socketFactory + "}";
    }

    public final void setHandlingPool(ConnectionPool connectionPool) {
        this.memberOf = connectionPool;
    }

    final HostAndPort getHostAndPort() {
        return ((DefaultJedisSocketFactory) this.socketFactory).getHostAndPort();
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public void setSoTimeout(int i) {
        this.soTimeout = i;
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(i);
            } catch (SocketException e) {
                this.broken = true;
                throw new JedisConnectionException(e);
            }
        }
    }

    public void setTimeoutInfinite() {
        try {
            if (!isConnected()) {
                connect();
            }
            this.socket.setSoTimeout(this.infiniteSoTimeout);
        } catch (SocketException e) {
            this.broken = true;
            throw new JedisConnectionException(e);
        }
    }

    public void rollbackTimeout() {
        try {
            this.socket.setSoTimeout(this.soTimeout);
        } catch (SocketException e) {
            this.broken = true;
            throw new JedisConnectionException(e);
        }
    }

    public Object executeCommand(ProtocolCommand protocolCommand) {
        return executeCommand(new CommandArguments(protocolCommand));
    }

    public Object executeCommand(CommandArguments commandArguments) {
        sendCommand(commandArguments);
        return getOne();
    }

    public <T> T executeCommand(CommandObject<T> commandObject) {
        CommandArguments arguments = commandObject.getArguments();
        sendCommand(arguments);
        if (!arguments.isBlocking()) {
            return commandObject.getBuilder().build(getOne());
        }
        try {
            setTimeoutInfinite();
            return commandObject.getBuilder().build(getOne());
        } finally {
            rollbackTimeout();
        }
    }

    public void sendCommand(ProtocolCommand protocolCommand) {
        sendCommand(new CommandArguments(protocolCommand));
    }

    public void sendCommand(ProtocolCommand protocolCommand, Rawable rawable) {
        sendCommand(new CommandArguments(protocolCommand).add(rawable));
    }

    public void sendCommand(ProtocolCommand protocolCommand, String... strArr) {
        sendCommand(new CommandArguments(protocolCommand).addObjects(strArr));
    }

    public void sendCommand(ProtocolCommand protocolCommand, byte[]... bArr) {
        sendCommand(new CommandArguments(protocolCommand).addObjects(bArr));
    }

    public void sendCommand(CommandArguments commandArguments) {
        try {
            connect();
            Protocol.sendCommand(this.outputStream, commandArguments);
        } catch (JedisConnectionException e) {
            e = e;
            try {
                String errorLineIfPossible = Protocol.readErrorLineIfPossible(this.inputStream);
                if (errorLineIfPossible != null && errorLineIfPossible.length() > 0) {
                    e = new JedisConnectionException(errorLineIfPossible, e.getCause());
                }
            } catch (Exception e2) {
            }
            this.broken = true;
            throw e;
        }
    }

    public void connect() {
        try {
            if (isConnected()) {
                return;
            }
            try {
                try {
                    this.socket = this.socketFactory.createSocket();
                    this.soTimeout = this.socket.getSoTimeout();
                    this.outputStream = new RedisOutputStream(this.socket.getOutputStream());
                    this.inputStream = new RedisInputStream(this.socket.getInputStream());
                    if (this.broken) {
                        IOUtils.closeQuietly(this.socket);
                    }
                } catch (JedisConnectionException e) {
                    this.broken = true;
                    throw e;
                }
            } catch (IOException e2) {
                this.broken = true;
                throw new JedisConnectionException("Failed to create input/output stream", e2);
            }
        } catch (Throwable th) {
            if (this.broken) {
                IOUtils.closeQuietly(this.socket);
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.memberOf == null) {
            disconnect();
            return;
        }
        ConnectionPool connectionPool = this.memberOf;
        this.memberOf = null;
        if (isBroken()) {
            connectionPool.returnBrokenResource(this);
        } else {
            connectionPool.returnResource(this);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void disconnect() {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L38
            r0 = r4
            me.module.multiserver.library.redis.jedis.util.RedisOutputStream r0 = r0.outputStream     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L2e
            r0.flush()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L2e
            r0 = r4
            java.net.Socket r0 = r0.socket     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L2e
            r0.close()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L2e
            r0 = r4
            java.net.Socket r0 = r0.socket
            me.module.multiserver.library.redis.jedis.util.IOUtils.closeQuietly(r0)
            goto L38
        L1f:
            r5 = move-exception
            r0 = r4
            r1 = 1
            r0.broken = r1     // Catch: java.lang.Throwable -> L2e
            me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException r0 = new me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException     // Catch: java.lang.Throwable -> L2e
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e
            throw r0     // Catch: java.lang.Throwable -> L2e
        L2e:
            r6 = move-exception
            r0 = r4
            java.net.Socket r0 = r0.socket
            me.module.multiserver.library.redis.jedis.util.IOUtils.closeQuietly(r0)
            r0 = r6
            throw r0
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.module.multiserver.library.redis.jedis.Connection.disconnect():void");
    }

    public boolean isConnected() {
        return (this.socket == null || !this.socket.isBound() || this.socket.isClosed() || !this.socket.isConnected() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) ? false : true;
    }

    public boolean isBroken() {
        return this.broken;
    }

    public void setBroken() {
        this.broken = true;
    }

    public String getStatusCodeReply() {
        flush();
        byte[] bArr = (byte[]) readProtocolWithCheckingBroken();
        if (null == bArr) {
            return null;
        }
        return SafeEncoder.encode(bArr);
    }

    public String getBulkReply() {
        byte[] binaryBulkReply = getBinaryBulkReply();
        if (null != binaryBulkReply) {
            return SafeEncoder.encode(binaryBulkReply);
        }
        return null;
    }

    public byte[] getBinaryBulkReply() {
        flush();
        return (byte[]) readProtocolWithCheckingBroken();
    }

    public Long getIntegerReply() {
        flush();
        return (Long) readProtocolWithCheckingBroken();
    }

    public List<String> getMultiBulkReply() {
        return BuilderFactory.STRING_LIST.build(getBinaryMultiBulkReply());
    }

    public List<byte[]> getBinaryMultiBulkReply() {
        flush();
        return (List) readProtocolWithCheckingBroken();
    }

    public List<Object> getUnflushedObjectMultiBulkReply() {
        return (List) readProtocolWithCheckingBroken();
    }

    public List<Object> getObjectMultiBulkReply() {
        flush();
        return getUnflushedObjectMultiBulkReply();
    }

    public List<Long> getIntegerMultiBulkReply() {
        flush();
        return (List) readProtocolWithCheckingBroken();
    }

    public Object getOne() {
        flush();
        return readProtocolWithCheckingBroken();
    }

    protected void flush() {
        try {
            this.outputStream.flush();
        } catch (IOException e) {
            this.broken = true;
            throw new JedisConnectionException(e);
        }
    }

    protected Object readProtocolWithCheckingBroken() {
        if (this.broken) {
            throw new JedisConnectionException("Attempting to read from a broken connection");
        }
        try {
            return Protocol.read(this.inputStream);
        } catch (JedisConnectionException e) {
            this.broken = true;
            throw e;
        }
    }

    public List<Object> getMany(int i) {
        flush();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            try {
                arrayList.add(readProtocolWithCheckingBroken());
            } catch (JedisDataException e) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    private void initializeFromClientConfig(JedisClientConfig jedisClientConfig) {
        try {
            connect();
            String password = jedisClientConfig.getPassword();
            if (password != null) {
                String user = jedisClientConfig.getUser();
                if (user != null) {
                    auth(user, password);
                } else {
                    auth(password);
                }
            }
            int database = jedisClientConfig.getDatabase();
            if (database > 0) {
                select(database);
            }
            String clientName = jedisClientConfig.getClientName();
            if (clientName != null) {
                clientSetname(clientName);
            }
        } catch (JedisException e) {
            try {
                if (isConnected()) {
                    quit();
                }
                disconnect();
            } catch (Exception e2) {
            }
            throw e;
        }
    }

    private String auth(String str) {
        sendCommand(Protocol.Command.AUTH, str);
        return getStatusCodeReply();
    }

    private String auth(String str, String str2) {
        sendCommand(Protocol.Command.AUTH, str, str2);
        return getStatusCodeReply();
    }

    public String select(int i) {
        sendCommand(Protocol.Command.SELECT, Protocol.toByteArray(i));
        return getStatusCodeReply();
    }

    private String clientSetname(String str) {
        sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.SETNAME.name(), str);
        return getStatusCodeReply();
    }

    public String quit() {
        sendCommand(Protocol.Command.QUIT);
        String statusCodeReply = getStatusCodeReply();
        disconnect();
        setBroken();
        return statusCodeReply;
    }

    public boolean ping() {
        sendCommand(Protocol.Command.PING);
        String statusCodeReply = getStatusCodeReply();
        if ("PONG".equals(statusCodeReply)) {
            return true;
        }
        throw new JedisException(statusCodeReply);
    }
}
