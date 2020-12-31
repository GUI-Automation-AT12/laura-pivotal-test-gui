package core.utils;

import org.openqa.selenium.WebElement;

public final class WebElementInteractor {

    /**
     * Constructor private.
     */
    private WebElementInteractor() { }

    /**
     * Sets the text into the webElement.
     *
     * @param webElement that sets its text.
     * @param text new value of webElement.
     */
    public static void setTxt(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Gets txt.
     *
     * @param webElement the web element
     * @return the txt
     */
    public static String getTxt(final WebElement webElement) {
        return webElement.getText();
    }
}
