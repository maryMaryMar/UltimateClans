package me.ulrich.clans.library.enumconfig;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.yaml.EnumConfigurationDumperOptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/EnumConfigurationBuilder.class */
public class EnumConfigurationBuilder {
    private File file;
    private List<ConfigurationEnum> configurationEnums;
    private EnumConfigurationDumperOptions dumperOptions;

    public <T extends Enum<T> & ConfigurationEnum> EnumConfigurationBuilder(File file, Class<T> cls) {
        this.dumperOptions = new EnumConfigurationDumperOptions();
        if (cls == null) {
            throw new IllegalArgumentException("EnumClass is Null!");
        }
        this.file = file;
        this.configurationEnums = new ArrayList(Arrays.asList((Enum[]) cls.getEnumConstants()));
    }

    EnumConfigurationBuilder(File file, List<ConfigurationEnum> list, EnumConfigurationDumperOptions enumConfigurationDumperOptions) {
        this.dumperOptions = new EnumConfigurationDumperOptions();
        this.file = file;
        this.configurationEnums = list;
        this.dumperOptions = enumConfigurationDumperOptions;
    }

    public EnumConfigurationBuilder setWidth(int i) {
        this.dumperOptions.setWidth(i);
        return this;
    }

    public EnumConfigurationBuilder setIndentation(int i) {
        if (i < 2 || i > 9) {
            throw new IllegalArgumentException("Indentation cannot be smaller than 2 or larger than 9");
        }
        this.dumperOptions.setIndent(i);
        return this;
    }

    public EnumConfigurationBuilder setIndicatorIndentation(int i) {
        this.dumperOptions.setIndicatorIndent(i);
        return this;
    }

    public EnumConfigurationBuilder setLineBreak(DumperOptions.LineBreak lineBreak) {
        this.dumperOptions.setLineBreak(lineBreak);
        return this;
    }

    public EnumConfigurationBuilder setSeparatorCharacter(char c) {
        this.dumperOptions.setSeparatorChar(c);
        return this;
    }

    public EnumConfigurationBuilder addConfigurationEnumeration(ConfigurationEnum... configurationEnumArr) {
        for (ConfigurationEnum configurationEnum : configurationEnumArr) {
            for (ConfigurationEnum configurationEnum2 : this.configurationEnums) {
                if (configurationEnum.equals(configurationEnum2)) {
                    throw new IllegalArgumentException("You cannot add identical ConfigurationEnums!");
                }
                if (configurationEnum.getPath().equalsIgnoreCase(configurationEnum2.getPath())) {
                    throw new IllegalArgumentException("You cannot add two ConfigurationEnums with the same path!");
                }
                this.configurationEnums.add(configurationEnum);
            }
        }
        return this;
    }

    public EnumConfiguration build(String str) {
        return new EnumConfiguration(str, this.file, this.configurationEnums, this.dumperOptions);
    }
}
