package in.jo.test;

import java.util.List;
import java.util.Scanner;

import in.jo.dao.CustromerDao;
import in.jo.dao.OrderDao;
import in.jo.pojo.Cart;
import in.jo.pojo.Customer;
import in.jo.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int orderid;
		  String customeremail;
		  double ordertotal;
		  String orderdate;
		  String orderstaus;
		  Scanner sc= new Scanner(System.in);
		  
			 boolean result;
			 int choice;
			 Order o =null;
			 
			OrderDao odao=new OrderDao();
			 
			 System.out.println("-----Welcome to JustOrganic-----");
			 System.out.println("1.Place Order");
			 System.out.println("2.Show my order");
			 
			 System.out.println("2.Enter Choice");
			 choice = sc.nextInt();
		  
		  switch(choice) {
		  case 1:
			  System.out.println("enter email");
			  customeremail=sc.next();
			  o=odao.placeOrder(customeremail);
			  if(o!=null) {
				  System.out.println(o);
			  }
			  
			  break;
				
			case 2:
				System.out.println("-----------------Show my Order--------------------");
				System.out.println("Enter customer email");
				customeremail=sc.next();
				List<Order> olist=odao.showMyOrder(customeremail);
				if(!olist.isEmpty()){
					for(Order o1:olist) {
						System.out.println(o1);
					}
				}
				else {
					System.out.println("Order is empty");
				}
		  }
		   
	}

}
