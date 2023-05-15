package controler;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.jo.dao.ProductDao;
import in.jo.pojo.Product;


@MultipartConfig
@WebServlet("/pc")
public class ProductControler extends HttpServlet {
	
	PrintWriter out=null;
	Product product=null;
	ProductDao pdao=new ProductDao();
	HttpSession session=null;
	RequestDispatcher rd=null;
	String action=null;
	 int productid;
	  String productname;
	 String productcategory;
	 double productweight;
	 double productprice;
	 InputStream productimage;
     boolean result;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		session=request.getSession();
		if(action!=null && action.equalsIgnoreCase("deleteProduct")) {
			productid=Integer.parseInt(request.getParameter("pid"));
			System.out.println(productid);
			result=pdao.deleteProduct(productid);
			if(result){
				request.setAttribute("msg","product deleted");
				List<Product> productlist=pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd=request.getRequestDispatcher("/jsp/ShowProduct.jsp");
				rd.forward(request, response);
			}}
		
		if(action!=null && action.equalsIgnoreCase("edit")) {
			productid=Integer.parseInt(request.getParameter("pid"));
			System.out.println(productid);
			product=pdao.searchbyproductid(productid);
			session.setAttribute("product", product);
			List<Product> productlist=pdao.showProductList();
			session.setAttribute("plist", productlist);
			rd=request.getRequestDispatcher("/jsp/updateproduct.jsp");
			rd.forward(request, response);
			
		}
		if(action!=null && action.equalsIgnoreCase("search")) {
			productcategory=request.getParameter("ptype");
			System.out.println(productcategory);
			List<Product> productlist=pdao.showProductCategory(productcategory);
			session.setAttribute("plist", productlist);
			rd=request.getRequestDispatcher("/jsp/ShowProduct.jsp");
			rd.forward(request, response);
		}
		
		
			else {
				List<Product> productlist=pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd=request.getRequestDispatcher("/jsp/ShowProduct.jsp");
				rd.forward(request, response);
			}
		}	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();

		action=request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("addproduct")) {
			System.out.println("inside add post methods");
			productname=request.getParameter("productname");
			productcategory=request.getParameter("producttype");
			productweight=Double.parseDouble(request.getParameter("productweight"));
			productprice=Double.parseDouble(request.getParameter("productprice"));
			Part part=request.getPart("productimage");
			productimage=part.getInputStream();
			product=new Product(productname,productcategory,productweight,productprice,productimage);
			System.out.println("product"+product);
			result=pdao.addProduct(product);
			if(result) {
				request.setAttribute("msg","product added");
				//List<Product> productlist=pdao.showProductList();
				//session.setAttribute("plist", productlist);
				rd=request.getRequestDispatcher("/jsp/addProduct.jsp");
				rd.forward(request, response);
			
			}
			else {
				request.setAttribute("msg","product not  added");
				rd=request.getRequestDispatcher("/jsp/addProduct.jsp");	
			rd.forward(request, response);
			}
		}
		
		if(action!=null && action.equalsIgnoreCase("updateproduct")) {
			System.out.println("inside update post methods");
			productid=Integer.parseInt(request.getParameter("productid"));
			productname=request.getParameter("productname");
			productcategory=request.getParameter("producttype");
			productweight=Double.parseDouble(request.getParameter("productweight"));
			productprice=Double.parseDouble(request.getParameter("productprice"));
			Part part=request.getPart("productimage");
			productimage=part.getInputStream();
			product=new Product(productid,productname,productcategory,productweight,productprice,productimage);
			System.out.println("product"+product);
			result=pdao.updateProduct(product);
			if(result) {
				request.setAttribute("msg","product updated");
				List<Product> productlist=pdao.showProductList();
				session.setAttribute("plist", productlist);
				rd=request.getRequestDispatcher("/jsp/ShowProduct.jsp");
				rd.forward(request, response);
				
			
			}
			else {
				request.setAttribute("msg","product not  updated");
				rd=request.getRequestDispatcher("/jsp/updateproduct.jsp");
				
			  rd.forward(request, response);
			}
		}
	}

}
