package pivotal.entities;

public class User {

    private String userName;
    private String name;
    private String initials;
    private String email;
    private String password;
    private String startPage;
    private String timeZone;
    private String defaultStoryType;

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userNameToSet the user name
     */
    public void setUserName(final String userNameToSet) {
        this.userName = userNameToSet;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param nameToSet the name
     */
    public void setName(final String nameToSet) {
        this.name = nameToSet;
    }

    /**
     * Gets initials.
     *
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * Sets initials.
     *
     * @param initialsToSet the initials
     */
    public void setInitials(final String initialsToSet) {
        this.initials = initialsToSet;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param emailToSet the email
     */
    public void setEmail(final String emailToSet) {
        this.email = emailToSet;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param passwordToSet the password
     */
    public void setPassword(final String passwordToSet) {
        this.password = passwordToSet;
    }

    /**
     * Gets start page.
     *
     * @return the start page
     */
    public String getStartPage() {
        return startPage;
    }

    /**
     * Sets start page.
     *
     * @param startPageToSet the start page
     */
    public void setStartPage(final String startPageToSet) {
        this.startPage = startPageToSet;
    }

    /**
     * Gets time zone.
     *
     * @return the time zone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets time zone.
     *
     * @param timeZoneToSet the time zone
     */
    public void setTimeZone(final String timeZoneToSet) {
        this.timeZone = timeZoneToSet;
    }

    /**
     * Gets default story type.
     *
     * @return the default story type
     */
    public String getDefaultStoryType() {
        return defaultStoryType;
    }

    /**
     * Sets default story type.
     *
     * @param defaultStoryTypeToSet the default story type
     */
    public void setDefaultStoryType(final String defaultStoryTypeToSet) {
        this.defaultStoryType = defaultStoryTypeToSet;
    }
}
