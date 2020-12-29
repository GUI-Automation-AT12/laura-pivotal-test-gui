package core.selenium;

import core.selenium.factory.Chrome;
import core.selenium.factory.Firefox;
import core.selenium.factory.IDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static Map<String, IDriver> browsers = new HashMap<>();
    static {
        browsers.put("chrome", new Chrome());
        browsers.put("firefox", new Firefox());
    }

    public static WebDriver getWebDriver(final String browser) {
        return browsers.get(browser).initDriver();
    }
}
