package org.java_websocket.extensions;

import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/extensions/DefaultExtension.class */
public class DefaultExtension implements IExtension {
    @Override // org.java_websocket.extensions.IExtension
    public void decodeFrame(Framedata framedata) {
    }

    @Override // org.java_websocket.extensions.IExtension
    public void encodeFrame(Framedata framedata) {
    }

    @Override // org.java_websocket.extensions.IExtension
    public boolean acceptProvidedExtensionAsServer(String str) {
        return true;
    }

    @Override // org.java_websocket.extensions.IExtension
    public boolean acceptProvidedExtensionAsClient(String str) {
        return true;
    }

    @Override // org.java_websocket.extensions.IExtension
    public void isFrameValid(Framedata framedata) throws InvalidFrameException {
        if (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        }
    }

    @Override // org.java_websocket.extensions.IExtension
    public String getProvidedExtensionAsClient() {
        return "";
    }

    @Override // org.java_websocket.extensions.IExtension
    public String getProvidedExtensionAsServer() {
        return "";
    }

    @Override // org.java_websocket.extensions.IExtension
    public IExtension copyInstance() {
        return new DefaultExtension();
    }

    @Override // org.java_websocket.extensions.IExtension
    public void reset() {
    }

    @Override // org.java_websocket.extensions.IExtension
    public String toString() {
        return getClass().getSimpleName();
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass());
    }
}
