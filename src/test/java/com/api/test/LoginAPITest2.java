package com.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest2 {

    @Test(description= "Verify if login API is working test 2")
    public void loginTest(){
        baseURI="http://64.227.160.186:8080";
// Removed RestAssured. from baseURI and Response by performing static import
//        RequestSpecification x = RestAssured.given();
//        RequestSpecification y = RestAssured.given().header("Content-Type" , "application/json");
//        RequestSpecification z = RestAssured.given().header("Content-Type" , "application/json").body("{ \"username\": \"uday1234\", \"password\": \"uday1234\"}");


        Response response = given().header("Content-Type" , "application/json").
                body("{ \"username\": \"testing1234\", \"password\": \"testing1234\"}").
                post("/api/auth/login");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 2112);
    }
}
