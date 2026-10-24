package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/IOStreamUtil.class */
final class IOStreamUtil {
    private IOStreamUtil() {
    }

    static InputStream closeShield(final InputStream inputStream) {
        return new InputStream() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.IOStreamUtil.1
            @Override // java.io.InputStream
            public int read() {
                return inputStream.read();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr) {
                return inputStream.read(bArr);
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return inputStream.read(bArr, i, i2);
            }
        };
    }

    static OutputStream closeShield(final OutputStream outputStream) {
        return new OutputStream() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.IOStreamUtil.2
            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                outputStream.write(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                outputStream.write(bArr);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                outputStream.write(bArr, i, i2);
            }
        };
    }
}
