package businessLayer;

public class Order {

	private int orderId;
	private String date;
	private int table;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	public Order(int orderId, String d, int table) {
		super();
		this.orderId = orderId;
		this.date = d;
		this.table = table;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderId;
		result = prime * result + table;
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
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderId != other.orderId)
			return false;
		if (table != other.table)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", table=" + table + "]";
	}
	
	
}
