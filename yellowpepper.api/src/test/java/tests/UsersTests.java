package tests;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

import models.UserModel;
import views.UserView;

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
        this.validateReturnedUserData(testUser);
    }


    @Order(2)
    @Test
    @DisplayName("GIVEN user id WHEN user requests user information THEN system return user information by its id")
    void getAnExistingUserByItsId(){
        this.setCurrentResponse(usersView.getUserByUsername("testUser"));
        this.validateReturnedUserData(testUser);
    }

    @Order(3)
    @Test
    @DisplayName("GIVEN user has correct username and password WHEN user log in THEN system logs in user successfully")
    void logInUserWithProperCredentials(){
        this.setCurrentResponse(usersView.login(testUser));
        this.getCurrentResponse().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().asString().equals("Logged in user session:");
    }

    @Order(4)
    @Test
    @DisplayName("GIVEN user has logged in WHEN user logs out THEN system finishes user session")
    void logoutUser(){
        this.setCurrentResponse(usersView.logout());
        this.getCurrentResponse().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().asString().equals("User logged out");
    }
}