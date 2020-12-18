package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Profile Dropdown']")
    private WebElement profileDropDown;

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
    public ProjectPage createProject() {
        createProjectBtn.click();
        return new ProjectPage();
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
