package in.jo.pojo;

import java.io.InputStream;

public class Product {

	private int productid;
	private  String productname;
	private String productcategory;
	private double productweight;
	private double productprice;
	private InputStream productimage;
	
	
	public InputStream getProductimage() {
		return productimage;
	}
	public void setProductimage(InputStream productimage) {
		this.productimage = productimage;
	}
	public Product(String productname, String productcategory, double productweight, double productprice,
			InputStream productimage) {
		super();
		this.productname = productname;
		this.productcategory = productcategory;
		this.productweight = productweight;
		this.productprice = productprice;
		this.productimage = productimage;
	}
	public Product(int productid, String productname, String productcategory, double productweight, double productprice,
			InputStream productimage) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productcategory = productcategory;
		this.productweight = productweight;
		this.productprice = productprice;
		this.productimage = productimage;
	}
	public Product() {
	super();
	}
public Product(String productname, String productcategory, double productweight, double productprice) {
	super();
	this.productname = productname;
	this.productcategory = productcategory;
	this.productweight = productweight;
	this.productprice = productprice;
}
public Product(int productid, String productname, String productcategory, double productweight, double productprice) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.productcategory = productcategory;
	this.productweight = productweight;
	this.productprice = productprice;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getProductcategory() {
	return productcategory;
}
public void setProductcategory(String productcategory) {
	this.productcategory = productcategory;
}
public double getProductweight() {
	return productweight;
}
public void setProductweight(double productweight) {
	this.productweight = productweight;
}
public double getProductprice() {
	return productprice;
}
public void setProductprice(double productprice) {
	this.productprice = productprice;
}
@Override
public String toString() {
	return "Product [productid=" + productid + ", productname=" + productname + ", productcategory=" + productcategory
			+ ", productweight=" + productweight + ", productprice=" + productprice + "]";
}
  
  
}
