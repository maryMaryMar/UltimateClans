package me.ulrich.clans.library.enumconfig.library.constructor;

import me.ulrich.clans.library.enumconfig.library.LoaderOptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/CustomClassLoaderConstructor.class */
public class CustomClassLoaderConstructor extends Constructor {
    private final ClassLoader loader;

    public CustomClassLoaderConstructor(ClassLoader classLoader, LoaderOptions loaderOptions) {
        this(Object.class, classLoader, loaderOptions);
    }

    public CustomClassLoaderConstructor(Class<? extends Object> cls, ClassLoader classLoader, LoaderOptions loaderOptions) {
        super(cls, loaderOptions);
        if (classLoader == null) {
            throw new NullPointerException("Loader must be provided.");
        }
        this.loader = classLoader;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.constructor.Constructor
    protected Class<?> getClassForName(String str) {
        return Class.forName(str, true, this.loader);
    }
}
