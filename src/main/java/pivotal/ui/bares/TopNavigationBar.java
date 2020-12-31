package pivotal.ui.bares;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.pages.BasePage;
import pivotal.ui.pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TopNavigationBar extends BasePage {

    @FindBy(css = "div.tc_tracker_header a[aria-label=\"Dashboard\"] > img[alt=\"tracker logo\"]")
    private WebElement dashboardBtn;

    @FindBy(css = "div.tc_tracker_header ul:nth-child(1) li:nth-child(2) div > button[aria-label=\"Pivotal Tracker - all projects/workspaces\"]")
    private WebElement projectWorkspaceDropdown;

    @FindBy(css = "header[data-aid=\"PageHeader\"] ul:first-child li:nth-child(6) div > button[aria-label=\"0 unread notifications\"]")
    private WebElement notificationsBtn;

    @FindBy(css = "header[data-aid=\"PageHeader\"] ul:first-child li:nth-child(5) div > button[type=\"button\"]")
    private WebElement whatsNewDropdown;

    @FindBy(css = "header[data-aid=\"PageHeader\"] ul:first-child li:nth-child(4) div > button[type=\"button\"]")
    private WebElement helpMenuDropdown;

    @FindBy(css = "button[aria-label=\"Profile Dropdown\"]")
    private WebElement userMenuDropdown;

    //User Menu Dropdown components
    @FindBy(css = "div:nth-child(1) > a.Dropdown__option.Dropdown__option--link:nth-child(3)")
    private WebElement profileBtn;

    @FindBy(xpath = "//div[@class='AvatarDetails__name']")
    private WebElement nameDetails;

    @FindBy(xpath = "//div[@class='AvatarDetails__username']")
    private WebElement usernameDetails;

    @FindBy(xpath = "//div[@class='AvatarDetails__initials']")
    private WebElement initialsDetails;

    /**
     * Instantiates a new Top navigation bar.
     */
    public TopNavigationBar() {
        super();
    }

    /**
     * Gets text from user menu.
     *
     * @return the text from user menu
     */
    public String getTextFromUserMenu() {
        return WebElementInteractor.getTxt(userMenuDropdown);
    }

    /**
     * Open user menu dropdown.
     */
    public void openUserMenuDropdown() {
        userMenuDropdown.click();
    }

    /**
     * Gets profile user.
     *
     * @return the profile user
     */
    public ProfilePage getProfileUser() {
        openUserMenuDropdown();
        profileBtn.click();
        return new ProfilePage();
    }

    /**
     * Gets profile drop down.
     *
     * @return the profile drop down
     */
    public WebElement getUserMenuDropdown() {
        return userMenuDropdown;
    }

    /**
     * Gets my profile map.
     *
     * @return the my profile map
     */
    public Map<String, String> getMyProfileMap() {
      //  userMenuDropdown.click();
        Map userInfoMap = new HashMap<String, String>();
        HashMap<String, Supplier<String>> myProfileMap = new HashMap<>();
        userInfoMap.put("Name Details", WebElementInteractor.getTxt(nameDetails));
        userInfoMap.put("User Name Details", WebElementInteractor.getTxt(usernameDetails).substring(1));
        userInfoMap.put("Initials Details", WebElementInteractor.getTxt(initialsDetails));
        return userInfoMap;
    }
}
