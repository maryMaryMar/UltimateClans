package me.ulrich.clans.library.hikari.util;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.hikari.HikariConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/PropertyElf.class */
public final class PropertyElf {
    private static final char ESCAPE_CHAR = '\\';
    private static final char SEPARATOR_CHAR = ',';
    private static final Pattern DURATION_PATTERN = Pattern.compile("^(?<number>\\d+)(?<unit>ms|s|m|h|d)$");

    private PropertyElf() {
    }

    public static void setTargetFromProperties(Object obj, Properties properties) {
        if (obj == null || properties == null) {
            return;
        }
        List listAsList = Arrays.asList(obj.getClass().getMethods());
        properties.forEach((obj2, obj3) -> {
            String string = obj2.toString();
            if ((obj instanceof HikariConfig) && string.startsWith("dataSource.")) {
                ((HikariConfig) obj).addDataSourceProperty(string.substring("dataSource.".length()), obj3);
            } else {
                setProperty(obj, string, obj3, listAsList);
            }
        });
    }

    public static Set<String> getPropertyNames(Class<?> cls) {
        HashSet hashSet = new HashSet();
        for (Method method : cls.getMethods()) {
            String strPropertyNameFromGetterName = propertyNameFromGetterName(method.getName());
            try {
                if (method.getParameterTypes().length == 0 && strPropertyNameFromGetterName != null) {
                    cls.getMethod("set" + capitalizedPropertyName(strPropertyNameFromGetterName), method.getReturnType());
                    hashSet.add(strPropertyNameFromGetterName);
                }
            } catch (Exception e) {
            }
        }
        return hashSet;
    }

    public static Object getProperty(String str, Object obj) {
        try {
            return obj.getClass().getMethod("get" + capitalizedPropertyName(str), new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e) {
            try {
                return obj.getClass().getMethod("is" + capitalizedPropertyName(str), new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public static Properties copyProperties(Properties properties) {
        Properties properties2 = new Properties();
        properties.forEach((obj, obj2) -> {
            properties2.setProperty(obj.toString(), obj2.toString());
        });
        return properties2;
    }

    private static String propertyNameFromGetterName(String str) {
        String strSubstring = null;
        if (str.startsWith("get") && str.length() > 3) {
            strSubstring = str.substring(3);
        } else if (str.startsWith("is") && str.length() > 2) {
            strSubstring = str.substring(2);
        }
        if (strSubstring != null) {
            return Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
        }
        return null;
    }

    private static void setProperty(Object obj, String str, Object obj2, List<Method> list) {
        Logger logger = LoggerFactory.getLogger((Class<?>) PropertyElf.class);
        String str2 = "set" + str.substring(0, 1).toUpperCase(Locale.ENGLISH) + str.substring(1);
        Method methodOrElse = list.stream().filter(method -> {
            return method.getName().equals(str2) && method.getParameterCount() == 1;
        }).findFirst().orElse(null);
        if (methodOrElse == null) {
            String str3 = "set" + str.toUpperCase(Locale.ENGLISH);
            methodOrElse = list.stream().filter(method2 -> {
                return method2.getName().equals(str3) && method2.getParameterCount() == 1;
            }).findFirst().orElse(null);
        }
        if (methodOrElse == null) {
            logger.error("Property {} does not exist on target {}", str, obj.getClass());
            throw new RuntimeException(String.format("Property %s does not exist on target %s", str, obj.getClass()));
        }
        try {
            Class<?> cls = methodOrElse.getParameterTypes()[0];
            String string = obj2.toString();
            if (cls == Integer.TYPE) {
                methodOrElse.invoke(obj, Integer.valueOf(Integer.parseInt(obj2.toString())));
            } else if (cls == Long.TYPE) {
                methodOrElse.invoke(obj, parseDuration(string).map((v0) -> {
                    return v0.toMillis();
                }).orElseGet(() -> {
                    return Long.valueOf(Long.parseLong(string));
                }));
            } else if (cls == Short.TYPE) {
                methodOrElse.invoke(obj, Short.valueOf(Short.parseShort(string)));
            } else if (cls == Boolean.TYPE || cls == Boolean.class) {
                methodOrElse.invoke(obj, Boolean.valueOf(Boolean.parseBoolean(string)));
            } else if (cls.isArray() && Character.TYPE.isAssignableFrom(cls.getComponentType())) {
                methodOrElse.invoke(obj, string.toCharArray());
            } else if (cls.isArray() && Integer.TYPE.isAssignableFrom(cls.getComponentType())) {
                methodOrElse.invoke(obj, parseIntArray(string));
            } else if (cls.isArray() && String.class.isAssignableFrom(cls.getComponentType())) {
                methodOrElse.invoke(obj, parseStringArray(string));
            } else if (cls == String.class) {
                methodOrElse.invoke(obj, string);
            } else {
                try {
                    logger.debug("Try to create a new instance of \"{}\"", obj2);
                    methodOrElse.invoke(obj, Class.forName(obj2.toString()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException | InstantiationException e) {
                    logger.debug("Class \"{}\" not found or could not instantiate it (Default constructor)", obj2);
                    methodOrElse.invoke(obj, obj2);
                }
            }
        } catch (Exception e2) {
            logger.error("Failed to set property {} on target {}", str, obj.getClass(), e2);
            throw new RuntimeException(e2);
        }
    }

    private static String capitalizedPropertyName(String str) {
        return str.substring(0, 1).toUpperCase(Locale.ENGLISH) + str.substring(1);
    }

    private static int[] parseIntArray(String str) {
        if (str == null || str.isEmpty()) {
            return new int[0];
        }
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            iArr[i] = Integer.parseInt(strArrSplit[i]);
        }
        return iArr;
    }

    private static String[] parseStringArray(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (z) {
                sb.append(c);
                z = false;
            } else if (c == '\\') {
                z = true;
            } else if (c == SEPARATOR_CHAR) {
                arrayList.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (z) {
            throw new IllegalArgumentException(String.format("Unterminated escape sequence in property value: %s", str));
        }
        arrayList.add(sb.toString());
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static Optional<Duration> parseDuration(String str) {
        Matcher matcher = DURATION_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return Optional.empty();
        }
        long j = Long.parseLong(matcher.group("number"));
        String strGroup = matcher.group("unit");
        switch (strGroup) {
            case "ms":
                return Optional.of(Duration.ofMillis(j));
            case "s":
                return Optional.of(Duration.ofSeconds(j));
            case "m":
                return Optional.of(Duration.ofMinutes(j));
            case "h":
                return Optional.of(Duration.ofHours(j));
            case "d":
                return Optional.of(Duration.ofDays(j));
            default:
                throw new IllegalStateException(String.format("Could not match unit, got %s (from given value %s)", strGroup, str));
        }
    }
}
