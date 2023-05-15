package in.jo.test;
import java.util.List;
import java.util.Scanner;

import in.jo.dao.CartDao;
import in.jo.pojo.Cart;
import in.jo.pojo.Product;
public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int cartid;
		String customeremail;
		int quantity;
		Product product;
		boolean result;
		int productid;
		Scanner sc=new Scanner(System.in);
		Cart c=null;
		Product p=new Product();
		CartDao cdao=new CartDao();
		int choice;
		System.out.println("Inside Cart");
		System.out.println("1. Add to Cart");
		System.out.println("2. Delete From cart");
		System.out.println("3. Show my Cart List");
		System.out.println("Enter Choice");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("-----------------Add to cart----------------");
			System.out.println("Enter email");
			customeremail=sc.next();
			System.out.println("Enter Product id");
			productid=sc.nextInt();
			p.setProductid(productid);
			System.out.println(p);
			c=new Cart(customeremail,p);
			result=cdao.addToCart(c);
			if(result) 
				System.out.println("Product added to cart");
			else
				System.out.println("Product not added to cart");
			break;
			
		case 2:
			System.out.println("---------------Delete Cart-------------------");
			System.out.println("Enter Customer id of the customer you want to delete");
			cartid=sc.nextInt();
			result=cdao.deleteCart(cartid);
			if(result) {
				System.out.println("Cart Deleted Sucessfully");
			}
			else {
				System.out.println("Cart Not deleted");
			}
			break;
			
			
		case 3:
			System.out.println("-----------------Show my Cart--------------------");
			System.out.println("Enter customer email");
			customeremail=sc.next();
			List<Cart> clist=cdao.showMyCart(customeremail);
			if(!clist.isEmpty()){
				for(Cart c1:clist) {
					System.out.println(c1);
				}
			}
			else {
				System.out.println("Cart is empty");
			}
			
			
		}
		

	}
		
		
	}

