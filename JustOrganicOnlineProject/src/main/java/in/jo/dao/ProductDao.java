package in.jo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import in.jo.pojo.Product;
import in.jo.utility.DBConnection;

public class ProductDao {
Connection conn=DBConnection.getConnect();
ResultSet rs=null;
String sql;
PreparedStatement ps=null;
int i=0;
public boolean addProduct(Product p) {
	System.out.println("inside addProduct");
	try {
		sql="insert into product(productname,productcategory,productweight,productprice,productimage) values(?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, p.getProductname());
		ps.setString(2, p.getProductcategory());
		ps.setDouble(3, p.getProductweight());
		ps.setDouble(4, p.getProductprice());
		ps.setBinaryStream(5, p.getProductimage());
		System.out.println("query"+ps);
		
		i=ps.executeUpdate();
		
		if(i>0)
			return true;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
}

public List<Product> showProductList(){
	System.out.println("inside product list");
	List<Product>plist=new ArrayList<Product>();
	try {
		sql="select *from product";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery(sql);
		while(rs.next()) {
			Product p=new Product();
			p.setProductid(rs.getInt(1));
			p.setProductname(rs.getString(2));
			p.setProductcategory(rs.getString(3));
			p.setProductweight(rs.getDouble(4));
			p.setProductprice(rs.getDouble(5));
			p.setProductimage(rs.getBinaryStream(6));
			plist.add(p);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return plist;
}
public boolean updateProduct(Product p) {
	System.out.println("inside update Product");
	sql="update product set productname=?, productcategory=?, productweight=?, productprice=?, productimage=? where productid=?";
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, p.getProductname());
		ps.setString(2, p.getProductcategory());
		ps.setDouble(3, p.getProductweight());
		ps.setDouble(4, p.getProductprice());
		ps.setBinaryStream(5, p.getProductimage());

		ps.setInt(6, p.getProductid());

		i=ps.executeUpdate();
		if(i>0)
		return true;
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		} return false;
		}
public boolean deleteProduct(int p) {
	System.out.println("Inside delete Product");

	try {
		sql="delete from product where productid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, p);
		System.out.println("Query"+ps);
		i=ps.executeUpdate();

		if(i>0)
			return true;
}

	catch (SQLException e) {
		e.printStackTrace();
}
return false;
}
public Product searchbyproductid(int id){
	System.out.println("inside search by  productid");
	//List<Product>plist=new ArrayList<Product>();
	Product p=null;
	try {
		sql="select *from product where productid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next()) {
		p=new Product();
			p.setProductid(rs.getInt(1));
			p.setProductname(rs.getString(2));
			p.setProductcategory(rs.getString(3));
			p.setProductweight(rs.getDouble(4));
			p.setProductprice(rs.getDouble(5));
			p.setProductimage(rs.getBinaryStream(6));

			//plist.add(p);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return p;
	
}
public Product searchbyproductname(String s){
	System.out.println("inside search by  product name");
//	List<Product>plist=new ArrayList<Product>();
	Product p=null;
	try {
		sql="select *from product where productname=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, s);
		rs=ps.executeQuery();
		while(rs.next()) {
			p=new Product();
			p.setProductid(rs.getInt(1));
			p.setProductname(rs.getString(2));
			p.setProductcategory(rs.getString(3));
			p.setProductweight(rs.getDouble(4));
			p.setProductprice(rs.getDouble(5));
			p.setProductimage(rs.getBinaryStream(6));

			//plist.add(p);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return p;
	}


public List<Product> showProductCategory(String s){
	System.out.println("inside product category");
	List<Product>plist=new ArrayList<Product>();
	
	try {
		sql="select *from product where productcategory=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, s);
		rs=ps.executeQuery();
		while(rs.next()) {
			Product p=new Product();
			p.setProductid(rs.getInt(1));
			p.setProductname(rs.getString(2));
			p.setProductcategory(rs.getString(3));
			p.setProductweight(rs.getDouble(4));
			p.setProductprice(rs.getDouble(5));
			p.setProductimage(rs.getBinaryStream(6));

			plist.add(p);
			
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return plist;
}}
