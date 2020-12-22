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

    /**
     * Constructor of Base page.
     */
    public BasePage() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getDriverWait();
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
}
