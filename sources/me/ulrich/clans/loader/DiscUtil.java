package me.ulrich.clans.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/DiscUtil.class */
public class DiscUtil {
    private static HashMap<String, Lock> locks = new HashMap<>();

    public static String readString(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                fileInputStream.close();
                return new String(bArr, StandardCharsets.UTF_8);
            }
            i = i2 + fileInputStream.read(bArr, i2, length - i2);
        }
    }

    public static void writeBytes(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(new String(bArr, StandardCharsets.UTF_8).getBytes());
        fileOutputStream.close();
    }

    public static void write(File file, String str) throws IOException {
        writeBytes(file, utf8(str));
    }

    public static String read(File file) throws IOException {
        return readString(file);
    }

    public static boolean writeCatch(Clans clans, File file, String str, boolean z) {
        Lock lockWriteLock;
        String name = file.getName();
        if (locks.containsKey(name)) {
            lockWriteLock = locks.get(name);
        } else {
            lockWriteLock = new ReentrantReadWriteLock().writeLock();
            locks.put(name, lockWriteLock);
        }
        if (!z) {
            Lock lock = lockWriteLock;
            clans.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
                lock.lock();
                try {
                    write(file, str);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            return true;
        }
        lockWriteLock.lock();
        try {
            try {
                file.createNewFile();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                try {
                    outputStreamWriter.write(str);
                    outputStreamWriter.close();
                    lockWriteLock.unlock();
                    return true;
                } catch (Throwable th) {
                    try {
                        outputStreamWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                e.printStackTrace();
                lockWriteLock.unlock();
                return true;
            }
        } catch (Throwable th3) {
            lockWriteLock.unlock();
            throw th3;
        }
    }

    public static String readCatch(File file) {
        try {
            return read(file);
        } catch (IOException e) {
            return null;
        }
    }

    public static byte[] utf8(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static String utf8(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }
}
