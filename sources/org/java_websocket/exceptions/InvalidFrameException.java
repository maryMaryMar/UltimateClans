package org.java_websocket.exceptions;

import org.java_websocket.framing.CloseFrame;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/exceptions/InvalidFrameException.class */
public class InvalidFrameException extends InvalidDataException {
    private static final long serialVersionUID = -9016496369828887591L;

    public InvalidFrameException() {
        super(CloseFrame.PROTOCOL_ERROR);
    }

    public InvalidFrameException(String str) {
        super(CloseFrame.PROTOCOL_ERROR, str);
    }

    public InvalidFrameException(Throwable th) {
        super(CloseFrame.PROTOCOL_ERROR, th);
    }

    public InvalidFrameException(String str, Throwable th) {
        super(CloseFrame.PROTOCOL_ERROR, str, th);
    }
}
