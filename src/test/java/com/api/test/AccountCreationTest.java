package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class AccountCreationTest {

    @Test(description = "Verify if new Account creation is working as expected")

    public void createAccount(){

       SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("Dishaa584").
                email("dishaa584@yahoo.com").
                firstName("Dishaa")
                .lastName("Bhatt")
                .password("dishaa123")
                .mobileNumber("9022374389").build();

        AuthService authService = new AuthService();
       Response response =  authService.signUp(signUpRequest);


        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(), "Error: Username is already taken!");

    }
}
