package me.ulrich.clans.library.enumconfig.library.introspector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.util.ArrayUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/FieldProperty.class */
public class FieldProperty extends GenericProperty {
    private final Field field;

    public FieldProperty(Field field) {
        super(field.getName(), field.getType(), field.getGenericType());
        this.field = field;
        field.setAccessible(true);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public void set(Object obj, Object obj2) throws IllegalAccessException {
        this.field.set(obj, obj2);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Object get(Object obj) {
        try {
            return this.field.get(obj);
        } catch (Exception e) {
            throw new YAMLException("Unable to access field " + this.field.getName() + " on object " + obj + " : " + e);
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public List<Annotation> getAnnotations() {
        return ArrayUtils.toUnmodifiableList(this.field.getAnnotations());
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.field.getAnnotation(cls);
    }
}
