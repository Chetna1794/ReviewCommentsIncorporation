// user defined package
package customer;

// importing built in packages
import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
	// class variables
	/**
	 * This will be used if I ever need to deserialise the Customer Object
	 */
	private static final long serialVersionUID = 17L;
	private int customerID;
	private String customerName;
	private String customerDob;
	private String customerMobile;
	private String customerType;
	private String customerAddress;

	// Getter-Setters
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	// Parameterized constructor
	Customer(int customerID, String customerName, String customerDob, String customerMobile, String customerType,
			String customerAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerDob = customerDob;
		this.customerMobile = customerMobile;
		this.customerType = customerType;
		this.customerAddress = customerAddress;
	}

	// Overridden hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerDob, customerID, customerMobile, customerName, customerType);
	}

	// Overridden equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		return Objects.equals(customerAddress, other.customerAddress) && Objects.equals(customerDob, other.customerDob)
				&& customerID == other.customerID && Objects.equals(customerMobile, other.customerMobile)
				&& Objects.equals(customerName, other.customerName) && Objects.equals(customerType, other.customerType);
	}

	// Overridden toString method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Customer ID: ").append(customerID).append(", Customer Name: ").append(customerName)
				.append(", Customer Dob: ").append(customerDob).append(", Customer Mobile: ").append(customerMobile)
				.append(", Customer Type: ").append(customerType).append(", Customer Address: ").append(customerAddress);
		return builder.toString();
	}
}
