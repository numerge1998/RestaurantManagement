package dataLayer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Set;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;

public class FileWriter {

	static Restaurant re = new Restaurant();
	public static void bill(int id) {
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("Bon.txt"), "utf-8"));
		    writer.write("Comanda cu numarul " + id + " :\n");
			Set<Order> li = (Restaurant.getComanda().keySet());
			for(Order s : li)
				if(s.getOrderId() == id)
					for(MenuItem l:Restaurant.getComanda().get(s)) {
						writer.write( l.getName() + " .............. " + l.computePrice() + "\n");
					}
			writer.write("\n Total: " + re.computePriceForOrder(id) + "\n");

		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
}
