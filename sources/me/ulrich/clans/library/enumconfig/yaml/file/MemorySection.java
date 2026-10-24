package me.ulrich.clans.library.enumconfig.yaml.file;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.enumconfig.yaml.file.interfaces.Configuration;
import me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/file/MemorySection.class */
public class MemorySection implements ConfigurationSection {
    private final Map<String, Object> map = new LinkedHashMap();
    private final Configuration root;
    private final ConfigurationSection parent;
    private final String path;
    private final String fullPath;

    /* JADX WARN: Multi-variable type inference failed */
    MemorySection() {
        if (!(this instanceof Configuration)) {
            throw new IllegalStateException("Cannot construct a root MemorySection when not a Configuration");
        }
        this.path = "";
        this.fullPath = "";
        this.parent = null;
        this.root = (Configuration) this;
    }

    private MemorySection(ConfigurationSection configurationSection, String str) {
        if (configurationSection == null) {
            throw new NullPointerException("Parent cannot be null");
        }
        if (str == null) {
            throw new NullPointerException("Path cannot be null");
        }
        this.path = str;
        this.parent = configurationSection;
        this.root = configurationSection.getRoot();
        if (this.root == null) {
            throw new NullPointerException("Path cannot be orphaned");
        }
        this.fullPath = createPath(configurationSection, str);
    }

    private static String createPath(ConfigurationSection configurationSection, String str) {
        if (configurationSection == null) {
            throw new NullPointerException("Cannot create path without a section");
        }
        return createPath(configurationSection, str, configurationSection.getRoot());
    }

    private static String createPath(ConfigurationSection configurationSection, String str, ConfigurationSection configurationSection2) {
        if (configurationSection == null) {
            throw new NullPointerException("Cannot create path without a section");
        }
        if (configurationSection.getRoot() == null) {
            throw new IllegalStateException("Cannot create path without a root");
        }
        char separatorCharacter = configurationSection.getRoot().getSeparatorCharacter();
        StringBuilder sb = new StringBuilder();
        ConfigurationSection parent = configurationSection;
        while (true) {
            ConfigurationSection configurationSection3 = parent;
            if (configurationSection3 == null || configurationSection3 == configurationSection2) {
                break;
            }
            if (sb.length() > 0) {
                sb.insert(0, separatorCharacter);
            }
            sb.insert(0, configurationSection3.getName());
            parent = configurationSection3.getParent();
        }
        if (str != null && str.length() > 0) {
            if (sb.length() > 0) {
                sb.append(separatorCharacter);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public Set<String> getKeys(boolean z) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        mapChildrenKeys(linkedHashSet, this, z);
        return linkedHashSet;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public LinkedHashMap<String, Object> getValues(boolean z) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        mapChildrenValues(linkedHashMap, this, z);
        return linkedHashMap;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public boolean contains(String str) {
        return get(str) != null;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public boolean isSet(String str) {
        return contains(str);
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public String getCurrentPath() {
        return this.fullPath;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public String getName() {
        return this.path;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public Configuration getRoot() {
        return this.root;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public ConfigurationSection getParent() {
        return this.parent;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public void set(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("Cannot set to an empty path");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Cannot set to an empty path");
        }
        if (getRoot() == null) {
            throw new IllegalStateException("Cannot use section without a root");
        }
        char separatorCharacter = getRoot().getSeparatorCharacter();
        int i = -1;
        ConfigurationSection configurationSectionCreateSection = this;
        while (true) {
            ConfigurationSection configurationSection = configurationSectionCreateSection;
            int i2 = i + 1;
            int iIndexOf = str.indexOf(separatorCharacter, i2);
            i = iIndexOf;
            if (iIndexOf == -1) {
                String strSubstring = str.substring(i2);
                if (configurationSection != this) {
                    configurationSection.set(strSubstring, obj);
                    return;
                } else if (obj == null) {
                    this.map.remove(strSubstring);
                    return;
                } else {
                    this.map.put(strSubstring, obj);
                    return;
                }
            }
            String strSubstring2 = str.substring(i2, i);
            ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(strSubstring2);
            if (configurationSection2 != null) {
                configurationSectionCreateSection = configurationSection2;
            } else if (obj == null) {
                return;
            } else {
                configurationSectionCreateSection = configurationSection.createSection(strSubstring2);
            }
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public Object get(String str) {
        if (str.length() == 0) {
            return this;
        }
        if (getRoot() == null) {
            throw new IllegalStateException("Cannot access section without a root");
        }
        char separatorCharacter = getRoot().getSeparatorCharacter();
        int i = -1;
        ConfigurationSection configurationSection = this;
        do {
            int i2 = i + 1;
            int iIndexOf = str.indexOf(separatorCharacter, i2);
            i = iIndexOf;
            if (iIndexOf == -1) {
                String strSubstring = str.substring(i2);
                return configurationSection == this ? this.map.get(strSubstring) : configurationSection.get(strSubstring);
            }
            configurationSection = configurationSection.getConfigurationSection(str.substring(i2, i));
        } while (configurationSection != null);
        return null;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public ConfigurationSection createSection(String str) {
        ConfigurationSection configurationSection;
        int i;
        if (str == null) {
            throw new NullPointerException("Cannot create section at empty path");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Cannot create section at empty path");
        }
        if (getRoot() == null) {
            throw new IllegalStateException("Cannot create section without a root");
        }
        char separatorCharacter = getRoot().getSeparatorCharacter();
        int i2 = -1;
        ConfigurationSection configurationSectionCreateSection = this;
        while (true) {
            configurationSection = configurationSectionCreateSection;
            i = i2 + 1;
            int iIndexOf = str.indexOf(separatorCharacter, i);
            i2 = iIndexOf;
            if (iIndexOf == -1) {
                break;
            }
            String strSubstring = str.substring(i, i2);
            ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(strSubstring);
            configurationSectionCreateSection = configurationSection2 == null ? configurationSection.createSection(strSubstring) : configurationSection2;
        }
        String strSubstring2 = str.substring(i);
        if (configurationSection != this) {
            return configurationSection.createSection(strSubstring2);
        }
        MemorySection memorySection = new MemorySection(this, strSubstring2);
        this.map.put(strSubstring2, memorySection);
        return memorySection;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public ConfigurationSection createSection(String str, LinkedHashMap<String, Object> linkedHashMap) {
        ConfigurationSection configurationSectionCreateSection = createSection(str);
        for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
            if (entry.getValue() instanceof LinkedHashMap) {
                configurationSectionCreateSection.createSection(entry.getKey(), (LinkedHashMap) entry.getValue());
            } else {
                configurationSectionCreateSection.set(entry.getKey(), entry.getValue());
            }
        }
        return configurationSectionCreateSection;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public ConfigurationSection getConfigurationSection(String str) {
        Object obj = get(str);
        if (obj instanceof ConfigurationSection) {
            return (ConfigurationSection) obj;
        }
        return null;
    }

    @Override // me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection
    public boolean isConfigurationSection(String str) {
        return get(str) instanceof ConfigurationSection;
    }

    private void mapChildrenKeys(Set<String> set, ConfigurationSection configurationSection, boolean z) {
        if (!(configurationSection instanceof MemorySection)) {
            Iterator<String> it = configurationSection.getKeys(z).iterator();
            while (it.hasNext()) {
                set.add(createPath(configurationSection, it.next(), this));
            }
            return;
        }
        for (Map.Entry<String, Object> entry : ((MemorySection) configurationSection).map.entrySet()) {
            set.add(createPath(configurationSection, entry.getKey(), this));
            if (z && (entry.getValue() instanceof ConfigurationSection)) {
                mapChildrenKeys(set, (ConfigurationSection) entry.getValue(), z);
            }
        }
    }

    private void mapChildrenValues(Map<String, Object> map, ConfigurationSection configurationSection, boolean z) {
        if (!(configurationSection instanceof MemorySection)) {
            for (Map.Entry<String, Object> entry : configurationSection.getValues(z).entrySet()) {
                map.put(createPath(configurationSection, entry.getKey(), this), entry.getValue());
            }
            return;
        }
        for (Map.Entry<String, Object> entry2 : ((MemorySection) configurationSection).map.entrySet()) {
            map.put(createPath(configurationSection, entry2.getKey(), this), entry2.getValue());
            if ((entry2.getValue() instanceof ConfigurationSection) && z) {
                mapChildrenValues(map, (ConfigurationSection) entry2.getValue(), z);
            }
        }
    }
}
