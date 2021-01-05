package pivotal.hooks;

import io.cucumber.java.After;
import pivotal.context.Context;
import pivotal.entities.User;
import pivotal.ui.PageTransporter;
import pivotal.ui.pages.ProfilePage;

import java.util.Set;

public class UserHooks {
    private final Context context;

    public UserHooks(final Context contextToSet) {
        context = contextToSet;
    }

    @After(value = "@resetUserInformation")
    public void resetUserInformation() {
        PageTransporter.navigateToPage("PROFILE_PAGE");
        ProfilePage profilePage = new ProfilePage();
        User user = context.getUserByAlias(context.getUserEdited());
        Set<String> data = user.getUpdatedFields();
        profilePage.editProfile(data, user);
        context.setUsers(null);
    }
}
