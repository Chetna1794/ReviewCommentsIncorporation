// user defined package
package customer;

import java.util.Objects;

public class CorporateCustomer extends Customer {
	/**
	 * This will be used if I ever need to deserialise the Customer Object
	 */
	private static final long serialVersionUID = 2L;
	// class variables
	private int registrationNumber;
	private float discountPercent;

	// Getter-Setters
	public int registrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	// Parameterized constructor
	public CorporateCustomer(int customerID, String customerName, String customerDob, String customerMobile,
			String customerType, String customerAddress) {
		super(customerID, customerName, customerDob, customerMobile, customerType, customerAddress);
	}

	public CorporateCustomer(int customerID, String customerName, String customerDob, String customerMobile,
			String customerType, String customerAddress, int registrationNumber, float discountPercent) {
		super(customerID, customerName, customerDob, customerMobile, customerType, customerAddress);
		this.registrationNumber = registrationNumber;
		this.discountPercent = discountPercent;
	}

	// Overridden hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(discountPercent, registrationNumber);
	}

	//Overridden equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CorporateCustomer)) {
			return false;
		}
		CorporateCustomer other = (CorporateCustomer) obj;
		return Float.floatToIntBits(discountPercent) == Float.floatToIntBits(other.discountPercent)
				&& registrationNumber == other.registrationNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorporateCustomer [").append(super.toString()).append(", Registration Number: ").append(registrationNumber).append(", Discount Percent: ")
				.append(discountPercent).append("]");
		return builder.toString();
	}
}
