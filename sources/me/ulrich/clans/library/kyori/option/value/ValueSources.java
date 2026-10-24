package me.ulrich.clans.library.kyori.option.value;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.option.Option;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueSources.class */
final class ValueSources {
    static final ValueSource ENVIRONMENT = new EnvironmentVariable("");
    static final ValueSource SYSTEM_PROPERTIES = new SystemProperty("");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueSources$EnvironmentVariable.class */
    static final class EnvironmentVariable implements ValueSource {
        private static final Pattern ENVIRONMENT_SUBST_PATTERN = Pattern.compile("[:\\-/]");
        private static final String ENVIRONMENT_VAR_SEPARATOR = "_";
        private final String prefix;

        EnvironmentVariable(String str) {
            this.prefix = str.isEmpty() ? "" : str.toUpperCase(Locale.ROOT) + ENVIRONMENT_VAR_SEPARATOR;
        }

        @Override // me.ulrich.clans.library.kyori.option.value.ValueSource
        public <T> T value(Option<T> option) {
            StringBuffer stringBuffer = new StringBuffer(option.id().length() + this.prefix.length());
            stringBuffer.append(this.prefix);
            Matcher matcher = ENVIRONMENT_SUBST_PATTERN.matcher(option.id());
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, ENVIRONMENT_VAR_SEPARATOR);
            }
            matcher.appendTail(stringBuffer);
            String str = System.getenv(stringBuffer.toString().toUpperCase(Locale.ROOT));
            if (str == null) {
                return null;
            }
            return option.valueType().parse(str);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueSources$SystemProperty.class */
    static final class SystemProperty implements ValueSource {
        private static final Pattern SYSTEM_PROP_SUBST_PATTERN = Pattern.compile("[:/]");
        private static final String SYSTEM_PROPERTY_SEPARATOR = ".";
        private final String prefix;

        SystemProperty(String str) {
            this.prefix = str.isEmpty() ? "" : str + SYSTEM_PROPERTY_SEPARATOR;
        }

        @Override // me.ulrich.clans.library.kyori.option.value.ValueSource
        public <T> T value(Option<T> option) {
            StringBuffer stringBuffer = new StringBuffer(option.id().length() + this.prefix.length());
            stringBuffer.append(this.prefix);
            Matcher matcher = SYSTEM_PROP_SUBST_PATTERN.matcher(option.id());
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, SYSTEM_PROPERTY_SEPARATOR);
            }
            matcher.appendTail(stringBuffer);
            String property = System.getProperty(stringBuffer.toString());
            if (property == null) {
                return null;
            }
            return option.valueType().parse(property);
        }
    }

    private ValueSources() {
    }
}
