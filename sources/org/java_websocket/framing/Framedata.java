package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/java_websocket/framing/Framedata.class */
public interface Framedata {
    boolean isFin();

    boolean isRSV1();

    boolean isRSV2();

    boolean isRSV3();

    boolean getTransfereMasked();

    Opcode getOpcode();

    ByteBuffer getPayloadData();

    void append(Framedata framedata);
}
