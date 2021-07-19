package tests;

import io.restassured.response.ValidatableResponse;
import models.PetModel;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.equalTo;

import models.UserModel;


public class BaseTests {

    final String webServiceURI = "http://localhost:8080/api/v3/";
    private ValidatableResponse response;
    static TestDataLoader testDataLoader;

    BaseTests() { }

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

    protected void validateReturnedPetData(PetModel pet){
        this.getCurrentResponse()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(pet.getId()))
                .body("category", equalTo(pet.getCategory()))
                .body("name", equalTo(pet.getName()))
                .body("photoUrls", equalTo(pet.getPhotoUrls()))
                .body("tags", equalTo(pet.getTags()))
                .body("status", equalTo(pet.getStatus()));

    }

    protected void validateMultipleObjectsInResponse(int expectedResultNumber) {
        this.getCurrentResponse()
                .statusCode(HttpStatus.SC_OK)
                .body("data.size()", equalTo(expectedResultNumber));
    }

}
