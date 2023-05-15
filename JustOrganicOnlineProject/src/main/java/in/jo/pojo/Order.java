package in.jo.pojo;

public class Order {

	 private int orderid;
	 private String customeremail;
	 private double ordertotal;
	 private String orderdate;
	 private String orderstaus;
	 
	 Product product;
	 Cart cart;
	public Order() {
		super();
	}
	public Order(int orderid, String customeremail, double ordertotal, String orderdate, String orderstaus,
			Product product, Cart cart) {
		super();
		this.orderid = orderid;
		this.customeremail = customeremail;
		this.ordertotal = ordertotal;
		this.orderdate = orderdate;
		this.orderstaus = orderstaus;
		this.product = product;
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Order(String customeremail, double ordertotal, String orderdate, String orderstaus) {
		super();
		this.customeremail = customeremail;
		this.ordertotal = ordertotal;
		this.orderdate = orderdate;
		this.orderstaus = orderstaus;
	}
	
	public Order(int orderid, String customeremail, double ordertotal, String orderdate, String orderstaus) {
		super();
		this.orderid = orderid;
		this.customeremail = customeremail;
		this.ordertotal = ordertotal;
		this.orderdate = orderdate;
		this.orderstaus = orderstaus;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public double getOrdertotal() {
		return ordertotal;
	}
	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrderstaus() {
		return orderstaus;
	}
	public void setOrderstaus(String orderstaus) {
		this.orderstaus = orderstaus;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", customeremail=" + customeremail + ", ordertotal=" + ordertotal
				+ ", orderdate=" + orderdate + ", orderstaus=" + orderstaus + "]";
	}
	 
	
}
