package tests;

import com.opencsv.exceptions.CsvValidationException;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import helpers.TestDataLoader;

import models.OrderModel;
import views.OrderView;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTests extends BaseTests{
    private static OrderView orderView;
    private static OrderModel testOrder;

    StoreTests() {
        super();
        orderView = new OrderView(super.webServiceURI);
    }

    @BeforeAll
    static void setUp(){
        testDataLoader = new TestDataLoader();
        testOrder = testDataLoader.createNewTestOrder();
    }

    @Order(1)
    @Test
    @DisplayName("GIVEN inventory information WHEN user requests current inventory THEN system shows inventory")
    void getCurrentInventory() throws CsvValidationException, IOException {
        this.setCurrentResponse(orderView.getCurrentInventory());
        this.validateInventory(testDataLoader.getInventory(3));
    }

    @Order(2)
    @Test
    @DisplayName("GIVEN user has data place a new order WHEN user place a new order THEN a new order is placed on the system")
    void createNewOrder(){
        this.setCurrentResponse(orderView.createOrder(testOrder));
        this.validateReturnedOrderData(testOrder);
    }

    @Order(3)
    @Test
    @DisplayName("GIVEN user an id of a placed order WHEN user requests the order information by its id THEN system returns information of placed order")
    void getPlacedOrder(){
        this.setCurrentResponse(orderView.getOrderById(testOrder.getId()));
        this.validateReturnedOrderData(testOrder);
    }

    @Order(4)
    @Test
    @DisplayName("GIVEN inventory information WHEN user requests current inventory THEN system shows inventory")
    void getInventoryAfterPlacingNewOrder() throws CsvValidationException, IOException {
        this.setCurrentResponse(orderView.getCurrentInventory());
        this.validateInventory(testDataLoader.getInventory(4));
    }

    @Order(5)
    @Test
    @DisplayName("GIVEN user an id of a placed order WHEN user deletes a placed order by its id THEN system deletes placed order")
    void deletePlaceOrder(){
        this.setCurrentResponse(orderView.deleteOrder(testOrder.getId()));
        this.getCurrentResponse().statusCode(HttpStatus.SC_OK);
    }

}