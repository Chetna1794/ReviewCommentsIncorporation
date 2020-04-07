// user defined package
package debonair;

import java.time.LocalDateTime;
// imports from in-built packages
import java.util.Iterator;
import java.util.Scanner;

// importing classes from other packages
import resources.Constants;

public class Restaurant implements IRestaurant {
	/**
	 * This method is used to show menu to the customer
	 */
	public void showMenu() {
		System.out.println("The menu has following items:-");
		// Iterator created to print items from Menu class's itemMenu List
		Iterator<Item> itemsIterator = Menu.ITEM_MENU.iterator();
		while (itemsIterator.hasNext()) {
			Item item = itemsIterator.next();
			System.out.println(item.toString());
		}
	}

	/**
	 * This method will be used to take order from the customer
	 */
	public void takeOrder() {
		Order.createOrder();
	}

	/**
	 * This method will be used to check customer's order status
	 * 
	 * @param orderID
	 */
	public boolean checkStatus(int orderId) {
		// not so important as no functionality in assignment of collections so just
		// returning true
		return true;
	}

	/**
	 * This method will be used to show offers to the regular customer
	 * 
	 * @param customerId
	 */
	public void showRegularCustomerOffers(int customerId) {
		if (customerId > 25) {
			System.out.println("This is not a valid Regular Customer Id");
		} else {
			int day = LocalDateTime.now().getDayOfWeek().getValue();
			System.out.println(day);
			if (day == 6 || day == 7) {
				System.out.println("Hurraaayy!! 10% discount will be applicable on the order");
			} else {
				System.out.println("Oops, no offers available for you!");
			}
		}
	}

	/**
	 * This method will be used to show offers to the corporate customer
	 * 
	 * @param corporateId
	 */
	public void showCorporateCustomerOffers(int corporateId) {
		if (corporateId < 24) {
			System.out.println("This is not a valid Corporate Customer Id");
		} else {
			System.out.println("You will get a meal voucher of 100 Rs.");
		}
	}

	public static void main(String[] args) {
		// object creation of Restaurant class
		Restaurant restaurantObj = new Restaurant();
		@SuppressWarnings("resource")
		Scanner scannerObj = new Scanner(System.in);
		// variable to get user input if we need to show the menu or not
		String showMenuChoice;
		// variable used to get user choice from the displayed menu through scanner
		// object
		int choice;
		do {
			// console driven menu for the customer
			System.out.println("Welcome to Debonair Restaurant.");
			System.out.println("Please select your choice from given menu");
			System.out.println("1. Show Menu");
			System.out.println("2. Take Order");
			System.out.println("3. Check Order status");
			System.out.println("4. Show Regular customer Offers");
			System.out.println("5. Show Corporate Customer Offers");
			System.out.print("Enter your choice :");
			choice = scannerObj.nextInt();
			switch (choice) {
			case 1: {
				restaurantObj.showMenu();
				break;
			}
			case 2: {
				restaurantObj.takeOrder();
				break;
			}
			case 3: {
				System.out.println("Please enter your order Id");
				int orderId = scannerObj.nextInt();
				restaurantObj.checkStatus(orderId);
				break;
			}
			case 4: {
				System.out.println("Please enter your Regular Customer Id");
				int regularCustomerId = scannerObj.nextInt();
				restaurantObj.showRegularCustomerOffers(regularCustomerId);
				break;
			}
			case 5: {
				System.out.println("Please enter your Corporate Customer Id");
				int corporateCustomerId = scannerObj.nextInt();
				restaurantObj.showCorporateCustomerOffers(corporateCustomerId);
				break;
			}
			default:
				System.out.println("Please enter valid choice.");
				break;
			}
			System.out.println("Would you like to return to main menu? (yes/no)");
			showMenuChoice = scannerObj.next();
		} while (Constants.YES.equalsIgnoreCase(showMenuChoice));
		if (!Constants.YES.equalsIgnoreCase(showMenuChoice)) {
			System.out.println("Program Exited");
			System.exit(1);
		}
	}
}
