package unitui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pivotal.config.Environment;

public class EnvironmentTest {

    /**
     * Test base url is loaded from gradle properties file.
     */
    @Test
    public void testBaseUrlIsLoadedFromGradleFile() {
        String expected = "https://www.pivotaltracker.com/";
        String actual= Environment.getInstance().getProperties().get("baseUrl");
        Assert.assertEquals(actual, expected);
    }

    /**
     * Test browser is loaded from driver properties file.
     */
    @Test
    public void testBrowserIsLoadedFromDriverFile() {
        String expected = "chrome";
        String actual= Environment.getInstance().getProperties().get("browser");
        Assert.assertEquals(actual, expected);
    }
}
