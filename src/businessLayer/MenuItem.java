package businessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public int price;
	public int id;
	
	public MenuItem(String name, int price, int id) {
		super();
		this.name = name;
		this.price = price;
		this.id = id;
	}

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", price=" + price + ", id=" + id + "]";
	}

	public abstract int computePrice();
}
