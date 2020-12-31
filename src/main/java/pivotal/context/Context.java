package pivotal.context;

import pivotal.entities.Project;
import pivotal.entities.User;

public class Context {

    private User user;
    private Project project;


    /**
     * Instantiates a new Context.
     */
    public Context() {
        this.user = new User();
        this.project = new Project();
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param userToSet the user to set
     */
    public void setUser(final User userToSet) {
        this.user = userToSet;
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
     * Sets project.
     *
     * @param projectToSet the project to set
     */
    public void setProject(final Project projectToSet) {
        this.project = projectToSet;
    }
}
