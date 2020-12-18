package pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement nameTextBox;
    @FindBy(xpath = "//span[@class='tc-account-selector__list-header-name']")
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
     * Instantiates a new Project page.
     *
     * @param webDriver     the web driver
     * @param webDriverWait the web driver wait
     */
    public ProjectPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    /**
     * Create project project page 2.
     *
     * @param name    the name
     * @param account the account
     * @return the project page 2
     */
    public ProjectPage2 createProject(final String name, final String account) {
        return new ProjectPage2(getWebDriver(), getWebDriverWait());
    }
}
