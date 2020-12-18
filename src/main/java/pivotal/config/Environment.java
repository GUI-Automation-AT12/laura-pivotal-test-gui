package pivotal.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    private Properties property;
    private FileReader reader;
    private static final String GRADLE_FILE = "gradle.properties";
    private static Environment environment;

    /**
     * Initializes an instance of properties files.
     *
     * @param propertiesPath the properties path
     */
    public Environment(final String propertiesPath) {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } finally {
            closeReader();
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment(GRADLE_FILE);
        }
        return environment;
    }

    /**
     * Get baseUrl.
     *
     * @return the base url.
     */
    public String getBaseUrl() {
        return getEnvProperty("baseUrl");
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return getEnvProperty("token");
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return getEnvProperty("email");
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return getEnvProperty("password");
    }

    /**
     * Gets environment property.
     *
     * @param env the env
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
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Gets schemas path.
     *
     * @return the schemas path
     */
    public String getSchemasPath() {
        return getEnvProperty("schemasPath");
    }
}
