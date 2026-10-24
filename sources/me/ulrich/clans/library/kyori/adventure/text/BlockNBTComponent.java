package me.ulrich.clans.library.kyori.adventure.text;

import java.util.regex.Matcher;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent.class */
public interface BlockNBTComponent extends NBTComponent<BlockNBTComponent, Builder>, ScopedComponent<BlockNBTComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent$Builder.class */
    public interface Builder extends NBTComponentBuilder<BlockNBTComponent, Builder> {
        @Contract("_ -> this")
        @NotNull
        Builder pos(@NotNull Pos pos);

        @Contract("_, _, _ -> this")
        @NotNull
        default Builder localPos(double d, double d2, double d3) {
            return pos(LocalPos.localPos(d, d2, d3));
        }

        @Contract("_, _, _ -> this")
        @NotNull
        default Builder worldPos(WorldPos.Coordinate coordinate, WorldPos.Coordinate coordinate2, WorldPos.Coordinate coordinate3) {
            return pos(WorldPos.worldPos(coordinate, coordinate2, coordinate3));
        }

        @Contract("_, _, _ -> this")
        @NotNull
        default Builder absoluteWorldPos(int i, int i2, int i3) {
            return worldPos(WorldPos.Coordinate.absolute(i), WorldPos.Coordinate.absolute(i2), WorldPos.Coordinate.absolute(i3));
        }

        @Contract("_, _, _ -> this")
        @NotNull
        default Builder relativeWorldPos(int i, int i2, int i3) {
            return worldPos(WorldPos.Coordinate.relative(i), WorldPos.Coordinate.relative(i2), WorldPos.Coordinate.relative(i3));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent$LocalPos.class */
    public interface LocalPos extends Pos {
        @NotNull
        static LocalPos localPos(double d, double d2, double d3) {
            return new BlockNBTComponentImpl.LocalPosImpl(d, d2, d3);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        static LocalPos of(double d, double d2, double d3) {
            return new BlockNBTComponentImpl.LocalPosImpl(d, d2, d3);
        }

        double left();

        double up();

        double forwards();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent$Pos.class */
    public interface Pos extends Examinable {
        @NotNull
        static Pos fromString(@NotNull String str) {
            Matcher matcher = BlockNBTComponentImpl.Tokens.LOCAL_PATTERN.matcher(str);
            if (matcher.matches()) {
                return LocalPos.localPos(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(3)), Double.parseDouble(matcher.group(5)));
            }
            Matcher matcher2 = BlockNBTComponentImpl.Tokens.WORLD_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return WorldPos.worldPos(BlockNBTComponentImpl.Tokens.deserializeCoordinate(matcher2.group(1), matcher2.group(2)), BlockNBTComponentImpl.Tokens.deserializeCoordinate(matcher2.group(3), matcher2.group(4)), BlockNBTComponentImpl.Tokens.deserializeCoordinate(matcher2.group(5), matcher2.group(6)));
            }
            throw new IllegalArgumentException("Cannot convert position specification '" + str + "' into a position");
        }

        @NotNull
        String asString();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent$WorldPos.class */
    public interface WorldPos extends Pos {

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent$WorldPos$Coordinate.class */
        public interface Coordinate extends Examinable {

            /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/BlockNBTComponent$WorldPos$Coordinate$Type.class */
            public enum Type {
                ABSOLUTE,
                RELATIVE
            }

            @NotNull
            static Coordinate absolute(int i) {
                return coordinate(i, Type.ABSOLUTE);
            }

            @NotNull
            static Coordinate relative(int i) {
                return coordinate(i, Type.RELATIVE);
            }

            @NotNull
            static Coordinate coordinate(int i, @NotNull Type type) {
                return new BlockNBTComponentImpl.WorldPosImpl.CoordinateImpl(i, type);
            }

            @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
            @Deprecated
            @NotNull
            static Coordinate of(int i, @NotNull Type type) {
                return new BlockNBTComponentImpl.WorldPosImpl.CoordinateImpl(i, type);
            }

            int value();

            @NotNull
            Type type();
        }

        @NotNull
        static WorldPos worldPos(@NotNull Coordinate coordinate, @NotNull Coordinate coordinate2, @NotNull Coordinate coordinate3) {
            return new BlockNBTComponentImpl.WorldPosImpl(coordinate, coordinate2, coordinate3);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        static WorldPos of(@NotNull Coordinate coordinate, @NotNull Coordinate coordinate2, @NotNull Coordinate coordinate3) {
            return new BlockNBTComponentImpl.WorldPosImpl(coordinate, coordinate2, coordinate3);
        }

        @NotNull
        Coordinate x();

        @NotNull
        Coordinate y();

        @NotNull
        Coordinate z();
    }

    @NotNull
    Pos pos();

    @Contract(pure = true)
    @NotNull
    BlockNBTComponent pos(@NotNull Pos pos);

    @Contract(pure = true)
    @NotNull
    default BlockNBTComponent localPos(double d, double d2, double d3) {
        return pos(LocalPos.localPos(d, d2, d3));
    }

    @Contract(pure = true)
    @NotNull
    default BlockNBTComponent worldPos(WorldPos.Coordinate coordinate, WorldPos.Coordinate coordinate2, WorldPos.Coordinate coordinate3) {
        return pos(WorldPos.worldPos(coordinate, coordinate2, coordinate3));
    }

    @Contract(pure = true)
    @NotNull
    default BlockNBTComponent absoluteWorldPos(int i, int i2, int i3) {
        return worldPos(WorldPos.Coordinate.absolute(i), WorldPos.Coordinate.absolute(i2), WorldPos.Coordinate.absolute(i3));
    }

    @Contract(pure = true)
    @NotNull
    default BlockNBTComponent relativeWorldPos(int i, int i2, int i3) {
        return worldPos(WorldPos.Coordinate.relative(i), WorldPos.Coordinate.relative(i2), WorldPos.Coordinate.relative(i3));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent, me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("pos", pos())), super.examinableProperties());
    }
}
