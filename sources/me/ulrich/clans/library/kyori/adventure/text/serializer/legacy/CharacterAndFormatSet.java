package me.ulrich.clans.library.kyori.adventure.text.serializer.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextFormat;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/CharacterAndFormatSet.class */
final class CharacterAndFormatSet {
    static final CharacterAndFormatSet DEFAULT = of(CharacterAndFormat.defaults());
    final List<TextFormat> formats;
    final List<TextColor> colors;
    final String characters;

    static CharacterAndFormatSet of(List<CharacterAndFormat> list) {
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(size);
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            CharacterAndFormat characterAndFormat = list.get(i);
            char cCharacter = characterAndFormat.character();
            TextFormat textFormat = characterAndFormat.format();
            boolean z = textFormat instanceof TextColor;
            sb.append(cCharacter);
            arrayList2.add(textFormat);
            if (z) {
                arrayList.add((TextColor) textFormat);
            }
            if (characterAndFormat.caseInsensitive()) {
                boolean z2 = false;
                if (Character.isUpperCase(cCharacter)) {
                    sb.append(Character.toLowerCase(cCharacter));
                    z2 = true;
                } else if (Character.isLowerCase(cCharacter)) {
                    sb.append(Character.toUpperCase(cCharacter));
                    z2 = true;
                }
                if (z2) {
                    arrayList2.add(textFormat);
                    if (z) {
                        arrayList.add((TextColor) textFormat);
                    }
                }
            }
        }
        if (arrayList2.size() != sb.length()) {
            throw new IllegalStateException("formats length differs from characters length");
        }
        return new CharacterAndFormatSet(Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), sb.toString());
    }

    CharacterAndFormatSet(List<TextFormat> list, List<TextColor> list2, String str) {
        this.formats = list;
        this.colors = list2;
        this.characters = str;
    }
}
