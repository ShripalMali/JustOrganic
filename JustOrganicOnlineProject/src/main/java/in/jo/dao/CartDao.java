package in.jo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.jo.pojo.Cart;
import in.jo.pojo.Product;
import in.jo.utility.DBConnection;
public class CartDao {
	Connection conn=DBConnection.getConnect();
	ResultSet  rs=null;
	String sql;
	PreparedStatement ps=null;
	int i=0;
	public boolean addToCart(Cart c) {
		try {
			sql="insert into Cart(customeremail,productid) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCustomeremail());
			ps.setInt(2, c.getProduct().getProductid());
			System.out.println("Query"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Cart> showMyCart(String customeremail){
		System.out.println("Inside Cart List");
		List<Cart> cartlist=new ArrayList<Cart>();
		try {
			sql="select p.productid,productname, productcategory,productweight,productprice,customeremail,quantity,cartid from product p inner join Cart c on p.productid=c.productid where customeremail=?";
	
			ps=conn.prepareStatement(sql);
			ps.setString(1, customeremail);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cart c=new Cart();
				Product p=new Product();
				p.setProductid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcategory(rs.getString(3));
				p.setProductweight(rs.getDouble(4));
				p.setProductprice(rs.getDouble(5));
				c.setCustomeremail(rs.getString(6));
				c.setQuantity(rs.getInt(7));
				c.setCartid(rs.getInt(8));
				c.setProduct(p);
				cartlist.add(c);
			}
			
		}
		catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return cartlist;
	}
	
	public boolean deleteCart(int cid) {
		System.out.println("Inside delete Cart");
		
		try {
			sql="delete from Cart where cartid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cid);
			System.out.println("Query"+ps);
			i=ps.executeUpdate();
			
			if(i>0)
				return true;
			}
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
