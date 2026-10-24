package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagReaderImpl.class */
final class BinaryTagReaderImpl implements BinaryTagIO.Reader {
    private final long maxBytes;
    static final BinaryTagIO.Reader UNLIMITED = new BinaryTagReaderImpl(-1);
    static final BinaryTagIO.Reader DEFAULT_LIMIT = new BinaryTagReaderImpl(131082);

    BinaryTagReaderImpl(long j) {
        this.maxBytes = j;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    @NotNull
    public CompoundBinaryTag read(@NotNull Path path, BinaryTagIO.Compression compression) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            CompoundBinaryTag compoundBinaryTag = read(inputStreamNewInputStream, compression);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return compoundBinaryTag;
        } catch (Throwable th) {
            if (inputStreamNewInputStream != null) {
                try {
                    inputStreamNewInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    @NotNull
    public CompoundBinaryTag read(@NotNull InputStream inputStream, BinaryTagIO.Compression compression) {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(compression.decompress(IOStreamUtil.closeShield(inputStream))));
        try {
            CompoundBinaryTag compoundBinaryTag = read((DataInput) dataInputStream);
            dataInputStream.close();
            return compoundBinaryTag;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    @NotNull
    public CompoundBinaryTag read(@NotNull DataInput dataInput) {
        return read(dataInput, true);
    }

    @NotNull
    private CompoundBinaryTag read(@NotNull DataInput dataInput, boolean z) throws IOException {
        if (!(dataInput instanceof TrackingDataInput)) {
            dataInput = new TrackingDataInput(dataInput, this.maxBytes);
        }
        requireCompound(BinaryTagType.binaryTagType(dataInput.readByte()));
        if (z) {
            dataInput.skipBytes(dataInput.readUnsignedShort());
        }
        return (CompoundBinaryTag) BinaryTagTypes.COMPOUND.read(dataInput);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    @NotNull
    public CompoundBinaryTag readNameless(@NotNull Path path, BinaryTagIO.Compression compression) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            CompoundBinaryTag nameless = readNameless(inputStreamNewInputStream, compression);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return nameless;
        } catch (Throwable th) {
            if (inputStreamNewInputStream != null) {
                try {
                    inputStreamNewInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    @NotNull
    public CompoundBinaryTag readNameless(@NotNull InputStream inputStream, BinaryTagIO.Compression compression) {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(compression.decompress(IOStreamUtil.closeShield(inputStream))));
        try {
            CompoundBinaryTag nameless = readNameless((DataInput) dataInputStream);
            dataInputStream.close();
            return nameless;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    @NotNull
    public CompoundBinaryTag readNameless(@NotNull DataInput dataInput) {
        return read(dataInput, false);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    public Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull Path path, BinaryTagIO.Compression compression) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            Map.Entry<String, CompoundBinaryTag> named = readNamed(inputStreamNewInputStream, compression);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return named;
        } catch (Throwable th) {
            if (inputStreamNewInputStream != null) {
                try {
                    inputStreamNewInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    public Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull InputStream inputStream, BinaryTagIO.Compression compression) {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(compression.decompress(IOStreamUtil.closeShield(inputStream))));
        try {
            Map.Entry<String, CompoundBinaryTag> named = readNamed((DataInput) dataInputStream);
            dataInputStream.close();
            return named;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Reader
    public Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull DataInput dataInput) throws IOException {
        requireCompound(BinaryTagType.binaryTagType(dataInput.readByte()));
        return new AbstractMap.SimpleImmutableEntry(dataInput.readUTF(), (CompoundBinaryTag) BinaryTagTypes.COMPOUND.read(dataInput));
    }

    private static void requireCompound(BinaryTagType<? extends BinaryTag> binaryTagType) throws IOException {
        if (binaryTagType != BinaryTagTypes.COMPOUND) {
            throw new IOException(String.format("Expected root tag to be a %s, was %s", BinaryTagTypes.COMPOUND, binaryTagType));
        }
    }
}
