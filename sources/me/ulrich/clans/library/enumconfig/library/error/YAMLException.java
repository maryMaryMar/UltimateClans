package me.ulrich.clans.library.enumconfig.library.error;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/error/YAMLException.class */
public class YAMLException extends RuntimeException {
    private static final long serialVersionUID = -4738336175050337570L;

    public YAMLException(String str) {
        super(str);
    }

    public YAMLException(Throwable th) {
        super(th);
    }

    public YAMLException(String str, Throwable th) {
        super(str, th);
    }
}
