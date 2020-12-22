package pivotal.entities;

public class Project {

    private String projectName;
    private String account;
    private String projectPrivacy;

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets project name.
     *
     * @param projectNameToSet the project name
     */
    public void setProjectName(final String projectNameToSet) {
        this.projectName = projectNameToSet;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets account.
     *
     * @param accountToSet the account
     */
    public void setAccount(final String accountToSet) {
        this.account = accountToSet;
    }

    /**
     * Gets project privacy.
     *
     * @return the project privacy
     */
    public String getProjectPrivacy() {
        return projectPrivacy;
    }

    /**
     * Sets project privacy.
     *
     * @param projectPrivacyToSet the project privacy
     */
    public void setProjectPrivacy(final String projectPrivacyToSet) {
        this.projectPrivacy = projectPrivacyToSet;
    }
}
