package dataProvider;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum ConfigFileReader {
    INST;

    private final String propertyFilePath = "configs//Configuration.properties";
    private final Config config;

    public Config getConfig() {
        return config;
    }

    ConfigFileReader() {
        try {
            Properties properties = loadConfig();
            Config.Builder builder = new Config.Builder(properties);
            config = builder.build();
        } catch (IOException e) {
            throw new RuntimeException("Configuration.properties unable to read " + propertyFilePath);
        }
    }

    private Properties loadConfig() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            Properties prop = new Properties();
            prop.load(reader);
            return prop;
        }
    }
}

enum ConfigProperties {
    ENVIRONMENT("environment") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null || prop.equals("local")) {
                builder.env(EnvironmentType.LOCAL);
                return true;
            } else if (prop.equals("remote")) {
                builder.env(EnvironmentType.REMOTE);
                return true;
            } else return false;
        }
    }, BROWSER("browser") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null || prop.equals("chrome")) {
                builder.browser(DriverType.CHROME);
                return true;
            } else if (prop.equals("firefox")) {
                builder.browser(DriverType.FIREFOX);
                return true;
            } else if (prop.equals("ie")) {
                builder.browser(DriverType.IE);
                return true;
            } else return false;
        }
    }, WINDOWS_MAXIMIZE("windowsMaximize") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null) {
                builder.windowsMaximize(true);
            } else {
                boolean propertyValue = Boolean.valueOf(prop);
                builder.windowsMaximize(propertyValue);
            }
            return true;
        }
    },
    DRIVER_PATH("driverPath") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null) {
                return false;
            } else {
                builder.driverPath(prop);
                return true;
            }
        }
    }, IMPLICIT_WAIT("implicitWait") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null) {
                builder.implicitWait(30);
            } else {
                try {
                    long value = Long.parseLong(prop);
                    ;
                    builder.implicitWait(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }
    },
    URL("url") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null) {
                return false;
            } else {
                builder.url(prop);
                return true;
            }
        }
    }, TEST_DATA_RESOURCES_PATH("testDataResourcePath") {
        @Override
        public boolean doRead(String prop, Config.Builder builder) {
            if (prop == null) {
                return false;
            } else {
                builder.testDataResourcePath(prop);
                return true;
            }
        }
    };

    private final String propertyName;
    private final String defaultValue = "";

    ConfigProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public final boolean read(Properties prop, Config.Builder builder) {
        return doRead(prop.getProperty(propertyName), builder);
    }

    public final String getValue(Properties p) {
        String property = p.getProperty(propertyName);
        if (property == null || property.isEmpty()) {
            return defaultValue;
        } else return property;
    }

    public abstract boolean doRead(String prop, Config.Builder builder);
}

