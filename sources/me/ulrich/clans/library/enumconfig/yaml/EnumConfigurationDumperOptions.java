package me.ulrich.clans.library.enumconfig.yaml;

import me.ulrich.clans.library.enumconfig.library.DumperOptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/EnumConfigurationDumperOptions.class */
public class EnumConfigurationDumperOptions extends DumperOptions {
    private char separatorChar;

    public EnumConfigurationDumperOptions() {
        setWidth(10000);
        setPrettyFlow(true);
        setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);
        setLineBreak(DumperOptions.LineBreak.getPlatformLineBreak());
        setSeparatorChar('.');
    }

    public char getSeparatorChar() {
        return this.separatorChar;
    }

    public void setSeparatorChar(char c) {
        this.separatorChar = c;
    }
}
