// user defined package
package debonair;

// importing built in packages
import java.time.LocalDateTime;
import java.util.*;

// importing classes from other packages
import resources.Constants;

public class Order {
	// class variables
	private int orderId;
	private LocalDateTime orderDate = LocalDateTime.now();
	private Set<Item> orderCart;
	private static Map<Integer, Bill> currentSale = new HashMap<>();

	// Getter-Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Item> getOrderCart() {
		return orderCart;
	}

	public void setOrderCart(TreeSet<Item> orderCart) {
		this.orderCart = orderCart;
	}

	public static Map<Integer, Bill> getCurrentSale() {
		return currentSale;
	}

	public static void setCurrentSale(HashMap<Integer, Bill> currentSale) {
		Order.currentSale = currentSale;
	}

	// Overridden toString method
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderCart=" + orderCart + "]";
	}

	// Parameterized constructor
	public Order(int orderId, LocalDateTime orderDate, Set<Item> orderCart) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderCart = orderCart;
	}

	/**
	 * Function to create order of the customer
	 */
	public static void createOrder() {
		Random randomObj = new Random();
		// Generating Random Order Id
		int orderId = randomObj.nextInt(100);
		// Getting current Date Time
		LocalDateTime currentDateTime = LocalDateTime.now();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice;
		TreeSet<Item> itemSet = new TreeSet<>();
		// User adding items to the cart
		do {
			System.out.println("Select item Id you want to add to the cart");
			int itemNumber = sc.nextInt();
			if (itemSet.add(Menu.ITEM_MENU.get(itemNumber))) {
				System.out.println("The added item is: " + Menu.ITEM_MENU.get(itemNumber).getItemName());
			} else {
				System.err.println("Failed to add the item");
			}
			System.out.println("Would you like to order more items? (yes/no)");
			choice = sc.next();
		} while (Constants.YES.equalsIgnoreCase(choice));
		@SuppressWarnings("unused")
		Order myOrder = new Order(orderId, currentDateTime, itemSet);
		// initiating bill generation
		myOrder.generateBill();
	}

	/**
	 * Function to generate user bill and show the details to the user
	 */
	public void generateBill() {
		Iterator<Item> orderCartIterator = getOrderCart().iterator();
		// Formatting order Cart items and computing total bill price
		String displayableOrderCart = null;
		double totalCartPrice = 0.00;
		while (orderCartIterator.hasNext()) {
			Item item = orderCartIterator.next();
			if (displayableOrderCart == null) {
				displayableOrderCart = item.getItemName();
			} else {
				displayableOrderCart = displayableOrderCart.concat(item.getItemName());
			}
			totalCartPrice += item.getItemRate();
			if (orderCartIterator.hasNext()) {
				displayableOrderCart = displayableOrderCart.concat(", ");
			}
		}
		Random randomObj = new Random();
		// Generating random Bill Id
		int billNumber = randomObj.nextInt(100);
		// Generating Bill class's object
		Bill billObj = new Bill(billNumber, getOrderId(), totalCartPrice, getOrderDate());
		currentSale.put(this.orderId, billObj);
		// Printing Bill Details
		System.out.println(billObj.toString() + ", Order Items: " + displayableOrderCart);
	}
}
