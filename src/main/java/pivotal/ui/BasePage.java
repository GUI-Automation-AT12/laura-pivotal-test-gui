package pivotal.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Base page.
 */
public abstract class BasePage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebDriverManager webDriverManager;

    /**
     * Constructor of Base page.
     *
     * @param webDriverToSet     the web driver
     * @param webDriverWaitToSet the web driver wait
     */
    public BasePage(final WebDriver webDriverToSet, final WebDriverWait webDriverWaitToSet) {
        this.webDriver = webDriverToSet;
        this.webDriverWait = webDriverWaitToSet;
        webDriverManager = new WebDriverManager(webDriver, webDriverWait);
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets web driver wait.
     *
     * @return the web driver wait
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Gets web driver manager.
     *
     * @return the web driver manager
     */
    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
}
