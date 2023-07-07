package com.java.framework.api.restassured.Test;

import com.java.framework.api.restassured.ResponseValidator;
import com.java.framework.api.restassured.RestAPIRequest;
import com.java.framework.api.restassured.RestApIResponse;
import com.java.framework.api.restassured.HttpMethod;
import org.apache.http.HttpException;
import org.junit.Test;
import org.testng.Assert;

import java.net.URISyntaxException;

public class tests {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";
    @Test
    public void
    getTest() throws HttpException, URISyntaxException {
        RestAPIRequest.createRequest("https://dog.ceo/api/").basePath("breeds/image/random");
        RestApIResponse.sendRequest(HttpMethod.GET);
        // Write Asset here as people may want to choose different Assert like testng/junit/AssertJ/Hamcrest
        Assert.assertEquals(ResponseValidator.validateBaseURI("https://dog.ceo/api/"),true) ;
        Assert.assertEquals(ResponseValidator.validateProtocolVersion("HTTP/1.1"),true);
        Assert.assertEquals(ResponseValidator.validateStatusLine("HTTP/1.1 200 OK"),true);
        Assert.assertEquals(ResponseValidator.validateReasonPhrase("OK"),true);
    }

    @Test
    public void postTestWithJsonObjectBody()
    {
        RestAPIRequest.createRequest("https://jsonplaceholder.typicode.com")
                .basePath("/post")
                .body(requestBody);
        RestApIResponse.sendRequest(HttpMethod.POST);
        Assert.assertEquals(201, RestApIResponse.getResponse().statusCode());
        Assert.assertEquals("foo", RestApIResponse.getResponse().jsonPath().getString("title"));
        Assert.assertEquals("bar", RestApIResponse.getResponse().jsonPath().getString("body"));
        Assert.assertEquals("1", RestApIResponse.getResponse().jsonPath().getString("userId"));
        Assert.assertEquals("101", RestApIResponse.getResponse().jsonPath().getString("id"));


    }




}

