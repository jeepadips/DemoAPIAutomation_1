package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class UpdateProfileTest {

    @Test(description = "verifying Update profile API")
    public void updateProfileTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("testing1234", "testing1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println("------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());

        System.out.println(response.asPrettyString());

        System.out.println("---------------");

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        Assert.assertEquals(userProfileResponse.getUsername(),"testing1234");

        System.out.println("-------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("testing123")
                .lastName("testing321")
                .email("testing321@mailinator.com")
                .mobileNumber("1234567890")
                .build();


        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);

        System.out.println(response.asPrettyString());
    }
}
