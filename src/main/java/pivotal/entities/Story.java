package pivotal.entities;

public class Story {

    private String name;
    private String id;

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
    }
}
