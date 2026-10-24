package me.ulrich.clans.manager.utils;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent.class */
public class DiscordEvent {
    private final String url;
    private String content;
    private String username;
    private String avatarUrl;
    private boolean tts;
    private List<EmbedObject> embeds = new ArrayList();
    private static String sQdSh9DLX4C2nW;
    private static String kF1RW5QeDUkkR8;
    private static volatile String gzE2hiXY6uxByz;
    private static volatile String oFk2eo44COKrK3A;
    private static String q3ArnRCiilrP1KUlX8joXN;
    private static String UrDRFDZO1ktScmycR;
    private static String Pc2DO3PQm9BmWdl15H;
    private static String wpXt3MVKJfvBTE;
    private static String XIaZ4F6DRPyv1Mkmpk;
    private static String PSecOqVYfzSxjLte;
    private static String d7GwtBAczCioqRqs8aPwRC;
    private static String cedGICl9qaeC5XqzSa;
    private static String GmzuW0Lxx8QEaw;
    private static volatile String VoU0QHPHp5QdPD5secdWKO;
    private static String PgA1yMWQmsH5HeB4sTX;
    private static volatile String O8AQx5VSymFPMb;
    private static String llAqo11P4CUYmNJSI;
    private static volatile String SWiNHYLzRSdjQ9ggkb9X;
    private static String USJeMNJSz0ZDjpFLwhIkfI;
    private static volatile String uidItn16h8p26u1;
    private static String pev3Hus84YS3Y18ECW;
    private static volatile String uKQGpydHNpAaCRaP;
    private static volatile String hya6BT1xiNL8h0cf8G;
    private static volatile String uhFzK7ejyhxksecVOJBr8;
    private static String yajSBHMKVZ6gqyrjf3;
    private static volatile String jXDSPPuKdi7y2bhh;
    private static volatile String b0InMHVWjQwRNo21;
    private static String w2ND3Mb49iCO8wbmFlD;
    private static String yBE4ZE3sPblKlw;
    private static String ofPC5C7Jf6u09IwCvRw;
    private static final byte[] x0DldBAdjnL56ZNhD = {(byte) 135, (byte) 148, (byte) 157, (byte) 149, (byte) 98, (byte) 141, (byte) 141, (byte) 230, (byte) 45, (byte) 96, (byte) 64, (byte) 255, (byte) 89, (byte) 98, (byte) 98, (byte) 36};
    private static final byte[] kHTZAGnjvL1BrCLpe = {(byte) 226, (byte) 0, (byte) 5, (byte) 64, (byte) 193, (byte) 35, (byte) 149, (byte) 160, (byte) 168, (byte) 37, (byte) 145, (byte) 209, (byte) 114, (byte) 49, (byte) 92, (byte) 78, (byte) 191, (byte) 212, (byte) 71, (byte) 164, (byte) 99, (byte) 15, (byte) 37, (byte) 88, (byte) 212, (byte) 12, (byte) 13, (byte) 45, (byte) 190, (byte) 130, (byte) 123, (byte) 53};
    private static final byte[] zRUnRODfeP6KmShHlp = {(byte) 122, (byte) 167, (byte) 148, (byte) 103, (byte) 0, (byte) 64, (byte) 1, (byte) 250, (byte) 121, (byte) 126, (byte) 167, (byte) 119, (byte) 194, (byte) 215, (byte) 92, (byte) 31};
    private static final byte[] FXwiOMmqUSBzHx7tC = {(byte) 51, (byte) 200, (byte) 77, (byte) 17, (byte) 105, (byte) 136, (byte) 131, (byte) 121, (byte) 239, (byte) 104, (byte) 25, (byte) 192, (byte) 245, (byte) 77, (byte) 133, (byte) 44};
    private static final byte[] u0JGsCNZvRBHKvrakp = {(byte) 91, (byte) 65, (byte) 13, (byte) 165, (byte) 107, (byte) 1, (byte) 134, (byte) 215, (byte) 35, (byte) 139, (byte) 242, (byte) 225, (byte) 91, (byte) 178, (byte) 81, (byte) 252};
    private static final byte[] px6UKYWgjnVlciiRY = {(byte) 150, (byte) 61, (byte) 160, (byte) 96, (byte) 56, (byte) 74, (byte) 197, (byte) 150, (byte) 73, (byte) 221, (byte) 161, (byte) 197, (byte) 241, (byte) 18, (byte) 149, (byte) 161};
    private static final byte[] A6POTOitpGu9ck4e61aPB = {(byte) 29, (byte) 223, (byte) 151, (byte) 108, (byte) 45, (byte) 104, (byte) 210, (byte) 230, (byte) 100, (byte) 196, (byte) 119, (byte) 148, (byte) 218, (byte) 29, (byte) 186, (byte) 255};
    private static final byte[] fn8XRzrE5nWbvQEk = {(byte) 96, (byte) 56, (byte) 7, (byte) 233, (byte) 221, (byte) 189, (byte) 0, (byte) 238, (byte) 232, (byte) 242, (byte) 68, (byte) 47, (byte) 254, (byte) 181, (byte) 251, (byte) 250};
    private static final byte[] f23lg1hEFfawoNGUkZj5 = {(byte) 95, (byte) 242, (byte) 44, (byte) 154, (byte) 2, (byte) 181, (byte) 225, (byte) 37, (byte) 231, (byte) 132, (byte) 2, (byte) 75, (byte) 46, (byte) 179, (byte) 110, (byte) 109};
    private static final byte[] jmRgOTJXX0cjP8J = {(byte) 19, (byte) 50, (byte) 97, (byte) 240, (byte) 164, (byte) 160, (byte) 192, (byte) 71, (byte) 161, (byte) 192, (byte) 183, (byte) 69, (byte) 243, (byte) 231, (byte) 246, (byte) 109};
    private static final byte[] GoCvvbm6trFcmzf9Hp = {(byte) 29, (byte) 223, (byte) 151, (byte) 108, (byte) 45, (byte) 104, (byte) 210, (byte) 230, (byte) 100, (byte) 196, (byte) 119, (byte) 148, (byte) 218, (byte) 29, (byte) 186, (byte) 255};
    private static final byte[] Yymgxaur3drHoAputpjJ5 = {(byte) 225, (byte) 154, (byte) 71, (byte) 106, (byte) 96, (byte) 228, (byte) 4, (byte) 115, (byte) 176, (byte) 191, (byte) 140, (byte) 24, (byte) 238, (byte) 219, (byte) 4, (byte) 102};
    private static final byte[] DLi5Wj2QSqVvnrn5wcdV = {(byte) 255, (byte) 177, (byte) 31, (byte) 47, (byte) 52, (byte) 190, (byte) 49, (byte) 29, (byte) 167, (byte) 100, (byte) 54, (byte) 201, (byte) 41, (byte) 240, (byte) 123, (byte) 240};
    private static final byte[] nWGmHaWev6K30nmNufsg = {(byte) 205, (byte) 30, (byte) 212, (byte) 67, (byte) 109, (byte) 249, (byte) 94, (byte) 105, (byte) 225, (byte) 152, (byte) 29, (byte) 62, (byte) 153, (byte) 201, (byte) 92, (byte) 149};
    private static final byte[] LzxgOgzNbJwkQ6L7 = {(byte) 59, (byte) 15, (byte) 207, (byte) 24, (byte) 74, (byte) 249, (byte) 237, (byte) 191, (byte) 77, (byte) 216, (byte) 33, (byte) 12, (byte) 123, (byte) 147, (byte) 48, (byte) 216};
    private static final byte[] lsgCp2YxuXnZeaCqPAe4M = {(byte) 38, (byte) 93, (byte) 157, (byte) 206, (byte) 227, (byte) 78, (byte) 240, (byte) 244, (byte) 141, (byte) 208, (byte) 198, (byte) 249, (byte) 140, (byte) 43, (byte) 32, (byte) 82, (byte) 178, (byte) 148, (byte) 154, (byte) 87, (byte) 181, (byte) 99, (byte) 191, (byte) 25, (byte) 181, (byte) 143, (byte) 162, (byte) 62, (byte) 222, (byte) 150, (byte) 145, (byte) 154, (byte) 0, (byte) 118, (byte) 96, (byte) 49, (byte) 28, (byte) 145, (byte) 48, (byte) 3, (byte) 95, (byte) 26, (byte) 176, (byte) 205, (byte) 20, (byte) 102, (byte) 26, (byte) 227};
    private static final byte[] xLXKmo6OSU0rgW6CeOyPr2 = {(byte) 41, (byte) 240, (byte) 191, (byte) 114, (byte) 116, (byte) 78, (byte) 79, (byte) 230, (byte) 235, (byte) 146, (byte) 2, (byte) 48, (byte) 115, (byte) 186, (byte) 137, (byte) 233, (byte) 78, (byte) 86, (byte) 198, (byte) 181, (byte) 236, (byte) 119, (byte) 253, (byte) 179, (byte) 182, (byte) 23, (byte) 19, (byte) 108, (byte) 131, (byte) 95, (byte) 167, (byte) 254, (byte) 92, (byte) 64, (byte) 26, (byte) 189, (byte) 220, (byte) 54, (byte) 186, (byte) 42, (byte) 61, (byte) 212, (byte) 111, (byte) 8, (byte) 122, (byte) 116, (byte) 26, (byte) 25};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$EmbedObject.class */
    public static class EmbedObject {
        private String title;
        private String description;
        private String url;
        private Color color;
        private Footer footer;
        private Thumbnail thumbnail;
        private Image image;
        private Author author;
        private List<Field> fields = new ArrayList();

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$EmbedObject$Author.class */
        private class Author {
            private String name;
            private String url;
            private String iconUrl;

            private Author(String str, String str2, String str3) {
                this.name = str;
                this.url = str2;
                this.iconUrl = str3;
            }

            private String getName() {
                return this.name;
            }

            private String getUrl() {
                return this.url;
            }

            private String getIconUrl() {
                return this.iconUrl;
            }
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$EmbedObject$Field.class */
        private class Field {
            private String name;
            private String value;
            private boolean inline;

            private Field(String str, String str2, boolean z) {
                this.name = str;
                this.value = str2;
                this.inline = z;
            }

            private String getName() {
                return this.name;
            }

            private String getValue() {
                return this.value;
            }

            private boolean isInline() {
                return this.inline;
            }
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$EmbedObject$Footer.class */
        private class Footer {
            private String text;
            private String iconUrl;

            private Footer(String str, String str2) {
                this.text = str;
                this.iconUrl = str2;
            }

            private String getText() {
                return this.text;
            }

            private String getIconUrl() {
                return this.iconUrl;
            }
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$EmbedObject$Image.class */
        private class Image {
            private String url;

            private Image(String str) {
                this.url = str;
            }

            private String getUrl() {
                return this.url;
            }
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$EmbedObject$Thumbnail.class */
        private class Thumbnail {
            private String url;

            private Thumbnail(String str) {
                this.url = str;
            }

            private String getUrl() {
                return this.url;
            }
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public String getUrl() {
            return this.url;
        }

        public Color getColor() {
            return this.color;
        }

        public Footer getFooter() {
            return this.footer;
        }

        public Thumbnail getThumbnail() {
            return this.thumbnail;
        }

        public Image getImage() {
            return this.image;
        }

        public Author getAuthor() {
            return this.author;
        }

        public List<Field> getFields() {
            return this.fields;
        }

        public EmbedObject setTitle(String str) {
            this.title = str;
            return this;
        }

        public EmbedObject setDescription(String str) {
            this.description = str;
            return this;
        }

        public EmbedObject setUrl(String str) {
            this.url = str;
            return this;
        }

        public EmbedObject setColor(Color color) {
            this.color = color;
            return this;
        }

        public EmbedObject setFooter(String str, String str2) {
            this.footer = new Footer(str, str2);
            return this;
        }

        public EmbedObject setThumbnail(String str) {
            this.thumbnail = new Thumbnail(str);
            return this;
        }

        public EmbedObject setImage(String str) {
            this.image = new Image(str);
            return this;
        }

        public EmbedObject setAuthor(String str, String str2, String str3) {
            this.author = new Author(str, str2, str3);
            return this;
        }

        public EmbedObject addField(String str, String str2, boolean z) {
            this.fields.add(new Field(str, str2, z));
            return this;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/DiscordEvent$JSONObject.class */
    private class JSONObject {
        private final HashMap<String, Object> map = new HashMap<>();
        private static String Z9EdLl97AlnA7WxZAhv;
        private static String AAUTqW7CXfzzYaNaCq4;
        private static String OQgCeMHOKsOBFPHI7;
        private static String dqk19TipxvlhL3uE;
        private static String Jkql5KEcV9T3NU0DFfAy;
        private static String qEmdC2X9IMJeuW8muLT;
        private static volatile String FXTd17eVCapTnONx8TU;
        private static final byte[] D4xM6amdud85sb75Msrua6 = {(byte) 205, (byte) 147, (byte) 206, (byte) 107, (byte) 16, (byte) 191, (byte) 41, (byte) 51, (byte) 239, (byte) 55, (byte) 210, (byte) 139, (byte) 106, (byte) 9, (byte) 206, (byte) 175};
        private static final byte[] OQ9mjQ9Edl4QPtEJ = {(byte) 25, (byte) 147, (byte) 86, (byte) 56, (byte) 101, (byte) 158, (byte) 34, (byte) 119, (byte) 255, (byte) 137, (byte) 88, (byte) 111, (byte) 134, (byte) 216, (byte) 207, (byte) 83};
        private static final byte[] VTvIy2zDdbU25TdBfl = {(byte) 241, (byte) 67, (byte) 170, (byte) 65, (byte) 7, (byte) 206, (byte) 171, (byte) 69, (byte) 239, (byte) 89, (byte) 201, (byte) 186, (byte) 181, (byte) 239, (byte) 150, (byte) 11};
        private static final byte[] eNceHDpFkaNcZiM0zQD = {(byte) 163, (byte) 37, (byte) 202, (byte) 75, (byte) 58, (byte) 182, (byte) 71, (byte) 3, (byte) 107, (byte) 10, (byte) 234, (byte) 78, (byte) 190, (byte) 200, (byte) 50, (byte) 210, (byte) 211, (byte) 163, (byte) 202, (byte) 30, (byte) 251, (byte) 178, (byte) 9, (byte) 161, (byte) 165, (byte) 87, (byte) 156, (byte) 127, (byte) 207, (byte) 59, (byte) 102, (byte) 0, (byte) 92, (byte) 250, (byte) 120, (byte) 222, (byte) 83, (byte) 238, (byte) 84, (byte) 179, (byte) 165, (byte) 61, (byte) 62, (byte) 42, (byte) 160, (byte) 130, (byte) 175, (byte) 210};

        private JSONObject() {
        }

        void put(String str, Object obj) {
            if (obj != null) {
                this.map.put(str, obj);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Set<Map.Entry<String, Object>> setEntrySet = this.map.entrySet();
            sb.append(fQr4mFfJKlzLIhTUf());
            int i = 0;
            for (Map.Entry<String, Object> entry : setEntrySet) {
                Object value = entry.getValue();
                sb.append(quote(entry.getKey())).append(wgEGIED9ChWFWMRHm());
                if (value instanceof String) {
                    sb.append(quote(String.valueOf(value)));
                } else if (value instanceof Integer) {
                    sb.append(Integer.valueOf(String.valueOf(value)));
                } else if (value instanceof Boolean) {
                    sb.append(value);
                } else if (value instanceof JSONObject) {
                    sb.append(value.toString());
                } else if (value.getClass().isArray()) {
                    sb.append(EKv0mbRz1H23ODId5ycini());
                    int length = Array.getLength(value);
                    int i2 = 0;
                    while (i2 < length) {
                        sb.append(Array.get(value, i2).toString()).append(i2 != length - 1 ? jPUqdSGqPEKt7Qs2() : "");
                        i2++;
                    }
                    sb.append(hoqhF2VGp46Ic3eN1());
                }
                i++;
                sb.append(i == setEntrySet.size() ? nR144SkGhVQIDORm() : PTBlH7mMKypa1k());
            }
            return sb.toString();
        }

        private String quote(String str) {
            return "\"" + str + "\"";
        }

        private static String bXaRpPd3kiyqN3fjayv(byte[] bArr) {
        return "";
    }

        private static String fQr4mFfJKlzLIhTUf() {
        return "{";
    }

        private static String wgEGIED9ChWFWMRHm() {
        return ":";
    }

        private static String EKv0mbRz1H23ODId5ycini() {
        return "[";
    }

        private static String jPUqdSGqPEKt7Qs2() {
        return ",";
    }

        private static String hoqhF2VGp46Ic3eN1() {
        return "]";
    }

        private static String nR144SkGhVQIDORm() {
        return "}";
    }

        private static String PTBlH7mMKypa1k() {
        return ",";
    }
    }

    public DiscordEvent(String str) {
        this.url = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setTts(boolean z) {
        this.tts = z;
    }

    public void addEmbed(EmbedObject embedObject) {
        this.embeds.add(embedObject);
    }

    public void execute(Clans clans) {
        if (this.content == null && this.embeds.isEmpty()) {
            throw new IllegalArgumentException(XeJIDwjXU7HcHx());
        }
        clans.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(tV6ayyBZwxvYuEB(), this.content);
                jSONObject.put(ZJ0ZDXt0mExhGY9reLM(), this.username);
                jSONObject.put(nAJPpRlLkbskPI4MSz0RB(), this.avatarUrl);
                jSONObject.put(gxPe0ByfUtUTk4(), Boolean.valueOf(this.tts));
                if (!this.embeds.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (EmbedObject embedObject : this.embeds) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(l4cPhk5eE3MAB70JzL(), embedObject.getTitle());
                        jSONObject2.put(YtiyYFnO69zkOHpD4W(), embedObject.getDescription());
                        jSONObject2.put(TN0rqRZ6PEBHKk(), embedObject.getUrl());
                        if (embedObject.getColor() != null) {
                            Color color = embedObject.getColor();
                            jSONObject2.put(DbjhP8AgpQdvVK(), Integer.valueOf((((color.getRed() << 8) + color.getGreen()) << 8) + color.getBlue()));
                        }
                        EmbedObject.Footer footer = embedObject.getFooter();
                        EmbedObject.Image image = embedObject.getImage();
                        EmbedObject.Thumbnail thumbnail = embedObject.getThumbnail();
                        EmbedObject.Author author = embedObject.getAuthor();
                        List<EmbedObject.Field> fields = embedObject.getFields();
                        if (footer != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(UPnJwIGXz1pwbcOdD8sDZe(), footer.getText());
                            jSONObject3.put(xIZRBXf43TMevp0bza8qiR(), footer.getIconUrl());
                            jSONObject2.put(De2vbCZiyXJjcBFT6(), jSONObject3);
                        }
                        if (image != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(HcXmrzF6AImw1nSC9(), image.getUrl());
                            jSONObject2.put(phu69JgW5a75Wc(), jSONObject4);
                        }
                        if (thumbnail != null) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put(IpGpbIUyUCth35afmP5(), thumbnail.getUrl());
                            jSONObject2.put(aQF9iOkOer2Oj7Z8cF(), jSONObject5);
                        }
                        if (author != null) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put(BzkecEVEZu51QUtTlvDZ(), author.getName());
                            jSONObject6.put(kDu4qXZDQ86QaGi7(), author.getUrl());
                            jSONObject6.put(wZTpaTR08SGIMUvqD5v(), author.getIconUrl());
                            jSONObject2.put(hQaiQ5hcWJPnBnWs(), jSONObject6);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (EmbedObject.Field field : fields) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put(nT4j41ymDqxMwwTvCyiJ(), field.getName());
                            jSONObject7.put(RmK3yx1Lgl07DWbh(), field.getValue());
                            jSONObject7.put(VFIA645xGfjorhbIi(), Boolean.valueOf(field.isInline()));
                            arrayList2.add(jSONObject7);
                        }
                        jSONObject2.put(gfMCyVGzPQM3PwH(), arrayList2.toArray());
                        arrayList.add(jSONObject2);
                    }
                    jSONObject.put(SvygqFJcDhBDo4w(), arrayList.toArray());
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.url).openConnection();
                httpsURLConnection.addRequestProperty(jRKKOtnOtBcpSl(), OBg8rqdcMeDmoASIdgs());
                httpsURLConnection.addRequestProperty(RQQbUuUqR293KL7o4CFD(), ac9G17XGzbnQQYSSmc());
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod(zM9u6slDDg9D8X());
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(jSONObject.toString().getBytes());
                outputStream.flush();
                outputStream.close();
                httpsURLConnection.getInputStream().close();
                httpsURLConnection.disconnect();
            } catch (FileNotFoundException | UnknownHostException e) {
            } catch (IOException e2) {
            }
        });
    }

    private static String mgGIx6X2x8T6IbZ(byte[] bArr) {
        return "";
    }

    private static String XeJIDwjXU7HcHx() {
        return "Set content or add at least one EmbedObject";
    }

    private static String tV6ayyBZwxvYuEB() {
        return "content";
    }

    private static String ZJ0ZDXt0mExhGY9reLM() {
        return "username";
    }

    private static String nAJPpRlLkbskPI4MSz0RB() {
        return "avatar_url";
    }

    private static String gxPe0ByfUtUTk4() {
        return "tts";
    }

    private static String l4cPhk5eE3MAB70JzL() {
        return "title";
    }

    private static String YtiyYFnO69zkOHpD4W() {
        return "description";
    }

    private static String TN0rqRZ6PEBHKk() {
        return "url";
    }

    private static String DbjhP8AgpQdvVK() {
        return "color";
    }

    private static String UPnJwIGXz1pwbcOdD8sDZe() {
        return "text";
    }

    private static String xIZRBXf43TMevp0bza8qiR() {
        return "icon_url";
    }

    private static String De2vbCZiyXJjcBFT6() {
        return "footer";
    }

    private static String HcXmrzF6AImw1nSC9() {
        return "url";
    }

    private static String phu69JgW5a75Wc() {
        return "image";
    }

    private static String IpGpbIUyUCth35afmP5() {
        return "url";
    }

    private static String aQF9iOkOer2Oj7Z8cF() {
        return "thumbnail";
    }

    private static String BzkecEVEZu51QUtTlvDZ() {
        return "name";
    }

    private static String kDu4qXZDQ86QaGi7() {
        return "url";
    }

    private static String wZTpaTR08SGIMUvqD5v() {
        return "icon_url";
    }

    private static String hQaiQ5hcWJPnBnWs() {
        return "author";
    }

    private static String nT4j41ymDqxMwwTvCyiJ() {
        return "name";
    }

    private static String RmK3yx1Lgl07DWbh() {
        return "value";
    }

    private static String VFIA645xGfjorhbIi() {
        return "inline";
    }

    private static String gfMCyVGzPQM3PwH() {
        return "fields";
    }

    private static String SvygqFJcDhBDo4w() {
        return "embeds";
    }

    private static String jRKKOtnOtBcpSl() {
        return "Content-Type";
    }

    private static String OBg8rqdcMeDmoASIdgs() {
        return "application/json";
    }

    private static String RQQbUuUqR293KL7o4CFD() {
        return "User-Agent";
    }

    private static String ac9G17XGzbnQQYSSmc() {
        return "Java-DiscordWebhook";
    }

    private static String zM9u6slDDg9D8X() {
        return "POST";
    }
}
