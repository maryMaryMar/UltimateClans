package me.ulrich.clans.library.nbtapi.utils.metrics;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/MetricsBase.class */
public class MetricsBase {
    public static final String METRICS_VERSION = "3.2.1";
    private static final String REPORT_URL = "https://bStats.org/api/v2/data/%s";
    private final ScheduledExecutorService scheduler;
    private final String platform;
    private final String serverUuid;
    private final int serviceId;
    private final Consumer<JsonObjectBuilder> appendPlatformDataConsumer;
    private final Consumer<JsonObjectBuilder> appendServiceDataConsumer;
    private final Consumer<Runnable> submitTaskConsumer;
    private final Supplier<Boolean> checkServiceEnabledSupplier;
    private final BiConsumer<String, Throwable> errorLogger;
    private final Consumer<String> infoLogger;
    private final boolean logErrors;
    private final boolean logSentData;
    private final boolean logResponseStatusText;
    private final Set<CustomChart> customCharts = new HashSet();
    private final boolean enabled;

    public MetricsBase(String str, String str2, int i, boolean z, Consumer<JsonObjectBuilder> consumer, Consumer<JsonObjectBuilder> consumer2, Consumer<Runnable> consumer3, Supplier<Boolean> supplier, BiConsumer<String, Throwable> biConsumer, Consumer<String> consumer4, boolean z2, boolean z3, boolean z4, boolean z5) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, runnable -> {
            Thread thread = new Thread(runnable, "bStats-Metrics");
            thread.setDaemon(true);
            return thread;
        });
        scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        this.scheduler = scheduledThreadPoolExecutor;
        this.platform = str;
        this.serverUuid = str2;
        this.serviceId = i;
        this.enabled = z;
        this.appendPlatformDataConsumer = consumer;
        this.appendServiceDataConsumer = consumer2;
        this.submitTaskConsumer = consumer3;
        this.checkServiceEnabledSupplier = supplier;
        this.errorLogger = biConsumer;
        this.infoLogger = consumer4;
        this.logErrors = z2;
        this.logSentData = z3;
        this.logResponseStatusText = z4;
        if (!z5) {
            checkRelocation();
        }
        if (z) {
            startSubmitting();
        }
    }

    public void addCustomChart(CustomChart customChart) {
        this.customCharts.add(customChart);
    }

    public void shutdown() {
        this.scheduler.shutdown();
    }

    private void startSubmitting() {
        Runnable runnable = () -> {
            if (!this.enabled || !this.checkServiceEnabledSupplier.get().booleanValue()) {
                this.scheduler.shutdown();
            } else if (this.submitTaskConsumer != null) {
                this.submitTaskConsumer.accept(this::submitData);
            } else {
                submitData();
            }
        };
        long jRandom = (long) (60000.0d * (3.0d + (Math.random() * 3.0d)));
        long jRandom2 = (long) (60000.0d * Math.random() * 30.0d);
        this.scheduler.schedule(runnable, jRandom, TimeUnit.MILLISECONDS);
        this.scheduler.scheduleAtFixedRate(runnable, jRandom + jRandom2, BaseObjectPoolConfig.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS, TimeUnit.MILLISECONDS);
    }

    private void submitData() {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        this.appendPlatformDataConsumer.accept(jsonObjectBuilder);
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        this.appendServiceDataConsumer.accept(jsonObjectBuilder2);
        JsonObjectBuilder.JsonObject[] jsonObjectArr = (JsonObjectBuilder.JsonObject[]) this.customCharts.stream().map(customChart -> {
            return customChart.getRequestJsonObject(this.errorLogger, this.logErrors);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toArray(i -> {
            return new JsonObjectBuilder.JsonObject[i];
        });
        jsonObjectBuilder2.appendField("id", this.serviceId);
        jsonObjectBuilder2.appendField("customCharts", jsonObjectArr);
        jsonObjectBuilder.appendField("service", jsonObjectBuilder2.build());
        jsonObjectBuilder.appendField("serverUUID", this.serverUuid);
        jsonObjectBuilder.appendField("metricsVersion", METRICS_VERSION);
        JsonObjectBuilder.JsonObject jsonObjectBuild = jsonObjectBuilder.build();
        this.scheduler.execute(() -> {
            try {
                sendData(jsonObjectBuild);
            } catch (Exception e) {
                if (this.logErrors) {
                    this.errorLogger.accept("Could not submit bStats metrics data", e);
                }
            }
        });
    }

    private void sendData(JsonObjectBuilder.JsonObject jsonObject) throws IOException {
        if (this.logSentData) {
            this.infoLogger.accept("Sent bStats metrics data: " + jsonObject.toString());
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(String.format(REPORT_URL, this.platform)).openConnection();
        byte[] bArrCompress = compress(jsonObject.toString());
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.addRequestProperty("Accept", "application/json");
        httpsURLConnection.addRequestProperty("Connection", "close");
        httpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpsURLConnection.addRequestProperty("Content-Length", String.valueOf(bArrCompress.length));
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("User-Agent", "Metrics-Service/1");
        httpsURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        try {
            dataOutputStream.write(bArrCompress);
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
            if (this.logResponseStatusText) {
                this.infoLogger.accept("Sent data to bStats and received response: " + ((Object) sb));
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

    private void checkRelocation() {
        if (System.getProperty("bstats.relocatecheck") == null || !System.getProperty("bstats.relocatecheck").equals("false")) {
            String str = "your.package";
            if (MetricsBase.class.getPackage().getName().startsWith("org.bstats") || MetricsBase.class.getPackage().getName().startsWith(str)) {
                throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
            }
        }
    }

    private static byte[] compress(String str) {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                gZIPOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
