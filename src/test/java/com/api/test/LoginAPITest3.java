package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest3 {

    @Test(description = "Verify if Login is Working test 3")
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("testing1234", "testing1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);

       LoginResponse loginResponse= response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());

        System.out.println("Token is " +loginResponse.getToken());
        System.out.println("Email is " +loginResponse.getEmail());
        System.out.println("ID is " +loginResponse.getId());

        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(), "testing321@mailinator.com");
        Assert.assertEquals(loginResponse.getId(),819);

        System.out.println(loginResponse.toString());


    }
}
