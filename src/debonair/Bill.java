//user defined package
package debonair;

// importing built in packages
import java.time.LocalDateTime;

public class Bill {
	// class variables
	private int billNumber;
	private int orderId;
	private double totalAmount;
	private LocalDateTime orderDate;

	// Getter-Setters
	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	// Parameterized Constructor
	public Bill(int billNumber, int orderId, double totalAmount, LocalDateTime orderDate) {
		this.billNumber = billNumber;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
	}

	// Overridden toString method
	@Override
	public String toString() {
		return "Bill Details are: [Bill Number: " + billNumber + ", Order Id: " + orderId + ", Total Amount: "
				+ totalAmount + ", Order Date: " + orderDate.getDayOfMonth() + "-" + orderDate.getMonth() + "-"
				+ orderDate.getYear();
	}
}
