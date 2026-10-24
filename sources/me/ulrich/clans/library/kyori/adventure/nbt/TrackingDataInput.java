package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.DataInput;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/TrackingDataInput.class */
final class TrackingDataInput implements DataInput, BinaryTagScope {
    private static final int MAX_DEPTH = 512;
    private final DataInput input;
    private final long maxLength;
    private long counter;
    private int depth;

    TrackingDataInput(DataInput dataInput, long j) {
        this.input = dataInput;
        this.maxLength = j;
    }

    public static BinaryTagScope enter(DataInput dataInput) {
        return dataInput instanceof TrackingDataInput ? ((TrackingDataInput) dataInput).enter() : BinaryTagScope.NoOp.INSTANCE;
    }

    public static BinaryTagScope enter(DataInput dataInput, long j) {
        return dataInput instanceof TrackingDataInput ? ((TrackingDataInput) dataInput).enter(j) : BinaryTagScope.NoOp.INSTANCE;
    }

    public DataInput input() {
        return this.input;
    }

    public TrackingDataInput enter(long j) throws IOException {
        int i = this.depth;
        this.depth = i + 1;
        if (i > 512) {
            throw new IOException("NBT read exceeded maximum depth of 512");
        }
        ensureMaxLength(j);
        return this;
    }

    public TrackingDataInput enter() {
        return enter(0L);
    }

    public void exit() throws IOException {
        this.depth--;
        ensureMaxLength(0L);
    }

    private void ensureMaxLength(long j) throws IOException {
        if (this.maxLength > 0 && this.counter + j > this.maxLength) {
            throw new IOException("The read NBT was longer than the maximum allowed size of " + this.maxLength + " bytes!");
        }
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.counter += (long) bArr.length;
        this.input.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.counter += (long) i2;
        this.input.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.input.skipBytes(i);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        this.counter++;
        return this.input.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        this.counter++;
        return this.input.readByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        this.counter++;
        return this.input.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public short readShort() {
        this.counter += 2;
        return this.input.readShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        this.counter += 2;
        return this.input.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public char readChar() {
        this.counter += 2;
        return this.input.readChar();
    }

    @Override // java.io.DataInput
    public int readInt() {
        this.counter += 4;
        return this.input.readInt();
    }

    @Override // java.io.DataInput
    public long readLong() {
        this.counter += 8;
        return this.input.readLong();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        this.counter += 4;
        return this.input.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        this.counter += 8;
        return this.input.readDouble();
    }

    @Override // java.io.DataInput
    @Nullable
    public String readLine() throws IOException {
        String line = this.input.readLine();
        if (line != null) {
            this.counter += (long) (line.length() + 1);
        }
        return line;
    }

    @Override // java.io.DataInput
    @NotNull
    public String readUTF() throws IOException {
        String utf = this.input.readUTF();
        this.counter += (((long) utf.length()) * 2) + 2;
        return utf;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagScope, java.lang.AutoCloseable
    public void close() throws IOException {
        exit();
    }
}
