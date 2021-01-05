package pivotal.ui;

import java.util.HashMap;
import java.util.Map;

public final class Permalink {

   /* public static final String LOGIN_PAGE = "signin?source=navbar";
    public static final String LOGIN_PAGE2 = "signin/show_with_password";
    public static final String DASHBOARD_PAGE = "dashboard";
    public static final String PROFILE_PAGE = "profile";*/
    private static Map<String, String> endpointsMap = new HashMap<>();
    static {
        endpointsMap.put("LOGIN_PAGE", "signin?source=navbar");
        endpointsMap.put("LOGIN_PAGE2", "signin/show_with_password");
        endpointsMap.put("DASHBOARD_PAGE", "dashboard");
        endpointsMap.put("PROFILE_PAGE", "profile");
    }

    private Permalink() { }

    /**
     * Gets permanent link.
     *
     * @param urlKey the url key
     * @return the permanent link
     */
    public static String getPermalink(final String urlKey) {
        return endpointsMap.get(urlKey);
    }
}

