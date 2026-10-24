package org.java_websocket.extensions;

import org.java_websocket.framing.Framedata;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/extensions/IExtension.class */
public interface IExtension {
    void decodeFrame(Framedata framedata);

    void encodeFrame(Framedata framedata);

    boolean acceptProvidedExtensionAsServer(String str);

    boolean acceptProvidedExtensionAsClient(String str);

    void isFrameValid(Framedata framedata);

    String getProvidedExtensionAsClient();

    String getProvidedExtensionAsServer();

    IExtension copyInstance();

    void reset();

    String toString();
}
