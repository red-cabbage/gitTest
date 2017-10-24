package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import beans.ProductDao;

public class AddProduct extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddProduct() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String img=request.getParameter("img");
		String desc=request.getParameter("desc");
		
		Product product=new Product();
		product.setName(name);
		product.setType(type);
		product.setPrice(Float.parseFloat(price));
		product.setQuantity(Integer.parseInt(quantity));
		product.setDesc(desc);
		product.setImg(img);
		
		String path=request.getContextPath();
		ProductDao pd=new ProductDao();
		int flag=pd.addProduct(product);
		if(flag>0){
			response.sendRedirect(path+"/product_list.jsp");
		}else{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.print("商品添加失败，<a href='javascript:history.back(-1)'>返回重新添加</a>");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
