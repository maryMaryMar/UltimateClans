package me.ulrich.clans.library.kyori.option;

import java.util.Map;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.option.value.ValueSource;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionState.class */
@ApiStatus.NonExtendable
public interface OptionState {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionState$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder {
        <V> Builder value(Option<V> option, V v);

        Builder values(OptionState optionState);

        Builder values(ValueSource valueSource);

        OptionState build();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionState$Versioned.class */
    @ApiStatus.NonExtendable
    public interface Versioned extends OptionState {
        Map<Integer, OptionState> childStates();

        Versioned at(int i);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionState$VersionedBuilder.class */
    @ApiStatus.NonExtendable
    public interface VersionedBuilder {
        VersionedBuilder version(int i, Consumer<Builder> consumer);

        Versioned build();
    }

    @Deprecated
    static OptionState emptyOptionState() {
        return OptionSchema.globalSchema().emptyState();
    }

    @Deprecated
    static Builder optionState() {
        return OptionSchema.globalSchema().stateBuilder();
    }

    @Deprecated
    static VersionedBuilder versionedOptionState() {
        return OptionSchema.globalSchema().versionedStateBuilder();
    }

    OptionSchema schema();

    boolean has(Option<?> option);

    <V> V value(Option<V> option);
}
