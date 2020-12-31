package pivotal.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import static pivotal.constants.UserIdentifiers.USER_NAME;
import static pivotal.constants.UserIdentifiers.NAME;
import static pivotal.constants.UserIdentifiers.INITIALS;
import static pivotal.constants.UserIdentifiers.START_PAGE;
import static pivotal.constants.UserIdentifiers.TIME_ZONE;
import static pivotal.constants.UserIdentifiers.DEFAULT_STORY_TYPE;

public class User {

    private String userName;
    private String name;
    private String initials;
    private String startPage;
    private String timeZone;
    private String defaultStoryType;
    private Set<String> userKeys = new HashSet<String>();

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
        String id = Long.toString(new Date().getTime());
        this.userName = userNameToSet.replaceAll("UNIQUE_ID", id);
        userKeys.add(USER_NAME);
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
        userKeys.add(NAME);
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
        userKeys.add(INITIALS);
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
        userKeys.add(START_PAGE);
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
        userKeys.add(TIME_ZONE);
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
        userKeys.add(DEFAULT_STORY_TYPE);
    }

    /**
     * Process information.
     *
     * @param userInformation the user information
     */
    public void processInformation(final Map<String, String> userInformation) {
        final HashMap<String, Runnable> strategyMap = composeMyProfileMap(userInformation);
        userInformation.keySet().forEach(key -> {
            strategyMap.get(key).run(); });
    }

    /**
     * Compose my profile hash map.
     *
     * @param userInformation the user information
     * @return the hash map
     */
    public HashMap<String, Runnable> composeMyProfileMap(final Map<String, String> userInformation) {
        final HashMap<String, Runnable> myProfileMap = new HashMap<>();
        myProfileMap.put(USER_NAME, () -> setName(userInformation.get(USER_NAME)));
        myProfileMap.put(NAME, () -> setName(userInformation.get(NAME)));
        myProfileMap.put(INITIALS, () -> setInitials(userInformation.get(INITIALS)));
        myProfileMap.put(START_PAGE, () -> setStartPage(userInformation.get(START_PAGE)));
        myProfileMap.put(TIME_ZONE, () -> setTimeZone(userInformation.get(TIME_ZONE)));
        myProfileMap.put(DEFAULT_STORY_TYPE, () -> setDefaultStoryType(userInformation.get(DEFAULT_STORY_TYPE)));
        return myProfileMap;
    }
}
