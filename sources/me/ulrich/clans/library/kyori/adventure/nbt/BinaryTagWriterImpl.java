package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/BinaryTagWriterImpl.class */
final class BinaryTagWriterImpl implements BinaryTagIO.Writer {
    static final BinaryTagIO.Writer INSTANCE = new BinaryTagWriterImpl();

    BinaryTagWriterImpl() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path, BinaryTagIO.Compression compression) throws IOException {
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, new OpenOption[0]);
        try {
            write(compoundBinaryTag, outputStreamNewOutputStream, compression);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
        } catch (Throwable th) {
            if (outputStreamNewOutputStream != null) {
                try {
                    outputStreamNewOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream, BinaryTagIO.Compression compression) {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(compression.compress(IOStreamUtil.closeShield(outputStream))));
        try {
            write(compoundBinaryTag, (DataOutput) dataOutputStream);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull DataOutput dataOutput) throws IOException {
        write(compoundBinaryTag, dataOutput, true);
    }

    private void write(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull DataOutput dataOutput, boolean z) throws IOException {
        dataOutput.writeByte(BinaryTagTypes.COMPOUND.id());
        if (z) {
            dataOutput.writeUTF("");
        }
        BinaryTagTypes.COMPOUND.write(compoundBinaryTag, dataOutput);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull Path path, BinaryTagIO.Compression compression) throws IOException {
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, new OpenOption[0]);
        try {
            writeNameless(compoundBinaryTag, outputStreamNewOutputStream, compression);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
        } catch (Throwable th) {
            if (outputStreamNewOutputStream != null) {
                try {
                    outputStreamNewOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull OutputStream outputStream, BinaryTagIO.Compression compression) {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(compression.compress(IOStreamUtil.closeShield(outputStream))));
        try {
            writeNameless(compoundBinaryTag, (DataOutput) dataOutputStream);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void writeNameless(@NotNull CompoundBinaryTag compoundBinaryTag, @NotNull DataOutput dataOutput) throws IOException {
        write(compoundBinaryTag, dataOutput, false);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull Path path, BinaryTagIO.Compression compression) throws IOException {
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, new OpenOption[0]);
        try {
            writeNamed(entry, outputStreamNewOutputStream, compression);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
        } catch (Throwable th) {
            if (outputStreamNewOutputStream != null) {
                try {
                    outputStreamNewOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull OutputStream outputStream, BinaryTagIO.Compression compression) {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(compression.compress(IOStreamUtil.closeShield(outputStream))));
        try {
            writeNamed(entry, (DataOutput) dataOutputStream);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.BinaryTagIO.Writer
    public void writeNamed(Map.Entry<String, CompoundBinaryTag> entry, @NotNull DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(BinaryTagTypes.COMPOUND.id());
        dataOutput.writeUTF(entry.getKey());
        BinaryTagTypes.COMPOUND.write(entry.getValue(), dataOutput);
    }
}
