package in.jo.test;
import java.util.List;
import java.util.Scanner;
import in.jo.dao.ProductDao;
import in.jo.pojo.Product;


public class ProductTest {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int productid;
		 String productname;
		 String productcategory;
		 double productweight;
		 double productprice;
		 
		 boolean result;
		 int choice;
		 Product product=null;
		 
		 ProductDao pdao=new ProductDao();
		 
		 System.out.println("-----Welcome to JustOrganic-----");
		 System.out.println("1.Add Product");
		 System.out.println("2.Update Product");
		 System.out.println("3.Delete Product");
		 System.out.println("4.Show Product List");
		 System.out.println("5.Search by Product Id");
		 System.out.println("6.Search by Product Name");
		 System.out.println("7.Search by Product Category");
		 System.out.println("Enter Your Choice");
		 
		 choice=sc.nextInt();
		 
		 switch(choice) {
		 case(1):
			 System.out.println("Enter Prouct Name");
		 		productname=sc.next();
		 	 System.out.println("Enter Product Category");
		 	 	productcategory=sc.next();
		 	 System.out.println("Enter Product Weight");
		 	 	productweight=sc.nextDouble();
		     System.out.println("Enter Product Price");
		     	productprice=sc.nextDouble();
		     	product= new Product(productname,productcategory,productweight,productprice);
		     	result=pdao.addProduct(product);
		     	if(result)
		     		System.out.println("Product Added Successfully");
		     	else
		     		System.out.println("Product NOt added");
			 break;
 
		 
		 case(2):
			 System.out.println("-----------------Update Employee------------------");
		 	System.out.println("Enter productid for which you want to update the details");
		 	productid=sc.nextInt();
		 	System.out.println("Enter new productname");
		 	productname=sc.next();
		 	System.out.println("Enter new productcategory");
		 	productcategory=sc.next();
		 	System.out.println("Enter new productweight");
		 	productweight=sc.nextDouble();
		 	System.out.println("Enter new productprice");
		 	productprice=sc.nextDouble();

		 	product=new Product(productid, productname, productcategory, productweight, productprice);
		 	result=pdao.updateProduct(product);
		 	System.out.println(result);
		 	if(result) {
		 		System.out.println("Product Updated");
		 	}
		 	else
		 	{
		 		System.out.println("Product not Updated");
		 	}

		 	break;

		 case(3):
			 System.out.println("---------------Delete Product-------------------");
		 System.out.println("Enter product id of the product you want to delete");
		 productid=sc.nextInt();
		 result=pdao.deleteProduct(productid);
		 if(result) {
			 System.out.println("Deleted Sucessfully");
		 }
		 else {
			 System.out.println("Not deleted");
		 }
		 break;
		 case(4):
			 System.out.println("-----product list-----");
		 List<Product>productlist=pdao.showProductList();
		 if(!productlist.isEmpty()) {
			 for(Product p1:productlist) {
				 System.out.println(p1);
			 }
		 }
		 else {
			 System.out.println("list is empty");
		 }break;

	case(5):
		 System.out.println("-----enter product id-----");
	     productid=sc.nextInt();
	     Product p=pdao.searchbyproductid(productid);
	     System.out.println(p);
	 break;
	case(6):
		 System.out.println("-----enter product name-----");
	    productname=sc.next();
	    Product p2=pdao.searchbyproductname(productname);
	    System.out.println(p2);
		 break;
	case(7):
		 System.out.println("-----enter product category-----");
	productcategory=sc.next();
	 
	 List<Product>productlist1= pdao.showProductCategory(productcategory);
	 if(!productlist1.isEmpty()) {
		 for(Product p1:productlist1) {
			 System.out.println(p1);
		 }
	 }
	 else {
		 System.out.println("list is empty");
	 }break;
}
}
}
