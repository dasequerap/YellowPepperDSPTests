package tests;

import io.restassured.response.ValidatableResponse;

public class BaseTests {

    private ValidatableResponse response;

    protected BaseTests() { }

    protected ValidatableResponse getCurrentResponse(){  return this.response; }

    protected void setCurrentResponse(ValidatableResponse response){
        this.response = response;
    }

}
