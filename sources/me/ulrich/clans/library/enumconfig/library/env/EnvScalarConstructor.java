package me.ulrich.clans.library.enumconfig.library.env;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.LoaderOptions;
import me.ulrich.clans.library.enumconfig.library.TypeDescription;
import me.ulrich.clans.library.enumconfig.library.constructor.AbstractConstruct;
import me.ulrich.clans.library.enumconfig.library.constructor.Constructor;
import me.ulrich.clans.library.enumconfig.library.error.MissingEnvironmentVariableException;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/env/EnvScalarConstructor.class */
public class EnvScalarConstructor extends Constructor {
    public static final Tag ENV_TAG = new Tag("!ENV");
    public static final Pattern ENV_FORMAT = Pattern.compile("^\\$\\{\\s*((?<name>\\w+)((?<separator>:?(-|\\?))(?<value>\\S+)?)?)\\s*\\}$");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/env/EnvScalarConstructor$ConstructEnv.class */
    private class ConstructEnv extends AbstractConstruct {
        private ConstructEnv() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
        public Object construct(Node node) {
            Matcher matcher = EnvScalarConstructor.ENV_FORMAT.matcher(EnvScalarConstructor.this.constructScalar((ScalarNode) node));
            matcher.matches();
            String strGroup = matcher.group("name");
            String strGroup2 = matcher.group("value");
            return EnvScalarConstructor.this.apply(strGroup, matcher.group("separator"), strGroup2 != null ? strGroup2 : "", EnvScalarConstructor.this.getEnv(strGroup));
        }
    }

    public EnvScalarConstructor() {
        super(new LoaderOptions());
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    public EnvScalarConstructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(typeDescription, collection, loaderOptions);
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    public String apply(String str, String str2, String str3, String str4) {
        if (str4 != null && !str4.isEmpty()) {
            return str4;
        }
        if (str2 == null) {
            return "";
        }
        if (str2.equals("?") && str4 == null) {
            throw new MissingEnvironmentVariableException("Missing mandatory variable " + str + ": " + str3);
        }
        if (str2.equals(":?")) {
            if (str4 == null) {
                throw new MissingEnvironmentVariableException("Missing mandatory variable " + str + ": " + str3);
            }
            if (str4.isEmpty()) {
                throw new MissingEnvironmentVariableException("Empty mandatory variable " + str + ": " + str3);
            }
        }
        if (str2.startsWith(":")) {
            return (str4 == null || str4.isEmpty()) ? str3 : "";
        }
        return str4 == null ? str3 : "";
    }

    public String getEnv(String str) {
        return System.getenv(str);
    }
}
