package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.jo.dao.CustromerDao;
import in.jo.dao.ProductDao;
import in.jo.pojo.Customer;
import in.jo.pojo.Product;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/cr")
public class CustomerRegister extends HttpServlet {
	PrintWriter out=null;
	
	Customer customer=null;
	CustromerDao cdao=new CustromerDao();
	
	HttpSession session=null;
	RequestDispatcher rd=null;
	String action=null;
	 int customerid;
	 String customername;
	 String customeremail;
	 String customercontact;
	 String customeraddress;
	 String customerpass;
     boolean result;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		session=request.getSession();

		if(action!=null && action.equalsIgnoreCase("delete")) {
		customerid=Integer.parseInt(request.getParameter("cid"));
		System.out.println(customerid);
		result=cdao.deleteCustomer(customerid);
		
		if(result) {
		request.setAttribute("msg", "Customer deleted Sucessfully");
		List<Customer>customerlist=cdao.showCustomerList();
		session.setAttribute("clist", customerlist);
		rd=request.getRequestDispatcher("/jsp/showcustomer.jsp");
		rd.forward(request, response);
		}
		}
		
		if(action!=null && action.equalsIgnoreCase("edit")) {
			customerid=Integer.parseInt(request.getParameter("cid"));
			System.out.println(customerid);
			customer=cdao.searchCustomerid(customerid);
			session.setAttribute("customer", customer);
			rd=request.getRequestDispatcher("/jsp/UpdateCustomer.jsp");
			rd.forward(request, response);
		}
		else {
		List<Customer>customerlist=cdao.showCustomerList();
		session.setAttribute("clist", customerlist);
		rd=request.getRequestDispatcher("/jsp/showcustomer.jsp");
		rd.forward(request, response);
		}

		}
	
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("addCustomer")) {
			System.out.println("inside add post methods");
			customername=request.getParameter("customername");
			customeremail=request.getParameter("customeremail");
			customercontact=request.getParameter("customercontact");
			customeraddress=request.getParameter("customeraddress");
			customerpass=request.getParameter("customerpass");
			customer=new Customer( customername,  customeremail,  customercontact,  customeraddress,customerpass);
			System.out.println("customer"+customer);
			result=cdao.addCustomer(customer);
			if(result) {
				request.setAttribute("msg","Register Successfully");
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				
			rd.forward(request, response);
			
			}
			else {
				request.setAttribute("msg","customer not  added");
				rd=request.getRequestDispatcher("/jsp/addCustomer.jsp");
				
			rd.forward(request, response);
			}
		}
	
		if(action!=null && action.equalsIgnoreCase("updateCustomer")) {
			System.out.println("inside update post methods");
			customerid=Integer.parseInt(request.getParameter("customerid"));
			customername=request.getParameter("customername");
			customeremail=request.getParameter("customeremail");
			customercontact=request.getParameter("customercontact");
			customeraddress=request.getParameter("customeraddress");
			customerpass=request.getParameter("customerpass");
			customer=new Customer(customerid, customername,  customeremail,  customercontact,  customeraddress,customerpass);
			System.out.println("customer"+customer);
			result=cdao.updateCustomer(customer);
			if(result) {
				request.setAttribute("msg","update Successfully");
				List<Customer>customerlist=cdao.showCustomerList();
				session.setAttribute("clist", customerlist);
				rd=request.getRequestDispatcher("/jsp/showcustomer.jsp");
				rd.forward(request, response);
			
			}
			else {
				request.setAttribute("msg","customer not  updated");
				rd=request.getRequestDispatcher("/jsp/showcustomer.jsp");
				
			rd.forward(request, response);
			}
		}
	
	
	
	}
	
	
	
	
	
	
	

}
