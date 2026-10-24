package me.ulrich.clans.manager;

import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/ua6rk884OvNUdJs7.class */
/* synthetic */ class ua6rk884OvNUdJs7 {
    static final /* synthetic */ int[] v8qP8fE86HMhvNuYPFjqY = new int[ClanEnum.ClanStorage.values().length];

    static {
        try {
            v8qP8fE86HMhvNuYPFjqY[ClanEnum.ClanStorage.MYSQL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            v8qP8fE86HMhvNuYPFjqY[ClanEnum.ClanStorage.SQLITE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            v8qP8fE86HMhvNuYPFjqY[ClanEnum.ClanStorage.YAML.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
