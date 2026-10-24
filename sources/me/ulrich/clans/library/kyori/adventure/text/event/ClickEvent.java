package me.ulrich.clans.library.kyori.adventure.text.event;

import java.net.URL;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.dialog.DialogLike;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.key.Keyed;
import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.library.kyori.adventure.util.Index;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent.class */
public final class ClickEvent implements StyleBuilderApplicable, Examinable {
    private final Action action;
    private final Payload payload;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent$Action.class */
    public enum Action {
        OPEN_URL("open_url", true, Payload.Text.class),
        OPEN_FILE("open_file", false, Payload.Text.class),
        RUN_COMMAND("run_command", true, Payload.Text.class),
        SUGGEST_COMMAND("suggest_command", true, Payload.Text.class),
        CHANGE_PAGE("change_page", true, Payload.Int.class),
        COPY_TO_CLIPBOARD("copy_to_clipboard", true, Payload.Text.class),
        SHOW_DIALOG("show_dialog", false, Payload.Dialog.class),
        CUSTOM("custom", true, Payload.Custom.class);

        public static final Index<String, Action> NAMES = Index.create(Action.class, action -> {
            return action.name;
        });
        private final String name;
        private final boolean readable;
        private final Class<? extends Payload> payloadType;

        Action(@NotNull String str, boolean z, Class cls) {
            this.name = str;
            this.readable = z;
            this.payloadType = cls;
        }

        public boolean readable() {
            return this.readable;
        }

        public boolean supports(@NotNull Payload payload) {
            Objects.requireNonNull(payload, "payload");
            return this.payloadType.isAssignableFrom(payload.getClass());
        }

        @Deprecated
        @NotNull
        public Class<? extends Payload> payloadType() {
            return this.payloadType;
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent$Payload.class */
    public interface Payload extends Examinable {

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent$Payload$Custom.class */
        public interface Custom extends Keyed, Payload {
            @Deprecated
            @NotNull
            String data();

            @NotNull
            BinaryTagHolder nbt();
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent$Payload$Dialog.class */
        public interface Dialog extends Payload {
            @NotNull
            DialogLike dialog();
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent$Payload$Int.class */
        public interface Int extends Payload {
            int integer();
        }

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickEvent$Payload$Text.class */
        public interface Text extends Payload {
            @NotNull
            String value();
        }

        static Text string(@NotNull String str) {
            Objects.requireNonNull(str, "value");
            return new PayloadImpl.TextImpl(str);
        }

        static Int integer(int i) {
            return new PayloadImpl.IntImpl(i);
        }

        static Dialog dialog(@NotNull DialogLike dialogLike) {
            Objects.requireNonNull(dialogLike, "dialog");
            return new PayloadImpl.DialogImpl(dialogLike);
        }

        @Deprecated
        static Custom custom(@NotNull Key key, @NotNull String str) {
            return custom(key, BinaryTagHolder.binaryTagHolder(str));
        }

        static Custom custom(@NotNull Key key, @NotNull BinaryTagHolder binaryTagHolder) {
            Objects.requireNonNull(key, KeybindTag.KEYBIND);
            Objects.requireNonNull(binaryTagHolder, "nbt");
            return new PayloadImpl.CustomImpl(key, binaryTagHolder);
        }
    }

    @NotNull
    public static ClickEvent openUrl(@NotNull String str) {
        return new ClickEvent(Action.OPEN_URL, Payload.string(str));
    }

    @NotNull
    public static ClickEvent openUrl(@NotNull URL url) {
        return openUrl(url.toExternalForm());
    }

    @NotNull
    public static ClickEvent openFile(@NotNull String str) {
        return new ClickEvent(Action.OPEN_FILE, Payload.string(str));
    }

    @NotNull
    public static ClickEvent runCommand(@NotNull String str) {
        return new ClickEvent(Action.RUN_COMMAND, Payload.string(str));
    }

    @NotNull
    public static ClickEvent suggestCommand(@NotNull String str) {
        return new ClickEvent(Action.SUGGEST_COMMAND, Payload.string(str));
    }

    @Deprecated
    @NotNull
    public static ClickEvent changePage(@NotNull String str) {
        Objects.requireNonNull(str, ComponentTreeConstants.CLICK_EVENT_PAGE);
        return new ClickEvent(Action.CHANGE_PAGE, Payload.integer(Integer.parseInt(str)));
    }

    @NotNull
    public static ClickEvent changePage(int i) {
        return new ClickEvent(Action.CHANGE_PAGE, Payload.integer(i));
    }

    @NotNull
    public static ClickEvent copyToClipboard(@NotNull String str) {
        return new ClickEvent(Action.COPY_TO_CLIPBOARD, Payload.string(str));
    }

    @NotNull
    public static ClickEvent callback(@NotNull ClickCallback<Audience> clickCallback) {
        return ClickCallbackInternals.PROVIDER.create((ClickCallback) Objects.requireNonNull(clickCallback, "function"), ClickCallbackOptionsImpl.DEFAULT);
    }

    @NotNull
    public static ClickEvent callback(@NotNull ClickCallback<Audience> clickCallback, ClickCallback.Options options) {
        return ClickCallbackInternals.PROVIDER.create((ClickCallback) Objects.requireNonNull(clickCallback, "function"), (ClickCallback.Options) Objects.requireNonNull(options, "options"));
    }

    @NotNull
    public static ClickEvent callback(@NotNull ClickCallback<Audience> clickCallback, @NotNull Consumer<ClickCallback.Options.Builder> consumer) {
        return ClickCallbackInternals.PROVIDER.create((ClickCallback) Objects.requireNonNull(clickCallback, "function"), (ClickCallback.Options) AbstractBuilder.configureAndBuild(ClickCallback.Options.builder(), (Consumer) Objects.requireNonNull(consumer, "optionsBuilder")));
    }

    @NotNull
    public static ClickEvent showDialog(@NotNull DialogLike dialogLike) {
        Objects.requireNonNull(dialogLike, "dialog");
        return new ClickEvent(Action.SHOW_DIALOG, Payload.dialog(dialogLike));
    }

    @Deprecated
    @NotNull
    public static ClickEvent custom(@NotNull Key key, @NotNull String str) {
        return custom(key, BinaryTagHolder.binaryTagHolder(str));
    }

    @NotNull
    public static ClickEvent custom(@NotNull Key key, @NotNull BinaryTagHolder binaryTagHolder) {
        Objects.requireNonNull(key, KeybindTag.KEYBIND);
        Objects.requireNonNull(binaryTagHolder, "nbt");
        return new ClickEvent(Action.CUSTOM, Payload.custom(key, binaryTagHolder));
    }

    @Deprecated
    @NotNull
    public static ClickEvent clickEvent(@NotNull Action action, @NotNull String str) {
        if (action == Action.CHANGE_PAGE) {
            return changePage(str);
        }
        if (action.payloadType().equals(Payload.Text.class)) {
            return new ClickEvent(action, Payload.string(str));
        }
        throw new IllegalArgumentException("Action " + action + " does not support string payloads");
    }

    @NotNull
    public static ClickEvent clickEvent(@NotNull Action action, @NotNull Payload payload) {
        return new ClickEvent(action, payload);
    }

    private ClickEvent(@NotNull Action action, @NotNull Payload payload) {
        if (!action.supports(payload)) {
            throw new IllegalArgumentException("Action " + action + " does not support payload " + payload);
        }
        this.action = (Action) Objects.requireNonNull(action, "action");
        this.payload = (Payload) Objects.requireNonNull(payload, "payload");
    }

    @NotNull
    public Action action() {
        return this.action;
    }

    @Deprecated
    @NotNull
    public String value() {
        if (this.payload instanceof Payload.Text) {
            return ((Payload.Text) this.payload).value();
        }
        if (this.action == Action.CHANGE_PAGE) {
            return String.valueOf(((Payload.Int) this.payload).integer());
        }
        throw new IllegalStateException("Payload is not a string payload, is " + this.payload);
    }

    @NotNull
    public Payload payload() {
        return this.payload;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable
    public void styleApply(Style.Builder builder) {
        builder.clickEvent(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClickEvent clickEvent = (ClickEvent) obj;
        return this.action == clickEvent.action && Objects.equals(this.payload, clickEvent.payload);
    }

    public int hashCode() {
        return (31 * this.action.hashCode()) + this.payload.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("action", this.action), ExaminableProperty.of("payload", this.payload)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}
