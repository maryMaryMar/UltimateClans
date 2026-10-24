package me.ulrich.clans.library.enumconfig.library.introspector;

import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.util.ArrayUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/MethodProperty.class */
public class MethodProperty extends GenericProperty {
    private final PropertyDescriptor property;
    private final boolean readable;
    private final boolean writable;
    private static final String TRANSIENT = "transient";

    private static Type discoverGenericType(PropertyDescriptor propertyDescriptor) {
        Method readMethod = propertyDescriptor.getReadMethod();
        if (readMethod != null) {
            return readMethod.getGenericReturnType();
        }
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            return null;
        }
        Type[] genericParameterTypes = writeMethod.getGenericParameterTypes();
        if (genericParameterTypes.length > 0) {
            return genericParameterTypes[0];
        }
        return null;
    }

    public MethodProperty(PropertyDescriptor propertyDescriptor) {
        super(propertyDescriptor.getName(), propertyDescriptor.getPropertyType(), discoverGenericType(propertyDescriptor));
        this.property = propertyDescriptor;
        this.readable = propertyDescriptor.getReadMethod() != null;
        this.writable = propertyDescriptor.getWriteMethod() != null;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (!this.writable) {
            throw new YAMLException("No writable property '" + getName() + "' on class: " + obj.getClass().getName());
        }
        this.property.getWriteMethod().invoke(obj, obj2);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Object get(Object obj) {
        try {
            this.property.getReadMethod().setAccessible(true);
            return this.property.getReadMethod().invoke(obj, new Object[0]);
        } catch (Exception e) {
            throw new YAMLException("Unable to find getter for property '" + this.property.getName() + "' on object " + obj + ":" + e);
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public List<Annotation> getAnnotations() {
        List<Annotation> unmodifiableList;
        if (isReadable() && isWritable()) {
            unmodifiableList = ArrayUtils.toUnmodifiableCompositeList(this.property.getReadMethod().getAnnotations(), this.property.getWriteMethod().getAnnotations());
        } else {
            unmodifiableList = isReadable() ? ArrayUtils.toUnmodifiableList(this.property.getReadMethod().getAnnotations()) : ArrayUtils.toUnmodifiableList(this.property.getWriteMethod().getAnnotations());
        }
        return unmodifiableList;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Annotation annotation = null;
        if (isReadable()) {
            annotation = this.property.getReadMethod().getAnnotation(cls);
        }
        if (annotation == null && isWritable()) {
            annotation = this.property.getWriteMethod().getAnnotation(cls);
        }
        return (A) annotation;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public boolean isWritable() {
        return this.writable;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public boolean isReadable() {
        return this.readable;
    }

    private static boolean isTransient(FeatureDescriptor featureDescriptor) {
        return Boolean.TRUE.equals(featureDescriptor.getValue(TRANSIENT));
    }

    static boolean addPublicFields(Class<?> cls, Map<String, Property> map) {
        boolean z = false;
        try {
            for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(cls).getPropertyDescriptors()) {
                Method readMethod = propertyDescriptor.getReadMethod();
                if ((readMethod == null || !readMethod.getName().equals("getClass")) && !isTransient(propertyDescriptor)) {
                    map.put(propertyDescriptor.getName(), new MethodProperty(propertyDescriptor));
                }
            }
            Class<?> superclass = cls;
            while (true) {
                Class<?> cls2 = superclass;
                if (cls2 == null) {
                    return z;
                }
                for (Field field : cls2.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                        if (Modifier.isPublic(modifiers)) {
                            map.put(field.getName(), new FieldProperty(field));
                        } else {
                            z = true;
                        }
                    }
                }
                superclass = cls2.getSuperclass();
            }
        } catch (IntrospectionException e) {
            throw new YAMLException((Throwable) e);
        }
    }
}
