package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(css = "input.app_signin_action_button:nth-child(5)")
    private WebElement nextBtn;

    /**
     * Instantiates a new Login page.
     *
     * @param webDriver the webDriver
     * @param webDriverWait   the webDriverWait
     */
    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    /**
     * Set email in Login page.
     *
     * @param email    the email
     * @return the Login Page 2
     */
    public LoginPage2 login (final String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        nextBtn.click();
        return new LoginPage2(webDriver, webDriverWait);
    }
}
