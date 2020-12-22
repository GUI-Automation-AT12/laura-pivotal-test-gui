package pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
     */
    public ProjectPage() {
        super();
    }
}
