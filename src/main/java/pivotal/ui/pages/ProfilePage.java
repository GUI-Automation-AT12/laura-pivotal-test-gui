package pivotal.ui.pages;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(id = "person_username")
    private WebElement usernameTextBox;

    @FindBy(id = "person_name")
    private WebElement nameTextBox;

    @FindBy(id = "person_initials")
    private WebElement initialsTextBox;

    @FindBy(css = "#general .save_button")
    private WebElement saveBtn;

    @FindBy(css = "#general .edit_button")
    private WebElement editBtn;

    /**
     * Instantiates a new Profile page.
     */
    public ProfilePage() {
        super();
    }

    /**
     * Edit profile.
     *
     * @param username the username
     * @param name     the name
     * @param initials the initials
     */
    public void editProfile(final String username, final String name, final String initials) {
        editBtn.click();
        WebElementInteractor.setTxt(usernameTextBox, username);
        WebElementInteractor.setTxt(nameTextBox, name);
        WebElementInteractor.setTxt(initialsTextBox, initials);
        saveBtn.click();
    }
}

