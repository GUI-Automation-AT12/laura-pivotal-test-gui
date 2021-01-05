package pivotal.ui.bares;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.menus.UserMenu;
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
     * Open user menu dropdown user menu.
     *
     * @return the user menu
     */
    public UserMenu openUserMenuDropdown() {
        userMenuDropdown.click();
        return new UserMenu();
    }

    /**
     * Gets profile drop down.
     *
     * @return the profile drop down
     */
    /*public WebElement getUserMenuDropdown() {
        return userMenuDropdown;
    }*/
}
