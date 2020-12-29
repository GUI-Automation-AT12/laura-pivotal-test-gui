package unittest.core.selenium;

import core.selenium.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverManagerTest {

    /**
     * Quit web driver.
     */
    @AfterTest
    public void quitWebDriver() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }

    /**
     * Tests if new instance of webdriver Chrome is created.
     */
    @Test
    public void testInitNewWebDriverChrome() {
        WebDriver actual = WebDriverManager.getInstance().getWebDriver();
        Assert.assertNotNull(actual, "Web Driver initialized successfully");
    }
}
