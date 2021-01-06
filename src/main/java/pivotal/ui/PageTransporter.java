package pivotal.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class PageTransporter {

    private static WebDriver webDriver;
    private static final String BASE_URL = "https://www.pivotaltracker.com/";

    /**
     * Constructor of page transporter.
     */
    public PageTransporter() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    private static void goToURL(final String url) {
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
    public static void navigateToPage(final String pageName) {
        String keyUrl = Permalink.getPermalink(pageName.toUpperCase());
        goToURL(BASE_URL.concat(keyUrl));
    }
}
