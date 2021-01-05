package pivotal.ui.pages;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.entities.User;

import static pivotal.constants.UserIdentifiers.NAME;
import static pivotal.constants.UserIdentifiers.USER_NAME;
import static pivotal.constants.UserIdentifiers.INITIALS;

public class ProfilePage extends BasePage {

    @FindBy(id = "person_username")
    private WebElement usernameTextBox;

    @FindBy(id = "person_name")
    private WebElement nameTextBox;

    @FindBy(id = "person_initials")
    private WebElement initialsTextBox;

    @FindBy(xpath = "//div[contains(text(),'UpdatedUsername')]")
    private WebElement usernameField;

    @FindBy(xpath = "//ul[@class='rows read']//li//div[contains(text(),'Updated name')]")
    private WebElement nameField;

    @FindBy(css = "div.profile_page.settings:nth-child(3) div.card:nth-child(1) ul.rows.read li:nth-child(3) > div:nth-child(2)")
    private WebElement initialsField;

    @FindBy(css = "#person_start_page")
    private WebElement startPageDropDown;

    @FindBy(css = "#person_time_zone")
    private WebElement timeZoneDropDown;

    @FindBy(css = "#person_default_story_type_value")
    private WebElement defaultStoryTypeDropDown;

    @FindBy(css = "#general .save_button")
    private WebElement saveBtn;

    @FindBy(css = "#general .edit_button")
    private WebElement editBtn;

    @FindBy(css = "#general_flash span")
    private WebElement changesNotification;

    @FindBy(css = ".name")
    private WebElement userManagementMenuTitle;

    /**
     * Instantiates a new Profile page.
     */
    public ProfilePage() {
        super();
    }

    private void setInformationToEdit(final Set<String> formFields, final User user) {
        HashMap<String, Runnable> strategyMap = composeStrategySetterMap(formFields, user);
        formFields.forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose my profile map hash map.
     *
     * @param fields the fields
     * @param user   the user
     * @return the hash map
     */
    public HashMap<String, Runnable> composeStrategySetterMap(final Set<String> fields, final User user) {
        final HashMap<String, Runnable> myProfileMap = new HashMap<>();
        myProfileMap.put(USER_NAME, () -> WebElementInteractor.setTxt(usernameTextBox, user.getUserName()));
        myProfileMap.put(NAME, () -> WebElementInteractor.setTxt(nameTextBox, user.getName()));
        myProfileMap.put(INITIALS, () -> WebElementInteractor.setTxt(initialsTextBox, user.getInitials()));
        return myProfileMap;
    }

    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        final HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put(USER_NAME, () -> WebElementInteractor.getTxt(usernameTextBox));
        strategyMap.put(NAME, () -> WebElementInteractor.getTxt(nameTextBox));
        strategyMap.put(INITIALS, () -> WebElementInteractor.getTxt(initialsTextBox));
        return strategyMap;
    }

    /**
     * Edit profile.
     *
     * @param fields the fields
     * @param user   the user
     */
    public void editProfile(final Set<String> fields, final User user) {
        editBtn.click();
        setInformationToEdit(fields, user);
        saveBtn.click();
    }

    /**
     * Gets text from changes notification.
     *
     * @return the text from changes notification
     */
    public String getTextFromChangesNotification() {
        return WebElementInteractor.getTxt(changesNotification);
    }

    /**
     * Gets my profile map.
     *
     * @return the my profile map
     */
    public Map<String, String> getMyProfileMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put(USER_NAME, WebElementInteractor.getTxt(usernameField));
        userInfoMap.put(NAME, WebElementInteractor.getTxt(nameField));
        userInfoMap.put(INITIALS, WebElementInteractor.getTxt(initialsField));
        return userInfoMap;
    }
    /**
     * Gets user mm title.
     *
     * @return the user mm title
     */
    public String getUserManagementMenuTitle() {
        return WebElementInteractor.getTxt(userManagementMenuTitle).toUpperCase();
    }
}

