package pivotal.hooks;

import core.client.RequestManager;
import io.cucumber.java.After;
import io.restassured.response.Response;
import pivotal.context.Context;
import pivotal.utils.AuthenticationUtils;

import java.util.*;

public class ProjectHooks {

    private Context context;
    private static final String BASE_URL_API = "https://www.pivotaltracker.com/services/v5";

    /**
     * Instantiates a new Project hooks.
     *
    // * @param contextToSet the context to set
     */
    public ProjectHooks(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Deletes project.
     */
    @After(value = "@deleteProject")
    public void deleteProject() {
        String projectName = context.getProject().getProjectName();
        String projectId =  getId(projectName);
        String endpoint = BASE_URL_API + "/projects/" + projectId;
        RequestManager.delete(endpoint);
    }

    private String getId(final String projectName) {
        String projectId = null;
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        String endpoint = BASE_URL_API + "/me";
        Response response = RequestManager.get(endpoint);
        List projectList = new ArrayList<HashMap>();
        projectList = response.jsonPath().getJsonObject("projects");
        for (int i = 0; i < projectList.size(); i++) {
            if (projectName.equals(((LinkedHashMap) projectList.get(i)).get("project_name"))) {
                return ((LinkedHashMap) projectList.get(i)).get("project_id").toString();
            }
        }
        return projectId;
    }
}
