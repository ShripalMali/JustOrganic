package in.jo.test;

import java.util.Scanner;

import in.jo.dao.LoginDao;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String uname;
String upass;
String utype;
Scanner sc=new Scanner(System.in);
boolean result;
LoginDao ldao=new LoginDao();

System.out.println("enter email");
uname=sc.next();
System.out.println("enter pass");
upass=sc.next();
System.out.println("enter utype");
utype=sc.next();
if(utype!=null && utype.equals("admin")) {
	result=ldao.isAdmin(uname, upass);
	if(result) {
		System.out.println("welcoem admin");
	}
	else {
		System.out.println("invalid user");
	}
}
else if(utype!=null && utype.equals("customer")) {
	result=ldao.isCustomer(uname, upass);
	if(result) {
		System.out.println("welcome customer");
	}
	else {
		System.out.println("invalid user");
	}
}
	
	}

}
