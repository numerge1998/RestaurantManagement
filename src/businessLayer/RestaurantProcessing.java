package businessLayer;

import java.util.List;

public interface RestaurantProcessing{
	public void addMenuItem(MenuItem produs);
	public void deleteMenuItem(int id);
	public void editMenuItem(int id, String name, int price);
	public void createOrder(Order ord,List<MenuItem> meniu);
	public int computePriceForOrder(int id);
	public void generateBill(int id);
}
