package in.jo.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection conn=null;
	
    public static Connection getConnect() {
    	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("driver loaded");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/justorganic_bsf04", "root", "Sunny@2525");
	System.out.println("connected to db");
	
	}
	catch(ClassNotFoundException  | SQLException e) {
		e.printStackTrace();
	}
	return conn;
    }
}