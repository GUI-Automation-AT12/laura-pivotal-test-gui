package core.utils;

import org.openqa.selenium.WebElement;

public final class WebElementInteractor {
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
     * Constructor private.
     */
    private WebElementInteractor() { }
}
