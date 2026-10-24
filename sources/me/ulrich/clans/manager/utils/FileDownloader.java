package me.ulrich.clans.manager.utils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import me.ulrich.clans.Clans;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/FileDownloader.class */
public class FileDownloader {
    private Runnable onSuccess;
    private Runnable onFailure;
    private static volatile String JZ2W4NCBFEcYY8RR;
    private static String oyXNVoBPYt26AV6;
    private static final byte[] z1TEA4cDCL5Ty0SXxS1j2 = {(byte) 14, (byte) 63, (byte) 214, (byte) 29, (byte) 11, (byte) 114, (byte) 21, (byte) 104, (byte) 2, (byte) 27, (byte) 123, (byte) 130, (byte) 231, (byte) 92, (byte) 206, (byte) 24, (byte) 151, (byte) 121, (byte) 185, (byte) 154, (byte) 182, (byte) 28, (byte) 88, (byte) 157, (byte) 94, (byte) 140, (byte) 200, (byte) 236, (byte) 84, (byte) 168, (byte) 88, (byte) 48};
    private static final byte[] WOnKmHszGNYvfPqzx = {(byte) 176, (byte) 211, (byte) 174, (byte) 89, (byte) 248, (byte) 66, (byte) 192, (byte) 186, (byte) 118, (byte) 73, (byte) 29, (byte) 42, (byte) 248, (byte) 205, (byte) 101, (byte) 63};
    private static final List<String> VALID_TYPES = Arrays.asList("yml", "txt", "jar");

    public FileDownloader onSuccess(Runnable runnable) {
        this.onSuccess = runnable;
        return this;
    }

    public FileDownloader onFailure(Runnable runnable) {
        this.onFailure = runnable;
        return this;
    }

    public void downloadUsingLocale(Clans clans, String str, String str2) {
        if (isValidType(str2)) {
            clans.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestProperty(yUryGvxlDKwximtndMLA(), S3IVjn0f9RT6C6FR());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(str2);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                }
                                runSync(clans, () -> {
                                    successDownload();
                                    if (this.onSuccess != null) {
                                        this.onSuccess.run();
                                    }
                                });
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                            throw th3;
                        }
                    } else {
                        clans.getLogger().warning("Could not download. Server returned HTTP response code: " + responseCode);
                        runSync(clans, () -> {
                            failedDownload();
                            if (this.onFailure != null) {
                                this.onFailure.run();
                            }
                        });
                    }
                    httpURLConnection.disconnect();
                } catch (Exception e) {
                    clans.getLogger().warning("Connection error while downloading file: " + e.getClass().getSimpleName());
                    runSync(clans, () -> {
                        failedDownload();
                        if (this.onFailure != null) {
                            this.onFailure.run();
                        }
                    });
                }
            });
        }
    }

    public void successDownload() {
    }

    public void failedDownload() {
    }

    private boolean isValidType(String str) {
        try {
            return VALID_TYPES.contains(str.substring(str.lastIndexOf(46) + 1).toLowerCase());
        } catch (Exception e) {
            return false;
        }
    }

    private void runSync(Clans clans, Runnable runnable) {
        clans.getTaskManager().xtOheRiObl4QeAl().runTask(runnable);
    }

    private static String yUryGvxlDKwximtndMLA() {
        return "User-Agent";
    }

    private static String S3IVjn0f9RT6C6FR() {
        return "Mozilla/5.0 (Windows NT 10.0; Win64; x64)";
    }
}
