//user defined package
package customer;

public class RegularCustomer extends Customer {
	/**
	 * This will be used if I ever need to deserialise the Customer Object
	 */
	private static final long serialVersionUID = 1L;
	// class variables
	private int customerPoints;

	// Getters-Setters
	public int getCustomerPoints() {
		return customerPoints;
	}

	public void setCustomerPoints(int customerPoints) {
		this.customerPoints = customerPoints;
	}

	public RegularCustomer(int customerID, String customerName, String customerDob, String customerMobile,
			String customerType, String customerAddress, int customerPoints) {
		super(customerID, customerName, customerDob, customerMobile, customerType, customerAddress);
		this.customerPoints = customerPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerPoints;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegularCustomer other = (RegularCustomer) obj;
		if (customerPoints != other.customerPoints)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegularCustomer [").append(super.toString()).append(", Customer Points: ").append(customerPoints).append("]");
		return builder.toString();
	}
}
