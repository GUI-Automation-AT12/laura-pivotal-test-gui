package pivotal.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import pivotal.config.Environment;

public final class AuthenticationUtils {

    private static final String TOKEN_HEADER = "X-TrackerToken";
    private static final String BASE_URL_API = "https://www.pivotaltracker.com/services/v5";
    private static RequestSpecification requestSpecification;

    /**
     * Constructor for AuthenticationUtils.
     */
    private AuthenticationUtils() {

    }

    /**
     * Getter to request specifications with
     * Token of user and the BaseURI of API which is loaded
     * from properties file.
     *
     * @return requestSpecification
     */
    public static RequestSpecification getLoggedReqSpec() {
        RestAssured.baseURI = BASE_URL_API;
        requestSpecification = new RequestSpecBuilder()
            .setRelaxedHTTPSValidation()
            .addHeader(TOKEN_HEADER, Environment.getInstance().getProperties().get("token"))
            .addHeader("Content-Type", "application/json")
            .build();
        return requestSpecification;
    }

    /**
     * Getter to request specifications with
     * Token of user and the BaseURI of API which is loaded
     * from properties file.
     *
     * @return requestSpecification
     */
    public static RequestSpecification getLoggedReqSpecWithoutContentType() {
        RestAssured.baseURI = BASE_URL_API;
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader(TOKEN_HEADER, Environment.getInstance().getProperties().get("token"))
                .build();
        return requestSpecification;
    }

    /**
     * Getter to request specifications.
     *
     * @return requestSpecification
     */
    public static RequestSpecification getNotLoggedReqSpec() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URL_API);
        return requestSpecification;
    }
}
