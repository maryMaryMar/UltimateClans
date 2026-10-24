package me.ulrich.clans.library.hikari.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Enumeration;
import java.util.Properties;
import javax.sql.DataSource;
import me.module.multiserver.library.redis.jedis.resps.AccessControlLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/DriverDataSource.class */
public final class DriverDataSource implements DataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DriverDataSource.class);
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private final String jdbcUrl;
    private final Properties driverProperties = new Properties();
    private Driver driver;

    public DriverDataSource(String str, String str2, Properties properties, String str3, String str4) {
        this.jdbcUrl = str;
        this.driverProperties.putAll(properties);
        if (str3 != null) {
            this.driverProperties.put(USER, this.driverProperties.getProperty(USER, str3));
        }
        if (str4 != null) {
            this.driverProperties.put(PASSWORD, this.driverProperties.getProperty(PASSWORD, str4));
        }
        if (str2 != null) {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driverNextElement = drivers.nextElement();
                if (driverNextElement.getClass().getName().equals(str2)) {
                    this.driver = driverNextElement;
                    break;
                }
            }
            if (this.driver == null) {
                LOGGER.warn("Registered driver with driverClassName={} was not found, trying direct instantiation.", str2);
                Class<?> clsLoadClass = null;
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    try {
                        try {
                            clsLoadClass = contextClassLoader.loadClass(str2);
                            LOGGER.debug("Driver class {} found in Thread context class loader {}", str2, contextClassLoader);
                        } catch (ClassNotFoundException e) {
                            LOGGER.debug("Driver class {} not found in Thread context class loader {}, trying classloader {}", str2, contextClassLoader, getClass().getClassLoader());
                        }
                    } catch (ClassNotFoundException e2) {
                        LOGGER.debug("Failed to load driver class {} from HikariConfig class classloader {}", str2, getClass().getClassLoader());
                    }
                }
                if (clsLoadClass == null) {
                    clsLoadClass = getClass().getClassLoader().loadClass(str2);
                    LOGGER.debug("Driver class {} found in the HikariConfig class classloader {}", str2, getClass().getClassLoader());
                }
                if (clsLoadClass != null) {
                    try {
                        this.driver = (Driver) clsLoadClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception e3) {
                        LOGGER.warn("Failed to create instance of driver class {}, trying jdbcUrl resolution", str2, e3);
                    }
                }
            }
        }
        String strMaskPasswordInJdbcUrl = UtilityElf.maskPasswordInJdbcUrl(str);
        try {
            if (this.driver == null) {
                this.driver = DriverManager.getDriver(str);
                LOGGER.debug("Loaded driver with class name {} for jdbcUrl={}", this.driver.getClass().getName(), strMaskPasswordInJdbcUrl);
            } else if (!this.driver.acceptsURL(str)) {
                throw new RuntimeException("Driver " + str2 + " claims to not accept jdbcUrl, " + strMaskPasswordInJdbcUrl);
            }
        } catch (SQLException e4) {
            throw new RuntimeException("Failed to get driver instance for jdbcUrl=" + strMaskPasswordInJdbcUrl, e4);
        }
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() {
        return this.driver.connect(this.jdbcUrl, this.driverProperties);
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String str, String str2) {
        Properties properties = (Properties) this.driverProperties.clone();
        if (str != null) {
            properties.put(USER, str);
            if (properties.containsKey(AccessControlLogEntry.USERNAME)) {
                properties.put(AccessControlLogEntry.USERNAME, str);
            }
        }
        if (str2 != null) {
            properties.put(PASSWORD, str2);
        }
        return this.driver.connect(this.jdbcUrl, properties);
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter printWriter) throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int i) {
        DriverManager.setLoginTimeout(i);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() {
        return DriverManager.getLoginTimeout();
    }

    @Override // javax.sql.CommonDataSource
    public java.util.logging.Logger getParentLogger() {
        return this.driver.getParentLogger();
    }

    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> cls) throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> cls) {
        return false;
    }
}
