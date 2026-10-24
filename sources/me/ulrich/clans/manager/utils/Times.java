package me.ulrich.clans.manager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Times.class */
public class Times {
    public String unixToDate(Long l, String str) {
        return new SimpleDateFormat(str).format(new Date(l.longValue()));
    }
}
