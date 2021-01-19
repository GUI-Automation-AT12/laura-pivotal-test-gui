package pivotal.entities;

import java.util.HashSet;
import java.util.Set;

import static pivotal.constants.StoryIdentifiers.STORY_ID;
import static pivotal.constants.StoryIdentifiers.STORY_NAME;

public class Story {

    private String name;
    private String id;
    private Set<String> updatedFields = new HashSet<String>();

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
        updatedFields.add(STORY_NAME);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param idToSet the id
     */
    public void setId(final String idToSet) {
        this.id = idToSet;
        updatedFields.add(STORY_ID);
    }

    public String getAttribute(final String attribute) {
        if (updatedFields.size() > 0) {
            return switch (attribute) {
                case STORY_NAME -> getName();
                case STORY_ID -> getId();
                default -> "";
            };
        }
        return "";
    }
}
