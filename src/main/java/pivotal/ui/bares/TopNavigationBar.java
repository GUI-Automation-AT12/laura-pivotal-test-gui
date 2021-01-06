package pivotal.ui.bares;

import core.utils.WebElementInteractor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.menus.UserMenu;
import pivotal.ui.pages.BasePage;

public class TopNavigationBar extends BasePage {

    @FindBy(css = "div.tc_tracker_header a[aria-label='Dashboard'] > img[alt='tracker logo']")
    private WebElement dashboardBtn;

    @FindBy(css = "button[aria-label='Pivotal Tracker - all projects/workspaces']")
    private WebElement projectWorkspaceDropdown;

    @FindBy(css = "button[aria-label='Profile Dropdown']")
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
        WebElementInteractor.click(userMenuDropdown);
        return new UserMenu();
    }

    /**
     * Gets text from project workspace dropdown.
     *
     * @return the text from project workspace dropdown
     */
    public String getTextFromProjectWorkspaceDropdown() {
        WebElementInteractor.wait(By.cssSelector("span.raw_context_name"));
        return WebElementInteractor.getTxt(projectWorkspaceDropdown);
    }
}
