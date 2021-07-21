package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
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
        testOrder.setQuantity(10);
        testOrder.setShipDate("2021-07-19T14:02:51.036+00:00");
        testOrder.setStatus("approved");
        testOrder.setComplete(true);

        return testOrder;
    }

    public  List<List<String>> getOrdersFromTestData() throws CsvValidationException, IOException {
        String ordersTestData = "src/test/resources/orders.csv";
        return readCSVFile(ordersTestData);
    }

    public Map<String, Object> getInventory(int orderEntries) throws CsvValidationException, IOException {
        Map<String, Object> inventory = new HashMap<>();
        List<List<String>> testDataOrders = this.getOrdersFromTestData();
        int tempCount;

        for(int index = 0; index < orderEntries; index++) {
            if(inventory.get(testDataOrders.get(index).get(4)) != null){
                tempCount = Integer.parseInt(testDataOrders.get(index).get(2))
                        + Integer.parseInt((String) inventory.get(testDataOrders.get(index).get(4)));
                inventory.remove(testDataOrders.get(index).get(4));
                inventory.put(testDataOrders.get(index).get(4), Integer.toString(tempCount));
            } else {
                inventory.put(testDataOrders.get(index).get(4), testDataOrders.get(index).get(2));
            }
        }
        return inventory;
    }

    private List<List<String>> readCSVFile(String csvFile) throws IOException, CsvValidationException {
        CSVReader csvTestData = new CSVReader(new FileReader(csvFile));
        List<List<String>> entries = new ArrayList<>();
        String[] line;
        csvTestData.readNext();

        while((line = csvTestData.readNext()) != null){ entries.add(Arrays.asList(line)); }
        return entries;
    }
}