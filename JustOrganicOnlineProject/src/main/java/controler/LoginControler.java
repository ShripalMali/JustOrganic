package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.jo.dao.CustromerDao;
import in.jo.dao.LoginDao;
import in.jo.pojo.Customer;

/**
 * Servlet implementation class LofinControler
 */
@WebServlet("/lc")
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

     PrintWriter out=null;
	
	LoginDao ldao=new LoginDao();
	
	HttpSession session=null;
	RequestDispatcher rd=null;
	String action=null;
	boolean result;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();
		action=request.getParameter("action");
	if(session!=null) {
		session.invalidate();
		rd=request.getRequestDispatcher("/jsp/index.jsp");
		rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();
		action=request.getParameter("action");
		String uname,upass,utype;
		if(action!=null && action.equals("login")) {
			uname=request.getParameter("username");
			upass=request.getParameter("userpass");
			utype=request.getParameter("usertype");
			if(utype!=null && utype.equals("admin")) {
				result=ldao.isAdmin(uname, upass);
				if(result) {
					session.setAttribute("utype", utype);
					session.setAttribute("uname", uname);
					rd=request.getRequestDispatcher("/jsp/index.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("msg", "invalid user please try again");
					rd=request.getRequestDispatcher("/jsp/login.jsp");
					rd.forward(request, response);
				}
			}
			
			if(utype!=null && utype.equals("customer")) {
				result=ldao.isCustomer(uname, upass);
				if(result) {
					session.setAttribute("utype", utype);
					session.setAttribute("uname", uname);
					rd=request.getRequestDispatcher("/jsp/index.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("msg", "invalid user please try again");
					rd=request.getRequestDispatcher("/jsp/login.jsp");
					rd.forward(request, response);
				}
			}		
		}
		
		
		
	}

}
