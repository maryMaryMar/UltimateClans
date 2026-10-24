package me.ulrich.clans.library.kyori.option;

import java.util.Objects;
import java.util.Set;
import me.ulrich.clans.library.kyori.option.OptionSchemaImpl.MutableImpl;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionSchema.class */
@ApiStatus.NonExtendable
public interface OptionSchema {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/OptionSchema$Mutable.class */
    @ApiStatus.NonExtendable
    public interface Mutable extends OptionSchema {
        Option<String> stringOption(String str, String str2);

        Option<Boolean> booleanOption(String str, boolean z);

        Option<Integer> intOption(String str, int i);

        Option<Double> doubleOption(String str, double d);

        <E extends Enum<E>> Option<E> enumOption(String str, Class<E> cls, E e);

        OptionSchema frozenView();
    }

    static Mutable globalSchema() {
        return OptionSchemaImpl.Instances.GLOBAL;
    }

    static Mutable childSchema(OptionSchema optionSchema) {
        return new OptionSchemaImpl((OptionSchemaImpl) Objects.requireNonNull(optionSchema instanceof OptionSchemaImpl.MutableImpl ? (OptionSchemaImpl) ((Mutable) optionSchema).frozenView() : (OptionSchemaImpl) optionSchema, "impl")).new MutableImpl();
    }

    static Mutable emptySchema() {
        return new OptionSchemaImpl(null).new MutableImpl();
    }

    Set<Option<?>> knownOptions();

    boolean has(Option<?> option);

    OptionState.Builder stateBuilder();

    OptionState.VersionedBuilder versionedStateBuilder();

    OptionState emptyState();
}
