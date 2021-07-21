package tests;

import helpers.TestDataLoader;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;

import models.UserModel;
import models.PetModel;
import models.OrderModel;

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
        this.getCurrentResponse().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(pet.getId()))
                .body("category", equalTo(pet.getCategory()))
                .body("name", equalTo(pet.getName()))
                .body("photoUrls", equalTo(pet.getPhotoUrls()))
                .body("tags", equalTo(pet.getTags()))
                .body("status", equalTo(pet.getStatus()));

    }

    protected void validateReturnedOrderData(OrderModel order){
        this.getCurrentResponse().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(order.getId()))
                .body("petId", equalTo(order.getPetId()))
                .body("quantity", equalTo(order.getQuantity()))
                .body("shipDate", equalTo(order.getShipDate()))
                .body("status", equalTo(order.getStatus()))
                .body("complete", equalTo(order.getComplete()));
    }

    protected void validateInventory(Map<String, Object> inventory){
        this.getCurrentResponse()
                .statusCode(HttpStatus.SC_OK)
                .body("approved", equalTo(Integer.parseInt((String) inventory.get("approved"))))
                .body("placed", equalTo(Integer.parseInt((String) inventory.get("placed"))))
                .body("delivered", equalTo(Integer.parseInt((String) inventory.get("delivered"))));
    }

    protected void validateMultipleObjectsInResponse(int expectedResultNumber) {
        this.getCurrentResponse()
                .statusCode(HttpStatus.SC_OK)
                .body("data.size()", equalTo(expectedResultNumber));
    }

}
