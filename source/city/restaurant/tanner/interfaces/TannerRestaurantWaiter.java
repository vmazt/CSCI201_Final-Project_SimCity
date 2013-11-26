package city.restaurant.tanner.interfaces;


public interface TannerRestaurantWaiter 
{
	public void msgHereIsANewCustomer(TannerRestaurantCustomer c, int tableNumber, TannerRestaurantHost h, TannerRestaurantCook co);
	
	public void msgImReadyToOrder(TannerRestaurantCustomer c);
	
	public void msgHereIsMyOrder(TannerRestaurantCustomer c, int choice);
	
	public void msgICantAffordAnything(TannerRestaurantCustomer c);
	
	public void msgThatChoiceIsOutOfStock(int choice, int tableNumber);
	
	public void msgHereIsMyReOrder(TannerRestaurantCustomer c, int choice);
	
	public void msgOrderIsReady(int choice, int tableNumber);
	
	public void msgIWouldLikeTheCheck(TannerRestaurantCustomer c, int choice);
	
	public void msgHereIsTheChek(double amount, TannerRestaurantCustomer c);
	
	public void msgGoodBye(TannerRestaurantCustomer c);
}
