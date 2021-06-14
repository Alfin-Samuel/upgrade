package uitest;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ui.framework.TestBase;
import ui.pages.*;
import ui.utilities.LoanApprovalDetails;

import java.io.IOException;

import static api.endpointfunctionalities.LoginFunctionality.DEFAULT_PASSWORD;

@Listeners(ui.framework.Listeners.class)
public class OfferPageTest extends TestBase {
    public StartPage startPage;
    public PersonalPage personalPage;
    public IncomePage incomePage;
    public CredentialsPage credentialsPage;
    public OfferPage offerPage;
    public LoginPage loginPage;
    public String environment;
    public String loginPageUrl;
    public static final String LOGIN_ENDPOINT = "/portal/login";
    public static final String DEFAULT_ENVIRONMENT = "https://www.credify.tech";

    public  OfferPageTest() throws IOException {
        openURL("chrome");
        startPage = new StartPage(getDriver());
        personalPage = new PersonalPage(getDriver());
        incomePage = new IncomePage(getDriver());
        credentialsPage = new CredentialsPage(getDriver());
        offerPage = new OfferPage(getDriver());
        loginPage = new LoginPage(getDriver());
        environment = System.getProperty("ENV", DEFAULT_ENVIRONMENT);
        loginPageUrl = String.format("%s%s", environment,LOGIN_ENDPOINT);
    }

    @Test(groups = {"regression"})
    public void openBrowserTest() throws InterruptedException {

        String email = emailOfNewlyCreatedUser();
        LoanApprovalDetails approvedDetails = offerPage.captureLoanApprovalDetails();
        driver.navigate().to(loginPageUrl);
        loginPage.loginToAccout(email, DEFAULT_PASSWORD);
        LoanApprovalDetails approvedDetailsAfterLogin = offerPage.captureLoanApprovalDetails();
        validateValuesBeforeAndAfterLogin(approvedDetails, approvedDetailsAfterLogin);
    }

    public String emailOfNewlyCreatedUser() throws InterruptedException {
        startPage.checkRateAfterEnteringValues("2000", "Debt Consolidation");
        personalPage.fillPersonalDetails();
        incomePage.enterIncomeDetails();
        String email = credentialsPage.fillCredentials();
        return email;
    }

    public void validateValuesBeforeAndAfterLogin(LoanApprovalDetails before, LoanApprovalDetails after) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(before.getLoanAmount(), after.getLoanAmount());
        softAssert.assertEquals(before.getMonthlyPayment(), after.getMonthlyPayment());
        softAssert.assertEquals(before.getIntrestRate(), after.getIntrestRate());
        softAssert.assertEquals(before.getTerm(), after.getTerm());
        softAssert.assertEquals(before.getApr(), after.getApr());
        softAssert.assertAll();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}
