package me.ulrich.clans.library.enumconfig.library.introspector;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/MissingProperty.class */
public class MissingProperty extends Property {
    public MissingProperty(String str) {
        super(str, Object.class);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        return new Class[0];
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public void set(Object obj, Object obj2) {
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Object get(Object obj) {
        return obj;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public List<Annotation> getAnnotations() {
        return Collections.emptyList();
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return null;
    }
}
