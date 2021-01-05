package core.utils;

import java.util.Date;

public final class IdGenerator {
    public static String getUniqueId() {
        return Long.toString(new Date().getTime());
    }
}
