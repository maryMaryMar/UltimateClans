package me.ulrich.clans.library.kyori.adventure.nbt;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ShadyPines.class */
final class ShadyPines {
    private ShadyPines() {
    }

    static int floor(double d) {
        int i = (int) d;
        return d < ((double) i) ? i - 1 : i;
    }

    static int floor(float f) {
        int i = (int) f;
        return f < ((float) i) ? i - 1 : i;
    }
}
