package pivotal.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import static pivotal.constants.ProjectIdentifiers.PROJECT_NAME;
import static pivotal.constants.ProjectIdentifiers.PROJECT_PRIVACY;
import static pivotal.constants.ProjectIdentifiers.ACCOUNT;

public class Project {

    private String projectName;
    private String account;
    private String projectPrivacy;
    private Set<String> projectKeys = new HashSet<String>();

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
        String id = Long.toString(new Date().getTime());
        this.projectName = projectNameToSet.replaceAll("UNIQUE_ID", id);
        projectKeys.add(PROJECT_NAME);
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
        projectKeys.add(ACCOUNT);
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
        projectKeys.add(PROJECT_PRIVACY);
    }

    /**
     * Process information.
     *
     * @param projectInformation the project information
     */
    public void processInformation(final Map<String, String> projectInformation) {
        final HashMap<String, Runnable> strategyMap = composeStrategyMap(projectInformation);
        projectInformation.keySet().forEach(key -> {
            strategyMap.get(key).run(); });
    }

    /**
     * Compose strategy hash map.
     *
     * @param projectInformation the project information
     * @return the hash map
     */
    public HashMap<String, Runnable> composeStrategyMap(final Map<String, String> projectInformation) {
        final HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(PROJECT_NAME, () -> setProjectName(projectInformation.get(PROJECT_NAME)));
        strategyMap.put(ACCOUNT, () -> setAccount(projectInformation.get(ACCOUNT)));
        strategyMap.put(PROJECT_PRIVACY, () -> setProjectPrivacy(projectInformation.get(PROJECT_PRIVACY)));
        return strategyMap;
    }
}
