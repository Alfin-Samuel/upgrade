package apitest;

import api.endpointfunctionalities.LoginFunctionality;
import api.utilities.ValidationHelpers;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uitest.OfferPageTest;

import java.io.IOException;
import java.util.logging.Logger;

@Listeners(ui.framework.Listeners.class)
public class TestLoginApi {
    ValidationHelpers validationHelpers = new ValidationHelpers();
    LoginFunctionality loginFunctionality = new LoginFunctionality();
    OfferPageTest offerPageTest = new OfferPageTest();
    String newUser;
    WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TestLoginApi.class));

    public TestLoginApi() throws IOException {
        driver = offerPageTest.getDriver();
    }

    @BeforeClass(alwaysRun = true)
    public String createNewUser() throws InterruptedException {
        try {
            newUser = offerPageTest.emailOfNewlyCreatedUser();
            LOGGER.info(String.format("User Name ----> %s",newUser));
            return newUser;
        }
        catch (RuntimeException e) {
            LOGGER.warning("New User Creation Failed");
            throw e;
        }
    }

    @Test(groups = {"regression"})
    public void verifyValidLoginTest() {
        Response response = loginFunctionality.sendLoginRequest(newUser, true);
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

    @AfterTest(alwaysRun = true)
    public void closeDriver(){
        driver.close();
    }
}
