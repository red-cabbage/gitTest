package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import beans.UserDao;

public class LoginServlet2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet2() {
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
		String path = request.getContextPath();
		HttpSession session=request.getSession();
	    UserBean user = new UserBean();
		String name=request.getParameter("name");		
		String pass=request.getParameter("pass");
		user.setName(name);
		user.setPass(pass);
		String num1=request.getParameter("checkNumber"); 
		String num2=(String)session.getAttribute("rnd");
        if(!num1.equals(num2)){
        	response.setCharacterEncoding("utf-8");
        	response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
    		out.println("<HTML>");
    		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
    		out.println("  <BODY>");
    		out.print("验证码输入有误，<a href='javascript:history.back(-1)'>返回重新填写</a>");
       		out.println("  </BODY>");
    		out.println("</HTML>");
    		out.flush();
    		out.close();
        }
		
		UserDao ud = new UserDao();
		if(ud.check_login(user)){
			session.setAttribute("name", user.getName());
			response.sendRedirect(path+"/guanliuser.jsp");
		}
		else{
			response.sendRedirect(path+"/faile.jsp");
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
