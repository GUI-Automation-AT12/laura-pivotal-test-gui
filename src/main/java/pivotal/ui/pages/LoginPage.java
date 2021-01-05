package pivotal.ui.pages;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(css = "input.app_signin_action_button:nth-child(5)")
    private WebElement nextBtn;

    /**
     * Instantiates a new Login page.
     */
    public LoginPage() {
        super();
    }

    /**
     * Set email in Login page.
     *
     * @param email    the email
     * @return the Login Page 2
     */
    public LoginPage2 login(final String email) {
        WebElementInteractor.setTxt(emailTextBox, email);
        nextBtn.click();
        return new LoginPage2();
    }
}
