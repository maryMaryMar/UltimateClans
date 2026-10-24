package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenType;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TagPart;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.PreProcess;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/parser/match/StringResolvingMatchedTokenConsumer.class */
public final class StringResolvingMatchedTokenConsumer extends MatchedTokenConsumer<String> {
    private final StringBuilder builder;
    private final TokenParser.TagProvider tagProvider;

    public StringResolvingMatchedTokenConsumer(@NotNull String str, @NotNull TokenParser.TagProvider tagProvider) {
        super(str);
        this.builder = new StringBuilder(str.length());
        this.tagProvider = tagProvider;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.MatchedTokenConsumer
    public void accept(int i, int i2, @NotNull TokenType tokenType) {
        super.accept(i, i2, tokenType);
        if (tokenType != TokenType.OPEN_TAG) {
            this.builder.append((CharSequence) this.input, i, i2);
            return;
        }
        String strSubstring = this.input.substring(i, i2);
        String strSubstring2 = this.input.substring(i + 1, i2 - 1);
        int iIndexOf = strSubstring2.indexOf(58);
        String strSubstring3 = iIndexOf == -1 ? strSubstring2 : strSubstring2.substring(0, iIndexOf);
        if (TagInternals.sanitizeAndCheckValidTagName(strSubstring3)) {
            List<Token> list = TokenParser.tokenize(strSubstring, false);
            ArrayList arrayList = new ArrayList();
            List<Token> listChildTokens = list.isEmpty() ? null : list.get(0).childTokens();
            if (listChildTokens != null) {
                for (int i3 = 1; i3 < listChildTokens.size(); i3++) {
                    arrayList.add(new TagPart(strSubstring, listChildTokens.get(i3), this.tagProvider));
                }
            }
            Tag tagResolve = this.tagProvider.resolve(TokenParser.TagProvider.sanitizePlaceholderName(strSubstring3), arrayList, list.get(0));
            if (tagResolve instanceof PreProcess) {
                this.builder.append((String) Objects.requireNonNull(((PreProcess) tagResolve).value(), "PreProcess replacements cannot return null"));
                return;
            }
        }
        this.builder.append(strSubstring);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.match.MatchedTokenConsumer
    @NotNull
    public String result() {
        return this.builder.toString();
    }
}
