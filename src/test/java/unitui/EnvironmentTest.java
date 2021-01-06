package unitui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pivotal.config.Environment;

public class EnvironmentTest {

    /**
     * Test browser is loaded from driver properties file.
     */
    @Test
    public void testBrowserIsLoadedFromDriverFile() {
        String expected = "chrome";
        String actual = Environment.getInstance().getProperties().get("browser");
        Assert.assertEquals(actual, expected);
    }
}
