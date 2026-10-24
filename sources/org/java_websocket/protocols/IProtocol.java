package org.java_websocket.protocols;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/protocols/IProtocol.class */
public interface IProtocol {
    boolean acceptProvidedProtocol(String str);

    String getProvidedProtocol();

    IProtocol copyInstance();

    String toString();
}
