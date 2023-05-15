package in.jo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.jo.pojo.Cart;
import in.jo.pojo.Order;
import in.jo.pojo.Product;
import in.jo.utility.DBConnection;

public class OrderDao {
	Connection conn=DBConnection.getConnect();
	ResultSet rs=null;
	String sql;
	PreparedStatement ps=null;
	int i=0;
	public double getTotal(String email) {
		try {
			sql="select sum(productprice*quantity) from product p inner join Cart c on p.productid=c.productid where customeremail=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, email);
					System.out.println("query:"+ps);
					rs=ps.executeQuery();
					if(rs.next()) {
						return rs.getDouble(1);
					}
		}catch(SQLException e) {
			e.printStackTrace();
		} return 0.0;
	}
	 
	public Order placeOrder(String email) {
		try {
		double total=getTotal(email);
		Date d=new Date();
		sql="insert into Orders(customeremail,ordertotal,orderdate) values(?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setDouble(2, total);
		ps.setString(3, d.toString());
		System.out.println("query:"+ps);
		i=ps.executeUpdate();
		if(i>0) {
			sql="select *from orders where orderdate=? and customeremail=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, d.toString());
			ps.setString(2, email);
			System.out.println("query:"+ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				Order o=new Order();
				o.setOrderid(rs.getInt(1));
				o.setCustomeremail(rs.getString(2));
				o.setOrdertotal(rs.getDouble(3));
				o.setOrderdate(rs.getString(4));
				o.setOrderstaus(rs.getString(5));
				return o;
			}
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
	public List<Order> showMyOrder(String customeremail){
		System.out.println("Inside Order List");
		List<Order> olist=new ArrayList<Order>();
		try {
			sql="select *from orders where customeremail=?";
	
			ps=conn.prepareStatement(sql);
			ps.setString(1, customeremail);
			rs=ps.executeQuery();
			while(rs.next()) {
			
				Order o=new Order();
				o.setOrderid(rs.getInt(1));
				o.setCustomeremail(rs.getString(2));
				o.setOrdertotal(rs.getDouble(3));
				o.setOrderdate(rs.getString(4));
				o.setOrderstaus(rs.getString(5));
			
				olist.add(o);
			}
			
		}
		catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return olist;
	}



	public List<Order> showMyOrders(String customeremail){
		System.out.println("Inside Order List");
		List<Order> olist=new ArrayList<Order>();
		try {
			sql="select p.productid,productname,productimage,productcategory,productweight,productprice,\r\n"
					+ "quantity,ordertotal,orderdate,orderstatus\r\n"
					+ "from product p inner join backupcart b inner join orders o\r\n"
					+ "on p.productid=b.productid and o.customeremail=b.customeremail  where customeremail=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, customeremail);
			rs=ps.executeQuery();
			while(rs.next()) {
			Product p=new Product();
			
				Order o=new Order();
				
			Cart c=new Cart();
				p.setProductid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductimage(rs.getBinaryStream(3));
				p.setProductcategory(rs.getString(4));
				p.setProductweight(rs.getDouble(5));
				p.setProductprice(rs.getDouble(6));
				c.setQuantity(rs.getInt(7));
			
			//	o.setOrderid(rs.getInt(1));
				//o.setCustomeremail(rs.getString(2));
				o.setOrdertotal(rs.getDouble(8));
				o.setOrderdate(rs.getString(9));
				o.setOrderstaus(rs.getString(10));
			o.setProduct(p);
			o.setCart(c);
				olist.add(o);
			}
			
		}
		catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return olist;
	}




















}
