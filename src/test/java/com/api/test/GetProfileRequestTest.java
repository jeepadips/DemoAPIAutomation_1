package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class GetProfileRequestTest {

    @Test(description = "verifying Get Profile API")
    public void getProfileInfoTest(){

        AuthService authService = new AuthService();
        Response response =authService.login(new LoginRequest("testing1234", "testing1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println("Token is "+ loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

        response = userProfileManagementService.getProfile(loginResponse.getToken());

        System.out.println(response.asPrettyString());

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        System.out.println("UserName is "+ userProfileResponse.getUsername());
    }
}
