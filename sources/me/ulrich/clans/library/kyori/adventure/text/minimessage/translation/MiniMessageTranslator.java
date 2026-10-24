package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgument;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgumentLike;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponent;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.adventure.translation.Translator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/MiniMessageTranslator.class */
public abstract class MiniMessageTranslator implements Translator {
    private final MiniMessage miniMessage;

    public MiniMessageTranslator() {
        this(MiniMessage.miniMessage());
    }

    public MiniMessageTranslator(@NotNull MiniMessage miniMessage) {
        this.miniMessage = (MiniMessage) Objects.requireNonNull(miniMessage, "miniMessage");
    }

    @Nullable
    protected abstract String getMiniMessageString(@NotNull String str, @NotNull Locale locale);

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public final MessageFormat translate(@NotNull String str, @NotNull Locale locale) {
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.translation.Translator
    @Nullable
    public final Component translate(@NotNull TranslatableComponent translatableComponent, @NotNull Locale locale) {
        Component componentDeserialize;
        String miniMessageString = getMiniMessageString(translatableComponent.key(), locale);
        if (miniMessageString == null) {
            return null;
        }
        Pointered localePointered = new LocalePointered(locale);
        List<TranslationArgument> listArguments = translatableComponent.arguments();
        if (listArguments.isEmpty()) {
            componentDeserialize = this.miniMessage.deserialize(miniMessageString, localePointered);
        } else {
            TagResolver.Builder builder = TagResolver.builder();
            ArrayList arrayList = new ArrayList(listArguments.size());
            boolean z = false;
            for (TranslationArgument translationArgument : listArguments) {
                Object objValue = translationArgument.value();
                if (objValue instanceof VirtualComponent) {
                    VirtualComponentRenderer<?> virtualComponentRendererRenderer = ((VirtualComponent) objValue).renderer();
                    if (virtualComponentRendererRenderer instanceof MiniMessageTranslatorTarget) {
                        if (z) {
                            throw new IllegalArgumentException("Multiple Argument.target() translation arguments have been set!");
                        }
                        localePointered = ((MiniMessageTranslatorTarget) virtualComponentRendererRenderer).pointered();
                        z = true;
                    } else if (virtualComponentRendererRenderer instanceof MiniMessageTranslatorArgument) {
                        MiniMessageTranslatorArgument miniMessageTranslatorArgument = (MiniMessageTranslatorArgument) virtualComponentRendererRenderer;
                        Object objData = miniMessageTranslatorArgument.data();
                        if (objData instanceof TranslationArgumentLike) {
                            Tag tagSelfClosingInserting = Tag.selfClosingInserting((TranslationArgumentLike) objData);
                            builder.tag(miniMessageTranslatorArgument.name(), tagSelfClosingInserting);
                            arrayList.add(tagSelfClosingInserting);
                        } else if (objData instanceof Tag) {
                            Tag tag = (Tag) objData;
                            builder.tag(miniMessageTranslatorArgument.name(), tag);
                            arrayList.add(tag);
                        } else {
                            if (!(objData instanceof TagResolver)) {
                                throw new IllegalArgumentException("Unknown translator argument type: " + objData.getClass());
                            }
                            builder.resolvers((TagResolver) objData);
                        }
                    }
                }
                arrayList.add(Tag.selfClosingInserting(translationArgument));
            }
            componentDeserialize = this.miniMessage.deserialize(miniMessageString, localePointered, new ArgumentTag(arrayList, builder.build()));
        }
        Style style = translatableComponent.style();
        if (!style.isEmpty()) {
            componentDeserialize = componentDeserialize.applyFallbackStyle(style);
        }
        return componentDeserialize.append(translatableComponent.children());
    }
}
