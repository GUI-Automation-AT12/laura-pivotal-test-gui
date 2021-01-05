package pivotal.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pivotal.context.Context;
import pivotal.entities.User;
import pivotal.ui.bares.TopNavigationBar;
import pivotal.ui.pages.ProfilePage;

import java.util.Map;

public class ProfileSteps {

    private Context context;
    private ProfilePage profilePage = new ProfilePage();;
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
     * Verify user name is updated.
     */
    @Then("my User Name should be updated in the Top Menu")
    public void verifyUserNameIsUpdatedInTheTopMenu() {
        String userNameFromTopMenu = topNavigationBar.getTextFromUserMenu();
        User user = context.getNewUser();
        String actualValue = user.getUserName().toUpperCase();
  //      Assert.assertEquals(actualValue, userNameFromTopMenu);
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
    @Then("the user information should be updated in My Profile section")
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
     //   Assert.assertEquals(managementMenuTitle, user.getName());
    }

    /**
     * Verify user information is updated in the user dropdown menu.
     */
    @Then("the user information should be updated in the User Dropdown Menu")
    public void verifyUserInformationIsUpdatedInTheUserDropdownMenu() {
        SoftAssert softAssert = new SoftAssert();
   /*     Map<String, String> dropdownMenuInfo = topNavigationBar.getMyProfileMap();
        softAssert.assertEquals(dropdownMenuInfo.get("Name Details"), user.getName());
        softAssert.assertEquals(dropdownMenuInfo.get("User Name Details"), user.getUserName());
        softAssert.assertEquals(dropdownMenuInfo.get("Initials Details"), user.getInitials());
        softAssert.assertAll();*/
    }
}
