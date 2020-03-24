package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class TestEndpointDefinition {
    private Response response;

    @Given("^I want to execute users endpoint")
    public void makeBaseEndpointUrl() {
        RestAssured.baseURI = "http://0.0.0.0:5000";
    }

    @When("^I submit GET request as (\\D+) from (\\d+) company to get info about (\\D+) user from (\\d+) company")
    public void submitGetRequests(String userName, String companyId, String requredUserName, String requredCompanyId) {
        String token = companyId + "_" + userName;
        String path = "/company/" + requredCompanyId + "/users" +
                "?name=" + requredUserName;

        RequestSpecification httpRequest = given();
        httpRequest.cookie("whoami_token", token);
        response = httpRequest.request(Method.GET, path);
    }

    @Then("^I should get Status code is (\\d+)")
    public void verifyStatusCode(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode);
    }
}