package org.java_websocket.exceptions;

import org.java_websocket.framing.CloseFrame;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/exceptions/InvalidHandshakeException.class */
public class InvalidHandshakeException extends InvalidDataException {
    private static final long serialVersionUID = -1426533877490484964L;

    public InvalidHandshakeException() {
        super(CloseFrame.PROTOCOL_ERROR);
    }

    public InvalidHandshakeException(String str, Throwable th) {
        super(CloseFrame.PROTOCOL_ERROR, str, th);
    }

    public InvalidHandshakeException(String str) {
        super(CloseFrame.PROTOCOL_ERROR, str);
    }

    public InvalidHandshakeException(Throwable th) {
        super(CloseFrame.PROTOCOL_ERROR, th);
    }
}
