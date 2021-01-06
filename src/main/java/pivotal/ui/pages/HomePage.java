package pivotal.ui.pages;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.forms.ProjectForm;

public class HomePage extends BasePage {

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    @FindBy(css = "button.Dropdown__option.Dropdown__option--button:nth-child(3)")
    private WebElement signOutProfile;

    @FindBy(css = "a[data-aid='project-name']")
    private WebElement defaultProjectTitleHeader;

    /**
     * Instantiates a new Home page.
     */
    public HomePage() {
        super();
    }

    /**
     * Create project.
     *
     * @return the project form
     */
    public ProjectForm createProject() {
        WebElementInteractor.click(createProjectBtn);
        return new ProjectForm();
    }

    /**
     * Open default project page.
     *
     * @return the project page
     */
    public ProjectPage openDefaultProject() {
        WebElementInteractor.click(defaultProjectTitleHeader);
        return new ProjectPage();
    }
}
