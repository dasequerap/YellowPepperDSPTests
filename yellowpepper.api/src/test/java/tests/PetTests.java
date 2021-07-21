package tests;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import helpers.TestDataLoader;

import models.PetModel;
import views.PetView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTests extends BaseTests {

    private static PetModel testPet;
    private static PetView petView;
    private final int defaultPetQuantity = 8;

    public PetTests() {
        super();
        petView = new PetView(super.webServiceURI);
    }

    @BeforeAll
    public static void setUp(){
        testDataLoader = new TestDataLoader();
        testPet = testDataLoader.createNewTestPet();
    }

    @Order(1)
    @Test
    @DisplayName("GIVEN user has data to create a new pet WHEN user requests new pet creation THEN a new pet is created on the system")
    public void createNewPet(){
        this.setCurrentResponse(petView.createPet(testPet));
        this.validateReturnedPetData(testPet);
    }

    @Order(2)
    @Test
    @DisplayName("GIVEN user has an id of an existing pet WHEN user queries for a pet THEN system returns information of an existing pet")
    public void getPetById(){
        this.setCurrentResponse(petView.getPetById(testPet.getId()));
        this.validateReturnedPetData(testPet);
    }

    @Order(3)
    @Test
    @DisplayName("GIVEN user has an id of a pet that does not exists WHEN user queries for a pet creation THEN system return not found")
    public void getNotExistentPetById(){
        this.setCurrentResponse(petView.getPetById(100));
        this.validateResponseMessage("Pet not found", HttpStatus.SC_NOT_FOUND);
    }

    @Order(4)
    @Test
    @DisplayName("GIVEN user a valid status of a pet WHEN user queries pets by status THEN system returns all pets that has given status")
    public void getPetsByValidStatus(){
        this.setCurrentResponse(petView.getPetsByStatus(testPet.getStatus()));
        this.validateMultipleObjectsInResponse(defaultPetQuantity);
    }

    @Order(5)
    @Test
    @DisplayName("GIVEN user has data to modify pet data WHEN user requests pet data modification THEN pet data is modified")
    public void createNewUser() {
        this.setCurrentResponse(petView.updatePet(testPet));
    }
}