package unittest.core.selenium;

import core.selenium.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverManagerTest {
    private WebDriverManager webDriverManager = new WebDriverManager();

    @After
    public void quitWebDriver() {
        webDriverManager.getWebDriver().quit();
    }
    /**
     * Tests if new instance of webdriver Chrome is created.
     */
    @Test
    public void testInitNewWebDriverChrome() {
        WebDriver actual = webDriverManager.getWebDriver();
        Assert.assertNotNull(actual);
    }
}
