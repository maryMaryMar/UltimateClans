package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagType.class */
public abstract class BinaryTagType<T extends BinaryTag> implements Predicate<BinaryTagType<? extends BinaryTag>> {
    private static final List<BinaryTagType<? extends BinaryTag>> TYPES = new ArrayList();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagType$Impl.class */
    static class Impl<T extends BinaryTag> extends BinaryTagType<T> {
        final Class<T> type;
        final byte id;
        private final Reader<T> reader;

        @Nullable
        private final Writer<T> writer;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagType$Impl$Numeric.class */
        static class Numeric<T extends BinaryTag> extends Impl<T> {
            Numeric(Class<T> cls, byte b, Reader<T> reader, @Nullable Writer<T> writer) {
                super(cls, b, reader, writer);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType.Impl, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType
            boolean numeric() {
                return true;
            }

            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType.Impl
            public String toString() {
                return BinaryTagType.class.getSimpleName() + '[' + this.type.getSimpleName() + " " + ((int) this.id) + " (numeric)]";
            }

            @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType.Impl, me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType, java.util.function.Predicate
            public /* bridge */ /* synthetic */ boolean test(BinaryTagType<? extends BinaryTag> binaryTagType) {
                return super.test(binaryTagType);
            }
        }

        Impl(Class<T> cls, byte b, Reader<T> reader, @Nullable Writer<T> writer) {
            this.type = cls;
            this.id = b;
            this.reader = reader;
            this.writer = writer;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType
        @NotNull
        public final T read(@NotNull DataInput dataInput) {
            return (T) this.reader.read(dataInput);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType
        public final void write(@NotNull T t, @NotNull DataOutput dataOutput) {
            if (this.writer != null) {
                this.writer.write(t, dataOutput);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType
        public final byte id() {
            return this.id;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType
        boolean numeric() {
            return false;
        }

        public String toString() {
            return BinaryTagType.class.getSimpleName() + '[' + this.type.getSimpleName() + " " + ((int) this.id) + "]";
        }

        @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagType, java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(BinaryTagType<? extends BinaryTag> binaryTagType) {
            return super.test(binaryTagType);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagType$Reader.class */
    interface Reader<T extends BinaryTag> {
        @NotNull
        T read(@NotNull DataInput dataInput);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagType$Writer.class */
    interface Writer<T extends BinaryTag> {
        void write(@NotNull T t, @NotNull DataOutput dataOutput);
    }

    public abstract byte id();

    abstract boolean numeric();

    @NotNull
    public abstract T read(@NotNull DataInput dataInput);

    public abstract void write(@NotNull T t, @NotNull DataOutput dataOutput);

    static <T extends BinaryTag> void writeUntyped(BinaryTagType<? extends BinaryTag> binaryTagType, T t, DataOutput dataOutput) {
        binaryTagType.write(t, dataOutput);
    }

    @NotNull
    static BinaryTagType<? extends BinaryTag> binaryTagType(byte b) {
        for (int i = 0; i < TYPES.size(); i++) {
            BinaryTagType<? extends BinaryTag> binaryTagType = TYPES.get(i);
            if (binaryTagType.id() == b) {
                return binaryTagType;
            }
        }
        throw new IllegalArgumentException(String.valueOf((int) b));
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static BinaryTagType<? extends BinaryTag> of(byte b) {
        return binaryTagType(b);
    }

    @NotNull
    static <T extends BinaryTag> BinaryTagType<T> register(Class<T> cls, byte b, Reader<T> reader, @Nullable Writer<T> writer) {
        return register(new Impl(cls, b, reader, writer));
    }

    @NotNull
    static <T extends NumberBinaryTag> BinaryTagType<T> registerNumeric(Class<T> cls, byte b, Reader<T> reader, Writer<T> writer) {
        return register(new Impl.Numeric(cls, b, reader, writer));
    }

    private static <T extends BinaryTag, Y extends BinaryTagType<T>> Y register(Y y) {
        TYPES.add(y);
        return y;
    }

    @Override // java.util.function.Predicate
    public boolean test(BinaryTagType<? extends BinaryTag> binaryTagType) {
        return this == binaryTagType || (numeric() && binaryTagType.numeric());
    }
}
