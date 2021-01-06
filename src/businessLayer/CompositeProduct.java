package businessLayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MenuItem> product ;
	
	public CompositeProduct(String name, int price,int id) {
		super(name, price, id);
		this.product = new ArrayList<MenuItem>();

	}

	public CompositeProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<MenuItem> getProduct() {
		return product;
	}
	
	
	
	public void setProduct(ArrayList<MenuItem> product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int computePrice() {
		for(MenuItem l:product)
			price+=l.computePrice();
		return price;
	}

	@Override
	public String toString() {
		return "CompositeProduct [composit=" + product + ", name=" + name + ", price=" + price + ", id=" + id + "]";
	}




}
