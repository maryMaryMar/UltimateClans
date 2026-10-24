package me.ulrich.clans.library.enumconfig.library.extensions.compactnotation;

import me.ulrich.clans.library.enumconfig.library.LoaderOptions;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/extensions/compactnotation/PackageCompactConstructor.class */
public class PackageCompactConstructor extends CompactConstructor {
    private final String packageName;

    public PackageCompactConstructor(String str) {
        super(new LoaderOptions());
        this.packageName = str;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.constructor.Constructor
    protected Class<?> getClassForName(String str) {
        if (str.indexOf(46) < 0) {
            try {
                return Class.forName(this.packageName + "." + str);
            } catch (ClassNotFoundException e) {
            }
        }
        return super.getClassForName(str);
    }
}
