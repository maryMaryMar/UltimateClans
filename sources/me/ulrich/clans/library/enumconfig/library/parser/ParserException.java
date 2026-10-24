package me.ulrich.clans.library.enumconfig.library.parser;

import me.ulrich.clans.library.enumconfig.library.error.Mark;
import me.ulrich.clans.library.enumconfig.library.error.MarkedYAMLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/parser/ParserException.class */
public class ParserException extends MarkedYAMLException {
    private static final long serialVersionUID = -2349253802798398038L;

    public ParserException(String str, Mark mark, String str2, Mark mark2) {
        super(str, mark, str2, mark2, null, null);
    }
}
