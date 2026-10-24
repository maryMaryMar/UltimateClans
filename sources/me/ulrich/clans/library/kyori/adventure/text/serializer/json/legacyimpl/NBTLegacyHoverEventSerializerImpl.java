package me.ulrich.clans.library.kyori.adventure.text.serializer.json.legacyimpl;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag;
import me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag;
import me.ulrich.clans.library.kyori.adventure.nbt.TagStringIO;
import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer;
import me.ulrich.clans.library.kyori.adventure.util.Codec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/legacyimpl/NBTLegacyHoverEventSerializerImpl.class */
final class NBTLegacyHoverEventSerializerImpl implements LegacyHoverEventSerializer {
    static final NBTLegacyHoverEventSerializerImpl INSTANCE = new NBTLegacyHoverEventSerializerImpl();
    private static final TagStringIO SNBT_IO = TagStringIO.get();
    private static final Codec<CompoundBinaryTag, String, IOException, IOException> SNBT_CODEC;
    static final String ITEM_TYPE = "id";
    static final String ITEM_COUNT = "Count";
    static final String ITEM_TAG = "tag";
    static final String ENTITY_NAME = "name";
    static final String ENTITY_TYPE = "type";
    static final String ENTITY_ID = "id";

    private NBTLegacyHoverEventSerializerImpl() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    public HoverEvent.ShowItem deserializeShowItem(@NotNull Component component) {
        assertTextComponent(component);
        CompoundBinaryTag compoundBinaryTagDecode = SNBT_CODEC.decode(((TextComponent) component).content());
        CompoundBinaryTag compound = compoundBinaryTagDecode.getCompound("tag");
        return HoverEvent.ShowItem.showItem(Key.key(compoundBinaryTagDecode.getString("id")), (int) compoundBinaryTagDecode.getByte(ITEM_COUNT, (byte) 1), compound == CompoundBinaryTag.empty() ? null : BinaryTagHolder.encode(compound, SNBT_CODEC));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    @NotNull
    public Component serializeShowItem(HoverEvent.ShowItem showItem) {
        CompoundBinaryTag.Builder builderPutByte = CompoundBinaryTag.builder().putString("id", showItem.item().asString()).putByte(ITEM_COUNT, (byte) showItem.count());
        BinaryTagHolder binaryTagHolderNbt = showItem.nbt();
        if (binaryTagHolderNbt != null) {
            builderPutByte.put("tag", (BinaryTag) binaryTagHolderNbt.get(SNBT_CODEC));
        }
        return Component.text(SNBT_CODEC.encode(builderPutByte.build()));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    public HoverEvent.ShowEntity deserializeShowEntity(@NotNull Component component, Codec.Decoder<Component, String, ? extends RuntimeException> decoder) {
        assertTextComponent(component);
        CompoundBinaryTag compoundBinaryTagDecode = SNBT_CODEC.decode(((TextComponent) component).content());
        return HoverEvent.ShowEntity.showEntity(Key.key(compoundBinaryTagDecode.getString("type")), UUID.fromString(compoundBinaryTagDecode.getString("id")), decoder.decode(compoundBinaryTagDecode.getString("name")));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    @NotNull
    public Component serializeShowEntity(HoverEvent.ShowEntity showEntity, Codec.Encoder<Component, String, ? extends RuntimeException> encoder) {
        CompoundBinaryTag.Builder builderPutString = CompoundBinaryTag.builder().putString("id", showEntity.id().toString()).putString("type", showEntity.type().asString());
        Component componentName = showEntity.name();
        if (componentName != null) {
            builderPutString.putString("name", encoder.encode(componentName));
        }
        return Component.text(SNBT_CODEC.encode(builderPutString.build()));
    }

    private static void assertTextComponent(Component component) {
        if (!(component instanceof TextComponent) || !component.children().isEmpty()) {
            throw new IllegalArgumentException("Legacy events must be single Component instances");
        }
    }

    static {
        TagStringIO tagStringIO = SNBT_IO;
        Objects.requireNonNull(tagStringIO);
        Codec.Decoder decoder = tagStringIO::asCompound;
        TagStringIO tagStringIO2 = SNBT_IO;
        Objects.requireNonNull(tagStringIO2);
        SNBT_CODEC = Codec.codec(decoder, tagStringIO2::asString);
    }
}
