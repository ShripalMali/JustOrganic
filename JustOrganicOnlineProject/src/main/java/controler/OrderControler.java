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
import in.jo.dao.OrderDao;
import in.jo.pojo.Cart;
import in.jo.pojo.Order;
import in.jo.pojo.Product;

/**
 * Servlet implementation class OrderControler
 */
@WebServlet("/orderc")
public class OrderControler extends HttpServlet {
	PrintWriter out=null;
	Cart cart=null;
	OrderDao odao=new OrderDao();
	HttpSession session=null;
	RequestDispatcher rd=null;
	String action=null;
	  int cartid;
	  String customeremail;
	  int quantity;
	  Product product=null;
	  Order order=null;
	  boolean result;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		session=request.getSession();
		String custemail=(String)session.getAttribute("uname");
		if(action!=null&& action.equals("placeorder")) {
			order=odao.placeOrder(custemail);
			if(order!=null) {
				session.setAttribute("order", order);

				rd=request.getRequestDispatcher("/jsp/recentorder.jsp");
				rd.forward(request, response);
			}
		}
		
		else {
			List<Order> orderlist=odao.showMyOrders(custemail);
			session.setAttribute("orderlist", orderlist);
			rd=request.getRequestDispatcher("/jsp/myorderss.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
