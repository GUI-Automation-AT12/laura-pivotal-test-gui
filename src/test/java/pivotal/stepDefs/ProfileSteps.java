package pivotal.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pivotal.context.Context;
import pivotal.entities.User;
import pivotal.ui.bares.TopNavigationBar;
import pivotal.ui.menus.UserMenu;
import pivotal.ui.pages.ProfilePage;

import java.util.Map;

import static pivotal.constants.UserIdentifiers.NAME;
import static pivotal.constants.UserIdentifiers.USER_NAME;
import static pivotal.constants.UserIdentifiers.INITIALS;

public class ProfileSteps {

    private Context context;
    private ProfilePage profilePage = new ProfilePage();
    private TopNavigationBar topNavigationBar = new TopNavigationBar();

    /**
     * Instantiates a new Profile steps.
     *
     * @param contextToSet the context to set
     */
    public ProfileSteps(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Edit my profile with the following information.
     *
     * @param data the data
     */
    @And("^I edit My Profile with the following information$")
    public void editMyProfileWithTheFollowingInformation(final Map<String, String> data) {
        context.saveActualUser();
        User user = new User();
        user.processInformation(data);
        context.saveNewUser(user);
        profilePage.editProfile(data.keySet(), user);
    }

    /**
     * Verify message is displayed in my profile section.
     *
     * @param message the message
     */
    @Then("{string} message should be displayed in My Profile section")
    public void verifyMessageIsDisplayedInMyProfileSection(final String message) {
        String messageDisplayed = profilePage.getTextFromChangesNotification();
        Assert.assertNotNull(messageDisplayed, "Changes Saved message displayed");
    }

    /**
     * Verify user information is updated in my profile section.
     */
    @And("the user information should be updated in My Profile section")
    public void verifyUserInformationIsUpdatedInMyProfileSection() {
        SoftAssert softAssert = new SoftAssert();
        Map<String, String> actualProfileInfo = profilePage.getMyProfileMap();
        Map<String, String> expectedProfileInfo = context.getNewUser().getUserInfo();
        actualProfileInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedProfileInfo.get(field));
        });
        softAssert.assertAll();
    }

    /**
     * Verify name is updated in the user management menu.
     */
    @Then("my Name should be updated in the User Management Menu")
    public void verifyNameIsUpdatedInTheUserManagementMenu() {
        String managementMenuTitle = profilePage.getUserManagementMenuTitle();
        String expectedValue = context.getNewUser().getName().toUpperCase();
        Assert.assertEquals(managementMenuTitle, expectedValue);
    }

    /**
     * Verify user name is updated.
     */
    @And("my User Name should be updated in the Top Menu")
    public void verifyUserNameIsUpdatedInTheTopMenu() {
        String userNameFromTopMenu = topNavigationBar.getTextFromUserMenu();
        User user = context.getNewUser();
        String expectedValue = user.getUserName().toUpperCase();
        Assert.assertEquals(userNameFromTopMenu, expectedValue);
    }

    /**
     * Verify user information is updated in the user dropdown menu.
     */
    @Then("the user information should be updated in the User Dropdown Menu")
    public void verifyUserInformationIsUpdatedInTheUserDropdownMenu() {
        SoftAssert softAssert = new SoftAssert();
        UserMenu userMenu = new UserMenu();
        User user = context.getNewUser();
        Map<String, String> dropdownMenuInfo = userMenu.getMyProfileMap();
        softAssert.assertEquals(dropdownMenuInfo.get(NAME), user.getName());
        softAssert.assertEquals(dropdownMenuInfo.get(USER_NAME), user.getUserName());
        softAssert.assertEquals(dropdownMenuInfo.get(INITIALS), user.getInitials());
        softAssert.assertAll();
    }
}
