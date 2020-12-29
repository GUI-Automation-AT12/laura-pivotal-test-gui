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
     * @param user the user
     */
    public void setUser(final User user) {
        this.user = user;
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
     * @param project the project
     */
    public void setProject(final Project project) {
        this.project = project;
    }
}
