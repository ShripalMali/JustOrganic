package in.jo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.jo.pojo.Customer;
import in.jo.pojo.Product;
import in.jo.utility.DBConnection;

public class CustromerDao {
    //add customer
	//update customer
	//delete customer
	//show custmer list
	//search by customerid
	//search by customer email
	
	Connection conn=DBConnection.getConnect();
	ResultSet rs=null;
	String sql;
	PreparedStatement ps=null;
	int i=0;
	public boolean addCustomer(Customer c) {
		System.out.println("inside addCustomer");
		try {
			sql="insert into customer(customername,customeremail,customercontact,customeraddress,customerpass) values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCustomername());
			ps.setString(2, c.getCustomeremail());
			ps.setString(3, c.getCustomercontact());
			ps.setString(4, c.getCustomeraddress());
			ps.setString(5, c.getCustomerpass());
			
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
	
	

public boolean updateCustomer(Customer c) {
	System.out.println("inside update customer");
	sql="update customer set customername=?, customeremail=?, customercontact=?, customeraddress=?, "
			+ "customerpass=? where customerid=?";
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, c.getCustomername());
		ps.setString(2, c.getCustomeremail());
		ps.setString(3, c.getCustomercontact());
		ps.setString(4, c.getCustomeraddress());
		ps.setString(5, c.getCustomerpass());
		ps.setInt(6, c.getCustomerid());
		i=ps.executeUpdate();
		if(i>0)
		return true;
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		} return false;
		}

	public boolean deleteCustomer(int c) {
		System.out.println("Inside delete customer");

		try {
			sql="delete from customer where customerid=?";
	ps=conn.prepareStatement(sql);
	ps.setInt(1, c);
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


public List<Customer> showCustomerList(){
	System.out.println("inside customer list");
	List<Customer>clist=new ArrayList<Customer>();
	try {
		sql="select *from customer";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery(sql);
		while(rs.next()) {
			Customer c=new Customer();
			c.setCustomerid(rs.getInt(1));
			c.setCustomername(rs.getString(2));
			c.setCustomeremail(rs.getString(3));
			c.setCustomercontact(rs.getString(4));
			c.setCustomeraddress(rs.getString(5));
			c.setCustomerpass(rs.getString(6));
			clist.add(c);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return clist;
}

public Customer searchCustomerid(int id){
	System.out.println("inside search by  customerid");
	
	Customer p=null;
	try {
		sql="select *from customer where customerid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next()) {
		p=new Customer();
			p.setCustomerid(rs.getInt(1));
			p.setCustomername(rs.getString(2));
			p.setCustomeremail(rs.getString(3));
			p.setCustomercontact(rs.getString(4));
			p.setCustomeraddress(rs.getString(5));
			p.setCustomerpass(rs.getString(6));
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return p;
}
public List<Customer> searchByCustomerName(String s){
	System.out.println("inside search by  product name");
	List<Customer>clist=new ArrayList<Customer>();
	
	try {
		sql="select *from customer where customername=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, s);
		rs=ps.executeQuery();
		while(rs.next()) {
			Customer p=new Customer();
			p.setCustomerid(rs.getInt(1));
			p.setCustomername(rs.getString(2));
			p.setCustomeremail(rs.getString(3));
			p.setCustomercontact(rs.getString(4));
			p.setCustomeraddress(rs.getString(5));
			p.setCustomerpass(rs.getString(6));
			clist.add(p);
			
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return clist;
	}

public Customer searchCustomerEmail(String e){
	System.out.println("inside search by  customer email");
	
	Customer p=null;
	try {
		sql="select *from customer where customeremail=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, e);
		rs=ps.executeQuery();
		while(rs.next()) {
		p=new Customer();
			p.setCustomerid(rs.getInt(1));
			p.setCustomername(rs.getString(2));
			p.setCustomeremail(rs.getString(3));
			p.setCustomercontact(rs.getString(4));
			p.setCustomeraddress(rs.getString(5));
			p.setCustomerpass(rs.getString(6));
		}
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
	return p;
}

}
