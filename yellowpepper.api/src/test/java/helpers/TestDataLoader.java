package helpers;

import java.util.HashMap;
import java.util.Map;

import models.UserModel;
import models.PetModel;
import models.OrderModel;

public class TestDataLoader {

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

    public PetModel createNewTestPet(){
        PetModel testPet = new PetModel();
        Map<String, Object> petTagOne = new HashMap<>();
        Map<String, Object> petTagTwo = new HashMap<>();

        petTagOne.put("id", 1);
        petTagOne.put("name", "tag2");
        petTagTwo.put("id", 2);
        petTagTwo.put("name", "tag3");

        testPet.setId(30);
        testPet.setName("doggo");
        testPet.setStatus("available");
        testPet.setCategoryParameter("id", 1);
        testPet.setCategoryParameter("name", "Dogs");
        testPet.addPhotoUrl("photo1");
        testPet.addPhotoUrl("photo2");
        testPet.addTag(petTagOne);
        testPet.addTag(petTagTwo);

        return testPet;
    }

    public OrderModel createNewTestOrder(){
        OrderModel testOrder = new OrderModel();

        testOrder.setId(4);
        testOrder.setPetId(2);
        testOrder.setQuantity(5);
        testOrder.setShipDate("2021-07-19T14:02:51.036+00:00");
        testOrder.setStatus("placed");
        testOrder.setComplete(true);

        return testOrder;
    }

}