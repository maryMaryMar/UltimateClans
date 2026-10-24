package me.ulrich.clans;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics.class */
public class Metrics {
    private final Plugin plugin;
    private final bUQFEznViQX6XlU8D metricsBase;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$DQoauhaxduHZi.class */
    public static class DQoauhaxduHZi extends ZRp1tak21UvNaOVCtFx {
        private final Callable<Map<String, Integer>> v8qP8fE86HMhvNuYPFjqY;

        public DQoauhaxduHZi(String str, Callable<Map<String, Integer>> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        protected zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            Map<String, Integer> mapCall = this.v8qP8fE86HMhvNuYPFjqY.call();
            if (mapCall == null || mapCall.isEmpty()) {
                return null;
            }
            boolean z = true;
            for (Map.Entry<String, Integer> entry : mapCall.entrySet()) {
                if (entry.getValue().intValue() != 0) {
                    z = false;
                    ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY(entry.getKey(), entry.getValue().intValue());
                }
            }
            if (z) {
                return null;
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("values", ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY()).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$E0Zb3L2jgpdfCu9HPY.class */
    public static class E0Zb3L2jgpdfCu9HPY extends ZRp1tak21UvNaOVCtFx {
        private final Callable<Integer> v8qP8fE86HMhvNuYPFjqY;

        public E0Zb3L2jgpdfCu9HPY(String str, Callable<Integer> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        protected zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            int iIntValue = this.v8qP8fE86HMhvNuYPFjqY.call().intValue();
            if (iIntValue == 0) {
                return null;
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("value", iIntValue).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$Ijap9SQKkijXSxP5.class */
    public static class Ijap9SQKkijXSxP5 extends ZRp1tak21UvNaOVCtFx {
        private final Callable<Map<String, int[]>> v8qP8fE86HMhvNuYPFjqY;

        public Ijap9SQKkijXSxP5(String str, Callable<Map<String, int[]>> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        protected zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            Map<String, int[]> mapCall = this.v8qP8fE86HMhvNuYPFjqY.call();
            if (mapCall == null || mapCall.isEmpty()) {
                return null;
            }
            boolean z = true;
            for (Map.Entry<String, int[]> entry : mapCall.entrySet()) {
                if (entry.getValue().length != 0) {
                    z = false;
                    ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY(entry.getKey(), entry.getValue());
                }
            }
            if (z) {
                return null;
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("values", ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY()).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$RuVgd0Dnv0ddhdcWL.class */
    public static class RuVgd0Dnv0ddhdcWL extends ZRp1tak21UvNaOVCtFx {
        private final Callable<Map<String, Map<String, Integer>>> v8qP8fE86HMhvNuYPFjqY;

        public RuVgd0Dnv0ddhdcWL(String str, Callable<Map<String, Map<String, Integer>>> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        public zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            Map<String, Map<String, Integer>> mapCall = this.v8qP8fE86HMhvNuYPFjqY.call();
            if (mapCall == null || mapCall.isEmpty()) {
                return null;
            }
            boolean z = true;
            for (Map.Entry<String, Map<String, Integer>> entry : mapCall.entrySet()) {
                zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc2 = new zTcC5XsAfoa1Tc1();
                boolean z2 = true;
                for (Map.Entry<String, Integer> entry2 : mapCall.get(entry.getKey()).entrySet()) {
                    ztcc5xsafoa1tc2.v8qP8fE86HMhvNuYPFjqY(entry2.getKey(), entry2.getValue().intValue());
                    z2 = false;
                }
                if (!z2) {
                    z = false;
                    ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY(entry.getKey(), ztcc5xsafoa1tc2.v8qP8fE86HMhvNuYPFjqY());
                }
            }
            if (z) {
                return null;
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("values", ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY()).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$UsEbiuprSHpNw3qjITfH.class */
    public static class UsEbiuprSHpNw3qjITfH extends ZRp1tak21UvNaOVCtFx {
        private final Callable<Map<String, Integer>> v8qP8fE86HMhvNuYPFjqY;

        public UsEbiuprSHpNw3qjITfH(String str, Callable<Map<String, Integer>> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        protected zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            Map<String, Integer> mapCall = this.v8qP8fE86HMhvNuYPFjqY.call();
            if (mapCall == null || mapCall.isEmpty()) {
                return null;
            }
            boolean z = true;
            for (Map.Entry<String, Integer> entry : mapCall.entrySet()) {
                if (entry.getValue().intValue() != 0) {
                    z = false;
                    ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY(entry.getKey(), entry.getValue().intValue());
                }
            }
            if (z) {
                return null;
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("values", ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY()).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$XQWpFH32TPMOVKV5.class */
    public static class XQWpFH32TPMOVKV5 extends ZRp1tak21UvNaOVCtFx {
        private final Callable<String> v8qP8fE86HMhvNuYPFjqY;

        public XQWpFH32TPMOVKV5(String str, Callable<String> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        protected zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            String strCall = this.v8qP8fE86HMhvNuYPFjqY.call();
            if (strCall == null || strCall.isEmpty()) {
                return null;
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("value", strCall).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$ZRp1tak21UvNaOVCtFx.class */
    public static abstract class ZRp1tak21UvNaOVCtFx {
        private final String v8qP8fE86HMhvNuYPFjqY;

        protected ZRp1tak21UvNaOVCtFx(String str) {
            if (str == null) {
                throw new IllegalArgumentException("chartId must not be null");
            }
            this.v8qP8fE86HMhvNuYPFjqY = str;
        }

        public zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY(BiConsumer<String, Throwable> biConsumer, boolean z) {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("chartId", this.v8qP8fE86HMhvNuYPFjqY);
            try {
                zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY();
                if (ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY == null) {
                    return null;
                }
                ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("data", ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY);
                return ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY();
            } catch (Throwable th) {
                if (!z) {
                    return null;
                }
                biConsumer.accept("Failed to get data for custom chart with id " + this.v8qP8fE86HMhvNuYPFjqY, th);
                return null;
            }
        }

        protected abstract zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception;
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$bUQFEznViQX6XlU8D.class */
    public static class bUQFEznViQX6XlU8D {
        public static final String v8qP8fE86HMhvNuYPFjqY = "3.0.2";
        private static final String jBUuLP0sWwaPyPOmogdX7l = "https://bStats.org/api/v2/data/%s";
        private final ScheduledExecutorService ZwrsrwOCXRUscW6Q;
        private final String iZTqZaRK5UGoe0Z;
        private final String xtOheRiObl4QeAl;
        private final int zJnaNCVQSgEShq;
        private final Consumer<zTcC5XsAfoa1Tc1> CDW4Fj1iwdIXEOqWjiJSR;
        private final Consumer<zTcC5XsAfoa1Tc1> b4i2FbOkaKeg91LiAe6l;
        private final Consumer<Runnable> p31abtwfBag2jhMH6K;
        private final Supplier<Boolean> Un3NRLL6aWivTcbodkcK;
        private final BiConsumer<String, Throwable> lGGwXL678c4Kv7skJb5NiE;
        private final Consumer<String> o1VU1x4DAlrEtGKZ3jAdhE;
        private final boolean vVo2VUvxrriklPdRxI;
        private final boolean Fc3p9FhCjSD1k5Ra4;
        private final boolean Nz8xKv4RePC2a0f0iuYU;
        private final Set<ZRp1tak21UvNaOVCtFx> HX3ZfRb1nSpNq57s7x5ui = new HashSet();
        private final boolean IO1OGSMpoP1ZjOsbXi3a;

        public bUQFEznViQX6XlU8D(String str, String str2, int i, boolean z, Consumer<zTcC5XsAfoa1Tc1> consumer, Consumer<zTcC5XsAfoa1Tc1> consumer2, Consumer<Runnable> consumer3, Supplier<Boolean> supplier, BiConsumer<String, Throwable> biConsumer, Consumer<String> consumer4, boolean z2, boolean z3, boolean z4) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, runnable -> {
                return new Thread(runnable, "bStats-Metrics");
            });
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.ZwrsrwOCXRUscW6Q = scheduledThreadPoolExecutor;
            this.iZTqZaRK5UGoe0Z = str;
            this.xtOheRiObl4QeAl = str2;
            this.zJnaNCVQSgEShq = i;
            this.IO1OGSMpoP1ZjOsbXi3a = z;
            this.CDW4Fj1iwdIXEOqWjiJSR = consumer;
            this.b4i2FbOkaKeg91LiAe6l = consumer2;
            this.p31abtwfBag2jhMH6K = consumer3;
            this.Un3NRLL6aWivTcbodkcK = supplier;
            this.lGGwXL678c4Kv7skJb5NiE = biConsumer;
            this.o1VU1x4DAlrEtGKZ3jAdhE = consumer4;
            this.vVo2VUvxrriklPdRxI = z2;
            this.Fc3p9FhCjSD1k5Ra4 = z3;
            this.Nz8xKv4RePC2a0f0iuYU = z4;
            iZTqZaRK5UGoe0Z();
            if (z) {
                jBUuLP0sWwaPyPOmogdX7l();
            }
        }

        public void v8qP8fE86HMhvNuYPFjqY(ZRp1tak21UvNaOVCtFx zRp1tak21UvNaOVCtFx) {
            this.HX3ZfRb1nSpNq57s7x5ui.add(zRp1tak21UvNaOVCtFx);
        }

        public void v8qP8fE86HMhvNuYPFjqY() {
            this.ZwrsrwOCXRUscW6Q.shutdown();
        }

        private void jBUuLP0sWwaPyPOmogdX7l() {
            Runnable runnable = () -> {
                if (!this.IO1OGSMpoP1ZjOsbXi3a || !this.Un3NRLL6aWivTcbodkcK.get().booleanValue()) {
                    this.ZwrsrwOCXRUscW6Q.shutdown();
                } else if (this.p31abtwfBag2jhMH6K != null) {
                    this.p31abtwfBag2jhMH6K.accept(this::ZwrsrwOCXRUscW6Q);
                } else {
                    ZwrsrwOCXRUscW6Q();
                }
            };
            long jRandom = (long) (60000.0d * (3.0d + (Math.random() * 3.0d)));
            long jRandom2 = (long) (60000.0d * Math.random() * 30.0d);
            this.ZwrsrwOCXRUscW6Q.schedule(runnable, jRandom, TimeUnit.MILLISECONDS);
            this.ZwrsrwOCXRUscW6Q.scheduleAtFixedRate(runnable, jRandom + jRandom2, 1800000L, TimeUnit.MILLISECONDS);
        }

        private void ZwrsrwOCXRUscW6Q() {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            this.CDW4Fj1iwdIXEOqWjiJSR.accept(ztcc5xsafoa1tc1);
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc2 = new zTcC5XsAfoa1Tc1();
            this.b4i2FbOkaKeg91LiAe6l.accept(ztcc5xsafoa1tc2);
            zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5[] ijap9SQKkijXSxP5Arr = (zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5[]) this.HX3ZfRb1nSpNq57s7x5ui.stream().map(zRp1tak21UvNaOVCtFx -> {
                return zRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY(this.lGGwXL678c4Kv7skJb5NiE, this.vVo2VUvxrriklPdRxI);
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).toArray(i -> {
                return new zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5[i];
            });
            ztcc5xsafoa1tc2.v8qP8fE86HMhvNuYPFjqY("id", this.zJnaNCVQSgEShq);
            ztcc5xsafoa1tc2.v8qP8fE86HMhvNuYPFjqY("customCharts", ijap9SQKkijXSxP5Arr);
            ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("service", ztcc5xsafoa1tc2.v8qP8fE86HMhvNuYPFjqY());
            ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("serverUUID", this.xtOheRiObl4QeAl);
            ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("metricsVersion", v8qP8fE86HMhvNuYPFjqY);
            zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY = ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY();
            this.ZwrsrwOCXRUscW6Q.execute(() -> {
                try {
                    v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY);
                } catch (Exception e) {
                    if (this.vVo2VUvxrriklPdRxI) {
                        this.lGGwXL678c4Kv7skJb5NiE.accept("Could not submit bStats metrics data", e);
                    }
                }
            });
        }

        private void v8qP8fE86HMhvNuYPFjqY(zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5) throws IOException {
            if (this.Fc3p9FhCjSD1k5Ra4) {
                this.o1VU1x4DAlrEtGKZ3jAdhE.accept("Sent bStats metrics data: " + ijap9SQKkijXSxP5.toString());
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(String.format(jBUuLP0sWwaPyPOmogdX7l, this.iZTqZaRK5UGoe0Z)).openConnection();
            byte[] bArrV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5.toString());
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.addRequestProperty("Accept", "application/json");
            httpsURLConnection.addRequestProperty("Connection", "close");
            httpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpsURLConnection.addRequestProperty("Content-Length", String.valueOf(bArrV8qP8fE86HMhvNuYPFjqY.length));
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestProperty("User-Agent", "Metrics-Service/1");
            httpsURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            try {
                dataOutputStream.write(bArrV8qP8fE86HMhvNuYPFjqY);
                dataOutputStream.close();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                if (this.Nz8xKv4RePC2a0f0iuYU) {
                    this.o1VU1x4DAlrEtGKZ3jAdhE.accept("Sent data to bStats and received response: " + String.valueOf(sb));
                }
            } catch (Throwable th3) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }

        private void iZTqZaRK5UGoe0Z() {
            if (System.getProperty("bstats.relocatecheck") == null || !System.getProperty("bstats.relocatecheck").equals("false")) {
                String str = "your.package";
                if (bUQFEznViQX6XlU8D.class.getPackage().getName().startsWith("org.bstats") || bUQFEznViQX6XlU8D.class.getPackage().getName().startsWith(str)) {
                    throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
                }
            }
        }

        private static byte[] v8qP8fE86HMhvNuYPFjqY(String str) {
        if (str == null) {
            return null;
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (GZIPOutputStream gz = new GZIPOutputStream(bos)) {
                gz.write(str.getBytes(StandardCharsets.UTF_8));
            }
            return bos.toByteArray();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$jfN3Uc9ymXXFWVHj7Oor.class */
    public static class jfN3Uc9ymXXFWVHj7Oor extends ZRp1tak21UvNaOVCtFx {
        private final Callable<Map<String, Integer>> v8qP8fE86HMhvNuYPFjqY;

        public jfN3Uc9ymXXFWVHj7Oor(String str, Callable<Map<String, Integer>> callable) {
            super(str);
            this.v8qP8fE86HMhvNuYPFjqY = callable;
        }

        @Override // me.ulrich.clans.Metrics.ZRp1tak21UvNaOVCtFx
        protected zTcC5XsAfoa1Tc1.Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() throws Exception {
            zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1 = new zTcC5XsAfoa1Tc1();
            Map<String, Integer> mapCall = this.v8qP8fE86HMhvNuYPFjqY.call();
            if (mapCall == null || mapCall.isEmpty()) {
                return null;
            }
            for (Map.Entry<String, Integer> entry : mapCall.entrySet()) {
                ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY(entry.getKey(), new int[]{entry.getValue().intValue()});
            }
            return new zTcC5XsAfoa1Tc1().v8qP8fE86HMhvNuYPFjqY("values", ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY()).v8qP8fE86HMhvNuYPFjqY();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$zTcC5XsAfoa1Tc1.class */
    public static class zTcC5XsAfoa1Tc1 {
        private StringBuilder v8qP8fE86HMhvNuYPFjqY = new StringBuilder();
        private boolean jBUuLP0sWwaPyPOmogdX7l = false;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Metrics$zTcC5XsAfoa1Tc1$Ijap9SQKkijXSxP5.class */
        public static class Ijap9SQKkijXSxP5 {
            private final String v8qP8fE86HMhvNuYPFjqY;

            private Ijap9SQKkijXSxP5(String str) {
                this.v8qP8fE86HMhvNuYPFjqY = str;
            }

            public String toString() {
                return this.v8qP8fE86HMhvNuYPFjqY;
            }
        }

        public zTcC5XsAfoa1Tc1() {
            this.v8qP8fE86HMhvNuYPFjqY.append("{");
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str) {
            jBUuLP0sWwaPyPOmogdX7l(str, "null");
            return this;
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
            if (str2 == null) {
                throw new IllegalArgumentException("JSON value must not be null");
            }
            jBUuLP0sWwaPyPOmogdX7l(str, "\"" + jBUuLP0sWwaPyPOmogdX7l(str2) + "\"");
            return this;
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str, int i) {
            jBUuLP0sWwaPyPOmogdX7l(str, String.valueOf(i));
            return this;
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str, Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5) {
            if (ijap9SQKkijXSxP5 == null) {
                throw new IllegalArgumentException("JSON object must not be null");
            }
            jBUuLP0sWwaPyPOmogdX7l(str, ijap9SQKkijXSxP5.toString());
            return this;
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str, String[] strArr) {
            if (strArr == null) {
                throw new IllegalArgumentException("JSON values must not be null");
            }
            jBUuLP0sWwaPyPOmogdX7l(str, "[" + ((String) Arrays.stream(strArr).map(str2 -> {
                return "\"" + jBUuLP0sWwaPyPOmogdX7l(str2) + "\"";
            }).collect(Collectors.joining(","))) + "]");
            return this;
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str, int[] iArr) {
            if (iArr == null) {
                throw new IllegalArgumentException("JSON values must not be null");
            }
            jBUuLP0sWwaPyPOmogdX7l(str, "[" + ((String) Arrays.stream(iArr).mapToObj(String::valueOf).collect(Collectors.joining(","))) + "]");
            return this;
        }

        public zTcC5XsAfoa1Tc1 v8qP8fE86HMhvNuYPFjqY(String str, Ijap9SQKkijXSxP5[] ijap9SQKkijXSxP5Arr) {
            if (ijap9SQKkijXSxP5Arr == null) {
                throw new IllegalArgumentException("JSON values must not be null");
            }
            jBUuLP0sWwaPyPOmogdX7l(str, "[" + ((String) Arrays.stream(ijap9SQKkijXSxP5Arr).map((v0) -> {
                return v0.toString();
            }).collect(Collectors.joining(","))) + "]");
            return this;
        }

        private void jBUuLP0sWwaPyPOmogdX7l(String str, String str2) {
            if (this.v8qP8fE86HMhvNuYPFjqY == null) {
                throw new IllegalStateException("JSON has already been built");
            }
            if (str == null) {
                throw new IllegalArgumentException("JSON key must not be null");
            }
            if (this.jBUuLP0sWwaPyPOmogdX7l) {
                this.v8qP8fE86HMhvNuYPFjqY.append(",");
            }
            this.v8qP8fE86HMhvNuYPFjqY.append("\"").append(jBUuLP0sWwaPyPOmogdX7l(str)).append("\":").append(str2);
            this.jBUuLP0sWwaPyPOmogdX7l = true;
        }

        public Ijap9SQKkijXSxP5 v8qP8fE86HMhvNuYPFjqY() {
            if (this.v8qP8fE86HMhvNuYPFjqY == null) {
                throw new IllegalStateException("JSON has already been built");
            }
            Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5 = new Ijap9SQKkijXSxP5(this.v8qP8fE86HMhvNuYPFjqY.append("}").toString());
            this.v8qP8fE86HMhvNuYPFjqY = null;
            return ijap9SQKkijXSxP5;
        }

        private static String jBUuLP0sWwaPyPOmogdX7l(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '\"') {
                    sb.append("\\\"");
                } else if (cCharAt == '\\') {
                    sb.append("\\\\");
                } else if (cCharAt <= 15) {
                    sb.append("\\u000").append(Integer.toHexString(cCharAt));
                } else if (cCharAt <= 31) {
                    sb.append("\\u00").append(Integer.toHexString(cCharAt));
                } else {
                    sb.append(cCharAt);
                }
            }
            return sb.toString();
        }
    }

    public Metrics(JavaPlugin javaPlugin, int i, TaskScheduler taskScheduler) {
        this.plugin = javaPlugin;
        File file = new File(new File(javaPlugin.getDataFolder().getParentFile(), "bStats"), "config.yml");
        YamlConfiguration yamlConfigurationLoadConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!yamlConfigurationLoadConfiguration.isSet("serverUuid")) {
            yamlConfigurationLoadConfiguration.addDefault("enabled", true);
            yamlConfigurationLoadConfiguration.addDefault("serverUuid", UUID.randomUUID().toString());
            yamlConfigurationLoadConfiguration.addDefault("logFailedRequests", false);
            yamlConfigurationLoadConfiguration.addDefault("logSentData", false);
            yamlConfigurationLoadConfiguration.addDefault("logResponseStatusText", false);
            yamlConfigurationLoadConfiguration.options().header("bStats (https://bStats.org) collects some basic information for plugin authors, like how\nmany people use their plugin and their total player count. It's recommended to keep bStats\nenabled, but if you're not comfortable with this, you can turn this setting off. There is no\nperformance penalty associated with having metrics enabled, and data sent to bStats is fully\nanonymous.").copyDefaults(true);
            try {
                yamlConfigurationLoadConfiguration.save(file);
            } catch (IOException e) {
            }
        }
        boolean z = yamlConfigurationLoadConfiguration.getBoolean("enabled", true);
        String string = yamlConfigurationLoadConfiguration.getString("serverUuid");
        boolean z2 = yamlConfigurationLoadConfiguration.getBoolean("logFailedRequests", false);
        boolean z3 = yamlConfigurationLoadConfiguration.getBoolean("logSentData", false);
        boolean z4 = yamlConfigurationLoadConfiguration.getBoolean("logResponseStatusText", false);
        Consumer<zTcC5XsAfoa1Tc1> consumer = this::appendPlatformData;
        Consumer<zTcC5XsAfoa1Tc1> consumer2 = this::appendServiceData;
        Consumer<Runnable> consumer3 = runnable -> {
            taskScheduler.runTask(runnable);
        };
        Objects.requireNonNull(javaPlugin);
        this.metricsBase = new bUQFEznViQX6XlU8D("bukkit", string, i, z, consumer, consumer2, consumer3, javaPlugin::isEnabled, (str, th) -> {
            this.plugin.getLogger().log(Level.WARNING, str, th);
        }, str2 -> {
            this.plugin.getLogger().log(Level.INFO, str2);
        }, z2, z3, z4);
    }

    public void shutdown() {
        this.metricsBase.v8qP8fE86HMhvNuYPFjqY();
    }

    public void addCustomChart(ZRp1tak21UvNaOVCtFx zRp1tak21UvNaOVCtFx) {
        this.metricsBase.v8qP8fE86HMhvNuYPFjqY(zRp1tak21UvNaOVCtFx);
    }

    private void appendPlatformData(zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1) {
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("playerAmount", getPlayerAmount());
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("onlineMode", Bukkit.getOnlineMode() ? 1 : 0);
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("bukkitVersion", Bukkit.getVersion());
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("bukkitName", Bukkit.getName());
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("javaVersion", System.getProperty("java.version"));
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("osName", System.getProperty("os.name"));
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("osArch", System.getProperty("os.arch"));
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("osVersion", System.getProperty("os.version"));
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("coreCount", Runtime.getRuntime().availableProcessors());
    }

    private void appendServiceData(zTcC5XsAfoa1Tc1 ztcc5xsafoa1tc1) {
        ztcc5xsafoa1tc1.v8qP8fE86HMhvNuYPFjqY("pluginVersion", this.plugin.getDescription().getVersion());
    }

    private int getPlayerAmount() {
        try {
            Method method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", new Class[0]);
            return method.getReturnType().equals(Collection.class) ? ((Collection) method.invoke(Bukkit.getServer(), new Object[0])).size() : ((Player[]) method.invoke(Bukkit.getServer(), new Object[0])).length;
        } catch (Exception e) {
            return Bukkit.getOnlinePlayers().size();
        }
    }
}
