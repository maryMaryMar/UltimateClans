package me.ulrich.clans.library.hikari.hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import me.ulrich.clans.library.hikari.HikariConfig;
import me.ulrich.clans.library.hikari.HikariDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Version;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.Stoppable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/hibernate/HikariConnectionProvider.class */
public class HikariConnectionProvider implements ConnectionProvider, Configurable, Stoppable {
    private static final long serialVersionUID = -9131625057941275711L;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) HikariConnectionProvider.class);
    private HikariConfig hcfg = null;
    private HikariDataSource hds = null;

    public HikariConnectionProvider() {
        if (Version.getVersionString().substring(0, 5).compareTo("4.3.6") >= 1) {
            LOGGER.warn("me.ulrich.clans.library.hikari.hibernate.HikariConnectionProvider has been deprecated for versions of Hibernate 4.3.6 and newer.  Please switch to org.hibernate.hikaricp.internal.HikariCPConnectionProvider.");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.hibernate.HibernateException */
    public void configure(Map map) throws HibernateException {
        try {
            LOGGER.debug("Configuring HikariCP");
            this.hcfg = HikariConfigurationUtil.loadConfiguration(map);
            this.hds = new HikariDataSource(this.hcfg);
            LOGGER.debug("HikariCP Configured");
        } catch (Exception e) {
            throw new HibernateException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        if (this.hds != null) {
            connection = this.hds.getConnection();
        }
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public boolean supportsAggressiveRelease() {
        return false;
    }

    public boolean isUnwrappableAs(Class cls) {
        return ConnectionProvider.class.equals(cls) || HikariConnectionProvider.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.hibernate.service.UnknownUnwrapTypeException */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T unwrap(Class<T> cls) throws UnknownUnwrapTypeException {
        if (ConnectionProvider.class.equals(cls) || HikariConnectionProvider.class.isAssignableFrom(cls)) {
            return this;
        }
        if (DataSource.class.isAssignableFrom(cls)) {
            return (T) this.hds;
        }
        throw new UnknownUnwrapTypeException(cls);
    }

    public void stop() {
        this.hds.close();
    }
}
