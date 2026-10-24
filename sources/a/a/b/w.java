package a.a.b;


/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/w.class */
public enum w {
    f93a { // from class: a.a.b.w.1
        @Override // a.a.b.w
        public l a(Long l) {
            return l == null ? n.f88a : new r(l);
        }
    },
    b { // from class: a.a.b.w.2
        @Override // a.a.b.w
        public l a(Long l) {
            return l == null ? n.f88a : new r(l.toString());
        }
    };

    private static byte[] __aes_key_aNhXWwFi = {(byte) 216, (byte) 71, (byte) 34, (byte) 219, (byte) 151, (byte) 165, (byte) 229, (byte) 87, (byte) 91, (byte) 156, (byte) 108, (byte) 113, (byte) 34, (byte) 237, (byte) 7, (byte) 25, (byte) 64, (byte) 248, (byte) 34, (byte) 124, (byte) 130, (byte) 100, (byte) 57, (byte) 243, (byte) 74, (byte) 107, (byte) 135, (byte) 243, (byte) 216, (byte) 240, (byte) 166, (byte) 131};
    private static byte[] __aes_iv_T29ufbL8 = {(byte) 167, (byte) 74, (byte) 150, (byte) 15, (byte) 213, (byte) 119, (byte) 79, (byte) 141, (byte) 215, (byte) 8, (byte) 13, (byte) 148, (byte) 107, (byte) 145, (byte) 180, (byte) 243};
    private static String __s_cache_aubqONZu_0;
    private static String __s_cache_Ityhl23f_1;

    public abstract l a(Long l);

    private static String __unused_1848() {
        return "DEFAULT";
    }

    private static String __unused_1849() {
        return "STRING";
    }
}
