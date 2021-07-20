package models;

public class Model {
	private final String itemName;
	private final String itemPrice;
	
	public Model(String name, String price) {
		this.itemName = name;
		this.itemPrice = price;
	}
	
	public String getItemName(){ return this.itemName; }
	
	public String getItemPrice(){ return this.itemPrice; }
}
