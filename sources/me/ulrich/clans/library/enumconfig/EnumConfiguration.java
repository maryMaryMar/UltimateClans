package me.ulrich.clans.library.enumconfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;
import me.ulrich.clans.library.enumconfig.yaml.EnumConfigurationDumperOptions;
import me.ulrich.clans.library.enumconfig.yaml.file.YAMLConfiguration;
import me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/EnumConfiguration.class */
public class EnumConfiguration {
    private YAMLConfiguration configuration;
    private YAMLConfiguration oldConfiguration;
    private List<ConfigurationEnum> configurationEnums;
    private String pluginTag;

    EnumConfiguration(String str, File file, List<ConfigurationEnum> list, EnumConfigurationDumperOptions enumConfigurationDumperOptions) {
        try {
            if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) {
                throw new IOException("Parent folder was a file, not directory");
            }
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException("File couldn't be created");
            }
            this.pluginTag = str;
            this.oldConfiguration = new YAMLConfiguration(file, enumConfigurationDumperOptions);
            try {
                this.oldConfiguration.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.configurationEnums = list;
            this.configuration = new YAMLConfiguration(file, enumConfigurationDumperOptions);
            buildConfig();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void buildConfig() {
        for (ConfigurationEnum configurationEnum : this.configurationEnums) {
            if (configurationEnum.getComments().length > 0) {
                this.configuration.setComments(configurationEnum.getPath(), configurationEnum.getComments());
            }
            if (this.oldConfiguration.get(configurationEnum.getPath()) != null) {
                this.configuration.set(configurationEnum.getPath(), this.oldConfiguration.get(configurationEnum.getPath()));
            } else {
                this.configuration.set(configurationEnum.getPath(), configurationEnum.getDefaultValue());
            }
        }
        try {
            this.configuration.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void set(ConfigurationEnum configurationEnum, Object obj) {
        this.configuration.set(configurationEnum.getPath(), obj);
        try {
            this.configuration.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YAMLConfiguration getYaml() {
        return this.configuration;
    }

    public Object get(ConfigurationEnum configurationEnum) {
        return this.configuration.get(configurationEnum.getPath());
    }

    public String getString(ConfigurationEnum configurationEnum) {
        return fingArgs(get(configurationEnum).toString(), null);
    }

    public String getString(ConfigurationEnum configurationEnum, List<String> list) {
        return fingArgs(get(configurationEnum).toString(), list);
    }

    public String fingArgs(String str, List<String> list) {
        String strReplace = str.replace("%tag%", getPluginTag());
        if (list != null && list.size() != 0) {
            for (String str2 : list) {
                if (str2 != null && !str2.isEmpty()) {
                    String[] strArrSplit = str2.split(";");
                    strReplace = strReplace.replace(strArrSplit[0], strArrSplit[1]);
                }
            }
            return strReplace;
        }
        return strReplace;
    }

    public boolean isString(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof String;
    }

    public int getInteger(ConfigurationEnum configurationEnum) {
        return ((Integer) get(configurationEnum)).intValue();
    }

    public boolean isInteger(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof Integer;
    }

    public boolean getBoolean(ConfigurationEnum configurationEnum) {
        return ((Boolean) get(configurationEnum)).booleanValue();
    }

    public boolean isBoolean(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof Boolean;
    }

    public double getDouble(ConfigurationEnum configurationEnum) {
        return ((Double) get(configurationEnum)).doubleValue();
    }

    public boolean isDouble(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof Double;
    }

    public long getLong(ConfigurationEnum configurationEnum) {
        return ((Long) get(configurationEnum)).longValue();
    }

    public boolean isLong(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof Long;
    }

    public ConfigurationSection getConfigurationSection(ConfigurationEnum configurationEnum) {
        return (ConfigurationSection) get(configurationEnum);
    }

    public boolean isConfigurationSection(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof ConfigurationSection;
    }

    public List<?> getList(ConfigurationEnum configurationEnum) {
        return (List) get(configurationEnum);
    }

    public boolean isList(ConfigurationEnum configurationEnum) {
        return get(configurationEnum) instanceof List;
    }

    public List<String> getStringList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof String) {
                arrayList.add(fingArgs(String.valueOf(obj), null));
            }
        }
        return arrayList;
    }

    public List<String> getStringList(ConfigurationEnum configurationEnum, List<String> list) {
        List<?> list2 = getList(configurationEnum);
        if (list2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (obj instanceof String) {
                arrayList.add(fingArgs(String.valueOf(obj), list));
            }
        }
        return arrayList;
    }

    public List<Integer> getIntegerList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                arrayList.add((Integer) obj);
            } else if (obj instanceof String) {
                try {
                    arrayList.add(Integer.valueOf((String) obj));
                } catch (Exception e) {
                }
            } else if (obj instanceof Character) {
                arrayList.add(Integer.valueOf(((Character) obj).charValue()));
            } else if (obj instanceof Number) {
                arrayList.add(Integer.valueOf(((Number) obj).intValue()));
            }
        }
        return arrayList;
    }

    public List<Boolean> getBooleanList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Boolean) {
                arrayList.add((Boolean) obj);
            } else if (obj instanceof String) {
                if (Boolean.TRUE.toString().equals(obj)) {
                    arrayList.add(true);
                } else if (Boolean.FALSE.toString().equals(obj)) {
                    arrayList.add(false);
                }
            }
        }
        return arrayList;
    }

    public List<Double> getDoubleList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Double) {
                arrayList.add((Double) obj);
            } else if (obj instanceof String) {
                try {
                    arrayList.add(Double.valueOf((String) obj));
                } catch (Exception e) {
                }
            } else if (obj instanceof Character) {
                arrayList.add(Double.valueOf(((Character) obj).charValue()));
            } else if (obj instanceof Number) {
                arrayList.add(Double.valueOf(((Number) obj).doubleValue()));
            }
        }
        return arrayList;
    }

    public List<Float> getFloatList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Float) {
                arrayList.add((Float) obj);
            } else if (obj instanceof String) {
                try {
                    arrayList.add(Float.valueOf((String) obj));
                } catch (Exception e) {
                }
            } else if (obj instanceof Character) {
                arrayList.add(Float.valueOf(((Character) obj).charValue()));
            } else if (obj instanceof Number) {
                arrayList.add(Float.valueOf(((Number) obj).floatValue()));
            }
        }
        return arrayList;
    }

    public List<Long> getLongList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Long) {
                arrayList.add((Long) obj);
            } else if (obj instanceof String) {
                try {
                    arrayList.add(Long.valueOf((String) obj));
                } catch (Exception e) {
                }
            } else if (obj instanceof Character) {
                arrayList.add(Long.valueOf(((Character) obj).charValue()));
            } else if (obj instanceof Number) {
                arrayList.add(Long.valueOf(((Number) obj).longValue()));
            }
        }
        return arrayList;
    }

    public List<Byte> getByteList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Byte) {
                arrayList.add((Byte) obj);
            } else if (obj instanceof String) {
                try {
                    arrayList.add(Byte.valueOf((String) obj));
                } catch (Exception e) {
                }
            } else if (obj instanceof Character) {
                arrayList.add(Byte.valueOf((byte) ((Character) obj).charValue()));
            } else if (obj instanceof Number) {
                arrayList.add(Byte.valueOf(((Number) obj).byteValue()));
            }
        }
        return arrayList;
    }

    public List<Character> getCharacterList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Character) {
                arrayList.add((Character) obj);
            } else if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 1) {
                    arrayList.add(Character.valueOf(str.charAt(0)));
                }
            } else if (obj instanceof Number) {
                arrayList.add(Character.valueOf((char) ((Number) obj).intValue()));
            }
        }
        return arrayList;
    }

    public List<Short> getShortList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Short) {
                arrayList.add((Short) obj);
            } else if (obj instanceof String) {
                try {
                    arrayList.add(Short.valueOf((String) obj));
                } catch (Exception e) {
                }
            } else if (obj instanceof Character) {
                arrayList.add(Short.valueOf((short) ((Character) obj).charValue()));
            } else if (obj instanceof Number) {
                arrayList.add(Short.valueOf(((Number) obj).shortValue()));
            }
        }
        return arrayList;
    }

    public List<Map<?, ?>> getMapList(ConfigurationEnum configurationEnum) {
        List<?> list = getList(configurationEnum);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (Object obj : list) {
            if (obj instanceof Map) {
                arrayList.add((Map) obj);
            }
        }
        return arrayList;
    }

    public void addConfigurationEnumeration(ConfigurationEnum[] configurationEnumArr) {
        ArrayList arrayList = new ArrayList();
        for (ConfigurationEnum configurationEnum : configurationEnumArr) {
            for (ConfigurationEnum configurationEnum2 : this.configurationEnums) {
                if (configurationEnum.equals(configurationEnum2)) {
                    throw new IllegalArgumentException("You cannot add identical ConfigurationEnums!");
                }
                if (configurationEnum.getPath().equalsIgnoreCase(configurationEnum2.getPath())) {
                    throw new IllegalArgumentException("You cannot add two ConfigurationEnums with the same path!");
                }
                arrayList.add(configurationEnum);
            }
        }
        this.configurationEnums.addAll(arrayList);
        buildConfig();
    }

    public String getPluginTag() {
        return this.pluginTag;
    }
}
