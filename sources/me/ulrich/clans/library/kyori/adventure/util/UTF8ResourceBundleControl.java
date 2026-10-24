package me.ulrich.clans.library.kyori.adventure.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/UTF8ResourceBundleControl.class */
@Deprecated
public final class UTF8ResourceBundleControl extends ResourceBundle.Control {
    private static final UTF8ResourceBundleControl INSTANCE = new UTF8ResourceBundleControl();

    @Deprecated
    public static ResourceBundle.Control get() {
        return INSTANCE;
    }

    @Deprecated
    public static ResourceBundle.Control utf8ResourceBundleControl() {
        return INSTANCE;
    }

    @Override // java.util.ResourceBundle.Control
    public ResourceBundle newBundle(String str, Locale locale, String str2, ClassLoader classLoader, boolean z) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        if (!str2.equals("java.properties")) {
            return super.newBundle(str, locale, str2, classLoader, z);
        }
        String resourceName = toResourceName(toBundleName(str, locale), "properties");
        InputStream resourceAsStream = null;
        if (z) {
            URL resource = classLoader.getResource(resourceName);
            if (resource != null && (uRLConnectionOpenConnection = resource.openConnection()) != null) {
                uRLConnectionOpenConnection.setUseCaches(false);
                resourceAsStream = uRLConnectionOpenConnection.getInputStream();
            }
        } else {
            resourceAsStream = classLoader.getResourceAsStream(resourceName);
        }
        if (resourceAsStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
        try {
            PropertyResourceBundle propertyResourceBundle = new PropertyResourceBundle(inputStreamReader);
            inputStreamReader.close();
            return propertyResourceBundle;
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
