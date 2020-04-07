// user defined package
package debonair;

// built in package imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Menu {
	// itemMenu is an ArrayList which will hold the items of the menu
	// which will be showed to the customer
	public static final List<Item> ITEM_MENU = new ArrayList<>();

	private Menu() { throw new UnsupportedOperationException(Menu.class.getName()); }
	
	static {
		// fetching items from Items.txt file and saving it in itemMenu collection(ArrayList)
		try (BufferedReader bufferedReaderObj = new BufferedReader(new FileReader("./src/Items.txt"))) {
			String itemTextObj;
			// reading each item line by line from bufferedReaderObject
			while ((itemTextObj = bufferedReaderObj.readLine()) != null) {
				String itemsArr[] = itemTextObj.split(",");
				int itemId = Integer.parseInt(itemsArr[0]);
				String itemName = itemsArr[1];
				float itemRate = Float.parseFloat(itemsArr[2]);
				Item i = new Item(itemId, itemName, itemRate);
				ITEM_MENU.add(i);
			}
		} catch (FileNotFoundException fe) {
			System.err.println("Items.txt file was not found on the mentioned location");
		} catch (IOException e) {
			System.err.println(e + " while fetching file from location: ./Items.txt");
		}

	}

}
