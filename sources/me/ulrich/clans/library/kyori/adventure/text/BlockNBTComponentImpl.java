package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.util.ShadyPines;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponentImpl.class */
final class BlockNBTComponentImpl extends NBTComponentImpl<BlockNBTComponent, BlockNBTComponent.Builder> implements BlockNBTComponent {
    private final BlockNBTComponent.Pos pos;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractNBTComponentBuilder<BlockNBTComponent, BlockNBTComponent.Builder> implements BlockNBTComponent.Builder {

        @Nullable
        private BlockNBTComponent.Pos pos;

        BuilderImpl() {
        }

        BuilderImpl(@NotNull BlockNBTComponent blockNBTComponent) {
            super(blockNBTComponent);
            this.pos = blockNBTComponent.pos();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.Builder
        public BlockNBTComponent.Builder pos(@NotNull BlockNBTComponent.Pos pos) {
            this.pos = (BlockNBTComponent.Pos) Objects.requireNonNull(pos, "pos");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public BlockNBTComponent build2() {
            if (this.nbtPath == null) {
                throw new IllegalStateException("nbt path must be set");
            }
            if (this.pos == null) {
                throw new IllegalStateException("pos must be set");
            }
            return BlockNBTComponentImpl.create(this.children, buildStyle(), this.nbtPath, this.interpret, this.separator, this.pos);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponentImpl$LocalPosImpl.class */
    static final class LocalPosImpl implements BlockNBTComponent.LocalPos {
        private final double left;
        private final double up;
        private final double forwards;

        LocalPosImpl(double d, double d2, double d3) {
            this.left = d;
            this.up = d2;
            this.forwards = d3;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.LocalPos
        public double left() {
            return this.left;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.LocalPos
        public double up() {
            return this.up;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.LocalPos
        public double forwards() {
            return this.forwards;
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("left", this.left), ExaminableProperty.of("up", this.up), ExaminableProperty.of("forwards", this.forwards)});
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BlockNBTComponent.LocalPos)) {
                return false;
            }
            BlockNBTComponent.LocalPos localPos = (BlockNBTComponent.LocalPos) obj;
            return ShadyPines.equals(localPos.left(), left()) && ShadyPines.equals(localPos.up(), up()) && ShadyPines.equals(localPos.forwards(), forwards());
        }

        public int hashCode() {
            return (31 * ((31 * Double.hashCode(this.left)) + Double.hashCode(this.up))) + Double.hashCode(this.forwards);
        }

        public String toString() {
            return String.format("^%f ^%f ^%f", Double.valueOf(this.left), Double.valueOf(this.up), Double.valueOf(this.forwards));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.Pos
        @NotNull
        public String asString() {
            return Tokens.serializeLocal(this.left) + ' ' + Tokens.serializeLocal(this.up) + ' ' + Tokens.serializeLocal(this.forwards);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponentImpl$Tokens.class */
    static final class Tokens {
        static final Pattern LOCAL_PATTERN = Pattern.compile("^\\^(-?\\d+(\\.\\d+)?) \\^(-?\\d+(\\.\\d+)?) \\^(-?\\d+(\\.\\d+)?)$");
        static final Pattern WORLD_PATTERN = Pattern.compile("^(~?)(-?\\d+) (~?)(-?\\d+) (~?)(-?\\d+)$");
        static final String LOCAL_SYMBOL = "^";
        static final String RELATIVE_SYMBOL = "~";
        static final String ABSOLUTE_SYMBOL = "";

        private Tokens() {
        }

        static BlockNBTComponent.WorldPos.Coordinate deserializeCoordinate(String str, String str2) {
            int i = Integer.parseInt(str2);
            if (str.equals("")) {
                return BlockNBTComponent.WorldPos.Coordinate.absolute(i);
            }
            if (str.equals(RELATIVE_SYMBOL)) {
                return BlockNBTComponent.WorldPos.Coordinate.relative(i);
            }
            throw new AssertionError();
        }

        static String serializeLocal(double d) {
            return LOCAL_SYMBOL + d;
        }

        static String serializeCoordinate(BlockNBTComponent.WorldPos.Coordinate coordinate) {
            return (coordinate.type() == BlockNBTComponent.WorldPos.Coordinate.Type.RELATIVE ? RELATIVE_SYMBOL : "") + coordinate.value();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponentImpl$WorldPosImpl.class */
    static final class WorldPosImpl implements BlockNBTComponent.WorldPos {
        private final BlockNBTComponent.WorldPos.Coordinate x;
        private final BlockNBTComponent.WorldPos.Coordinate y;
        private final BlockNBTComponent.WorldPos.Coordinate z;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponentImpl$WorldPosImpl$CoordinateImpl.class */
        static final class CoordinateImpl implements BlockNBTComponent.WorldPos.Coordinate {
            private final int value;
            private final BlockNBTComponent.WorldPos.Coordinate.Type type;

            CoordinateImpl(int i, @NotNull BlockNBTComponent.WorldPos.Coordinate.Type type) {
                this.value = i;
                this.type = (BlockNBTComponent.WorldPos.Coordinate.Type) Objects.requireNonNull(type, "type");
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.WorldPos.Coordinate
            public int value() {
                return this.value;
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.WorldPos.Coordinate
            @NotNull
            public BlockNBTComponent.WorldPos.Coordinate.Type type() {
                return this.type;
            }

            @Override // me.ulrich.clans.library.kyori.examination.Examinable
            @NotNull
            public Stream<? extends ExaminableProperty> examinableProperties() {
                return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("value", this.value), ExaminableProperty.of("type", this.type)});
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof BlockNBTComponent.WorldPos.Coordinate)) {
                    return false;
                }
                BlockNBTComponent.WorldPos.Coordinate coordinate = (BlockNBTComponent.WorldPos.Coordinate) obj;
                return value() == coordinate.value() && type() == coordinate.type();
            }

            public int hashCode() {
                return (31 * this.value) + this.type.hashCode();
            }

            public String toString() {
                return (this.type == BlockNBTComponent.WorldPos.Coordinate.Type.RELATIVE ? "~" : "") + this.value;
            }
        }

        WorldPosImpl(BlockNBTComponent.WorldPos.Coordinate coordinate, BlockNBTComponent.WorldPos.Coordinate coordinate2, BlockNBTComponent.WorldPos.Coordinate coordinate3) {
            this.x = (BlockNBTComponent.WorldPos.Coordinate) Objects.requireNonNull(coordinate, "x");
            this.y = (BlockNBTComponent.WorldPos.Coordinate) Objects.requireNonNull(coordinate2, "y");
            this.z = (BlockNBTComponent.WorldPos.Coordinate) Objects.requireNonNull(coordinate3, "z");
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.WorldPos
        @NotNull
        public BlockNBTComponent.WorldPos.Coordinate x() {
            return this.x;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.WorldPos
        @NotNull
        public BlockNBTComponent.WorldPos.Coordinate y() {
            return this.y;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.WorldPos
        @NotNull
        public BlockNBTComponent.WorldPos.Coordinate z() {
            return this.z;
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("x", this.x), ExaminableProperty.of("y", this.y), ExaminableProperty.of("z", this.z)});
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BlockNBTComponent.WorldPos)) {
                return false;
            }
            BlockNBTComponent.WorldPos worldPos = (BlockNBTComponent.WorldPos) obj;
            return this.x.equals(worldPos.x()) && this.y.equals(worldPos.y()) && this.z.equals(worldPos.z());
        }

        public int hashCode() {
            return (31 * ((31 * this.x.hashCode()) + this.y.hashCode())) + this.z.hashCode();
        }

        public String toString() {
            return this.x.toString() + ' ' + this.y.toString() + ' ' + this.z.toString();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent.Pos
        @NotNull
        public String asString() {
            return Tokens.serializeCoordinate(x()) + ' ' + Tokens.serializeCoordinate(y()) + ' ' + Tokens.serializeCoordinate(z());
        }
    }

    static BlockNBTComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, String str, boolean z, @Nullable ComponentLike componentLike, @NotNull BlockNBTComponent.Pos pos) {
        return new BlockNBTComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, "nbtPath"), z, ComponentLike.unbox(componentLike), (BlockNBTComponent.Pos) Objects.requireNonNull(pos, "pos"));
    }

    BlockNBTComponentImpl(@NotNull List<Component> list, @NotNull Style style, String str, boolean z, @Nullable Component component, @NotNull BlockNBTComponent.Pos pos) {
        super(list, style, str, z, component);
        this.pos = pos;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public BlockNBTComponent nbtPath(@NotNull String str) {
        return Objects.equals(this.nbtPath, str) ? this : create(this.children, this.style, str, this.interpret, this.separator, this.pos);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public BlockNBTComponent interpret(boolean z) {
        return this.interpret == z ? this : create(this.children, this.style, this.nbtPath, z, this.separator, this.pos);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @Nullable
    public Component separator() {
        return this.separator;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public BlockNBTComponent separator(@Nullable ComponentLike componentLike) {
        return create(this.children, this.style, this.nbtPath, this.interpret, componentLike, this.pos);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent
    @NotNull
    public BlockNBTComponent.Pos pos() {
        return this.pos;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent
    @NotNull
    public BlockNBTComponent pos(@NotNull BlockNBTComponent.Pos pos) {
        return create(this.children, this.style, this.nbtPath, this.interpret, this.separator, pos);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public BlockNBTComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.nbtPath, this.interpret, this.separator, this.pos);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public BlockNBTComponent style(@NotNull Style style) {
        return create(this.children, style, this.nbtPath, this.interpret, this.separator, this.pos);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BlockNBTComponent) && super.equals(obj)) {
            return Objects.equals(this.pos, ((BlockNBTComponent) obj).pos());
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * super.hashCode()) + this.pos.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentImpl, me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public BlockNBTComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
