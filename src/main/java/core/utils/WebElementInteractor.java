package core.utils;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pivotal.config.Environment;

public final class WebElementInteractor {

    /**
     * Constructor private.
     */
    private WebElementInteractor() { }

    /**
     * Sets the text into the webElement.
     *
     * @param webElement that sets its text.
     * @param text       new value of webElement.
     */
    public static void setTxt(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Gets txt from the webElement.
     *
     * @param webElement the web element
     * @return the txt
     */
    public static String getTxt(final WebElement webElement) {
        return webElement.getText();
    }

    private static WebDriverWait configWebDriverWait() {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        int timeout = Integer.parseInt(Environment.getInstance().getProperties().get("timeout"));
        return new WebDriverWait(webDriver, timeout);
    }

    /**
     * Click the webElement.
     *
     * @param webElement the web element
     */
    public static void click(final WebElement webElement) {
        WebDriverWait wait = configWebDriverWait();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    /**
     * Wait the presence of the webElement.
     *
     * @param by the locator of web element
     */
    public static void wait(final By by) {
        WebDriverWait wait = configWebDriverWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean findElement(final By by) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        return webDriver.findElements(by).size() > 0;
    }
}
