package apitest;

import api.endpointfunctionalities.LoginFunctionality;
import api.utilities.ValidationHelpers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestLoginApi {
    ValidationHelpers validationHelpers = new ValidationHelpers();
    LoginFunctionality loginFunctionality = new LoginFunctionality();


    @Test(groups = {"regression"})
    public void verifyValidLoginTest() {
        Response response = loginFunctionality.sendLoginRequest(LoginFunctionality.DEFAULT_USERNAME, true);
        validationHelpers.validateStatusCode(response, 200);
        validationHelpers.validateLoanResponseInExpectedFormat(response);
        validationHelpers.validateProductTypeInResponse(response, "PERSONAL_LOAN");
    }

    @Test(groups = {"regression"})
    public void verifyUnauthorisedLogin() {
        Response response = loginFunctionality.sendLoginRequest("invalid", true);
        validationHelpers.validateStatusCode(response, 401);
        validationHelpers.validateResponseBodyOfUnauthorized(response);
        validationHelpers.validateUnauthorizedResponseInExpectedFormat(response);
    }

    @Test(groups = {"regression"})
    public void verifyInternalServerError() {
        Response response = loginFunctionality.sendLoginRequest("invalid", false);
        validationHelpers.validateStatusCode(response, 500);
    }
}
