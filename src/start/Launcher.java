package start;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;
import presentationLayer.AdministratorGraphicalUserInterface;
import presentationLayer.WaiterGraphicalUserInterface;

public class Launcher implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		
		RestaurantSerializator.deser();
		Restaurant.menuSet();
		new AdministratorGraphicalUserInterface();
		new WaiterGraphicalUserInterface();
	}
}
