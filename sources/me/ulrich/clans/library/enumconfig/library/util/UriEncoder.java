package me.ulrich.clans.library.enumconfig.library.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.Escaper;
import me.ulrich.clans.library.enumconfig.library.external.com.google.gdata.util.common.base.PercentEscaper;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/UriEncoder.class */
public abstract class UriEncoder {
    private static final CharsetDecoder UTF8Decoder = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
    private static final String SAFE_CHARS = "-_.!~*'()@:$&,;=[]/";
    private static final Escaper escaper = new PercentEscaper(SAFE_CHARS, false);

    public static String encode(String str) {
        return escaper.escape(str);
    }

    public static String decode(ByteBuffer byteBuffer) {
        return UTF8Decoder.decode(byteBuffer).toString();
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new YAMLException(e);
        }
    }
}
