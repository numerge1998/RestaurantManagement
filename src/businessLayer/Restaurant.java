package businessLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import dataLayer.FileWriter;
import dataLayer.RestaurantSerializator;


@SuppressWarnings("deprecation")
public class Restaurant extends Observable implements RestaurantProcessing{

	public static List<MenuItem> meniuSel = new ArrayList<MenuItem>();
	public static List<MenuItem> compSel = new ArrayList<MenuItem>();
	public static ArrayList<MenuItem> meniu = new ArrayList<MenuItem>();
	public static HashMap<Order, List<MenuItem>> comanda = new HashMap<Order, List<MenuItem>>();

	
	public static List<MenuItem> getMeniu() {
		return meniu;
	}
	
	public static void menuSet() {
		meniu = (ArrayList<MenuItem>) RestaurantSerializator.getMen();
	}

	public static void setMeniu(List<MenuItem> meniu) {
		Restaurant.meniu = (ArrayList<MenuItem>) meniu;
	}

	public static HashMap<Order, List<MenuItem>> getComanda() {
		return comanda;
	}

	public static void setComanda(HashMap<Order, List<MenuItem>> comanda) {
		Restaurant.comanda = comanda;
	}

	public static List<MenuItem> getMeniuSel() {
		return meniuSel;
	}

	public static void setMeniuSel(List<MenuItem> meniuSel) {
		Restaurant.meniuSel = meniuSel;
	}
	
	public List<MenuItem> selectMenu(int i){
		for(MenuItem l: meniu)
			if(l.getId() == i)
				meniuSel.add(l);
		
		for(MenuItem l: meniuSel)
				System.out.println(l);
		return meniuSel;
	}
	
	public static List<MenuItem> selectComp(int i){
		for(MenuItem l: meniu)
			if(l.getId() == i)
				compSel.add(l);
		
		return compSel;
	}
	
	public static void deletComp(int i) {
		for(MenuItem l: compSel)
				if(l.getId() == i)
					compSel.remove(l);

	}
	
	public static List<MenuItem> getCompSel() {
		return compSel;
	}

	public static void setCompSel(List<MenuItem> compSel) {
		Restaurant.compSel = compSel;
	}

	public void deletMenu(int i) {
		for(MenuItem l: meniuSel)
			if(l.getId() == i)
				meniuSel.remove(l);

	}
	
	public void addMenuItem(MenuItem produs) {
		meniu.add(produs);
		RestaurantSerializator.ser();
		for(MenuItem l:meniu)
			System.out.println(l.toString());
		System.out.println("\n");
	}
	
	public void deleteMenuItem(int id) {
		for(MenuItem l:meniu)
			if(l.getId() == id)
				meniu.remove(l);
		RestaurantSerializator.ser();

	}
	
	public void editMenuItem(int id, String name, int price) {
		for(MenuItem l:meniu)
			if(l.getId() == id) {
				l.setName(name);
				l.setPrice(price);
			}
		RestaurantSerializator.ser();
		for(MenuItem l:meniu)
			System.out.println(l.toString() );
		System.out.println("\n");
	}
	
	public void createOrder(Order ord,List<MenuItem> meniu) {	
		
		comanda.put(ord, meniu);
		meniuSel = new ArrayList<MenuItem>();
		System.out.println(comanda);
		System.out.println("\n");
        setChanged();
        notifyObservers(comanda);
	}
	
	public int computePriceForOrder(int id) {

		int a = 0;
		Set<Order> li = (comanda.keySet());
		for(Order s : li)
			if(s.getOrderId() == id)
				for(MenuItem l:comanda.get(s))
					a+=l.computePrice();
		return a;
	}
	
	public void generateBill(int id) {
		FileWriter.bill(id);
		
		
	}
	

	

}
