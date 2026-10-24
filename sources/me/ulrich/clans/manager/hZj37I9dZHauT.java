package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.EntityOptionsData;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.OnlineData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.PlayerData_Settings;
import me.ulrich.clans.data.SpawnedEntityData;
import me.ulrich.clans.events.ClanPlayerJoinEvent;
import me.ulrich.clans.events.ClanPlayerKDRChangeEvent;
import me.ulrich.clans.events.ClanPlayerKickedEvent;
import me.ulrich.clans.events.ClanPlayerLeaveEvent;
import me.ulrich.clans.events.ClanPlayerSoulsChangeEvent;
import me.ulrich.clans.interfaces.ClaimImplement;
import me.ulrich.clans.interfaces.EventImplement;
import me.ulrich.clans.interfaces.HologramImplement;
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.cache.UpdatePlayerSkinCache;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.entitywizard.packetevents.protocol.entity.type.EntityTypes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/hZj37I9dZHauT.class */
public class hZj37I9dZHauT {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private ConcurrentHashMap<UUID, PlayerData> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private List<OnlineData> ZwrsrwOCXRUscW6Q = new ArrayList();
    private static volatile String EZYop2Q0D2Qg72jIoTzM;
    private static String TXUgmzbkgyI0XWsNEFd1x;
    private static volatile String GDnXWrMtn9eGUtR2oW;
    private static String aE4RWrYPGD4lUaM5gqc;
    private static String y1ayPKQ1sww0SgSRnW2;
    private static volatile String nYyDv5O3Ww1hH23D;
    private static String cmZtPTGseqa63tnhXvIxe5;
    private static volatile String XriKuCAEBuTazzc;
    private static volatile String gbAAFd8jbhQ4LNKY9q43k;
    private static volatile String eKKXhRtLFaH2H3bOD5;
    private static String omfw2rOONZO9zApBFb;
    private static volatile String uXP6CrGKaEkLfosUI6WM;
    private static volatile String wPysv4yucD3hhcrMYxC;
    private static String fThDtknMlzvET1;
    private static volatile String RsPVAyxT3WLMiN3h;
    private static String c39cjUZrFVInkke3KZ;
    private static String P5z6Z46dmgUt5Uwfrg1K;
    private static String fg8vdxUcE9Uv6K5SkajufA;
    private static String zLsYEjOjAHdLgjCcb;
    private static String lieoyTfQa2gaM0iS57nIZ;
    private static String lQ3tZJXyy9lE6spa5iB;
    private static String hv1TvUp1v73mAxX50A;
    private static volatile String j5dJ4J7WYoGzkkGTCF0B;
    private static volatile String dLqs0tZCE7B0CXdy;
    private static volatile String dbFOT5h9Vpx4h44f3ng;
    private static String ueHCSwJSddXplKWmzr4;
    private static volatile String PMpW0nXHrLLl82OVfVEiRo;
    private static volatile String uQ9xYdART4GY1YHDNBp;
    private static volatile String rr5mYTgns7OcZILIv;
    private static volatile String voabMOKVUX7e1gO;
    private static volatile String lojl57nafj226H;
    private static volatile String xWqrGD5Ol3ytT6XWm8xUpw;
    private static volatile String EVZHYcK2RWnIutixZXqdo;
    private static volatile String UqwhhDMLlVM7RKzX6bd;
    private static String GQY3fF2gItzOLFTqD9kPW;
    private static String mZjkoRfcQgZv7HNRp6mdv;
    private static String Ll98JTnmswDkax;
    private static volatile String p8AFvZDVJzisflYU0;
    private static String jkwVvYTy5hMKZPv;
    private static volatile String TVZVQ38qZjYD0cy8185;
    private static volatile String FgKMOiK4dy9cvgWXkdaqY;
    private static String kg1vKK56djGFaY8PH1q4;
    private static volatile String QOQu1Zs23f1tHaYTFPq;
    private static volatile String NyqiZTfOukS34K22u0LbrB;
    private static volatile String ALaZ7JTmIXxPJw1h;
    private static String PXi8eBVuHthYK5;
    private static String w6SddUMVnVo3ujbQit;
    private static volatile String j9L8zBPyCOdQQk;
    private static volatile String XWCtBlDqSbUMJa6rB9fAKk;
    private static volatile String FOzBYurpm0zpNd3m4;
    private static String E52BZc2TBR0lADd5KpMfjZ;
    private static String m0JRnheZbsbHCcvJwVpKVY;
    private static volatile String CGdReKrMT4GASQhrTTV86;
    private static final byte[] AmKjj9ydmtbAWYWXT24XCu = {(byte) 180, (byte) 122, (byte) 183, (byte) 114, (byte) 68, (byte) 28, (byte) 82, (byte) 154, (byte) 105, (byte) 7, (byte) 88, (byte) 248, (byte) 233, (byte) 118, (byte) 152, (byte) 117};
    private static final byte[] b9qA5l2wSh5sLL = {(byte) 86, (byte) 246, (byte) 4, (byte) 251, (byte) 100, (byte) 164, (byte) 220, (byte) 155, (byte) 40, (byte) 89, (byte) 13, (byte) 36, (byte) 239, (byte) 107, (byte) 243, (byte) 38};
    private static final byte[] nLaU5GjIPhrPYYJ2J = {(byte) 198, (byte) 12, (byte) 161, (byte) 29, (byte) 232, (byte) 53, (byte) 252, (byte) 70, (byte) 2, (byte) 110, (byte) 249, (byte) 49, (byte) 71, (byte) 42, (byte) 168, (byte) 4, (byte) 205, (byte) 160, (byte) 245, (byte) 126, (byte) 184, (byte) 180, (byte) 225, (byte) 233, (byte) 224, (byte) 192, (byte) 9, (byte) 83, (byte) 210, (byte) 126, (byte) 22, (byte) 109, (byte) 126, (byte) 159, (byte) 109, (byte) 69, (byte) 61, (byte) 197, (byte) 12, (byte) 136, (byte) 83, (byte) 244, (byte) 144, (byte) 76, (byte) 40, (byte) 196, (byte) 18, (byte) 207};
    private static final byte[] Ku4CdtEk4JVIJiOJo = {(byte) 198, (byte) 12, (byte) 161, (byte) 29, (byte) 232, (byte) 53, (byte) 252, (byte) 70, (byte) 2, (byte) 110, (byte) 249, (byte) 49, (byte) 71, (byte) 42, (byte) 168, (byte) 4, (byte) 205, (byte) 160, (byte) 245, (byte) 126, (byte) 184, (byte) 180, (byte) 225, (byte) 233, (byte) 224, (byte) 192, (byte) 9, (byte) 83, (byte) 210, (byte) 126, (byte) 22, (byte) 109, (byte) 165, (byte) 200, (byte) 103, (byte) 74, (byte) 45, (byte) 189, (byte) 157, (byte) 20, (byte) 27, (byte) 93, (byte) 182, (byte) 229, (byte) 223, (byte) 169, (byte) 164, (byte) 114};
    private static final byte[] BivQD6GrDglnetHZVm = {(byte) 198, (byte) 12, (byte) 161, (byte) 29, (byte) 232, (byte) 53, (byte) 252, (byte) 70, (byte) 2, (byte) 110, (byte) 249, (byte) 49, (byte) 71, (byte) 42, (byte) 168, (byte) 4, (byte) 205, (byte) 160, (byte) 245, (byte) 126, (byte) 184, (byte) 180, (byte) 225, (byte) 233, (byte) 224, (byte) 192, (byte) 9, (byte) 83, (byte) 210, (byte) 126, (byte) 22, (byte) 109, (byte) 126, (byte) 159, (byte) 109, (byte) 69, (byte) 61, (byte) 197, (byte) 12, (byte) 136, (byte) 83, (byte) 244, (byte) 144, (byte) 76, (byte) 40, (byte) 196, (byte) 18, (byte) 207};
    private static final byte[] fKxaXtV7LeeISG = {(byte) 198, (byte) 12, (byte) 161, (byte) 29, (byte) 232, (byte) 53, (byte) 252, (byte) 70, (byte) 2, (byte) 110, (byte) 249, (byte) 49, (byte) 71, (byte) 42, (byte) 168, (byte) 4, (byte) 205, (byte) 160, (byte) 245, (byte) 126, (byte) 184, (byte) 180, (byte) 225, (byte) 233, (byte) 224, (byte) 192, (byte) 9, (byte) 83, (byte) 210, (byte) 126, (byte) 22, (byte) 109, (byte) 69, (byte) 99, (byte) 114, (byte) 209, (byte) 184, (byte) 254, (byte) 190, (byte) 186, (byte) 59, (byte) 93, (byte) 211, (byte) 118, (byte) 29, (byte) 185, (byte) 182, (byte) 150};
    private static final byte[] MxdGHpr6YW5sWWC = {(byte) 198, (byte) 12, (byte) 161, (byte) 29, (byte) 232, (byte) 53, (byte) 252, (byte) 70, (byte) 2, (byte) 110, (byte) 249, (byte) 49, (byte) 71, (byte) 42, (byte) 168, (byte) 4, (byte) 205, (byte) 160, (byte) 245, (byte) 126, (byte) 184, (byte) 180, (byte) 225, (byte) 233, (byte) 224, (byte) 192, (byte) 9, (byte) 83, (byte) 210, (byte) 126, (byte) 22, (byte) 109, (byte) 69, (byte) 99, (byte) 114, (byte) 209, (byte) 184, (byte) 254, (byte) 190, (byte) 186, (byte) 59, (byte) 93, (byte) 211, (byte) 118, (byte) 29, (byte) 185, (byte) 182, (byte) 150};
    private static final byte[] lJRmAqwVyAGCmScKXeEn = {(byte) 82, (byte) 78, (byte) 167, (byte) 110, (byte) 168, (byte) 211, (byte) 76, (byte) 173, (byte) 102, (byte) 150, (byte) 180, (byte) 247, (byte) 173, (byte) 116, (byte) 189, (byte) 12, (byte) 188, (byte) 121, (byte) 134, (byte) 174, (byte) 141, (byte) 77, (byte) 5, (byte) 180, (byte) 205, (byte) 69, (byte) 184, (byte) 93, (byte) 143, (byte) 251, (byte) 142, (byte) 208};
    private static final byte[] qyvZPBUHyXO49leRQ97 = {(byte) 66, (byte) 173, (byte) 110, (byte) 63, (byte) 20, (byte) 96, (byte) 128, (byte) 89, (byte) 74, (byte) 201, (byte) 137, (byte) 141, (byte) 215, (byte) 225, (byte) 157, (byte) 238, (byte) 135, (byte) 190, (byte) 13, (byte) 97, (byte) 193, (byte) 12, (byte) 27, (byte) 80, (byte) 183, (byte) 231, (byte) 22, (byte) 205, (byte) 174, (byte) 207, (byte) 246, (byte) 117};
    private static final byte[] lGMVTEFjIdqlsSFinzemM = {(byte) 66, (byte) 173, (byte) 110, (byte) 63, (byte) 20, (byte) 96, (byte) 128, (byte) 89, (byte) 74, (byte) 201, (byte) 137, (byte) 141, (byte) 215, (byte) 225, (byte) 157, (byte) 238, (byte) 23, (byte) 114, (byte) 85, (byte) 85, (byte) 138, (byte) 65, (byte) 193, (byte) 179, (byte) 191, (byte) 150, (byte) 136, (byte) 181, (byte) 0, (byte) 240, (byte) 182, (byte) 222};
    private static final byte[] oDui7tTbvJfqYrGyptSq = {(byte) 66, (byte) 173, (byte) 110, (byte) 63, (byte) 20, (byte) 96, (byte) 128, (byte) 89, (byte) 74, (byte) 201, (byte) 137, (byte) 141, (byte) 215, (byte) 225, (byte) 157, (byte) 238, (byte) 48, (byte) 244, (byte) 244, (byte) 21, (byte) 228, (byte) 237, (byte) 251, (byte) 133, (byte) 131, (byte) 119, (byte) 81, (byte) 134, (byte) 103, (byte) 110, (byte) 60, (byte) 61};
    private static final byte[] JQNN501VkKb6XAI4 = {(byte) 66, (byte) 173, (byte) 110, (byte) 63, (byte) 20, (byte) 96, (byte) 128, (byte) 89, (byte) 74, (byte) 201, (byte) 137, (byte) 141, (byte) 215, (byte) 225, (byte) 157, (byte) 238, (byte) 116, (byte) 170, (byte) 109, (byte) 241, (byte) 7, (byte) 147, (byte) 170, (byte) 222, (byte) 151, (byte) 1, (byte) 111, (byte) 134, (byte) 62, (byte) 33, (byte) 197, (byte) 232};
    private static final byte[] eHbL8muwDWSeVBaOr = {(byte) 66, (byte) 173, (byte) 110, (byte) 63, (byte) 20, (byte) 96, (byte) 128, (byte) 89, (byte) 74, (byte) 201, (byte) 137, (byte) 141, (byte) 215, (byte) 225, (byte) 157, (byte) 238, (byte) 203, (byte) 173, (byte) 118, (byte) 52, (byte) 239, (byte) 253, (byte) 203, (byte) 31, (byte) 126, (byte) 222, (byte) 58, (byte) 126, (byte) 123, (byte) 62, (byte) 157, (byte) 29};
    private static final byte[] TIKSzq0jN8pfvQ3sfaRV = {(byte) 66, (byte) 173, (byte) 110, (byte) 63, (byte) 20, (byte) 96, (byte) 128, (byte) 89, (byte) 74, (byte) 201, (byte) 137, (byte) 141, (byte) 215, (byte) 225, (byte) 157, (byte) 238, (byte) 213, (byte) 9, (byte) 148, (byte) 59, (byte) 129, (byte) 191, (byte) 83, (byte) 104, (byte) 217, (byte) 177, (byte) 220, (byte) 111, (byte) 139, (byte) 99, (byte) 197, (byte) 199};
    private static final byte[] rPgK0TUS5XDYLPuwZSfW = {(byte) 230, (byte) 84, (byte) 242, (byte) 98, (byte) 8, (byte) 212, (byte) 11, (byte) 17, (byte) 58, (byte) 115, (byte) 238, (byte) 76, (byte) 120, (byte) 203, (byte) 170, (byte) 66, (byte) 72, (byte) 183, (byte) 100, (byte) 219, (byte) 194, (byte) 129, (byte) 222, (byte) 228, (byte) 240, (byte) 253, (byte) 45, (byte) 85, (byte) 143, (byte) 148, (byte) 55, (byte) 85};
    private static final byte[] ors4Bc2ZGSQp2PyHgEOAY = {(byte) 0, (byte) 183, (byte) 87, (byte) 139, (byte) 71, (byte) 143, (byte) 46, (byte) 211, (byte) 196, (byte) 56, (byte) 148, (byte) 218, (byte) 76, (byte) 147, (byte) 205, (byte) 246};
    private static final byte[] Ge9sP0SZDtZiobJOeX = {(byte) 116, (byte) 190, (byte) 48, (byte) 37, (byte) 143, (byte) 222, (byte) 161, (byte) 209, (byte) 158, (byte) 57, (byte) 49, (byte) 116, (byte) 108, (byte) 193, (byte) 63, (byte) 250, (byte) 165, (byte) 75, (byte) 137, (byte) 73, (byte) 190, (byte) 195, (byte) 112, (byte) 13, (byte) 225, (byte) 93, (byte) 43, (byte) 132, (byte) 90, (byte) 155, (byte) 178, (byte) 164};
    private static final byte[] UKFqcX8nbnmmqTk8c = {(byte) 0, (byte) 183, (byte) 87, (byte) 139, (byte) 71, (byte) 143, (byte) 46, (byte) 211, (byte) 196, (byte) 56, (byte) 148, (byte) 218, (byte) 76, (byte) 147, (byte) 205, (byte) 246};
    private static final byte[] Em2s3oDVj74bA0i9YFv = {(byte) 7, (byte) 196, (byte) 24, (byte) 138, (byte) 205, (byte) 129, (byte) 23, (byte) 209, (byte) 172, (byte) 92, (byte) 232, (byte) 205, (byte) 127, (byte) 64, (byte) 46, (byte) 24, (byte) 130, (byte) 49, (byte) 249, (byte) 215, (byte) 192, (byte) 26, (byte) 198, (byte) 192, (byte) 68, (byte) 28, (byte) 57, (byte) 189, (byte) 208, (byte) 167, (byte) 159, (byte) 252};
    private static final byte[] gZQtkXK84dSeq24rh4wf1 = {(byte) 187, (byte) 205, (byte) 191, (byte) 8, (byte) 101, (byte) 90, (byte) 251, (byte) 220, (byte) 179, (byte) 246, (byte) 123, (byte) 57, (byte) 254, (byte) 50, (byte) 50, (byte) 80, (byte) 226, (byte) 25, (byte) 251, (byte) 69, (byte) 25, (byte) 45, (byte) 81, (byte) 141, (byte) 53, (byte) 20, (byte) 118, (byte) 204, (byte) 167, (byte) 219, (byte) 24, (byte) 64, (byte) 19, (byte) 90, (byte) 73, (byte) 141, (byte) 155, (byte) 37, (byte) 150, (byte) 245, (byte) 244, (byte) 156, (byte) 254, (byte) 18, (byte) 45, (byte) 138, (byte) 112, (byte) 229};
    private static final byte[] DBPEHfoUGhqaouW7yw = {(byte) 187, (byte) 205, (byte) 191, (byte) 8, (byte) 101, (byte) 90, (byte) 251, (byte) 220, (byte) 179, (byte) 246, (byte) 123, (byte) 57, (byte) 254, (byte) 50, (byte) 50, (byte) 80, (byte) 37, (byte) 16, (byte) 211, (byte) 48, (byte) 2, (byte) 105, (byte) 8, (byte) 115, (byte) 196, (byte) 27, (byte) 92, (byte) 218, (byte) 254, (byte) 60, (byte) 208, (byte) 0};
    private static final byte[] cFOPc7WhlietqcHSq0Km = {(byte) 187, (byte) 205, (byte) 191, (byte) 8, (byte) 101, (byte) 90, (byte) 251, (byte) 220, (byte) 179, (byte) 246, (byte) 123, (byte) 57, (byte) 254, (byte) 50, (byte) 50, (byte) 80, (byte) 141, (byte) 177, (byte) 250, (byte) 199, (byte) 149, (byte) 16, (byte) 236, (byte) 14, (byte) 34, (byte) 155, (byte) 89, (byte) 69, (byte) 65, (byte) 253, (byte) 232, (byte) 163};
    private static final byte[] n9Y2QAjVRgtiUHy6qLN = {(byte) 187, (byte) 205, (byte) 191, (byte) 8, (byte) 101, (byte) 90, (byte) 251, (byte) 220, (byte) 179, (byte) 246, (byte) 123, (byte) 57, (byte) 254, (byte) 50, (byte) 50, (byte) 80, (byte) 141, (byte) 177, (byte) 250, (byte) 199, (byte) 149, (byte) 16, (byte) 236, (byte) 14, (byte) 34, (byte) 155, (byte) 89, (byte) 69, (byte) 65, (byte) 253, (byte) 232, (byte) 163};
    private static final byte[] qgGdux2oos9Jkxnqiu = {(byte) 12, (byte) 157, (byte) 206, (byte) 251, (byte) 71, (byte) 103, (byte) 68, (byte) 197, (byte) 8, (byte) 156, (byte) 88, (byte) 75, (byte) 231, (byte) 226, (byte) 177, (byte) 226};
    private static final byte[] ISjLvC8bvwG14eU6GAA = {(byte) 24, (byte) 108, (byte) 99, (byte) 254, (byte) 137, (byte) 27, (byte) 79, (byte) 150, (byte) 254, (byte) 1, (byte) 2, (byte) 47, (byte) 16, (byte) 38, (byte) 124, (byte) 159};
    private static final byte[] aD5klgq00EELP54MWS = {(byte) 33, (byte) 193, (byte) 194, (byte) 171, (byte) 183, (byte) 110, (byte) 234, (byte) 164, (byte) 96, (byte) 145, (byte) 83, (byte) 211, (byte) 76, (byte) 220, (byte) 249, (byte) 19};
    private static final byte[] Eoci6UxIdYmSQHpF3 = {(byte) 244, (byte) 59, (byte) 86, (byte) 118, (byte) 134, (byte) 104, (byte) 170, (byte) 161, (byte) 109, (byte) 176, (byte) 21, (byte) 58, (byte) 2, (byte) 128, (byte) 107, (byte) 114};
    private static final byte[] HWehyw3rMZIiknmjSmAA = {(byte) 147, (byte) 104, (byte) 17, (byte) 122, (byte) 24, (byte) 106, (byte) 95, (byte) 157, (byte) 193, (byte) 95, (byte) 214, (byte) 188, (byte) 210, (byte) 238, (byte) 186, (byte) 117, (byte) 167, (byte) 165, (byte) 169, (byte) 146, (byte) 185, (byte) 73, (byte) 52, (byte) 135, (byte) 33, (byte) 243, (byte) 204, (byte) 168, (byte) 126, (byte) 21, (byte) 162, (byte) 243};
    private static final byte[] iO3J3WpS9MO7W6QMIj3V2k = {(byte) 174, (byte) 132, (byte) 144, (byte) 172, (byte) 32, (byte) 13, (byte) 251, (byte) 204, (byte) 17, (byte) 106, (byte) 249, (byte) 101, (byte) 254, (byte) 236, (byte) 63, (byte) 34};

    public hZj37I9dZHauT(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        Bukkit.getOnlinePlayers().iterator().forEachRemaining(player -> {
            v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), player.getName(), this.v8qP8fE86HMhvNuYPFjqY.getServerName());
            if (zJnaNCVQSgEShq(player.getUniqueId())) {
                Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                    ArrayList arrayList = new ArrayList(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getOnlineMembers());
                    if (arrayList.size() == 0) {
                        this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().iZTqZaRK5UGoe0Z(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
                    }
                    arrayList.add(player.getUniqueId());
                    Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z().getClanManager().iZTqZaRK5UGoe0Z(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
                    if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                        optionalIZTqZaRK5UGoe0Z.get().setOnlineMembers(arrayList);
                    }
                }
            }
        });
    }

    public void jBUuLP0sWwaPyPOmogdX7l() {
        zJnaNCVQSgEShq().clear();
    }

    public Optional<OnlineData> v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        return zJnaNCVQSgEShq().stream().filter(onlineData -> {
            return onlineData.getPlayerUUID().equals(uuid);
        }).findAny();
    }

    public Optional<OnlineData> v8qP8fE86HMhvNuYPFjqY(String str) {
        return zJnaNCVQSgEShq().stream().filter(onlineData -> {
            return onlineData.getPlayerName().equalsIgnoreCase(str) && !this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().isInvisible(onlineData.getPlayerUUID());
        }).findAny();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str, String str2) {
        if (zJnaNCVQSgEShq().stream().filter(onlineData -> {
            return onlineData.getPlayerUUID().equals(uuid);
        }).findAny().isPresent()) {
            return false;
        }
        zJnaNCVQSgEShq().add(new OnlineData(uuid, str, str2));
        return true;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        return zJnaNCVQSgEShq().removeIf(onlineData -> {
            return onlineData.getPlayerUUID().equals(uuid);
        });
    }

    public void jBUuLP0sWwaPyPOmogdX7l(String str) {
        jBUuLP0sWwaPyPOmogdX7l();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(BVXC9ZKMMbwTeFP())) {
            JSONArray jSONArray = jSONObject.getJSONArray(eHyB7LwcLzKB4kwx());
            if (jSONObject.length() > 0) {
                int length = jSONObject.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(RLv1znMJA0LMBbDPDQoVS()) && jSONObject2.has(t1gTZ7kzoCzW6egw9()) && jSONObject2.has(FmSSsvUFssMoAVBuH())) {
                            UUID uuidFromString = UUID.fromString(jSONObject2.getString(lIn5Ma0aSM4Giu2uE1()));
                            if (b4i2FbOkaKeg91LiAe6l(uuidFromString)) {
                                v8qP8fE86HMhvNuYPFjqY(uuidFromString, jSONObject2.getString(hgPk5IABZwnf1bV()), jSONObject2.getString(kNDKUbrRMtpUojXk()));
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public void ZwrsrwOCXRUscW6Q() {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY();
    }

    public void ZwrsrwOCXRUscW6Q(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public void v8qP8fE86HMhvNuYPFjqY(PlayerData playerData) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg.zTcC5XsAfoa1Tc1.v8qP8fE86HMhvNuYPFjqY(playerData);
    }

    public void iZTqZaRK5UGoe0Z(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg.Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public Optional<UUID> xtOheRiObl4QeAl(UUID uuid) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(uuid);
        return optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() ? Optional.of(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()) : Optional.empty();
    }

    public boolean zJnaNCVQSgEShq(UUID uuid) {
        Iterator<ClanData> it = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator();
        while (it.hasNext()) {
            if (it.next().getMembers().contains(uuid)) {
                return true;
            }
        }
        return false;
    }

    public boolean ZwrsrwOCXRUscW6Q(String str) {
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(str);
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return zJnaNCVQSgEShq(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
        }
        return false;
    }

    public Optional<ClanData> iZTqZaRK5UGoe0Z(String str) {
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(str);
        return optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() ? CDW4Fj1iwdIXEOqWjiJSR(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()) : Optional.empty();
    }

    public Optional<ClanData> CDW4Fj1iwdIXEOqWjiJSR(UUID uuid) {
        for (ClanData clanData : this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values()) {
            if (clanData.getMembers().contains(uuid)) {
                return Optional.of(clanData);
            }
        }
        return Optional.empty();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player) {
        return b4i2FbOkaKeg91LiAe6l(player.getUniqueId());
    }

    public boolean b4i2FbOkaKeg91LiAe6l(UUID uuid) {
        return xtOheRiObl4QeAl().containsKey(uuid);
    }

    public boolean xtOheRiObl4QeAl(String str) {
        return xtOheRiObl4QeAl().values().stream().filter(playerData -> {
            return playerData.getName().equalsIgnoreCase(str);
        }).findAny().isPresent();
    }

    public Optional<PlayerData> p31abtwfBag2jhMH6K(UUID uuid) {
        return b4i2FbOkaKeg91LiAe6l(uuid) ? Optional.of(xtOheRiObl4QeAl().get(uuid)) : Optional.empty();
    }

    public Optional<PlayerData> zJnaNCVQSgEShq(String str) {
        Optional<PlayerData> optionalMin = xtOheRiObl4QeAl().values().stream().filter(playerData -> {
            return playerData.getName().equalsIgnoreCase(str);
        }).min(Comparator.comparingLong((v0) -> {
            return v0.getLastSeen();
        }));
        return optionalMin.isPresent() ? optionalMin : Optional.empty();
    }

    public Optional<PlayerData> CDW4Fj1iwdIXEOqWjiJSR(String str) {
        Optional<PlayerData> optionalMax = xtOheRiObl4QeAl().values().stream().filter(playerData -> {
            return playerData.getName().equalsIgnoreCase(str);
        }).max(Comparator.comparingLong((v0) -> {
            return v0.getLastSeen();
        }));
        return optionalMax.isPresent() ? optionalMax : Optional.empty();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(uuid);
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = CDW4Fj1iwdIXEOqWjiJSR(uuid2);
        return optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId().equals(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId());
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, UUID uuid2) {
        hZj37I9dZHauT playerManager = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager();
        boolean zIZTqZaRK5UGoe0Z = playerManager.iZTqZaRK5UGoe0Z(uuid, uuid2);
        boolean zZwrsrwOCXRUscW6Q = playerManager.ZwrsrwOCXRUscW6Q(uuid, uuid2);
        Player player = Bukkit.getPlayer(uuid);
        Player player2 = Bukkit.getPlayer(uuid2);
        if (player == null || player2 == null) {
            return false;
        }
        return playerManager.jBUuLP0sWwaPyPOmogdX7l(player, player2) || ((zIZTqZaRK5UGoe0Z || zZwrsrwOCXRUscW6Q) && !playerManager.jBUuLP0sWwaPyPOmogdX7l(player2));
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, Player player2) {
        hZj37I9dZHauT playerManager = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager();
        boolean zIZTqZaRK5UGoe0Z = playerManager.iZTqZaRK5UGoe0Z(player.getUniqueId(), player2.getUniqueId());
        boolean zZwrsrwOCXRUscW6Q = playerManager.ZwrsrwOCXRUscW6Q(player.getUniqueId(), player2.getUniqueId());
        if (player == null || player2 == null) {
            return false;
        }
        return playerManager.jBUuLP0sWwaPyPOmogdX7l(player, player2) || ((zIZTqZaRK5UGoe0Z || zZwrsrwOCXRUscW6Q) && !playerManager.jBUuLP0sWwaPyPOmogdX7l(player2));
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(uuid);
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = CDW4Fj1iwdIXEOqWjiJSR(uuid2);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() || !optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
            return false;
        }
        Optional<EventImplement> optionalV3DAV3orG0so43Del8NdO = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().V3DAV3orG0so43Del8NdO();
        if (optionalV3DAV3orG0so43Del8NdO.isPresent()) {
            return optionalV3DAV3orG0so43Del8NdO.get().playerInEvent(uuid) || optionalV3DAV3orG0so43Del8NdO.get().playerInEvent(uuid2);
        }
        return false;
    }

    public boolean iZTqZaRK5UGoe0Z(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(uuid);
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = CDW4Fj1iwdIXEOqWjiJSR(uuid2);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() || !optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
            if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(qUyPtTW98KU91BDzi4()) || this.v8qP8fE86HMhvNuYPFjqY.getClanManager().b4i2FbOkaKeg91LiAe6l()) {
                return this.v8qP8fE86HMhvNuYPFjqY.getClanManager().b4i2FbOkaKeg91LiAe6l() ? true : true;
            }
            return false;
        }
        if (v8qP8fE86HMhvNuYPFjqY(uuid, uuid2)) {
            return optionalCDW4Fj1iwdIXEOqWjiJSR.get().isFf();
        }
        Optional<RivalAllyModuleAPI> optionalV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().v8qP8fE86HMhvNuYPFjqY();
        if (!optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            return true;
        }
        if (optionalV8qP8fE86HMhvNuYPFjqY.get().isClanAlly(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            return optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllyPvp() && optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getSettings().isAllyPvp();
        }
        return optionalV8qP8fE86HMhvNuYPFjqY.get().isClanRival(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId()) ? true : true;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(Player player, Player player2) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(MP1mlcp9LcGsHRCSK19W()).size() > 0 && this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(vrYy6zN9sEG5eIy()).contains(player2.getWorld().getName())) {
            return true;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(CTU8Vj15SSNrdrGZLgoreS()).size() > 0) {
            Optional<RegionImplement> optionalHX3ZfRb1nSpNq57s7x5ui = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
            if (optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui.get().playerHasRegionList(player2, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(ZHevheznb5ZpJ95lT0()))) {
                return true;
            }
        }
        try {
            List stringList = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(l7Z29F2urhiBTtjJEee());
            if (stringList.size() > 0) {
                Iterator it = stringList.iterator();
                while (it.hasNext()) {
                    Optional<ClaimImplement> optionalHX3ZfRb1nSpNq57s7x5ui2 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui((String) it.next());
                    if (optionalHX3ZfRb1nSpNq57s7x5ui2.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui2.get().hasClaimLocation(player.getLocation())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(Player player) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(U0P1L0SD2cwu8rqo04WjQZ()).size() > 0 && this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(cj2kWinwUmmL02()).contains(player.getWorld().getName())) {
            return true;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(T189ow2WJ3KWmxXAEWsQBt()).size() <= 0) {
            return false;
        }
        Optional<RegionImplement> optionalHX3ZfRb1nSpNq57s7x5ui = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
        return optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui.get().playerHasRegionList(player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(TUerHFw6bNU0p9oBuiB()));
    }

    public boolean ZwrsrwOCXRUscW6Q(Player player, Player player2) {
        try {
            List stringList = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(FulzACWz64vmOy85IBMHNy());
            if (stringList.size() > 0) {
                Iterator it = stringList.iterator();
                while (it.hasNext()) {
                    Optional<ClaimImplement> optionalHX3ZfRb1nSpNq57s7x5ui = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui((String) it.next());
                    if (optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui.get().hasClaimLocation(player.getLocation())) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return jBUuLP0sWwaPyPOmogdX7l(player, player2);
    }

    public boolean ZwrsrwOCXRUscW6Q(Player player) {
        return Un3NRLL6aWivTcbodkcK(player.getUniqueId());
    }

    public boolean Un3NRLL6aWivTcbodkcK(UUID uuid) {
        if (!b4i2FbOkaKeg91LiAe6l(uuid)) {
            return false;
        }
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (optionalP31abtwfBag2jhMH6K.isPresent()) {
            return optionalP31abtwfBag2jhMH6K.get().isLockedChat();
        }
        return false;
    }

    public boolean iZTqZaRK5UGoe0Z(Player player) {
        return lGGwXL678c4Kv7skJb5NiE(player.getUniqueId());
    }

    public boolean lGGwXL678c4Kv7skJb5NiE(UUID uuid) {
        if (!b4i2FbOkaKeg91LiAe6l(uuid)) {
            return false;
        }
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return true;
        }
        optionalP31abtwfBag2jhMH6K.get().setLockedChat(!optionalP31abtwfBag2jhMH6K.get().isLockedChat());
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        return true;
    }

    public boolean xtOheRiObl4QeAl(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z().getClanManager().iZTqZaRK5UGoe0Z(uuid);
        return optionalIZTqZaRK5UGoe0Z.isPresent() && iZTqZaRK5UGoe0Z().getPlayerManager().p31abtwfBag2jhMH6K(uuid2).isPresent() && optionalIZTqZaRK5UGoe0Z.get().getMembers().contains(uuid2);
    }

    public boolean zJnaNCVQSgEShq(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z().getClanManager().iZTqZaRK5UGoe0Z(uuid);
        return optionalIZTqZaRK5UGoe0Z.isPresent() && optionalIZTqZaRK5UGoe0Z.get().getBanned().contains(uuid2);
    }

    public boolean xtOheRiObl4QeAl(Player player) {
        return o1VU1x4DAlrEtGKZ3jAdhE(player.getUniqueId());
    }

    public boolean o1VU1x4DAlrEtGKZ3jAdhE(UUID uuid) {
        return v8qP8fE86HMhvNuYPFjqY(uuid, ClanEnum.PlayerLeaveReaction.LEAVE);
    }

    public void CDW4Fj1iwdIXEOqWjiJSR(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent() && optionalIZTqZaRK5UGoe0Z.get().getMembers().contains(uuid2)) {
            ArrayList arrayList = new ArrayList(optionalIZTqZaRK5UGoe0Z.get().getMembers());
            arrayList.remove(uuid2);
            optionalIZTqZaRK5UGoe0Z.get().setMembers(arrayList);
            this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, ClanEnum.PlayerLeaveReaction playerLeaveReaction) {
        return v8qP8fE86HMhvNuYPFjqY(uuid, playerLeaveReaction, Optional.empty());
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, ClanEnum.PlayerLeaveReaction playerLeaveReaction, Optional<String> optional) {
        return v8qP8fE86HMhvNuYPFjqY(uuid, playerLeaveReaction, Optional.empty(), optional);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, ClanEnum.PlayerLeaveReaction playerLeaveReaction, Optional<UUID> optional, Optional<String> optional2) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(uuid);
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() || !optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        if (!xtOheRiObl4QeAl(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), uuid)) {
            CDW4Fj1iwdIXEOqWjiJSR(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), uuid);
            return true;
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid);
        Optional<ModerationData> optionalZwrsrwOCXRUscW6Q = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().ZwrsrwOCXRUscW6Q();
        if (!p31abtwfBag2jhMH6K(optionalP31abtwfBag2jhMH6K.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            return false;
        }
        if (playerLeaveReaction.equals(ClanEnum.PlayerLeaveReaction.KICK)) {
            optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().setMemberKicked(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().getMemberKicked() + 1);
        }
        optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().setMemberLeft(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().getMemberLeft() + 1);
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers().contains(uuid)) {
            ArrayList arrayList = new ArrayList(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers());
            arrayList.remove(uuid);
            optionalCDW4Fj1iwdIXEOqWjiJSR.get().setMembers(arrayList);
        }
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getOnlineMembers().contains(uuid)) {
            ArrayList arrayList2 = new ArrayList(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getOnlineMembers());
            arrayList2.remove(uuid);
            optionalCDW4Fj1iwdIXEOqWjiJSR.get().setOnlineMembers(arrayList2);
        }
        int kills = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().getKills() - optionalP31abtwfBag2jhMH6K.get().getKills();
        if (kills < 0) {
            kills = 0;
        }
        optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().setKills(kills);
        int deaths = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().getDeaths() - optionalP31abtwfBag2jhMH6K.get().getDeaths();
        if (deaths < 0) {
            deaths = 0;
        }
        optionalCDW4Fj1iwdIXEOqWjiJSR.get().getStats().setDeaths(deaths);
        this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get());
        if (optionalB4i2FbOkaKeg91LiAe6l.isPresent() && optionalZwrsrwOCXRUscW6Q.isPresent() && optionalB4i2FbOkaKeg91LiAe6l.get().getPriority() > this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().ZwrsrwOCXRUscW6Q().get().getPriority()) {
            Optional<LevelupModuleAPI> optionalZwrsrwOCXRUscW6Q2 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().ZwrsrwOCXRUscW6Q();
            if (optionalZwrsrwOCXRUscW6Q2.isPresent()) {
                optionalZwrsrwOCXRUscW6Q2.get().check_actions(ClanEnum.ClanActions.DEMOTEMEMBER, optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
            }
        }
        new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions.LEAVE, Arrays.asList("%player%;" + optionalP31abtwfBag2jhMH6K.get().getName(), "%clantag%;" + optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTagNoColor()), optionalP31abtwfBag2jhMH6K.get().getId());
        if (playerLeaveReaction.equals(ClanEnum.PlayerLeaveReaction.KICK)) {
            Bukkit.getPluginManager().callEvent(new ClanPlayerKickedEvent(uuid, optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optional, optional2));
            return true;
        }
        if (!playerLeaveReaction.equals(ClanEnum.PlayerLeaveReaction.LEAVE)) {
            return true;
        }
        Bukkit.getPluginManager().callEvent(new ClanPlayerLeaveEvent(uuid, optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), playerLeaveReaction, uuid));
        return true;
    }

    public boolean b4i2FbOkaKeg91LiAe6l(UUID uuid, UUID uuid2) {
        if (xtOheRiObl4QeAl(uuid2, uuid) || zJnaNCVQSgEShq(uuid)) {
            return false;
        }
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z().getClanManager().iZTqZaRK5UGoe0Z(uuid2);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        Nz8xKv4RePC2a0f0iuYU(uuid);
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent() || !v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get().getId(), optionalIZTqZaRK5UGoe0Z.get().getId(), this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().ZwrsrwOCXRUscW6Q())) {
            return false;
        }
        ArrayList arrayList = new ArrayList(optionalIZTqZaRK5UGoe0Z.get().getMembers());
        arrayList.add(uuid);
        optionalIZTqZaRK5UGoe0Z.get().setMembers(arrayList);
        ArrayList arrayList2 = new ArrayList(optionalIZTqZaRK5UGoe0Z.get().getOnlineMembers());
        arrayList2.add(uuid);
        optionalIZTqZaRK5UGoe0Z.get().setOnlineMembers(arrayList2);
        optionalIZTqZaRK5UGoe0Z.get().getStats().setKills(optionalIZTqZaRK5UGoe0Z.get().getStats().getKills() + optionalP31abtwfBag2jhMH6K.get().getKills());
        optionalIZTqZaRK5UGoe0Z.get().getStats().setDeaths(optionalIZTqZaRK5UGoe0Z.get().getStats().getDeaths() + optionalP31abtwfBag2jhMH6K.get().getDeaths());
        optionalIZTqZaRK5UGoe0Z.get().getStats().setMemberJoined(optionalIZTqZaRK5UGoe0Z.get().getStats().getMemberJoined() + 1);
        iZTqZaRK5UGoe0Z().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions.JOIN, Arrays.asList("%player%;" + optionalP31abtwfBag2jhMH6K.get().getName(), "%clantag%;" + optionalIZTqZaRK5UGoe0Z.get().getTagNoColor()), optionalP31abtwfBag2jhMH6K.get().getId());
        Bukkit.getPluginManager().callEvent(new ClanPlayerJoinEvent(uuid, optionalIZTqZaRK5UGoe0Z.get().getId()));
        this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2, Optional<ModerationData> optional) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        if (optional.isPresent()) {
            optionalP31abtwfBag2jhMH6K.get().setRole(optional.get().getId());
        }
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        return true;
    }

    public boolean p31abtwfBag2jhMH6K(UUID uuid, UUID uuid2) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        optionalP31abtwfBag2jhMH6K.get().setRole(null);
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, UUID uuid) {
        return b4i2FbOkaKeg91LiAe6l(player.getUniqueId(), uuid);
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(Player player, UUID uuid) {
        return Un3NRLL6aWivTcbodkcK(player.getUniqueId(), uuid);
    }

    public boolean Un3NRLL6aWivTcbodkcK(UUID uuid, UUID uuid2) {
        return b4i2FbOkaKeg91LiAe6l(uuid, uuid2);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;
        if (this.v8qP8fE86HMhvNuYPFjqY.getClanManager().p31abtwfBag2jhMH6K().contains(player.getUniqueId())) {
            this.v8qP8fE86HMhvNuYPFjqY.getClanManager().p31abtwfBag2jhMH6K().remove(player.getUniqueId());
            return false;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getClanManager().p31abtwfBag2jhMH6K().add(player.getUniqueId());
        return true;
    }

    public boolean vVo2VUvxrriklPdRxI(UUID uuid) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(uuid);
        return optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader().equals(uuid);
    }

    public boolean lGGwXL678c4Kv7skJb5NiE(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(uuid2);
        return optionalIZTqZaRK5UGoe0Z.isPresent() && optionalIZTqZaRK5UGoe0Z.get().getLeader().equals(uuid);
    }

    public double Fc3p9FhCjSD1k5Ra4(UUID uuid) {
        double dV8qP8fE86HMhvNuYPFjqY = 0.0d;
        try {
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                dV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get().getKills(), optionalP31abtwfBag2jhMH6K.get().getDeaths());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dV8qP8fE86HMhvNuYPFjqY;
    }

    public Optional<PlayerData> Nz8xKv4RePC2a0f0iuYU(UUID uuid) {
        Player player = null;
        try {
            player = Bukkit.getPlayer(uuid);
        } catch (Exception e) {
        }
        return player != null ? zJnaNCVQSgEShq(player) : Optional.empty();
    }

    public Optional<PlayerData> v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str) {
        if (b4i2FbOkaKeg91LiAe6l(uuid)) {
            return p31abtwfBag2jhMH6K(uuid);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        PlayerData playerData = new PlayerData(uuid, str, uuid, 0, 0, 0, 0.0d, jCurrentTimeMillis, jCurrentTimeMillis, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(ZWqrfTqc2zfxTbT8UF()), "", "", new PlayerData_Settings(true), this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().ZwrsrwOCXRUscW6Q().get().getId(), jCurrentTimeMillis, false, this.v8qP8fE86HMhvNuYPFjqY.getLanguage());
        xtOheRiObl4QeAl().put(uuid, playerData);
        v8qP8fE86HMhvNuYPFjqY(playerData);
        HX3ZfRb1nSpNq57s7x5ui(uuid);
        return Optional.of(playerData);
    }

    public Optional<PlayerData> zJnaNCVQSgEShq(Player player) {
        if (v8qP8fE86HMhvNuYPFjqY(player)) {
            return p31abtwfBag2jhMH6K(player.getUniqueId());
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(rklVy27A4tLjUz());
        PlayerData playerData = new PlayerData(player.getUniqueId(), player.getName(), player.getUniqueId(), 0, 0, 0, 0.0d, jCurrentTimeMillis, jCurrentTimeMillis, string, "", "", new PlayerData_Settings(true), this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().ZwrsrwOCXRUscW6Q().get().getId(), jCurrentTimeMillis, false, this.v8qP8fE86HMhvNuYPFjqY.getLanguage());
        xtOheRiObl4QeAl().put(player.getUniqueId(), playerData);
        v8qP8fE86HMhvNuYPFjqY(playerData);
        HX3ZfRb1nSpNq57s7x5ui(player.getUniqueId());
        return Optional.of(playerData);
    }

    public void HX3ZfRb1nSpNq57s7x5ui(UUID uuid) {
        if (b4i2FbOkaKeg91LiAe6l(uuid)) {
            new UpdatePlayerSkinCache(this.v8qP8fE86HMhvNuYPFjqY, uuid);
        }
    }

    public boolean IO1OGSMpoP1ZjOsbXi3a(UUID uuid) {
        if (!b4i2FbOkaKeg91LiAe6l(uuid)) {
            return false;
        }
        xtOheRiObl4QeAl().remove(uuid);
        iZTqZaRK5UGoe0Z(uuid);
        return false;
    }

    public boolean VkPRYe34Awk6AdSxoUC(UUID uuid) {
        return p31abtwfBag2jhMH6K(uuid, null);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, Optional<ModerationData> optional) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent() || !optional.isPresent()) {
            return false;
        }
        optionalP31abtwfBag2jhMH6K.get().setRole(optional.get().getId());
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(PlayerData playerData, UUID uuid, Optional<ModerationData> optional) {
        return v8qP8fE86HMhvNuYPFjqY(playerData.getId(), uuid, optional);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(PlayerData playerData, UUID uuid) {
        return p31abtwfBag2jhMH6K(playerData.getId(), uuid);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(PlayerData playerData, Optional<ModerationData> optional) {
        return v8qP8fE86HMhvNuYPFjqY(playerData.getId(), optional);
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, String str) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        optionalP31abtwfBag2jhMH6K.get().setNickname(str);
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        return true;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, Optional<String> optional) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        if (optional.isPresent()) {
            optionalP31abtwfBag2jhMH6K.get().setLang(optional.get());
        } else {
            optionalP31abtwfBag2jhMH6K.get().setLang(this.v8qP8fE86HMhvNuYPFjqY.getLanguage());
        }
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, ClanEnum.PlayerSettingsType playerSettingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept) {
        try {
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
            if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
                return false;
            }
            boolean zIsInvitations = false;
            switch (R505XUxJkyuf5.v8qP8fE86HMhvNuYPFjqY[playerSettingsType.ordinal()]) {
                case 1:
                    boolean z = true;
                    if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                        z = !optionalP31abtwfBag2jhMH6K.get().getSettings().isInvitations();
                    } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                        z = true;
                    } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                        z = false;
                    }
                    optionalP31abtwfBag2jhMH6K.get().getSettings().setInvitations(z);
                    v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
                    zIsInvitations = optionalP31abtwfBag2jhMH6K.get().getSettings().isInvitations();
                default:
                    return zIsInvitations;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean QXoNfOxIPaPrSlQMNR(UUID uuid) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        optionalP31abtwfBag2jhMH6K.get().setKills(0);
        optionalP31abtwfBag2jhMH6K.get().setDeaths(0);
        optionalP31abtwfBag2jhMH6K.get().setKdr(0.0d);
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        Bukkit.getPluginManager().callEvent(new ClanPlayerKDRChangeEvent(uuid, ClanEnum.KdrChangeType.RESET, 0.0d, 0, 0));
        return true;
    }

    public boolean V3DAV3orG0so43Del8NdO(UUID uuid) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        optionalP31abtwfBag2jhMH6K.get().setSouls(0);
        v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
        Bukkit.getPluginManager().callEvent(new ClanPlayerSoulsChangeEvent(uuid, ClanEnum.SoulsChangeType.RESET, 0));
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, String str) {
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, qeums5UE29sLizPQ0ls6y(), Gr2nxY6sjQC2Y6GJ(), true)) {
            return false;
        }
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).Un3NRLL6aWivTcbodkcK(str)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        if (str.length() > iZTqZaRK5UGoe0Z().getFiles().p31abtwfBag2jhMH6K().getInt(KsQf49gSwEJzmFnwoGffrV())) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_LENGTH, Arrays.asList(bWeNuVB13x86R9p(), "%max%;" + iZTqZaRK5UGoe0Z().getFiles().p31abtwfBag2jhMH6K().getInt(w2W99w6cH5YljRr2aCTViz()))));
            return false;
        }
        if (new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(eWXe7aGDbLAXe8X()).getValue()), true)) {
            return jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str);
        }
        return false;
    }

    public void iZTqZaRK5UGoe0Z(Player player, Player player2) {
        if (player != null) {
            Optional.empty();
            int i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(FUtdkZ4er85TRleXVS08p());
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(player.getUniqueId());
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                int souls = 0;
                if (i > 0) {
                    souls = optionalP31abtwfBag2jhMH6K.get().getSouls() + i;
                } else if (i < 0) {
                    souls = optionalP31abtwfBag2jhMH6K.get().getSouls() + i;
                    if (souls < 0) {
                        souls = 0;
                    }
                }
                optionalP31abtwfBag2jhMH6K.get().setSouls(souls);
                Bukkit.getPluginManager().callEvent(new ClanPlayerSoulsChangeEvent(optionalP31abtwfBag2jhMH6K.get().getId(), ClanEnum.SoulsChangeType.DEATH, souls));
                v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
            }
        }
        if (player2 != null) {
            Optional.empty();
            int i2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(vqRuv6woKSE8GXWCHnvgT());
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = p31abtwfBag2jhMH6K(player2.getUniqueId());
            if (optionalP31abtwfBag2jhMH6K2.isPresent()) {
                int souls2 = 0;
                if (i2 > 0) {
                    souls2 = optionalP31abtwfBag2jhMH6K2.get().getSouls() + i2;
                } else if (i2 < 0) {
                    souls2 = optionalP31abtwfBag2jhMH6K2.get().getSouls() + i2;
                    if (souls2 < 0) {
                        souls2 = 0;
                    }
                }
                optionalP31abtwfBag2jhMH6K2.get().setSouls(souls2);
                Bukkit.getPluginManager().callEvent(new ClanPlayerSoulsChangeEvent(optionalP31abtwfBag2jhMH6K2.get().getId(), ClanEnum.SoulsChangeType.DEATH, souls2));
                v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K2.get());
            }
        }
    }

    public void xtOheRiObl4QeAl(Player player, Player player2) {
        Optional<ClanData> optionalEmpty = Optional.empty();
        Optional<ClanData> optionalEmpty2 = Optional.empty();
        int i = 0;
        if (player != null) {
            if (zJnaNCVQSgEShq(player.getUniqueId()) && zJnaNCVQSgEShq(player2.getUniqueId())) {
                optionalEmpty = CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                optionalEmpty2 = CDW4Fj1iwdIXEOqWjiJSR(player2.getUniqueId());
                i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(KiUmWb5HANCQVSil());
                if (optionalEmpty.isPresent() && optionalEmpty2.isPresent()) {
                    if (optionalEmpty.get().getRivalAlly().getRival().contains(optionalEmpty2.get().getId())) {
                        i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(hxrEzzbdUfNlMSWy());
                    } else if (optionalEmpty.get().getRivalAlly().getAlly().contains(optionalEmpty2.get().getId())) {
                        i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(U706Ti32N8nEDoVdzM());
                    }
                }
            } else if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(bLUc4IwRnoDlrkVY())) {
                i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(CxpAL04KFjQF5Dbwg());
            }
        } else if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(QvJpFd8vbf7qWWQAdDxUGC())) {
            i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(Xf2XcwTbrAp6ruRhI());
        }
        if (player != null && i > 0) {
            if (v8qP8fE86HMhvNuYPFjqY(player)) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = p31abtwfBag2jhMH6K(player.getUniqueId());
                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                    optionalP31abtwfBag2jhMH6K.get().setKills(optionalP31abtwfBag2jhMH6K.get().getKills() + i);
                    if (optionalEmpty.isPresent()) {
                        Bukkit.getPluginManager().callEvent(new ClanPlayerKDRChangeEvent(player.getUniqueId(), ClanEnum.KdrChangeType.KILL, optionalP31abtwfBag2jhMH6K.get().getKdr(), optionalP31abtwfBag2jhMH6K.get().getKills(), optionalP31abtwfBag2jhMH6K.get().getDeaths()));
                    }
                    v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
                }
            }
            this.v8qP8fE86HMhvNuYPFjqY.getBossBarManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId());
        }
        if (player2 == null || i <= 0) {
            return;
        }
        if (v8qP8fE86HMhvNuYPFjqY(player2)) {
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = p31abtwfBag2jhMH6K(player2.getUniqueId());
            if (optionalP31abtwfBag2jhMH6K2.isPresent()) {
                optionalP31abtwfBag2jhMH6K2.get().setDeaths(optionalP31abtwfBag2jhMH6K2.get().getDeaths() + i);
                if (optionalEmpty2.isPresent()) {
                    Bukkit.getPluginManager().callEvent(new ClanPlayerKDRChangeEvent(player2.getUniqueId(), ClanEnum.KdrChangeType.DEATH, optionalP31abtwfBag2jhMH6K2.get().getKdr(), optionalP31abtwfBag2jhMH6K2.get().getKills(), optionalP31abtwfBag2jhMH6K2.get().getDeaths()));
                }
                v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K2.get());
            }
        }
        this.v8qP8fE86HMhvNuYPFjqY.getBossBarManager().jBUuLP0sWwaPyPOmogdX7l(player2.getUniqueId());
    }

    public void v8qP8fE86HMhvNuYPFjqY(Player player, Player player2, double d) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(Hi6fGHlxLe42WtwQmpAa()) && !CooldownAPI.isInCooldown(player2.getUniqueId(), PkWYiLs6mYbCX9())) {
            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player2, () -> {
                if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(jljyl7UfT578ZLIy()) > 0) {
                    new CooldownAPI(player2.getUniqueId(), i99bIh2UYI1MNtZ(), this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(hYz4G7IKJ8o7ZwhNtidksG())).start();
                }
                if (this.v8qP8fE86HMhvNuYPFjqY.isEntity()) {
                    Location locationClone = player2.getLocation().clone();
                    locationClone.add(0.1d, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getDouble(Lgy8OYsdCPx3NZ0a4()), 0.1d);
                    Optional<SpawnedEntityData> optionalV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getEntityManager().v8qP8fE86HMhvNuYPFjqY(player, locationClone, EntityTypes.ARMOR_STAND, new EntityOptionsData(true, false, true, false, false, false), new ArrayList(), Arrays.asList(player, player2));
                    if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                        ArrayList arrayList = new ArrayList();
                        this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(QieMW2dieeemvf()).iterator().forEachRemaining(str -> {
                            arrayList.add(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player2.getUniqueId(), str.replace(ytnIJotlKZhdBzd5ahnYyU(), String.valueOf(d)).replace(URGEG8J5WbgLvfUMaEe(), String.valueOf(player.getName())).replace(p3bVsgGqCNYY0nK(), String.valueOf(player2.getName()))));
                        });
                        if (arrayList.size() > 0) {
                            this.v8qP8fE86HMhvNuYPFjqY.getEntityManager().v8qP8fE86HMhvNuYPFjqY(optionalV8qP8fE86HMhvNuYPFjqY.get().getId(), Optional.of((String) arrayList.get(0)));
                            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
                                this.v8qP8fE86HMhvNuYPFjqY.getEntityManager().v8qP8fE86HMhvNuYPFjqY(((SpawnedEntityData) optionalV8qP8fE86HMhvNuYPFjqY.get()).getId());
                            }, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(zc84XzhBvabdUhs4()));
                        }
                    }
                }
                Optional<HologramImplement> optionalQXoNfOxIPaPrSlQMNR = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().QXoNfOxIPaPrSlQMNR();
                if (optionalQXoNfOxIPaPrSlQMNR.isPresent()) {
                    optionalQXoNfOxIPaPrSlQMNR.get().deleteHolo(player2.getUniqueId().toString());
                    Location locationClone2 = player2.getLocation().clone();
                    locationClone2.add(0.1d, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getDouble(IN6Veln4MC43Mp3NC()), 0.1d);
                    ArrayList arrayList2 = new ArrayList();
                    this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(imzklUqiPVHiEF9MLXz()).iterator().forEachRemaining(str2 -> {
                        arrayList2.add(this.v8qP8fE86HMhvNuYPFjqY.getColorManager().iZTqZaRK5UGoe0Z(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player2.getUniqueId(), str2.replace(NnUZwmQ8PC3V0TtYdG3F(), String.valueOf(d)).replace(Ag6oK8CD7zBsj2(), String.valueOf(player.getName())).replace(j9zwpbM9pcWJawaeZu4SvX(), String.valueOf(player2.getName())))));
                    });
                    optionalQXoNfOxIPaPrSlQMNR.get().createHologramTimed(Long.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(Vah37XPZ4Zlj2U4())), player2.getUniqueId().toString(), locationClone2, arrayList2, new Object[0]);
                }
            }, 1L);
        }
    }

    public Clans iZTqZaRK5UGoe0Z() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public ConcurrentHashMap<UUID, PlayerData> xtOheRiObl4QeAl() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public List<OnlineData> zJnaNCVQSgEShq() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public void v8qP8fE86HMhvNuYPFjqY(List<OnlineData> list) {
        this.ZwrsrwOCXRUscW6Q = list;
    }

    private static String BVXC9ZKMMbwTeFP() {
        return "players";
    }

    private static String eHyB7LwcLzKB4kwx() {
        return "players";
    }

    private static String RLv1znMJA0LMBbDPDQoVS() {
        return "uuid";
    }

    private static String t1gTZ7kzoCzW6egw9() {
        return "name";
    }

    private static String FmSSsvUFssMoAVBuH() {
        return "server";
    }

    private static String lIn5Ma0aSM4Giu2uE1() {
        return "uuid";
    }

    private static String hgPk5IABZwnf1bV() {
        return "name";
    }

    private static String kNDKUbrRMtpUojXk() {
        return "server";
    }

    private static String qUyPtTW98KU91BDzi4() {
        return "Config.player.ff.disable_noclan_pvp";
    }

    private static String MP1mlcp9LcGsHRCSK19W() {
        return "Config.player.ff.forced_worlds";
    }

    private static String vrYy6zN9sEG5eIy() {
        return "Config.player.ff.forced_worlds";
    }

    private static String CTU8Vj15SSNrdrGZLgoreS() {
        return "Config.player.ff.forced_regions";
    }

    private static String ZHevheznb5ZpJ95lT0() {
        return "Config.player.ff.forced_regions";
    }

    private static String l7Z29F2urhiBTtjJEee() {
        return "Config.player.ff.forced_ff_terrain";
    }

    private static String U0P1L0SD2cwu8rqo04WjQZ() {
        return "Config.player.ff.disabled_worlds";
    }

    private static String cj2kWinwUmmL02() {
        return "Config.player.ff.disabled_worlds";
    }

    private static String T189ow2WJ3KWmxXAEWsQBt() {
        return "Config.player.ff.disabled_regions";
    }

    private static String TUerHFw6bNU0p9oBuiB() {
        return "Config.player.ff.disabled_regions";
    }

    private static String FulzACWz64vmOy85IBMHNy() {
        return "Config.player.ff.disabled_ff_terrain";
    }

    private static String ZWqrfTqc2zfxTbT8UF() {
        return "Config.player.skin.on_empty";
    }

    private static String rklVy27A4tLjUz() {
        return "Config.player.skin.on_empty";
    }

    private static String qeums5UE29sLizPQ0ls6y() {
        return "nickname";
    }

    private static String Gr2nxY6sjQC2Y6GJ() {
        return "clan";
    }

    private static String KsQf49gSwEJzmFnwoGffrV() {
        return "Config.player.nickname.max_size";
    }

    private static String bWeNuVB13x86R9p() {
        return "%min%;1";
    }

    private static String w2W99w6cH5YljRr2aCTViz() {
        return "Config.player.nickname.max_size";
    }

    private static String eWXe7aGDbLAXe8X() {
        return "nickname";
    }

    private static String FUtdkZ4er85TRleXVS08p() {
        return "Config.player.souls.kill";
    }

    private static String vqRuv6woKSE8GXWCHnvgT() {
        return "Config.player.souls.death";
    }

    private static String KiUmWb5HANCQVSil() {
        return "Config.player.kdr.kills.neutral";
    }

    private static String hxrEzzbdUfNlMSWy() {
        return "Config.player.kdr.kills.rival";
    }

    private static String U706Ti32N8nEDoVdzM() {
        return "Config.player.kdr.kills.ally";
    }

    private static String bLUc4IwRnoDlrkVY() {
        return "Config.player.kdr.noclan_count";
    }

    private static String CxpAL04KFjQF5Dbwg() {
        return "Config.player.kdr.kills.noclan";
    }

    private static String QvJpFd8vbf7qWWQAdDxUGC() {
        return "Config.player.kdr.nopvp_count";
    }

    private static String Xf2XcwTbrAp6ruRhI() {
        return "Config.player.kdr.kills.nopvp";
    }

    private static String Hi6fGHlxLe42WtwQmpAa() {
        return "Config.player.pvp.damage_indicator.enabled";
    }

    private static String PkWYiLs6mYbCX9() {
        return "damage_indicator";
    }

    private static String jljyl7UfT578ZLIy() {
        return "Config.player.pvp.damage_indicator.delay";
    }

    private static String i99bIh2UYI1MNtZ() {
        return "damage_indicator";
    }

    private static String hYz4G7IKJ8o7ZwhNtidksG() {
        return "Config.player.pvp.damage_indicator.delay";
    }

    private static String Lgy8OYsdCPx3NZ0a4() {
        return "Config.player.pvp.damage_indicator.ajust_y";
    }

    private static String QieMW2dieeemvf() {
        return "Config.player.pvp.damage_indicator.format";
    }

    private static String zc84XzhBvabdUhs4() {
        return "Config.player.pvp.damage_indicator.timer";
    }

    private static String IN6Veln4MC43Mp3NC() {
        return "Config.player.pvp.damage_indicator.ajust_y";
    }

    private static String imzklUqiPVHiEF9MLXz() {
        return "Config.player.pvp.damage_indicator.format";
    }

    private static String Vah37XPZ4Zlj2U4() {
        return "Config.player.pvp.damage_indicator.timer";
    }

    private static String NnUZwmQ8PC3V0TtYdG3F() {
        return "{damage}";
    }

    private static String Ag6oK8CD7zBsj2() {
        return "{attacker}";
    }

    private static String j9zwpbM9pcWJawaeZu4SvX() {
        return "{victim}";
    }

    private static String ytnIJotlKZhdBzd5ahnYyU() {
        return "{damage}";
    }

    private static String URGEG8J5WbgLvfUMaEe() {
        return "{attacker}";
    }

    private static String p3bVsgGqCNYY0nK() {
        return "{victim}";
    }
}
