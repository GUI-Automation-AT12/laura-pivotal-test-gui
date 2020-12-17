package pivotal.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected WebDriverManager webDriverManager;

    /**
     * Constructor of Base page.
     *
     * @param webDriver     the web driver
     * @param webDriverWait the web driver wait
     */
    public BasePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        webDriverManager = new WebDriverManager(webDriver, webDriverWait);
        PageFactory.initElements(this.webDriver, this);
    }
}
