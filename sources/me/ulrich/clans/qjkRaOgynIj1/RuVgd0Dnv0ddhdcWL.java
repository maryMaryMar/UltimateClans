package me.ulrich.clans.qjkRaOgynIj1;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    private Optional<JSONObject> v8qP8fE86HMhvNuYPFjqY = Optional.empty();
    private static volatile String fhZ2imObTmSQRAHdj0Cd;
    private static String Fs4G3hXoTSv6RBpGuYzNm;
    private static String GNpjSX46Wv9MZnB5Lb1Zxd;
    private static volatile String DqRxiLRgWTc5iIYFUsh;
    private static volatile String wYCjOql93G1M55ZcVL8;
    private static String VCwIaONg6yJIH4O;
    private static String GGQtpDc64NIRiR;
    private static String TiQ6EcZy3Ud8hCy82WJ;
    private static final byte[] RrNuvDgDftZDpWU = {(byte) 65, (byte) 185, (byte) 124, (byte) 21, (byte) 36, (byte) 164, (byte) 140, (byte) 211, (byte) 226, (byte) 58, (byte) 123, (byte) 146, (byte) 52, (byte) 126, (byte) 165, (byte) 139, (byte) 49, (byte) 228, (byte) 44, (byte) 107, (byte) 35, (byte) 68, (byte) 49, (byte) 51, (byte) 95, (byte) 65, (byte) 143, (byte) 37, (byte) 105, (byte) 18, (byte) 152, (byte) 11, (byte) 163, (byte) 195, (byte) 173, (byte) 126, (byte) 222, (byte) 198, (byte) 160, (byte) 54, (byte) 134, (byte) 168, (byte) 215, (byte) 108, (byte) 105, (byte) 48, (byte) 216, (byte) 91, (byte) 4, (byte) 91, (byte) 148, (byte) 204, (byte) 161, (byte) 242, (byte) 233, (byte) 106, (byte) 146, (byte) 253, (byte) 107, (byte) 214, (byte) 225, (byte) 239, (byte) 187, (byte) 90, (byte) 108, (byte) 137, (byte) 218, (byte) 107, (byte) 172, (byte) 179, (byte) 5, (byte) 174, (byte) 82, (byte) 116, (byte) 190, (byte) 136, (byte) 222, (byte) 196, (byte) 245, (byte) 36, (byte) 206, (byte) 53, (byte) 193, (byte) 152, (byte) 217, (byte) 109, (byte) 166, (byte) 31, (byte) 80, (byte) 9, (byte) 123, (byte) 235, (byte) 63, (byte) 225, (byte) 90, (byte) 20};
    private static final byte[] MSuYRGjXUT5ogkZk4J = {(byte) 3, (byte) 216, (byte) 142, (byte) 57, (byte) 236, (byte) 97, (byte) 59, (byte) 55, (byte) 118, (byte) 58, (byte) 43, (byte) 134, (byte) 139, (byte) 116, (byte) 176, (byte) 108, (byte) 199, (byte) 41, (byte) 130, (byte) 140, (byte) 125, (byte) 79, (byte) 78, (byte) 215, (byte) 149, (byte) 211, (byte) 15, (byte) 232, (byte) 84, (byte) 11, (byte) 68, (byte) 165};
    private static final byte[] iLHhnZfA7SNDZyEdja = {(byte) 65, (byte) 185, (byte) 124, (byte) 21, (byte) 36, (byte) 164, (byte) 140, (byte) 211, (byte) 226, (byte) 58, (byte) 123, (byte) 146, (byte) 52, (byte) 126, (byte) 165, (byte) 139, (byte) 49, (byte) 228, (byte) 44, (byte) 107, (byte) 35, (byte) 68, (byte) 49, (byte) 51, (byte) 95, (byte) 65, (byte) 143, (byte) 37, (byte) 105, (byte) 18, (byte) 152, (byte) 11, (byte) 163, (byte) 195, (byte) 173, (byte) 126, (byte) 222, (byte) 198, (byte) 160, (byte) 54, (byte) 134, (byte) 168, (byte) 215, (byte) 108, (byte) 105, (byte) 48, (byte) 216, (byte) 91, (byte) 4, (byte) 91, (byte) 148, (byte) 204, (byte) 161, (byte) 242, (byte) 233, (byte) 106, (byte) 146, (byte) 253, (byte) 107, (byte) 214, (byte) 225, (byte) 239, (byte) 187, (byte) 90, (byte) 108, (byte) 137, (byte) 218, (byte) 107, (byte) 172, (byte) 179, (byte) 5, (byte) 174, (byte) 82, (byte) 116, (byte) 190, (byte) 136, (byte) 222, (byte) 196, (byte) 245, (byte) 36, (byte) 206, (byte) 53, (byte) 193, (byte) 152, (byte) 217, (byte) 109, (byte) 166, (byte) 31, (byte) 80, (byte) 9, (byte) 123, (byte) 235, (byte) 63, (byte) 225, (byte) 90, (byte) 20};
    private static final byte[] rxoa9fi1mARupMK2RdEj = {(byte) 3, (byte) 216, (byte) 142, (byte) 57, (byte) 236, (byte) 97, (byte) 59, (byte) 55, (byte) 118, (byte) 58, (byte) 43, (byte) 134, (byte) 139, (byte) 116, (byte) 176, (byte) 108, (byte) 199, (byte) 41, (byte) 130, (byte) 140, (byte) 125, (byte) 79, (byte) 78, (byte) 215, (byte) 149, (byte) 211, (byte) 15, (byte) 232, (byte) 84, (byte) 11, (byte) 68, (byte) 165};
    private static final byte[] ngOaaIlWJrhzkCUdQW5 = {(byte) 231, (byte) 202, (byte) 144, (byte) 162, (byte) 157, (byte) 112, (byte) 251, (byte) 111, (byte) 204, (byte) 68, (byte) 124, (byte) 177, (byte) 193, (byte) 176, (byte) 107, (byte) 2, (byte) 149, (byte) 121, (byte) 207, (byte) 172, (byte) 195, (byte) 37, (byte) 196, (byte) 205, (byte) 92, (byte) 130, (byte) 240, (byte) 140, (byte) 124, (byte) 133, (byte) 228, (byte) 211};
    private static final byte[] bMJqrWrEp4uz5miU5N1M = {(byte) 116, (byte) 97, (byte) 6, (byte) 2, (byte) 245, (byte) 122, (byte) 199, (byte) 0, (byte) 121, (byte) 238, (byte) 12, (byte) 126, (byte) 236, (byte) 150, (byte) 8, (byte) 142};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/RuVgd0Dnv0ddhdcWL$Ijap9SQKkijXSxP5.class */
    public static class Ijap9SQKkijXSxP5 {
        private Optional<JSONObject> v8qP8fE86HMhvNuYPFjqY = Optional.empty();
        private Optional<JSONArray> jBUuLP0sWwaPyPOmogdX7l = Optional.empty();
        private Optional<String> ZwrsrwOCXRUscW6Q = Optional.empty();
        private static String D3zvCslNScUKnFlGQ;
        private static volatile String DICdRD7RjvNLN4pCNDl26g;
        private static volatile String jxMCmwoGvHa5VMUSpHct9;
        private static String xHfhxnLU477Be9S7MKl2DC;
        private static volatile String muZktSF9LyGbGa6hmZe;
        private static volatile String zRnlGgapTcbrW2U39P9d;
        private static String BKSbMvZUeWeuXYLTZZ;
        private static volatile String Gmof8f9X0XDuMdPgDo;
        private static volatile String xwFjHSCMseIVoQinuLUl;
        private static volatile String IEDQNe4fTu3WLwgt3OQVB;
        private static String gboDDsvUDCGWLNeOH;
        private static String Yvgd02XfmtoU4CVN5m1;
        private static volatile String KdEuNv7cHi1rwlc5ox;
        private static volatile String HdKSk9ymS8LLz9Z8;
        private static volatile String HXnl6eVVMRUAklOASUfSS;
        private static String JeVRv8ASfynt0WW;
        private static volatile String TIrnsKfBIWIdy2z1VLMw;
        private static volatile String phVVzo7dmfR5wnZr8TCcQt;
        private static String gDGlkjtkeLab7tjM;
        private static final byte[] L1oQqRdwB7jIUhWw = {(byte) 164, (byte) 153, (byte) 64, (byte) 224, (byte) 168, (byte) 177, (byte) 115, (byte) 168, (byte) 129, (byte) 203, (byte) 114, (byte) 129, (byte) 86, (byte) 223, (byte) 218, (byte) 68, (byte) 56, (byte) 235, (byte) 110, (byte) 125, (byte) 9, (byte) 51, (byte) 45, (byte) 98, (byte) 5, (byte) 242, (byte) 218, (byte) 241, (byte) 192, (byte) 73, (byte) 51, (byte) 214, (byte) 61, (byte) 206, (byte) 241, (byte) 196, (byte) 158, (byte) 141, (byte) 34, (byte) 148, (byte) 176, (byte) 27, (byte) 134, (byte) 77, (byte) 189, (byte) 82, (byte) 107, (byte) 129};
        private static final byte[] Wape9drmrNdENAdRXhHJq = {(byte) 164, (byte) 153, (byte) 64, (byte) 224, (byte) 168, (byte) 177, (byte) 115, (byte) 168, (byte) 129, (byte) 203, (byte) 114, (byte) 129, (byte) 86, (byte) 223, (byte) 218, (byte) 68, (byte) 56, (byte) 235, (byte) 110, (byte) 125, (byte) 9, (byte) 51, (byte) 45, (byte) 98, (byte) 5, (byte) 242, (byte) 218, (byte) 241, (byte) 192, (byte) 73, (byte) 51, (byte) 214, (byte) 25, (byte) 134, (byte) 103, (byte) 189, (byte) 232, (byte) 53, (byte) 13, (byte) 181, (byte) 214, (byte) 61, (byte) 124, (byte) 200, (byte) 138, (byte) 96, (byte) 34, (byte) 220, (byte) 229, (byte) 160, (byte) 223, (byte) 46, (byte) 69, (byte) 163, (byte) 214, (byte) 44, (byte) 224, (byte) 177, (byte) 38, (byte) 84, (byte) 151, (byte) 134, (byte) 177, (byte) 129, (byte) 59, (byte) 198, (byte) 251, (byte) 15, (byte) 227, (byte) 227, (byte) 82, (byte) 116, (byte) 156, (byte) 33, (byte) 250, (byte) 42, (byte) 0, (byte) 50, (byte) 157, (byte) 12, (byte) 191, (byte) 34, (byte) 114, (byte) 193, (byte) 222, (byte) 188, (byte) 102, (byte) 83, (byte) 47, (byte) 125, (byte) 118, (byte) 238, (byte) 192, (byte) 216, (byte) 186, (byte) 159};
        private static final byte[] VKQ3qlbDCqG87NtuI1V = {(byte) 191, (byte) 60, (byte) 117, (byte) 246, (byte) 160, (byte) 66, (byte) 207, (byte) 69, (byte) 95, (byte) 139, (byte) 193, (byte) 167, (byte) 202, (byte) 86, (byte) 88, (byte) 28, (byte) 73, (byte) 157, (byte) 112, (byte) 32, (byte) 241, (byte) 253, (byte) 186, (byte) 77, (byte) 25, (byte) 187, (byte) 122, (byte) 219, (byte) 58, (byte) 179, (byte) 103, (byte) 129};
        private static final byte[] rBjvfZKkXZTFKsfQVl = {(byte) 164, (byte) 153, (byte) 64, (byte) 224, (byte) 168, (byte) 177, (byte) 115, (byte) 168, (byte) 129, (byte) 203, (byte) 114, (byte) 129, (byte) 86, (byte) 223, (byte) 218, (byte) 68, (byte) 56, (byte) 235, (byte) 110, (byte) 125, (byte) 9, (byte) 51, (byte) 45, (byte) 98, (byte) 5, (byte) 242, (byte) 218, (byte) 241, (byte) 192, (byte) 73, (byte) 51, (byte) 214, (byte) 25, (byte) 134, (byte) 103, (byte) 189, (byte) 232, (byte) 53, (byte) 13, (byte) 181, (byte) 214, (byte) 61, (byte) 124, (byte) 200, (byte) 138, (byte) 96, (byte) 34, (byte) 220, (byte) 229, (byte) 160, (byte) 223, (byte) 46, (byte) 69, (byte) 163, (byte) 214, (byte) 44, (byte) 224, (byte) 177, (byte) 38, (byte) 84, (byte) 151, (byte) 134, (byte) 177, (byte) 129, (byte) 59, (byte) 198, (byte) 251, (byte) 15, (byte) 227, (byte) 227, (byte) 82, (byte) 116, (byte) 156, (byte) 33, (byte) 250, (byte) 42, (byte) 0, (byte) 50, (byte) 157, (byte) 12, (byte) 191, (byte) 34, (byte) 114, (byte) 193, (byte) 222, (byte) 188, (byte) 102, (byte) 83, (byte) 47, (byte) 125, (byte) 118, (byte) 238, (byte) 192, (byte) 216, (byte) 186, (byte) 159};
        private static final byte[] umkWrKgiIwiaJ5 = {(byte) 164, (byte) 153, (byte) 64, (byte) 224, (byte) 168, (byte) 177, (byte) 115, (byte) 168, (byte) 129, (byte) 203, (byte) 114, (byte) 129, (byte) 86, (byte) 223, (byte) 218, (byte) 68, (byte) 56, (byte) 235, (byte) 110, (byte) 125, (byte) 9, (byte) 51, (byte) 45, (byte) 98, (byte) 5, (byte) 242, (byte) 218, (byte) 241, (byte) 192, (byte) 73, (byte) 51, (byte) 214, (byte) 61, (byte) 206, (byte) 241, (byte) 196, (byte) 158, (byte) 141, (byte) 34, (byte) 148, (byte) 176, (byte) 27, (byte) 134, (byte) 77, (byte) 189, (byte) 82, (byte) 107, (byte) 129};
        private static final byte[] Nfxrk5zsDT46Qtil2sGz = {(byte) 191, (byte) 60, (byte) 117, (byte) 246, (byte) 160, (byte) 66, (byte) 207, (byte) 69, (byte) 95, (byte) 139, (byte) 193, (byte) 167, (byte) 202, (byte) 86, (byte) 88, (byte) 28, (byte) 73, (byte) 157, (byte) 112, (byte) 32, (byte) 241, (byte) 253, (byte) 186, (byte) 77, (byte) 25, (byte) 187, (byte) 122, (byte) 219, (byte) 58, (byte) 179, (byte) 103, (byte) 129};
        private static final byte[] pHfCee0jHwynoCImp = {(byte) 191, (byte) 60, (byte) 117, (byte) 246, (byte) 160, (byte) 66, (byte) 207, (byte) 69, (byte) 95, (byte) 139, (byte) 193, (byte) 167, (byte) 202, (byte) 86, (byte) 88, (byte) 28, (byte) 73, (byte) 157, (byte) 112, (byte) 32, (byte) 241, (byte) 253, (byte) 186, (byte) 77, (byte) 25, (byte) 187, (byte) 122, (byte) 219, (byte) 58, (byte) 179, (byte) 103, (byte) 129};
        private static final byte[] k0KTcbBLnsjQRETwcO2FU = {(byte) 164, (byte) 153, (byte) 64, (byte) 224, (byte) 168, (byte) 177, (byte) 115, (byte) 168, (byte) 129, (byte) 203, (byte) 114, (byte) 129, (byte) 86, (byte) 223, (byte) 218, (byte) 68, (byte) 56, (byte) 235, (byte) 110, (byte) 125, (byte) 9, (byte) 51, (byte) 45, (byte) 98, (byte) 5, (byte) 242, (byte) 218, (byte) 241, (byte) 192, (byte) 73, (byte) 51, (byte) 214, (byte) 25, (byte) 134, (byte) 103, (byte) 189, (byte) 232, (byte) 53, (byte) 13, (byte) 181, (byte) 214, (byte) 61, (byte) 124, (byte) 200, (byte) 138, (byte) 96, (byte) 34, (byte) 220, (byte) 229, (byte) 160, (byte) 223, (byte) 46, (byte) 69, (byte) 163, (byte) 214, (byte) 44, (byte) 224, (byte) 177, (byte) 38, (byte) 84, (byte) 151, (byte) 134, (byte) 177, (byte) 129, (byte) 59, (byte) 198, (byte) 251, (byte) 15, (byte) 227, (byte) 227, (byte) 82, (byte) 116, (byte) 156, (byte) 33, (byte) 250, (byte) 42, (byte) 0, (byte) 50, (byte) 157, (byte) 12, (byte) 191, (byte) 34, (byte) 114, (byte) 193, (byte) 222, (byte) 188, (byte) 102, (byte) 83, (byte) 47, (byte) 125, (byte) 118, (byte) 238, (byte) 192, (byte) 216, (byte) 186, (byte) 159};
        private static final byte[] gxwa90XcEPPbSjFSOclI = {(byte) 191, (byte) 60, (byte) 117, (byte) 246, (byte) 160, (byte) 66, (byte) 207, (byte) 69, (byte) 95, (byte) 139, (byte) 193, (byte) 167, (byte) 202, (byte) 86, (byte) 88, (byte) 28, (byte) 73, (byte) 157, (byte) 112, (byte) 32, (byte) 241, (byte) 253, (byte) 186, (byte) 77, (byte) 25, (byte) 187, (byte) 122, (byte) 219, (byte) 58, (byte) 179, (byte) 103, (byte) 129};
        private static final byte[] HSzbrZJIpe7xxScr = {(byte) 73, (byte) 253, (byte) 236, (byte) 32, (byte) 110, (byte) 82, (byte) 199, (byte) 224, (byte) 11, (byte) 183, (byte) 149, (byte) 39, (byte) 131, (byte) 184, (byte) 160, (byte) 172, (byte) 60, (byte) 149, (byte) 202, (byte) 170, (byte) 225, (byte) 212, (byte) 76, (byte) 19, (byte) 216, (byte) 124, (byte) 146, (byte) 168, (byte) 194, (byte) 157, (byte) 98, (byte) 28};
        private static final byte[] RJ9TwjiY1xnESAb = {(byte) 107, (byte) 15, (byte) 240, (byte) 54, (byte) 151, (byte) 235, (byte) 254, (byte) 201, (byte) 55, (byte) 36, (byte) 164, (byte) 7, (byte) 219, (byte) 77, (byte) 83, (byte) 67};

        public Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY(Object obj) {
            if (obj == null) {
                this.v8qP8fE86HMhvNuYPFjqY = Optional.of(new JSONObject());
                this.jBUuLP0sWwaPyPOmogdX7l = Optional.of(new JSONArray());
                return this;
            }
            if (obj instanceof JSONObject) {
                this.v8qP8fE86HMhvNuYPFjqY = Optional.of(new JSONObject(obj.toString()));
                return this;
            }
            if (obj instanceof String) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (Exception e) {
                }
                if (jSONObject != null) {
                    this.v8qP8fE86HMhvNuYPFjqY = Optional.of(jSONObject);
                    return this;
                }
            }
            return this;
        }

        public Optional<JSONObject> v8qP8fE86HMhvNuYPFjqY() {
            return this.v8qP8fE86HMhvNuYPFjqY;
        }

        public Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY(String str) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                v8qP8fE86HMhvNuYPFjqY((Object) null);
            }
            if (this.v8qP8fE86HMhvNuYPFjqY.get().has(str)) {
                JSONArray jSONArray = this.v8qP8fE86HMhvNuYPFjqY.get().getJSONArray(str);
                this.ZwrsrwOCXRUscW6Q = Optional.of(str);
                this.jBUuLP0sWwaPyPOmogdX7l = Optional.of(jSONArray);
                return this;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new JSONObject());
            this.ZwrsrwOCXRUscW6Q = Optional.of(str);
            this.jBUuLP0sWwaPyPOmogdX7l = Optional.of(jSONArray2);
            return this;
        }

        public Ijap9SQKkijXSxP5 jBUuLP0sWwaPyPOmogdX7l(String str) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(rO3UpMcQaajeAYwB1j()), "You haven't set the json object yet, use the JsonUtils.Builder()#setObject() method.");
            }
            if (!this.v8qP8fE86HMhvNuYPFjqY.get().has(str)) {
                return this;
            }
            this.jBUuLP0sWwaPyPOmogdX7l = Optional.of(this.v8qP8fE86HMhvNuYPFjqY.get().getJSONArray(str));
            return this;
        }

        public Ijap9SQKkijXSxP5 ZwrsrwOCXRUscW6Q(String str) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(l0XJNpGeMarsVxWuYGDBgD()), lU5iZSCQV8QnJKdH());
            }
            if (!this.v8qP8fE86HMhvNuYPFjqY.get().has(str)) {
                return this;
            }
            this.v8qP8fE86HMhvNuYPFjqY.get().remove(str);
            return this;
        }

        public Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY(String str, Object obj) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(xLThIC5jAgfGql8gwb()), n8nonNYr3ogX7g0YHO());
            }
            if (!this.jBUuLP0sWwaPyPOmogdX7l.isPresent() || !this.ZwrsrwOCXRUscW6Q.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(kX6BSnWfeESGqC7cBrm()), HBj8wv6a7woDcI());
            }
            List<JSONObject> list = (List<JSONObject>) IntStream.range(0, this.jBUuLP0sWwaPyPOmogdX7l.get().length()).mapToObj(i -> {
                return (JSONObject) this.jBUuLP0sWwaPyPOmogdX7l.get().get(i);
            }).collect(Collectors.toList());
            list.removeIf(jSONObject -> {
                return jSONObject.has(str) && jSONObject.get(str).equals(obj);
            });
            JSONArray jSONArray = new JSONArray();
            jSONArray.putAll((Collection<?>) list);
            this.jBUuLP0sWwaPyPOmogdX7l.get().clear();
            if (jSONArray.length() <= 0) {
                return this;
            }
            this.jBUuLP0sWwaPyPOmogdX7l.get().put(jSONArray);
            this.v8qP8fE86HMhvNuYPFjqY.get().put(this.ZwrsrwOCXRUscW6Q.get(), this.jBUuLP0sWwaPyPOmogdX7l.get());
            return this;
        }

        public Ijap9SQKkijXSxP5 iZTqZaRK5UGoe0Z(String str) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(ytpX4diiAOrzfZhGXzOBQT()), P6XNM3NOAaqSTnW());
            }
            if (!this.jBUuLP0sWwaPyPOmogdX7l.isPresent() || !this.ZwrsrwOCXRUscW6Q.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(OiOAQesQ0s8z03()), S1yUtJCiHQhZRM());
            }
            List<JSONObject> list = (List<JSONObject>) IntStream.range(0, this.jBUuLP0sWwaPyPOmogdX7l.get().length()).mapToObj(i -> {
                return (JSONObject) this.jBUuLP0sWwaPyPOmogdX7l.get().get(i);
            }).collect(Collectors.toList());
            list.removeIf(jSONObject -> {
                return jSONObject.has(str) && jSONObject.get(str) != null;
            });
            this.jBUuLP0sWwaPyPOmogdX7l.get().clear();
            JSONArray jSONArray = new JSONArray();
            jSONArray.putAll((Collection<?>) list);
            if (jSONArray.length() <= 0) {
                return this;
            }
            this.jBUuLP0sWwaPyPOmogdX7l.get().put(jSONArray);
            this.v8qP8fE86HMhvNuYPFjqY.get().put(this.ZwrsrwOCXRUscW6Q.get(), jSONArray);
            return this;
        }

        public Ijap9SQKkijXSxP5 jBUuLP0sWwaPyPOmogdX7l(String str, Object obj) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(QDG6HZwW9sGSQERAX()), h1OOetiR2ikv3FqrNExfOS());
            }
            if (!this.jBUuLP0sWwaPyPOmogdX7l.isPresent() || !this.ZwrsrwOCXRUscW6Q.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(CtXkrROSAiZS4c()), famWAE8iIMOPgwZhY3l());
            }
            List<JSONObject> list = (List<JSONObject>) IntStream.range(0, this.jBUuLP0sWwaPyPOmogdX7l.get().length()).mapToObj(i -> {
                return (JSONObject) this.jBUuLP0sWwaPyPOmogdX7l.get().get(i);
            }).collect(Collectors.toList());
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((JSONObject) it.next()).put(str, obj);
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.putAll((Collection<?>) list);
                this.v8qP8fE86HMhvNuYPFjqY.get().put(this.ZwrsrwOCXRUscW6Q.get(), jSONArray);
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, obj);
            jSONArray2.put(jSONObject2);
            jSONObject.put(this.ZwrsrwOCXRUscW6Q.get(), jSONArray2);
            this.v8qP8fE86HMhvNuYPFjqY.get().put(this.ZwrsrwOCXRUscW6Q.get(), jSONArray2);
            return this;
        }

        public Ijap9SQKkijXSxP5 xtOheRiObl4QeAl(String str) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(wa9546Df3tEVeWss()), zQlNi7HdoWqcvWW());
            }
            if (!this.jBUuLP0sWwaPyPOmogdX7l.isPresent() || !this.ZwrsrwOCXRUscW6Q.isPresent()) {
                new UsEbiuprSHpNw3qjITfH(new Throwable(EBh3Qr624lONZFFELh6I9()), adcBmVpYpgL7LRg7());
            }
            List<JSONObject> list = (List) IntStream.range(0, this.jBUuLP0sWwaPyPOmogdX7l.get().length()).mapToObj(i -> {
                return (JSONObject) this.jBUuLP0sWwaPyPOmogdX7l.get().get(i);
            }).collect(Collectors.toList());
            for (JSONObject jSONObject : list) {
                if (jSONObject.has(str)) {
                    jSONObject.remove(str);
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.putAll((Collection<?>) list);
            this.v8qP8fE86HMhvNuYPFjqY.get().put(this.ZwrsrwOCXRUscW6Q.get(), jSONArray);
            return this;
        }

        private static String ZMkcRZ1ToeDlQphUK6o(byte[] bArr) {
        return "";
    }

        private static String rO3UpMcQaajeAYwB1j() {
        return "JsonUtils Error!";
    }

        private static String l0XJNpGeMarsVxWuYGDBgD() {
        return "JsonUtils Error!";
    }

        private static String lU5iZSCQV8QnJKdH() {
        return "You haven't set the json object yet, use the JsonUtils.Builder()#setObject(Object) method.";
    }

        private static String xLThIC5jAgfGql8gwb() {
        return "JsonUtils Error!";
    }

        private static String n8nonNYr3ogX7g0YHO() {
        return "You haven't set the json object yet, use the JsonUtils.Builder()#setObject(Object) method.";
    }

        private static String kX6BSnWfeESGqC7cBrm() {
        return "JsonUtils Error!";
    }

        private static String HBj8wv6a7woDcI() {
        return "You haven't set the json object or arrays.";
    }

        private static String ytpX4diiAOrzfZhGXzOBQT() {
        return "JsonUtils Error!";
    }

        private static String P6XNM3NOAaqSTnW() {
        return "You haven't set the json object yet, use the JsonUtils.Builder()#setObject(Object) method.";
    }

        private static String OiOAQesQ0s8z03() {
        return "JsonUtils Error!";
    }

        private static String S1yUtJCiHQhZRM() {
        return "You haven't set the json object or arrays.";
    }

        private static String QDG6HZwW9sGSQERAX() {
        return "JsonUtils Error!";
    }

        private static String h1OOetiR2ikv3FqrNExfOS() {
        return "You haven't set the json object yet, use the JsonUtils.Builder()#setObject(Object) method.";
    }

        private static String CtXkrROSAiZS4c() {
        return "JsonUtils Error!";
    }

        private static String famWAE8iIMOPgwZhY3l() {
        return "You haven't set the json object or arrays.";
    }

        private static String wa9546Df3tEVeWss() {
        return "JsonUtils Error!";
    }

        private static String zQlNi7HdoWqcvWW() {
        return "You haven't set the json object yet, use the JsonUtils.Builder()#setObject(Object) method.";
    }

        private static String EBh3Qr624lONZFFELh6I9() {
        return "JsonUtils Error!";
    }

        private static String adcBmVpYpgL7LRg7() {
        return "You haven't set the json object or arrays.";
    }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/RuVgd0Dnv0ddhdcWL$UsEbiuprSHpNw3qjITfH.class */
    public static final class UsEbiuprSHpNw3qjITfH extends RuntimeException {
        UsEbiuprSHpNw3qjITfH(Throwable th) {
            super("An error occurred when handling Json!", th);
        }

        UsEbiuprSHpNw3qjITfH(Throwable th, String str) {
            super(str, th);
        }
    }

    public Optional<JSONObject> v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY.isPresent() ? this.v8qP8fE86HMhvNuYPFjqY : Optional.empty();
    }

    public RuVgd0Dnv0ddhdcWL v8qP8fE86HMhvNuYPFjqY(Object obj) {
        if (obj instanceof JSONObject) {
            this.v8qP8fE86HMhvNuYPFjqY = Optional.of(new JSONObject(obj.toString()));
            return this;
        }
        if (obj instanceof String) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject((String) obj);
            } catch (Exception e) {
            }
            if (jSONObject != null) {
                this.v8qP8fE86HMhvNuYPFjqY = Optional.of(jSONObject);
                return this;
            }
        }
        return this;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(String str) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
            new UsEbiuprSHpNw3qjITfH(new Throwable(CIShSWJUrz4GaN()), A6qyjnW3Skw7i1WwrN7J());
        }
        return this.v8qP8fE86HMhvNuYPFjqY.get().has(str);
    }

    public Optional<JSONArray> jBUuLP0sWwaPyPOmogdX7l(String str) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
            new UsEbiuprSHpNw3qjITfH(new Throwable(VQLBnoNg4ZelBJI()), GPW2OPG9Myw1cakwcwts());
        }
        return this.v8qP8fE86HMhvNuYPFjqY.get().has(str) ? Optional.of(this.v8qP8fE86HMhvNuYPFjqY.get().getJSONArray(str)) : Optional.empty();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
            new UsEbiuprSHpNw3qjITfH(new Throwable(WxaCg1NqNRPVkcxt()), wQOXEHKZJeixTTSG());
        }
        if (!v8qP8fE86HMhvNuYPFjqY(str)) {
            return false;
        }
        Optional<JSONArray> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(str);
        return ((List<JSONObject>) IntStream.range(0, optionalJBUuLP0sWwaPyPOmogdX7l.get().length()).mapToObj(i -> {
            return (JSONObject) ((JSONArray) optionalJBUuLP0sWwaPyPOmogdX7l.get()).get(i);
        }).collect(Collectors.toList())).stream().filter(jSONObject -> {
            return jSONObject.has(str2);
        }).findAny().isPresent();
    }

    public Optional<JSONObject> jBUuLP0sWwaPyPOmogdX7l(String str, String str2) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.isPresent()) {
            new UsEbiuprSHpNw3qjITfH(new Throwable(bMjAP7EC6cEAv1n3TOO()), eGEKbruKxFxvrBsTOpw());
        }
        if (v8qP8fE86HMhvNuYPFjqY(str)) {
            Optional<JSONArray> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(str);
            Optional<JSONObject> optionalFindAny = ((List<JSONObject>) IntStream.range(0, optionalJBUuLP0sWwaPyPOmogdX7l.get().length()).mapToObj(i -> {
                return (JSONObject) ((JSONArray) optionalJBUuLP0sWwaPyPOmogdX7l.get()).get(i);
            }).collect(Collectors.toList())).stream().filter(jSONObject -> {
                return jSONObject.has(str2);
            }).findAny();
            if (optionalFindAny.isPresent()) {
                return optionalFindAny;
            }
        }
        return Optional.empty();
    }

    public Optional<Object> ZwrsrwOCXRUscW6Q(String str, String str2) {
        Optional<JSONObject> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(str, str2);
        return optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() ? Optional.of(optionalJBUuLP0sWwaPyPOmogdX7l.get().get(str2)) : Optional.empty();
    }

    public Optional<String> iZTqZaRK5UGoe0Z(String str, String str2) {
        Optional<JSONObject> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(str, str2);
        return (optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() && (optionalJBUuLP0sWwaPyPOmogdX7l.get().get(str2) instanceof String)) ? Optional.of(optionalJBUuLP0sWwaPyPOmogdX7l.get().getString(str2)) : Optional.empty();
    }

    public Optional<Integer> xtOheRiObl4QeAl(String str, String str2) {
        Optional<JSONObject> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(str, str2);
        return (optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() && (optionalJBUuLP0sWwaPyPOmogdX7l.get().get(str2) instanceof Integer)) ? Optional.of(Integer.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l.get().getInt(str2))) : Optional.empty();
    }

    public Optional<Boolean> zJnaNCVQSgEShq(String str, String str2) {
        Optional<JSONObject> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(str, str2);
        return (optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() && (optionalJBUuLP0sWwaPyPOmogdX7l.get().get(str2) instanceof Boolean)) ? Optional.of(Boolean.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l.get().getBoolean(str2))) : Optional.empty();
    }

    public static JSONObject v8qP8fE86HMhvNuYPFjqY(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (!jSONObject2.has(next)) {
                jSONObject2.put(next, obj);
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (jSONArray.get(i) instanceof JSONObject) {
                        v8qP8fE86HMhvNuYPFjqY((JSONObject) jSONArray.get(i), jSONObject2.getJSONArray(next).getJSONObject(i));
                    }
                }
            } else if (obj instanceof JSONObject) {
                v8qP8fE86HMhvNuYPFjqY((JSONObject) obj, jSONObject2.getJSONObject(next));
            } else {
                jSONObject2.put(next, obj);
            }
        }
        return jSONObject2;
    }

    private static String CIShSWJUrz4GaN() {
        return "JsonUtils Error!";
    }

    private static String A6qyjnW3Skw7i1WwrN7J() {
        return "You haven't set the json object yet, use the JsonUtils#setObject(Object) method.";
    }

    private static String VQLBnoNg4ZelBJI() {
        return "JsonUtils Error!";
    }

    private static String GPW2OPG9Myw1cakwcwts() {
        return "You haven't set the json object yet, use the JsonUtils#setObject(Object) method.";
    }

    private static String WxaCg1NqNRPVkcxt() {
        return "JsonUtils Error!";
    }

    private static String wQOXEHKZJeixTTSG() {
        return "You haven't set the json object yet, use the JsonUtils#setObject(Object) method.";
    }

    private static String bMjAP7EC6cEAv1n3TOO() {
        return "JsonUtils Error!";
    }

    private static String eGEKbruKxFxvrBsTOpw() {
        return "You haven't set the json object yet, use the JsonUtils#setObject(Object) method.";
    }
}
