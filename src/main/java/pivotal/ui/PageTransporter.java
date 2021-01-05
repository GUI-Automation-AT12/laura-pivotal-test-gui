package pivotal.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class PageTransporter {

    private WebDriver webDriver;
    private static PageTransporter instance;
    private static final String BASE_URL = "https://www.pivotaltracker.com/";

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
     * @param pageName for navigate.
     */
    public void navigateToPage(final String pageName) {
        String keyUrl = Permalink.getPermalink(pageName.toUpperCase());
        goToURL(BASE_URL.concat(keyUrl));
    }
}
