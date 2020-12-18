package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage2 extends BasePage {
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement loginBtn;

    /**
     * Instantiates a new Login page 2.
     *
     * @param webDriver     the web driver
     * @param webDriverWait the web driver wait
     */
    public LoginPage2(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    /**
     * Set password in Login page.
     *
     * @param password the password
     * @return the home page
     */
    public HomePage login(final String password) {
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        loginBtn.click();
        return new HomePage(getWebDriver(), getWebDriverWait());
    }
}
