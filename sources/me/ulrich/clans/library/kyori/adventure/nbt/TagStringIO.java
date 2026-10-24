package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/TagStringIO.class */
public final class TagStringIO {
    private static final TagStringIO INSTANCE = new TagStringIO(new Builder());
    private final boolean acceptLegacy;
    private final boolean emitLegacy;
    private final String indent;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/TagStringIO$Builder.class */
    public static class Builder {
        private boolean acceptLegacy = true;
        private boolean emitLegacy = false;
        private String indent = "";

        Builder() {
        }

        @NotNull
        public Builder indent(int i) {
            if (i == 0) {
                this.indent = "";
            } else if ((this.indent.length() > 0 && this.indent.charAt(0) != ' ') || i != this.indent.length()) {
                char[] cArr = new char[i];
                Arrays.fill(cArr, ' ');
                this.indent = String.copyValueOf(cArr);
            }
            return this;
        }

        @NotNull
        public Builder indentTab(int i) {
            if (i == 0) {
                this.indent = "";
            } else if ((this.indent.length() > 0 && this.indent.charAt(0) != '\t') || i != this.indent.length()) {
                char[] cArr = new char[i];
                Arrays.fill(cArr, '\t');
                this.indent = String.copyValueOf(cArr);
            }
            return this;
        }

        @NotNull
        public Builder acceptLegacy(boolean z) {
            this.acceptLegacy = z;
            return this;
        }

        @NotNull
        public Builder emitLegacy(boolean z) {
            this.emitLegacy = z;
            return this;
        }

        @NotNull
        public TagStringIO build() {
            return new TagStringIO(this);
        }
    }

    @NotNull
    public static TagStringIO get() {
        return INSTANCE;
    }

    @NotNull
    public static Builder builder() {
        return new Builder();
    }

    private TagStringIO(@NotNull Builder builder) {
        this.acceptLegacy = builder.acceptLegacy;
        this.emitLegacy = builder.emitLegacy;
        this.indent = builder.indent;
    }

    public CompoundBinaryTag asCompound(String str) throws IOException {
        try {
            CharBuffer charBuffer = new CharBuffer(str);
            TagStringReader tagStringReader = new TagStringReader(charBuffer);
            tagStringReader.legacy(this.acceptLegacy);
            CompoundBinaryTag compoundBinaryTagCompound = tagStringReader.compound();
            if (charBuffer.skipWhitespace().hasMore()) {
                throw new IOException("Document had trailing content after first CompoundTag");
            }
            return compoundBinaryTagCompound;
        } catch (StringTagParseException e) {
            throw new IOException(e);
        }
    }

    public String asString(CompoundBinaryTag compoundBinaryTag) {
        return asString((BinaryTag) compoundBinaryTag);
    }

    public String asString(BinaryTag binaryTag) throws IOException {
        StringBuilder sb = new StringBuilder();
        TagStringWriter tagStringWriter = new TagStringWriter(sb, this.indent);
        try {
            tagStringWriter.legacy(this.emitLegacy);
            tagStringWriter.writeTag(binaryTag);
            tagStringWriter.close();
            return sb.toString();
        } catch (Throwable th) {
            try {
                tagStringWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void toWriter(CompoundBinaryTag compoundBinaryTag, Writer writer) throws IOException {
        TagStringWriter tagStringWriter = new TagStringWriter(writer, this.indent);
        try {
            tagStringWriter.legacy(this.emitLegacy);
            tagStringWriter.writeTag(compoundBinaryTag);
            tagStringWriter.close();
        } catch (Throwable th) {
            try {
                tagStringWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
