package me.ulrich.clans.library.enumconfig.library.scanner;

import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.MarkedYAMLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/scanner/ScannerException.class */
public class ScannerException extends MarkedYAMLException {
    private static final long serialVersionUID = 4782293188600445954L;

    public ScannerException(String str, Mark mark, String str2, Mark mark2, String str3) {
        super(str, mark, str2, mark2, str3);
    }

    public ScannerException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null);
    }
}
