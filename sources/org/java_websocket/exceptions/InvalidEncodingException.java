package org.java_websocket.exceptions;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/exceptions/InvalidEncodingException.class */
public class InvalidEncodingException extends RuntimeException {
    private final UnsupportedEncodingException encodingException;

    public InvalidEncodingException(UnsupportedEncodingException unsupportedEncodingException) {
        if (unsupportedEncodingException == null) {
            throw new IllegalArgumentException();
        }
        this.encodingException = unsupportedEncodingException;
    }

    public UnsupportedEncodingException getEncodingException() {
        return this.encodingException;
    }
}
