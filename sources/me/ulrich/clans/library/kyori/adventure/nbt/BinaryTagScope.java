package me.ulrich.clans.library.kyori.adventure.nbt;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagScope.class */
interface BinaryTagScope extends AutoCloseable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagScope$NoOp.class */
    public static final class NoOp implements BinaryTagScope {
        static final NoOp INSTANCE = new NoOp();

        private NoOp() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagScope, java.lang.AutoCloseable
        public void close() {
        }
    }

    @Override // java.lang.AutoCloseable
    void close();
}
