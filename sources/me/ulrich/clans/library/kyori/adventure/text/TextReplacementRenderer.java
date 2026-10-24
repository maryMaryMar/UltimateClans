package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementRenderer.class */
final class TextReplacementRenderer implements ComponentRenderer<State> {
    static final TextReplacementRenderer INSTANCE = new TextReplacementRenderer();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TextReplacementRenderer$State.class */
    static final class State {
        final Pattern pattern;
        final BiFunction<MatchResult, TextComponent.Builder, ComponentLike> replacement;
        final TextReplacementConfig.Condition continuer;
        final boolean replaceInsideHoverEvents;
        boolean running = true;
        int matchCount = 0;
        int replaceCount = 0;
        boolean firstMatch = true;

        State(@NotNull Pattern pattern, @NotNull BiFunction<MatchResult, TextComponent.Builder, ComponentLike> biFunction, TextReplacementConfig.Condition condition, boolean z) {
            this.pattern = pattern;
            this.replacement = biFunction;
            this.continuer = condition;
            this.replaceInsideHoverEvents = z;
        }
    }

    private TextReplacementRenderer() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer
    @NotNull
    public Component render(@NotNull Component component, @NotNull State state) {
        HoverEvent<?> hoverEvent;
        HoverEvent<?> hoverEventWithRenderedValue;
        if (!state.running) {
            return component;
        }
        boolean z = state.firstMatch;
        state.firstMatch = true;
        List<Component> listChildren = component.children();
        int size = listChildren.size();
        Style style = component.style();
        ArrayList arrayList = null;
        Component componentArguments = component;
        if (component instanceof TextComponent) {
            String strContent = ((TextComponent) component).content();
            Matcher matcher = state.pattern.matcher(strContent);
            int iEnd = 0;
            while (matcher.find()) {
                TextReplacementConfig.Condition condition = state.continuer;
                int i = state.matchCount + 1;
                state.matchCount = i;
                PatternReplacementResult patternReplacementResultShouldReplace = condition.shouldReplace(matcher, i, state.replaceCount);
                if (patternReplacementResultShouldReplace != PatternReplacementResult.CONTINUE) {
                    if (patternReplacementResultShouldReplace == PatternReplacementResult.STOP) {
                        state.running = false;
                        break;
                    }
                    if (matcher.start() != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(size + 2);
                        }
                        if (state.firstMatch) {
                            componentArguments = ((TextComponent) component).content(strContent.substring(0, matcher.start()));
                        } else if (iEnd < matcher.start()) {
                            arrayList.add(Component.text(strContent.substring(iEnd, matcher.start())));
                        }
                        ComponentLike componentLikeApply = state.replacement.apply(matcher, Component.text().content(matcher.group()));
                        if (componentLikeApply != null) {
                            arrayList.add(componentLikeApply.asComponent());
                        }
                    } else if (matcher.end() == strContent.length()) {
                        ComponentLike componentLikeApply2 = state.replacement.apply(matcher, Component.text().content(matcher.group()).style(component.style()));
                        Component componentEmpty = componentLikeApply2 == null ? Component.empty() : componentLikeApply2.asComponent();
                        if (componentEmpty.style().hoverEvent() != null) {
                            style = style.hoverEvent((HoverEventSource<?>) null);
                        }
                        componentArguments = componentEmpty.style(componentEmpty.style().merge(component.style(), Style.Merge.Strategy.IF_ABSENT_ON_TARGET));
                        if (arrayList == null) {
                            arrayList = new ArrayList(size + componentArguments.children().size());
                            arrayList.addAll(componentArguments.children());
                        }
                    } else {
                        componentArguments = Component.text("", component.style());
                        ComponentLike componentLikeApply3 = state.replacement.apply(matcher, Component.text().content(matcher.group()));
                        if (componentLikeApply3 != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList(size + 1);
                            }
                            arrayList.add(componentLikeApply3.asComponent());
                        }
                    }
                    state.replaceCount++;
                    state.firstMatch = false;
                    iEnd = matcher.end();
                }
            }
            if (iEnd < strContent.length() && iEnd > 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList(size);
                }
                arrayList.add(Component.text(strContent.substring(iEnd)));
            }
        } else if (componentArguments instanceof TranslatableComponent) {
            List<TranslationArgument> listArguments = ((TranslatableComponent) componentArguments).arguments();
            ArrayList arrayList2 = null;
            int size2 = listArguments.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TranslationArgument translationArgument = listArguments.get(i2);
                TranslationArgument translationArgumentComponent = translationArgument.value() instanceof Component ? TranslationArgument.component(render((Component) translationArgument.value(), state)) : translationArgument;
                if (translationArgumentComponent != translationArgument && arrayList2 == null) {
                    arrayList2 = new ArrayList(size2);
                    if (i2 > 0) {
                        arrayList2.addAll(listArguments.subList(0, i2));
                    }
                }
                if (arrayList2 != null) {
                    arrayList2.add(translationArgumentComponent);
                }
            }
            if (arrayList2 != null) {
                componentArguments = ((TranslatableComponent) componentArguments).arguments(arrayList2);
            }
        }
        if (state.running) {
            if (state.replaceInsideHoverEvents && (hoverEvent = style.hoverEvent()) != null && hoverEvent != (hoverEventWithRenderedValue = hoverEvent.withRenderedValue(this, state))) {
                componentArguments = componentArguments.style(builder -> {
                    builder.hoverEvent((HoverEventSource<?>) hoverEventWithRenderedValue);
                });
            }
            boolean z2 = true;
            for (int i3 = 0; i3 < size; i3++) {
                Component component2 = listChildren.get(i3);
                Component componentRender = render(component2, state);
                if (componentRender != component2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(size);
                    }
                    if (z2) {
                        arrayList.addAll(listChildren.subList(0, i3));
                    }
                    z2 = false;
                }
                if (arrayList != null) {
                    arrayList.add(componentRender);
                    z2 = false;
                }
            }
        } else if (arrayList != null) {
            arrayList.addAll(listChildren);
        }
        state.firstMatch = z;
        return arrayList != null ? componentArguments.children(arrayList) : componentArguments;
    }
}
