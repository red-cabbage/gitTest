package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
public class DoReg extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoReg() {
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
        //����request������ַ�������ȡrequest�е�����
		request.setCharacterEncoding("utf-8");
	    String name = request.getParameter("name");
	    String pass = request.getParameter("pass");
        String pass2 = request.getParameter("pass2");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        
        //�ж������ȷ�������Ƿ�һ��,�����д���
        if(!pass.equals(pass2)){
        	response.setCharacterEncoding("utf-8");
        	response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
    		out.println("<HTML>");
    		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
    		out.println("  <BODY>");
    		out.print("������ȷ�����벻һ�£�<a href='javascript:history.back(-1)'>��������ע��</a>");
       		out.println("  </BODY>");
    		out.println("</HTML>");
    		out.flush();
    		out.close();
        }
        
        else{
    		//��������Bean���󣬲�������ֵ
        	UserBean user = new UserBean();
        	user.setName(name);
        	user.setPass(pass);
        	user.setEmail(email);
        	user.setAddress(address);
        	user.setTel(tel);
        	//����ҵ��Bean���󣬵�����֤�û����ķ���,���ݷ���������д��� 
        	String path = request.getContextPath();//��ȡ���̸�·��
        	HttpSession session = request.getSession();//��ȡsession
        	UserDao ud = new UserDao();
        	int flag=ud.regUser(user);
        	if(flag>0){
        		session.setAttribute("name", user.getName());
        		response.sendRedirect(path+"/index.jsp");
        	}else{
        		response.sendRedirect(path+"/faile.jsp");
        	}
        	
        	
        	
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
