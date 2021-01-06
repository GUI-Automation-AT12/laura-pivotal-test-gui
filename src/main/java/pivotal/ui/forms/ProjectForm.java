package pivotal.ui.forms;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

import static pivotal.constants.ProjectIdentifiers.PROJECT_NAME;
import static pivotal.constants.ProjectIdentifiers.PROJECT_PRIVACY;
import static pivotal.constants.ProjectIdentifiers.ACCOUNT;

public class ProjectForm extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement nameTextBox;

    @FindBy(css = ".tc-account-selector__header")
    private WebElement selectAccountDropDown;

    @FindBy(xpath = "//div[@class='tc-account-selector__option-account-name']")
    private WebElement myAccountOption;

    @FindBy(css = "label.tc-project-type-chooser__label:nth-child(2) > input")
    private WebElement privateOption;

    @FindBy(css = "label.tc-project-type-chooser__label:nth-child(3) > input")
    private WebElement publicOption;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createBtn;

    private static final String UNTITLED_ACCOUNT = "Untitled";
    private static final String PRIVATE_OPTION = "Private";
    private static final String PUBLIC_OPTION = "Public";

    /**
     * Instantiates a new Project form.
     */
    public ProjectForm() {
        super();
    }

    private void setProjectName(final String projectName) {
        WebElementInteractor.setTxt(nameTextBox, projectName);
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(final String account) {
        WebElementInteractor.click(selectAccountDropDown);
        if (UNTITLED_ACCOUNT.equals(account)) {
            WebElementInteractor.click(myAccountOption);
        }
    }

    /**
     * Sets project privacy.
     *
     * @param projectPrivacy the project privacy
     */
    public void setProjectPrivacy(final String projectPrivacy) {
        if (PRIVATE_OPTION.equals(projectPrivacy)) {
            WebElementInteractor.click(privateOption);
        } else if (PUBLIC_OPTION.equals(projectPrivacy)) {
            WebElementInteractor.click(publicOption);
        }
    }

    /**
     * Click create button.
     */
    public void clickCreateButton() {
        WebElementInteractor.click(createBtn);
    }

    /**
     * Create project.
     *
     * @param newProject the new project
     */
    public void createProject(final Map<String, String> newProject) {
        final HashMap<String, Runnable> strategyMap = composeStrategyMap(newProject);
        newProject.keySet().forEach(key -> {
            strategyMap.get(key).run(); });
    }

    /**
     * Compose strategy hash map.
     *
     * @param projectInformation the project information
     * @return the hash map
     */
    public HashMap<String, Runnable> composeStrategyMap(final Map<String, String> projectInformation) {
        final HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(PROJECT_NAME, () -> setProjectName(projectInformation.get(PROJECT_NAME)));
        strategyMap.put(ACCOUNT, () -> setAccount(projectInformation.get(ACCOUNT)));
        strategyMap.put(PROJECT_PRIVACY, () -> setProjectPrivacy(projectInformation.get(PROJECT_PRIVACY)));
        return strategyMap;
    }
}
