package views;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import models.OrderModel;



public class OrderView extends BaseView{

    public OrderView(String _webServiceURI){
        super(_webServiceURI, "store");
    }

    public ValidatableResponse getOrderById(int orderId){
        return this.getRequest().get( "/order/{orderId}", orderId).then().log().everything();
    }

    public ValidatableResponse createOrder(OrderModel order){
        return this.getRequest().body(setJsonBodyParamsForOrder(order).toString()).post("/order").then().log().everything();

    }

    public ValidatableResponse deleteOrder(int orderId){
        return this.getRequest().delete( "/order/{orderId}", orderId).then().log().everything();
    }

    public ValidatableResponse getCurrentInventory(){
        return this.getRequest().get( "/inventory").then().log().everything();
    }

    private JSONObject setJsonBodyParamsForOrder(OrderModel order){
        JSONObject bodyParams = new JSONObject();

        bodyParams.put("id", order.getId());
        bodyParams.put("petId", order.getPetId());
        bodyParams.put("quantity", order.getQuantity());
        bodyParams.put("shipDate", order.getShipDate());
        bodyParams.put("status", order.getStatus());
        bodyParams.put("complete", order.getComplete());
        this.getRequest().header("Content-Type", "application/json");

        return bodyParams;
    }
}