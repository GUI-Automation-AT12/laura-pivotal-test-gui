package pivotal.ui.menus;

import core.utils.WebElementInteractor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.pages.BasePage;
import pivotal.ui.pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;

import static pivotal.constants.UserIdentifiers.NAME;
import static pivotal.constants.UserIdentifiers.USER_NAME;
import static pivotal.constants.UserIdentifiers.INITIALS;

public class UserMenu extends BasePage {

    @FindBy(css = "a[data-aid='ProfileDropdown__profile']")
    private WebElement profileBtn;

    @FindBy(xpath = "//div[@class='AvatarDetails__name']")
    private WebElement nameDetails;

    @FindBy(xpath = "//div[@class='AvatarDetails__username']")
    private WebElement usernameDetails;

    @FindBy(xpath = "//div[@class='AvatarDetails__initials']")
    private WebElement initialsDetails;

    /**
     * Instantiates a new User menu.
     */
    public UserMenu() {
        super();
    }

    /**
     * Gets profile user.
     *
     * @return the profile user
     */
    public ProfilePage getProfileUser() {
        profileBtn.click();
        return new ProfilePage();
    }

    /**
     * Gets my profile map.
     *
     * @return the my profile map
     */
     public Map<String, String> getMyProfileMap() {
        Map userInfoMap = new HashMap<String, String>();
     //   HashMap<String, Supplier<String>> myProfileMap = new HashMap<>();
        userInfoMap.put(NAME, WebElementInteractor.getTxt(nameDetails));
        userInfoMap.put(USER_NAME, WebElementInteractor.getTxt(usernameDetails).substring(1));
        userInfoMap.put(INITIALS, WebElementInteractor.getTxt(initialsDetails));
        return userInfoMap;
//         myProfileMap.put(NAME, WebElementInteractor.getTxt(nameDetails));
//         myProfileMap.put(USER_NAME, WebElementInteractor.getTxt(usernameDetails).substring(1));
//         myProfileMap.put(INITIALS, WebElementInteractor.getTxt(initialsDetails));
//         return myProfileMap;
    }
}
