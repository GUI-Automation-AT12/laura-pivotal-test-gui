package core.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
    private WebDriverWait driverWait;
    private WebDriver webDriver;
    private static final int TIMEOUT = 10;

    public WebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        webDriver = new ChromeDriver();
        driverWait = new WebDriverWait(webDriver, TIMEOUT);
    }

    public WebDriverManager(final WebDriver webDriver, final WebDriverWait driverWait) {
        this.driverWait = driverWait;
        this.webDriver = webDriver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
