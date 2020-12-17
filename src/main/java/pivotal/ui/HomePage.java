package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(xpath = "//button[@aria-label='Profile Dropdown']")
    private WebElement profileDropDown;

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    @FindBy(css = "button.Dropdown__option.Dropdown__option--button:nth-child(3)")
    private WebElement signOutProfile;

    /**
     * Instantiates a new Project page.
     *
     * @param webDriver the webDriver
     * @param webDriverWait   the webDriverWait
     */
    public HomePage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public ProjectPage createProject() {
        createProjectBtn.click();
        return new ProjectPage(webDriver, webDriverWait);
    }

    /**
     * Gets profile drop down.
     *
     * @return the profile drop down
     */
    public WebElement getProfileDropDown() {
        return profileDropDown;
    }
}
