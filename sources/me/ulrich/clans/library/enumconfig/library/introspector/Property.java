package me.ulrich.clans.library.enumconfig.library.introspector;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/Property.class */
public abstract class Property implements Comparable<Property> {
    private final String name;
    private final Class<?> type;

    public Property(String str, Class<?> cls) {
        this.name = str;
        this.type = cls;
    }

    public Class<?> getType() {
        return this.type;
    }

    public abstract Class<?>[] getActualTypeArguments();

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName() + " of " + getType();
    }

    @Override // java.lang.Comparable
    public int compareTo(Property property) {
        return getName().compareTo(property.getName());
    }

    public boolean isWritable() {
        return true;
    }

    public boolean isReadable() {
        return true;
    }

    public abstract void set(Object obj, Object obj2);

    public abstract Object get(Object obj);

    public abstract List<Annotation> getAnnotations();

    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    public int hashCode() {
        return getName().hashCode() + getType().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Property)) {
            return false;
        }
        Property property = (Property) obj;
        return getName().equals(property.getName()) && getType().equals(property.getType());
    }
}
