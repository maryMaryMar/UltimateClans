package me.ulrich.clans.library.kyori.adventure.text.serializer.plain;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainTextComponentSerializerImpl.class */
final class PlainTextComponentSerializerImpl implements PlainTextComponentSerializer {
    private static final ComponentFlattener DEFAULT_FLATTENER = ComponentFlattener.basic().mo683toBuilder().unknownMapper(component -> {
        throw new UnsupportedOperationException("Don't know how to turn " + component.getClass().getSimpleName() + " into a string");
    }).build2();
    private static final Optional<PlainTextComponentSerializer.Provider> SERVICE = Services.service(PlainTextComponentSerializer.Provider.class);
    static final Consumer<PlainTextComponentSerializer.Builder> BUILDER = (Consumer) SERVICE.map((v0) -> {
        return v0.plainText();
    }).orElseGet(() -> {
        return builder -> {
        };
    });
    final ComponentFlattener flattener;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainTextComponentSerializerImpl$BuilderImpl.class */
    static final class BuilderImpl implements PlainTextComponentSerializer.Builder {
        private ComponentFlattener flattener;

        BuilderImpl() {
            this.flattener = PlainTextComponentSerializerImpl.DEFAULT_FLATTENER;
            PlainTextComponentSerializerImpl.BUILDER.accept(this);
        }

        BuilderImpl(PlainTextComponentSerializerImpl plainTextComponentSerializerImpl) {
            this();
            this.flattener = plainTextComponentSerializerImpl.flattener;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer.Builder
        public PlainTextComponentSerializer.Builder flattener(@NotNull ComponentFlattener componentFlattener) {
            this.flattener = (ComponentFlattener) Objects.requireNonNull(componentFlattener, "flattener");
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public PlainTextComponentSerializer build2() {
            return new PlainTextComponentSerializerImpl(this.flattener);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/plain/PlainTextComponentSerializerImpl$Instances.class */
    static final class Instances {
        static final PlainTextComponentSerializer INSTANCE = (PlainTextComponentSerializer) PlainTextComponentSerializerImpl.SERVICE.map((v0) -> {
            return v0.plainTextSimple();
        }).orElseGet(() -> {
            return new PlainTextComponentSerializerImpl(PlainTextComponentSerializerImpl.DEFAULT_FLATTENER);
        });

        Instances() {
        }
    }

    PlainTextComponentSerializerImpl(ComponentFlattener componentFlattener) {
        this.flattener = componentFlattener;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
    public void serialize(@NotNull StringBuilder sb, @NotNull Component component) {
        ComponentFlattener componentFlattener = this.flattener;
        Component component2 = (Component) Objects.requireNonNull(component, "component");
        Objects.requireNonNull(sb);
        componentFlattener.flatten(component2, sb::append);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public PlainTextComponentSerializer.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }
}
