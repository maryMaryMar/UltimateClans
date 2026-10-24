package me.ulrich.clans.library.hikari;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import javax.sql.DataSource;
import me.ulrich.clans.library.hikari.util.PropertyElf;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/HikariJNDIFactory.class */
public class HikariJNDIFactory implements ObjectFactory {
    public synchronized Object getObjectInstance(Object obj, Name name, Context context, Hashtable<?, ?> hashtable) {
        if (!(obj instanceof Reference) || !"javax.sql.DataSource".equals(((Reference) obj).getClassName())) {
            return null;
        }
        Set<String> propertyNames = PropertyElf.getPropertyNames(HikariConfig.class);
        Properties properties = new Properties();
        Enumeration all = ((Reference) obj).getAll();
        while (all.hasMoreElements()) {
            RefAddr refAddr = (RefAddr) all.nextElement();
            String type = refAddr.getType();
            if (type.startsWith("dataSource.") || propertyNames.contains(type)) {
                properties.setProperty(type, refAddr.getContent().toString());
            }
        }
        return createDataSource(properties, context);
    }

    private DataSource createDataSource(Properties properties, Context context) {
        String property = properties.getProperty("dataSourceJNDI");
        return property != null ? lookupJndiDataSource(properties, context, property) : new HikariDataSource(new HikariConfig(properties));
    }

    private DataSource lookupJndiDataSource(Properties properties, Context context, String str) {
        if (context == null) {
            throw new RuntimeException("JNDI context does not found for dataSourceJNDI : " + str);
        }
        DataSource dataSource = (DataSource) context.lookup(str);
        if (dataSource == null) {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup(str);
            initialContext.close();
        }
        if (dataSource == null) {
            return null;
        }
        HikariConfig hikariConfig = new HikariConfig(properties);
        hikariConfig.setDataSource(dataSource);
        return new HikariDataSource(hikariConfig);
    }
}
