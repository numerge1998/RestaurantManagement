package businessLayer;

public class BaseProduct extends MenuItem{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseProduct(String name, int price,int id) {
		super(name, price, id);
	}

	public BaseProduct() {
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

	@Override
	public String toString() {
		return "BaseProduct [name=" + name + ", price=" + price + ", id=" + id + "]";
	}

	public int computePrice() {
		return price;
	}
}
