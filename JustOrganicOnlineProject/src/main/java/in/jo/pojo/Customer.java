package in.jo.pojo;

public class Customer {

	private int customerid;
	private String customername;
	private String customeremail;
	private String customercontact;
	private String customeraddress;
	private String customerpass;
	public Customer() {
		super();
	}
	public Customer(String customername, String customeremail, String customercontact, String customeraddress,
			String customerpass) {
		super();
		this.customername = customername;
		this.customeremail = customeremail;
		this.customercontact = customercontact;
		this.customeraddress = customeraddress;
		this.customerpass = customerpass;
	}
	public Customer(int customerid, String customername, String customeremail, String customercontact,
			String customeraddress, String customerpass) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customeremail = customeremail;
		this.customercontact = customercontact;
		this.customeraddress = customeraddress;
		this.customerpass = customerpass;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public String getCustomercontact() {
		return customercontact;
	}
	public void setCustomercontact(String customercontact) {
		this.customercontact = customercontact;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getCustomerpass() {
		return customerpass;
	}
	public void setCustomerpass(String customerpass) {
		this.customerpass = customerpass;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customeremail="
				+ customeremail + ", customercontact=" + customercontact + ", customeraddress=" + customeraddress
				+ ", customerpass=" + customerpass + "]";
	}

	
}
