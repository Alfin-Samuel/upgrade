package api.utilities;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import api.requestbody.UserCredentials;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiHelpers {

    public List<Header> headersForRequest() {
        Header h1= new Header("x-cf-source-id", "coding-challenge");
        Header h2 = new Header("x-cf-corr-id", "bb24bb2a-c74e-11eb-b8bc-0242ac130003");
        Header h3 = new Header("Content-Type", "application/json");
        List<Header> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        return list;
    }

    public Response postJsonRequest(String url, UserCredentials user, Boolean isHeaderPresent) {
        Headers header = new Headers(headersForRequest());
        Response response = given()
                .headers((isHeaderPresent) ? header : new Headers())
                .log().body()
                .log().headers()
                .body(user)
                .contentType("application/json")
                .when()
                .post(url);
        return response;
    }


}
