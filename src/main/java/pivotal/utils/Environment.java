package pivotal.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesReader class.
 */
public class Environment {

    private static final Logger LOGGER = LogManager.getLogger(Environment.class);
    private Properties property;
    private FileReader reader;
    private static Environment environment;

    public Environment() {

    }

    /**
     * Gets a singleton instance of the PivotalEnvironment.
     * @return PivotalEnvironment instance.
     */
//    public static Environment getInstance() throws IOException {
//        if (environment == null) {
//            environment = new Environment();
//        }
//        return environment;
//    }
    /**
     * Initializes an instance of properties files.
     *
     * @param propertiesPath
     */
    public Environment(final String propertiesPath) throws IOException {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            System.out.printf(e.getMessage());
        } finally {
            closeReader();
        }
    }
 /*   public void authenticateUsing(Credentials credentials) {
        final Alert alert = null;
        alert.authenticateUsing(credentials);
    }

    /**
     * get the from the file.properties.
     *
     * @return
     */
    public String getUsername() {
        return getEnvProperty("username");
    }

    /**
     * get the from the file.properties.
     *
     * @return
     */
    public String getPassword() {
        return getEnvProperty("password");
    }

    /**
     * Gets environment property.
     * @param env
     * @return property value.
     */
    protected String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close File Reader.");
        }
    }
}
