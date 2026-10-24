package me.ulrich.clans.library.enumconfig.yaml.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.Yaml;
import me.ulrich.clans.library.enumconfig.yaml.EnumConfigurationConstructor;
import me.ulrich.clans.library.enumconfig.yaml.EnumConfigurationDumperOptions;
import me.ulrich.clans.library.enumconfig.yaml.EnumConfigurationRepresenter;
import me.ulrich.clans.library.enumconfig.yaml.file.interfaces.Configuration;
import me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/file/YAMLConfiguration.class */
public class YAMLConfiguration extends MemorySection implements Configuration {
    private final EnumConfigurationDumperOptions dumperOptions;
    private final Yaml yaml;
    private final File file;
    private HashMap<String, String> comments = new HashMap<>();

    public YAMLConfiguration(File file, EnumConfigurationDumperOptions enumConfigurationDumperOptions) {
        this.file = file;
        this.dumperOptions = enumConfigurationDumperOptions;
        this.yaml = new Yaml(new EnumConfigurationConstructor(), new EnumConfigurationRepresenter(), enumConfigurationDumperOptions);
    }

    public void load() throws IOException {
        LinkedHashMap<String, Object> linkedHashMap = null;
        try {
            linkedHashMap = (LinkedHashMap) this.yaml.load(new InputStreamReader(new FileInputStream(this.file), StandardCharsets.UTF_8));
        } catch (Exception e) {
            tryCopyFileUsingStream(this.file, new File(this.file.getPath() + "_backup_" + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(Calendar.getInstance().getTime())));
            e.printStackTrace();
        }
        if (linkedHashMap != null) {
            convertMapsToSections(linkedHashMap, this);
        }
    }

    private void tryCopyFileUsingStream(File file, File file2) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            fileInputStream.close();
            fileOutputStream.close();
            throw th;
        }
    }

    public File getFile() {
        return this.file;
    }

    private void convertMapsToSections(LinkedHashMap<String, Object> linkedHashMap, ConfigurationSection configurationSection) {
        for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
            try {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof LinkedHashMap) {
                    convertMapsToSections((LinkedHashMap) value, configurationSection.createSection(key));
                } else {
                    configurationSection.set(key, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void save() throws IOException {
        if (this.file == null) {
            throw new NullPointerException("File cannot be null");
        }
        File parentFile = this.file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        if (parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Unable to create parent directories of " + this.file);
        }
        String strDump = this.yaml.dump(getValues(false));
        if (strDump.equals("{}\n")) {
            strDump = "";
        }
        String[] strArrSplit = strDump.split(System.getProperty("line.separator"));
        StringBuilder sb = new StringBuilder();
        String strReplace = "";
        int i = 0;
        for (String str : strArrSplit) {
            boolean z = false;
            if (str.contains(": ") || (str.length() > 1 && str.charAt(str.length() - 1) == ':')) {
                z = true;
                int iIndexOf = str.indexOf(": ");
                if (iIndexOf < 0) {
                    iIndexOf = str.length() - 1;
                }
                if (strReplace.isEmpty()) {
                    strReplace = str.substring(0, iIndexOf);
                } else {
                    int i2 = 0;
                    for (int i3 = 0; i3 < str.length() && str.charAt(i3) == ' '; i3++) {
                        i2++;
                    }
                    if (i2 / this.dumperOptions.getIndent() > i) {
                        strReplace = strReplace + this.dumperOptions.getSeparatorChar() + str.substring(i2, iIndexOf);
                        i++;
                    } else if (i2 / this.dumperOptions.getIndent() < i) {
                        int indent = i2 / this.dumperOptions.getIndent();
                        for (int i4 = 0; i4 < i - indent; i4++) {
                            strReplace = strReplace.replace(strReplace.substring(strReplace.lastIndexOf(this.dumperOptions.getSeparatorChar())), "");
                        }
                        strReplace = (strReplace.lastIndexOf(this.dumperOptions.getSeparatorChar()) < 0 ? "" : strReplace.replace(strReplace.substring(strReplace.lastIndexOf(this.dumperOptions.getSeparatorChar())), "") + this.dumperOptions.getSeparatorChar()) + str.substring(i2, iIndexOf);
                        i = indent;
                    } else {
                        strReplace = (strReplace.lastIndexOf(this.dumperOptions.getSeparatorChar()) < 0 ? "" : strReplace.replace(strReplace.substring(strReplace.lastIndexOf(this.dumperOptions.getSeparatorChar())), "") + this.dumperOptions.getSeparatorChar()) + str.substring(i2, iIndexOf);
                    }
                }
            }
            if (z && this.comments.get(strReplace) != null) {
                str = this.comments.get(strReplace) + str;
            }
            sb.append(str).append(System.getProperty("line.separator"));
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.file), StandardCharsets.UTF_8);
            try {
                outputStreamWriter.write(sb.toString());
                outputStreamWriter.close();
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
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.MemorySection, me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public ConfigurationSection getParent() {
        return null;
    }

    public void setComments(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == this.dumperOptions.getSeparatorChar()) {
                for (int i2 = 0; i2 < this.dumperOptions.getIndent(); i2++) {
                    sb2.append(" ");
                }
            }
        }
        for (String str2 : strArr) {
            sb.append((CharSequence) sb2).append(str2).append(System.getProperty("line.separator"));
        }
        this.comments.put(str, sb.toString());
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.Configuration
    public char getSeparatorCharacter() {
        return this.dumperOptions.getSeparatorChar();
    }
}
