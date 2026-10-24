package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponent;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TagNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ValueNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Modifying;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/AbstractColorChangingTag.class */
abstract class AbstractColorChangingTag implements Modifying, Examinable {
    private static final ComponentFlattener LENGTH_CALCULATOR = ComponentFlattener.builder().mapper(TextComponent.class, (v0) -> {
        return v0.content();
    }).unknownMapper(component -> {
        return "_";
    }).build2();
    private boolean visited;
    private int size = 0;
    private int disableApplyingColorDepth = -1;
    private final boolean emitVirtuals;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/AbstractColorChangingTag$TagInfoHolder.class */
    static final class TagInfoHolder implements VirtualComponentRenderer<Void>, Emitable {
        private final Consumer<TokenEmitter> output;
        private final Component originalComp;

        TagInfoHolder(Consumer<TokenEmitter> consumer, Component component) {
            this.output = consumer;
            this.originalComp = component;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer
        public ComponentLike apply(@NotNull Void r3) {
            return this.originalComp;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer
        @NotNull
        public String fallbackString() {
            return "";
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable
        public void emit(@NotNull TokenEmitter tokenEmitter) {
            this.output.accept(tokenEmitter);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable
        @Nullable
        public Component substitute() {
            return this.originalComp;
        }
    }

    AbstractColorChangingTag(Context context) {
        this.emitVirtuals = context.emitVirtuals();
    }

    protected final int size() {
        return this.size;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Modifying
    public final void visit(@NotNull Node node, int i) {
        if (this.visited) {
            throw new IllegalStateException("Color changing tag instances cannot be re-used, return a new one for each resolve");
        }
        if (node instanceof ValueNode) {
            String strValue = ((ValueNode) node).value();
            this.size += strValue.codePointCount(0, strValue.length());
        } else if (node instanceof TagNode) {
            TagNode tagNode = (TagNode) node;
            if (tagNode.tag() instanceof Inserting) {
                LENGTH_CALCULATOR.flatten(((Inserting) tagNode.tag()).value(), str -> {
                    this.size += str.codePointCount(0, str.length());
                });
            }
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Modifying
    public final void postVisit() {
        this.visited = true;
        init();
    }

    /* JADX WARN: Type inference failed for: r0v34, types: [java.util.PrimitiveIterator$OfInt] */
    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Modifying
    public final Component apply(@NotNull Component component, int i) {
        if (this.emitVirtuals && i == 0) {
            return Component.virtual(Void.class, new TagInfoHolder(preserveData(), component), component.style());
        }
        if ((this.disableApplyingColorDepth != -1 && i > this.disableApplyingColorDepth) || component.style().color() != null) {
            if (this.disableApplyingColorDepth == -1 || i < this.disableApplyingColorDepth) {
                this.disableApplyingColorDepth = i;
            }
            if (component instanceof TextComponent) {
                skipColorForLengthOf(((TextComponent) component).content());
            }
            return component.children(Collections.emptyList());
        }
        this.disableApplyingColorDepth = -1;
        if (component instanceof VirtualComponent) {
            skipColorForLengthOf(((VirtualComponent) component).content());
            return component.children(Collections.emptyList());
        }
        if (!(component instanceof TextComponent) || ((TextComponent) component).content().length() <= 0) {
            if (component instanceof TextComponent) {
                return Component.empty().mergeStyle(component);
            }
            Component componentColorIfAbsent = component.children(Collections.emptyList()).colorIfAbsent(color());
            advanceColor();
            return componentColorIfAbsent;
        }
        String strContent = ((TextComponent) component).content();
        TextComponent.Builder builderText = Component.text();
        int[] iArr = new int[1];
        var it = strContent.codePoints().iterator();
        while (it.hasNext()) {
            iArr[0] = it.nextInt();
            TextComponent textComponentText = Component.text(new String(iArr, 0, 1), component.style().color(color()));
            advanceColor();
            builderText.append((Component) textComponentText);
        }
        return builderText.build2();
    }

    private void skipColorForLengthOf(String str) {
        int iCodePointCount = str.codePointCount(0, str.length());
        for (int i = 0; i < iCodePointCount; i++) {
            advanceColor();
        }
    }

    protected abstract void init();

    protected abstract void advanceColor();

    protected abstract TextColor color();

    @NotNull
    protected abstract Consumer<TokenEmitter> preserveData();

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public abstract Stream<? extends ExaminableProperty> examinableProperties();

    @NotNull
    public final String toString() {
        return Internals.toString(this);
    }

    public abstract boolean equals(@Nullable Object obj);

    public abstract int hashCode();

    @Nullable
    static Emitable claimComponent(Component component) {
        if (!(component instanceof VirtualComponent)) {
            return null;
        }
        VirtualComponentRenderer<?> virtualComponentRendererRenderer = ((VirtualComponent) component).renderer();
        if (virtualComponentRendererRenderer instanceof TagInfoHolder) {
            return (TagInfoHolder) virtualComponentRendererRenderer;
        }
        return null;
    }
}
