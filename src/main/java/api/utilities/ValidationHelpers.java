package api.utilities;

import api.responsebody.FullLoanDetails;
import api.responsebody.UnauthorizedResponse;
import io.restassured.response.Response;
import org.testng.Assert;


import java.util.logging.Logger;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidationHelpers {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ValidationHelpers.class));


    public void validateStatusCode(Response response, int expectedStatusCode) {
        response.then()
                .statusCode(expectedStatusCode);
        LOGGER.info("<======Response======>");
        LOGGER.info(response.then().extract().body().asPrettyString());

    }

    public void validateProductTypeInResponse(Response response, String expectedProductType) {
        FullLoanDetails loanDetails = response.then()
                .extract()
                .body()
                .as(FullLoanDetails.class);
        Assert.assertEquals(loanDetails.getLoanApplications().get(0).getProductType(),expectedProductType);
    }

    public void validateResponseBodyOfUnauthorized(Response response) {
        UnauthorizedResponse unauthorizedResponse = response.then()
                .extract()
                .body()
                .as(UnauthorizedResponse.class);
        Assert.assertEquals(unauthorizedResponse.getCodeName(),"INVALID_CREDENTIALS");
        Assert.assertEquals(unauthorizedResponse.getHttpStatus(), "UNAUTHORIZED");
    }

    public void validateLoanResponseInExpectedFormat(Response response) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath("LoanResponseFormat.json"));
    }

    public void validateUnauthorizedResponseInExpectedFormat(Response response) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath("UnauthorizedFormat.json"));
    }

}
