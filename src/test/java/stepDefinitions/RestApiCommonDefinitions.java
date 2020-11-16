package stepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestApiCommonDefinitions {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_USERLIST = "https://reqres.in/api/users";

    @Given("User executes getUsersList endPoint")
    public void user_executes_userlist_endpoint() throws Throwable {
        request = given().param("page", "2");
    }

    @Given("User submits GET request")
    public void user_submits_request() throws Throwable {
        response = request.when().get(ENDPOINT_GET_USERLIST);
        System.out.println("response: " + response.prettyPrint());
    }

    @Given("Success status code to be {int}")
    public void status_code_200(int statusCode) throws Throwable {
        json = response.then().statusCode(statusCode);

    }

}
