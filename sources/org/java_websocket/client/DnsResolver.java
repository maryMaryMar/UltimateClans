package org.java_websocket.client;

import java.net.InetAddress;
import java.net.URI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/client/DnsResolver.class */
public interface DnsResolver {
    InetAddress resolve(URI uri);
}
