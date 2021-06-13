package api.endpointfunctionalities;

import io.restassured.response.Response;
import api.requestbody.UserCredentials;
import api.utilities.ApiHelpers;

public class LoginFunctionality {

    ApiHelpers apiHelpers = new ApiHelpers();
    public static final String DEFAULT_USERNAME = "abc123@upgrade-challenge.com";
    public static final String DEFAULT_PASSWORD = "123Password";

    public Response sendLoginRequest(String userName, Boolean isHeaderPresent) {
        UserCredentials user = newUserCredentials(userName);
        Response response = apiHelpers.postJsonRequest("https://credapi.credify.tech/api/brportorch/v2/login", user, isHeaderPresent);
        return response;
    }

    public UserCredentials newUserCredentials(String userName) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(userName);
        userCredentials.setPassword(DEFAULT_PASSWORD);
        userCredentials.setRecaptchaToken("coding_challenge");
        return userCredentials;
    }
}
