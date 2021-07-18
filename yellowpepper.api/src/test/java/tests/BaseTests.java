package tests;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import models.UserModel;

import static org.hamcrest.Matchers.equalTo;

public class BaseTests {

    private ValidatableResponse response;

    protected BaseTests() { }

    protected ValidatableResponse getCurrentResponse(){  return this.response; }

    protected void setCurrentResponse(ValidatableResponse response){
        this.response = response;
    }

    protected void validateReturnedUserData(UserModel user){
        this.getCurrentResponse().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(user.getId()))
                .body("username", equalTo(user.getUserName()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("email", equalTo(user.getEmail()))
                .body("password", equalTo(user.getPassword()))
                .body("phone", equalTo(user.getPhone()))
                .body("userStatus", equalTo(user.getUserStatus()));
    }

}
