package pivotal.ui;

import java.util.HashMap;
import java.util.Map;

public final class Permalink {

    public static final String LOGIN_PAGE = "signin?source=navbar";
    public static final String LOGIN_PAGE2 = "signin/show_with_password";
    public static final String DASHBOARD_PAGE = "dashboard";
    public static final String PROFILE_PAGE = "profile";
    private static Map<String, String> endpointsMap = new HashMap<>();
    static {
        endpointsMap.put("LOGIN_PAGE", LOGIN_PAGE);
        endpointsMap.put("LOGIN_PAGE2", LOGIN_PAGE2);
        endpointsMap.put("DASHBOARD_PAGE", DASHBOARD_PAGE);
        endpointsMap.put("PROFILE_PAGE", PROFILE_PAGE);
    }
    /**
     * Constructor private.
     */
    private Permalink() { }

    /**
     * Gets of course map.
     *
     * @param urlKey of type string.
     * @return value of map.
     */
    public static String getPermalink(final String urlKey) {
        return endpointsMap.get(urlKey);
    }
}

