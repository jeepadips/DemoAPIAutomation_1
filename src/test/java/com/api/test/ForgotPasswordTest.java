package com.api.test;

import com.api.base.AuthService;
import com.api.models.response.ForgotPasswordResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class ForgotPasswordTest {

    @Test(description = "Verify if Forgot Password API is working")

    public void forgotPassword(){


        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("testing12334@mailinator.com");
        ForgotPasswordResponse forgotPasswordResponse = response.as(ForgotPasswordResponse.class);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(forgotPasswordResponse.getMessage(), "If your email exists in our system, you will receive reset instructions.");
    }
}
