package pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage2 extends BasePage {
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement loginBtn;

    /**
     * Instantiates a new Login page 2.
     */
    public LoginPage2() {
        super();
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
        return new HomePage();
    }
}
