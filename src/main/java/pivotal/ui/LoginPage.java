package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    @FindBy(id = "credentials_username")
    private WebElement emailTextBox;

    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.app_signin_action_button:nth-child(5)")
    private WebElement nextBtn;

    @FindBy(css = "input.app_signin_action_button")
    private WebElement loginBtn;

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     * @param wait   the wait
     */
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Login home page.
     *
     * @param email    the email
     * @param password the password
     * @return the home page
     */
    public HomePage login (final String email, final String password) {
        setEmail(email);
        clickNextBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setPassword(password);
        clickLoginBtn();
        return new HomePage(driver, wait);
    }

    private void clickNextBtn() {
        nextBtn.click();
    }

    private void clickLoginBtn() {
        loginBtn.click();
    }

    private void setEmail(final String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
    }

    private void setPassword(final String password) {
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }
}
