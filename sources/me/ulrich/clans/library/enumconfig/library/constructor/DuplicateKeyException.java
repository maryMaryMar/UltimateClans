package me.ulrich.clans.library.enumconfig.library.constructor;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/DuplicateKeyException.class */
public class DuplicateKeyException extends ConstructorException {
    protected DuplicateKeyException(Mark mark, Object obj, Mark mark2) {
        super("while constructing a mapping", mark, "found duplicate key " + obj, mark2);
    }
}
