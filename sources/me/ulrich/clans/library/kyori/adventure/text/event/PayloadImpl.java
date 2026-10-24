package me.ulrich.clans.library.kyori.adventure.text.event;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.dialog.DialogLike;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/PayloadImpl.class */
abstract class PayloadImpl implements ClickEvent.Payload {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/PayloadImpl$CustomImpl.class */
    static final class CustomImpl extends PayloadImpl implements ClickEvent.Payload.Custom {
        private final Key key;
        private final BinaryTagHolder nbt;

        CustomImpl(@NotNull Key key, @NotNull BinaryTagHolder binaryTagHolder) {
            this.key = key;
            this.nbt = binaryTagHolder;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.key.Keyed
        @NotNull
        public Key key() {
            return this.key;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent.Payload.Custom
        @NotNull
        public String data() {
            return this.nbt.string();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent.Payload.Custom
        @NotNull
        public BinaryTagHolder nbt() {
            return this.nbt;
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of(KeybindTag.KEYBIND, this.key), ExaminableProperty.of("nbt", this.nbt)});
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CustomImpl customImpl = (CustomImpl) obj;
            return Objects.equals(this.key, customImpl.key) && Objects.equals(this.nbt, customImpl.nbt);
        }

        public int hashCode() {
            return (31 * this.key.hashCode()) + this.nbt.hashCode();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/PayloadImpl$DialogImpl.class */
    static final class DialogImpl extends PayloadImpl implements ClickEvent.Payload.Dialog {
        private final DialogLike dialogLike;

        DialogImpl(@NotNull DialogLike dialogLike) {
            this.dialogLike = dialogLike;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent.Payload.Dialog
        @NotNull
        public DialogLike dialog() {
            return this.dialogLike;
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of(ExaminableProperty.of("dialog", this.dialogLike));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.dialogLike, ((DialogImpl) obj).dialogLike);
        }

        public int hashCode() {
            return this.dialogLike.hashCode();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/PayloadImpl$IntImpl.class */
    static final class IntImpl extends PayloadImpl implements ClickEvent.Payload.Int {
        private final int integer;

        IntImpl(int i) {
            this.integer = i;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent.Payload.Int
        public int integer() {
            return this.integer;
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of(ExaminableProperty.of("integer", this.integer));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(Integer.valueOf(this.integer), Integer.valueOf(((IntImpl) obj).integer));
        }

        public int hashCode() {
            return this.integer;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/PayloadImpl$TextImpl.class */
    static final class TextImpl extends PayloadImpl implements ClickEvent.Payload.Text {
        private final String value;

        TextImpl(@NotNull String str) {
            this.value = str;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent.Payload.Text
        @NotNull
        public String value() {
            return this.value;
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of(ExaminableProperty.of("value", this.value));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.value, ((TextImpl) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }
    }

    PayloadImpl() {
    }

    public String toString() {
        return Internals.toString(this);
    }
}
