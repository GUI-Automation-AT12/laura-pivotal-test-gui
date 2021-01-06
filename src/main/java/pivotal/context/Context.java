package pivotal.context;

import core.utils.JsonDataReader;
import pivotal.entities.Project;
import pivotal.entities.Story;
import pivotal.entities.User;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, User> users;
    private Project project;
    private Story story;
    private String userEdited;
    private static final String USER_EDITED = "User after changes";

    /**
     * Instantiates a new Context.
     */
    public Context() {
    }

    /**
     * Save new user.
     *
     * @param user the user
     */
    public void saveNewUser(final User user) {
        this.users.put(USER_EDITED, user);
    }

    /**
     * Save actual user.
     */
    public void saveActualUser() {
        User user = new User();
        this.users = new HashMap<String, User>();
        JsonDataReader jsonDataReader = new JsonDataReader("users.json");
        user.setUserName(jsonDataReader.getValueData(userEdited, "username"));
        user.setName(jsonDataReader.getValueData(userEdited, "name"));
        user.setInitials(jsonDataReader.getValueData(userEdited, "initials"));
        this.users.put(userEdited, user);
    }

    /**
     * Gets user by alias.
     *
     * @param user the user
     * @return the user by alias
     */
    public User getUserByAlias(final String user) {
        return users.get(user);
    }

    /**
     * Sets users.
     *
     * @param usersToSet the users to set
     */
    public void setUsers(final Map<String, User> usersToSet) {
        this.users = usersToSet;
    }

    /**
     * Sets user edited.
     *
     * @param userEditedToSet the user edited to set
     */
    public void setUserEdited(final String userEditedToSet) {
        this.userEdited = userEditedToSet;
    }

    /**
     * Gets user edited.
     *
     * @return the user edited
     */
    public String getUserEdited() {
        return userEdited;
    }

    /**
     * Gets new user.
     *
     * @return the new user
     */
    public User getNewUser() {
        return users.get(USER_EDITED);
    }

    /**
     * Sets project.
     *
     * @param projectToSet the project to set
     */
    public void setProject(final Project projectToSet) {
        this.project = projectToSet;
    }

    /**
     * Gets project.
     *
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets story.
     *
     * @param storyToSet the story to set
     */
    public void setStory(final Story storyToSet) {
        this.story = storyToSet;
    }

    /**
     * Gets story.
     *
     * @return the story
     */
    public Story getStory() {
        return story;
    }
}
