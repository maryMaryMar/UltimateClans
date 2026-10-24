package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.ParsingExceptionImpl;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenType;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ElementNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.RootNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TagNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.ValueNode;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Modifying;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.string.MultiLineStringExaminer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageParser.class */
final class MiniMessageParser {
    final TagResolver tagResolver;

    MiniMessageParser() {
        this.tagResolver = TagResolver.standard();
    }

    MiniMessageParser(TagResolver tagResolver) {
        this.tagResolver = tagResolver;
    }

    @NotNull
    String escapeTokens(@NotNull ContextImpl contextImpl) {
        StringBuilder sb = new StringBuilder(contextImpl.message().length());
        escapeTokens(sb, contextImpl);
        return sb.toString();
    }

    void escapeTokens(StringBuilder sb, @NotNull ContextImpl contextImpl) {
        escapeTokens(sb, contextImpl.message(), contextImpl);
    }

    private void escapeTokens(StringBuilder sb, String str, ContextImpl contextImpl) {
        processTokens(sb, str, contextImpl, (token, sb2) -> {
            sb2.append('\\').append('<');
            if (token.type() == TokenType.CLOSE_TAG) {
                sb2.append('/');
            }
            List<Token> listChildTokens = token.childTokens();
            for (int i = 0; i < listChildTokens.size(); i++) {
                if (i != 0) {
                    sb2.append(':');
                }
                escapeTokens(sb2, listChildTokens.get(i).get(str).toString(), contextImpl);
            }
            sb2.append('>');
        });
    }

    @NotNull
    String stripTokens(@NotNull ContextImpl contextImpl) {
        StringBuilder sb = new StringBuilder(contextImpl.message().length());
        processTokens(sb, contextImpl, (token, sb2) -> {
        });
        return sb.toString();
    }

    private void processTokens(@NotNull StringBuilder sb, @NotNull ContextImpl contextImpl, BiConsumer<Token, StringBuilder> biConsumer) {
        processTokens(sb, contextImpl.message(), contextImpl, biConsumer);
    }

    private void processTokens(@NotNull StringBuilder sb, @NotNull String str, @NotNull ContextImpl contextImpl, BiConsumer<Token, StringBuilder> biConsumer) {
        TagResolver tagResolverResolver = TagResolver.resolver(this.tagResolver, contextImpl.extraTags());
        for (Token token : TokenParser.tokenize(str, true)) {
            switch (token.type()) {
                case TEXT:
                    sb.append((CharSequence) str, token.startIndex(), token.endIndex());
                    break;
                case OPEN_TAG:
                case CLOSE_TAG:
                case OPEN_CLOSE_TAG:
                    if (token.childTokens().isEmpty()) {
                        sb.append((CharSequence) str, token.startIndex(), token.endIndex());
                    } else if (tagResolverResolver.has(TokenParser.TagProvider.sanitizePlaceholderName(token.childTokens().get(0).get(str).toString()))) {
                        biConsumer.accept(token, sb);
                    } else {
                        sb.append((CharSequence) str, token.startIndex(), token.endIndex());
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported token type " + token.type());
            }
        }
    }

    @NotNull
    RootNode parseToTree(@NotNull ContextImpl contextImpl) {
        TagResolver tagResolverResolver = TagResolver.resolver(this.tagResolver, contextImpl.extraTags());
        String str = (String) contextImpl.preProcessor().apply(contextImpl.message());
        Consumer<String> consumerDebugOutput = contextImpl.debugOutput();
        if (consumerDebugOutput != null) {
            consumerDebugOutput.accept("Beginning parsing message ");
            consumerDebugOutput.accept(str);
            consumerDebugOutput.accept("\n");
        }
        TokenParser.TagProvider tagProvider = consumerDebugOutput != null ? (str2, list, token) -> {
            try {
                consumerDebugOutput.accept("Attempting to match node '");
                consumerDebugOutput.accept(str2);
                consumerDebugOutput.accept("'");
                if (token != null) {
                    consumerDebugOutput.accept(" at column ");
                    consumerDebugOutput.accept(String.valueOf(token.startIndex()));
                }
                consumerDebugOutput.accept("\n");
                Tag tagResolve = tagResolverResolver.resolve(str2, new ArgumentQueueImpl(contextImpl, list), contextImpl);
                if (tagResolve == null) {
                    consumerDebugOutput.accept("Could not match node '");
                    consumerDebugOutput.accept(str2);
                    consumerDebugOutput.accept("'\n");
                } else {
                    consumerDebugOutput.accept("Successfully matched node '");
                    consumerDebugOutput.accept(str2);
                    consumerDebugOutput.accept("' to tag ");
                    consumerDebugOutput.accept(tagResolve instanceof Examinable ? ((Examinable) tagResolve).examinableName() : tagResolve.getClass().getName());
                    consumerDebugOutput.accept("\n");
                }
                return tagResolve;
            } catch (ParsingException e) {
                if (token != null && (e instanceof ParsingExceptionImpl)) {
                    ParsingExceptionImpl parsingExceptionImpl = (ParsingExceptionImpl) e;
                    if (parsingExceptionImpl.tokens().length == 0) {
                        parsingExceptionImpl.tokens(new Token[]{token});
                    }
                }
                consumerDebugOutput.accept("Could not match node '");
                consumerDebugOutput.accept(str2);
                consumerDebugOutput.accept("' - ");
                consumerDebugOutput.accept(e.getMessage());
                consumerDebugOutput.accept("\n");
                return null;
            }
        } : (str3, list2, token2) -> {
            try {
                return tagResolverResolver.resolve(str3, new ArgumentQueueImpl(contextImpl, list2), contextImpl);
            } catch (ParsingException e) {
                return null;
            }
        };
        Predicate predicate = str4 -> {
            return tagResolverResolver.has(TokenParser.TagProvider.sanitizePlaceholderName(str4));
        };
        String strResolvePreProcessTags = TokenParser.resolvePreProcessTags(str, tagProvider);
        contextImpl.message(strResolvePreProcessTags);
        RootNode rootNode = TokenParser.parse(tagProvider, predicate, strResolvePreProcessTags, str, contextImpl.strict());
        if (consumerDebugOutput != null) {
            consumerDebugOutput.accept("Text parsed into element tree:\n");
            consumerDebugOutput.accept(rootNode.toString());
        }
        return rootNode;
    }

    @NotNull
    Component parseFormat(@NotNull ContextImpl contextImpl) {
        return (Component) Objects.requireNonNull((Component) contextImpl.postProcessor().apply(treeToComponent(parseToTree(contextImpl), contextImpl)), "Post-processor must not return null");
    }

    @NotNull
    Component treeToComponent(@NotNull ElementNode elementNode, @NotNull ContextImpl contextImpl) {
        Component componentEmpty = Component.empty();
        Tag tag = null;
        if (elementNode instanceof ValueNode) {
            componentEmpty = Component.text(((ValueNode) elementNode).value());
        } else if (elementNode instanceof TagNode) {
            TagNode tagNode = (TagNode) elementNode;
            tag = tagNode.tag();
            if (tag instanceof Modifying) {
                Modifying modifying = (Modifying) tag;
                visitModifying(modifying, tagNode, 0);
                modifying.postVisit();
            }
            if (tag instanceof Inserting) {
                componentEmpty = ((Inserting) tag).value();
            }
        }
        if (!elementNode.unsafeChildren().isEmpty()) {
            List<? extends ComponentLike> arrayList = new ArrayList<>(componentEmpty.children().size() + elementNode.children().size());
            arrayList.addAll(componentEmpty.children());
            Iterator<ElementNode> it = elementNode.unsafeChildren().iterator();
            while (it.hasNext()) {
                arrayList.add(treeToComponent(it.next(), contextImpl));
            }
            componentEmpty = componentEmpty.children(arrayList);
        }
        if (tag instanceof Modifying) {
            componentEmpty = handleModifying((Modifying) tag, componentEmpty, 0);
        }
        Consumer<String> consumerDebugOutput = contextImpl.debugOutput();
        if (consumerDebugOutput != null) {
            consumerDebugOutput.accept("==========\ntreeToComponent \n");
            consumerDebugOutput.accept(elementNode.toString());
            consumerDebugOutput.accept("\n");
            consumerDebugOutput.accept((String) ((Stream) componentEmpty.examine(MultiLineStringExaminer.simpleEscaping())).collect(Collectors.joining("\n")));
            consumerDebugOutput.accept("\n==========\n");
        }
        return componentEmpty;
    }

    private void visitModifying(Modifying modifying, ElementNode elementNode, int i) {
        modifying.visit(elementNode, i);
        Iterator<ElementNode> it = elementNode.unsafeChildren().iterator();
        while (it.hasNext()) {
            visitModifying(modifying, it.next(), i + 1);
        }
    }

    private Component handleModifying(Modifying modifying, Component component, int i) {
        Component componentApply = modifying.apply(component, i);
        Iterator<Component> it = component.children().iterator();
        while (it.hasNext()) {
            componentApply = componentApply.append(handleModifying(modifying, it.next(), i + 1));
        }
        return componentApply;
    }
}
