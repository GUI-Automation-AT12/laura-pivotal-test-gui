package pivotal.ui.pages;

import core.IStrategySetter;
import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * Create project.
     *
     * @param newProject the new project
     */
    public void createProject(final Map<String, String> newProject) {
        final HashMap<String, IStrategySetter> strategyMap = composeStrategyMap(newProject);
        newProject.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * Compose strategy map hash map.
     *
     * @param newProject the new project
     * @return the hash map
     */
    public HashMap<String, IStrategySetter> composeStrategyMap(final Map<String, String> newProject) {
        final HashMap<String, IStrategySetter> strategyMap = new HashMap<>();
        strategyMap.put("Project Name", () -> setProjectName(newProject.get("Project Name")));
        strategyMap.put("Account", () -> setAccount(newProject.get("Account")));
        strategyMap.put("Project privacy", () -> setProjectPrivacy(newProject.get("Project privacy")));
        return strategyMap;
    }

    private void setProjectName(final String projectName) {
        WebElementInteractor.setTxt(nameTextBox, projectName);
    }

    private void setAccount(final String account) {
       // Select selectElement = new Select(selectAccountDropDown);
       // selectElement.selectByVisibleText(account);
        selectAccountDropDown.click();
        if ("Untitled".equals(account)) {
            myAccountOption.click();
        }
      //  Actions keyDown = new Actions(getWebDriver());
       // keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
    }

    private void setProjectPrivacy(final String projectPrivacy) {
        if ("Private".equals(projectPrivacy)) {
            privateOption.click();
        } else if ("Public".equals(projectPrivacy)) {
            publicOption.click();
        }
    }

    /**
     * Click create button.
     */
    public void clickCreateButton() {
        createBtn.click();
    }
}
