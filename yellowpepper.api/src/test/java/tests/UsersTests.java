package tests;

import org.junit.BeforeClass;
import views.UserView;
import org.junit.jupiter.api.*;
import java.io.IOException;

import tests.TestDataLoader;
import models.UserModel;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersTests extends BaseTests {

    private final String _webServiceURI = "http://localhost:8080/api/v3/";
    private static UserView usersView;
    private static TestDataLoader testDataLoader;
    private static UserModel testUser;

    UsersTests() throws IOException {
        usersView = new UserView(this._webServiceURI);
    }

    @BeforeAll
    static void setUp(){
        testDataLoader = new TestDataLoader();
        testUser = testDataLoader.createNewTestUser();
    }

    @Order(1)
    @Test
    @DisplayName("GIVEN user has data to create a new user WHEN user requests new user creation THEN user is created on the system")
    void createNewUser(){
        this.setCurrentResponse(usersView.createUser(testUser));
        this.getCurrentResponse().statusCode(200);
    }


    @Order(2)
    @Test
    @DisplayName("GIVEN user id WHEN user requests user information THEN system return user information by its id")
    void getAnExistingUserByItsId(){
        this.setCurrentResponse(usersView.getUserByUsername("testUser"));
        this.getCurrentResponse().statusCode(200);
        System.out.println("Result:" + this.getCurrentResponse().extract().path("email"));
    }
}