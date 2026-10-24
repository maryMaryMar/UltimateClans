package me.ulrich.clans.library.enumconfig.yaml.file.interfaces;

import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/file/interfaces/ConfigurationSection.class */
public interface ConfigurationSection {
    Set<String> getKeys(boolean z);

    LinkedHashMap<String, Object> getValues(boolean z);

    boolean contains(String str);

    boolean isSet(String str);

    String getCurrentPath();

    String getName();

    Configuration getRoot();

    ConfigurationSection getParent();

    Object get(String str);

    void set(String str, Object obj);

    ConfigurationSection createSection(String str);

    ConfigurationSection createSection(String str, LinkedHashMap<String, Object> linkedHashMap);

    ConfigurationSection getConfigurationSection(String str);

    boolean isConfigurationSection(String str);
}
