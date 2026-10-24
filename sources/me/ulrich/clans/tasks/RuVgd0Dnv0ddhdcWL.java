package me.ulrich.clans.tasks;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.InviteData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL implements Runnable {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static final byte[] QdFEuGk2lLZl5TIompn = {(byte) 56, (byte) 90, (byte) 245, (byte) 128, (byte) 16, (byte) 179, (byte) 230, (byte) 72, (byte) 3, (byte) 185, (byte) 97, (byte) 59, (byte) 205, (byte) 66, (byte) 230, (byte) 238, (byte) 13, (byte) 174, (byte) 241, (byte) 23, (byte) 236, (byte) 100, (byte) 209, (byte) 212, (byte) 33, (byte) 5, (byte) 101, (byte) 3, (byte) 230, (byte) 5, (byte) 119, (byte) 100, (byte) 149, (byte) 53, (byte) 128, (byte) 233, (byte) 147, (byte) 35, (byte) 146, (byte) 67, (byte) 238, (byte) 115, (byte) 179, (byte) 42, (byte) 220, (byte) 119, (byte) 150, (byte) 87};
    private static String vLb3mYallV9sVQt;

    public RuVgd0Dnv0ddhdcWL(Clans clans) {
        v8qP8fE86HMhvNuYPFjqY(clans);
    }

    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<Map.Entry<UUID, List<InviteData>>> it = this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().ZwrsrwOCXRUscW6Q().entrySet().iterator();
        while (it.hasNext()) {
            Iterator<InviteData> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                InviteData next = it2.next();
                if (jCurrentTimeMillis > next.getDate() + ((long) (60 * this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(PQQoKFS0JmXFYeQS1s58Bc())))) {
                    it2.remove();
                    this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(next.getId());
                }
            }
        }
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public void v8qP8fE86HMhvNuYPFjqY(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    private static String JvUAZDJArlORSLE(byte[] bArr) {
        return "";
    }

    private static String PQQoKFS0JmXFYeQS1s58Bc() {
        return "Config.player.invites.time_expires";
    }
}
