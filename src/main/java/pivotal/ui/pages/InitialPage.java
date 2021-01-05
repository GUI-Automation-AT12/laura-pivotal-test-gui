package pivotal.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.config.Environment;

public class InitialPage extends BasePage {

    @FindBy(css = "div.header__lg:nth-child(4) > a.header__link.header__link-signin:nth-child(4)")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Product')]")
    private WebElement productDropDown;

    @FindBy(xpath = "//span[contains(text(),'Community')]")
    private WebElement communityDropDown;

    @FindBy(css = "div.header__md:nth-child(3) div.subheader__dropdown-content.header__dropdown-content > a.subheader__dropdown-link.header__dropdown-link:nth-child(5)")
    private WebElement blogBtn;

    @FindBy(css = "input.signup-form__email")
    private WebElement emailTextBox;

    @FindBy(css = "input.signup-button")
    private WebElement getStartedBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign up with Google')]")
    private WebElement signUpGoogleLink;

    private static final String BASE_URL = "https://www.pivotaltracker.com/";

    /**
     * Instantiates a new Initial page.
     */
    public InitialPage() {
        super();
    }

    /**
     * Login to pivotal.
     *
     * @return the login page
     */
    public LoginPage login() {
        WebDriverManager.getInstance().getWebDriver().get(BASE_URL);
        loginBtn.click();
        return new LoginPage();
    }
}
