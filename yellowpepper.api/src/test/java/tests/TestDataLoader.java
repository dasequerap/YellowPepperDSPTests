package tests;

import models.UserModel;

class TestDataLoader {

    public TestDataLoader(){}

    public UserModel createNewTestUser(){
        UserModel testUser = new UserModel();
        testUser.setId(1);
        testUser.setUserName("testUser");
        testUser.setFirstName("John");
        testUser.setLastName("Doe");
        testUser.setEmail("john@email.com");
        testUser.setPassword("12345");
        testUser.setPhone("12345");
        testUser.setUserStatus(1);
        return testUser;
    }

}