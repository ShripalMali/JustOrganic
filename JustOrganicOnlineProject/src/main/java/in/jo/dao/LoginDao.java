package in.jo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jo.utility.DBConnection;

public class LoginDao {
	Connection conn=DBConnection.getConnect();
	ResultSet rs=null;
	String sql;
	PreparedStatement ps=null;
	int i=0;
	public boolean isAdmin(String email, String pass) {
		try {
			sql="select adminemail , adminpass from admin where adminemail=? and adminpass=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			System.out.println("query"+ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
		}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}return false;
} 
	
	public boolean isCustomer(String email, String pass) {
		try {
			sql="select customeremail , customerpass from customer where customeremail=? and customerpass=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			System.out.println("query"+ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
		}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}return false;
} 
	}
