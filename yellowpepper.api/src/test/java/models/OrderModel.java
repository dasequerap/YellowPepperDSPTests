package models;

public class OrderModel {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public int getId() { return this.id; }

    public int getPetId() { return this.petId;  }

    public int getQuantity() { return this.quantity; }

    public String getShipDate() { return this.shipDate; }

    public String getStatus() { return this.status; }

    public boolean getComplete() { return this.complete; }

    public void setId(int id) { this.id = id; }

    public void setPetId(int petId) {  this.petId = petId;  }

    public void setQuantity(int quantity) {  this.quantity = quantity; }

    public void setShipDate(String shipDate) {  this.shipDate = shipDate; }

    public void setStatus(String status) {  this.status = status; }

    public void setComplete(boolean complete) {  this.complete = complete; }

}
