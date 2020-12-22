package pivotal.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pivotal.config.Environment;

import java.net.MalformedURLException;
import java.net.URL;

public class PageTransporter {

    private WebDriver webDriver;
    private static PageTransporter instance;

    /**
     * Constructor of page transporter.
     */
    protected PageTransporter() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    /**
     * Navigates to a page sending the url.
     *
     * @param url for navigate.
     */
    private void goToURL(final String url) {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to a page sending the url.
     *
     * @param keyUrl for navigate.
     */
    public void navigateToPage(final String keyUrl) {
        String baseUrl = Environment.getInstance().getBaseUrl();
        goToURL(baseUrl.concat(keyUrl));
    }
}
