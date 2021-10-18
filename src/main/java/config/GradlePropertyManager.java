package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum GradlePropertyManager {
    INSTANCE;

    static final String GRADLE_PROPERTIES_FILE = "properties/environment.properties";
    Properties properties;

    GradlePropertyManager() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final Properties gradleProperties = new Properties();
        try {
            InputStream in = classLoader.getResourceAsStream(GRADLE_PROPERTIES_FILE);
            if (in == null) {
                throw new RuntimeException("The file " + GRADLE_PROPERTIES_FILE + " does not exist !");
            }
            gradleProperties.load(in);
        } catch (final IOException e) {
            throw new RuntimeException("Error reading file " + GRADLE_PROPERTIES_FILE + ": " + e.getMessage());
        }

        this.properties = gradleProperties;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        this.properties.setProperty(key, value);
    }
}
