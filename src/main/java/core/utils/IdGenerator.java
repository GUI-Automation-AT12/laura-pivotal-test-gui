package core.utils;

import java.util.Date;

public final class IdGenerator {

    /**
     * Gets unique id.
     *
     * @return the unique id
     */
    public static String getUniqueId() {
        return Long.toString(new Date().getTime());
    }
}
