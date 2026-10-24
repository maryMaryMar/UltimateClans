package me.ulrich.clans.licensing;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HexFormat;

/**
 * Utilidades Ed25519: firma, verificación y huella de la clave pública.
 *
 * <p>Se usa Ed25519 (JDK 15+) en lugar de RSA/HMAC porque las claves son cortas, la firma es
 * determinista y el servidor de licencias nunca necesita compartir un secreto con el plugin.</p>
 */
public final class LicenseSignature {

    private static final String ALGORITHM = "Ed25519";

    private LicenseSignature() {
    }

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
            return generator.generateKeyPair();
        } catch (GeneralSecurityException error) {
            throw new IllegalStateException("Ed25519 no está disponible en esta JVM", error);
        }
    }

    public static String encodePublicKey(PublicKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static String encodePrivateKey(PrivateKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static PublicKey decodePublicKey(String base64) {
        try {
            byte[] decoded = Base64.getDecoder().decode(base64.trim());
            return KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
        } catch (GeneralSecurityException | IllegalArgumentException error) {
            throw new LicenseException(LicenseStatus.CONFIGURATION_ERROR, "Clave pública de licencias inválida", error);
        }
    }

    public static PrivateKey decodePrivateKey(String base64) {
        try {
            byte[] decoded = Base64.getDecoder().decode(base64.trim());
            return KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        } catch (GeneralSecurityException | IllegalArgumentException error) {
            throw new IllegalStateException("Clave privada de licencias inválida", error);
        }
    }

    public static byte[] sign(PrivateKey key, byte[] payload) {
        try {
            Signature signature = Signature.getInstance(ALGORITHM);
            signature.initSign(key);
            signature.update(payload);
            return signature.sign();
        } catch (GeneralSecurityException error) {
            throw new IllegalStateException("No se pudo firmar el token", error);
        }
    }

    public static boolean verify(PublicKey key, byte[] payload, byte[] signatureBytes) {
        try {
            Signature signature = Signature.getInstance(ALGORITHM);
            signature.initVerify(key);
            signature.update(payload);
            return signature.verify(signatureBytes);
        } catch (GeneralSecurityException error) {
            return false;
        }
    }

    /**
     * SHA-256 de la clave pública codificada, en hexadecimal. Sirve para fijar ("pin") la clave
     * esperada y detectar que alguien sustituyó el archivo de configuración.
     */
    public static String fingerprint(PublicKey key) {
        return fingerprint(key.getEncoded());
    }

    public static String fingerprint(byte[] encodedKey) {
        try {
            return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(encodedKey));
        } catch (GeneralSecurityException error) {
            throw new IllegalStateException("SHA-256 no disponible", error);
        }
    }

    /**
     * Comparación en tiempo constante para huellas y nonces.
     */
    public static boolean constantTimeEquals(String left, String right) {
        return MessageDigest.isEqual(
                left.getBytes(StandardCharsets.US_ASCII),
                right.getBytes(StandardCharsets.US_ASCII));
    }
}
