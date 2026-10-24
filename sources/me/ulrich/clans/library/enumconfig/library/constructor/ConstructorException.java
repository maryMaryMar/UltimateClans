package me.ulrich.clans.library.enumconfig.library.constructor;

import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.MarkedYAMLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/ConstructorException.class */
public class ConstructorException extends MarkedYAMLException {
    private static final long serialVersionUID = -8816339931365239910L;

    protected ConstructorException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        super(str, mark, str2, mark2, th);
    }

    protected ConstructorException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null);
    }
}
