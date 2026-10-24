package me.ulrich.clans.library.enumconfig.library.composer;

import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.MarkedYAMLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/composer/ComposerException.class */
public class ComposerException extends MarkedYAMLException {
    private static final long serialVersionUID = 2146314636913113935L;

    protected ComposerException(String str, Mark mark, String str2, Mark mark2) {
        super(str, mark, str2, mark2);
    }

    protected ComposerException(String str, Mark mark) {
        this(null, null, str, mark);
    }
}
