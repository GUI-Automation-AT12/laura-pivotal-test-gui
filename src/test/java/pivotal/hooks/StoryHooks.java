package pivotal.hooks;

import core.client.RequestManager;
import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import pivotal.context.Context;
import pivotal.entities.Story;
import pivotal.ui.pages.ProjectPage;
import pivotal.utils.AuthenticationUtils;

import java.util.LinkedHashMap;
import java.util.List;

public class StoryHooks {

    private Context context;
    private static final String BASE_URL_API = "https://www.pivotaltracker.com/services/v5";
    //projectId of project with "default story" story
    private static final String PROJECT_ID = "2482520";
    private static final String STORY_NAME = "default story";
    //Default project url
    private static final String PROJECT_URL = "https://www.pivotaltracker.com/n/projects/2482520";

    /**
     * Instantiates a new Story hooks.
     *
     * @param contextToSet the context to set
     */
    public StoryHooks(final Context contextToSet) {
        this.context = contextToSet;
    }

    //Returns story Id obtained by API of given story name
    private String getId(final String storyName) {
        String storyId = null;
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        String endpoint = BASE_URL_API + "/projects/" + PROJECT_ID + "/stories";
        Response response = RequestManager.get(endpoint);
        List storyList;
        storyList = response.jsonPath().getList("");
        for (int i = 0; i < storyList.size(); i++) {
            if (storyName.equals(((LinkedHashMap) storyList.get(i)).get("name"))) {
                storyId = ((LinkedHashMap) storyList.get(i)).get("id").toString();
            }
        }
        return storyId;
    }

    /**
     * Save default story into Context.
     */
    @Before(value = "@saveDefaultStory")
    public void saveDefaultStory() {
        Story defaultStory = new Story();
        defaultStory.setId(getId(STORY_NAME));
        defaultStory.setName(STORY_NAME);
        context.setStory(defaultStory);
    }

    /**
     * Restore default story position.
     */
    @After(value = "@restoreDefaultStoryPosition")
    public void restoreDefaultStoryPosition() {
        WebDriverManager.getInstance().getWebDriver().get(PROJECT_URL);
        ProjectPage projectPage = new ProjectPage();
        projectPage.moveStoryFromIceboxToBacklogPanel();
    }
}
