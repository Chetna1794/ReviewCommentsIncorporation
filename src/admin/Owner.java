//user defined package
package admin;

// importing built in packages
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// importing classes from other packages
import resources.Constants;

public class Owner {

	/**
	 * Function provided to the owner to add items to the Menu
	 * @throws IOException
	 */
	public void modifyMenu() throws IOException {
		try(BufferedWriter bufferedWriterObj = new BufferedWriter(new FileWriter("./src/main/resources/Items.txt", true))) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);			
			String addItems;
			String item;
			int itemId;
			String itemName;
			Double itemRate;
			do {
				System.out.println("Do you want to add items in the menu?");
				addItems = sc.next();
				if (addItems.equals("Yes")) {
					System.out.println("Enter item id");
					itemId = sc.nextInt();
					System.out.println("Enter item name");
					itemName = sc.next();
					System.out.println("Enter item rate");
					itemRate = sc.nextDouble();
					item = itemId + "," + itemName + "," + itemRate;
					bufferedWriterObj.append(item);
					bufferedWriterObj.newLine();
				}
			} while (Constants.YES.equalsIgnoreCase(addItems));
			bufferedWriterObj.flush();
		} catch (FileNotFoundException fe) {
			System.err.println(fe);
		}
	}
}
