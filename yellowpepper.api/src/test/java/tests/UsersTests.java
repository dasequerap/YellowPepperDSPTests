package tests;

import helpers.TestDataLoader;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import models.UserModel;
import views.UserView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersTests extends BaseTests {

    private static UserView usersView;
    private static UserModel testUser;

    public UsersTests() {
        super();
        usersView = new UserView(super.webServiceURI);
    }

    @BeforeAll
    public static void setUp(){
        testDataLoader = new TestDataLoader();
        testUser = testDataLoader.createNewTestUser();
    }

    @Order(1)
    @Test
    @DisplayName("GIVEN user has data to create a new user WHEN user requests new user creation THEN user is created on the system")
    public void createNewUser(){
        this.setCurrentResponse(usersView.createUser(testUser));
        this.validateReturnedUserData(testUser);
    }


    @Order(2)
    @Test
    @DisplayName("GIVEN user id WHEN user requests user information THEN system return user information by its id")
    public void getAnExistingUserByItsId(){
        this.setCurrentResponse(usersView.getUserByUsername(testUser.getUserName()));
        this.validateReturnedUserData(testUser);
    }

    @Order(3)
    @Test
    @DisplayName("GIVEN user has correct username and password WHEN user log in THEN system logs in user successfully")
    public void logInUserWithProperCredentials(){
        this.setCurrentResponse(usersView.login(testUser));
        this.validateSuccessfulResponseContainsMessage("Logged in user session:");
    }

    @Order(4)
    @Test
    @DisplayName("GIVEN user has logged in WHEN user logs out THEN system finishes user session")
    public void logoutUser(){
        this.setCurrentResponse(usersView.logout());
        this.validateResponseMessage("User logged out", HttpStatus.SC_OK);
    }
}