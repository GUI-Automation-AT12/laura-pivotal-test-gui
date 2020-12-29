package pivotal.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Environment {

    private static final String GRADLE_FILE = "gradle.properties";
    private static final String DRIVER_FILE = "driver.properties";
    private static Environment environment;
    private Map<String, String> properties;
    private Properties property;
    private FileReader fileReader;

    /**
     * Instantiates a new Environment.
     */
    protected Environment() {
        properties = new HashMap<>();
        addPropertiesGradle();
        addPropertiesDriver();
    }

    private void addPropertiesGradle() {
        Properties propertiesGradle = loadFile(GRADLE_FILE);
        propertiesGradle.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }

    private void addPropertiesDriver() {
        Properties propertiesDriver = loadFile(DRIVER_FILE);
        propertiesDriver.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }

    private Properties loadFile(final String propertiesPath) {
        property = new Properties();
        try {
            fileReader = new FileReader(propertiesPath);
            property.load(fileReader);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            closeReader();
        }
        return property;
    }

    private void closeReader() {
        try {
            fileReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Map<String, String> getProperties() {
        return properties;
    }
}
