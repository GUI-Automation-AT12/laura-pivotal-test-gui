package pivotal.entities;

import core.utils.IdGenerator;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

import static pivotal.constants.UserIdentifiers.USER_NAME;
import static pivotal.constants.UserIdentifiers.NAME;
import static pivotal.constants.UserIdentifiers.INITIALS;

public class User {

    private String userName;
    private String name;
    private String initials;
    private String startPage;
    private String timeZone;
    private String defaultStoryType;
    private Set<String> updatedFields = new HashSet<String>();
    private static final String ID = "UNIQUE_ID";

    /**
     * Process information.
     *
     * @param userInformation the user information
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeMyProfileMap(userInformation);
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
        HashMap<String, Runnable> myProfileMap = new HashMap<>();
        myProfileMap.put(USER_NAME, () -> setUserName(userInformation.get(USER_NAME)));
        myProfileMap.put(NAME, () -> setName(userInformation.get(NAME)));
        myProfileMap.put(INITIALS, () -> setInitials(userInformation.get(INITIALS)));
        return myProfileMap;
    }

    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put(USER_NAME, () -> getUserName());
        strategyMap.put(NAME, () -> getName());
        strategyMap.put(INITIALS, () -> getInitials());
        return strategyMap;
    }

    /**
     * Gets user info.
     *
     * @return the user info
     */
    public Map<String, String> getUserInfo() {
        Map<String, String> userInfoMap = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetterMap();
        updatedFields.forEach(field -> userInfoMap.put(field, strategyMap.get(field).get()));
        return userInfoMap;
    }

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
        this.userName = userNameToSet.replaceAll(ID, IdGenerator.getUniqueId());
        updatedFields.add(USER_NAME);
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
        this.name = nameToSet.replaceAll(ID, IdGenerator.getUniqueId());
        updatedFields.add(NAME);
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
        updatedFields.add(INITIALS);
    }

    /**
     * Gets updated fields.
     *
     * @return the updated fields
     */
    public Set<String> getUpdatedFields() {
        return updatedFields;
    }
}
