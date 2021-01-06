package pivotal.context;

import core.utils.JsonDataReader;
import pivotal.entities.Project;
import pivotal.entities.Story;
import pivotal.entities.User;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, User> users;
    private Map<String, String> data;
    private Project project;
    private Story story;
    private String userEdited;
    private final String USER_EDITED = "User after changes";


    /**
     * Instantiates a new Context.
     */
    public Context() {
    }

    public void saveNewUser(final User user) {
        this.users.put(USER_EDITED, user);
    }

    public void saveActualUser() {
        User user = new User();
        this.users = new HashMap<String, User>();
        JsonDataReader jsonDataReader = new JsonDataReader("users.json");
        user.setUserName(jsonDataReader.getValueData(userEdited, "username"));
        user.setName(jsonDataReader.getValueData(userEdited, "name"));
        user.setInitials(jsonDataReader.getValueData(userEdited, "initials"));
        this.users.put(userEdited, user);
    }

    public User getUserByAlias(final String user) {
        return users.get(user);
    }

    public void setUsers(final Map<String, User> users) {
        this.users = users;
    }

    public void setUserEdited(final String userEdited) {
        this.userEdited = userEdited;
    }

    public String getUserEdited() {
        return userEdited;
    }

    public User getNewUser() {
        return users.get(USER_EDITED);
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public Map<String, String> getData() {
        return data;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(final Story story) {
        this.story = story;
    }

    public void saveData(final String key, final String value) {
        data = new HashMap<>();
        data.put(key, value);
    }
}
