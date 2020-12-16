package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialPage extends BasePage{
    @FindBy(css = "div.header__lg:nth-child(4) > a.header__link.header__link-signin:nth-child(4)")
    private WebElement loginBtn;

    /**
     * Instantiates a new Initial page.
     *
     * @param driver the driver
     * @param wait   the wait
     */
    public InitialPage(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Click login btn.
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
}
