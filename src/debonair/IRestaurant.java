package debonair;

public interface IRestaurant {
	public void showMenu();
	public void takeOrder();
	public boolean checkStatus(int orderId);
	public void showRegularCustomerOffers(int custId);
	public void showCorporateCustomerOffers(int corpId);
}