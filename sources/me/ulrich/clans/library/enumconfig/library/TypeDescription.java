package me.ulrich.clans.library.enumconfig.library;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.internal.Logger;
import me.ulrich.clans.library.enumconfig.library.introspector.BeanAccess;
import me.ulrich.clans.library.enumconfig.library.introspector.Property;
import me.ulrich.clans.library.enumconfig.library.introspector.PropertySubstitute;
import me.ulrich.clans.library.enumconfig.library.introspector.PropertyUtils;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/TypeDescription.class */
public class TypeDescription {
    private static final Logger log = Logger.getLogger(TypeDescription.class.getPackage().getName());
    private final Class<? extends Object> type;
    private Class<?> impl;
    private final Tag tag;
    private transient Set<Property> dumpProperties;
    private transient PropertyUtils propertyUtils;
    private transient boolean delegatesChecked;
    private Map<String, PropertySubstitute> properties;
    protected Set<String> excludes;
    protected String[] includes;
    protected BeanAccess beanAccess;

    public TypeDescription(Class<? extends Object> cls, Tag tag) {
        this(cls, tag, null);
    }

    public TypeDescription(Class<? extends Object> cls, Tag tag, Class<?> cls2) {
        this.properties = Collections.emptyMap();
        this.excludes = Collections.emptySet();
        this.includes = null;
        this.type = cls;
        this.tag = tag;
        this.impl = cls2;
        this.beanAccess = null;
    }

    public TypeDescription(Class<? extends Object> cls, String str) {
        this(cls, new Tag(str), null);
    }

    public TypeDescription(Class<? extends Object> cls) {
        this(cls, new Tag(cls), null);
    }

    public TypeDescription(Class<? extends Object> cls, Class<?> cls2) {
        this(cls, new Tag(cls), cls2);
    }

    public Tag getTag() {
        return this.tag;
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    @Deprecated
    public void putListPropertyType(String str, Class<? extends Object> cls) {
        addPropertyParameters(str, cls);
    }

    @Deprecated
    public void putMapPropertyType(String str, Class<? extends Object> cls, Class<? extends Object> cls2) {
        addPropertyParameters(str, cls, cls2);
    }

    public void addPropertyParameters(String str, Class<?>... clsArr) {
        if (this.properties.containsKey(str)) {
            this.properties.get(str).setActualTypeArguments(clsArr);
        } else {
            substituteProperty(str, null, null, null, clsArr);
        }
    }

    public String toString() {
        return "TypeDescription for " + getType() + " (tag='" + getTag() + "')";
    }

    private void checkDelegates() {
        for (PropertySubstitute propertySubstitute : this.properties.values()) {
            try {
                propertySubstitute.setDelegate(discoverProperty(propertySubstitute.getName()));
            } catch (YAMLException e) {
            }
        }
        this.delegatesChecked = true;
    }

    private Property discoverProperty(String str) {
        if (this.propertyUtils != null) {
            return this.beanAccess == null ? this.propertyUtils.getProperty(this.type, str) : this.propertyUtils.getProperty(this.type, str, this.beanAccess);
        }
        return null;
    }

    public Property getProperty(String str) {
        if (!this.delegatesChecked) {
            checkDelegates();
        }
        return this.properties.containsKey(str) ? this.properties.get(str) : discoverProperty(str);
    }

    public void substituteProperty(String str, Class<?> cls, String str2, String str3, Class<?>... clsArr) {
        substituteProperty(new PropertySubstitute(str, cls, str2, str3, clsArr));
    }

    public void substituteProperty(PropertySubstitute propertySubstitute) {
        if (Collections.EMPTY_MAP == this.properties) {
            this.properties = new LinkedHashMap();
        }
        propertySubstitute.setTargetType(this.type);
        this.properties.put(propertySubstitute.getName(), propertySubstitute);
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
    }

    public void setIncludes(String... strArr) {
        this.includes = (strArr == null || strArr.length <= 0) ? null : strArr;
    }

    public void setExcludes(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            this.excludes = Collections.emptySet();
        } else {
            this.excludes = new HashSet();
            Collections.addAll(this.excludes, strArr);
        }
    }

    public Set<Property> getProperties() {
        if (this.dumpProperties != null) {
            return this.dumpProperties;
        }
        if (this.propertyUtils == null) {
            return null;
        }
        if (this.includes != null) {
            this.dumpProperties = new LinkedHashSet();
            for (String str : this.includes) {
                if (!this.excludes.contains(str)) {
                    this.dumpProperties.add(getProperty(str));
                }
            }
            return this.dumpProperties;
        }
        Set<Property> properties = this.beanAccess == null ? this.propertyUtils.getProperties(this.type) : this.propertyUtils.getProperties(this.type, this.beanAccess);
        if (this.properties.isEmpty()) {
            if (this.excludes.isEmpty()) {
                this.dumpProperties = properties;
                return properties;
            }
            this.dumpProperties = new LinkedHashSet();
            for (Property property : properties) {
                if (!this.excludes.contains(property.getName())) {
                    this.dumpProperties.add(property);
                }
            }
            return this.dumpProperties;
        }
        if (!this.delegatesChecked) {
            checkDelegates();
        }
        this.dumpProperties = new LinkedHashSet();
        for (PropertySubstitute propertySubstitute : this.properties.values()) {
            if (!this.excludes.contains(propertySubstitute.getName()) && propertySubstitute.isReadable()) {
                this.dumpProperties.add(propertySubstitute);
            }
        }
        for (Property property2 : properties) {
            if (!this.excludes.contains(property2.getName())) {
                this.dumpProperties.add(property2);
            }
        }
        return this.dumpProperties;
    }

    public boolean setupPropertyType(String str, Node node) {
        return false;
    }

    public boolean setProperty(Object obj, String str, Object obj2) {
        return false;
    }

    public Object newInstance(Node node) {
        if (this.impl == null) {
            return null;
        }
        try {
            Constructor<?> declaredConstructor = this.impl.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
            this.impl = null;
            return null;
        }
    }

    public Object newInstance(String str, Node node) {
        return null;
    }

    public Object finalizeConstruction(Object obj) {
        return obj;
    }
}
