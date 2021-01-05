package pivotal.ui.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotal.ui.pages.ProfilePage;

public class UserMenu {

    @FindBy(css = "a[data-aid='ProfileDropdown__profile']")
    private WebElement profileBtn;

    @FindBy(xpath = "//div[@class='AvatarDetails__name']")
    private WebElement nameDetails;

    @FindBy(xpath = "//div[@class='AvatarDetails__username']")
    private WebElement usernameDetails;

    @FindBy(xpath = "//div[@class='AvatarDetails__initials']")
    private WebElement initialsDetails;

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
   /* public Map<String, String> getMyProfileMap() {
        Map userInfoMap = new HashMap<String, String>();
        HashMap<String, Supplier<String>> myProfileMap = new HashMap<>();
        userInfoMap.put(NAME, WebElementInteractor.getTxt(nameDetails));
        userInfoMap.put(USER_NAME, WebElementInteractor.getTxt(usernameDetails).substring(1));
        userInfoMap.put(INITIALS, WebElementInteractor.getTxt(initialsDetails));
        return userInfoMap;
    }*/
}
