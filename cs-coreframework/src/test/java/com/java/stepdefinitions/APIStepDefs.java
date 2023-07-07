package com.java.stepdefinitions;

import com.java.framework.api.httpclient.HttpMethod;
import com.java.framework.api.httpclient.RestAPIRequest;
import com.java.framework.api.httpclient.RestAPIResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class APIStepDefs {

        @Given("^user navigates to the covid19 india application url$")
        public void userNavigates() throws IOException {
            RestAPIRequest.createRequest("https://jsonplaceholder.typicode.com/users", HttpMethod.GET);
           // RestAPIResponse.sendRequest();
        }

    @When("user calls get request API for covid19 data successfully")
    public void userCallsGetRequestAPIForCovidDataSuccessfully() {
        Assert.assertEquals("200",RestAPIResponse.getResponse().getStatusLine().getStatusCode());
    }

    @Then("user validates the top state data from UI to API")
    public void userValidatesTheTopStateDataFromUIToAPI() {

    }

    @And("user clicks on first state displayed in table")
    public void userClicksOnFirstStateDisplayedInTable() {
    }

    @When("user clicks on See More option")
    public void userClicksOnSeeMoreOption() {
    }

    @And("user calls get request API for covid{int} district data successfully")
    public void userCallsGetRequestAPIForCovidDistrictDataSuccessfully(int arg0) {
    }

    @Then("correct data from districts API is mapped with districts data in UI")
    public void correctDataFromDistrictsAPIIsMappedWithDistrictsDataInUI() {
    }
}
