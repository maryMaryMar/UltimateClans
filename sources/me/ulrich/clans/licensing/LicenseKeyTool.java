package me.ulrich.clans.licensing;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.UUID;

/**
 * Herramienta de línea de comandos para el <b>servidor de licencias</b> (no se distribuye con el
 * plugin). Permite generar el par de claves y firmar tokens.
 *
 * <pre>
 * java -cp UltimateClans.jar me.ulrich.clans.licensing.LicenseKeyTool keygen
 * java -cp UltimateClans.jar me.ulrich.clans.licensing.LicenseKeyTool sign \
 *      --private=&lt;base64&gt; --product=ultimateclans --key=UC-XXXX --days=30 --subject=MiServidor
 * </pre>
 */
public final class LicenseKeyTool {

    private LicenseKeyTool() {
    }

    public static void main(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("Uso: keygen | sign --private=<b64> --product=<id> --key=<clave> [--days=30] [--subject=Nombre] [--nonce=<uuid>]");
            return;
        }
        switch (arguments[0].toLowerCase()) {
            case "keygen" -> keygen();
            case "sign" -> sign(arguments);
            default -> System.out.println("Comando desconocido: " + arguments[0]);
        }
    }

    private static void keygen() {
        KeyPair pair = LicenseSignature.generateKeyPair();
        String publicKey = LicenseSignature.encodePublicKey(pair.getPublic());
        String privateKey = LicenseSignature.encodePrivateKey(pair.getPrivate());
        System.out.println("public-key:      " + publicKey);
        System.out.println("key-fingerprint: " + LicenseSignature.fingerprint(pair.getPublic()));
        System.out.println("private-key:     " + privateKey);
        System.out.println();
        System.out.println("Guarda private-key SOLO en el servidor de licencias.");
    }

    private static void sign(String[] arguments) {
        String privateKeyBase64 = value(arguments, "--private=");
        String product = value(arguments, "--product=");
        String licenseKey = value(arguments, "--key=");
        String subject = valueOr(arguments, "--subject=", "");
        String nonce = valueOr(arguments, "--nonce=", UUID.randomUUID().toString());
        long days = Long.parseLong(valueOr(arguments, "--days=", "30"));

        if (privateKeyBase64 == null || product == null || licenseKey == null) {
            System.out.println("Faltan --private, --product o --key");
            return;
        }

        PrivateKey privateKey = LicenseSignature.decodePrivateKey(privateKeyBase64);
        Instant now = Instant.now();
        String payload = "{\"product\":\"" + jsonEscape(product)
                + "\",\"key\":\"" + jsonEscape(licenseKey)
                + "\",\"subject\":\"" + jsonEscape(subject)
                + "\",\"iat\":" + now.getEpochSecond()
                + ",\"exp\":" + now.plus(days, ChronoUnit.DAYS).getEpochSecond()
                + ",\"nonce\":\"" + jsonEscape(nonce) + "\"}";

        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
        byte[] signature = LicenseSignature.sign(privateKey, payloadBytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        System.out.println(encoder.encodeToString(payloadBytes) + "." + encoder.encodeToString(signature));
    }

    private static String jsonEscape(String value) {
        StringBuilder escaped = new StringBuilder(value.length() + 8);
        for (int index = 0; index < value.length(); index++) {
            char character = value.charAt(index);
            switch (character) {
                case '"' -> escaped.append("\\\"");
                case '\\' -> escaped.append("\\\\");
                case '\n' -> escaped.append("\\n");
                case '\r' -> escaped.append("\\r");
                case '\t' -> escaped.append("\\t");
                default -> {
                    if (character < 0x20) {
                        escaped.append(String.format("\\u%04x", (int) character));
                    } else {
                        escaped.append(character);
                    }
                }
            }
        }
        return escaped.toString();
    }

    private static String value(String[] arguments, String prefix) {
        return valueOr(arguments, prefix, null);
    }

    private static String valueOr(String[] arguments, String prefix, String fallback) {
        for (String argument : arguments) {
            if (argument.startsWith(prefix)) {
                return argument.substring(prefix.length());
            }
        }
        return fallback;
    }
}
