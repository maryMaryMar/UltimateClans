package a.a.b.d;

import a.a.b.b.a.g;
import a.a.b.b.p;
import a.a.b.y;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.obf.AesHelper;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.udojava.evalex.Expression;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/d/a.class */
public class a implements Closeable {
    private static final long d = -922337203685477580L;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;
    private static final int j = 5;
    private static final int k = 6;
    private static final int l = 7;
    private static final int m = 8;
    private static final int n = 9;
    private static final int o = 10;
    private static final int p = 11;
    private static final int q = 12;
    private static final int r = 13;
    private static final int s = 14;
    private static final int t = 15;
    private static final int u = 16;
    private static final int v = 17;
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 3;
    private static final int A = 4;
    private static final int B = 5;
    private static final int C = 6;
    private static final int D = 7;
    private final Reader E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f74a = 255;
    static final int b = 1024;
    private long M;
    private int N;
    private String O;
    private int Q;
    private String[] R;
    private int[] S;
    private static byte[] __aes_key_NHMFviLY = {(byte) 153, (byte) 128, (byte) 51, (byte) 79, (byte) 155, (byte) 179, (byte) 175, (byte) 8, (byte) 124, (byte) 200, (byte) 130, (byte) 226, (byte) 219, (byte) 36, (byte) 11, (byte) 170, (byte) 227, (byte) 87, (byte) 88, (byte) 189, (byte) 99, (byte) 145, (byte) 107, (byte) 88, (byte) 178, (byte) 209, (byte) 113, (byte) 160, (byte) 69, (byte) 36, (byte) 35, (byte) 95};
    private static byte[] __aes_iv_OjODXgu7 = {(byte) 174, (byte) 206, (byte) 147, (byte) 18, (byte) 142, (byte) 57, (byte) 20, (byte) 155, (byte) 50, (byte) 170, (byte) 98, (byte) 55, (byte) 118, (byte) 120, (byte) 118, (byte) 58};
    private static String __s_cache_2JgV7lid_0;
    private static String __s_cache_zLD0Rq7V_1;
    private static String __s_cache_KfBVEKu4_2;
    private static String __s_cache_YBMUhzHY_3;
    private static String __s_cache_lRG2DbLz_4;
    private static String __s_cache_WzdSbFpt_5;
    private static String __s_cache_JG1f4l6v_6;
    private static String __s_cache_xFSv3OSC_7;
    private static String __s_cache_fUcxxjtL_8;
    private static String __s_cache_dTLpkEqg_9;
    private static String __s_cache_Nktzbsxf_10;
    private static String __s_cache_i8azvh7L_11;
    private static String __s_cache_3FhUpPde_12;
    private static String __s_cache_izCdOslS_13;
    private static String __s_cache_k3urGgBL_14;
    private static String __s_cache_dRD2UNRU_15;
    private static String __s_cache_TrIvIsSP_16;
    private static String __s_cache_RkIJ3IUa_17;
    private static String __s_cache_qlQmlKG1_18;
    private static String __s_cache_gI5HvPvR_19;
    private static String __s_cache_UnwcLtZ3_20;
    private static String __s_cache_GsvlxDGg_21;
    private static String __s_cache_Gt2cHopH_22;
    private static String __s_cache_2B4Oh3uQ_23;
    private static String __s_cache_xca5pOKx_24;
    private static String __s_cache_R1bXjGg6_25;
    private static String __s_cache_BXpRRa9r_26;
    private static String __s_cache_hghnFNNc_27;
    private static String __s_cache_hTCfzgcl_28;
    private static String __s_cache_MlHrj8MS_29;
    private static String __s_cache_EKGzgD9F_30;
    private static String __s_cache_CRK50jf9_31;
    private static String __s_cache_DqrKjZ1k_32;
    private static String __s_cache_01UInHYV_33;
    private static String __s_cache_Pd2XT8gW_34;
    private static String __s_cache_jjDO9q7O_35;
    private static String __s_cache_EX7mvcE4_36;
    private static String __s_cache_fOHSMIYV_37;
    private static String __s_cache_UgeGcpcy_38;
    private static String __s_cache_aIJb0TT0_39;
    private static String __s_cache_PJCiDjgN_40;
    private static String __s_cache_cECVlmV8_41;
    private static String __s_cache_7oEbqt5R_42;
    private static String __s_cache_zcLEWJdp_43;
    private static String __s_cache_am4gieJ3_44;
    private static String __s_cache_OqKQ0X0Q_45;
    private static String __s_cache_9ogvml7G_46;
    private static String __s_cache_fo5Lh1CK_47;
    private static String __s_cache_kHFkuVjR_48;
    private static String __s_cache_fyilG6UA_49;
    private static String __s_cache_tWtD6pbM_50;
    private static String __s_cache_DNt36Tno_51;
    private static String __s_cache_KjNHHfiz_52;
    private static String __s_cache_Q3kRQTU5_53;
    private static String __s_cache_WTX42IZU_54;
    private static String __s_cache_1XFt1q6j_55;
    private static String __s_cache_BuhJVP0b_56;
    private static String __s_cache_aJFSUI35_57;
    private static String __s_cache_UTfLGQY7_58;
    private static String __s_cache_To1px4Cw_59;
    private y F = y.b;
    private int G = f74a;
    private final char[] H = new char[b];
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    int c = 0;
    private int[] P = new int[32];

    public a(Reader reader) {
        this.Q = 0;
        int[] iArr = this.P;
        int i2 = this.Q;
        this.Q = i2 + 1;
        iArr[i2] = 6;
        this.R = new String[32];
        this.S = new int[32];
        this.E = (Reader) Objects.requireNonNull(reader, "in == null");
    }

    @Deprecated
    public final void a(boolean z2) {
        a(z2 ? y.f96a : y.b);
    }

    public final boolean s() {
        return this.F == y.f96a;
    }

    public final void a(y yVar) {
        Objects.requireNonNull(yVar);
        this.F = yVar;
    }

    public final y t() {
        return this.F;
    }

    public final void a(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(__getString_c4AQDKLc_1() + i2);
        }
        this.G = i2;
    }

    public final int u() {
        return this.G;
    }

    public void a() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 3) {
            throw c(__getString_Pad9fgUN_2());
        }
        b(1);
        this.S[this.Q - 1] = 0;
        this.c = 0;
    }

    public void b() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 4) {
            throw c(__getString_cn4ycj5f_3());
        }
        this.Q--;
        int[] iArr = this.S;
        int i2 = this.Q - 1;
        iArr[i2] = iArr[i2] + 1;
        this.c = 0;
    }

    public void c() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 1) {
            throw c("BEGIN_OBJECT");
        }
        b(3);
        this.c = 0;
    }

    public void d() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 2) {
            throw c(__getString_IhjuwmHK_5());
        }
        this.Q--;
        this.R[this.Q] = null;
        int[] iArr = this.S;
        int i2 = this.Q - 1;
        iArr[i2] = iArr[i2] + 1;
        this.c = 0;
    }

    public boolean e() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        return (iV == 2 || iV == 4 || iV == v) ? false : true;
    }

    public c f() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        switch (iV) {
            case 1:
                return c.c;
            case 2:
                return c.d;
            case 3:
                return c.f76a;
            case 4:
                return c.b;
            case 5:
            case 6:
                return c.h;
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                return c.i;
            case 8:
            case n /* 9 */:
            case 10:
            case 11:
                return c.f;
            case q /* 12 */:
            case r /* 13 */:
            case s /* 14 */:
                return c.e;
            case 15:
            case 16:
                return c.g;
            case v /* 17 */:
                return c.j;
            default:
                throw new AssertionError();
        }
    }

    int v() throws IOException {
        int i2 = this.P[this.Q - 1];
        if (i2 == 1) {
            this.P[this.Q - 1] = 2;
        } else if (i2 == 2) {
            switch (b(true)) {
                case 44:
                    break;
                case 59:
                    z();
                    break;
                case 93:
                    this.c = 4;
                    return this.c;
                default:
                    throw b("Unterminated array");
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                this.P[this.Q - 1] = 4;
                if (i2 == 5) {
                    switch (b(true)) {
                        case 44:
                            break;
                        case 59:
                            z();
                            break;
                        case 125:
                            this.c = 2;
                            return this.c;
                        default:
                            throw b(__getString_LgUykvB3_7());
                    }
                }
                int iB = b(true);
                switch (iB) {
                    case 34:
                        this.c = r;
                        return this.c;
                    case 39:
                        z();
                        this.c = q;
                        return this.c;
                    case 125:
                        if (i2 == 5) {
                            throw b("Expected name");
                        }
                        this.c = 2;
                        return this.c;
                    default:
                        z();
                        this.I--;
                        if (!a((char) iB)) {
                            throw b("Expected name");
                        }
                        this.c = s;
                        return this.c;
                }
            }
            if (i2 == 4) {
                this.P[this.Q - 1] = 5;
                switch (b(true)) {
                    case 58:
                        break;
                    case 61:
                        z();
                        if ((this.I < this.J || c(1)) && this.H[this.I] == '>') {
                            this.I++;
                        }
                        break;
                    default:
                        throw b("Expected ':'");
                }
            } else if (i2 == 6) {
                if (this.F == y.f96a) {
                    C();
                }
                this.P[this.Q - 1] = 7;
            } else if (i2 == 7) {
                if (b(false) == -1) {
                    this.c = v;
                    return this.c;
                }
                z();
                this.I--;
            } else if (i2 == 8) {
                throw new IllegalStateException(__getString_T7xDq3Sh_11());
            }
        }
        switch (b(true)) {
            case 34:
                this.c = n;
                return this.c;
            case 39:
                z();
                this.c = 8;
                return this.c;
            case 44:
            case 59:
                break;
            case 91:
                this.c = 3;
                return this.c;
            case 93:
                if (i2 == 1) {
                    this.c = 4;
                    return this.c;
                }
                break;
            case 123:
                this.c = 1;
                return this.c;
            default:
                this.I--;
                int iN = n();
                if (iN != 0) {
                    return iN;
                }
                int iP = p();
                if (iP != 0) {
                    return iP;
                }
                if (!a(this.H[this.I])) {
                    throw b("Expected value");
                }
                z();
                this.c = 10;
                return this.c;
        }
        if (i2 != 1 && i2 != 2) {
            throw b(__getString_3Lrx0ew6_12());
        }
        z();
        this.I--;
        this.c = 7;
        return this.c;
    }

    private int n() {
        String str__getString_CDtmFhWz_14;
        String str__getString_Zvbxsz43_15;
        int i2;
        char c = this.H[this.I];
        if (c == 't' || c == 'T') {
            str__getString_CDtmFhWz_14 = "true";
            str__getString_Zvbxsz43_15 = __getString_Zvbxsz43_15();
            i2 = 5;
        } else if (c == 'f' || c == 'F') {
            str__getString_CDtmFhWz_14 = __getString_S92NnMO3_16();
            str__getString_Zvbxsz43_15 = "FALSE";
            i2 = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str__getString_CDtmFhWz_14 = "null";
            str__getString_Zvbxsz43_15 = __getString_A366kWkA_19();
            i2 = 7;
        }
        boolean z2 = this.F != y.c;
        int length = str__getString_CDtmFhWz_14.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (this.I + i3 >= this.J && !c(i3 + 1)) {
                return 0;
            }
            char c2 = this.H[this.I + i3];
            if (!(c2 == str__getString_CDtmFhWz_14.charAt(i3) || (z2 && c2 == str__getString_Zvbxsz43_15.charAt(i3)))) {
                return 0;
            }
        }
        if ((this.I + length < this.J || c(length + 1)) && a(this.H[this.I + length])) {
            return 0;
        }
        this.I += length;
        this.c = i2;
        return this.c;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0084  */
    /* JADX WARN: Code duplicated, block: B:17:0x0089  */
    /* JADX WARN: Code duplicated, block: B:18:0x0092  */
    /* JADX WARN: Code duplicated, block: B:20:0x0098  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ec A[RETURN] */
    private int p() {
        char c;
        char[] cArr = this.H;
        int i2 = this.I;
        int i3 = this.J;
        long j2 = 0;
        boolean z2 = false;
        boolean z3 = true;
        char c2 = 0;
        int i4 = 0;
        while (true) {
            if (i2 + i4 != i3) {
                c = cArr[i2 + i4];
                switch (c) {
                    case Protocol.PLUS_BYTE /* 43 */:
                        if (c2 == 5) {
                            return 0;
                        }
                        c2 = 6;
                        continue;
                        continue;
                        i4++;
                        break;
                        break;
                    case Protocol.MINUS_BYTE /* 45 */:
                        if (c2 == 0) {
                            z2 = true;
                            c2 = 1;
                            continue;
                            continue;
                        } else {
                            if (c2 == 5) {
                                return 0;
                            }
                            c2 = 6;
                        }
                        i4++;
                        break;
                    case '.':
                        if (c2 == 2) {
                            return 0;
                        }
                        c2 = 3;
                        continue;
                        continue;
                        i4++;
                        break;
                        break;
                    case 'E':
                    case 'e':
                        if (c2 == 2 && c2 != 4) {
                            return 0;
                        }
                        c2 = 5;
                        continue;
                        continue;
                        i4++;
                        break;
                        break;
                    default:
                        if (c < '0' && c <= '9') {
                            if (c2 == 1 || c2 == 0) {
                                j2 = -(c - '0');
                                c2 = 2;
                            } else if (c2 == 2) {
                                if (j2 == 0) {
                                    return 0;
                                }
                                long j3 = (j2 * 10) - ((long) (c - '0'));
                                z3 &= j2 > d || (j2 == d && j3 < j2);
                                j2 = j3;
                            } else if (c2 == 3) {
                                c2 = 4;
                            } else if (c2 == 5 || c2 == 6) {
                                c2 = 7;
                            }
                            i4++;
                        } else if (a(c)) {
                            return 0;
                        }
                        break;
                }
            } else {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (c(i4 + 1)) {
                    i2 = this.I;
                    i3 = this.J;
                    c = cArr[i2 + i4];
                    switch (c) {
                        case Protocol.PLUS_BYTE /* 43 */:
                            if (c2 == 5) {
                                return 0;
                            }
                            c2 = 6;
                            continue;
                            continue;
                            i4++;
                            break;
                            break;
                        case Protocol.MINUS_BYTE /* 45 */:
                            if (c2 == 0) {
                                z2 = true;
                                c2 = 1;
                                continue;
                                continue;
                            } else {
                                if (c2 == 5) {
                                    return 0;
                                }
                                c2 = 6;
                            }
                            i4++;
                            break;
                        case '.':
                            if (c2 == 2) {
                                return 0;
                            }
                            c2 = 3;
                            continue;
                            continue;
                            i4++;
                            break;
                            break;
                        case 'E':
                        case 'e':
                            if (c2 == 2) {
                            }
                            c2 = 5;
                            continue;
                            continue;
                            i4++;
                            break;
                        default:
                            if (c < '0') {
                            }
                            if (a(c)) {
                                return 0;
                            }
                            break;
                    }
                }
            }
        }
        if (c2 == 2 && z3 && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            this.M = z2 ? j2 : -j2;
            this.I += i4;
            this.c = 15;
            return this.c;
        }
        if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        }
        this.N = i4;
        this.c = 16;
        return this.c;
    }

    private boolean a(char c) throws e {
        switch (c) {
            case n /* 9 */:
            case '\n':
            case q /* 12 */:
            case r /* 13 */:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            case '#':
            case TokenParser.CLOSE_TAG /* 47 */:
            case ';':
            case '=':
            case TokenParser.ESCAPE /* 92 */:
                z();
                return false;
            default:
                return true;
        }
    }

    public String g() throws IOException {
        String strB;
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV == s) {
            strB = x();
        } else if (iV == q) {
            strB = b('\'');
        } else {
            if (iV != r) {
                throw c("a name");
            }
            strB = b('\"');
        }
        this.c = 0;
        this.R[this.Q - 1] = strB;
        return strB;
    }

    public String h() throws IOException {
        String str;
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 10) {
            str = x();
        } else if (iV == 8) {
            str = b('\'');
        } else if (iV == n) {
            str = b('\"');
        } else if (iV == 11) {
            str = this.O;
            this.O = null;
        } else if (iV == 15) {
            str = Long.toString(this.M);
        } else {
            if (iV != 16) {
                throw c(__getString_8mdClwsN_21());
            }
            str = new String(this.H, this.I, this.N);
            this.I += this.N;
        }
        this.c = 0;
        int[] iArr = this.S;
        int i2 = this.Q - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 5) {
            this.c = 0;
            int[] iArr = this.S;
            int i2 = this.Q - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iV != 6) {
            throw c("a boolean");
        }
        this.c = 0;
        int[] iArr2 = this.S;
        int i3 = this.Q - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public void j() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV != 7) {
            throw c("null");
        }
        this.c = 0;
        int[] iArr = this.S;
        int i2 = this.Q - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public double k() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 15) {
            this.c = 0;
            int[] iArr = this.S;
            int i2 = this.Q - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.M;
        }
        if (iV == 16) {
            this.O = new String(this.H, this.I, this.N);
            this.I += this.N;
        } else if (iV == 8 || iV == n) {
            this.O = b(iV == 8 ? '\'' : '\"');
        } else if (iV == 10) {
            this.O = x();
        } else if (iV != 11) {
            throw c("a double");
        }
        this.c = 11;
        double d2 = Double.parseDouble(this.O);
        if (this.F != y.f96a && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw b(__getString_O5BfDKGO_25() + d2);
        }
        this.O = null;
        this.c = 0;
        int[] iArr2 = this.S;
        int i3 = this.Q - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public long l() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 15) {
            this.c = 0;
            int[] iArr = this.S;
            int i2 = this.Q - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.M;
        }
        if (iV == 16) {
            this.O = new String(this.H, this.I, this.N);
            this.I += this.N;
        } else {
            if (iV != 8 && iV != n && iV != 10) {
                throw c("a long");
            }
            if (iV == 10) {
                this.O = x();
            } else {
                this.O = b(iV == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.O);
                this.c = 0;
                int[] iArr2 = this.S;
                int i3 = this.Q - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException e2) {
            }
        }
        this.c = 11;
        double d2 = Double.parseDouble(this.O);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException(__getString_XOXHVGwR_27() + this.O + w());
        }
        this.O = null;
        this.c = 0;
        int[] iArr3 = this.S;
        int i4 = this.Q - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    private String b(char c) throws e {
        char[] cArr = this.H;
        StringBuilder sb = null;
        do {
            int i2 = this.I;
            int i3 = this.J;
            int i4 = i2;
            while (i2 < i3) {
                int i5 = i2;
                i2++;
                char c2 = cArr[i5];
                if (this.F == y.c && c2 < ' ') {
                    throw b("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                }
                if (c2 == c) {
                    this.I = i2;
                    int i6 = (i2 - i4) - 1;
                    if (sb == null) {
                        return new String(cArr, i4, i6);
                    }
                    sb.append(cArr, i4, i6);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.I = i2;
                    int i7 = (i2 - i4) - 1;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                    }
                    sb.append(cArr, i4, i7);
                    sb.append(B());
                    i2 = this.I;
                    i3 = this.J;
                    i4 = i2;
                } else if (c2 == '\n') {
                    this.K++;
                    this.L = i2;
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i2 - i4) * 2, 16));
            }
            sb.append(cArr, i4, i2 - i4);
            this.I = i2;
        } while (c(1));
        throw b(__getString_U7xu0nfe_29());
    }

    private String x() throws e {
        StringBuilder sb = null;
        int i2 = 0;
        while (true) {
            if (this.I + i2 < this.J) {
                switch (this.H[this.I + i2]) {
                    case n /* 9 */:
                    case '\n':
                    case q /* 12 */:
                    case r /* 13 */:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case TokenParser.CLOSE_TAG /* 47 */:
                    case ';':
                    case '=':
                    case TokenParser.ESCAPE /* 92 */:
                        z();
                        break;
                    default:
                        i2++;
                        continue;
                }
            } else if (i2 >= this.H.length) {
                if (sb == null) {
                    sb = new StringBuilder(Math.max(i2, 16));
                }
                sb.append(this.H, this.I, i2);
                this.I += i2;
                i2 = 0;
                if (!c(1)) {
                }
            } else if (c(i2 + 1)) {
            }
        }
        String str = sb == null ? new String(this.H, this.I, i2) : sb.append(this.H, this.I, i2).toString();
        this.I += i2;
        return str;
    }

    private void c(char c) throws e {
        char[] cArr = this.H;
        do {
            int i2 = this.I;
            int i3 = this.J;
            while (i2 < i3) {
                int i4 = i2;
                i2++;
                char c2 = cArr[i4];
                if (c2 == c) {
                    this.I = i2;
                    return;
                }
                if (c2 == '\\') {
                    this.I = i2;
                    B();
                    i2 = this.I;
                    i3 = this.J;
                } else if (c2 == '\n') {
                    this.K++;
                    this.L = i2;
                }
            }
            this.I = i2;
        } while (c(1));
        throw b(__getString_xRS4phqt_30());
    }

    private void y() throws e {
        do {
            int i2 = 0;
            while (this.I + i2 < this.J) {
                switch (this.H[this.I + i2]) {
                    case n /* 9 */:
                    case '\n':
                    case q /* 12 */:
                    case r /* 13 */:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case TokenParser.CLOSE_TAG /* 47 */:
                    case ';':
                    case '=':
                    case TokenParser.ESCAPE /* 92 */:
                        z();
                        break;
                    default:
                        i2++;
                        break;
                }
                this.I += i2;
                return;
            }
            this.I += i2;
        } while (c(1));
    }

    public int m() throws IOException {
        int iV = this.c;
        if (iV == 0) {
            iV = v();
        }
        if (iV == 15) {
            int i2 = (int) this.M;
            if (this.M != i2) {
                throw new NumberFormatException("Expected an int but was " + this.M + w());
            }
            this.c = 0;
            int[] iArr = this.S;
            int i3 = this.Q - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iV == 16) {
            this.O = new String(this.H, this.I, this.N);
            this.I += this.N;
        } else {
            if (iV != 8 && iV != n && iV != 10) {
                throw c("an int");
            }
            if (iV == 10) {
                this.O = x();
            } else {
                this.O = b(iV == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.O);
                this.c = 0;
                int[] iArr2 = this.S;
                int i5 = this.Q - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException e2) {
            }
        }
        this.c = 11;
        double d2 = Double.parseDouble(this.O);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.O + w());
        }
        this.O = null;
        this.c = 0;
        int[] iArr3 = this.S;
        int i7 = this.Q - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c = 0;
        this.P[0] = 8;
        this.Q = 1;
        this.E.close();
    }

    public void o() throws IOException {
        int i2 = 0;
        do {
            int iV = this.c;
            if (iV == 0) {
                iV = v();
            }
            switch (iV) {
                case 1:
                    b(3);
                    i2++;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.R[this.Q - 1] = null;
                    }
                    this.Q--;
                    i2--;
                    break;
                case 3:
                    b(1);
                    i2++;
                    break;
                case 4:
                    this.Q--;
                    i2--;
                    break;
                case 8:
                    c('\'');
                    break;
                case n /* 9 */:
                    c('\"');
                    break;
                case 10:
                    y();
                    break;
                case q /* 12 */:
                    c('\'');
                    if (i2 == 0) {
                        this.R[this.Q - 1] = "<skipped>";
                    }
                    break;
                case r /* 13 */:
                    c('\"');
                    if (i2 == 0) {
                        this.R[this.Q - 1] = "<skipped>";
                    }
                    break;
                case s /* 14 */:
                    y();
                    if (i2 == 0) {
                        this.R[this.Q - 1] = "<skipped>";
                    }
                    break;
                case 16:
                    this.I += this.N;
                    break;
                case v /* 17 */:
                    return;
            }
            this.c = 0;
        } while (i2 > 0);
        int[] iArr = this.S;
        int i3 = this.Q - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    private void b(int i2) throws e {
        if (this.Q - 1 >= this.G) {
            throw new e("Nesting limit " + this.G + " reached" + w());
        }
        if (this.Q == this.P.length) {
            int i3 = this.Q * 2;
            this.P = Arrays.copyOf(this.P, i3);
            this.S = Arrays.copyOf(this.S, i3);
            this.R = (String[]) Arrays.copyOf(this.R, i3);
        }
        int[] iArr = this.P;
        int i4 = this.Q;
        this.Q = i4 + 1;
        iArr[i4] = i2;
    }

    private boolean c(int i2) throws IOException {
        char[] cArr = this.H;
        this.L -= this.I;
        if (this.J != this.I) {
            this.J -= this.I;
            System.arraycopy(cArr, this.I, cArr, 0, this.J);
        } else {
            this.J = 0;
        }
        this.I = 0;
        do {
            int i3 = this.E.read(cArr, this.J, cArr.length - this.J);
            if (i3 == -1) {
                return false;
            }
            this.J += i3;
            if (this.K == 0 && this.L == 0 && this.J > 0 && cArr[0] == 65279) {
                this.I++;
                this.L++;
                i2++;
            }
        } while (this.J < i2);
        return true;
    }

    private int b(boolean z2) throws IOException {
        char[] cArr = this.H;
        int i2 = this.I;
        int i3 = this.J;
        while (true) {
            if (i2 == i3) {
                this.I = i2;
                if (!c(1)) {
                    if (z2) {
                        throw new EOFException("End of input" + w());
                    }
                    return -1;
                }
                i2 = this.I;
                i3 = this.J;
            }
            int i4 = i2;
            i2++;
            char c = cArr[i4];
            if (c == '\n') {
                this.K++;
                this.L = i2;
            } else if (c != ' ' && c != r && c != n) {
                if (c == '/') {
                    this.I = i2;
                    if (i2 == i3) {
                        this.I--;
                        boolean zC = c(2);
                        this.I++;
                        if (!zC) {
                            return c;
                        }
                    }
                    z();
                    switch (cArr[this.I]) {
                        case Protocol.ASTERISK_BYTE /* 42 */:
                            this.I++;
                            if (!a("*/")) {
                                throw b("Unterminated comment");
                            }
                            i2 = this.I + 2;
                            i3 = this.J;
                            break;
                            break;
                        case TokenParser.CLOSE_TAG /* 47 */:
                            this.I++;
                            A();
                            i2 = this.I;
                            i3 = this.J;
                            break;
                        default:
                            return c;
                    }
                } else {
                    if (c != '#') {
                        this.I = i2;
                        return c;
                    }
                    this.I = i2;
                    z();
                    A();
                    i2 = this.I;
                    i3 = this.J;
                }
            }
        }
    }

    private void z() throws e {
        if (this.F != y.f96a) {
            throw b(__getString_6nIrMJWn_42());
        }
    }

    private void A() {
        char c;
        do {
            if (this.I >= this.J && !c(1)) {
                return;
            }
            char[] cArr = this.H;
            int i2 = this.I;
            this.I = i2 + 1;
            c = cArr[i2];
            if (c == '\n') {
                this.K++;
                this.L = this.I;
                return;
            }
        } while (c != r);
    }

    private boolean a(String str) {
        int length = str.length();
        while (true) {
            if (this.I + length > this.J && !c(length)) {
                return false;
            }
            if (this.H[this.I] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.H[this.I + i2] == str.charAt(i2)) {
                    }
                }
                return true;
            }
            this.K++;
            this.L = this.I + 1;
            this.I++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + w();
    }

    String w() {
        return " at line " + (this.K + 1) + " column " + ((this.I - this.L) + 1) + __getString_m9UTnJSC_45() + q();
    }

    private String c(boolean z2) {
        StringBuilder sbAppend = new StringBuilder().append('$');
        for (int i2 = 0; i2 < this.Q; i2++) {
            int i3 = this.P[i2];
            switch (i3) {
                case 1:
                case 2:
                    int i4 = this.S[i2];
                    if (z2 && i4 > 0 && i2 == this.Q - 1) {
                        i4--;
                    }
                    sbAppend.append('[').append(i4).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sbAppend.append('.');
                    if (this.R[i2] != null) {
                        sbAppend.append(this.R[i2]);
                    }
                    break;
                case 6:
                case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i3);
            }
        }
        return sbAppend.toString();
    }

    public String q() {
        return c(false);
    }

    public String r() {
        return c(true);
    }

    private char B() throws e {
        int i2;
        if (this.I == this.J && !c(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.H;
        int i3 = this.I;
        this.I = i3 + 1;
        char c = cArr[i3];
        switch (c) {
            case '\n':
                if (this.F != y.c) {
                    this.K++;
                    this.L = this.I;
                    break;
                } else {
                    throw b("Cannot escape a newline character in strict mode");
                }
            case '\'':
                if (this.F == y.c) {
                    throw b(__getString_wXk0yAGd_51());
                }
            case '\"':
            case TokenParser.CLOSE_TAG /* 47 */:
            case TokenParser.ESCAPE /* 92 */:
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.I + 4 > this.J && !c(4)) {
                    throw b("Unterminated escape sequence");
                }
                int i4 = 0;
                int i5 = this.I;
                int i6 = i5 + 4;
                while (i5 < i6) {
                    char c2 = this.H[i5];
                    int i7 = i4 << 4;
                    if (c2 >= '0' && c2 <= '9') {
                        i2 = c2 - '0';
                    } else if (c2 >= 'a' && c2 <= 'f') {
                        i2 = (c2 - 'a') + 10;
                    } else {
                        if (c2 < 'A' || c2 > 'F') {
                            throw b("Malformed Unicode escape \\u" + new String(this.H, this.I, 4));
                        }
                        i2 = (c2 - 'A') + 10;
                    }
                    i4 = i7 + i2;
                    i5++;
                }
                this.I += 4;
                return (char) i4;
            default:
                throw b(__getString_Bh6URluk_52());
        }
    }

    private e b(String str) throws e {
        throw new e(str + w() + "\nSee " + p.a("malformed-json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IllegalStateException c(String str) {
        return new IllegalStateException(__getString_O0Q7X9WM_57() + str + __getString_jwUGD6KN_58() + f() + w() + "\nSee " + p.a(f() == c.i ? "��zF�$��ν#��safe" : "unexpected-json-structure"));
    }

    private void C() throws IOException {
        b(true);
        this.I--;
        if (this.I + 5 <= this.J || c(5)) {
            int i2 = this.I;
            char[] cArr = this.H;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.I += 5;
            }
        }
    }

    static {
        a.a.b.b.f.f58a = new a.a.b.b.f() { // from class: a.a.b.d.a.1
            private static byte[] __aes_key_QyDqUFEA = {(byte) 251, (byte) 157, (byte) 55, (byte) 116, (byte) 179, (byte) 41, (byte) 7, (byte) 128, (byte) 88, (byte) 136, (byte) 91, (byte) 229, (byte) 157, (byte) 176, (byte) 242, (byte) 48, (byte) 32, (byte) 45, (byte) 248, (byte) 251, (byte) 152, (byte) 203, (byte) 176, (byte) 67, (byte) 227, (byte) 124, (byte) 195, (byte) 104, (byte) 84, (byte) 222, (byte) 191, (byte) 85};
            private static byte[] __aes_iv_za9DXxNr = {(byte) 236, (byte) 88, (byte) 55, (byte) 202, (byte) 240, (byte) 184, (byte) 184, (byte) 1, (byte) 41, (byte) 155, (byte) 140, (byte) 31, (byte) 83, (byte) 95, (byte) 24, (byte) 132};
            private static String __s_cache_X94TJLyB_0;

            @Override // a.a.b.b.f
            public void a(a aVar) throws IOException {
                if (aVar instanceof g) {
                    ((g) aVar).p();
                    return;
                }
                int iV = aVar.c;
                if (iV == 0) {
                    iV = aVar.v();
                }
                if (iV == a.r) {
                    aVar.c = a.n;
                } else if (iV == a.q) {
                    aVar.c = 8;
                } else {
                    if (iV != a.s) {
                        throw aVar.c(__getString_sUCLuXRc_0());
                    }
                    aVar.c = 10;
                }
            }

            private static String __getString_sUCLuXRc_0() {
                String str = __s_cache_X94TJLyB_0;
                if (str != null) {
                    return str;
                }
                String strDecrypt = AesHelper.decrypt(__aes_key_QyDqUFEA, __aes_iv_za9DXxNr, new byte[]{(byte) 199, (byte) 48, (byte) 153, a.s, (byte) 188, (byte) 153, (byte) 192, (byte) 6, (byte) 253, (byte) 128, (byte) 0, (byte) 137, (byte) 168, (byte) 205, a.n, (byte) 213});
                __s_cache_X94TJLyB_0 = strDecrypt;
                return strDecrypt;
            }
        };
    }

    private static String __unused_1945() {
        return "in == null";
    }

    private static String __getString_c4AQDKLc_1() {
        String str = __s_cache_zLD0Rq7V_1;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 128, (byte) 214, (byte) 253, (byte) 106, (byte) 195, (byte) 118, (byte) 97, (byte) 3, (byte) 141, (byte) 74, (byte) 212, (byte) 228, (byte) 132, (byte) 75, f(byte) 74a, (byte) 177, (byte) 160, (byte) 174, (byte) 48, (byte) 74, (byte) 123, (byte) 190, (byte) 85, (byte) 51, (byte) 111, (byte) 222, (byte) 199, (byte) 38, (byte) 200, (byte) 86, (byte) 149, (byte) 175});
        __s_cache_zLD0Rq7V_1 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_Pad9fgUN_2() {
        String str = __s_cache_KfBVEKu4_2;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 102, s, (byte) 149, (byte) 54, (byte) 216, (byte) 198, (byte) 7, (byte) 43, (byte) 35, (byte) 91, (byte) 215, (byte) 220, (byte) 250, (byte) 146, (byte) 125, (byte) 176});
        __s_cache_KfBVEKu4_2 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_cn4ycj5f_3() {
        String str = __s_cache_YBMUhzHY_3;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 138, (byte) 36, f(byte) 74a, (byte) 243, (byte) 234, (byte) 159, (byte) 162, (byte) 157, (byte) 11, (byte) 166, (byte) 138, (byte) 212, (byte) 92, (byte) 146, (byte) 65, (byte) 78});
        __s_cache_YBMUhzHY_3 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1946() {
        return "BEGIN_OBJECT";
    }

    private static String __getString_IhjuwmHK_5() {
        String str = __s_cache_WzdSbFpt_5;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 75, (byte) 167, (byte) 250, (byte) 225, (byte) 182, v, (byte) 208, (byte) 10, (byte) 225, (byte) 105, f(byte) 74a, (byte) 84, (byte) 184, (byte) 223, (byte) 101, (byte) 211});
        __s_cache_WzdSbFpt_5 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1947() {
        return "Unterminated array";
    }

    private static String __getString_LgUykvB3_7() {
        String str = __s_cache_xFSv3OSC_7;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 215, (byte) 246, (byte) 33, (byte) 70, (byte) 69, (byte) 37, r, (byte) 124, (byte) 79, (byte) 158, (byte) 77, (byte) 71, f(byte) 74a, (byte) 56, (byte) 175, (byte) 112, (byte) 136, (byte) 120, (byte) 56, (byte) 166, (byte) 188, (byte) 248, (byte) 223, (byte) 134, (byte) 73, (byte) 119, (byte) 74, (byte) 76, n, (byte) 215, (byte) 82, (byte) 138});
        __s_cache_xFSv3OSC_7 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1948() {
        return "Expected name";
    }

    private static String __unused_1949() {
        return "Expected name";
    }

    private static String __unused_1950() {
        return "Expected ':'";
    }

    private static String __getString_T7xDq3Sh_11() {
        String str = __s_cache_i8azvh7L_11;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 5, (byte) 64, (byte) 215, (byte) 87, (byte) 52, (byte) 11, (byte) 71, (byte) 208, (byte) 199, (byte) 130, (byte) 142, (byte) 153, (byte) 220, (byte) 60, (byte) 147, (byte) 160, (byte) 25, (byte) 231, (byte) 108, (byte) 207, (byte) 128, (byte) 140, (byte) 215, (byte) 166, (byte) 20, (byte) 193, (byte) 69, (byte) 87, (byte) 25, n, (byte) 31, (byte) 37});
        __s_cache_i8azvh7L_11 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_3Lrx0ew6_12() {
        String str = __s_cache_3FhUpPde_12;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 32, (byte) 125, (byte) 139, (byte) 229, (byte) 201, (byte) 106, (byte) 15, (byte) 189, (byte) 52, (byte) 98, (byte) 129, (byte) 40, (byte) 5, (byte) 135, (byte) 211, (byte) 166, (byte) 250, (byte) 56, (byte) 253, (byte) 175, (byte) 221, (byte) 160, (byte) 165, (byte) 39, (byte) 48, (byte) 83, (byte) 167, (byte) 241, s, (byte) 33, (byte) 236, (byte) 134});
        __s_cache_3FhUpPde_12 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1951() {
        return "Expected value";
    }

    private static String __unused_1952() {
        return "true";
    }

    private static String __getString_Zvbxsz43_15() {
        String str = __s_cache_dRD2UNRU_15;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 11, (byte) 126, n, (byte) 155, (byte) 187, (byte) 91, (byte) 150, (byte) 42, (byte) 4, (byte) 35, (byte) 126, (byte) 227, (byte) 142, (byte) 53, (byte) 18, (byte) 251});
        __s_cache_dRD2UNRU_15 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_S92NnMO3_16() {
        String str = __s_cache_TrIvIsSP_16;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 151, f(byte) 74a, (byte) 115, (byte) 62, (byte) 192, (byte) 27, (byte) 96, (byte) 221, (byte) 205, (byte) 208, (byte) 7, (byte) 80, (byte) 135, (byte) 26, (byte) 186, (byte) 166});
        __s_cache_TrIvIsSP_16 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1953() {
        return "FALSE";
    }

    private static String __unused_1954() {
        return "null";
    }

    private static String __getString_A366kWkA_19() {
        String str = __s_cache_gI5HvPvR_19;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 149, (byte) 63, (byte) 8, (byte) 100, (byte) 75, (byte) 189, (byte) 113, (byte) 54, (byte) 48, (byte) 192, (byte) 147, (byte) 132, (byte) 74, (byte) 50, (byte) 25, f(byte) 74a});
        __s_cache_gI5HvPvR_19 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1955() {
        return "a name";
    }

    private static String __getString_8mdClwsN_21() {
        String str = __s_cache_GsvlxDGg_21;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 105, n, (byte) 46, (byte) 46, (byte) 29, (byte) 206, v, (byte) 191, (byte) 183, (byte) 4, (byte) 163, (byte) 41, (byte) 239, (byte) 16, (byte) 105, (byte) 147});
        __s_cache_GsvlxDGg_21 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1956() {
        return "a boolean";
    }

    private static String __unused_1957() {
        return "null";
    }

    private static String __unused_1958() {
        return "a double";
    }

    private static String __getString_O5BfDKGO_25() {
        String str = __s_cache_R1bXjGg6_25;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 81, (byte) 28, (byte) 253, (byte) 124, (byte) 159, (byte) 237, (byte) 114, (byte) 176, (byte) 78, (byte) 0, (byte) 247, (byte) 160, (byte) 65, f(byte) 74a, (byte) 70, (byte) 90, (byte) 83, (byte) 51, (byte) 138, (byte) 75, (byte) 180, (byte) 206, (byte) 146, (byte) 166, (byte) 114, (byte) 46, (byte) 138, (byte) 62, (byte) 249, (byte) 109, r, (byte) 120, (byte) 79, (byte) 214, (byte) 44, (byte) 119, (byte) 190, (byte) 164, (byte) 41, (byte) 15, (byte) 98, (byte) 1, (byte) 79, (byte) 50, (byte) 243, (byte) 82, (byte) 137, (byte) 114});
        __s_cache_R1bXjGg6_25 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1959() {
        return "a long";
    }

    private static String __getString_XOXHVGwR_27() {
        String str = __s_cache_hghnFNNc_27;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 59, (byte) 147, (byte) 246, (byte) 210, (byte) 123, (byte) 181, (byte) 38, (byte) 16, (byte) 53, (byte) 246, (byte) 33, (byte) 26, (byte) 152, f(byte) 74a, (byte) 96, (byte) 108, (byte) 79, (byte) 98, (byte) 50, (byte) 178, (byte) 134, (byte) 250, (byte) 130, (byte) 4, (byte) 214, (byte) 241, (byte) 113, (byte) 235, (byte) 1, (byte) 207, (byte) 90, (byte) 88});
        __s_cache_hghnFNNc_27 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1960() {
        return "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode";
    }

    private static String __getString_U7xu0nfe_29() {
        String str = __s_cache_MlHrj8MS_29;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 33, (byte) 25, (byte) 227, (byte) 126, (byte) 62, (byte) 62, (byte) 91, (byte) 206, (byte) 152, (byte) 180, (byte) 227, (byte) 117, (byte) 172, (byte) 130, (byte) 167, (byte) 187, (byte) 164, f(byte) 74a, (byte) 47, (byte) 173, (byte) 218, (byte) 205, (byte) 52, (byte) 174, (byte) 240, (byte) 52, (byte) 180, (byte) 210, (byte) 114, (byte) 150, (byte) 240, (byte) 145});
        __s_cache_MlHrj8MS_29 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_xRS4phqt_30() {
        String str = __s_cache_EKGzgD9F_30;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 33, (byte) 25, (byte) 227, (byte) 126, (byte) 62, (byte) 62, (byte) 91, (byte) 206, (byte) 152, (byte) 180, (byte) 227, (byte) 117, (byte) 172, (byte) 130, (byte) 167, (byte) 187, (byte) 164, f(byte) 74a, (byte) 47, (byte) 173, (byte) 218, (byte) 205, (byte) 52, (byte) 174, (byte) 240, (byte) 52, (byte) 180, (byte) 210, (byte) 114, (byte) 150, (byte) 240, (byte) 145});
        __s_cache_EKGzgD9F_30 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1961() {
        return "Expected an int but was ";
    }

    private static String __unused_1962() {
        return "an int";
    }

    private static String __unused_1963() {
        return "Expected an int but was ";
    }

    private static String __unused_1964() {
        return "<skipped>";
    }

    private static String __unused_1965() {
        return "<skipped>";
    }

    private static String __unused_1966() {
        return "<skipped>";
    }

    private static String __unused_1967() {
        return "Nesting limit ";
    }

    private static String __unused_1968() {
        return " reached";
    }

    private static String __unused_1969() {
        return "*/";
    }

    private static String __unused_1970() {
        return "Unterminated comment";
    }

    private static String __unused_1971() {
        return "End of input";
    }

    private static String __getString_6nIrMJWn_42() {
        String str = __s_cache_7oEbqt5R_42;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 74, (byte) 95, (byte) 107, (byte) 52, (byte) 246, (byte) 198, (byte) 54, (byte) 140, (byte) 140, (byte) 72, (byte) 113, (byte) 44, (byte) 224, (byte) 197, (byte) 221, (byte) 113, (byte) 242, (byte) 102, (byte) 250, (byte) 201, (byte) 49, (byte) 220, (byte) 98, (byte) 21, (byte) 230, (byte) 216, (byte) 159, (byte) 199, (byte) 109, (byte) 56, (byte) 2, (byte) 15, (byte) 166, (byte) 151, r, (byte) 121, (byte) 208, (byte) 112, (byte) 144, (byte) 20, (byte) 171, (byte) 71, (byte) 177, (byte) 147, (byte) 140, (byte) 133, (byte) 75, (byte) 96, (byte) 149, (byte) 203, (byte) 187, (byte) 39, (byte) 213, (byte) 197, (byte) 81, (byte) 180, (byte) 70, (byte) 206, (byte) 158, (byte) 228, (byte) 171, (byte) 162, (byte) 250, (byte) 56, (byte) 118, (byte) 3, (byte) 178, (byte) 241, (byte) 109, (byte) 155, (byte) 190, (byte) 116, (byte) 73, f(byte) 74a, (byte) 191, (byte) 102, (byte) 141, (byte) 150, (byte) 129, (byte) 161});
        __s_cache_7oEbqt5R_42 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1972() {
        return " at line ";
    }

    private static String __unused_1973() {
        return " column ";
    }

    private static String __getString_m9UTnJSC_45() {
        String str = __s_cache_OqKQ0X0Q_45;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 181, (byte) 31, (byte) 39, (byte) 180, (byte) 117, (byte) 239, (byte) 85, (byte) 85, (byte) 184, (byte) 65, (byte) 89, (byte) 213, (byte) 11, (byte) 214, (byte) 208, q});
        __s_cache_OqKQ0X0Q_45 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1974() {
        return "Unknown scope value: ";
    }

    private static String __unused_1975() {
        return "Unterminated escape sequence";
    }

    private static String __unused_1976() {
        return "Unterminated escape sequence";
    }

    private static String __unused_1977() {
        return "Malformed Unicode escape \\u";
    }

    private static String __unused_1978() {
        return "Cannot escape a newline character in strict mode";
    }

    private static String __getString_wXk0yAGd_51() {
        String str = __s_cache_DNt36Tno_51;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 219, (byte) 5, (byte) 201, (byte) 68, (byte) 147, (byte) 91, (byte) 188, (byte) 164, (byte) 22, (byte) 200, (byte) 211, (byte) 118, (byte) 123, (byte) 52, (byte) 1, (byte) 105, (byte) 83, (byte) 44, (byte) 246, (byte) 162, (byte) 164, (byte) 62, (byte) 248, (byte) 254, (byte) 143, (byte) 136, (byte) 204, (byte) 37, (byte) 251, (byte) 242, (byte) 65, (byte) 144, (byte) 188, (byte) 36, (byte) 105, (byte) 177, (byte) 226, (byte) 228, (byte) 154, (byte) 19, (byte) 187, (byte) 166, (byte) 124, (byte) 192, (byte) 182, (byte) 45, (byte) 125, s});
        __s_cache_DNt36Tno_51 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_Bh6URluk_52() {
        String str = __s_cache_KjNHHfiz_52;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 132, (byte) 108, (byte) 180, (byte) 123, n, (byte) 109, (byte) 231, (byte) 56, (byte) 31, (byte) 253, (byte) 73, (byte) 41, (byte) 172, (byte) 36, (byte) 62, (byte) 75, (byte) 230, (byte) 232, (byte) 84, (byte) 160, (byte) 94, (byte) 123, (byte) 247, (byte) 244, (byte) 163, (byte) 67, (byte) 47, (byte) 1, (byte) 29, (byte) 81, (byte) 198, (byte) 55});
        __s_cache_KjNHHfiz_52 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1979() {
        return "\nSee ";
    }

    private static String __unused_1980() {
        return "malformed-json";
    }

    private static String __unused_1981() {
        String str = __s_cache_1XFt1q6j_55;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{f(byte) 74a, (byte) 4, (byte) 143, (byte) 176, (byte) 91, (byte) 114, (byte) 114, (byte) 30, (byte) 246, (byte) 222, (byte) 224, (byte) 64, (byte) 206, (byte) 231, (byte) 23, (byte) 105, (byte) 130, (byte) 25, (byte) 8, (byte) 41, (byte) 248, (byte) 245, (byte) 230, (byte) 222, (byte) 137, (byte) 203, (byte) 233, (byte) 59, (byte) 94, (byte) 107, (byte) 104, (byte) 226});
        __s_cache_1XFt1q6j_55 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1982() {
        return "unexpected-json-structure";
    }

    private static String __getString_O0Q7X9WM_57() {
        String str = __s_cache_aJFSUI35_57;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 109, (byte) 35, (byte) 207, (byte) 254, (byte) 1, (byte) 29, (byte) 173, (byte) 61, (byte) 232, v, (byte) 43, (byte) 50, (byte) 114, (byte) 123, (byte) 193, (byte) 146});
        __s_cache_aJFSUI35_57 = strDecrypt;
        return strDecrypt;
    }

    private static String __getString_jwUGD6KN_58() {
        String str = __s_cache_UTfLGQY7_58;
        if (str != null) {
            return str;
        }
        String strDecrypt = AesHelper.decrypt(__aes_key_NHMFviLY, __aes_iv_OjODXgu7, new byte[]{(byte) 33, (byte) 162, (byte) 89, (byte) 159, (byte) 146, (byte) 231, r, (byte) 7, (byte) 121, (byte) 127, (byte) 24, (byte) 45, (byte) 237, (byte) 248, (byte) 177, (byte) 230});
        __s_cache_UTfLGQY7_58 = strDecrypt;
        return strDecrypt;
    }

    private static String __unused_1983() {
        return "\nSee ";
    }
}
