package in.jo.pojo;

public class Cart {
	private int cartid;
	private String customeremail;
	private int quantity;
	private Product product;
	
	public Cart() {
		super();
	}

	public Cart(String customeremail, Product product) {
		super();
		
		this.customeremail = customeremail;
		
		this.product = product;
	}

	public Cart(int cartid, String customeremail, int quantity, Product product) {
		super();
		this.cartid = cartid;
		this.customeremail = customeremail;
		this.quantity = quantity;
		this.product = product;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", customeremail=" + customeremail + ", quantity=" + quantity + ", product=" + product
				+ "]";
	}
}
