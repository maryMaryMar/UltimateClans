package me.ulrich.clans.library.enumconfig.library.introspector;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.util.PlatformFeatureDetector;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/PropertyUtils.class */
public class PropertyUtils {
    private final Map<Class<?>, Map<String, Property>> propertiesCache;
    private final Map<Class<?>, Set<Property>> readableProperties;
    private BeanAccess beanAccess;
    private boolean allowReadOnlyProperties;
    private boolean skipMissingProperties;
    private final PlatformFeatureDetector platformFeatureDetector;

    public PropertyUtils() {
        this(new PlatformFeatureDetector());
    }

    PropertyUtils(PlatformFeatureDetector platformFeatureDetector) {
        this.propertiesCache = new HashMap();
        this.readableProperties = new HashMap();
        this.beanAccess = BeanAccess.DEFAULT;
        this.allowReadOnlyProperties = false;
        this.skipMissingProperties = false;
        this.platformFeatureDetector = platformFeatureDetector;
        if (platformFeatureDetector.isIntrospectionAvailable()) {
            return;
        }
        this.beanAccess = BeanAccess.FIELD;
    }

    protected Map<String, Property> getPropertiesMap(Class<?> cls, BeanAccess beanAccess) {
        if (this.propertiesCache.containsKey(cls)) {
            return this.propertiesCache.get(cls);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zAddPublicFields = false;
        if (beanAccess == BeanAccess.FIELD) {
            Class<?> superclass = cls;
            while (true) {
                Class<?> cls2 = superclass;
                if (cls2 == null) {
                    break;
                }
                for (Field field : cls2.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && !linkedHashMap.containsKey(field.getName())) {
                        linkedHashMap.put(field.getName(), new FieldProperty(field));
                    }
                }
                superclass = cls2.getSuperclass();
            }
        } else {
            zAddPublicFields = MethodProperty.addPublicFields(cls, linkedHashMap);
        }
        if (linkedHashMap.isEmpty() && zAddPublicFields) {
            throw new YAMLException("No JavaBean properties found in " + cls.getName());
        }
        this.propertiesCache.put(cls, linkedHashMap);
        return linkedHashMap;
    }

    public Set<Property> getProperties(Class<? extends Object> cls) {
        return getProperties(cls, this.beanAccess);
    }

    public Set<Property> getProperties(Class<? extends Object> cls, BeanAccess beanAccess) {
        if (this.readableProperties.containsKey(cls)) {
            return this.readableProperties.get(cls);
        }
        Set<Property> setCreatePropertySet = createPropertySet(cls, beanAccess);
        this.readableProperties.put(cls, setCreatePropertySet);
        return setCreatePropertySet;
    }

    protected Set<Property> createPropertySet(Class<? extends Object> cls, BeanAccess beanAccess) {
        TreeSet treeSet = new TreeSet();
        for (Property property : getPropertiesMap(cls, beanAccess).values()) {
            if (property.isReadable() && (this.allowReadOnlyProperties || property.isWritable())) {
                treeSet.add(property);
            }
        }
        return treeSet;
    }

    public Property getProperty(Class<? extends Object> cls, String str) {
        return getProperty(cls, str, this.beanAccess);
    }

    public Property getProperty(Class<? extends Object> cls, String str, BeanAccess beanAccess) {
        Property missingProperty = getPropertiesMap(cls, beanAccess).get(str);
        if (missingProperty == null && this.skipMissingProperties) {
            missingProperty = new MissingProperty(str);
        }
        if (missingProperty == null) {
            throw new YAMLException("Unable to find property '" + str + "' on class: " + cls.getName());
        }
        return missingProperty;
    }

    public void setBeanAccess(BeanAccess beanAccess) {
        if (this.platformFeatureDetector.isRunningOnAndroid() && beanAccess != BeanAccess.FIELD) {
            throw new IllegalArgumentException("JVM is Android - only BeanAccess.FIELD is available");
        }
        if (this.beanAccess != beanAccess) {
            this.beanAccess = beanAccess;
            this.propertiesCache.clear();
            this.readableProperties.clear();
        }
    }

    public void setAllowReadOnlyProperties(boolean z) {
        if (this.allowReadOnlyProperties != z) {
            this.allowReadOnlyProperties = z;
            this.readableProperties.clear();
        }
    }

    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }

    public void setSkipMissingProperties(boolean z) {
        if (this.skipMissingProperties != z) {
            this.skipMissingProperties = z;
            this.readableProperties.clear();
        }
    }

    public boolean isSkipMissingProperties() {
        return this.skipMissingProperties;
    }
}
