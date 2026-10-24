package me.ulrich.clans.library.nbtapi.utils.metrics.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/config/MetricsConfig.class */
public class MetricsConfig {
    private final File file;
    private final boolean defaultEnabled;
    private String serverUUID;
    private boolean enabled;
    private boolean logErrors;
    private boolean logSentData;
    private boolean logResponseStatusText;
    private boolean didExistBefore = true;

    public MetricsConfig(File file, boolean z) throws IOException {
        this.file = file;
        this.defaultEnabled = z;
        setupConfig();
    }

    public String getServerUUID() {
        return this.serverUUID;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isLogErrorsEnabled() {
        return this.logErrors;
    }

    public boolean isLogSentDataEnabled() {
        return this.logSentData;
    }

    public boolean isLogResponseStatusTextEnabled() {
        return this.logResponseStatusText;
    }

    public boolean didExistBefore() {
        return this.didExistBefore;
    }

    private void setupConfig() throws IOException {
        if (!this.file.exists()) {
            this.didExistBefore = false;
            writeConfig();
        }
        readConfig();
        if (this.serverUUID == null) {
            writeConfig();
            readConfig();
        }
    }

    private void writeConfig() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add("# bStats (https://bStats.org) collects some basic information for plugin authors, like");
        arrayList.add("# how many people use their plugin and their total player count. It's recommended to keep");
        arrayList.add("# bStats enabled, but if you're not comfortable with this, you can turn this setting off.");
        arrayList.add("# There is no performance penalty associated with having metrics enabled, and data sent to");
        arrayList.add("# bStats is fully anonymous.");
        arrayList.add("# Learn more here: https://bstats.org/docs/server-owners");
        arrayList.add("enabled=" + this.defaultEnabled);
        arrayList.add("server-uuid=" + UUID.randomUUID().toString());
        arrayList.add("log-errors=false");
        arrayList.add("log-sent-data=false");
        arrayList.add("log-response-status-text=false");
        writeFile(this.file, arrayList);
    }

    private void readConfig() {
        List<String> file = readFile(this.file);
        if (file == null) {
            throw new AssertionError("Content of newly created file is null");
        }
        String str = "true";
        this.enabled = ((Boolean) getConfigValue("enabled", file).map((v1) -> {
            return r2.equals(v1);
        }).orElse(true)).booleanValue();
        this.serverUUID = getConfigValue("server-uuid", file).orElse(null);
        String str2 = "true";
        this.logErrors = ((Boolean) getConfigValue("log-errors", file).map((v1) -> {
            return r2.equals(v1);
        }).orElse(false)).booleanValue();
        String str3 = "true";
        this.logSentData = ((Boolean) getConfigValue("log-sent-data", file).map((v1) -> {
            return r2.equals(v1);
        }).orElse(false)).booleanValue();
        String str4 = "true";
        this.logResponseStatusText = ((Boolean) getConfigValue("log-response-status-text", file).map((v1) -> {
            return r2.equals(v1);
        }).orElse(false)).booleanValue();
    }

    private Optional<String> getConfigValue(String str, List<String> list) {
        return list.stream().filter(str2 -> {
            return str2.startsWith(str + "=");
        }).map(str3 -> {
            return str3.replaceFirst(Pattern.quote(str + "="), "");
        }).findFirst();
    }

    private List<String> readFile(File file) {
        if (!file.exists()) {
            return null;
        }
        FileReader fileReader = new FileReader(file);
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                List<String> list = (List) bufferedReader.lines().collect(Collectors.toList());
                bufferedReader.close();
                fileReader.close();
                return list;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileReader.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    private void writeFile(File file, List<String> list) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    bufferedWriter.write(it.next());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileWriter.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }
}
