package me.ulrich.clans.library.enumconfig.library.introspector;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/introspector/GenericProperty.class */
public abstract class GenericProperty extends Property {
    private final Type genType;
    private boolean actualClassesChecked;
    private Class<?>[] actualClasses;

    public GenericProperty(String str, Class<?> cls, Type type) {
        super(str, cls);
        this.genType = type;
        this.actualClassesChecked = type == null;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        if (!this.actualClassesChecked) {
            if (this.genType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) this.genType).getActualTypeArguments();
                if (actualTypeArguments.length > 0) {
                    this.actualClasses = new Class[actualTypeArguments.length];
                    for (int i = 0; i < actualTypeArguments.length; i++) {
                        if (actualTypeArguments[i] instanceof Class) {
                            this.actualClasses[i] = (Class) actualTypeArguments[i];
                        } else if (!(actualTypeArguments[i] instanceof ParameterizedType)) {
                            if (!(actualTypeArguments[i] instanceof GenericArrayType)) {
                                this.actualClasses = null;
                                break;
                            }
                            Type genericComponentType = ((GenericArrayType) actualTypeArguments[i]).getGenericComponentType();
                            if (!(genericComponentType instanceof Class)) {
                                this.actualClasses = null;
                                break;
                            }
                            this.actualClasses[i] = Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                        } else {
                            this.actualClasses[i] = (Class) ((ParameterizedType) actualTypeArguments[i]).getRawType();
                        }
                    }
                }
            } else if (this.genType instanceof GenericArrayType) {
                Type genericComponentType2 = ((GenericArrayType) this.genType).getGenericComponentType();
                if (genericComponentType2 instanceof Class) {
                    this.actualClasses = new Class[]{(Class) genericComponentType2};
                }
            } else if ((this.genType instanceof Class) && ((Class) this.genType).isArray()) {
                this.actualClasses = new Class[1];
                this.actualClasses[0] = getType().getComponentType();
            }
            this.actualClassesChecked = true;
        }
        return this.actualClasses;
    }
}
