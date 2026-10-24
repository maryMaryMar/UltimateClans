package me.ulrich.clans.library.enumconfig.library.introspector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.internal.Logger;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/PropertySubstitute.class */
public class PropertySubstitute extends Property {
    private static final Logger log = Logger.getLogger(PropertySubstitute.class.getPackage().getName());
    protected Class<?> targetType;
    private final String readMethod;
    private final String writeMethod;
    private transient Method read;
    private transient Method write;
    private Field field;
    protected Class<?>[] parameters;
    private Property delegate;
    private boolean filler;

    public PropertySubstitute(String str, Class<?> cls, String str2, String str3, Class<?>... clsArr) {
        super(str, cls);
        this.readMethod = str2;
        this.writeMethod = str3;
        setActualTypeArguments(clsArr);
        this.filler = false;
    }

    public PropertySubstitute(String str, Class<?> cls, Class<?>... clsArr) {
        this(str, cls, null, null, clsArr);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        return (this.parameters != null || this.delegate == null) ? this.parameters : this.delegate.getActualTypeArguments();
    }

    public void setActualTypeArguments(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            this.parameters = null;
        } else {
            this.parameters = clsArr;
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (this.write == null) {
            if (this.field != null) {
                this.field.set(obj, obj2);
                return;
            } else if (this.delegate != null) {
                this.delegate.set(obj, obj2);
                return;
            } else {
                log.warn("No setter/delegate for '" + getName() + "' on object " + obj);
                return;
            }
        }
        if (!this.filler) {
            this.write.invoke(obj, obj2);
            return;
        }
        if (obj2 != null) {
            if (obj2 instanceof Collection) {
                Iterator it = ((Collection) obj2).iterator();
                while (it.hasNext()) {
                    this.write.invoke(obj, it.next());
                }
                return;
            }
            if (obj2 instanceof Map) {
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    this.write.invoke(obj, entry.getKey(), entry.getValue());
                }
                return;
            }
            if (obj2.getClass().isArray()) {
                int length = Array.getLength(obj2);
                for (int i = 0; i < length; i++) {
                    this.write.invoke(obj, Array.get(obj2, i));
                }
            }
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Object get(Object obj) {
        try {
            if (this.read != null) {
                return this.read.invoke(obj, new Object[0]);
            }
            if (this.field != null) {
                return this.field.get(obj);
            }
            if (this.delegate != null) {
                return this.delegate.get(obj);
            }
            throw new YAMLException("No getter or delegate for property '" + getName() + "' on object " + obj);
        } catch (Exception e) {
            throw new YAMLException("Unable to find getter for property '" + getName() + "' on object " + obj + ":" + e);
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public List<Annotation> getAnnotations() {
        Annotation[] annotations = null;
        if (this.read != null) {
            annotations = this.read.getAnnotations();
        } else if (this.field != null) {
            annotations = this.field.getAnnotations();
        }
        return annotations != null ? Arrays.asList(annotations) : this.delegate.getAnnotations();
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Annotation annotation;
        if (this.read != null) {
            annotation = this.read.getAnnotation(cls);
        } else {
            annotation = this.field != null ? this.field.getAnnotation(cls) : this.delegate.getAnnotation(cls);
        }
        return (A) annotation;
    }

    public void setTargetType(Class<?> cls) {
        if (this.targetType != cls) {
            this.targetType = cls;
            String name = getName();
            Class<?> superclass = cls;
            while (true) {
                Class<?> cls2 = superclass;
                if (cls2 == null) {
                    break;
                }
                for (Field field : cls2.getDeclaredFields()) {
                    if (field.getName().equals(name)) {
                        int modifiers = field.getModifiers();
                        if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                            field.setAccessible(true);
                            this.field = field;
                            break;
                        }
                        break;
                    }
                }
                superclass = cls2.getSuperclass();
            }
            if (this.field == null && log.isLoggable(Logger.Level.DEBUG)) {
                log.debug(String.format("Failed to find field for %s.%s", cls.getName(), getName()));
            }
            if (this.readMethod != null) {
                this.read = discoverMethod(cls, this.readMethod, new Class[0]);
            }
            if (this.writeMethod != null) {
                this.filler = false;
                this.write = discoverMethod(cls, this.writeMethod, getType());
                if (this.write != null || this.parameters == null) {
                    return;
                }
                this.filler = true;
                this.write = discoverMethod(cls, this.writeMethod, this.parameters);
            }
        }
    }

    private Method discoverMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Class<?> superclass = cls;
        while (true) {
            Class<?> cls2 = superclass;
            if (cls2 == null) {
                if (!log.isLoggable(Logger.Level.WARNING)) {
                    return null;
                }
                log.warn(String.format("Failed to find [%s(%d args)] for %s.%s", str, Integer.valueOf(clsArr.length), this.targetType.getName(), getName()));
                return null;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != clsArr.length) {
                        continue;
                    } else {
                        boolean z = true;
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (!parameterTypes[i].isAssignableFrom(clsArr[i])) {
                                z = false;
                            }
                        }
                        if (z) {
                            method.setAccessible(true);
                            return method;
                        }
                    }
                }
            }
            superclass = cls2.getSuperclass();
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public String getName() {
        String name = super.getName();
        if (name != null) {
            return name;
        }
        if (this.delegate != null) {
            return this.delegate.getName();
        }
        return null;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Class<?> getType() {
        Class<?> type = super.getType();
        if (type != null) {
            return type;
        }
        if (this.delegate != null) {
            return this.delegate.getType();
        }
        return null;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public boolean isReadable() {
        return (this.read == null && this.field == null && (this.delegate == null || !this.delegate.isReadable())) ? false : true;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public boolean isWritable() {
        return (this.write == null && this.field == null && (this.delegate == null || !this.delegate.isWritable())) ? false : true;
    }

    public void setDelegate(Property property) {
        this.delegate = property;
        if (this.writeMethod == null || this.write != null || this.filler) {
            return;
        }
        this.filler = true;
        this.write = discoverMethod(this.targetType, this.writeMethod, getActualTypeArguments());
    }
}
