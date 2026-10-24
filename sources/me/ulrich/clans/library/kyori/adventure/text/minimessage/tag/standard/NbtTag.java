package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/NbtTag.class */
final class NbtTag {
    private static final String NBT = "nbt";
    private static final String BLOCK = "block";
    private static final String ENTITY = "entity";
    private static final String STORAGE = "storage";
    private static final String INTERPRET = "interpret";
    private static final String DATA = "data";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(StandardTags.names("nbt", DATA), (BiFunction<ArgumentQueue, Context, Tag>) NbtTag::resolve, (Function<Component, Emitable>) NbtTag::emit);

    private NbtTag() {
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.text.Component] */
    static Tag resolve(ArgumentQueue argumentQueue, Context context) {
        NBTComponentBuilder nBTComponentBuilderStorage;
        String strLowerValue = argumentQueue.popOr("a type of block, entity, or storage is required").lowerValue();
        if ("block".equals(strLowerValue)) {
            try {
                nBTComponentBuilderStorage = Component.blockNBT().pos(BlockNBTComponent.Pos.fromString(argumentQueue.popOr("A position is required").value()));
            } catch (IllegalArgumentException e) {
                throw context.newException(e.getMessage(), argumentQueue);
            }
        } else if ("entity".equals(strLowerValue)) {
            nBTComponentBuilderStorage = Component.entityNBT().selector(argumentQueue.popOr("A selector is required").value());
        } else {
            if (!"storage".equals(strLowerValue)) {
                throw context.newException("Unknown nbt tag type '" + strLowerValue + "'", argumentQueue);
            }
            nBTComponentBuilderStorage = Component.storageNBT().storage(Key.key(argumentQueue.popOr("A storage key is required").value()));
        }
        nBTComponentBuilderStorage.nbtPath(argumentQueue.popOr("An NBT path is required").value());
        if (argumentQueue.hasNext()) {
            String strValue = argumentQueue.pop().value();
            if ("interpret".equalsIgnoreCase(strValue)) {
                nBTComponentBuilderStorage.interpret(true);
            } else {
                nBTComponentBuilderStorage.separator(context.deserialize(strValue));
                if (argumentQueue.hasNext() && argumentQueue.pop().value().equalsIgnoreCase("interpret")) {
                    nBTComponentBuilderStorage.interpret(true);
                }
            }
        }
        return Tag.inserting((Component) nBTComponentBuilderStorage.build2());
    }

    @Nullable
    static Emitable emit(Component component) {
        String str;
        String strAsString;
        if (component instanceof BlockNBTComponent) {
            str = "block";
            strAsString = ((BlockNBTComponent) component).pos().asString();
        } else if (component instanceof EntityNBTComponent) {
            str = "entity";
            strAsString = ((EntityNBTComponent) component).selector();
        } else {
            if (!(component instanceof StorageNBTComponent)) {
                return null;
            }
            str = "storage";
            strAsString = ((StorageNBTComponent) component).storage().asString();
        }
        String str2 = str;
        String str3 = strAsString;
        return tokenEmitter -> {
            NBTComponent nBTComponent = (NBTComponent) component;
            tokenEmitter.tag("nbt").argument(str2).argument(str3).argument(nBTComponent.nbtPath());
            if (nBTComponent.separator() != null) {
                tokenEmitter.argument(nBTComponent.separator());
            }
            if (nBTComponent.interpret()) {
                tokenEmitter.argument("interpret");
            }
        };
    }
}
