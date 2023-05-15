package in.jo.test;

import java.util.List;
import java.util.Scanner;

import in.jo.dao.CustromerDao;
import in.jo.dao.ProductDao;
import in.jo.pojo.Customer;
import in.jo.pojo.Product;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Scanner sc=new Scanner(System.in);
		 int customerid;
		 String customername;
		 String customeremail;
		 String customercontact;
		 String customeraddress;
		 String customerpass;
		 
		 boolean result;
		 int choice;
		 Customer customer=null;
		 
		 CustromerDao cdao=new CustromerDao();
		 
		 System.out.println("-----Welcome to JustOrganic-----");
		 System.out.println("1.Add Customer");
		 System.out.println("2.Update Customer");
		 System.out.println("3.Delete Customer");
		 System.out.println("4.Show Customer List");
		 System.out.println("5.Search by Customer Id");
		 System.out.println("6.Search by Customer Name");
		 System.out.println("7.Search by Customer email");
		 System.out.println("Enter Your Choice");
		 
		 choice=sc.nextInt();
		 
		 switch(choice) {
		 case(1):
			 System.out.println("Enter Customer Name");
		 		customername=sc.next();
		 	 System.out.println("Enter Customer email");
		 	 	customeremail=sc.next();
		 	 System.out.println("Enter Customer contact");
		 	 	customercontact=sc.next();
		     System.out.println("Enter Customer address");
		     	customeraddress=sc.next();
		     System.out.println("Enter Customer pass");
		    	customerpass=sc.next();
		     	customer= new Customer(customername,customeremail,customercontact,customeraddress,customerpass);
		     	result=cdao.addCustomer(customer);
		     	if(result)
		     		System.out.println("Customer Added Successfully");
		     	else
		     		System.out.println("Customer Not added");
			 break;
 
		 case(2):
		 		System.out.println("-----------------Update Customer------------------");
		 		System.out.println("Enter customerid for which you want to update the details");
		 		customerid=sc.nextInt();
		 		System.out.println("Enter new customername");
		 		customername=sc.next();
		 		System.out.println("Enter new customer email");
		 		customeremail=sc.next();
		 		System.out.println("Enter new customer contact");
		 		customercontact=sc.next();
		 		System.out.println("Enter new customer address");
		 		customeraddress=sc.next();
		 		System.out.println("Enter Customer pass");
		    	customerpass=sc.next();

		 		customer=new Customer(customerid, customername, customeremail, customercontact, customeraddress,customerpass);
		 		result=cdao.updateCustomer(customer);
		 		System.out.println(result);
		 		if(result) {
		 			System.out.println("customer Updated");
		 		}
		 		else
		 		{
		 			System.out.println("customer not Updated");
		 		}

		 		break;

		 case(3):
			 System.out.println("---------------Delete customer-------------------");
		 System.out.println("Enter customer id of the product you want to delete");
		 customerid=sc.nextInt();
		 result=cdao.deleteCustomer(customerid);
		 if(result) {
			 System.out.println("Deleted Sucessfully");
		 }
		 else {
			 System.out.println("Not deleted");
		 }
		 break;
		 
		 case(4):
	 System.out.println("-----customer list-----");
		 List<Customer>customerlist=cdao.showCustomerList();
		 if(!customerlist.isEmpty()) {
			 for(Customer c1:customerlist) {
	System.out.println(c1);
			 }
		 }
		 else {
	System.out.println("list is empty");
		 }
		 break;
		 
	case(5):
		 System.out.println("-----enter customer id-----");
	     customerid=sc.nextInt();
	     Customer p=cdao.searchCustomerid(customerid);
	     System.out.println(p);
	 break;
	case(6):
		 System.out.println("-----enter customer name-----");
	    customername=sc.next();
	    List<Customer> p2=cdao.searchByCustomerName(customername);
	    if(!p2.isEmpty()) {
			 for(Customer c1:p2) {
	System.out.println(c1);
			 }
		 }
		 else {
	System.out.println("list is empty");
		 }
		 break;
	case(7):
		 System.out.println("-----enter customer email-----");
	     customeremail=sc.next();
	     Customer p4=cdao.searchCustomerEmail(customeremail);
	     System.out.println(p4);
	 break;
	}
	}

}
