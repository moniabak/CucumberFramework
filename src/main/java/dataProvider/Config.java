package dataProvider;

import enums.DriverType;
import enums.EnvironmentType;

import java.util.Properties;

public class Config {

    private final EnvironmentType env;
    private final DriverType browser;
    private final String driverPath;
    private final String url;
    private final String testDataResourcePath;
    private final long implicitWait;
    private final boolean windowsMaximize;

    private Config(EnvironmentType env, DriverType browser, String driverPath, String url, long implicitWait, boolean maximize, String testDataResurcePath) {
        this.env = env;
        this.browser = browser;
        this.driverPath = driverPath;
        this.url = url;
        this.implicitWait = implicitWait;
        this.windowsMaximize = maximize;
        this.testDataResourcePath = testDataResurcePath;
    }

    public EnvironmentType getEnv() {
        return env;
    }

    public DriverType getBrowser() {
        return browser;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getUrl() {
        return url;
    }

    public String getTestDataResourcePath() {
        return testDataResourcePath;
    }

    public long getImplicitWait() {
        return implicitWait;
    }

    public boolean isWindowsMaximize() {
        return windowsMaximize;
    }

    public static class Builder {

        private EnvironmentType env;
        private DriverType browser;
        private String driverPath;
        private String url;
        private String testDataResourcePath;
        private long implicitWait;
        private boolean windowsMaximize;
        private final Properties prop;

        public Builder(Properties prop) {
            this.prop = prop;
        }

        public Builder env(EnvironmentType env) {
            this.env = env;
            return this;
        }

        public Builder browser(DriverType browser) {
            this.browser = browser;
            return this;
        }

        public Builder driverPath(String driverPath) {
            this.driverPath = driverPath;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder testDataResourcePath(String testDataResourcePath) {
            this.testDataResourcePath = testDataResourcePath;
            return this;
        }

        public Builder implicitWait(long iWait) {
            this.implicitWait = iWait;
            return this;
        }

        public Builder windowsMaximize(boolean max) {
            this.windowsMaximize = max;
            return this;
        }

        public Config build() {
            for (ConfigProperties value : ConfigProperties.values()) {
                value.read(prop, this);
            }
            Config c = new Config(env, browser, driverPath, url, implicitWait, windowsMaximize, testDataResourcePath);
            return c;
        }
    }
}
