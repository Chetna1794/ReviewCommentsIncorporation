// user defined package
package debonair;

public class Item implements Comparable<Item>{
	// class variables
	private int itemId;
	private String itemName;
	private float itemRate;
	
	// Getter Setters
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemRate() {
		return itemRate;
	}
	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}
	
	// Parameterized constructor
	public Item(int itemId, String itemName, float itemRate) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemRate = itemRate;
	}
	
	// Overridden toString method
	@Override
	public String toString() {
		return "Item Id: " + itemId + ", Item Name: " + itemName + ", Price: " + itemRate;
	}
	
	// Overridden compareTo method as we are implementing comparable interface 
	@Override
	public int compareTo(Item arg0) {
		return this.getItemId()-arg0.getItemId();
	}
	
	
	
	
}
