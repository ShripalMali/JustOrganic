package controler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.jo.dao.ProductDao;
import in.jo.pojo.Product;

/**
 * Servlet implementation class ProductImageControler
 */
@MultipartConfig
@WebServlet("/pic")
public class ProductImageControler extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/*");
		int productid=Integer.parseInt(request.getParameter("productid"));
		ProductDao pdao=new  ProductDao();
		Product product=pdao.searchbyproductid(productid);
		if(product!=null){
			InputStream in=product.getProductimage();
			
			OutputStream out=response.getOutputStream();
			int i=0;
			while(i!=-1) {
				i=in.read();
				if(i!=-1) {
					out.write(i);
				}
				
			}
			in.close();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
