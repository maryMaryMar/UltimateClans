package me.ulrich.clans.library.gui.builder.item;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/item/BookBuilder.class */
public class BookBuilder extends BaseItemBuilder<BookBuilder> {
    private static final EnumSet<Material> BOOKS = EnumSet.of(Material.WRITABLE_BOOK, Material.WRITTEN_BOOK);

    BookBuilder(@NotNull ItemStack itemStack, @NotNull NameLoreHandler nameLoreHandler) {
        super(itemStack, nameLoreHandler);
        if (!BOOKS.contains(itemStack.getType())) {
            throw new GuiException("BookBuilder requires the material to be a WRITABLE_BOOK/WRITTEN_BOOK!");
        }
    }

    @Contract("_ -> this")
    @NotNull
    public BookBuilder author(@Nullable Component component) {
        BookMeta meta = getMeta();
        if (component == null) {
            meta.setAuthor((String) null);
            setMeta(meta);
            return this;
        }
        meta.setAuthor(Legacy.SERIALIZER.serialize(component));
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public BookBuilder generation(@Nullable BookMeta.Generation generation) {
        BookMeta meta = getMeta();
        meta.setGeneration(generation);
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public BookBuilder page(@NotNull Component... componentArr) {
        return page(Arrays.asList(componentArr));
    }

    @Contract("_ -> this")
    @NotNull
    public BookBuilder page(@NotNull List<Component> list) {
        BookMeta meta = getMeta();
        Iterator<Component> it = list.iterator();
        while (it.hasNext()) {
            meta.addPage(new String[]{Legacy.SERIALIZER.serialize(it.next())});
        }
        setMeta(meta);
        return this;
    }

    @Contract("_, _ -> this")
    @NotNull
    public BookBuilder page(int i, @NotNull Component component) {
        BookMeta meta = getMeta();
        meta.setPage(i, Legacy.SERIALIZER.serialize(component));
        setMeta(meta);
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public BookBuilder title(@Nullable Component component) {
        BookMeta meta = getMeta();
        if (component == null) {
            meta.setTitle((String) null);
            setMeta(meta);
            return this;
        }
        meta.setTitle(Legacy.SERIALIZER.serialize(component));
        setMeta(meta);
        return this;
    }
}
