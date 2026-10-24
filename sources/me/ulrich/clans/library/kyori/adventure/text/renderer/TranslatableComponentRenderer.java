package me.ulrich.clans.library.kyori.adventure.text.renderer;

import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.BuildableComponent;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.ScoreComponent;
import me.ulrich.clans.library.kyori.adventure.text.SelectorComponent;
import me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgument;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.translation.Translator;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/renderer/TranslatableComponentRenderer.class */
public abstract class TranslatableComponentRenderer<C> extends AbstractComponentRenderer<C> {
    private static final Set<Style.Merge> MERGES;

    @NotNull
    public static TranslatableComponentRenderer<Locale> usingTranslationSource(@NotNull final Translator translator) {
        Objects.requireNonNull(translator, "source");
        return new TranslatableComponentRenderer<Locale>() { // from class: me.ulrich.clans.library.kyori.adventure.text.renderer.TranslatableComponentRenderer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.TranslatableComponentRenderer
            @Nullable
            public MessageFormat translate(@NotNull String str, @NotNull Locale locale) {
                return translator.translate(str, locale);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.TranslatableComponentRenderer
            @NotNull
            public Component renderTranslatableInner(@NotNull TranslatableComponent translatableComponent, @NotNull Locale locale) {
                if (translator.hasAnyTranslations() == TriState.FALSE) {
                    return translatableComponent;
                }
                Component componentTranslate = translator.canTranslate(translatableComponent.key(), locale) ? translator.translate(translatableComponent, locale) : null;
                return componentTranslate != null ? render(componentTranslate, locale) : super.renderTranslatableInner(translatableComponent, locale);
            }
        };
    }

    @Nullable
    protected MessageFormat translate(@NotNull String str, @NotNull C c) {
        return null;
    }

    @Nullable
    protected MessageFormat translate(@NotNull String str, @Nullable String str2, @NotNull C c) {
        return translate(str, c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderBlockNbt(@NotNull BlockNBTComponent blockNBTComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(blockNBTComponent, ((BlockNBTComponent.Builder) nbt(c, Component.blockNBT(), blockNBTComponent)).pos(blockNBTComponent.pos()), c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderEntityNbt(@NotNull EntityNBTComponent entityNBTComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(entityNBTComponent, ((EntityNBTComponent.Builder) nbt(c, Component.entityNBT(), entityNBTComponent)).selector(entityNBTComponent.selector()), c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderStorageNbt(@NotNull StorageNBTComponent storageNBTComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(storageNBTComponent, ((StorageNBTComponent.Builder) nbt(c, Component.storageNBT(), storageNBTComponent)).storage(storageNBTComponent.storage()), c);
    }

    protected <O extends NBTComponent<O, B>, B extends NBTComponentBuilder<O, B>> B nbt(@NotNull C c, B b, O o) {
        b.nbtPath(o.nbtPath()).interpret(o.interpret());
        Component componentSeparator = o.separator();
        if (componentSeparator != null) {
            b.separator(render(componentSeparator, c));
        }
        return b;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderKeybind(@NotNull KeybindComponent keybindComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(keybindComponent, Component.keybind().keybind(keybindComponent.keybind()), c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderScore(@NotNull ScoreComponent scoreComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(scoreComponent, Component.score().name(scoreComponent.name()).objective(scoreComponent.objective()).value(scoreComponent.value()), c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderSelector(@NotNull SelectorComponent selectorComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(selectorComponent, Component.selector().pattern(selectorComponent.pattern()), c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderText(@NotNull TextComponent textComponent, @NotNull C c) {
        return mergeStyleAndOptionallyDeepRender(textComponent, Component.text().content(textComponent.content()), c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.AbstractComponentRenderer
    @NotNull
    protected Component renderTranslatable(@NotNull TranslatableComponent translatableComponent, @NotNull C c) {
        List<TranslationArgument> listArguments = translatableComponent.arguments();
        List<Component> listChildren = translatableComponent.children();
        if (!listArguments.isEmpty() || !listChildren.isEmpty()) {
            TranslatableComponent.Builder builder = translatableComponent.mo683toBuilder();
            if (!listArguments.isEmpty()) {
                ArrayList arrayList = new ArrayList(listArguments);
                for (int i = 0; i < arrayList.size(); i++) {
                    TranslationArgument translationArgument = (TranslationArgument) arrayList.get(i);
                    if ((translationArgument.value() instanceof Component) && !(translationArgument.value() instanceof VirtualComponent)) {
                        arrayList.set(i, TranslationArgument.component(render((Component) translationArgument.value(), c)));
                    }
                }
                builder.arguments(arrayList);
            }
            translatableComponent = builder.build2();
        }
        return renderTranslatableInner(translatableComponent, c);
    }

    @NotNull
    protected Component renderTranslatableInner(@NotNull TranslatableComponent translatableComponent, @NotNull C c) {
        MessageFormat messageFormatTranslate = translate(translatableComponent.key(), translatableComponent.fallback(), c);
        if (messageFormatTranslate == null) {
            return optionallyRenderChildrenAndStyle(translatableComponent, c);
        }
        List<TranslationArgument> listArguments = translatableComponent.arguments();
        TextComponent.Builder builderText = Component.text();
        mergeStyle(translatableComponent, builderText, c);
        if (listArguments.isEmpty()) {
            builderText.content(messageFormatTranslate.format((Object[]) null, new StringBuffer(), (FieldPosition) null).toString());
            return optionallyRenderChildrenAppendAndBuild(translatableComponent.children(), builderText, c);
        }
        Object[] objArr = new Object[listArguments.size()];
        StringBuffer stringBuffer = messageFormatTranslate.format(objArr, new StringBuffer(), (FieldPosition) null);
        AttributedCharacterIterator toCharacterIterator = messageFormatTranslate.formatToCharacterIterator(objArr);
        while (toCharacterIterator.getIndex() < toCharacterIterator.getEndIndex()) {
            int runLimit = toCharacterIterator.getRunLimit();
            Integer num = (Integer) toCharacterIterator.getAttribute(MessageFormat.Field.ARGUMENT);
            if (num != null) {
                builderText.append(listArguments.get(num.intValue()).asComponent());
            } else {
                builderText.append((Component) Component.text(stringBuffer.substring(toCharacterIterator.getIndex(), runLimit)));
            }
            toCharacterIterator.setIndex(runLimit);
        }
        return optionallyRenderChildrenAppendAndBuild(translatableComponent.children(), builderText, c);
    }

    protected Component optionallyRenderChildrenAndStyle(Component component, C c) {
        HoverEvent<?> hoverEvent = component.hoverEvent();
        if (hoverEvent != null) {
            component = component.hoverEvent((HoverEventSource<?>) hoverEvent.withRenderedValue(this, c));
        }
        List<Component> listChildren = component.children();
        if (listChildren.isEmpty()) {
            return component;
        }
        ArrayList arrayList = new ArrayList(listChildren.size());
        listChildren.forEach(component2 -> {
            arrayList.add(render(component2, c));
        });
        return component.children(arrayList);
    }

    protected <O extends BuildableComponent<O, B>, B extends ComponentBuilder<O, B>> O mergeStyleAndOptionallyDeepRender(Component component, B b, C c) {
        mergeStyle(component, b, c);
        return (O) optionallyRenderChildrenAppendAndBuild(component.children(), b, c);
    }

    protected <O extends BuildableComponent<O, B>, B extends ComponentBuilder<O, B>> O optionallyRenderChildrenAppendAndBuild(List<Component> list, B b, C c) {
        if (!list.isEmpty()) {
            list.forEach(component -> {
                b.append(render(component, c));
            });
        }
        return (O) b.build2();
    }

    protected <B extends ComponentBuilder<?, ?>> void mergeStyle(Component component, B b, C c) {
        b.mergeStyle(component, MERGES);
        b.clickEvent(component.clickEvent());
        HoverEvent<?> hoverEvent = component.hoverEvent();
        if (hoverEvent != null) {
            b.hoverEvent(hoverEvent.withRenderedValue(this, c));
        }
    }

    static {
        EnumSet enumSetAllOf = EnumSet.allOf(Style.Merge.class);
        enumSetAllOf.remove(Style.Merge.EVENTS);
        MERGES = Collections.unmodifiableSet(enumSetAllOf);
    }
}
