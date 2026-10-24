package a.a.b.b;

import a.a.b.v;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/o.class */
public final class o {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/o$a.class */
    private static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f69a;
        private final C0001a b = new C0001a();

        /* JADX INFO: renamed from: a.a.b.b.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/o$a$a.class */
        private static class C0001a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private char[] f70a;
            private String b;

            private C0001a() {
            }

            void a(char[] cArr) {
                this.f70a = cArr;
                this.b = null;
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f70a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f70a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f70a, i, i2 - i);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.b == null) {
                    this.b = new String(this.f70a);
                }
                return this.b;
            }
        }

        a(Appendable appendable) {
            this.f69a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.a(cArr);
            this.f69a.append(this.b, i, i + i2);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f69a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) throws IOException {
            Objects.requireNonNull(str);
            this.f69a.append(str, i, i + i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f69a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
            this.f69a.append(charSequence, i, i2);
            return this;
        }
    }

    private o() {
        throw new UnsupportedOperationException();
    }

    public static a.a.b.l a(a.a.b.d.a aVar) {
        boolean z = true;
        try {
            aVar.f();
            z = false;
            return a.a.b.b.a.p.V.b(aVar);
        } catch (a.a.b.d.e e) {
            throw new v(e);
        } catch (EOFException e2) {
            if (z) {
                return a.a.b.n.f88a;
            }
            throw new v(e2);
        } catch (IOException e3) {
            throw new a.a.b.m(e3);
        } catch (NumberFormatException e4) {
            throw new v(e4);
        }
    }

    public static void a(a.a.b.l lVar, a.a.b.d.d dVar) {
        a.a.b.b.a.p.V.a(dVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
