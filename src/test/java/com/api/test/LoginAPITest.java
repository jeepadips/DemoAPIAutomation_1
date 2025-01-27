package com.api.test;

import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

    @Test(description= "Verify if login API is working test1")
    public void loginTest(){
        RestAssured.baseURI="http://64.227.160.186:8080";

        RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type" , "application/json");
        RequestSpecification z = y.body("{ \"username\": \"testing1234\", \"password\": \"testing1234\"}");


        Response response = z.post("/api/auth/login");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 2112);
    }
}
