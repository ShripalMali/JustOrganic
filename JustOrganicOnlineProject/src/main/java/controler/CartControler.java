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

import in.jo.dao.CartDao;
import in.jo.dao.ProductDao;
import in.jo.pojo.Cart;
import in.jo.pojo.Customer;
import in.jo.pojo.Product;

/**
 * Servlet implementation class CartControler
 */
@WebServlet("/cartc")
public class CartControler extends HttpServlet {
	PrintWriter out=null;
	Cart cart=null;
	CartDao cdao=new CartDao();
	HttpSession session=null;
	RequestDispatcher rd=null;
	String action=null;
	  int cartid;
	  String customeremail;
	  int quantity;
	  Product product;
	  boolean result;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 out=response.getWriter();
			response.setContentType("text/html");
			action=request.getParameter("action");
			session=request.getSession();
			String custemail=(String)session.getAttribute("uname");
			if(action!=null&& action.equals("mycart")) {
				
				  List<Cart> cartlist=cdao.showMyCart(custemail);
					session.setAttribute("clist", cartlist);

					rd=request.getRequestDispatcher("/jsp/showcartlist.jsp");
					rd.forward(request, response);
				}
		
			
			if(action!=null&& action.equals("addtocart")) {
				int pid=Integer.parseInt(request.getParameter("pid"));
				product=new Product();
				product.setProductid(pid);
				cart=new Cart(custemail,product);
				result=cdao.addToCart(cart);
				if(result) {
					List<Cart> cartlist=cdao.showMyCart(custemail);
					request.setAttribute("msg", "product added to cart");
					session.setAttribute("clist", cartlist);
					rd=request.getRequestDispatcher("/jsp/ShowProduct.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("msg", "prodcut not added");
					rd=request.getRequestDispatcher("/jsp/showcartlist.jsp");
					rd.forward(request, response);
				}
			}
			if(action!=null && action.equalsIgnoreCase("delete")) {
				cartid=Integer.parseInt(request.getParameter("pid"));
				System.out.println(cartid);
				result=cdao.deleteCart(cartid);
				
				if(result) {
				request.setAttribute("msg", "product deleted Sucessfully");
				List<Cart>cartlist=cdao.showMyCart(custemail);
				session.setAttribute("clist", cartlist);
				rd=request.getRequestDispatcher("/jsp/showcartlist.jsp");
				rd.forward(request, response);
				}
				else {
					request.setAttribute("msg", "product not deleted ");
					List<Cart>cartlist=cdao.showMyCart(custemail);
					rd=request.getRequestDispatcher("/jsp/showcartlist.jsp");
					rd.forward(request, response);
				}
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
