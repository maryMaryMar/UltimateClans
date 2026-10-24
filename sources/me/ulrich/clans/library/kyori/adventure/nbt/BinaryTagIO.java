package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagIO.class */
public final class BinaryTagIO {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagIO$Compression.class */
    public static abstract class Compression {
        public static final Compression NONE = new Compression() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression.1
            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression
            @NotNull
            InputStream decompress(@NotNull InputStream inputStream) {
                return inputStream;
            }

            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression
            @NotNull
            OutputStream compress(@NotNull OutputStream outputStream) {
                return outputStream;
            }

            public String toString() {
                return "Compression.NONE";
            }
        };
        public static final Compression GZIP = new Compression() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression.2
            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression
            @NotNull
            InputStream decompress(@NotNull InputStream inputStream) {
                return new GZIPInputStream(inputStream);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression
            @NotNull
            OutputStream compress(@NotNull OutputStream outputStream) {
                return new GZIPOutputStream(outputStream);
            }

            public String toString() {
                return "Compression.GZIP";
            }
        };
        public static final Compression ZLIB = new Compression() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression.3
            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression
            @NotNull
            InputStream decompress(@NotNull InputStream inputStream) {
                return new InflaterInputStream(inputStream);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Compression
            @NotNull
            OutputStream compress(@NotNull OutputStream outputStream) {
                return new DeflaterOutputStream(outputStream);
            }

            public String toString() {
                return "Compression.ZLIB";
            }
        };

        @NotNull
        abstract InputStream decompress(@NotNull InputStream inputStream);

        @NotNull
        abstract OutputStream compress(@NotNull OutputStream outputStream);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagIO$Reader.class */
    public interface Reader {
        @NotNull
        default CompoundBinaryTag read(@NotNull Path path) {
            return read(path, Compression.NONE);
        }

        @NotNull
        CompoundBinaryTag read(@NotNull Path path, @NotNull Compression compression);

        @NotNull
        default CompoundBinaryTag read(@NotNull InputStream inputStream) {
            return read(inputStream, Compression.NONE);
        }

        @NotNull
        CompoundBinaryTag read(@NotNull InputStream inputStream, @NotNull Compression compression);

        @NotNull
        CompoundBinaryTag read(@NotNull DataInput dataInput);

        @NotNull
        default CompoundBinaryTag readNameless(@NotNull Path path) {
            return readNameless(path, Compression.NONE);
        }

        @NotNull
        CompoundBinaryTag readNameless(@NotNull Path path, @NotNull Compression compression);

        @NotNull
        default CompoundBinaryTag readNameless(@NotNull InputStream inputStream) {
            return readNameless(inputStream, Compression.NONE);
        }

        @NotNull
        CompoundBinaryTag readNameless(@NotNull InputStream inputStream, @NotNull Compression compression);

        @NotNull
        CompoundBinaryTag readNameless(@NotNull DataInput dataInput);

        default Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull Path path) {
            return readNamed(path, Compression.NONE);
        }

        Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull Path path, @NotNull Compression compression);

        default Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull InputStream inputStream) {
            return readNamed(inputStream, Compression.NONE);
        }

        Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull InputStream inputStream, @NotNull Compression compression);

        Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull DataInput dataInput);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagIO$Writer.class */
    public interface Writer {
        default void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path) {
            write(compoundBinaryTag, path, Compression.NONE);
        }

        void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path, @NotNull Compression compression);

        default void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream) {
            write(compoundBinaryTag, outputStream, Compression.NONE);
        }

        void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream, @NotNull Compression compression);

        void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull DataOutput dataOutput);

        default void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path) {
            writeNameless(compoundBinaryTag, path, Compression.NONE);
        }

        void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path, @NotNull Compression compression);

        default void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream) {
            writeNameless(compoundBinaryTag, outputStream, Compression.NONE);
        }

        void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream, @NotNull Compression compression);

        void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull DataOutput dataOutput);

        default void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull Path path) {
            writeNamed(entry, path, Compression.NONE);
        }

        void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull Path path, @NotNull Compression compression);

        default void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull OutputStream outputStream) {
            writeNamed(entry, outputStream, Compression.NONE);
        }

        void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull OutputStream outputStream, @NotNull Compression compression);

        void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull DataOutput dataOutput);
    }

    private BinaryTagIO() {
    }

    @NotNull
    public static Reader unlimitedReader() {
        return BinaryTagReaderImpl.UNLIMITED;
    }

    @NotNull
    public static Reader reader() {
        return BinaryTagReaderImpl.DEFAULT_LIMIT;
    }

    @NotNull
    public static Reader reader(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("The size limit must be greater than zero");
        }
        return new BinaryTagReaderImpl(j);
    }

    @NotNull
    public static Writer writer() {
        return BinaryTagWriterImpl.INSTANCE;
    }

    @Deprecated
    @NotNull
    public static CompoundBinaryTag readPath(@NotNull Path path) {
        return reader().read(path);
    }

    @Deprecated
    @NotNull
    public static CompoundBinaryTag readInputStream(@NotNull InputStream inputStream) {
        return reader().read(inputStream);
    }

    @Deprecated
    @NotNull
    public static CompoundBinaryTag readCompressedPath(@NotNull Path path) {
        return reader().read(path, Compression.GZIP);
    }

    @Deprecated
    @NotNull
    public static CompoundBinaryTag readCompressedInputStream(@NotNull InputStream inputStream) {
        return reader().read(inputStream, Compression.GZIP);
    }

    @Deprecated
    @NotNull
    public static CompoundBinaryTag readDataInput(@NotNull DataInput dataInput) {
        return reader().read(dataInput);
    }

    @Deprecated
    public static void writePath(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path) {
        writer().write(compoundBinaryTag, path);
    }

    @Deprecated
    public static void writeOutputStream(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream) {
        writer().write(compoundBinaryTag, outputStream);
    }

    @Deprecated
    public static void writeCompressedPath(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path) {
        writer().write(compoundBinaryTag, path, Compression.GZIP);
    }

    @Deprecated
    public static void writeCompressedOutputStream(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream) {
        writer().write(compoundBinaryTag, outputStream, Compression.GZIP);
    }

    @Deprecated
    public static void writeDataOutput(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull DataOutput dataOutput) {
        writer().write(compoundBinaryTag, dataOutput);
    }

    static {
        BinaryTagTypes.COMPOUND.id();
    }
}
