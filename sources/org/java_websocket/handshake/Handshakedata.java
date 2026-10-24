package org.java_websocket.handshake;

import java.util.Iterator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/handshake/Handshakedata.class */
public interface Handshakedata {
    Iterator<String> iterateHttpFields();

    String getFieldValue(String str);

    boolean hasFieldValue(String str);

    byte[] getContent();
}
