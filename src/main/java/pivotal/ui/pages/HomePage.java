package pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Profile Dropdown']")
    private WebElement profileDropDown;

    @FindBy(css = "div:nth-child(1) > a.Dropdown__option.Dropdown__option--link:nth-child(3)")
    private WebElement profileBtn;

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    @FindBy(css = "button.Dropdown__option.Dropdown__option--button:nth-child(3)")
    private WebElement signOutProfile;

    /**
     * Instantiates a new Project page.
     */
    public HomePage() {
        super();
    }

    /**
     * Create project project page.
     *
     * @return the project page
     */
    public ProjectForm createProject() {
        createProjectBtn.click();
        return new ProjectForm();
    }

    /**
     * Gets profile user.
     *
     * @return the profile user
     */
    public ProfilePage getProfileUser() {
        profileDropDown.click();
        profileBtn.click();
        return new ProfilePage();
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
